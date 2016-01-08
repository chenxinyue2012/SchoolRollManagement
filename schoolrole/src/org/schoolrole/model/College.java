package org.schoolrole.model;

import java.util.ArrayList;
import java.util.List;

public class College {
	private Integer id;
	private String collegeName;//学院名
	private String presidentName;//院长名
	private String collegeNum;
	private List<Major> majorList=new ArrayList<Major>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCollegeNum() {
		return collegeNum;
	}
	public void setCollegeNum(String collegeNum) {
		this.collegeNum = collegeNum;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getPresidentName() {
		return presidentName;
	}
	public void setPresidentName(String presidentName) {
		this.presidentName = presidentName;
	}
	
	
	
}
