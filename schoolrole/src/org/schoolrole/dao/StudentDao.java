package org.schoolrole.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.schoolrole.model.CClass;
import org.schoolrole.model.College;
import org.schoolrole.model.Major;
import org.schoolrole.model.Student;
import org.schoolrole.utils.DBUtils;

public class StudentDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public Student getStudentByStuNum(String stuNum) {
		Student student = null;
		try {
			con = DBUtils.getConnection();//连接数据库
			
			pstmt = con
					.prepareStatement("SELECT * FROM STUDENT WHERE stuNum=?");
			pstmt.setString(1, stuNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				student=new Student();
				student.setId(rs.getInt("id"));
				student.setStudentNumber(rs.getString("stuNum"));
				student.setName(rs.getString("stuName"));
				student.setCardnumber(rs.getString("cardNum"));
				student.setAddress(rs.getString("address"));
				student.setNation(rs.getString("nation"));
				student.setPhoneNumber(rs.getString("phoneNum"));
				student.setPolitical(rs.getString("political"));
				student.setEntranceDate(rs.getDate("entranceDate"));
				student.setSex(rs.getString("sex"));
				student.setPassword(rs.getString("password"));
				student.setNowclassID(rs.getInt("classID"));
				
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;

	}
	public Student getStudentByStuID(Integer id) {
		Student student = null;
		try {
			con = DBUtils.getConnection();//连接数据库
			
			pstmt = con
					.prepareStatement("SELECT * FROM STUDENT WHERE ID=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				student=new Student();
				student.setId(rs.getInt("id"));
				student.setStudentNumber(rs.getString("stuNum"));
				student.setName(rs.getString("stuName"));
				student.setCardnumber(rs.getString("cardNum"));
				student.setAddress(rs.getString("address"));
				student.setNation(rs.getString("nation"));
				student.setPhoneNumber(rs.getString("phoneNum"));
				student.setPolitical(rs.getString("political"));
				student.setEntranceDate(rs.getDate("entranceDate"));
				student.setSex(rs.getString("sex"));
				student.setPassword(rs.getString("password"));
				student.setNowclassID(rs.getInt("classID"));
				
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;

	}
	public List<Student> getAllStudent() {
		List<Student> stuList = new ArrayList<Student>();
		Student student =null;
		con = DBUtils.getConnection();
		try {
			pstmt = con.prepareStatement("SELECT * FROM STUDENT");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setStudentNumber(rs.getString("stuNum"));
				student.setName(rs.getString("stuName"));
				student.setCardnumber(rs.getString("cardNum"));
				student.setAddress(rs.getString("address"));
				student.setNation(rs.getString("nation"));
				student.setPhoneNumber(rs.getString("phoneNum"));
				student.setPolitical(rs.getString("political"));
				student.setEntranceDate(rs.getDate("entranceDate"));
				student.setSex(rs.getString("sex"));
				student.setPassword(rs.getString("password"));
				student.setNowclassID(rs.getInt("classID"));
				stuList.add(student);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stuList;
	}

	public boolean insertStudent(Student student) {
		boolean result = false;
		String SQL = "INSERT INTO STUDENT(STUNUM,STUNAME,CARDNUM,ADDRESS,NATION,PHONENUM,"
				+ "POLITICAL,ENTRANCEDATE,CLASSID,SEX,PASSWORD)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		con = DBUtils.getConnection();
		try {
				pstmt = con.prepareStatement(SQL);
				pstmt.setString(1, student.getStudentNumber());
				pstmt.setString(2, student.getName());
				pstmt.setString(3, student.getCardnumber());
				pstmt.setString(4, student.getAddress());
				pstmt.setString(5, student.getNation());
				pstmt.setString(6, student.getPhoneNumber());
				pstmt.setString(7, student.getPolitical());
				pstmt.setDate(8, new java.sql.Date(student.getEntranceDate().getTime()));
				if(student.getNowclassID()!=null){
					pstmt.setInt(9, student.getNowclassID());
				}
				else pstmt.setString(9, null);
				pstmt.setString(10, student.getSex());
				pstmt.setString(11, student.getPassword());
				if(pstmt.executeUpdate()==1){
					result=true;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public boolean stuChangePasswd(Integer id,String password){
		boolean result = false;
		String SQL="UPDATE STUDENT SET PASSWORD=? WHERE ID=?";
		
		con=DBUtils.getConnection();
		try {
			con.setAutoCommit(false);//事务 取消自动提交
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1, password);
			pstmt.setInt(2, id);
			if(pstmt.executeUpdate()==1){
				result=true;
			}
			con.commit();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public Student login(String loginName,String password){
		Student student=null;
		try {
			con = DBUtils.getConnection();//连接数据库
			pstmt = con
					.prepareStatement("SELECT * FROM STUDENT WHERE stuNum=? AND password=?");
			pstmt.setString(1, loginName);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				student=new Student();
				student.setId(rs.getInt("id"));
				student.setStudentNumber(rs.getString("stuNum"));
				student.setName(rs.getString("stuName"));
				student.setCardnumber(rs.getString("cardNum"));
				student.setAddress(rs.getString("address"));
				student.setNation(rs.getString("nation"));
				student.setPhoneNumber(rs.getString("phoneNum"));
				student.setPolitical(rs.getString("political"));
				student.setEntranceDate(rs.getDate("entranceDate"));
				student.setSex(rs.getString("sex"));
				student.setPassword(rs.getString("password"));
				student.setNowclassID(rs.getInt("classID"));
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
		
	}
	
	
}
