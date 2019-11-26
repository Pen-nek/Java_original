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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.light.domain.CalendarVO;
import com.light.service.CalService;

import lombok.AllArgsConstructor;

@RequestMapping
@Controller
@AllArgsConstructor
public class CalendarController {

	private CalService service;
	HttpSession session;


	// 일정 창 띄우기
	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public String test(Model model) {
		String jsonStr = "";
		int listSize = 0;

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			// calendar 화면을 부르는 곳에서 데이터를 일단 가져온다.
			List<CalendarVO> resultList = service.getCalList();
			// 화면에 값을 넘겨준다.
			if(resultList != null) {
				// 나중에 json 사용할때 참고! https://m.blog.naver.com/platinasnow/220388218842
				// 아래는 걍 하드코딩 복사.
				// list<vo> 형태로 보내주니까 값이 이상하게 받아와져서 json 형태로 변환함 
				// 아래 json으로 형태 변환해준 후에 (json = [{"키1":"값", "키2":"값"},{"키1":"값", "키2":"값"}] 이런 형태임) 
				jsonStr = "[";
				for(int i = 0; i < resultList.size(); i++) {
					CalendarVO cVO = (CalendarVO) resultList.get(i);
					//추가해주고 싶은 항목 있으면 아래에다가 잘 추가해주면 됨.
					jsonStr += "{\"c_id\": \"" + cVO.getC_id() 
					+ "\",\"c_content\": \"" + cVO.getC_content() 
					+ "\",\"c_start\": \"" + cVO.getC_start() 
					+ "\",\"c_finish\": \"" + cVO.getC_finish() 
					+ "\",\"c_category\": \"" + cVO.getC_category()
					+ "\"}";
					if( i != resultList.size() -1){     // 변수 i가 list.size 보다 1 작을때
						jsonStr += ",";

					}
				}
				jsonStr += "]";

				listSize = resultList.size();
			}

			model.addAttribute("listSize", listSize);
			model.addAttribute("jsonResult", jsonStr);
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
		}

		return "calendar";
	}


	// 일정 추가 창 띄우기
	@GetMapping(value = "/addschedule")
	public void addschedule() {

	}


	// 일정 추가
	@PostMapping("/addschedule")
	public String addschedule(CalendarVO calendarVO, RedirectAttributes rttr, Model model) {
		System.out.println(calendarVO);
		//System.out.println(calendarVO.getC_id());
		//시작일자가 호박인지(어떤 타입인지) 체크
		//System.out.println("너는 호박이니? : " + calendarVO.getC_start());

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			// 일정 추가 실행
			service.addschedule(calendarVO);
			rttr.addFlashAttribute("c_id", calendarVO.getC_id());
			model.addAttribute("msg", "추가되었습니다.");
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}

		return "addschedule";

	}


	//일정 추가해서 넣은 데이터 날짜 클릭하면 일정 조회
	@GetMapping(value="/eventschedule")
	public String show(@RequestParam("c_id") int c_id, Model model) {

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			model.addAttribute("c_id", c_id);
			model.addAttribute("calendar", service.show(c_id));
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}
		return "eventschedule";
	}


	//날짜 클릭하면 수정/삭제 가능.
	//캘린더에서 날짜클릭하면 나오는 창 띄워서 수정/삭제

	@PostMapping(value="/eventschedule") 
	public String modify(CalendarVO calendar, Model model) { 

		// 세션이 존재할 때만
		if (session.getAttribute("userId") != null) {
			if("U".equals(calendar.getFlag())) { // 수정

				service.modify(calendar);
				model.addAttribute("msg", "수정되었습니다.");
			} else if("D".equals(calendar.getFlag())) { // 삭제

				service.calDelete(calendar.getC_id());
				model.addAttribute("msg", "삭제되었습니다.");
			}
		}
		// 세션이 존재하지 않으면
		else {
			model.addAttribute("msg","로그인한 사용자만 이용할 수 있는 페이지입니다.");
			return "/login/LoginForm";
		}

		return "eventschedule";
	}


	/*
	 * @PostMapping("/SenderDelete") public void senderDelete(@RequestParam("n_id")
	 * int n_id) { service.senderDelete(n_id); }
	 */
}




