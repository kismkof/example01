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
		System.out.println("�ε���");
		return "index";
	}
	
	@RequestMapping(value = "/main")
	public String goMain(HttpServletRequest request) {
		System.out.println("����������");
		return "main";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String goSignup() {
		System.out.println("ȸ������ ������");
		return "member/signup";
	}
	
	@RequestMapping(value = "/insertMember", method = RequestMethod.POST)
	public String insertMember(HttpServletRequest request) {
		System.out.println("ȸ�� ���� ����");
		
		String memberId = request.getParameter("memberId");
		String memberPassword = request.getParameter("memberPassword");
		String memberName = request.getParameter("memberName");
		
		System.out.println("memberId       :: "+memberId);
		System.out.println("memberPassword :: "+memberPassword);
		System.out.println("memberName     :: "+memberName);
		
		//ȸ������ ����
		HttpSession session = request.getSession();
		session.setAttribute("memberId", memberId);
		session.setAttribute("memberPassword", memberPassword);
		session.setAttribute("memberName", memberName);
		
		return "index";
	}
	
	@RequestMapping(value = "/signin")
	public ModelAndView signin(HttpServletRequest request) {
		System.out.println("ȸ�� ���� ����");
		
		String inputId = request.getParameter("memberId");
		String inputPassword = request.getParameter("memberPassword");
		
		System.out.println("inputId       :: "+inputId);
		System.out.println("inputPassword :: "+inputPassword);
		
		//ȸ������ ��������
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
