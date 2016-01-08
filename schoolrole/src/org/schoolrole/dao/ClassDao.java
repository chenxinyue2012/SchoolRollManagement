package org.schoolrole.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.schoolrole.model.CClass;
import org.schoolrole.utils.DBUtils;

public class ClassDao {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 更新或添加
	public boolean saveUpdate(CClass cclass) {
		boolean result = false;
		String SQL = "INSERT INTO CLASS(CLASSNUM,CLASSNAME,MAJORID) VALUES(?,?,?)";
		if (cclass.getId() != null) 
			 SQL = "UPDATE CLASS SET CLASSNUM=?,CLASSNAME=?,MAJORID=? WHERE ID=?";
		
		con = DBUtils.getConnection();
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, cclass.getClassNumber());
			pstmt.setString(2, cclass.getName());
			pstmt.setInt(3, cclass.getMajorID());
			
			if (cclass.getId() != null) {
				pstmt.setInt(4, cclass.getId());
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

	// 查看所有班级
	public List<CClass> getAllClass() {
		List<CClass> classList = new ArrayList<CClass>();
		CClass cclass = null;
		String SQL = "SELECT * FROM CLASS";
		con = DBUtils.getConnection();
		try {
			pstmt = con.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cclass = new CClass();
				cclass.setId(rs.getInt("ID"));
				cclass.setClassNumber(rs.getString("CLASSNUM"));
				cclass.setName(rs.getString("CLASSNAME"));
				cclass.setMajorID(rs.getInt("MAJORID"));
				classList.add(cclass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classList;
	}

	// 删除某一班级
	public boolean deleteClassByID(Integer classID) {
		boolean result = false;
		con = DBUtils.getConnection();
		try {
			pstmt = con.prepareStatement("DELETE FROM CLASS WHERE ID=?  ");
			pstmt.setInt(1, classID);
			if (pstmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public CClass getClassByID(Integer id) {

		CClass cclass = null;
		String SQL = "SELECT * FROM CLASS WHERE ID=?";
		con = DBUtils.getConnection();
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cclass = new CClass();
				cclass.setId(rs.getInt("ID"));
				cclass.setClassNumber(rs.getString("CLASSNUM"));
				cclass.setName(rs.getString("CLASSNAME"));
				cclass.setMajorID(rs.getInt("MAJORID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cclass;
	}
	public CClass getClassByNum(String numb) {

		CClass cclass = null;
		String SQL = "SELECT * FROM CLASS WHERE CLASSNUM=?";
		con = DBUtils.getConnection();
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, numb);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cclass = new CClass();
				cclass.setId(rs.getInt("ID"));
				cclass.setClassNumber(rs.getString("CLASSNUM"));
				cclass.setName(rs.getString("CLASSNAME"));
				cclass.setMajorID(rs.getInt("MAJORID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cclass;
	}
}
