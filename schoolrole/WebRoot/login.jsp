
<%@page contentType="text/html; charset=utf-8"%>

<html>
<head>
<meta charset="utf-8" />
<title>loginPage</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/login.css">
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>

</head>
<body >
	<%Integer stu=0,manager=1; %>
	
	<div id="login">
  <div id="head">
    <div class="content">
  
    <form id="loginForm" action="#">
        用户名:&nbsp;<input type="text" id="userName" name="userName" /><br /> <br /> 
        密码:  &nbsp;&nbsp;&nbsp;<input id="passwd" type="password" name="passwd" /><br /><br />  
        用户类型: &nbsp;&nbsp;<select name="role" id="role">
      <option value="student">学生</option>
      <option value="manager" >管理员</option>
      </select><br /><br />  
         &nbsp; &nbsp;&nbsp;<input id="loginSend" type="button" class="write" value="登录"  />
         &nbsp;&nbsp;<input  type="reset" class="write" value="重置" />
   </form>
    </div>
  </div>
  <div id="left"></div>
  <div id="center">  
   <div id="loginInform"></div>
  </div>
  <div id="right"></div>
  <div id="footer"></div>
</div>
<script type="text/javascript">
$("#loginSend").click(function(){
if($("#userName").val()==""||$("#passwd").val()==""){
 $("#loginInform").html("用户名或密码不能为空!").css("color","red");
}
$.get("LoginAction",$("#loginForm").serialize(),function(data,textStatus){

   if(data=="studentFail"||data=="managerFail"){
   
   $("#loginInform").html("用户名或密码错误!").css("color","red");
   
   }
   if(data=="studentSuccess"){
   window.location.href="studentMessage.jsp";
   }
   if(data=="managerSuccess"){
     window.location.href="managerMessage.jsp";
   }
});
});
</script>
	<br>
</body>
</html>
