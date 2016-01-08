<%@page contentType="text/html; charset=utf-8"%>
<%@page import="org.schoolrole.model.Manager"%>
<html>
  <head>
    <title>My JSP 'managerMessage.jsp' starting page</title> 
     <link rel="stylesheet" type="text/css" href="css/reset.css" /> 
    <link rel="stylesheet" type="text/css" href="css/managerMessage.css" />
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
   <script type="text/javascript">
   $(document).ready(function(){
   /*管理班级信息*/
   		
   		 $("#manageClass").click(function(){
   		$(this).addClass("current").parent().siblings().children("a").removeClass("current");
       	$("#class").css("display","block").siblings().css("display","none");
       	$("#mainContent").attr("src","");
       });
  	   /*添加班级*/
       $("#mgClassInstert").click(function(){
    	 $("#mainContent").attr("src","mgClassInstert.jsp");
       });
        /*更新班级*/
       $("#mgClassGetNumUp").click(function(){
    	 $("#mainContent").attr("src","mgClassGetNumUp.jsp");
       });
       /*删除班级*/
       $("#mgClassGetNumDel").click(function(){
    	 $("#mainContent").attr("src","mgClassGetNum.jsp?typ=0");
       });
        /*查询单个班级*/
       $("#mgClassQuery").click(function(){
    	 $("#mainContent").attr("src","mgClassGetNum.jsp?typ=1");
       });
       /*查询所有班级*/
   		 $("#mgClassGetAll").click(function(){
    	 $("#mainContent").attr("src","mgClassGetAll.jsp");
       });
  /*管理学生信息*/
       $("#manageStudentIndex").click(function(){
       $(this).addClass("current").parent().siblings().children("a").removeClass("current");
       	$("#student").css("display","block").siblings().css("display","none");
       	$("#mainContent").attr("src","");
       });
       /*添加学生*/  
      $("#mgstudentInsert").click(function(){
    	 $("#mainContent").attr("src","mgstudentInsert.jsp");
       });
       /*查询单个学生*/
       $("#mgStudentGetByNum").click(function(){
    	 $("#mainContent").attr("src","mgStudentGetByNum.jsp");
       });
       /*查询所有学生信息*/
       $("#mgStudentGetALL").click(function(){
    	 $("#mainContent").attr("src","mgStudentGetALL.jsp");
       });
    /*异动信息管理*/
    $("#mgChange").click(function(){
       $(this).addClass("current").parent().siblings().children("a").removeClass("current");
       	$("#change").css("display","block").siblings().css("display","none");
       	$("#mainContent").attr("src","");
       });
       //添加异动信息
        $("#mgChangeInsert").click(function(){
    	 $("#mainContent").attr("src","mgChangeInset.jsp");
       });
       //查询异动信息
       $("#mgChangeQuery").click(function(){
    	 $("#mainContent").attr("src","mgChangeQU.jsp");
       });
    /*奖惩信息管理*/
     $("#manageRewPublish").click(function(){
       $(this).addClass("current").parent().siblings().children("a").removeClass("current");
       	$("#rewardOrPublish").css("display","block").siblings().css("display","none");
       	$("#mainContent").attr("src","");
       });
       //添加奖惩信息
        $("#mgRewPubInsert").click(function(){
    	 $("#mainContent").attr("src","mgRewPublishDetails.jsp");
       });
       //查询奖惩信息
    	 $("#mgRewPubDetail").click(function(){
    	 $("#mainContent").attr("src","manageRewPublish.jsp");
       });
     /*密码修改*/
     $("#manageChangePassword").click(function(){
       $(this).addClass("current").parent().siblings().children("a").removeClass("current");
       	$("#mgPwd").css("display","block").siblings().css("display","none");	
       	$("#mainContent").attr("src","");
       });
       $("#mgChangePwd").click(function(){
    	 $("#mainContent").attr("src","manageChangePassword.jsp");
       });
   });
   </script>
  </head>
  <body>
  <div id="headings">
  <div id="logo">学生学籍管理系统</div>
   <ul id="menu">
	   <li><a id="manageClass"  class="current" href="#">班级信息 </a></li>
	   <li><a id="manageStudentIndex" href="#">学生信息 </a></li>
	   <li><a id="mgChange" href="#">异动信息 </a></li>
	   <li><a id="manageRewPublish" href="#">奖惩信息 </a></li>
	   <li><a id="manageChangePassword"  href="#">密码修改 </a></li>
   </ul>
  <div id="userWelcome">
 <%Manager manager = (Manager)session.getAttribute("currentManager");
				if(manager == null) {
			%>
					<a href="login.jsp">登录</a>
			<%	
				}else {
			%>
					Welcome <%=manager.getUserName()%>!!
					
					|<a href="login.jsp" >
						退出
					</a>
			<% 
				}
			%> 
   </div>
   </div>
   <div style="clear:both"> </div>
 <div id="sidebar" >
 <ul id="list">
 <li id="class">
  <a id="mgClassInstert" href="#">添加班级 </a><br /><br />
  <a id="mgClassGetNumUp" href="#">修改班级信息 </a><br /><br />
  <a id="mgClassGetNumDel" href="#">删除班级信息 </a><br /><br />
  <a id="mgClassQuery" href="#" >查看某个班级信息 </a><br /><br />
  <a id="mgClassGetAll" href="#">查看所有班级信息</a><br /><br />
  </li>
  <li id="student">
  <a id="mgstudentInsert" href="#">添加学生信息 </a><br /><br />
  <a id="mgStudentGetByNum" href="#"> 查询单个学生</a><br /><br />
  <a id="mgStudentGetALL" href="#"> 查询所有学生</a><br /><br />
  </li>
  <li id="change">
   <a id="mgChangeInsert" href="#">添加异动信息</a><br /><br />
   <a id="mgChangeQuery" href="#">查看更新异动信息</a><br /><br />
  </li>
   <li id="rewardOrPublish">
   <a id="mgRewPubInsert" href="#">添加奖惩信息</a><br /><br />
   <a id="mgRewPubDetail" href="#">查看所有异动信息</a><br /><br />
  </li>
  <li id="mgPwd">
  <a id="mgChangePwd" href="#">修改密码</a><br /><br />
  </li>
  </ul>
 </div>
 <iframe id="mainContent" width="1100px" height="600px" >
  </iframe> 
  </body>
</html>
