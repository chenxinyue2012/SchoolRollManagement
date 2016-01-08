<%@page contentType="text/html; charset=utf-8"%>
<%@page import="org.schoolrole.dao.ManagerDao"%>
<%@page import="org.schoolrole.model.Manager"%>
<html>
  <head>
    <title>My JSP 'checkChangemanager.jsp' starting page</title>

  </head>
  
  <body>
   <%
				Manager manager = (Manager)session.getAttribute("currentManager");
			
		
			
					
     
     String nowPasswd=request.getParameter("nowpasswd");
      String newPasswd=request.getParameter("newpasswd");
       String checkNewPasswd=request.getParameter("checknewpasswd");
       if(nowPasswd.equals("")||nowPasswd.equals(null)||!nowPasswd.equals(manager.getPassword())){
        %>
              当前密码错误！ <a href="manageChangePassword.jsp" >返回 </a>
         <%return;
       }
       else if(newPasswd!=null&&checkNewPasswd!=null&&newPasswd.equals(checkNewPasswd)){
       ManagerDao managerDao=new ManagerDao();
       if(managerDao.passUpdate(manager.getId(), newPasswd)==true){;
    %>  修改成功！ 
   <% return;}}   %> 两次输入的新密码不相同！ 
   
    <br>
  </body>
</html>
