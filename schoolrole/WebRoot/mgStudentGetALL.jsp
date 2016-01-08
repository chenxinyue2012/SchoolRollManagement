<%@page contentType="text/html; charset=utf-8"%>
<%@page import="org.schoolrole.dao.StudentDao"%>
<%@page import="org.schoolrole.model.Student"%>
<%@page import="org.schoolrole.model.College"%>
<%@page import="org.schoolrole.model.CClass"%>
<%@page import="org.schoolrole.model.Major"%>
<%@page import="org.schoolrole.dao.ClassDao"%>
<%@page import="org.schoolrole.dao.MajorDao"%>
<%@page import="org.schoolrole.dao.CollegeDao"%>
<html>
  <head>
   
    <title>My JSP 'stuDetailMessage.jsp' starting page</title>
   <style type="text/css">
   table {
	margin-top:30px;
	border-collapse:collapse;
	font-size:14px;

}
   </style>
  </head>
  
  <body >
   
  <%
		StudentDao studentDao = new StudentDao();
		 ClassDao classDao=new ClassDao();
		 CClass cclass;
		MajorDao majorDao=new MajorDao();
		Major major;
		CollegeDao collegeDao=new CollegeDao();
		College college;
	%>
 
  <H2>所有学生学籍信息：</H2><br><br>
 
	
	<%for(Student student:studentDao.getAllStudent()) {
	 cclass=new CClass();
	cclass=classDao.getClassByID(student.getNowclassID());
    major=new Major();
    major=majorDao.getMajorByID(cclass.getMajorID());
	college=new College();
	college=collegeDao.getCollegeByID(major.getCollegeID());
    %>
 
	
	
	<table width="800px" border="2" cellpadding="6" cellspacing="5" bordercolor="#34587C">
		 <tr>  <td>姓名</td> <td> <%=student.getName() %></td>  <td>学号 </td> <td> <%=student.getStudentNumber() %></td>  </tr>
		 <tr>  <td>性别</td>  <td> <%=student.getSex() %></td>  <td>入学日期 </td> <td> <%=student.getEntranceDate()  %></td></tr>
		 <tr><td>身份证号码</td> <td> <%=student.getCardnumber() %></td>  
		 <td>学院</td><td> <%=college.getCollegeName() %></td></tr>
		 <tr><td>住址</td> <td> <%=student.getAddress()%></td><td>专业</td> <td> <%=major.getMajorName() %></td></tr>
		 <tr><td>民族</td> <td> <%=student.getNation() %></td><td>班级</td> <td> <%=cclass.getName() %></td></tr>
		 <tr><td>电话号码</td><td><%=student.getPhoneNumber() %></td><td>政治面貌</td><td><%=student.getPolitical() %></td>
	</table><br><br>
	<%} %>
      
  
  
  </body>
</html>
