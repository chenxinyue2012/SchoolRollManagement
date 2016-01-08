<%@page contentType="text/html; charset=utf-8"%>
<%@page import="org.schoolrole.model.College"%>
<%@page import="org.schoolrole.model.CClass"%>
<%@page import="org.schoolrole.model.Major"%>
<%@page import="org.schoolrole.dao.ClassDao"%>
<%@page import="org.schoolrole.dao.MajorDao"%>
<%@page import="org.schoolrole.dao.CollegeDao"%>
<html>
  <head>
    <title>My JSP 'mgClassGet.jsp' starting page</title>
    <style type="text/css">
    .bustyle {
    color:#34587C;
	border:1px solid #ccc;
	border-radius:5px;
    }
    #returnPre {
	color:#34587C;
	border:1px solid #ccc;
	border-radius:5px;
	}
    </style>
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
   <script type="text/javascript">
   $(document).ready(function(){
      $("#classUpdate").click(function(){
    	$.get("ManageClassUpdateAction",$("#classUpdateForm").serialize(),function(data,textStatus){
    	if(data=="更新成功!"){
    	$("#successOrFail").html(data).css({"color":"blue","fontSize":"30px"});
    	}else{
    	$("#successOrFail").html(data).css({"color":"red","fontSize":"30px"});
    	}
   	    });    
   	});
   
   });
   </script>
  </head>
  <body> 
  <h4> </h4>
  <%
  String classNum=request.getParameter("classNum");
 ClassDao classDao=new ClassDao();
 CClass cclass=classDao.getClassByNum(classNum);	
 if(cclass==null){
  %> 
没有此班级，请重新输入 <a href="mgClassGetNumUp.jsp" >返回 </a>
  <% 
   return;}
  MajorDao majorDao=new MajorDao();
   Major major=new Major();
		major=majorDao.getMajorByID(cclass.getMajorID());
		CollegeDao collegeDao=new CollegeDao();
		College college=collegeDao.getCollegeByID(major.getCollegeID());
   %>
   <fieldset>
   <legend>修改班级信息</legend>
   <form id="classUpdateForm" action="#" method="post">
     <input type="hidden" name="id" value="<%=cclass.getId() %>"><br />
 班级班号:<input type="text" name="classNum" value="<%=cclass.getClassNumber() %>"><br /><br />
  班级名称:<input type="text" name="className" value="<%=cclass.getName() %>"><br /><br />
所属专业:<select name="majorSelect" id="majorSelect" ><br />
<option value="<%=major.getId() %>"> <%=major.getMajorName() %></option>
<% for(Major major1:majorDao.getAllMajor()){
 %>
 <% if(major.getId()==major1.getId()){
 continue;
 }%>
	<option value="<%=major1.getId() %>"> <%=major1.getMajorName() %></option>
	<% }%>
	
	</select><br /><br />
  <input id="classUpdate" type="button" class="bustyle"  value="确定">&nbsp;&nbsp;
  <input id="reset" type="reset" class="bustyle"  value="重置" />
  </form>
  <div id="successOrFail"></div>
   </fieldset>
  <input id="returnPre" type="button" onclick="location.href='javascript:history.go(-1);'" value="返回上一级" />
  </body>
</html>
