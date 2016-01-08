package org.schoolrole.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.schoolrole.model.CClass;
import org.schoolrole.model.Major;
import org.schoolrole.utils.DBUtils;

public class MajorDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
   //更新或添加
	public boolean saveUpdate(Major major) {
		boolean result = false;
		String SQL = "UPPADE MAJOR SET MAJORNUM=?,MAJORNAME=?,COLLEGEID=? WHERE ID=?";
		if (major.getId() == null) {
			SQL = "INSERT INTO MAJOR(MAJORNUM,MAJORNAME,COLLEGEID) VALUES(?,?,?)";
		}
		con = DBUtils.getConnection();
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, major.getMajorNumber());
			pstmt.setString(2, major.getMajorName());
			if(major.getCollegeID()!=null){
				pstmt.setInt(3, major.getCollegeID());
			}
			else pstmt.setString(3, null);
			if (major.getId() != null) {
				pstmt.setInt(4, major.getId());
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
//查看所有专业
	public List<Major> getAllMajor() {
		List<Major> majorList=new ArrayList<Major>();
		Major major=null;
		String SQL = "SELECT * FROM MAJOR";
		con=DBUtils.getConnection();
		try {
			pstmt=con.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			while(rs.next()){
				major=new Major();
				major.setId(rs.getInt("ID"));
				major.setMajorNumber(rs.getString("MAJORNUM"));
				major.setMajorName(rs.getString("MAJORNAME"));
				major.setCollegeID(rs.getInt("collegeID"));
				majorList.add(major);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return majorList;
	}
	//删除某一专业
	public boolean deleteMajorByID(Integer majorID){
		boolean result=false;
		con=DBUtils.getConnection();
		try {
			pstmt=con.prepareStatement("DELETE FROM MAJOR WHERE ID=?");
			pstmt.setInt(1, majorID);
			if(pstmt.executeUpdate()==1){
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Major getMajorByID(Integer id) {
		
		Major major=null;
		String SQL = "SELECT * FROM MAJOR WHERE ID=?";
		con=DBUtils.getConnection();
		try {
			pstmt=con.prepareStatement(SQL);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				major=new Major();
				major.setId(rs.getInt("ID"));
				major.setMajorNumber(rs.getString("MAJORNUM"));
				major.setMajorName(rs.getString("MAJORNAME"));
				major.setCollegeID(rs.getInt("collegeID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return major;
	}
	
	public List<Major> getAllMajorByCollegeID(Integer id) {
		List<Major> majorList=new ArrayList<Major>();
		Major major=null;
		String SQL = "SELECT * FROM MAJOR WHERE COLLEGEID=? ";
		con=DBUtils.getConnection();
		try {
			pstmt=con.prepareStatement(SQL);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				major=new Major();
				major.setId(rs.getInt("ID"));
				major.setMajorNumber(rs.getString("MAJORNUM"));
				major.setMajorName(rs.getString("MAJORNAME"));
				major.setCollegeID(rs.getInt("collegeID"));
				majorList.add(major);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return majorList;
	}
	
	
}
