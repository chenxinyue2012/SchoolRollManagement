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
	cursor:pointer;
    }
    </style> 
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
   <script type="text/javascript">
   $(document).ready(function(){
   
   });
   </script>
  </head>
  <body> 
  <form id="mgClassUpdate" action="mgClassUpdate.jsp" method="post">
  输入班级班号:<input type="text" name="classNum">
  <input id="updateSend" type="submit" class="bustyle" value="确定" />
   <input id="reset" type="reset" class="bustyle" value="重置" />
  </form>
   
  
  </body>
</html>
