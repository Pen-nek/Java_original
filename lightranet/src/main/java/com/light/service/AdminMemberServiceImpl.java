package com.light.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.light.domain.AdminMemberVO;
import com.light.domain.DepartmentVO;
import com.light.mapper.AdminMemberMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class AdminMemberServiceImpl implements AdminMemberService {
	
	
	@Setter(onMethod_ = @Autowired)
	private AdminMemberMapper mapper;
	
	@Override
	public void adminMemberRegister(AdminMemberVO adminMember){
		log.info("register.........." + adminMember);
		mapper.adminMemberInsert(adminMember);
		
	}

	@Override
	public AdminMemberVO adminMemberGet(Long e_id) {
		log.info("get..............." + e_id);
		
		return mapper.adminMemberRead(e_id);
	}

	@Override
	public boolean adminMemberModify(AdminMemberVO adminMember) {
		log.info("modify..................." + adminMember);
		return mapper.adminMemberUpdate(adminMember) == 1;
	}

	@Override
	public List<AdminMemberVO> getAdminMemberList() {
		
		log.info("getList..................");
		return mapper.getAdminMemberList();
	}
	
	@Override
	public List<DepartmentVO> getDeptList(){
		log.info("getDeptList.............");
		return mapper.getDeptList();
	}
	@Override
	public boolean adminMemberRemove(Long e_id) {
		log.info("remove...................." + e_id);
		return mapper.adminMemberDelete(e_id) == 1;
	}
}
