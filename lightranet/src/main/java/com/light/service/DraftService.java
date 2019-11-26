package com.light.service;

import java.util.List;

import com.light.domain.DeptVO;
import com.light.domain.DraftVO;
import com.light.domain.EmployeeVO;
import com.light.domain.ReturnVO;

public interface DraftService {
	
	// 진행문서함 목록 불러오기
	public List<DraftVO> getList(int userId);
	
	// 임시보관함 목록 불러오기
	public List<DraftVO> getReadyList(int userId);
	
	// 결재완료보관함 - 기안 목록 불러오기
	public List<DraftVO> getFinishedList(int userId);
	
	// 반려문서함 - 기안 목록 불러오기
	public List<DraftVO> getReturnList(int userId);
	
	// 부서문서함 - 기안 목록 불러오기
	public List<DeptVO> getDeptDraftList(int userDeptId);
	
	
	
	// 진행&임시저장&회수&완료문서 - 문서 읽기
	public DraftVO draftRead(int d_id);
	
	// 반려기록 - 읽기
	public ReturnVO returnDraftRead(int r_id);
	
	
	
	// 기안 작성 창 - 부서목록 불러오기
	public List<DeptVO> getDeptList();
	
	// 기안 작성 창&임시보관함 읽기 창 - 부서에 해당하는 사람 이름 목록 불러오기 (ajax처리)
	public List<EmployeeVO> getNameList(String deptName);
	
	
	
	// 기안 작성 창 - 작성하기
	public void registDraft(DraftVO draft);
	
	// 기안 작성 창 - 전결 작성하기 
	public void registJumpDraft(DraftVO draft);
	
	// 진행문서 - 결재자 반려 (반려기록 인서트)
	public void returnInsert(ReturnVO back);
	
	
	
	// 기안 작성 창 - 임시저장
	public void saveDraft(DraftVO draft);
	
	// 기안 작성 창 - 전결 임시저장
	public void saveJumpDraft(DraftVO draft);
	
	// 임시보관문서 - 임시보관
	public boolean saveReadyDraft(DraftVO draft);
	
	// 임시보관문서 - 기안 작성하기
	public boolean registReadyDraft(DraftVO draft);
	
	// 진행문서 - 중간결재자 승인
	public boolean midOk(DraftVO draft);
	
	// 진행문서 - 최종결재자 승인
	public boolean finalOk(DraftVO draft);
	
	// 진행문서 - 결재자 반려 (기안문서 업데이트)
	public boolean draftNo(DraftVO draft);
	
	// 기안 작성 창 - 회수 버튼 클릭 시 진행상태 변경 (회수)
	public boolean backDraftGo(DraftVO draft);
	
	// 회수 창 - 재기안
	public boolean backDraftModify(DraftVO draft);
	
	// 회수 창 - 삭제
	public boolean removeDraft(int d_id);
	
	
	
}
