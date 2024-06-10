package com.mysite.member1;

import com.mysite.member1.repository.MemberDao;
import com.mysite.member1.service.ChangePasswordService;
import com.mysite.member1.service.MemberRegisterService;

public class Factory {
	private static Factory factory;
	
	private MemberRegisterService regSvc = new MemberRegisterService();
	private ChangePasswordService changePwdSvc = new ChangePasswordService();
	private MemberDao memberDao = new MemberDao();
	
	private Factory() {}
	
	public static Factory instanceOf() {
		if(factory == null) {
			factory = new Factory();
		}
		return factory;
	}
	
	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}
	
	public ChangePasswordService getChangePasswordService() {
		return changePwdSvc;
	}
	
	public MemberDao getMemberDao() {
		return memberDao;
	}
}
