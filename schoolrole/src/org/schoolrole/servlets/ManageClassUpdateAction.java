package org.schoolrole.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.schoolrole.dao.ClassDao;
import org.schoolrole.model.CClass;

public class ManageClassUpdateAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ManageClassUpdateAction() {
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
		Integer id=Integer.valueOf(request.getParameter("id"));
		String classNum=request.getParameter("classNum");
		String className = new String(request.getParameter("className").getBytes("ISO-8859-1"),"utf-8");
		Integer majorID=Integer.valueOf(request.getParameter("majorSelect"));
		  CClass cclass=new CClass();
		  cclass.setId(id);
		  cclass.setClassNumber(classNum);
		  cclass.setMajorID(majorID);
		  cclass.setName(className);
		  ClassDao classDao=new ClassDao();
		  if(classDao.saveUpdate(cclass)==false){
		 out.print("����ʧ��!");
		}else {
		 out.print("���³ɹ�!");
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
