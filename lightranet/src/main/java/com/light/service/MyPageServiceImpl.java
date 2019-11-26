package com.light.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.light.domain.EmployeeVO;
import com.light.mapper.MyPageMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MyPageServiceImpl implements MyPageService{

	@Setter(onMethod_ = @Autowired)
	private MyPageMapper mapper;

	@Override
	public EmployeeVO show(int e_id) {
		
		return mapper.select(e_id);
	}

	@Override
	public boolean emp_modify(EmployeeVO employee) {
		
		return mapper.update(employee) == 1;
	}


}
