package com.light.mapper;

import com.light.domain.EmployeeVO;

public interface MyPageMapper {
	
	public EmployeeVO select(int e_id);
	
	public int update(EmployeeVO employee);
	
	public int pwdCheck(String userPw);


}
