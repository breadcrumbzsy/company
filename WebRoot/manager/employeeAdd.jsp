<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主要内容区main</title>
<link href="../css/css.css" type="text/css" rel="stylesheet" />
<link href="../css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />
<script type="text/javascript" src="../js/employee.js"></script>
<script src="../js/jquery.js"></script>

<script type="text/javascript">
function addSkillInputBox(){
	$("#skillput").append("<input type=\"text\" name=\"skillInput\" value=\"\" class=\"text-word-short\" >");
	 return false;  
}
function addTrainingInputBox(){
	$("#trainingput").append("<input type=\"text\" name=\"trainingInput\" value=\"\" class=\"text-word-short\" >");
	 return false;  
}
</script>

<style>
body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
#searchmain{ font-size:12px;}
#search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF}
#search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
#search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
#search form input.text-but{height:24px; line-height:24px; width:55px; background:url(../images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
#search a.add{ background:url(../images/main/add.jpg) no-repeat 0px 6px; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF}
#search a:hover.add{ text-decoration:underline; color:#d2e9ff;}
#main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
#main-tab th{ font-size:12px; background:url(../images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
#main-tab td{ font-size:12px; line-height:40px;}
#main-tab td a{ font-size:12px; color:#548fc9;}
#main-tab td a:hover{color:#565656; text-decoration:underline;}
.bordertop{ border-top:1px solid #ebebeb}
.borderright{ border-right:1px solid #ebebeb}
.borderbottom{ border-bottom:1px solid #ebebeb}
.borderleft{ border-left:1px solid #ebebeb}
.gray{ color:#dbdbdb;}
td.fenye{ padding:10px 0 0 0; text-align:right;}
.bggray{ background:#f9f9f9; font-size:14px; font-weight:bold; padding:10px 10px 10px 0; width:120px;}
.main-for{ padding:10px;}
.main-for input.text-word{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; padding:0 10px;}
.main-for input.text-word-short{ width:182px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; padding:0 10px;}
.main-for input.text-word-fix{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#e6e6e6; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; padding:0 10px;}
.main-for input.text-word-fix-short{ width:182px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#e6e6e6; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; padding:0 10px;}
.main-for select{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666;}
.main-for input.text-but{ width:100px; height:40px; line-height:30px; border: 1px solid #cdcdcd; background:#e6e6e6; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#969696; float:left; margin:0 10px 0 0; display:inline; cursor:pointer; font-size:14px; font-weight:bold;}
#addinfo a{ font-size:14px; font-weight:bold; background:url(../images/main/addinfoblack.jpg) no-repeat 0 1px; padding:0px 0 0px 20px; line-height:45px;}
#addinfo a:hover{ background:url(../images/main/addinfoblue.jpg) no-repeat 0 1px;}
</style>
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：下属信息&nbsp;&nbsp;>&nbsp;&nbsp;添加部员</td>
  </tr>
  <!--<tr>-->
    <!--<td align="left" valign="top" id="addinfo">-->
    <!--<a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">新增管理员</a>-->
    <!--</td>-->
  <!--</tr>-->
  <tr>
    <td align="left" valign="top">
    <form method="post" action="">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">编号：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="" value="" class="text-word" id="eid">
        </td>
        </tr>
              <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">姓名：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="" value="" class="text-word" id="name">
        </td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">性别：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="" value="" class="text-word" id="gender">
        </td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">电子邮箱：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="" value="" class="text-word" id="email">
        </td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">电话：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="" value="" class="text-word" id="tel">
        </td>
      </tr>
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">入职时间：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="" value="" class="text-word" id="enrollTime">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">等级：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
          <input type="text" name="" value="" class="text-word" id="level">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">部门：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
          <input type="text" name="" value="" class="text-word" id="department">
        </td>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">初始密码：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
          <input type="text" name="" value="" class="text-word" id="password">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
         <td align="right" valign="middle" class="borderright borderbottom bggray">技能：</td>
		<td align="left" valign="middle" class="borderright borderbottom main-for" id="skillput">
			   
         		<!--  <input type="text" name="" value="" class="text-word-short" > -->
	
			<input type="button" value="添加" onclick="addSkillInputBox()" >
 		</td>
      </tr>
      
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
         <td align="right" valign="middle" class="borderright borderbottom bggray">所受培训：</td>
		<td align="left" valign="middle" class="borderright borderbottom main-for" id="trainingput">
		    <!-- <input type="text" name="" value="" class="text-word-short" > -->
			 <input type="button" value="添加" onclick="addTrainingInputBox()" >
 		</td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">&nbsp;</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="" type="submit" value="添加" class="text-but" onclick="employeeAdd()">
        <input name="" type="reset" value="重置" class="text-but"></td>
        <div id="msg" style="color:red;text-align:center;font-size:16pt;"></div>
        </tr>
    </table>
    </form>
    </td>
    </tr>
</table>
</body>
</html>