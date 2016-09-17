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
      <div>
        <span>下属信息</span>
        <a href="boss/employeeInfoList.jsp" target="mainFrame" onFocus="this.blur()">员工列表</a><!-- 根据eid、姓名从全公司搜索，还可将别人level设置为部门经理哦！-->
        <a href="boss/employeeAdd.jsp" target="mainFrame" onFocus="this.blur()">添加部员</a><!-- 除普通员工之外，还尅添加部门经理哦！ -->
      </div>
      <div>
        <span>下属考勤</span>
        <a href="boss/attendanceSetDaily.jsp" target="mainFrame" onFocus="this.blur()">批免部门经理日考勤表</a>
        <a href="boss/attendanceRecordList.jsp" target="mainFrame" onFocus="this.blur()">签到记录查询</a><!-- 根据eid、姓名从全公司搜索-->
        <a href="boss/attendanceList.jsp" target="mainFrame" onFocus="this.blur()">考勤表查询</a><!-- 根据eid、姓名从全公司搜索-->
        <a href="boss/attendanceCountMonthly.jsp" target="mainFrame" onFocus="this.blur()">月考勤统计表查询</a><!-- 根据eid、姓名从全公司搜索-->
      </div>
      <div>
        <span>下属工资</span>
        <a href="boss/salarySet.jsp" target="mainFrame" onFocus="this.blur()">设置部门经理当月奖金</a>
        <a href="boss/salaryList.jsp" target="mainFrame" onFocus="this.blur()">工资查询</a><!-- 根据eid、姓名从全公司搜索-->
      </div>
    </div>
</body>
</html>