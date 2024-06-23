package com.sunbeam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {
	public TestController() {
		System.out.println("in ctor " + getClass());
	}

	// add req handling method for testing model map n req params
	@GetMapping("/multiply") // =@RequestMapping(method=GET)
	public String multiplyNos(Model modelMap, 
			@RequestParam int num1, @RequestParam int num2)
	/*
	 * @RequestParam - method arg level annotation,
	 *  It's for binding (n parsing)
	 * incoming request param -> method argument
	 * int num1=Integer.parseInt(request.getParameter("num1"));
	 * Match req param name with method arg name
	 */
	{
		// o.s.ui.Model - i/f , represents a holder of model attributes.
		System.out.println("in multiply " + modelMap+" "+num1+" "+num2);// empty map
		//store the result in model map
		modelMap.addAttribute("multiply_result", num1*num2);
		return "/test/result";// AVN : /WEB-INF/views/test/result.jsp
		/*
		 * Handler rets LVN (explicitly) n model map implicitly -> D.S
		 * D.S -> LVN -> V.R -> AVN 
		 * D.S adds model attributes from the model map , under request scope
		 * n forwards the clnt to JSP
		 */
	}

}
