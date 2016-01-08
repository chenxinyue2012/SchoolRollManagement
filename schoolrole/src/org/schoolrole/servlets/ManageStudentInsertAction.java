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
		  //ѧ��
		   student.setStudentNumber(request.getParameter("stuNum"));
		   //����
		   String stuName = new String(request.getParameter("stuName").getBytes("ISO-8859-1"),"utf-8");
		   student.setName(stuName);
		   //�Ա�
		   student.setSex(request.getParameter("sex").equals("women")?"Ů":"��");
		  //����
		   String stuNation = new String(request.getParameter("stuNation").getBytes("ISO-8859-1"),"utf-8");
		   student.setNation(stuNation);
		   //���֤��
		   student.setCardnumber(request.getParameter("stuCardNum"));
		
		   //��ͥסַ
		   String stuAddress = new String(request.getParameter("stuAddress").getBytes("ISO-8859-1"),"utf-8");
		   student.setAddress(stuAddress);//stuPhoneNum
		   //�绰����
		   student.setPhoneNumber(request.getParameter("stuPhoneNum"));//stuPhoneNum
		  
		   //������ò
		   String stuPolitical = new String(request.getParameter("stuPolitical").getBytes("ISO-8859-1"),"utf-8");
		   student.setPolitical(stuPolitical);
		   
		   //��ѧ����
		   student.setEntranceDate(DateUtils.parseDate(request.getParameter("stuEntrance")));
		   
		   //��¼����
		   student.setPassword(request.getParameter("stuPasswd"));
		   
		   //���ڰ༶
		   student.setNowclassID(Integer.valueOf(request.getParameter("classSelect")));
		   
		   if(studao.insertStudent(student)==true){
			   out.print("����ɹ�");
		   } else{
			   out.print("����ʧ��");
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
