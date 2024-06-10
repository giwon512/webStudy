package com.mysite.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "*", methods = RequestMethod.GET)
public class DataController {
	
	@ResponseBody
	@GetMapping("/data/test1")
	public String getTest1() {
		String data = "{\"name\":\"John\", \"age\":30}";
		return data;
	}
	
	static class User{
		private Long id;
		private String name;
		private int age;
		
		public User(Long id, String name, int age) {
			this.id = id;
			this.name = name;
			this.age = age;
		}
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
	}
	
	@ResponseBody
	@GetMapping("/data/users")
	public List<User> getAllUsers() {
		ArrayList<User> userList = new ArrayList<>();
		userList.add(new User(1L, "John", 25));
		userList.add(new User(2L, "Alice", 20));
		userList.add(new User(3L, "Bob", 22));
		
		return userList;
	}
}
