<%@page contentType="text/html; charset=utf-8"%>
<html>
  <head>
    <title>My JSP 'mgClassGet.jsp' starting page</title>
    <style type="text/css">
    .bustyle {
    color:#34587C;
	border:1px solid #ccc;
	border-radius:5px;
    }
    </style>
 <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
   <script type="text/javascript">
   $(document).ready(function(){
       $("#deleteClassSend").click(function(){
    	$.get("ManageClassDeleteAction",$("#deleteClassForm").serialize(),function(data,textStatus){
    	if(data=="更新成功!"){
    	$("#showInfom").html(data).css({"color":"blue","fontSize":"30px"});
    	}else{
    	$("#showInfom").html(data).css({"color":"red","fontSize":"30px"});
    	}
   	    });    
   	});
   
   
   });
   </script>
  </head>
  
  <body> 
  <%int typ=Integer.valueOf(request.getParameter("typ"));
  if(typ==0){
   %>
  <form id="deleteClassForm" action="#" method="post">
  输入班级班号:<input type="text" name="classNum">
  <input id="deleteClassSend" type="button" class="bustyle" value="确定">
  </form>
  <div id="showInfom"></div>
 <%
  }
  else if(typ==1){
   %>
  <form action="mgClassGetMess.jsp" method="post">
  输入班级班号:<input type="text" name="classNum">
  <input type="submit" class="bustyle" value="确定">
  </form>
 <%} %>
    <br> 
    
  </body>
</html>
