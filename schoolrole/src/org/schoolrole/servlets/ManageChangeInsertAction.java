package org.schoolrole.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.schoolrole.dao.ChangeSchoolRolDao;
import org.schoolrole.dao.ClassDao;
import org.schoolrole.dao.StudentDao;
import org.schoolrole.model.CClass;
import org.schoolrole.model.ChangeMessage;
import org.schoolrole.model.Student;
import org.schoolrole.utils.DateUtils;

public class ManageChangeInsertAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ManageChangeInsertAction() {
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
		
		StudentDao studentdao = new StudentDao();
		ClassDao classDao = new ClassDao();
		ChangeMessage change = new ChangeMessage();
		CClass cclass = new CClass();
		ChangeSchoolRolDao changeDao = new ChangeSchoolRolDao();
		String stunum=request.getParameter("stunum");
		if(studentdao.getStudentByStuNum(stunum)==null){
			out.print("没有此学号的学生！"); 
		}
		else{
			Student student=new Student();
			student=studentdao.getStudentByStuNum(stunum);
			change.setStudentID(student.getId());
			change.setChangeDate(DateUtils.parseDate(request
					.getParameter("ChangeDate")));
			change.setChangeNumber(request.getParameter("ChangeNumber"));
			
			String type = new String(request.getParameter("Type").getBytes("ISO-8859-1"),"utf-8"); 
			change.setType(type);
			String reason = new String(request.getParameter("Reason").getBytes("ISO-8859-1"),"utf-8");
			change.setReason(reason);
			
			change.setBackDate(DateUtils.parseDate(request
					.getParameter("BackDate")));
			change.setOldClassID(Integer.valueOf(request
					.getParameter("oldclass")));
			change.setNewClassID(Integer.valueOf(request
					.getParameter("nowclass")));
					if(false==changeDao.saveUpdateCM(change)){
						out.print("添加失败！"); 
					}else{
						out.print("添加成功！"); 
					}	
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
