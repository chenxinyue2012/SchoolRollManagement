package org.schoolrole.model;

import java.util.Date;

public class RewordorPublishment {

	private Integer id;
	private String num;
	private Date date;
	private String reason;
	private int reorPublish;
	private String other;
	private Integer studentID;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int isReorPublish() {
		return reorPublish;
	}
	public void setReorPublish(int reorPublish) {
		this.reorPublish = reorPublish;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public Integer getStudentID() {
		return studentID;
	}
	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}
	
	
	
	
	
	
}
