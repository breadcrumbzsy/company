<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  
  <form action="${pageContext.request.contextPath }/servlet/EmployeeLogin" method="post">
eid:<input type="text" name="eid" value="${eid }"/><br/>
password:<input type="text" name="password" value="${password }"/><br/>
  <input type="submit" value="登录"/>
  </form>
  
<form action="${pageContext.request.contextPath }/servlet/EmployeeAdd" method="post">
eid:<input type="text" name="eid" value="${eid }"/><br/>
name:<input type="text" name="name" value="${name }"/><br/>
gender:<input type="text" name="gender" value="${gender }"/><br/>
email:<input type="text" name="email" value="${email }"/><br/>
tel:<input type="text" name="tel" value="${tel }"/><br/>
enrollTime:<input type="text" name="enrollTime" value="${enrollTime }"/><br/>
level:<input type="text" name="level" value="${level }"/><br/>
department:<input type="text" name="department" value="${department }"/><br/>
isQuit:<input type="text" name="isQuit" value="${isQuit }"/><br/>
password:<input type="text" name="password" value="${password }"/><br/>

skill1:<input type="text" name="skill1" value="${skill1 }"/><br/>
skill2:<input type="text" name="skill2" value="${skill2 }"/><br/>
skill3:<input type="text" name="skill3" value="${skill3 }"/><br/>
skill4:<input type="text" name="skill4" value="${skill4 }"/><br/>
skill5:<input type="text" name="skill5" value="${skill5 }"/><br/>

training1:<input type="text" name="training1" value="${training1 }"/><br/>
training2:<input type="text" name="training2" value="${training2 }"/><br/>
training3:<input type="text" name="training3" value="${training3 }"/><br/>
training4:<input type="text" name="training4" value="${training4 }"/><br/>
training5:<input type="text" name="training5" value="${training5 }"/><br/>
  <input type="submit" value="添加"/>
  </form>
  
<form action="${pageContext.request.contextPath }/servlet/EmployeeModify" method="post">
eid:<input type="text" name="eid" value="${eid }"/><br/>
email:<input type="text" name="email" value="${email }"/><br/>
tel:<input type="text" name="tel" value="${tel }"/><br/>
level:<input type="text" name="level" value="${level }"/><br/>
department:<input type="text" name="department" value="${department }"/><br/>
isQuit:<input type="text" name="isQuit" value="${isQuit }"/><br/>
  <input type="submit" value="修改个人信息"/>
  </form>
  
<form action="${pageContext.request.contextPath }/servlet/EmployeeSkillAdd" method="post">
eid:<input type="text" name="eid" value="${eid }"/><br/>
description:<input type="text" name="description" value="${description }"/><br/>
  <input type="submit" value="添加新技能"/>
  </form>
  
  <form action="${pageContext.request.contextPath }/servlet/EmployeeSkillDelete" method="post">
sklid:<input type="text" name="sklid" value="${sklid }"/><br/>
  <input type="submit" value="删除原有技能"/>
  </form>
  
<form action="${pageContext.request.contextPath }/servlet/EmployeeTrainingAdd" method="post">
eid:<input type="text" name="eid" value="${eid }"/><br/>
description:<input type="text" name="description" value="${description }"/><br/>
  <input type="submit" value="添加新培训"/>
  </form>
  
    <form action="${pageContext.request.contextPath }/servlet/EmployeeTrainingDelete" method="post">
tid:<input type="text" name="tid" value="${tid }"/><br/>
  <input type="submit" value="删除原有培训"/>
  </form>
  

  
     <form action="${pageContext.request.contextPath }/servlet/SalaryAdd" method="post">
eid:<input type="text" name="eid" value="${eid }"/><br/>
year:<input type="text" name="year" value="${year }"/><br/>
month:<input type="text" name="month" value="${month }"/><br/>
bonus:<input type="text" name="bonus" value="${bonus }"/><br/>
  <input type="submit" value="添加工资"/>
  </form>
  
       <form action="${pageContext.request.contextPath }/servlet/SalaryBasicModify" method="post">
syyg:<input type="text" name="syyg" value="${syyg }"/><br/>
ptyg:<input type="text" name="ptyg" value="${ptyg }"/><br/>
zz:<input type="text" name="zz" value="${zz }"/><br/>
bmjl:<input type="text" name="bmjl" value="${bmjl }"/><br/>
zjl:<input type="text" name="zjl" value="${zjl }"/><br/>
  <input type="submit" value="重设基本工资"/>
  </form>
  
      <form action="${pageContext.request.contextPath }/servlet/RecordServlet" method="post">
eid:<input type="text" name="eid" value="${eid }"/><br/>
  <input type="submit" value="签到/签退"/>
  </form>  
  
      <form action="${pageContext.request.contextPath }/servlet/AttendanceSetAllowed" method="post">
aid:<input type="text" name="aid" value="${aid }"/><br/>
  <input type="submit" value="设置为被允许"/>
  </form>  
  
        <form action="${pageContext.request.contextPath }/servlet/AttendanceAdd" method="post">
day:<input type="text" name="day" value="${day }"/><br/>
department:<input type="text" name="department" value="${department }"/><br/>
  <input type="submit" value="根据今日签到记录生成今日考勤表"/>
  </form>  
  
  
  </body>
</html>
