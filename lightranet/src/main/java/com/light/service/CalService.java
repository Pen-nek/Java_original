package com.light.service;


import java.util.List;

import com.light.domain.CalendarVO;

public interface CalService {
	
		//일정 작성
		public void addschedule(CalendarVO calendarVO);

		//일정 조회
		public List<CalendarVO> getCalList();

		//일정 넣은 것 조회
		public CalendarVO show(int c_id);
		
		//일정 수정
		public boolean modify(CalendarVO calendar);

		//일정 삭제
		public boolean calDelete(int c_id);
}
