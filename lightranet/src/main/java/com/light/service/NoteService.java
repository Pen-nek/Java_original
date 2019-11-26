package com.light.service;

import java.util.List;

import com.light.domain.DeptVO;
import com.light.domain.EmployeeVO;
import com.light.domain.NoteVO;

public interface NoteService {
	
	//헤더에서 쪽지보내기
	public void send(NoteVO note);
	
	public void newNoteSend(NoteVO note);
	
	//부서목록불러오기
	public List<DeptVO> getReceiverDept();
	
	//부서에 해당되는 사람이름 불러오기
	public List<EmployeeVO> getReceiverList(String deptName);
	
	//새창에서 쪽지읽기
	public NoteVO get(int n_id);
	
	//받은 쪽지 리스트
	public List<NoteVO> getReceiveList(int userId);
	
	//보낸 쪽지 리스트
	public List<NoteVO> getSendList(int userId);
	
	//쪽지 확인
	public boolean checked(int n_id);
	
	//받은 사람이 쪽지 삭제
	public boolean receiverDelete(int n_id);
	
	//보낸 사람이 쪽지삭제
	public boolean senderDelete(int n_id);
}
