<%@ page language="java" import="java.util.*,domain.Employee" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左侧导航menu</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/sdmenu.js"></script>
<script type="text/javascript">
	// <![CDATA[
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("my_menu");
		myMenu.init();
	};
	// ]]>
</script>
<style type=text/css>
html{ SCROLLBAR-FACE-COLOR: #538ec6; SCROLLBAR-HIGHLIGHT-COLOR: #dce5f0; SCROLLBAR-SHADOW-COLOR: #2c6daa; SCROLLBAR-3DLIGHT-COLOR: #dce5f0; SCROLLBAR-ARROW-COLOR: #2c6daa;  SCROLLBAR-TRACK-COLOR: #dce5f0;  SCROLLBAR-DARKSHADOW-COLOR: #dce5f0; overflow-x:hidden;}
body{overflow-x:hidden; background:url(images/main/leftbg.jpg) left top repeat-y #f2f0f5; width:194px;}
</style>
</head>
<body onselectstart="return false;" ondragstart="return false;" oncontextmenu="return false;">
<div id="left-top">
	<div><img src="images/main/member.gif" width="44" height="44" /></div>
    <span>编号：${sessionScope.employee.getEid() }<br>姓名：${sessionScope.employee.getName() }</span>
</div>
    <div style="float: left" id="my_menu" class="sdmenu">
      <div class="collapsed">
        <span>个人信息</span>
        <a href="self/employeeInfo.jsp" target="mainFrame" onFocus="this.blur()">信息详情</a>
        <a href="self/employeePasswordSet.jsp" target="mainFrame" onFocus="this.blur()">修改密码</a>
      </div>
      <div>
        <span>个人考勤</span>
        <a href="self/attendanceRecordList.jsp" target="mainFrame" onFocus="this.blur()">签到记录查询</a>
        <a href="self/attendanceList.jsp" target="mainFrame" onFocus="this.blur()">考勤记录查询</a>
      </div>
      <div>
        <span>个人工资</span>
        <a href="self/salaryListYearly.jsp" target="mainFrame" onFocus="this.blur()">工资查询</a>
      </div>
      <div>
        <span>下属信息</span>
        <a href="manager/employeeInfoList.jsp" target="mainFrame" onFocus="this.blur()">部员列表</a>
        <!-- <a href="manager/employeeModify.jsp" target="mainFrame" onFocus="this.blur()">部员信息查询、修改</a> -->
        <a href="manager/employeeAdd.jsp" target="mainFrame" onFocus="this.blur()">添加部员</a>
      </div>
      <div>
        <span>下属考勤</span>
         <a href="manager/attendanceSetDaily.jsp" target="mainFrame" onFocus="this.blur()">生成日考勤表</a>
        <a href="manager/attendanceRecordList.jsp" target="mainFrame" onFocus="this.blur()">签到记录查询</a>
        <a href="manager/attendanceList.jsp" target="mainFrame" onFocus="this.blur()">考勤表查询</a>
        <a href="manager/attendanceCountMonthly.jsp" target="mainFrame" onFocus="this.blur()">月考勤统计表查询</a>
      </div>
      <div>
        <span>下属工资</span>
        <a href="manager/salarySet.jsp" target="mainFrame" onFocus="this.blur()">设置当月奖金及工资</a>
        <a href="manager/salaryList.jsp" target="mainFrame" onFocus="this.blur()">部员工资查询</a>
      </div>
    </div>
</body>
</html>