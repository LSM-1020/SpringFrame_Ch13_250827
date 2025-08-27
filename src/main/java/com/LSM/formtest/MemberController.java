package com.LSM.formtest;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

	@RequestMapping(value ="/login") 
		public String login(HttpServletRequest request, Model model) {
		return "login";
	}
	@RequestMapping(value ="/login2") 
	public String login2(HttpServletRequest request, Model model) {
	return "login2";
}
	@RequestMapping(value ="/loginOk") 
	public String loginOk(HttpServletRequest request, Model model, HttpSession session, HttpServletResponse response) {
		String mid = request.getParameter("mid"); //login.jsp에서 클라이언트가 입력한 값 불러오기 그리고 선언
		String mpw = request.getParameter("mpw");
		model.addAttribute("mid",mid); //model로 String mid를 실어서 loginOk로 보내줌 = request.setAttribute
		model.addAttribute("mpw",mpw);
		
		if(mid.equals("tiger") && mpw.equals("12345")) {
			session.setAttribute("sessionId", mid);//세션에 로그인한 아이디 올려두기
			return "loginOk";
		}else {
			return "loginFail";
		}
	}
		@RequestMapping(value ="/loginOk2") //1~2개정도 넘어올때 매소드에서 바로 param으로 선언
		public String loginOk2(@RequestParam("mid") String mid, @RequestParam("mpw") String mpw, Model model, HttpSession session, HttpServletResponse response) {
			//String mid = request.getParameter("mid"); //login.jsp에서 클라이언트가 입력한 값 불러오기 그리고 선언
			//String mpw = request.getParameter("mpw");
			
			model.addAttribute("mid",mid); //model로 String mid를 실어서 loginOk로 보내줌 = request.setAttribute
			model.addAttribute("mpw",mpw);
			
			if(mid.equals("tiger") && mpw.equals("12345")) {
				session.setAttribute("sessionId", mid);//세션에 로그인한 아이디 올려두기
				return "loginOk";
			}else {
				return "loginFail";
			}	
	
}
}
