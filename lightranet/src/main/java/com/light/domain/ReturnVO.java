package com.light.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReturnVO {
	private int r_id;
	private String r_content;
	private LocalDateTime r_returndate;
	private int r_returner;
	private int r_employee;
	private int r_draft;
	
	private LocalDateTime d_writedate;
	private String d_title;
	private String d_content;
	
	private String writer_name;
	private String writer_dept;
	private String midApprover_name;
	private String midApprover_dept;
	private String finalApprover_name;
	private String finalApprover_dept;
	
	private String returner_name;
}
