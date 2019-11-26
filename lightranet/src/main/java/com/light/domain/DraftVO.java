package com.light.domain;

import lombok.Data;

@Data
public class DraftVO {
	
	private int d_id;
	private String d_title;
	private String d_content;
	private String d_writeDate;	// 왜 LocalDateTime인가 : https://jeong-pro.tistory.com/163
	private String d_approvedate;
	private String d_process;
	private int d_dept;
	private int d_writer;
	private int d_midApprover;
	private int d_finalApprover;
	
	private int writer_id;
	private String writer_name;
	private String writer_dept;
	private int midApprover_id;
	private String midApprover_name;
	private String midApprover_dept;
	private int finalApprover_id;
	private String finalApprover_name;
	private String finalApprover_dept;
	private boolean jumpFinal;
	
	private String dept_name;
	
}
