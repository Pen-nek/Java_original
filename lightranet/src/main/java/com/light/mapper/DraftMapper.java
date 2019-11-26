package com.light.mapper;

import java.util.List;

import com.light.domain.DeptVO;
import com.light.domain.DraftVO;
import com.light.domain.EmployeeVO;
import com.light.domain.ReturnVO;

public interface DraftMapper {

	// 진행문서함 목록 불러오기
	public List<DraftVO> getList(int userId);
	
	// 임시보관함 목록 불러오기
	public List<DraftVO> getReadyList(int userId);
	
	// 결재완료보관함 목록 불러오기
	public List<DraftVO> getFinishedList(int userId);
	
	// 반려문서함 목록 불러오기
	public List<DraftVO> getReturnList(int userId);
	
	// 부서문서함 목록 불러오기
	public List<DeptVO> getDeptDraftList(int userDeptId);
	
	
	
	// 진행문서함&임시보관 글 읽기
	public DraftVO draftRead(int d_id);
	
	// 반려기록 읽기
	public ReturnVO returnDraftRead(int r_id);
	
	
	
	// 기안 작성 창 - 부서목록 불러오기
	public List<DeptVO> getDeptList();
	
	// 기안 작성 창 - 부서에 해당하는 사람 이름 목록 불러오기 (ajax처리)
	public List<EmployeeVO> getNameList(String deptName);
	
	
	
	// 기안 작성하기
	public void insert(DraftVO draft);
	
	// 기안 작성하기 - 전결
	public void insertJump(DraftVO draft);
	
	// 진행문서 읽기 창 - 결재자 반려 (인서트)
	public void returnInsert(ReturnVO back);
	
	// 기안 작성 창 - 임시저장
	public void saveDraft(DraftVO draft);
	
	// 기안 작성 창 - 전결 임시저장
	public void saveJumpDraft(DraftVO draft);
	
	
	
	// 진행문서 읽기 창 - 중간결재자 승인
	public int updateMidOk(DraftVO draft);
	
	// 진행문서 읽기 창 - 중간결재자 승인
	public int updateFinalOk(DraftVO draft);
	
	// 진행문서 읽기 창 - 결재자 반려
	public int updateNo(DraftVO draft);

	
	
	//회수 버튼 클릭시 d_process = "회수" 수정
	public int backDraftGo(DraftVO draft);
	
	//회수 수정 후 다시 재기안
	public int backDraftUpdate(DraftVO draft);
	
	// 회수문서 수정 창 - 삭제 처리
	public int removeDraft(int d_id);
	
	// 임시보관함 읽기 창 - 기안 작성하기
	public int registReadyDraft(DraftVO draft);
	
	// 임시보관문서 - 임시보관
	public int saveReadyDraft(DraftVO draft);
//	
//	// 임시보관함 읽기 창 - 기안 작성하기 신정연
//	public boolean readyDraftModify(DraftVO draft);
	
	
	


}
