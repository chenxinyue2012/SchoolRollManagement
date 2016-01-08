<%@page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.List"%>
<%@page import="org.schoolrole.model.Student"%>
<%@page import="org.schoolrole.model.RewordorPublishment"%>
<%@page import="org.schoolrole.dao.StudentDao" %>
<%@page import="org.schoolrole.dao.ClassDao"%>
<%@page import="org.schoolrole.model.CClass"%>
<html>
  <head>
    <title>My JSP 'managestudent.jsp' starting page</title>
    <style type="text/css">
    input,select {
    margin-top: 15px;
    }
    form {
    margin-left: 20px;
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
    legend {
    color:#345A7E;
    }
    </style>
     <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
   <script type="text/javascript">
    //验证手机号码
   function validatemobile(mobile)
    {
        if(mobile.length==0)
        {
           alert('请输入手机号码！');
           document.stuForm.stuPhoneNum.focus();
           return false;
        }    
        if(mobile.length!=11)
        {
            alert('请输入有效的手机号码！');
            document.stuForm.stuPhoneNum.focus();
            return false;
        }
        
        var myreg = /^((1[0-9]{1}[0-9]{1})+\d{8})$/;
        if(!myreg.test(mobile))
        {
            alert('请输入有效的手机号码!！');
            document.stuForm.stuPhoneNum.focus();
            return false;
        }
        return true;
    }
    //日期格式验证
     function dateCheck(dateStr) {
            var date = dateStr;
            var result = date.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);

            if (result == null)
                return false;
            var d = new Date(result[1], result[3] - 1, result[4]);
            return (d.getFullYear() == result[1] && (d.getMonth() + 1) == result[3] && d.getDate() == result[4]);

        }

	function checkAdd(strDate) {
            var ret = true;
            if (!dateCheck(strDate)) {
                alert("请输入正确的日期");
                return false;
            }
            return ret;
        }
   $(document).ready(function(){
    $("#stuSend").click(function(){
    var flag = true;
    var stuPhone = $("#stuPhoneNum")[0].value;
    flag = validatemobile(stuPhone);
    var dateValue = $("#stuEntrance")[0].value;
    flag = checkAdd(dateValue);
    if(flag){
     $("#stuForm")[0].submit();
    }
   
    
    });
   });
    </script>
  </head>
  <body>
  <% 
ClassDao classDao=new ClassDao();
%>
<fieldset>
  <legend>添加学生信息</legend>
   <form id="stuForm" name="stuForm" action="ManageStudentInsertAction" method="post">
学号:&nbsp;<input type="text" name="stuNum" /><br />
姓名:&nbsp;<input type="text" name="stuName" /><br />
性别:&nbsp;<select name="sex" id="sex" >
<option value=<%="nan" %>> 男</option>
<option value=<%="women"%>> 女</option>
</select><br />
民族:&nbsp;<input type="text" name="stuNation" /><br />
身份证号:&nbsp;<input type="text" name="stuCardNum" /><br />
家庭住址:&nbsp;<input type="text" name="stuAddress" /><br />
手机号码:&nbsp;<input id="stuPhoneNum" type="text" name="stuPhoneNum" /><label id="phoneDisplay">*手机号码为11位数字组成</label><br />
政治面貌:&nbsp;<input type="text" name="stuPolitical" /><br />
入学日期:&nbsp;<input id="stuEntrance" type="date" name="stuEntrance" /><label>*日期格式为xxxx-mm-dd</label><br />
登录密码:&nbsp;<input type="text" name="stuPasswd" /><br />
所在班级:&nbsp;<select name="classSelect" id="classSelect" >
<%
for(CClass cclass:classDao.getAllClass()){
 %>
	<option value="<%=cclass.getId() %>"> <%=cclass.getName()%></option>
	
	<%}%>
	</select><br/>
  <input type="button" id="stuSend" class="bustyle" value="确定" />
  <input type="reset" class="bustyle"  value="重置" />
  </form>
 </fieldset>
  </body>
</html>
  