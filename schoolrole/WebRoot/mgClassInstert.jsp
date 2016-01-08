<%@page contentType="text/html; charset=utf-8"%>
<%@page import="org.schoolrole.model.College"%>
<%@page import="org.schoolrole.model.CClass"%>
<%@page import="org.schoolrole.model.Major"%>
<%@page import="org.schoolrole.dao.ClassDao"%>
<%@page import="org.schoolrole.dao.MajorDao"%>
<%@page import="org.schoolrole.dao.CollegeDao"%>
<html>
  <head>
  <meta content="text/html;charset=utf-8" />
    <title>My JSP 'mgClassGet.jsp' starting page</title>
    <style type="text/css">
    fieldset {
    margin: 30px 0 0 30px;
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
    <link rel="stylesheet" type="text/css" href="css/reset.css" /> 
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
   <script type="text/javascript">
   
   $(document).ready(function(){
       $("#insertClass").click(function(){
      
    	$.get("ManageClassInsertAction",$("#addClass").serialize(),function(data,textStatus){
    	if(data=="添加成功！"){
    	$("#suuccessOrFail").html(data).css("color","blue");
    	}
   		else {
   		$("#suuccessOrFail").html(data).css("color","red");
   		}
   	    });    
   	});
   });
   </script>
  </head>
  <body> 
  <%
  MajorDao majorDao=new MajorDao();
		CollegeDao collegeDao=new CollegeDao();%>

 <fieldset>
   <legend>添加班级</legend>
  <form id="addClass" action="#">
&nbsp;&nbsp; 班级班号:<input type="text" id="classNum" name="classNum" /><br /><br />
 &nbsp;&nbsp; 班级名称:<input type="text" id="className" name="className" /><br /><br />
 &nbsp;&nbsp;  所属专业:<select name="majorSelect" id="majorSelect" >
<%
for(Major major:majorDao.getAllMajor()){
 %>
	<option value="<%=major.getId() %>"> <%=major.getMajorName() %></option>
	<%}%>
	</select><br /><br />
 &nbsp;&nbsp; &nbsp;&nbsp;<input type="button" id="insertClass" class="bustyle" value="确定" />
  &nbsp;&nbsp;<input type="reset" id="reset" class="bustyle" value="重置" />
  </form> 
</fieldset>
  <div id="suuccessOrFail" style="margin-left:30px;margin-top:30px;font-size:30px;color:red;"></div> <br />
  </body>
</html>
