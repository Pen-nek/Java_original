package com.light.mapper;

import java.util.List;

import com.light.domain.DeptVO;
import com.light.domain.EmployeeVO;
import com.light.domain.NoteVO;

public interface NoteMapper {
	
	public List<NoteVO> getReceiveList(int userId);
	
	public List<NoteVO> getSendList(int userId);
	
	public List<DeptVO> getReceiverDept();
	
	public List<EmployeeVO> getReceiverList(String deptName);
	
	public void send(NoteVO note);
	
	public void newNoteSend(NoteVO note);
	
	public NoteVO read(int n_id);
	
	public boolean receiverDelete(int n_id);
	
	public boolean senderDelete(int n_id);
	
	public boolean check(int n_id);
	
}
