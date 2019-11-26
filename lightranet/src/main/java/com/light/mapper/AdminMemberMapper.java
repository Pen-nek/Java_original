package com.light.mapper;

import java.util.List;

import com.light.domain.AdminMemberVO;
import com.light.domain.DepartmentVO;

public interface AdminMemberMapper {

	public List<AdminMemberVO> getAdminMemberList();
	
	public void adminMemberInsert(AdminMemberVO adminMember);
	
	public void adminMemberinsertSelectKey(AdminMemberVO adminMember);
	
	public AdminMemberVO adminMemberRead(Long e_id);
	
	public int adminMemberDelete(Long e_id);
	
	public int adminMemberUpdate(AdminMemberVO adminMember);
	
	public List<DepartmentVO> getDeptList();
}
