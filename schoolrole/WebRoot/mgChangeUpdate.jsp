<%@page contentType="text/html; charset=utf-8"%>
<%@page import="org.schoolrole.dao.ChangeSchoolRolDao"%>
<%@page import="org.schoolrole.dao.StudentDao"%>
<%@page import="org.schoolrole.dao.ClassDao"%>
<%@page import="org.schoolrole.model.ChangeMessage"%>
<%@page import="org.schoolrole.model.Student"%>
<%@page import="org.schoolrole.model.CClass"%>
<%@page import="java.util.List"%>

<html>
<head>
<title>My JSP 'mgClassGet.jsp' starting page</title>
<style type="text/css">
input,select {
margin-top: 15px;
}
#returnPre {
color:#34587C;
border:1px solid #ccc;
border-radius:5px;
}
.bustyle {
    color:#34587C;
	border:1px solid #ccc;
	border-radius:5px;
	width:70px;
	height:30px;
	cursor:pointer;
	font-size:14px;
	margin-right:15px;
    }
    form {
    margin-left:15px;
    }
</style>
</head>
<body>
	<%
		String theid = request.getParameter("id");
		ChangeMessage change = new ChangeMessage();
		if (theid != null && !"".equals(theid)) {
			Integer id = Integer.valueOf(request.getParameter("id"));
			ChangeSchoolRolDao changeDao = new ChangeSchoolRolDao();
			change = changeDao.getChangeMessByID(id);
		}
		String stunum = request.getParameter("stunum");
		Student student = new Student();
		StudentDao studentdao = new StudentDao();
		if (stunum != null && !"".equals(stunum)) {
			student = studentdao.getStudentByStuNum(stunum);
		}
		Integer stuID = change.getStudentID();
		Integer oldClassID = change.getOldClassID();
		Integer newClassID = change.getNewClassID();
		ClassDao classDao = new ClassDao();
		CClass oldcclass = new CClass();
		CClass newcclass = new CClass();
		if (oldClassID != null) {
			oldcclass = classDao.getClassByID(oldClassID);
		}
		if (newClassID != null) {
			newcclass = classDao.getClassByID(newClassID);
		}
	%>
	<fieldset>
	<legend>更新异动信息</legend>
	<form id="changeForm" action="ManageChangeUpdateAction" method="POST">

		<input type="hidden"  name="id"
			value="<%=change.getId() == null ? "" : change.getId()%>">
		学生学号:<input type="text" id="stunum" name="stunum"
			value="<%=stunum == null ? "" : stunum%>"><br> 异动日期:<input
			type="date" name="ChangeDate"
			value="<%=change.getChangeDate() == null ? "" : change
					.getChangeDate()%>"><br>
		异动文号:<input id="ChangeNumber" type="text" name="ChangeNumber"
			value="<%=change.getChangeNumber() == null ? "" : change
					.getChangeNumber()%>"><br>
		异动类别:<input type="text" id="Type" name="Type"
			value="<%=change.getType() == null ? "" : change.getType()%>"><br>
		异动原因<input type="text" id="Reason" name="Reason"
			value="<%=change.getReason() == null ? "" : change.getReason()%>"><br>
		复学日期<input type="date" id="BackDate" name="BackDate"
			value="<%=change.getBackDate() == null ? "" : change.getBackDate()%>"><br>
		原班级:<select name="oldclass" id="oldclass">
			<%
				if (oldcclass.getName() != null) {
			%>
			<option value="<%=oldcclass.getId()%>">
				<%=oldcclass.getName() == null ? "" : oldcclass
						.getName()%></option>
			<%
				}
				for (CClass cclass : classDao.getAllClass()) {
					if (cclass.getId() == oldcclass.getId()) {
						continue;
					}
			%>
			<option value="<%=cclass.getId()%>">
				<%=cclass.getName()%></option>

			<%
				}
			%>
		</select><br> 现班级<select name="nowclass" id="nowclass">
			<%
				if (newcclass.getName() != null) {
			%>
			<option value="<%=newcclass.getId()%>">
				<%=newcclass.getName() == null ? "" : oldcclass
						.getName()%></option>
			<%
				}
				for (CClass cclass : classDao.getAllClass()) {
					if (newcclass.getId() == cclass.getId()) {
						continue;
					}
			%>
			<option value="<%=cclass.getId()%>">
				<%=cclass.getName()%></option>

			<%
				}
			%>
		</select><br> <input id="changeSend" type="submit" class="bustyle" value="更新" />
		<input type="reset" class="bustyle" value="取消" />
	</form>
	<input id="returnPre" type="button" onclick="location.href='javascript:history.go(-1);'" value="返回上一级" />
	</fieldset>
</body>
</html>
