package com.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.domain.Member;
import com.mysite.domain.RegisterRequest;
import com.mysite.repository.MemberDao;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public void registerMember(RegisterRequest dto) throws Exception {
		// TODO Auto-generated method stub
		memberDao.registerMember(dto);
	}

	@Override
	public Member selectMember(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectWithPass(String email, String pw) throws Exception {
		// TODO Auto-generated method stub
		return memberDao.selectWithPass(email, pw);
	}

}
