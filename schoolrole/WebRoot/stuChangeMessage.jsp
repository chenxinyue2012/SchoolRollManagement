<%@page contentType="text/html; charset=utf-8"%>
<%@page import="org.schoolrole.dao.ChangeSchoolRolDao"%>
<%@page import="org.schoolrole.model.ChangeMessage"%>
<%@page import="org.schoolrole.model.College"%>
<%@page import="org.schoolrole.model.CClass"%>
<%@page import="org.schoolrole.model.Major"%>
<%@page import="org.schoolrole.model.Student"%>
<%@page import="org.schoolrole.dao.ClassDao"%>
<%@page import="org.schoolrole.dao.MajorDao"%>
<%@page import="org.schoolrole.dao.CollegeDao"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>My JSP 'stuChangeMessage.jsp' starting page</title>
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


	
<%		Student student = (Student)session.getAttribute("currentStudent");
        Integer studentID=student.getId();
		ChangeSchoolRolDao changeSchoolRolDao=new ChangeSchoolRolDao();
		 List<ChangeMessage> changeMessList=changeSchoolRolDao.getChangeMessByStuID(studentID);
		 ClassDao classDao=new ClassDao();
		 CClass cclass=new CClass();//classDao.getClassByID(changeMessage.getOldClassID());
		MajorDao majorDao=new MajorDao();
		Major major=new Major();// majorDao.getMajorByID(cclass.getMajorID());
		CollegeDao collegeDao=new CollegeDao();
		College college=new College();//.getCollegeByID(major.getCollegeID());
	%>
	
	<h2>学籍异动：</h2>
	<table width="800px" border="2" cellpadding="6" cellspacing="5" >
		
	<th>学号</th><th>异动日期</th><th>异动文号</th><th>异动类别</th><th>异动原因描述</th><th>复学日期</th>
	<th>原班级</th><th>原专业</th><th>原系所</th>
		
       <tr>
       <% for(ChangeMessage changeMessage :changeMessList ){
       cclass=classDao.getClassByID(changeMessage.getOldClassID());
       major=majorDao.getMajorByID(cclass.getMajorID());
       college=collegeDao.getCollegeByID(major.getCollegeID());
        %>
        <td><%=student.getStudentNumber() %></td>
         <td><%=changeMessage.getChangeDate() %></td>
         <td><%=changeMessage.getChangeNumber() %></td>
         <td><%=changeMessage.getType() %></td>
         <td><%=changeMessage.getReason() %></td>
         <td><%=changeMessage.getBackDate() %></td>
         <td><%=cclass.getName() %></td>
         <td><%=major.getMajorName() %></td>
         <td><%=college.getCollegeName() %></td>
       <%
       }
        %>
         </tr>
	</table><br />
</body>
</html>
