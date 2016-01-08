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
table th {
	text-align:left;
}
</style>
  </head>
  
  <body>
   
  
  <%	Student student = (Student)session.getAttribute("currentStudent");
		StudentDao studentDao = new StudentDao();
		 Integer classID=student.getNowclassID();
		 ClassDao classDao=new ClassDao();
		 CClass cclass=classDao.getClassByID(classID);
		MajorDao majorDao=new MajorDao();
		Major major=majorDao.getMajorByID(cclass.getMajorID());
		CollegeDao collegeDao=new CollegeDao();
		College college=collegeDao.getCollegeByID(major.getCollegeID());
	%>
 
  <h2>学籍信息：</h2>
 
	<table width="800px" border="2" cellpadding="6" cellspacing="5">
		 <tr>  <th>姓名</th> <td> <%=student.getName()==null?"":student.getName() %></td>  <th>学号 </th> <td> <%=student.getStudentNumber()==null?"":student.getStudentNumber() %></td>  </tr>
		 <tr>  <th>性别</th>  <td> <%=student.getSex()==null?"":student.getSex() %></td>  <th>入学日期 </th> <td> <%=student.getEntranceDate()==null?"":student.getEntranceDate()  %></td></tr>
		 <tr><th>身份证号码</th> <td> <%=student.getCardnumber()==null?"":student.getCardnumber() %></td>  <th>学院</th> <td> <%=college.getCollegeName()==null?"":college.getCollegeName() %></td></tr>
		 <tr><th>住址</th> <td> <%=student.getAddress()==null?"":student.getAddress() %></td>  <th>专业</th> <td> <%=major.getMajorName()==null?"":major.getMajorName() %></td></tr>
		 <tr><th>民族</th> <td> <%=student.getNation()==null?"":student.getNation() %></td>  <th>班级</th> <td> <%=cclass.getName()==null?"":cclass.getName() %></td></tr>
		 <tr><th>电话号码</th><td> <%=student.getPhoneNumber()==null?"":student.getPhoneNumber() %></td>  <th>政治面貌</th> <td> <%=student.getPolitical()==null?"":student.getPolitical() %></td></tr>
		
	</table><br />
  </body>
</html>
