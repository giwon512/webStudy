package com.mysite;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialController {
	
	@GetMapping("/factorial")
	public Long factorial(@RequestParam(value="num") long num) {
		long answer = 1;
		while(num > 0) {
			answer *= num;
			num--;
		}
		
		return answer;
	}
}
