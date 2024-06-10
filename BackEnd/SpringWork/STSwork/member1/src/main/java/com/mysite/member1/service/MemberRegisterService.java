package com.mysite.member1.service;

import java.util.Collection;
import java.util.Date;

import com.mysite.member1.model.Member;
import com.mysite.member1.model.RegisterRequest;
import com.mysite.member1.repository.MemberDao;

public class MemberRegisterService {
	private MemberDao memberDao = new MemberDao();
	
	public void register(RegisterRequest req) {
		// 같은 이메일 주소가 있는지 검사
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			System.out.println("같은 이메일 주소가 있습니다.");
			return;
		}
		
		// 입력한 패스워드와 패스워드 확인이 일치하는지 확인
		if(!req.getPassword().equals(req.getPasswordConfirm())) {
			System.out.println("패스워드를 잘못 입력하였습니다.");
			return;
		}
		
		Member newMem = new Member(req.getName(), req.getEmail(), req.getPassword(), new Date());
		memberDao.insert(newMem);
		
	}
	
}
