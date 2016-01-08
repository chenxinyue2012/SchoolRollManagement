package org.schoolrole.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.schoolrole.dao.StudentDao;
import org.schoolrole.model.Student;

public class StuPwdChangeAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public StuPwdChangeAction() {
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
		HttpSession  session = request.getSession();
	     Student student = (Student)session.getAttribute("currentStudent");
	     String nowPasswd=request.getParameter("nowpasswd");
	      String newPasswd=request.getParameter("newpasswd");
	       String checkNewPasswd=request.getParameter("checknewpasswd");
	       if(nowPasswd.equals("")||nowPasswd.equals(null)||!nowPasswd.equals(student.getPassword())){
	        
	            out.print("当前密码错误!");  
	      
	       }
	       else if(newPasswd!=null&&checkNewPasswd!=null&&newPasswd.equals(checkNewPasswd)){
	       StudentDao studentDao=new StudentDao();
	       if(studentDao.stuChangePasswd(student.getId(), newPasswd)==true){
	    	   out.print("修改成功！"); 
	  
	       }
	       }
	       else {
	    	   out.print("两次输入的新密码不相同！");
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
