package com.light.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.light.domain.DeptVO;
import com.light.domain.DraftVO;
import com.light.domain.EmployeeVO;
import com.light.domain.ReturnVO;
import com.light.mapper.DraftMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class DraftServiceImpl implements DraftService {
	
	@Setter(onMethod_ = @Autowired)
	private DraftMapper mapper;
	
	// 진행문서함 - 기안 목록 불러오기
	@Override
	public List<DraftVO> getList(int userId) {
		return mapper.getList(userId);
	}
	
	// 임시보관함 - 기안 목록 불러오기
	@Override
	public List<DraftVO> getReadyList(int userId) {
		return mapper.getReadyList(userId);
	}
	
	// 결재완료보관함 - 기안 목록 불러오기
	@Override
	public List<DraftVO> getFinishedList(int userId) {
		return mapper.getFinishedList(userId);
	}
	
	// 반려문서함 - 기안 목록 불러오기
	@Override
	public List<DraftVO> getReturnList(int userId) {
		return mapper.getReturnList(userId);
	}
	
	// 부서문서함 - 기안 목록 불러오기
	@Override
	public List<DeptVO> getDeptDraftList(int userDeptId) {
		return mapper.getDeptDraftList(userDeptId);
	}
	
	
	
	// 진행문서 읽기 창 - 문서 읽기
	@Override
	public DraftVO draftRead(int d_id) {
		return mapper.draftRead(d_id);
	}
	
	// 반려기록 읽기
	@Override
	public ReturnVO returnDraftRead(int r_id) {
		return mapper.returnDraftRead(r_id);
	}
	
	
	
	// 기안 작성 창 - 부서목록 불러오기
	@Override
	public List<DeptVO> getDeptList() {
		return mapper.getDeptList();
	}
	
	// 기안 작성 창 - 부서에 해당하는 사람 이름 목록 불러오기 (ajax처리)
	@Override
	public List<EmployeeVO> getNameList(String deptName) {
		return mapper.getNameList(deptName);
	}
	
	
	
	// 기안 작성 창 - 작성하기
	@Override
	public void registDraft(DraftVO draft) {
		mapper.insert(draft);
	}
	
	// 기안 작성 창 - 작성하기 (전결)
	@Override
	public void registJumpDraft(DraftVO draft) {
		mapper.insertJump(draft);
	}
	
	// 진행문서 - 결재자 반려 (인서트)
	@Override
	public void returnInsert(ReturnVO back) {
		mapper.returnInsert(back);
	}
	
	// 기안 작성 창 - 임시저장
	@Override
	public void saveDraft(DraftVO draft) {
		mapper.saveDraft(draft);
	}
	
	// 기안 작성 창 - 전결 임시저장
	@Override
	public void saveJumpDraft(DraftVO draft) {
		mapper.saveJumpDraft(draft);
	}

	
	
	// 임시보관함 읽기 창 - 기안 작성하기
	@Override
	public boolean registReadyDraft(DraftVO draft) {
		return mapper.registReadyDraft(draft) == 1;
	}
	
	// 임시저장함 - 임시저장
	@Override
	public boolean saveReadyDraft(DraftVO draft) {
		return mapper.saveReadyDraft(draft) == 1;
	}
	
	// 진행문서 - 중간결재자 승인
	@Override
	public boolean midOk(DraftVO draft) {
		return mapper.updateMidOk(draft) == 1;
	}
	
	// 진행문서 - 중간결재자 승인
	@Override
	public boolean finalOk(DraftVO draft) {
		return mapper.updateFinalOk(draft) == 1;
	}
	
	// 진행문서 - 결재자 반려
	@Override
	public boolean draftNo(DraftVO draft) {
		return mapper.updateNo(draft) == 1;
	}
	
	
	
	// 기안 작성 창 - 회수
	@Override
	public boolean backDraftGo(DraftVO draft) {
		return mapper.backDraftGo(draft) == 1;
	}
	
	// 회수문서 - 수정
	@Override
	public boolean backDraftModify(DraftVO draft) {
		return mapper.backDraftUpdate(draft) == 1;
	}
	
	// 회수문서 - 삭제
	@Override
	public boolean removeDraft(int d_id) {
		return mapper.removeDraft(d_id) == 1;
	}


}

