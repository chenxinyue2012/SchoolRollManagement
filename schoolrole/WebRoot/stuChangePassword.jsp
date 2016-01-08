<%@page contentType="text/html; charset=utf-8"%>
<html>
  <head>
    <title>My JSP 'stuChangePassword.jsp' starting page</title>
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
   <script type="text/javascript">
   $(document).ready(function(){
   $("#stuChangePwdSend").click(function(){
   		$.get("StuPwdChangeAction",$("#stuChangePwd").serialize(),function(data,textStatus){
   			alert(data);
   		});
   });	
   });
   </script>
   <style type="text/css">
   input {
   margin-bottom: 20px;
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
 	<fieldset>
    <legend>密码更改</legend>
    <form id="stuChangePwd"  name="myForm" action="#" method="post" >
                当前密码:&nbsp;<input id="nowpasswd" type="password" name="nowpasswd" /><br /> 
		新密码:&nbsp;&nbsp; &nbsp;&nbsp;<input id="newpasswd" type="password" name="newpasswd" /><br /> 
		确认新密码: <input id="checknewpasswd" type="password" name="checknewpasswd" /><br /> 
		&nbsp;&nbsp;<input class="bustyle" type="button" id="stuChangePwdSend"	value="确定" /> 
		<input type="reset" class="bustyle"  id="reset"	value="重置" /> 
	</form>
	</fieldset>
  </body>
</html>
