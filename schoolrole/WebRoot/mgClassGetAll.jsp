<%@page contentType="text/html; charset=utf-8"%>
<%@page import="org.schoolrole.model.College"%>
<%@page import="org.schoolrole.model.CClass"%>
<%@page import="org.schoolrole.model.Major"%>
<%@page import="org.schoolrole.dao.ClassDao"%>
<%@page import="org.schoolrole.dao.MajorDao"%>
<%@page import="org.schoolrole.dao.CollegeDao"%>
<html>
<head>
<title>My JSP 'mgClassGet.jsp' starting page</title>
<style type="text/css">
table {
	margin-top:30px;
	border-collapse:collapse;
	font-size:14px;

}
table th {
	text-align:left;
}
#returnPre {
color:#34587C;
border:1px solid #ccc;
border-radius:5px;
}
</style>
</head>
<body>
	
	<%
		ClassDao classDao = new ClassDao();
		MajorDao majorDao = new MajorDao();
		CollegeDao collegeDao = new CollegeDao();
		Major major;
		College college;%>
		<table  width="600px" border="2" cellpadding="6" cellspacing="5" bordercolor="#34587C">
		<th>班级编号</th>
		<th>班级名称</th>
		<th>所属专业</th>
		<th>所属院系</th>
		<%
		for (CClass cclass : classDao.getAllClass()) {
			 major = majorDao.getMajorByID(cclass.getMajorID());
			college = collegeDao.getCollegeByID(major
					.getCollegeID());
	%>
		<tr>
			<td><%=cclass.getClassNumber()%></td>
			<td><%=cclass.getName()%></td>
			<td><%=major.getMajorName()%></td>
			<td><%=college.getCollegeName()%></td>
		</tr>
	
	<%
		}
	%>
	</table><br>
	<input id="returnPre" type="button" onclick="location.href='javascript:history.go(-1);'" value="返回上一级" />
	<br>
</body>
</html>