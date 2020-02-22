package com.example01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping(value = "/")
	public String goIndex() {
		System.out.println("인덱스");
		return "index";
	}
	
	@RequestMapping(value = "/main")
	public String goMain(HttpServletRequest request) {
		System.out.println("메인페이지");
		return "main";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String goSignup() {
		System.out.println("회원가입 페이지");
		return "member/signup";
	}
	
	@RequestMapping(value = "/insertMember", method = RequestMethod.POST)
	public String insertMember(HttpServletRequest request) {
		System.out.println("회원 정보 저장");
		
		String memberId = request.getParameter("memberId");
		String memberPassword = request.getParameter("memberPassword");
		String memberName = request.getParameter("memberName");
		
		System.out.println("memberId       :: "+memberId);
		System.out.println("memberPassword :: "+memberPassword);
		System.out.println("memberName     :: "+memberName);
		
		//회원정보 저장
		HttpSession session = request.getSession();
		session.setAttribute("memberId", memberId);
		session.setAttribute("memberPassword", memberPassword);
		session.setAttribute("memberName", memberName);
		
		return "index";
	}
	
	@RequestMapping(value = "/signin")
	public ModelAndView signin(HttpServletRequest request) {
		System.out.println("회원 정보 검증");
		
		String inputId = request.getParameter("memberId");
		String inputPassword = request.getParameter("memberPassword");
		
		System.out.println("inputId       :: "+inputId);
		System.out.println("inputPassword :: "+inputPassword);
		
		//회원정보 가져오기
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		String memberPassword = (String) session.getAttribute("memberPassword");
		String memberName = null;
		
		String returnPage;
		if(memberId.equals(inputId) && memberPassword.equals(inputPassword)) {
			memberName = (String) session.getAttribute("memberName");
			returnPage = "main";
		} else {
			returnPage = "index";
		}
		
		ModelAndView mav = new ModelAndView(returnPage);
		mav.addObject("memberName", memberName);
		
		return mav;
	}
}
