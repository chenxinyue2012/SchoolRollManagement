<%@page contentType="text/html; charset=utf-8"%>
<%@page import="org.schoolrole.dao.StudentDao"%>
<%@page import="org.schoolrole.model.Student"%>
<html>
  <head>
    <title>My JSP 'checkChange.jsp' starting page</title>

  </head>
  
  <body>
    
     <%
     Student student = (Student)session.getAttribute("currentStudent");
     String nowPasswd=request.getParameter("nowpasswd");
      String newPasswd=request.getParameter("newpasswd");
       String checkNewPasswd=request.getParameter("checknewpasswd");
       if(nowPasswd.equals("")||nowPasswd.equals(null)||!nowPasswd.equals(student.getPassword())){
        %>
              当前密码错误！ <a href="stuChangePassword.jsp" >返回 </a>
         <%return;
       }
       else if(newPasswd!=null&&checkNewPasswd!=null&&newPasswd.equals(checkNewPasswd)){
       StudentDao studentDao=new StudentDao();
       if(studentDao.stuChangePasswd(student.getId(), newPasswd)==true){;
    %>  修改成功！ <a href="studentMessage.jsp" >返回 </a>
   <% return;}}   %> 两次输入的新密码不相同！ <a href="stuChangePassword.jsp" >返回 </a>
   
    <br>
  </body>
</html>
