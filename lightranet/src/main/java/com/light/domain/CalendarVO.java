package com.light.domain;

import lombok.Data;

@Data

public class CalendarVO {
	
	   private int c_id;
	   private String c_content;
	   private String c_writer;
	   private String c_dept;
	   private String c_start;   //LocalDateTime
	   private String c_finish;  //LocalDateTime
	   private String c_category;
	   private String flag;
	   
}
