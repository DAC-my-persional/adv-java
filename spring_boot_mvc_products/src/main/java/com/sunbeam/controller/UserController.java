package com.sunbeam.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.entities.Role;
import com.sunbeam.entities.User;
import com.sunbeam.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	// depcy
	@Autowired
	private UserService userService;

	public UserController() {
		System.out.println("in ctor " + getClass());
	}

	// URL - http://host:port/ctx_path/user/login , method=GET
	@GetMapping("/login")
	public String renderLoginForm() {
		System.out.println("in render login form");
		return "/user/login";// AVN - /WEB-INF/views/user/login.jsp
	}

	// URL - http://host:port/ctx_path/user/login , method=POST
	@PostMapping("/login") // =@RequestMapping(method=POST)
	public String processLoginForm(@RequestParam String em, 
			@RequestParam String pass, Model map, HttpSession session) {
		// read req params
		try {
			// invoke service method
			User user = userService.authenticateUser(em, pass);
			// in case of success -
			// chk the role -- in case of blogger -> forward -> user to blogger's home
			// display blogger's details (Hello blogger name)
			// add user details under session scope
			session.setAttribute("user_details", user);
			if (user.getRole() == Role.BLOGGER)
				return "redirect:/blogger/home";
			/*
			 * Handler rets redirect view name -> D.S D.S -> sends redirect resp (SC
			 * 302|Location:/blogger/home body - EMPTY) clnt browser sends a NEW redirect
			 * request -> http://host:port/ctx_path/blogger/home -> has to be handled by the
			 * BloggerController
			 */
			if (user.getRole() == Role.ADMIN)
				return "/admin/home";// AVN - /WEB-INF/views/blogger/home.jsp
			return "/commenter/home";
		} catch (RuntimeException e) {
			System.out.println(e);
			// in case of login failure -- forward user to login page again ,
			// highlighted with err mesg
			// add model attribute - for err mesg
			map.addAttribute("message", e.getMessage());
			return "/user/login";
		}
	}

	// user logout
	// http://host:port/ctx/user/logout , method = GET
	@GetMapping("/logout")
	public String logout(HttpSession session,Model map) {
		System.out.println("in logout");
		//save user details under model map
		map.addAttribute("details", session.getAttribute("user_details"));
		// invalidate session
		session.invalidate();
		//forward to logout page
		return "/user/logout";
	}

}
