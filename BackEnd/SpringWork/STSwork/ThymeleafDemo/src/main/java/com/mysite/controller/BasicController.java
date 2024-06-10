package com.mysite.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/basic")
public class BasicController {
	
	@GetMapping("/text-basic")
	public String textBasic(Model model) {
		model.addAttribute("data1", "Hello Spring");
		model.addAttribute("data2", "<b>Hello Spring</b>");
		return "basic/text-basic";
	}
	
	@GetMapping("/variable")
	public String variable(Model model) {
		User userA = new User("userA", 25);
		User userB = new User("userB", 21);
		
		List<User> list = new ArrayList<>(Arrays.asList(userA, userB));
		
		Map<String, User> map = new HashMap<>();
		map.put("a", userA);
		map.put("b", userB);
		
		model.addAttribute("list", list);
		model.addAttribute("map", map);
		
		return "basic/variable";
	}

	static class User {
		private String userName;
		private int age;
		
		public User(String userName, int age) {
			this.userName = userName;
			this.age = age;
		}
			
		public String getUserName() {
			return userName;
		}
		
		public int getAge() {
			return age;
		}
		
	}
	
	@GetMapping("/basic-objects")
	public String basicObjects(HttpServletRequest req, HttpSession session) {
		req.setAttribute("userName", "jiwon");
		session.setAttribute("sessionData", "Hello Session");
		return "basic/basic-objects";
	}
	
	@Component("helloBean")
	static class HelloBean {
		public String hello(String data) {
			return "Hello! " + data;
		}
	}
	
	@GetMapping("/date")
	public String date(Model model) {
		model.addAttribute("localDateTime", LocalDateTime.now());
		return "basic/date";
	}
	
	@GetMapping("/link")
	public String link(Model model) {
		model.addAttribute("path1", "board");
		model.addAttribute("path2", "write");
		
		model.addAttribute("param1", "data1");
		model.addAttribute("param2", "data2");
		
		return "basic/link";
	}
	
	@GetMapping("/literal")
	public String literal(Model model) {
		model.addAttribute("data", "Hello");
		return "basic/literal";
	}
	
	@GetMapping("/operation")
	public String operation(Model model) {
		model.addAttribute("nullData", null);
		model.addAttribute("data", "Hello~~Spring");
		return "basic/operation";
	}
	
	@GetMapping("/attribute")
	public String attribute(Model model) {
		return "basic/attribute";
	}
	
	@GetMapping("/each")
	public String each(Model model) {
		addUsers(model);
		return "basic/each";
	}
	
	private void addUsers(Model model) {
		List<User> users = Arrays.asList(new User("userA", 10), new User("userB", 20), new User("userC", 30));
		
		model.addAttribute(users);
	}
	
	@GetMapping("/condition")
	public String condition(Model model) {
		addUsers(model);
		return "basic/condition";
	}
	
	@GetMapping("/comments")
	public String comments(Model model) {
		model.addAttribute("data", "Hello~~ Spring");
		return "basic/comments";
	}
	
	@GetMapping("/block")
	public String block(Model model) {
		addUsers(model);
		return "basic/block";
	}
	
	@GetMapping("/javascript")
	public String javascript(Model model) {
		model.addAttribute("user", new User("홍길동", 20));
		addUsers(model);
		return "basic/javascript";
	}
}
