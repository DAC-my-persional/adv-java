package com.sunbeam.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.User;
import com.sunbeam.service.BlogPostService;
import com.sunbeam.service.CategoryService;

@Controller
@RequestMapping("/blogger")
public class BloggerController {
	// depcy
	@Autowired
	private BlogPostService blogPostService;
	
	@Autowired
	private CategoryService categoryService;

	public BloggerController() {
		System.out.println("in ctor " + getClass());
	}

	// add req handling method
	// URL - http://host:port/ctx_path/blogger/home , method - GET
	@GetMapping("/home")
	public String renderHomePage(Model map) {
		System.out.println("in blogger hm page");
		map.addAttribute("posts", blogPostService.getAllPosts());
		return "/blogger/home";
	}
	// add req handling method , to delete a blog post along with the comments
	// URL - http://host:port/ctx_path/blogger/delete_post?postId=... , 
	//method - GET
	@GetMapping("/delete_post")
	public String deleteBlogPost(@RequestParam Long postId,
			HttpSession session) {
		System.out.println("in delete blog post "+postId);
		 session.setAttribute("message",blogPostService.deleteBlogPost(postId));
		//redirect the blogger to home page
		 return "redirect:/blogger/home";
	}
	
	// add a method to show form to create a new blog
		@GetMapping("/new_blog")
		public String showFormNewBlog(Model map, BlogPost post) {
			map.addAttribute("all_categories", categoryService.getAllCategories());
			return "/blogger/new_blog";
		}

		// add a method to process form to create a new blog
		@PostMapping("/new_blog")
		public String processFormNewBlog(RedirectAttributes flashMap,
				BlogPost post, HttpSession session) {
			System.out.println(post);
			System.out.println(post.getSelectedCategory());
			User author = (User) session.getAttribute("user_details");
			post.setBlogger(author);
			flashMap.addFlashAttribute("message", blogPostService.addNewPost(post));
			return "redirect:/blogger/home";
		}

		// add a method to show form for update blog contents
		// http:host:port/ctx/blogger/update_post?id=blogId
		@GetMapping("/update_post")
		public String showUpdateForm(@RequestParam Long id, Model map) {
			System.out.println("in update form " + id);
			map.addAttribute("blog", blogPostService.getBlogDetails(id));
			return "/blogger/update_blog";
		}

		// add a method to update blog contents
		// http:host:port/ctx/blogger/update_post?id=blogId
		@PostMapping("/update_post")
		public String processUpdateForm(@RequestParam Long id, 
				@RequestParam String content,RedirectAttributes flashMap) {
			System.out.println("in process update form " + id+" content");
			flashMap.addFlashAttribute("mesg", blogPostService.updateBlogContents(id,content));
			return "redirect:/blogger/home";
		}
		
	

}
