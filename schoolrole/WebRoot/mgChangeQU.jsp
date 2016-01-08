<%@page contentType="text/html; charset=utf-8"%>
<%@page import="org.schoolrole.dao.ChangeSchoolRolDao" %>
<%@page import="org.schoolrole.dao.StudentDao" %>
<%@page import="org.schoolrole.dao.ClassDao" %>
<%@page import="org.schoolrole.model.ChangeMessage"%>
<%@page import="org.schoolrole.model.Student"%>
<%@page import="org.schoolrole.model.CClass"%>
<%@page import="java.util.List"%>
<html>
  <head>
    <title>manageChange</title>
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
   <h4>更新异动信息：</h4>
  <%
  StudentDao studentdao=new StudentDao();
  ClassDao classDao=new ClassDao();
  CClass cclass=new CClass();
  Integer nonid=null;
   %>
  <table width="800px" border="1">
		<tr>
		<th>学生学号</th>
			<th>异动日期</th>
			<th>异动文号</th>
			<th>异动类别</th>
			<th>异动原因</th>
			<th>复学日期</th>
			<th>原班级</th>
			<th>现班级</th>
		</tr>
	<%
		ChangeSchoolRolDao changeDao = new ChangeSchoolRolDao();
		List<ChangeMessage> ChangeList = changeDao.getAllChangeMess();
		for(ChangeMessage change : ChangeList) {
	%>
			<tr>
				<td>
				<a href="mgChangeUpdate.jsp?id=<%=change.getId()%>&stunum=<%=studentdao.getStudentByStuID(change.getStudentID()).getStudentNumber()%>">
				<%=studentdao.getStudentByStuID(change.getStudentID()).getStudentNumber() %></a>
				</td>
				<td><%=change.getChangeDate()%></td>
				<td><%=change.getChangeNumber()%></td>
					<td><%=change.getType()%></td>
						<td><%=change.getReason()%></td>
						<td><%=change.getBackDate()%></td>
							<td><%=classDao.getClassByID(change.getOldClassID()).getName() %></td>
							<td><%=classDao.getClassByID(change.getNewClassID()).getName() %></td>
							
			</tr>
	<%
		}	
	%>
	</table>
 
    <br> 
  </body>
</html>
