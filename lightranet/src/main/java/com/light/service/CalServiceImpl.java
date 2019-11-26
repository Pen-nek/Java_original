package com.light.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.light.domain.CalendarVO;
import com.light.mapper.CalMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class CalServiceImpl implements CalService{
	
	@Setter(onMethod_ = @Autowired)
	private CalMapper calMapper;

	
	// 스케줄 추가
	@Override
	public void addschedule(CalendarVO calendarVO) {
		
		calMapper.insert(calendarVO);
	}

	//일정 조회
	@Override
	public List<CalendarVO> getCalList() {
			return calMapper.getCalList();
		}

	//일정 넣은 것 조회
	@Override
	public CalendarVO show(int c_id) {
		
		return calMapper.select(c_id);
	}

	//일정 수정
	@Override
	public boolean modify(CalendarVO calendar) {
		return calMapper.update(calendar) == 1;
	}
	// 일정 삭제
	@Override
	public boolean calDelete(int c_id) {
		
		return calMapper.calDelete(c_id) == 1;
	}
	
	
	

}
