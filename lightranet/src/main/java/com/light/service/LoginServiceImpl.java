package com.light.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.light.service.LoginService;
import com.light.domain.EmployeeVO;
import com.light.mapper.LoginMapper;

import lombok.Setter;

@Service
public class LoginServiceImpl implements LoginService{

	@Setter(onMethod_= @Autowired)
	private LoginMapper loginMapper;
	
	@Override
	public EmployeeVO login(String e_loginid, String e_loginpw) {
		EmployeeVO eVO = new EmployeeVO();
		eVO.setE_loginid(e_loginid);
		eVO.setE_loginpw(e_loginpw);
		EmployeeVO loginPersonVO = loginMapper.login(eVO);
		return loginPersonVO;
	}

}