package com.light.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.light.domain.DeptVO;
import com.light.domain.EmployeeVO;
import com.light.domain.NoteVO;
import com.light.mapper.NoteMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService{
	
	@Setter(onMethod_ = @Autowired)
	private NoteMapper mapper;
	
	@Override //등록작업
	public void send(NoteVO note) {
		log.info("register" + note);
		
		mapper.send(note);
	}

	@Override
	public NoteVO get(int n_id) {
		log.info("get");
		
		return mapper.read(n_id);
	}

	@Override //목록작업
	public List<NoteVO> getReceiveList(int userId) {
		log.info("getlist");
		return mapper.getReceiveList(userId);
		
	}

	@Override
	public boolean checked(int n_id) {
		return mapper.check(n_id);
	}


	@Override
	public boolean receiverDelete(int n_id) {
		return mapper.receiverDelete(n_id);
	}

	@Override
	public boolean senderDelete(int n_id) {
		return mapper.senderDelete(n_id);
	}

	@Override
	public List<DeptVO> getReceiverDept() {
		return mapper.getReceiverDept();
	}

	@Override
	public List<EmployeeVO> getReceiverList(String deptName) {
		return mapper.getReceiverList(deptName);
	}

	@Override
	public List<NoteVO> getSendList(int userId) {
		log.info("getsendlist");
		return mapper.getSendList(userId);
	}

	@Override
	public void newNoteSend(NoteVO note) {
		mapper.newNoteSend(note);
	}

}
