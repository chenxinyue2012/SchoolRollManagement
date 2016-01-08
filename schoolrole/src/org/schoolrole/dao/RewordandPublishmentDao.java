package org.schoolrole.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.schoolrole.model.ChangeMessage;
import org.schoolrole.model.RewordorPublishment;
import org.schoolrole.utils.DBUtils;

public class RewordandPublishmentDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public boolean insertRewPub(RewordorPublishment rePub){
		boolean result = false;
		String SQL = "INSERT INTO REWORDORPUBLISHMENT(REPUBDATE,REASON,REWORDPUBLISH,OTHERMESS,STUID,number)" +
				" VALUES(?,?,?,?,?,?)";
		
		con = DBUtils.getConnection();
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setDate(1, new java.sql.Date(rePub.getDate().getTime()));
			pstmt.setString(2, rePub.getReason());
			pstmt.setInt(3,rePub.isReorPublish());
			pstmt.setString(4, rePub.getOther());
			pstmt.setInt(5, rePub.getStudentID());
			pstmt.setString(6, rePub.getNum());
			if (pstmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public List<RewordorPublishment> getRePubByStuID(Integer stuID) {
		List<RewordorPublishment> rewordPubList=new ArrayList<RewordorPublishment>();
		RewordorPublishment rePub;
		String SQL = "SELECT * FROM REWORDORPUBLISHMENT WHERE STUID=?";
		con=DBUtils.getConnection();
		try {
			pstmt=con.prepareStatement(SQL);
			pstmt.setInt(1, stuID);
			rs=pstmt.executeQuery();
			while(rs.next()){
				 rePub=new RewordorPublishment();
				rePub.setId(rs.getInt("id"));
				rePub.setDate(rs.getDate("repubDate"));
				rePub.setReason(rs.getString("reason"));
				rePub.setReorPublish(rs.getInt("rewordPublish"));
				rePub.setOther(rs.getString("otherMess"));
				rePub.setStudentID(rs.getInt("stuID"));
				rePub.setNum(rs.getString("number"));
				rewordPubList.add(rePub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rewordPubList;
	}
	public List<RewordorPublishment> getRePub() {
		List<RewordorPublishment> rewordPubList=new ArrayList<RewordorPublishment>();
		RewordorPublishment rePub;
		String SQL = "SELECT * FROM REWORDORPUBLISHMENT ";
		con=DBUtils.getConnection();
		try {
			pstmt=con.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			while(rs.next()){
				rePub=new RewordorPublishment();
				rePub.setId(rs.getInt("id"));
				rePub.setDate(rs.getDate("repubDate"));
				rePub.setReason(rs.getString("reason"));
				rePub.setReorPublish(rs.getInt("rewordPublish"));
				rePub.setOther(rs.getString("otherMess"));
				rePub.setStudentID(rs.getInt("stuID"));
				rePub.setNum(rs.getString("number"));
				rewordPubList.add(rePub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rewordPubList;
	}
	
	public RewordorPublishment getRePub(Integer ID) {
		RewordorPublishment rePub=null;
		String SQL = "SELECT * FROM REWORDORPUBLISHMENT WHERE ID=?";
		con=DBUtils.getConnection();
		try {
			pstmt=con.prepareStatement(SQL);
			pstmt.setInt(1, ID);
			rs=pstmt.executeQuery();
			while(rs.next()){
				rePub=new RewordorPublishment();
				rePub.setId(rs.getInt("id"));
				rePub.setDate(rs.getDate("repubDate"));
				rePub.setReason(rs.getString("reason"));
				rePub.setReorPublish(rs.getInt("rewordPublish"));
				rePub.setOther(rs.getString("otherMess"));
				rePub.setStudentID(rs.getInt("stuID"));
				rePub.setNum(rs.getString("number"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rePub;
	}
}
