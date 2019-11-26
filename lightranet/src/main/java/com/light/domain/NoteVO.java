package com.light.domain;

import java.util.Date;

import lombok.Data;

@Data
public class NoteVO {
	
	private int n_id;
	private int userId;
	private String n_content;
	private Date n_sendtime;
	private int n_receiver;
	private int n_sender;
	private boolean n_checked;
	private boolean n_receiverdelete;
	private boolean n_senderdelete;
	private String e_name;
	private String dept_name;
}
