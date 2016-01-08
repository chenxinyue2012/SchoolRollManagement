package org.schoolrole.model;

public class Major {
	private Integer id;
	private String majorNumber;
	private String majorName;//×¨ÒµÃû
	private Integer collegeID;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	
	public Integer getCollegeID() {
		return collegeID;
	}
	public void setCollegeID(Integer collegeID) {
		this.collegeID = collegeID;
	}
	public String getMajorNumber() {
		return majorNumber;
	}
	public void setMajorNumber(String majorNumber) {
		this.majorNumber = majorNumber;
	}
	
	
}
