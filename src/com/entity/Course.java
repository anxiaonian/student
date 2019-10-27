package com.entity;

public class Course {
		private String cid;
		private String cno;
		private String cname;
		private String cteacher;
		
		public Course(String cno, String cname, String cteacher,String cid) {
			this.cno=cno;
			this.cname=cname;
			this.cteacher=cteacher;
			this.cid=cid;
		}
		public Course() {}
		
		
		public String getCid() {
			return cid;
		}
		public void setCid(String cid) {
			this.cid = cid;
		}
		public String getCno() {
			return cno;
		}
		public void setCno(String cno) {
			this.cno = cno;
		}
		public String getCname() {
			return cname;
		}
		public void setCname(String cname) {
			this.cname = cname;
		}
		public String getCteacher() {
			return cteacher;
		}
		public void setCteacher(String cteacher) {
			this.cteacher = cteacher;
		}
}
