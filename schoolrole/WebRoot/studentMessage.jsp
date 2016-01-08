<%@page contentType="text/html; charset=utf-8"%>
<%@page import="org.schoolrole.model.Student"%>
<html >
  <head>
    <title>My JSP 'studentMessage.jsp' starting page</title>
     <link rel="stylesheet" type="text/css" href="css/studentMessage.css" />
     <link rel="stylesheet" type="text/css" href="css/reset.css" /> 
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
   <script type="text/javascript">
   $(document).ready(function(){
    $("#stuDetailMessage").click(function(){
    	 $("#stuMainContent").attr("src","stuDetailMessage.jsp");
       });
    $("#stuChangeMessage").click(function(){
    	 $("#stuMainContent").attr("src","stuChangeMessage.jsp");
       });
     $("#stuRewordPublish").click(function(){
    	 $("#stuMainContent").attr("src","stuRewordPublish.jsp");
       });   
     $("#stuChangePassword").click(function(){
    	 $("#stuMainContent").attr("src","stuChangePassword.jsp");
       });   
       
       
   });
    </script>
  </head>
  <body >
  <div id="headings">
  <div id="logo">学生学籍管理系统</div>
   <ul id="menu">
	   
   </ul>
  <div id="userWelcome">
  <%	Student student = (Student)session.getAttribute("currentStudent");
				if(student == null) {
			%>
					<a href="login.jsp">
						登录 
					</a>
			<%	
				}else {
			%>
					欢迎<%=student.getName()%>
					<a href="login.jsp" >
						|退出
					</a>
				<% 
				}
			%>	
  </div>
 </div>
 <div style="clear:both"> </div>
 <div id="sidebar">
  <a id="stuDetailMessage" href="#">学籍信息 </a>&nbsp;&nbsp;&nbsp;<br><br>
  <a id="stuChangeMessage" href="#">异动信息 </a><br><br>
  <a id="stuRewordPublish" href="#">奖惩信息 </a><br><br>
   <a id="stuChangePassword"  href="#">密码修改 </a>
  </div>
  <iframe id="stuMainContent" width="1100px" height="600px" >
  </iframe> 
</body>
</html>
