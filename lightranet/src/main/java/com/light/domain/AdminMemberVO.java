package com.light.domain;

import lombok.Data;

@Data
public class AdminMemberVO {
	private Long e_id;
	private String e_name;
	private String e_email;
	private String e_phone;
	private String e_position;
	private String e_loginid;
	private String e_loginpw;
	
	private byte[] e_stamp;
	
	private String e_dept;
	private int dept_id;
	private String dept_name;
	
}
