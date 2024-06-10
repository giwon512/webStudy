package com.mysite.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mysite.domain.Member;
import com.mysite.domain.RegisterRequest;
import com.mysite.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String loginOk(String id, String pwd, HttpServletRequest req) throws UnsupportedEncodingException {
		String msg = URLEncoder.encode("id 또는 password가 일치하지 않습니다.", "utf-8");
		try {
			Member member = memberService.selectWithPass(id, pwd);
			
			HttpSession session = req.getSession();
			session.setAttribute("id", member.getEmail());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "redirect:/member/login?msg=" + msg;
		}
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/add")
	public ModelAndView step1() {
		return new ModelAndView("member/step1");
	}
	
	@PostMapping("/step2")
	public ModelAndView step2(@RequestParam(value="agree", defaultValue="false") boolean agree) {
		if(!agree) {
			return new ModelAndView("member/step1");
		}
		return new ModelAndView("member/step2");
	}
	
	@PostMapping("/step3")
	public ModelAndView step3(RegisterRequest dto, HttpServletRequest req) throws Exception {
		if(dto.isPasswordEqualToPasswordConfirm()) {
			memberService.registerMember(dto);
			req.getSession().setAttribute("id", dto.getEmail());
		}
		else {
			return new ModelAndView("member/step2");
		}
		return new ModelAndView("member/step3");
	}
}
