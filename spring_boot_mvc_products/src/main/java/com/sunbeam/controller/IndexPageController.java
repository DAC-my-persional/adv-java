package com.sunbeam.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexPageController {
	public IndexPageController() {
		System.out.println("in ctor "+getClass());
	}
	//http://host:port/ctx_path/
	@GetMapping("/")
	public String renderIndexPage(Model map)
	{
		System.out.println("in render index page "+map);
		map.addAttribute("ts",LocalDateTime.now());
		return "/index";//AVN - /WEB-INF/views/index.jsp
	}

}
