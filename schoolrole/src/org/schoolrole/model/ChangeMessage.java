package org.schoolrole.model;

import java.util.Date;

public class ChangeMessage {
	
	private Integer id;
	private Date changeDate;
	private String changeNumber;
	private String type;
	private String reason;
	private Date backDate;
	private Integer oldClassID;
	private Integer newClassID;
	private Integer studentID;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	public String getChangeNumber() {
		return changeNumber;
	}
	public void setChangeNumber(String changeNumber) {
		this.changeNumber = changeNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getBackDate() {
		return backDate;
	}
	public void setBackDate(Date backDate) {
		this.backDate = backDate;
	}
	
	public Integer getOldClassID() {
		return oldClassID;
	}
	public void setOldClassID(Integer oldClassID) {
		this.oldClassID = oldClassID;
	}
	public Integer getNewClassID() {
		return newClassID;
	}
	public void setNewClassID(Integer newClassID) {
		this.newClassID = newClassID;
	}
	public Integer getStudentID() {
		return studentID;
	}
	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}
	
	
}
