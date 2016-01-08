<%@page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.List"%>
<%@page import="org.schoolrole.model.Student"%>
<%@page import="org.schoolrole.model.RewordorPublishment"%>
<%@page import="org.schoolrole.dao.StudentDao" %>
<%@page import="org.schoolrole.dao.RewordandPublishmentDao" %>
<html>
  <head>
    <title>My JSP 'manageClass.jsp' starting page</title>
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
   <H2>奖惩信息管理：</H2>
  <% //Integer nonid=null; %>
  <table width="600px" border="2" cellpadding="6" cellspacing="5" bordercolor="#34587C">
		<tr>
		<td>学生学号</td>
		<td>奖惩编号</td>
			<td>奖惩日期</td>
			<td>奖惩原因</td>
			<td>奖或惩</td>
			<td>备注</td>
		</tr>
		<%
		StudentDao studentdao=new StudentDao();
		RewordandPublishmentDao RePubDao = new RewordandPublishmentDao();
		List<RewordorPublishment> RePubList = RePubDao.getRePub();
		for(RewordorPublishment repub : RePubList) {
	%>
			<tr>
				<td>
				<%=studentdao.getStudentByStuID(repub.getStudentID()).getStudentNumber() %>
				</td>
				<td><%=repub.getNum() %></td>
				<td><%=repub.getDate() %></td>
				<td><%=repub.getReason() %></td>
					<td><%=repub.isReorPublish()==1?"奖":"惩" %></td>
						<td><%=repub.getOther() %></td>
			</tr>
	<%
		}	
	%>
	</table>
    <br>
  </body>
</html>