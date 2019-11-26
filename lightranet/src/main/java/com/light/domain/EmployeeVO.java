package com.light.domain;

import com.mysql.cj.jdbc.Blob;

import lombok.Data;

@Data
public class EmployeeVO {

   private int e_id;
   private String e_name;
   private String e_email;
   private String e_phone;
   private String e_position;
   private String e_loginid;
   private String e_loginpw;
   private Blob e_stamp;
   private int e_dept;
   
   private String dept_name;

}