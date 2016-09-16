<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主要内容区main</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />
<script type="text/javascript" src="../js/salary.js"></script>
<script src="../js/jquery.js"></script>
<style>
body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
#searchmain{ font-size:12px;}
#search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF; float:left}
#search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
#search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
#search form input.text-but{height:24px; line-height:24px; width:55px; background:url(../images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
#search a.add{ background:url(../images/main/add.jpg) no-repeat -3px 7px #548fc9; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF; float:right}
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
.bggray{ background:#f9f9f9}
</style>
</head>
<body>
<%
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
String date= format.format(new Date());
String year=date.substring(0,4);
String month=date.substring(5,7);
%>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：下属工资&nbsp;&nbsp;>&nbsp;&nbsp;部员工资查询</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
	         <form method="post" action="">
               <span>选择月份查询部员工资详情：</span>
               <input type="text" name="" value="<%=year%>" class="text-word" id="year"><span> 年</span>
               <input type="text" name="" value="<%=month%>" class="text-word" id="month"><span> 月</span>
	         <input name="" type="button" value="查询" class="text-but" onclick="getSalaryListByMonth('${sessionScope.employee.getDepartment() }')" >

               <span>|    填写部员编号查询工资详情：</span>
              <input type="text" name="" value="" class="text-word" id="eid">
               <input name="" type="button" value="查询" class="text-but" onclick="getSalaryListByEid('${sessionScope.employee.getDepartment() }')" >
	         </form>
         </td>
          <!--<td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">设置部员奖金</a></td>-->
  		</tr>
	</table>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr>
        <th align="center" valign="middle" class="borderright">编号</th>
        <th align="center" valign="middle" class="borderright">姓名</th>
        <th align="center" valign="middle" class="borderright">等级</th>
        <th align="center" valign="middle" class="borderright">基本工资</th>
        <th align="center" valign="middle" class="borderright">奖金</th>
        <th align="center" valign="middle" class="borderright">罚金</th>
        <th align="center" valign="middle" class="borderright">总计</th>
      </tr>
<!--       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom">1</td>
        <td align="center" valign="middle" class="borderright borderbottom">张三</td>
        <td align="center" valign="middle" class="borderright borderbottom">组长</td>
        <td align="center" valign="middle" class="borderright borderbottom">8000</td>
        <td align="center" valign="middle" class="borderright borderbottom">2000</td>
        <td align="center" valign="middle" class="borderright borderbottom">200</td>
        <td align="center" valign="middle" class="borderright borderbottom">9800</td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom">1</td>
        <td align="center" valign="middle" class="borderright borderbottom">张三</td>
        <td align="center" valign="middle" class="borderright borderbottom">组长</td>
        <td align="center" valign="middle" class="borderright borderbottom">8000</td>
        <td align="center" valign="middle" class="borderright borderbottom">2000</td>
        <td align="center" valign="middle" class="borderright borderbottom">200</td>
        <td align="center" valign="middle" class="borderright borderbottom">9800</td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom">1</td>
        <td align="center" valign="middle" class="borderright borderbottom">张三</td>
        <td align="center" valign="middle" class="borderright borderbottom">组长</td>
        <td align="center" valign="middle" class="borderright borderbottom">8000</td>
        <td align="center" valign="middle" class="borderright borderbottom">2000</td>
        <td align="center" valign="middle" class="borderright borderbottom">200</td>
        <td align="center" valign="middle" class="borderright borderbottom">9800</td>
      </tr>
 -->
    </table></td>
    </tr>
<!--   <tr>
    <td align="left" valign="top" class="fenye">11 条数据 1/1 页&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">首页</a>&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">尾页</a></td>
  </tr> -->
</table>
</body>
</html>
