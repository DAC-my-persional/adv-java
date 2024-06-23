package com.sunbeam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//annotation
@Controller //mandatory cls level annotation to specify this is a spring bean 
//containing req handling logic
//singleton n eager
public class HomePageController {
//def ctor : print
	public HomePageController() {
		System.out.println("in ctor - "+getClass());
	}
	//add req handling method with anno.
	//HandlerMapping 
	//key - /
	//value - com.sunbeam.controller.HomePageController.renderHomePage
	@RequestMapping("/")
	public String renderHomePage( ) {
		System.out.println("in render home page");
		return "/index";	 //Handler rets LVN -> 
		//D.S -> V.R -> AVN (/WEB-INF/views/index.jsp)	-> D.S forward
		//the clnt to the view layer(JSP)
	}
	
}
