package com.light.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.light.domain.DraftVO;
import com.light.domain.EmployeeVO;
import com.light.domain.ReturnVO;
import com.light.service.DraftService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class DraftController { 

	private DraftService service;
	HttpSession session;


	// 진행문서함 - 기안 목록 불러오기
	@GetMapping("/goingDraft")
	public String goingDraft(Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			int userId = (int) session.getAttribute("userId");
			model.addAttribute("goingDraft", service.getList(userId));
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}
		return "/goingDraft";

	}

	// 임시보관함 - 기안 목록 불러오기
	@GetMapping("/readyDraft")
	public String readyDraft(Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			int userId = (int) session.getAttribute("userId");
			model.addAttribute("readyDraftList", service.getReadyList(userId));
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}
		return "/readyDraft";

	}

	// 반려기록함 - 기안 목록 불러오기
	@GetMapping("/returnDraft")
	public String returnDraft(Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			int userId = (int) session.getAttribute("userId");
			model.addAttribute("returnDraftList", service.getReturnList(userId));
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}
		return "/returnDraft";

	}

	// 결재완료보관함 - 기안 목록 불러오기
	@GetMapping("/finishedDraft")
	public String finishedDraft(Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			int userId = (int) session.getAttribute("userId");
			model.addAttribute("finishedDraftList", service.getFinishedList(userId));
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}
		return "/finishedDraft";

	}

	// 부서문서함 - 기안 목록 불러오기
	@GetMapping("/deptDraft")
	public String deptDraftList(Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			int userDeptId = (int) session.getAttribute("userDeptId");
			model.addAttribute("deptdraftlist", service.getDeptDraftList(userDeptId));
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}
		return "/deptDraft";

	}



	// 진행문서함 - 문서 읽기
	@GetMapping("/goingDraftRead")
	public String goingDraftRead(@RequestParam("d_id") int d_id, Model model) {
		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			model.addAttribute("draft", service.draftRead(d_id));
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}
		return "/goingDraftRead";
	}


	// 반려기록함 - 문서 읽기
	@GetMapping("/returnDraftRead")
	public String returnDraftRead(@RequestParam("r_id") int r_id, Model model) {
		if (session.getAttribute("userId") != null) {
			model.addAttribute("back", service.returnDraftRead(r_id));
		}
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}
		return "/returnDraftRead";

	}

	// 결재완료문서함 - 문서 읽기
	@GetMapping("/finishedDraftRead")
	public String finishedDraftRead(@RequestParam("d_id") int d_id, Model model) {
		if (session.getAttribute("userId") != null) {
			model.addAttribute("draft", service.draftRead(d_id));
		}
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}
		return "/finishedDraftRead";

	}

	// 부서문서함 - 문서 읽기
	@GetMapping("/deptDraftRead")
	public String deptDraftRead(@RequestParam("d_id") int d_id, Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			model.addAttribute("draft", service.draftRead(d_id)); //매퍼에 d_approvedate추가했음
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}

		return "deptDraftRead";
	}



	// 기안 작성 - 작성폼에 부서목록 불러오기
	@GetMapping("/registDraft")
	public String registDraft(Model model) {

		if (session.getAttribute("userId") != null) {
			model.addAttribute("getDeptList", service.getDeptList());	// https://offbyone.tistory.com/368	
		}
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}
		return "/registDraft";
	}

	// 기안 작성 - 폼에서 부서 선택 시 해당사원 목록 불러오기 (ajax)
	@RequestMapping(value="/ajaxRegistDraft", method=RequestMethod.POST)
	@ResponseBody // return결과를 json으로 만들어줌
	public List<EmployeeVO> ajaxRegistDraft(@RequestParam(value="deptName") String deptName) {

		List<EmployeeVO> vo = service.getNameList(deptName);
		return vo;
	}

	// 기안 작성 - 기안 작성하기 (전결 체크 후 인서트)
	// 폼에 들어있는 hidden으로 세션 값도 넘겨받고 있음
	@PostMapping("/registDraft")
	public String registDraft(DraftVO draft, RedirectAttributes rttr, Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			// 전결여부 체크
			boolean jump = draft.isJumpFinal();

			// 전결이면
			if (jump == true) {
				service.registJumpDraft(draft);	
			} else {
				service.registDraft(draft);
			}
			// 모달에 필요한 부분 (일회용 값 넘기기)
			rttr.addFlashAttribute("result", "registSuccess");
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}

		return "redirect:/goingDraft";
	}

	// 기안 작성 창 - 임시저장하기 (전결 체크 후 인서트)
	@PostMapping("/saveDraft")
	public String saveDraft(DraftVO draft, RedirectAttributes rttr, Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			// 전결여부 체크
			boolean jump = draft.isJumpFinal();

			if (jump == true) {
				service.saveJumpDraft(draft);
			} else {
				service.saveDraft(draft);
			}

			rttr.addFlashAttribute("result", "saveDraftSuccess");
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}

		return "redirect:/readyDraft";
	}



	// 진행문서 - 결재자 반려 (수정&삽입)
	@PostMapping("/goingDraftNo")
	public String goingDraftNo(Model model, DraftVO draft, ReturnVO back, RedirectAttributes rttr) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			// 진행문서를 '반려' 상태로 update
			service.draftNo(draft);

			// 진행문서를 반려기록함 테이블에 insert
			service.returnInsert(back);

			rttr.addFlashAttribute("result", "noDraftSuccess");
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}

		return "redirect:/goingDraft";
	}



	// 진행문서 - 중간결재자 승인 (전결 체크 후 수정)
	@PostMapping("/goingDraftMidOk")
	public String goingDraftMidOk(DraftVO draft, RedirectAttributes rttr, Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			// 전결 체크
			int checkJumped = draft.getFinalApprover_id();

			if (checkJumped > 0) {
				if (service.midOk(draft)) {
					rttr.addFlashAttribute("result", "midOkSuccess");
					return "redirect:/goingDraft";
				}
			}
			if (service.finalOk(draft)) {
				rttr.addFlashAttribute("result", "midJumpSuccess");
			}
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}

		return "redirect:/goingDraft";
	}

	// 임시보관문서 - 임시저장
	@PostMapping("/saveReadyDraft")
	public String saveReadyDraft(DraftVO draft, RedirectAttributes rttr, Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			if(service.saveReadyDraft(draft)) {
				rttr.addFlashAttribute("result", "modSaveDraftSuccess");
			}
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}

		return "redirect:/readyDraft";
	}

	// 임시보관문서 - 기안 작성하기
	@PostMapping("/registReadyDraft")
	public String registReadyDraft(DraftVO draft, RedirectAttributes rttr, Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			if(service.registReadyDraft(draft)) {
				rttr.addFlashAttribute("result", "registSaveDraftSuccess");
			}
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}

		return "redirect:/goingDraft";
	}

	// 진행문서 - 최종결재자 승인
	@PostMapping("/goingDraftFinalOk")
	public String goingDraftFinalOk(DraftVO draft, RedirectAttributes rttr, Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			if (service.finalOk(draft)) {
				rttr.addFlashAttribute("result", "finalOkSuccess");
			}
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}

		return "redirect:/goingDraft";
	}

	// 진행문서 - 회수 버튼 클릭시 진행상태 수정
	@PostMapping("/backDraftGo")
	public String backDraftGo(DraftVO draft, RedirectAttributes rttr, Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			if (service.backDraftGo(draft)) {
				rttr.addFlashAttribute("result", "backDraftSuccess");
			}
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}

		return "redirect:/goingDraft";
	}

	// 회수문서 수정 창 - 재기안 버튼 클릭 시
	@PostMapping("/backDraftModify")
	public String backDraftModify(DraftVO draft, RedirectAttributes rttr, Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			if (service.backDraftModify(draft)) {
				rttr.addFlashAttribute("result", "backRegistSuccess");
			}
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}

		return "redirect:/goingDraft";
	}

	// 회수문서 수정 창 - 삭제 처리
	@PostMapping("/removeDraft")
	public String removeDraft(@RequestParam("d_id") int d_id, RedirectAttributes rttr, Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			if(service.removeDraft(d_id)) {
				rttr.addFlashAttribute("result", "removeDraftSuccess");
			}
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}

		return "redirect:/goingDraft";
	}



	// 임시보관문서 - 문서 읽기
	@GetMapping("/readyDraftRead")
	public String readyDraftRead(@RequestParam("d_id") int d_id, Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			model.addAttribute("draft", service.draftRead(d_id));
			model.addAttribute("getDeptList", service.getDeptList()); 
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}

		return "readyDraftRead";

	}

	// 회수문서 수정 창 - 문서 읽기
	@GetMapping("/backDraftModify")
	public String backDraftRead(@RequestParam("d_id") int d_id, Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			model.addAttribute("draft", service.draftRead(d_id));
			model.addAttribute("getDeptList", service.getDeptList()); 
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}

		return "backDraftModify";
	}


}
