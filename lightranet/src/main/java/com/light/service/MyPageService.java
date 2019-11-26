package com.light.service;

import com.light.domain.EmployeeVO;

public interface MyPageService {

	public EmployeeVO show(int e_id);
	
	public boolean emp_modify(EmployeeVO employee);
	
}

