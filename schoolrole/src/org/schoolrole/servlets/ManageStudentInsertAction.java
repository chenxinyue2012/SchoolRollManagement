package org.schoolrole.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.schoolrole.dao.StudentDao;
import org.schoolrole.model.Student;
import org.schoolrole.utils.DateUtils;

public class ManageStudentInsertAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ManageStudentInsertAction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Student student=new Student();
		  StudentDao studao=new StudentDao();
		  //学号
		   student.setStudentNumber(request.getParameter("stuNum"));
		   //姓名
		   String stuName = new String(request.getParameter("stuName").getBytes("ISO-8859-1"),"utf-8");
		   student.setName(stuName);
		   //性别
		   student.setSex(request.getParameter("sex").equals("women")?"女":"男");
		  //民族
		   String stuNation = new String(request.getParameter("stuNation").getBytes("ISO-8859-1"),"utf-8");
		   student.setNation(stuNation);
		   //身份证号
		   student.setCardnumber(request.getParameter("stuCardNum"));
		
		   //家庭住址
		   String stuAddress = new String(request.getParameter("stuAddress").getBytes("ISO-8859-1"),"utf-8");
		   student.setAddress(stuAddress);//stuPhoneNum
		   //电话号码
		   student.setPhoneNumber(request.getParameter("stuPhoneNum"));//stuPhoneNum
		  
		   //政治面貌
		   String stuPolitical = new String(request.getParameter("stuPolitical").getBytes("ISO-8859-1"),"utf-8");
		   student.setPolitical(stuPolitical);
		   
		   //入学日期
		   student.setEntranceDate(DateUtils.parseDate(request.getParameter("stuEntrance")));
		   
		   //登录密码
		   student.setPassword(request.getParameter("stuPasswd"));
		   
		   //所在班级
		   student.setNowclassID(Integer.valueOf(request.getParameter("classSelect")));
		   
		   if(studao.insertStudent(student)==true){
			   out.print("插入成功");
		   } else{
			   out.print("插入失败");
		   }
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
