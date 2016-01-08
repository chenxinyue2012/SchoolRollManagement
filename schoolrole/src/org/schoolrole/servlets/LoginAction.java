package org.schoolrole.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 import org.schoolrole.dao.StudentDao;
 import org.schoolrole.dao.ManagerDao;
 import org.schoolrole.model.Manager;
 import org.schoolrole.model.Student;

public class LoginAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginAction() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String passwd = request.getParameter("passwd");
		String role = request.getParameter("role");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		if (role.equals("student")) {
			StudentDao studentDao = new StudentDao();
			Student student = studentDao.login(userName, passwd);
			if (student == null) {
				out.print("studentFail");
			}  if(student != null) {
		
				session.setAttribute("currentStudent", student);
				out.print("studentSuccess");
				
			}
		}
		if (role.equals("manager")) {
			ManagerDao managerDao = new ManagerDao();
			Manager manager = managerDao.login(userName, passwd);
			if (manager == null) {
				out.print("managerFail");
			} else {
				session.setAttribute("currentManager", manager);
				out.print("managerSuccess");
				
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
