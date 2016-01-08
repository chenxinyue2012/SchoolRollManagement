package org.schoolrole.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.schoolrole.model.CClass;
import org.schoolrole.model.ChangeMessage;
import org.schoolrole.utils.DBUtils;

public class ChangeSchoolRolDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public boolean saveUpdateCM(ChangeMessage changeMess){
		boolean result = false;
		boolean sturesult = false;
		String SQL = "INSERT INTO CHANGEMESSAGE(DATE,CHANGENUM,TYPE,REASON," +
				"BACKDATE,OLDCLASSID,NEWCLASSID,STUID) VALUES(?,?,?,?,?,?,?,?)";
		if (changeMess.getId() != null) {
			SQL = "UPDATE CHANGEMESSAGE SET DATE=?,CHANGENUM=?,TYPE=?,REASON=?," +
				"BACKDATE=?,OLDCLASSID=?,NEWCLASSID=?,STUID=? WHERE ID=?";
		}
		con = DBUtils.getConnection();
		try {
			con.setAutoCommit(false);//事务 取消自动提交
			pstmt = con.prepareStatement(SQL);
			pstmt.setDate(1, new java.sql.Date(changeMess.getChangeDate().getTime()));
			pstmt.setString(2, changeMess.getChangeNumber());
			pstmt.setString(3, changeMess.getType());
			pstmt.setString(4, changeMess.getReason());
			pstmt.setDate(5, new java.sql.Date(changeMess.getBackDate().getTime()));
			pstmt.setInt(6, changeMess.getOldClassID());
			pstmt.setInt(7, changeMess.getNewClassID());
			pstmt.setInt(8, changeMess.getStudentID());
		    if(changeMess.getId()!=null){
		    	pstmt.setInt(9, changeMess.getId());
		    }
			if (pstmt.executeUpdate() == 1) {
				result = true;
			}
			//修改学生信息
			SQL="UPDATE STUDENT SET CLASSID=? WHERE ID=? ";
			 PreparedStatement  pstmt1 = con.prepareStatement(SQL);
			pstmt1.setInt(1, changeMess.getNewClassID());
			pstmt1.setInt(2, changeMess.getStudentID());
			if (pstmt1.executeUpdate() == 1) {
				sturesult = true;
			}
			con.commit();//当程序执行完后就提交，否则不提交修改
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (result&&sturesult);
	}
	public List<ChangeMessage> getAllChangeMess() {
		List<ChangeMessage> cMList=new ArrayList<ChangeMessage>();
		ChangeMessage changeMess=null;
		String SQL = "SELECT * FROM CHANGEMESSAGE";
		con=DBUtils.getConnection();
		try {
			pstmt=con.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			while(rs.next()){
				changeMess=new ChangeMessage();
				changeMess.setId(rs.getInt("id"));
				changeMess.setChangeDate(rs.getDate("DATE"));
				changeMess.setChangeNumber(rs.getString("changeNum"));
				changeMess.setType(rs.getString("type"));
				changeMess.setReason(rs.getString("reason"));
				changeMess.setBackDate(rs.getDate("backDate"));
				changeMess.setOldClassID(rs.getInt("oldClassID"));
				changeMess.setNewClassID(rs.getInt("NEWCLASSID"));
				changeMess.setStudentID(rs.getInt("stuID"));
				cMList.add(changeMess);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cMList;
	}
	public List<ChangeMessage> getChangeMessByStuID(Integer stuID) {
		List<ChangeMessage> cMList=new ArrayList<ChangeMessage>();
		ChangeMessage changeMess=null;
		String SQL = "SELECT * FROM CHANGEMESSAGE WHERE STUID=?";
		con=DBUtils.getConnection();
		try {
			pstmt=con.prepareStatement(SQL);
			pstmt.setInt(1, stuID);
			rs=pstmt.executeQuery();
			if(rs.next()){
				changeMess=new ChangeMessage();
				changeMess.setId(rs.getInt("id"));
				changeMess.setChangeDate(rs.getDate("DATE"));
				changeMess.setChangeNumber(rs.getString("changeNum"));
				changeMess.setType(rs.getString("type"));
				changeMess.setReason(rs.getString("reason"));
				changeMess.setBackDate(rs.getDate("backDate"));
				changeMess.setOldClassID(rs.getInt("oldClassID"));
				changeMess.setNewClassID(rs.getInt("NEWCLASSID"));
				changeMess.setStudentID(rs.getInt("stuID"));
				cMList.add(changeMess);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cMList;
	}
	public ChangeMessage getChangeMessByID(Integer stuID) {
		
		ChangeMessage changeMess=null;
		String SQL = "SELECT * FROM CHANGEMESSAGE WHERE ID=?";
		con=DBUtils.getConnection();
		try {
			pstmt=con.prepareStatement(SQL);
			pstmt.setInt(1, stuID);
			rs=pstmt.executeQuery();
			if(rs.next()){
				changeMess=new ChangeMessage();
				changeMess.setId(rs.getInt("id"));
				changeMess.setChangeDate(rs.getDate("DATE"));
				changeMess.setChangeNumber(rs.getString("changeNum"));
				changeMess.setType(rs.getString("type"));
				changeMess.setReason(rs.getString("reason"));
				changeMess.setBackDate(rs.getDate("backDate"));
				changeMess.setOldClassID(rs.getInt("oldClassID"));
				changeMess.setNewClassID(rs.getInt("NEWCLASSID"));
				changeMess.setStudentID(rs.getInt("stuID"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return changeMess;
	}
	
}
