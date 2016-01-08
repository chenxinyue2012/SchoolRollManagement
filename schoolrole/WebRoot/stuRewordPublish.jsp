<%@page contentType="text/html; charset=utf-8"%>
<%@page import="org.schoolrole.dao.StudentDao"%>
<%@page import="org.schoolrole.model.Student"%>
<%@page import="org.schoolrole.dao.RewordandPublishmentDao"%>
<%@page import="org.schoolrole.model.RewordorPublishment"%>
<%@page import="java.util.List"%>
<html>
  <head>
    <title>My JSP 'stuRewordPublish.jsp' starting page</title>
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
	<%
	Student student = (Student)session.getAttribute("currentStudent");
  RewordandPublishmentDao rewordPubDao=new RewordandPublishmentDao();
  %>
    <h2>奖惩信息：</h2>
	
	<table width="800px" border="2" cellpadding="6" cellspacing="5" >
		<tr>
	<td>学号</td><td>奖惩编号</td><td>奖惩日期</td><td>奖惩原因</td><td>奖或惩</td><td>备注</td>
		</tr>
   
    <% for(RewordorPublishment reworPub :rewordPubDao.getRePubByStuID(student.getId()) ){
        %> <tr>
         <td><%=student.getStudentNumber() %></td>
          <td><%=reworPub.getNum() %></td>
         <td><%=reworPub.getDate() %></td>
         <td><%=reworPub.getReason() %></td>
         <td><%= reworPub.isReorPublish()==0?"惩":"奖" %></td>
         <td><%=reworPub.getOther() %></td></tr>
   <% }%>
    
    </table><br />
  </body>
</html>
