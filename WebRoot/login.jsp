<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>后台登录</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="css/style.css" tppabs="css/style.css" />
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
</style>
<script src="js/jquery.js"></script>
<script type="text/javascript" src="js/employee.js"></script>
<script src="js/Particleground.js" tppabs="js/Particleground.js"></script>

<script>
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
    dotColor: '#5cbdaa',
    lineColor: '#5cbdaa'
  });
});
</script>
</head>
<body>
<dl class="admin_login">
 <dt>
  <strong>人力资源管理系统</strong>
  <em>Management System</em>
 </dt>
 <dd class="user_icon">
  <input type="text" placeholder="编号" class="login_txtbx" id="eid"/>
 </dd>
 <dd class="pwd_icon">
  <input type="password" placeholder="密码" class="login_txtbx" id="password"/>
 </dd>
 <!--<dd class="val_icon">-->
  <!--<div class="checkcode">-->
    <!--<input type="text" id="J_codetext" placeholder="验证码" maxlength="4" class="login_txtbx">-->
    <!--<canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>-->
  <!--</div>-->
  <!--<input type="button" value="验证码核验" class="ver_btn" onClick="validate();">-->
 <!--</dd>-->
 <dd>
  <input type="button" value="登陆" class="submit_btn" onclick="login()" />
   <div id="msg" style="color:red;text-align:center;font-size:16pt;"></div>
 </dd>
 <dd>
<!--   <p>© 2015-2016 jq22 版权所有</p>
  <p>陕B2-8998988-1</p> -->
 </dd>
</dl>
</body>
</html>