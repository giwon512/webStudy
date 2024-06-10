package com.mysite;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Value("${myapp.message}")
	private String msg;
	
	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		return msg;
	}
}
