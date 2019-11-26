package com.light.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.light.domain.AdminMemberVO;
import com.light.service.AdminMemberService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/*")
@AllArgsConstructor
public class AdminMemberController {

	private AdminMemberService service;
	HttpSession session;



	// 사원관리 목록 불러오기
	@GetMapping("/memberList")
	public String adminMemberList(Model model) {

		boolean isAdmin = (boolean)session.getAttribute("isAdmin");

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			// 접속자가 관리자일 때
			if (isAdmin == true) {
				model.addAttribute("memberList", service.getAdminMemberList());
				return "/memberList";
			} else {
				// 관리자 아닐 때
				model.addAttribute("msg","관리자만 이용할 수 있는 페이지입니다.");
			}
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
		}

		return "/login/LoginForm";
	}



	// 사원 추가 창 - 부서목록 불러오기 
	@GetMapping("/adminMemberAdd") 
	public void adminMemberRegister(Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			model.addAttribute("getDeptList", service.getDeptList()); 
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
		}

	}



	// 사원 추가
	@RequestMapping(value = "/adminMemberAdd", method = RequestMethod.POST)
	public void adminMemberRegister(AdminMemberVO adminMember, Model model) throws Exception {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			service.adminMemberRegister(adminMember); 
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
		}

	}



	// 사원 조회
	@GetMapping("/adminMemberRUD") 
	public void adminMemberGet(@RequestParam("e_id") Long e_id, Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			model.addAttribute("getDeptList", service.getDeptList()); 
			model.addAttribute("adminMember", service.adminMemberGet(e_id));
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
		}

	}



	// 사원 정보 수정
	@PostMapping("/adminMemberRUD") // @PostMapping("/modify")
	public void adminMemberModify(AdminMemberVO adminMember, RedirectAttributes rttr, Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			if (service.adminMemberModify(adminMember)) {
				rttr.addFlashAttribute("result", "success");
			}
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
		}





	}


	// 사원 정보 삭제
	// 멤버의 id가 다른 테이블에 FK로 물려있기 때문에 완전 삭제 처리가 안 됨. delete가 아니라 update를 사용하는 방식으로 내용 수정 필요
	@PostMapping("/adminMemberRemove")
	public void adminMemberRemove(@RequestParam("e_id") Long e_id, RedirectAttributes rttr, Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			if (service.adminMemberRemove(e_id)) {
				rttr.addFlashAttribute("result", "success");
			}
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
		}

	}

}
