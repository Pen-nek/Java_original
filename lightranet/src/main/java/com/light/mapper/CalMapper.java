package com.light.mapper;

import java.util.List;

import com.light.domain.CalendarVO;

public interface CalMapper {
	
	// 일정 추가
	public void insert(CalendarVO calendarVO);  //
	//일정 조회
		public List<CalendarVO> getCalList();
		
	//일정 수정 조회
		public CalendarVO select(int c_id);
		/*
	 * public int update(CalendarVO calendar);
	 */
		public int update(CalendarVO calendar);

		public int calDelete(int c_id);

}
