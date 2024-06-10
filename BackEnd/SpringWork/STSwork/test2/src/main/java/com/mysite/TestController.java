package com.mysite;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@ResponseBody
	@GetMapping("/greeting")
	public String greeting(@RequestParam(value="name") String name) {
		String str = "Hello, " + name + "!";
		return str;
	}
}
