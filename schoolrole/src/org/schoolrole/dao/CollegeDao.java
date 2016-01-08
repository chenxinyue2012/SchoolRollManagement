package org.schoolrole.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.schoolrole.model.College;
import org.schoolrole.model.Major;
import org.schoolrole.utils.DBUtils;

public class CollegeDao {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
   //更新或添加
	public boolean saveUpdate(College college) {
		boolean result = false;
		String SQL = "UPPADE COLLEGE SET COLLEGENUM=?,COLLEGENAME=?,PRESIDENTNAME=? WHERE ID=?";
		if (college.getId() == null) {
			SQL = "INSERT INTO COLLEGE(COLLEGENUM,COLLEGENAME,PRESIDENTNAME) VALUES(?,?,?)";
		}
		con = DBUtils.getConnection();
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, college.getCollegeNum());
			pstmt.setString(2, college.getCollegeName());
			pstmt.setString(3, college.getPresidentName());
			if (college.getId() != null) {
				pstmt.setInt(4, college.getId());
			}
			if (pstmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
//查看所有学院
	public List<College> getAllCollege() {
		List<College> collegeList=new ArrayList<College>();
		College college=null;
		String SQL = "SELECT * FROM COLLEGE";
		con=DBUtils.getConnection();
		try {
			pstmt=con.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			while(rs.next()){
				college=new College();
				college.setId(rs.getInt("ID"));
				college.setCollegeNum(rs.getString("collegeNum"));
				college.setCollegeName(rs.getString("collegeName"));
				college.setPresidentName(rs.getString("presidentName"));
				collegeList.add(college);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return collegeList;
	}
	//删除某一专业
	public boolean deleteCollegeByID(Integer collegeID){
		boolean result=false;
		con=DBUtils.getConnection();
		try {
			pstmt=con.prepareStatement("DELETE FROM COLLEGE WHERE ID=?");
			pstmt.setInt(1, collegeID);
			if(pstmt.executeUpdate()==1){
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public College getCollegeByID(Integer collegeID) {
		College college=null;
		String SQL = "SELECT * FROM COLLEGE WHERE ID=?";
		con=DBUtils.getConnection();
		try {
			pstmt=con.prepareStatement(SQL);
			pstmt.setInt(1, collegeID);
			rs=pstmt.executeQuery();
			while(rs.next()){
				college=new College();
				college.setId(rs.getInt("ID"));
				college.setCollegeNum(rs.getString("collegeNum"));
				college.setCollegeName(rs.getString("collegeName"));
				college.setPresidentName(rs.getString("presidentName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return college;
	}
	
	
	
}
