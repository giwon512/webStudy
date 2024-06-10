package com.mysite.member1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysite.member1.model.Member;
import com.mysite.member1.model.RegisterRequest;
import com.mysite.member1.service.ChangePasswordService;
import com.mysite.member1.service.MemberRegisterService;

/**
 * exit 종료
 * new 이메일 이름 암호 암호확인
 * change 이메일 현재암호 바꿀암호
 * list 회원 정보 출력
 */
public class App {
	private static ApplicationContext ctx;
	
    public static void main( String[] args ) throws IOException{
    	ctx = new ClassPathXmlApplicationContext("config/application_context_config.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        App app = new App();
        String command = null;
        
        while(true) {
			System.out.println( "명령어를 입력하세요 : " );
			command = br.readLine();
	        String[] cmd = command.split(" ");
	        
	        if(cmd[0].equalsIgnoreCase("exit")) {
	        	System.out.println("프로그램을 종료합니다.");
	        	break;
	        }
	        else if(cmd[0].equals("new")) {
	        	app.newCommand(cmd);
	        }
	        else if(cmd[0].equals("change")) {
	        	app.changeCommand(cmd);
	        }
	        else if(cmd[0].equals("list")) {
	        	app.listCommand();
	        }
        } // end while
    } // end main
    
    public void newCommand(String[] cmd) {
    	RegisterRequest req = new RegisterRequest();
    	req.setEmail(cmd[1]);
    	req.setName(cmd[2]);
    	req.setPassword(cmd[3]);
    	req.setPasswordConfirm(cmd[4]);
    	
    	MemberRegisterService regSvc = ctx.getBean("regSvc", MemberRegisterService.class);
    	regSvc.register(req);
    }
    
    public void changeCommand(String[] cmd) {
    	ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);
    	changePwdSvc.changePassword(cmd[1], cmd[2], cmd[3]);
    	System.out.println("암호를 변경하였습니다.");
    }
    
    public void listCommand() {
    	MemberRegisterService regSvc = ctx.getBean("regSvc", MemberRegisterService.class);
    	Collection<Member> list = regSvc.selectAll();
		for(Member mem : list) {
			System.out.println(mem.getEmail() + ", " + mem.getName() + ", " + mem.getPassword() + ", " + mem.getRegisterDate());
		}
    }
}
