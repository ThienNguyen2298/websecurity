package com.example.controller;

import java.io.IOException;

import java.text.ParseException;



import java.util.List;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.*;
import com.example.service.CategoryNewsService;
import com.example.service.CommentsService;
import com.example.service.NewsDetailsService;
import com.example.service.NewsService;
import com.example.service.UserService;

@Controller
public class HomeController {
	@Autowired
	private CategoryNewsService categoryNewsService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private NewsDetailsService newsDetailsService;
	@Autowired
	private UserService userService;
	@Autowired
	private CommentsService commentsService;
	//Mới vô trang chủ.
	@GetMapping("/")
	public String home(HttpSession session ,ModelMap model) throws IOException
	{
		session.setAttribute("user", session.getAttribute("user"));
		model.put("catenews", categoryNewsService.findAll());
		model.put("newss", newsService.findAll());
		return "home";
	}
	//Xem theo danh mục
	@GetMapping("/category/{id}") 
	public String Category(HttpSession session, @PathVariable int id, ModelMap model) throws IOException
	{
		List<News> lstnews = newsService.findAllByCategoryNewsId(id);
		session.setAttribute("user", session.getAttribute("user"));
		model.put("catenews", categoryNewsService.findAll());
		model.put("newss", lstnews);
		return "category";
	}
	//Xem chi tiết một tin tức.
	@GetMapping("/home/viewdetail/{id}")
	public String viewdetail(HttpSession session, @PathVariable int id, ModelMap model)
	{
		NewsDetails nDetails = newsDetailsService.findNewsDetailsByIdNews(id);
		List<Comments> list = commentsService.findAllCommentsByNewsDetails(nDetails.getId()); 
		model.put("newsdetails", nDetails);
		model.put("catenews", categoryNewsService.findAll());
		model.put("lstcmt", list);
		session.setAttribute("user", session.getAttribute("user"));
		return "viewdetail";
	}
	//Chuyển trang đăng nhập.
	@GetMapping("/home/login")
	public String getFormLogin(ModelMap model) throws Exception{
		
		model.put("outputUser", new Account());
		return "login";
	}
	//Xử lý đăng nhập.
	@PostMapping("/home/login")
	public String login(@ModelAttribute(name="outputUser") Account user,HttpSession session, ModelMap model)
	{
		String gmail=user.getGmail();
		String pwd=user.getPwd();
		User user2 = userService.login(gmail, pwd);
		if(user2!=null)
		{
			model.put("catenews", categoryNewsService.findAll());
			model.put("newss", newsService.findAll());
			session.setAttribute("user", user2);
			return "home";
			
		}
		else {
			model.put("message", "Login Failed");
			return "login";
		}
		
	}
	//Đăng xuất
	@GetMapping("/home/logout")
	public String logout(HttpSession session ,ModelMap model)
	{
		session.removeAttribute("user");
		return "redirect:/";
	}
	//Redirect đến Trang quản lý tin tức của User hiện tại.
	@GetMapping("/home/newsmanagement")
	public String newsmanagement(HttpSession session, ModelMap model)
	{
		User user = (User)session.getAttribute("user");
		model.put("newsbyauthor", newsService.findAllByAuthor(user.getId()));
		session.setAttribute("user", session.getAttribute("user"));
		return "newsmanagement";
	}
	//Tạo một tin tức.
	@GetMapping("/news/create")
	public String create(HttpSession session, ModelMap model) {
		model.put("lstcatenews", categoryNewsService.findAll());
		model.addAttribute("news", new News());
		session.setAttribute("user", session.getAttribute("user"));
		return "form";
	}
	@PostMapping("/news/save")
	public String save(HttpSession session, @RequestParam("name") String name, @RequestParam("postday") String postday,
			@RequestParam("image") String image, @RequestParam("categoryNews") int categoryNews, 
			@RequestParam("content") String content, RedirectAttributes redirect) throws ParseException
	{
		//Thêm News mới
		User user = (User)session.getAttribute("user");
		News news = new News();
		news.setName(name);
		news.setImage(image);
		news.setPostday(postday);
		news.setCategoryNews(categoryNewsService.findOne(categoryNews));
		news.setAuthor(user);
		newsService.saveNews(news);
		//
		
		NewsDetails newsdetails = new NewsDetails();
		newsdetails.setContent(content);
		newsdetails.setNews(news);
		newsDetailsService.save(newsdetails);
		redirect.addFlashAttribute("success", "Saved employee successfully!");
		return "redirect:/home/newsmanagement";
	}
	@GetMapping("/news/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		newsService.deleteNews(id);
		redirect.addFlashAttribute("success", "Deleted employee successfully!");
		return "redirect:/home/newsmanagement";
	}
	@GetMapping("/news/{id}/edit")
	public String edit(@PathVariable int id,HttpSession session, ModelMap model) {
		model.put("news", newsService.findOne(id));
		session.setAttribute("user", session.getAttribute("user"));
		model.put("lstcatenews", categoryNewsService.findAll());
		
		NewsDetails details = newsDetailsService.findNewsDetailsByIdNews(id);
		
			
		model.put("content", details.getContent());
		return "edit";
		
		
	}
	@PostMapping("/news/update")
	public String update(HttpSession session, @Valid News news,
			@RequestParam("content") String content, RedirectAttributes redirect, ModelMap model)
	{
		
		User user = (User)session.getAttribute("user");
		//News news = new News();
		
		NewsDetails details=newsDetailsService.findNewsDetailsByIdNews(news.getId());
		details.setContent(content);
		details.setNews(news);
		newsDetailsService.save(details);
		//
		News n =newsService.findOne(news.getId());
		n.setName(news.getName());
		n.setPostday(news.getPostday());
		n.setCategoryNews(news.getCategoryNews());
		n.setAuthor(user);
		//
		newsService.saveNews(n);
		
		redirect.addFlashAttribute("success", "Updated employee successfully!");
		return "redirect:/home/newsmanagement";
		
	}
	//Comment đơn giản.
	@PostMapping("viewdetail/comment/{id}")
	public String comment(@PathVariable int id,@RequestParam("name") String name,
			@RequestParam("content") String content,ModelMap model) {
		Comments cmt =new Comments();
		cmt.setId(0);
		cmt.setUsercmt(name);
		cmt.setContent(content);
		cmt.setNewsDetails(newsDetailsService.findOne(id));
		commentsService.save(cmt);
		return "redirect:/home/viewdetail/"+id;
	}
	
	
}
