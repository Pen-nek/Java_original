package com.light.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.light.domain.EmployeeVO;
import com.light.domain.NoteVO;
import com.light.service.NoteService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class NoteController {

	private NoteService service;
	HttpSession session;

	// 받은쪽지함 리스트
	@GetMapping(value = "/receiveNote")
	public String receiveNote(Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			int userId = (int) session.getAttribute("userId");
			model.addAttribute("list", service.getReceiveList(userId));
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}
		return "receiveNote";
	}

	// 보낸쪽지함
	@GetMapping(value = "/sendedNote")
	public String sendedNote(Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			int userId = (int) session.getAttribute("userId");
			model.addAttribute("list", service.getSendList(userId));
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}
		return "sendedNote";
	}

	// 헤더 쪽지보내기
	@PostMapping("/noteForm")
	public String send(NoteVO note, Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			service.send(note);
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}
		return "redirect:/sendedNote";
	}

	// 받은 쪽지 확인창
	@RequestMapping(value = "/readReceiveNote")
	public String get(HttpServletRequest request, @RequestParam("n_id") int n_id, Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			model.addAttribute("n_id", n_id);
			service.checked(n_id);
			model.addAttribute("note", service.get(n_id));
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}
		return "readReceiveNote";
	}

	// 받은 사람이 쪽지삭제
	@PostMapping("/ReceiverDelete")
	public String receiverDelete(@RequestParam("n_id") int n_id, Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			service.receiverDelete(n_id);
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}
		return "ReceiverDelete";
	}

	// 받은 사람이 쪽지삭제
	@PostMapping("/SenderDelete")
	public String senderDelete(@RequestParam("n_id") int n_id, Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			service.senderDelete(n_id);
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}
		return "SenderDelete";
	}

	// 보낸 쪽지 확인창
	@RequestMapping(value = "/readSendNote")
	public String readsendednote(HttpServletRequest request, @RequestParam("n_id") int n_id, Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			model.addAttribute("n_id", n_id);
			model.addAttribute("note", service.get(n_id));
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}
		return "readSendNote";
	}

	// 쪽지전송 부서리스트
	@RequestMapping(value = "/noteForm", method = RequestMethod.GET)
	public String deptlisting(Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			model.addAttribute("getReceiverDept", service.getReceiverDept()); // https://offbyone.tistory.com/368
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}
		return "noteForm";
	}

	// 받은 쪽지에서 답장 눌렀을 때
	@RequestMapping(value = "/newNoteForm", method = RequestMethod.GET)
	public String noteForm(Model model, @RequestParam("e_name") String e_name,
			@RequestParam("dept_name") String dept_name)
	{
		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			model.addAttribute("dept_name", dept_name);
			model.addAttribute("e_name", e_name);
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}
		return "/newNoteForm";
	}

	// 받은 쪽지 send할때
	@RequestMapping(value = "/newNoteForm", method = RequestMethod.POST)
	public String newNoteForm(Model model, @RequestParam("e_name") String e_name, NoteVO note) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			model.addAttribute("e_name", e_name);

			service.newNoteSend(note);
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}
		return "/newNoteForm";
	}

	// 기안하기 창 - ajax처리
	@RequestMapping(value = "/ajaxreceiver", method = RequestMethod.POST)
	@ResponseBody // return결과를 json으로 만들어줌
	public List<EmployeeVO> ajaxreceiverlist(@RequestParam(value = "deptName") String deptName) {

		List<EmployeeVO> vo = service.getReceiverList(deptName);
		return vo;
	}

	// 쪽지보내기(readNote)
	@RequestMapping(value = "/sender", method = RequestMethod.GET)
	public String sender(NoteVO note, RedirectAttributes rttr, Model model) {
		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			service.send(note);
			rttr.addFlashAttribute("result", note.getE_name());
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}
		return "sender";
	}

}
