package com.light.service;

import com.light.domain.EmployeeVO;

public interface LoginService {

	public EmployeeVO login(String e_loginid, String e_loginpw);
	
}
