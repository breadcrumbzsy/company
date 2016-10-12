<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台页面头部</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
</head>
<body onselectstart="return false" oncontextmenu=return(false) style="overflow-x:hidden;">
<!--禁止网页另存为-->
<noscript><iframe scr="*.htm"></iframe></noscript>
<!--禁止网页另存为-->
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="header">
  <tr>
    <td rowspan="2" align="left" valign="top" id="logo"><img src="" width="74" height="64"></td>
    <td align="left" valign="bottom">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <!--<td align="left" valign="bottom" id="header-name">侯马经济开发区</td>-->
        <td align="right" valign="top" id="header-right">
        	<a href="${pageContext.request.contextPath }/servlet/EmployeeLogout" target="topFrame" onFocus="this.blur()" class="admin-out">注销</a>
             <!-- <a href="index.jsp" target="top" onFocus="this.blur()" class="admin-home">管理首页</a> -->
        	<!-- <a href="index.jsp" target="_blank" onFocus="this.blur()" class="admin-index">网站首页</a>  -->    
            <span>
<!-- 日历 -->
<SCRIPT type=text/javascript src="js/clock.js"></SCRIPT>
<SCRIPT type=text/javascript>showcal();</SCRIPT>
            </span>
        </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td align="left" valign="bottom">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="left" valign="top" id="header-admin">人力资源管理系统</td>
        <td align="left" valign="bottom" id="header-menu">
        <!--<a href="index.html" target="left" onFocus="this.blur()" id="menuon">后台首页</a>-->
        <!--<a href="manager/employeeInfoList.html" target="left" onFocus="this.blur()">部员信息</a>-->
        <!--<a href="main_info.html" target="left" onFocus="this.blur()">部员考勤</a>-->
        <!--<a href="manager/salarySet.html" target="left" onFocus="this.blur()">部员工资</a>-->
        <!--<a href="index.html" target="left" onFocus="this.blur()">留言管理</a>-->
        <!--<a href="index.html" target="left" onFocus="this.blur()">附件管理</a>-->
        <!--<a href="index.html" target="left" onFocus="this.blur()">站点管理</a>-->
        </td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
