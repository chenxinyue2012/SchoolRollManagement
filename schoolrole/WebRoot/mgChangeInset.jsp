<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="org.schoolrole.dao.ClassDao"%>
<%@page import="org.schoolrole.model.CClass"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title> MangerChangeInsert</title> 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
input,select {
margin-top: 20px;
}
.bustyle {
    color:#34587C;
	border:1px solid #ccc;
	border-radius:5px;
	width:70px;
	height:30px;
	cursor:pointer;
	font-size:14px;
    }
</style>
  </head>
  
  <body>
  <%
  ClassDao classDao=new ClassDao();
   %>
   <fieldset>
	<legend>添加奖惩信息</legend>
   <form id="changeForm" action="ManageChangeUpdateAction" method="POST">

		<input type="hidden"  name="id" />
		学生学号:<input type="text" id="stunum" name="stunum" /><br />
	        异动日期:<input type="date" name="ChangeDate" /><br /><label>*日期格式为xxxx-mm-dd</label><br />
		异动文号:<input id="ChangeNumber" type="text" name="ChangeNumber" /><br />
		异动类别:<input type="text" id="Type" name="Type" /><br />
		异动原因<input type="text" id="Reason" name="Reason" /><br />
		复学日期<input type="date" id="BackDate" name="BackDate" /><br /><label>*日期格式为xxxx-mm-dd</label><br />
		原班级:<select name="oldclass" id="oldclass">
			<%
			for(CClass cclass:classDao.getAllClass()){
			 %>
		<option value="<%=cclass.getId() %>"> <%=cclass.getName()%></option>
		<%}%>
		</select><br>
		 现班级:<select name="nowclass" id="nowclass">
			<%
for(CClass cclass:classDao.getAllClass()){
 %>
	<option value="<%=cclass.getId() %>"> <%=cclass.getName()%></option>
	
	<%}%>
		</select><br> 
		<input id="changeSend" class="bustyle" type="submit" value="提交" />
		<input type="reset" class="bustyle" value="重置" />
	</form>
	</fieldset>
  </body>
</html>
