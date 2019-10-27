package com.entity;

import java.util.Date;

public class Student {
	private int sid;
	private String sno;
	private String sname;
	private String age;
	private String gender;
	private String class_id;
	private Date birthday;

		

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int sid, String sno, String sname, String age, String gender, String class_id, Date birthday) {
		super();
		this.sid=sid;
		this.sno=sno;
		this.sname=sname;
		this.age=age;
		this.gender=gender;
		this.class_id=class_id;
		this.birthday=birthday;
		}
	
	public Student(String sno, String sname, String age, String gender, String class_id,Date birthday) {
		super();
		this.sno=sno;
		this.sname=sname;
		this.age=age;
		this.gender=gender;
		this.class_id=class_id;
		this.birthday=birthday;
	}
		

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	}

