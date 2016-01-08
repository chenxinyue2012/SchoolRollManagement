<%@page contentType="text/html; charset=utf-8"%>
<html>
  <head>
    <title>My JSP 'manageChangePassword.jsp' starting page</title>
    <style type="text/css">
    .bustyle {
    color:#34587C;
	border:1px solid #ccc;
	border-radius:5px;
	width:70px;
	height:30px;
	cursor:pointer;
	font-size:14px;
    }
    input,select {
    margin-top: 20px;
    }
    </style>
  </head>
 <body>   
    <fieldset>
    <legend>密码更改</legend>
    <form  name="myForm" action="checkChangemanager.jsp" method="post" />
                 当前密码:<input type="password" name="nowpasswd" /><br /> 
		新密码:&nbsp;&nbsp; <input type="password" name="newpasswd" /><br /> 
		确认新密码: <input type="password"  name="checknewpasswd" /><br /> 
		&nbsp;&nbsp;<input type="submit" class="bustyle"	value="确定" /> 
		&nbsp;&nbsp;<input type="reset" class="bustyle"	value="重置" /> 
	</form>
    </fieldset>
  </body>
</html>