package org.schoolrole.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.schoolrole.dao.RewordandPublishmentDao;
import org.schoolrole.dao.StudentDao;
import org.schoolrole.model.RewordorPublishment;
import org.schoolrole.model.Student;
import org.schoolrole.utils.DateUtils;

public class ManageRewPublishAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ManageRewPublishAction() {
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
		
		/*String theid=request.getParameter("id");
		Integer id =null;
		if(theid != null && !"".equals(theid)){
		id= Integer.valueOf(request.getParameter("id"));
		}*/
		String stunum=request.getParameter("stunum");
		StudentDao studentdao=new StudentDao();
		RewordandPublishmentDao RePubDao = new RewordandPublishmentDao();
		Student student=studentdao.getStudentByStuNum(stunum);
		RewordorPublishment repub=new RewordorPublishment();
			int result;
			if(student==null){
			out.print("没有此学号的学生！");
			}
			else{ repub.setStudentID(student.getId());
			/*if (id != null) {
				repub.setId(id);
			}*/
			repub.setNum(request.getParameter("repubnum"));
			repub.setDate(DateUtils.parseDate(request.getParameter("ReDate")));
			String reason = new String(request.getParameter("Reason").getBytes("ISO-8859-1"),"utf-8");
			repub.setReason(reason);
			repub.setReorPublish(Integer.valueOf(request.getParameter("reword")) );	
			String other = new String(request.getParameter("other").getBytes("ISO-8859-1"),"utf-8");
			repub.setOther(other) ; 	
			if(RePubDao.insertRewPub(repub)==false){
				out.print("提交失败！");
			}else {
				out.print("提交成功！");
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
