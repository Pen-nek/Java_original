package com.light.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.light.domain.EmployeeVO;
import com.light.service.LoginService;

import lombok.AllArgsConstructor;



@Controller
@RequestMapping("/login/*")
@AllArgsConstructor
public class LoginController {

	
	private LoginService LoginService;
	
	
	
	// /loginform이라는 요청이 들어오면
	@GetMapping("/LoginForm")
	public void LoginForm () {
		
	}
	
	
	
	// 로그인 성공 실패 체크
	@PostMapping(value = "/LoginCheck")
	public String loginCheck(Model model, HttpSession session,
			@RequestParam(value="loginId") String loginId,
			@RequestParam(value="loginPw") String loginPw) {
		
		EmployeeVO loginPersonVO = LoginService.login(loginId, loginPw);
	    
		// 로그인에 실패하면
	    if(loginPersonVO == null) {
			model.addAttribute("msg","로그인에 실패하였습니다.");
			return "/login/LoginForm";
		} 
	    // 로그인에 성공하면
	    else {
	    	// 세션에 유저네임, 유저id, 유저부서id, 관리자 아님 저장
			session.setAttribute("userName", loginPersonVO.getE_name());
	        session.setAttribute("userId", loginPersonVO.getE_id());
	        session.setAttribute("userDeptId", loginPersonVO.getE_dept());
	        session.setAttribute("isAdmin", false);
	        
	        // 관리자인지 체크하고 맞으면 세션에 관리자임을 저장
	        if (loginId.equals("admin") && loginPw.equals("1234")) {
	        	session.setAttribute("isAdmin", true);
	        	return "redirect:/memberList";
	        }
		}
	    
	    model.addAttribute("loginPersonVO", loginPersonVO);
	    return "redirect:/goingDraft"; // 로그인 성공

	}
	
	
	
	// 로그아웃 시 세션 삭제
	@RequestMapping(value = "/logout")
    public String logout(HttpSession session) {

        session.removeAttribute("userName");
        session.removeAttribute("userId");
        session.removeAttribute("isAdmin");
        
        return "redirect:/login/LoginForm";
    }
	
}
