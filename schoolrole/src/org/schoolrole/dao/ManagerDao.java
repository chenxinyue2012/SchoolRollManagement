package org.schoolrole.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.schoolrole.model.Manager;
import org.schoolrole.utils.DBUtils;



public class ManagerDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Manager getMessageByNum(Integer id){
		Manager manager=null;
		String SQL="SELECT * FROM MANAGER WHERE ID=?";
		con=DBUtils.getConnection();
		try {
			pstmt=con.prepareStatement(SQL);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				manager=new Manager();
				manager.setId(rs.getInt("id"));
				manager.setUserName(rs.getString("loginname"));
				manager.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manager;
	}
	public boolean saveUpdate(Manager manager){
		boolean result = false;
		String SQL="UPDATE MANAGER SET loginName=?,password=? WHERE ID=?";
		if(manager.getId()==null){
			SQL="INSERT INTO MANAGER(loginName,password) VALUES(?,?)";
		}
		con=DBUtils.getConnection();
		try {
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1, manager.getUserName());
			pstmt.setString(2, manager.getPassword());
			if(manager.getId()!=null){
				pstmt.setInt(3, manager.getId());
			}
			if(pstmt.executeUpdate()==1){
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public boolean deleteManage(Integer managerID){
		boolean result=false;
		con=DBUtils.getConnection();
		try {
			pstmt=con.prepareStatement("DELETE FROM MANAGER WHERE ID=?");
			pstmt.setInt(1, managerID);
			if(pstmt.executeUpdate()==1){
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public Manager login(String loginName,String password){
		Manager manager=null;
		String SQL="SELECT * FROM MANAGER WHERE loginName=? AND password=?";
		con=DBUtils.getConnection();
		try {
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1, loginName);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()){
				manager=new Manager();
				manager.setId(rs.getInt("id"));
				manager.setUserName(rs.getString("loginname"));
				manager.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manager;
	}
	
	public boolean passUpdate(Integer id,String password){
		boolean result = false;
		String SQL="UPDATE MANAGER SET password=? WHERE ID=?";
		con=DBUtils.getConnection();
		try {
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1,password);
			pstmt.setInt (2, id);
			if(pstmt.executeUpdate()==1){
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	

}
