package com.light.service;

import java.util.List;

import com.light.domain.AdminMemberVO;
import com.light.domain.DepartmentVO;

public interface AdminMemberService {

	public void adminMemberRegister(AdminMemberVO adminMember);
	
	public AdminMemberVO adminMemberGet(Long e_id);

	public List<AdminMemberVO> getAdminMemberList();
	
	public List<DepartmentVO> getDeptList();
	
	public boolean adminMemberModify(AdminMemberVO adminMember);
	
	public boolean adminMemberRemove(Long e_id);
}
