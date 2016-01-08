<%@page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.List"%>
<%@page import="org.schoolrole.model.Student"%>
<%@page import="org.schoolrole.model.RewordorPublishment"%>
<%@page import="org.schoolrole.dao.StudentDao" %>
<%@page import="org.schoolrole.dao.RewordandPublishmentDao" %>

<html>
<head>
<title>My JSP 'mgClassGet.jsp' starting page</title>
<style type="text/css">
input,select {
margin-top: 20px;
}

</style>
</head>
<body>
	<fieldset>
	<legend>添加奖惩信息</legend>
	<form action="ManageRewPublishAction" method="POST">
		<input type="hidden" name="id" />
		学生编号:<input type="text" name="stunum" /><br />
		奖惩编号:<input type="text" name="repubnum" /><br />
		奖惩日期:<input type="date" name="ReDate" /><label>*日期格式为xxxx-mm-dd</label><br />
		奖惩原因:<input type="text" name="Reason" /><br />
		奖或惩:<select name="reword">
		<option value="<%=0 %>">罚</option>
		<option value="<%=1 %>">奖 </option>
		</select>
		<br>
		备注<input type="text" name="other" /><br />
			<input type="submit" value="提交" />
			<input type="reset" value="重置" />
	</form>
	</fieldset>
   <br>
  </body>
</html>
