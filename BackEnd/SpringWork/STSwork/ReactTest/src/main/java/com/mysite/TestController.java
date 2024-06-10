package com.mysite;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@RequestMapping("/api/employees")
public class TestController {
	
	@GetMapping("/test")
	public String test() {
		return "<html><body>이것은 테스트 입니다.</body><html>";
	}
	
	@GetMapping("/test2")
	public LoginDTO test2() {
		LoginDTO login = new LoginDTO("hong", "1234");
		return login;
	}
	
	@GetMapping("/test3")
	public ArrayList<LoginDTO> test3() {
		ArrayList<LoginDTO> list = new ArrayList<>();
		list.add(new LoginDTO("hong", "1111"));
		list.add(new LoginDTO("lee", "2222"));
		return list;
	}
	
	@GetMapping("/test4")
	public HashMap<String, LoginDTO> test4() {
		HashMap<String, LoginDTO> list = new HashMap<>();
		list.put("1", new LoginDTO("hong", "1111"));
		list.put("2", new LoginDTO("lee", "2222"));
		return list;
	}
	
	@PostMapping("/test5")
	public String test5(@RequestBody LoginDTO login) {
		String info = login.getId() + ", " + login.getPw();
		return info;
	}
	
	@Data
	static class LoginDTO {
		private String id;
		
		//@JsonIgnore
		private String pw;
		
		public LoginDTO() {}
		
		public LoginDTO(String id, String pw) {
			this.id = id;
			this.pw = pw;
		}
	}
}
