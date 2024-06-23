package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.service.BlogPostService;

@Controller
@RequestMapping("/posts")
public class BlogPostController {
	// depcy - service layer i/f
	@Autowired
	private BlogPostService blogPostService;

	public BlogPostController() {
		System.out.println("in ctor " + getClass());
	}

	// URL -http://host:port/ctx_path/posts/view?categoryName=category-1
	// Method - GET
	@GetMapping("/view")
	public String getBlogPostsByCategory(@RequestParam 
			String categoryName,Model modelAttributeMap)
	{
		System.out.println("in get blog posts "+categoryName);
		//invoke service method 
		modelAttributeMap.addAttribute("blog_list",
				blogPostService.getPostsByCategoryName(categoryName));
		return "/posts/view";//AVN - /WEB-INF/views/posts/view.jsp
				
	}

}
