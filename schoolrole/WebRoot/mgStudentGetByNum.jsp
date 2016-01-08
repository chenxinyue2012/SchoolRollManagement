<%@page contentType="text/html; charset=utf-8"%>
<html>
  <head>
    <title>My JSP 'mgClassGet.jsp' starting page</title>
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
</style>
  </head>
  
  <body> 
 
  <form action="mgStudentGetByNumAction.jsp" method="post">
  输入学生学号:<input type="text"  name="stuNum">
  <input type="submit" class="bustyle" value="确定">
 
  </form>

    <br> 
  </body>
</html>
