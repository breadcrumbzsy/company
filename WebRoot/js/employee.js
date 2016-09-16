function login() {

	var eid = document.getElementById("eid").value;
	var password = document.getElementById("password").value;
	var params = "eid=" + eid + "&password=" + password;
//	var sendinfo;
	var url="/company/servlet/EmployeeLogin";
	$.ajax({
		type : 'POST',
		url : url,
		dataType : 'html',
		data : params,
		beforeSend : function() {
			
		},
		complete : function() {

		},
		success : function(html) {
			var jsonto = eval('(' + html + ')');
			if (jsonto.result == 1) {
				window.location = "/company/index_zjl.jsp";
			} else if(jsonto.result==2){
				window.location = "/company/index_bmjl.jsp";
			} else if(jsonto.result==3){
				window.location = "/company/index_yg.jsp";
			}else{
				 alert("登录失败");
			}


		}
	});
}

function modifyPassword() {

	var oldPassword=document.getElementById("oldPassword").value;
	var newPassword1=document.getElementById("newPassword1").value;
	var newPassword2=document.getElementById("newPassword2").value;
	

	if(newPassword1!=newPassword2){
		//document.getElementById("msg").innerHTML="两次输入的新密码不一致";
		alert("两次输入的新密码不一致");

	}else if(newPassword1.length>18||newPassword1.length<6){
		//document.getElementById("msg").innerHTML="新密码不符合要求";
		alert("新密码不符合要求");
		
	}else{
		var url="/company/servlet/EmployeePasswordModify";
		var params="oldPassword="+oldPassword+"&newPassword="+newPassword1;
		$.ajax({
			type:'POST',
			url:url,
			dataType:'html',
			data:params,
			beforeSend:function(){
				
			},
			complete:function(){
				
			},
			success:function(html){
				var jsonto=eval('('+html+')');
				if(jsonto.result==1){
					//document.getElementById("msg").innerHTML="修改成功";
					alert("修改成功");
				}else{
					//document.getElementById("msg").innerHTML="修改失败";
					alert("修改失败");
				}
			}
		})
	}
	

}
function getListById(department){//貌似这个方法没用
//	var url="/company/servlet/EmployeeInfoByEid";
//	
//	var eid = document.getElementById("eid").value;
//	var params = "department=" + department+"&eid="+eid;
//	alert(params);
//	$.ajax({
//		type:'POST',
//		url:url,
//		dataType:'html',
//		data:params,
//		beforeSend:function(){},
//		complete:function(){},
//		success:function(json){
//			var datas = eval('(' + json + ')');
//	
//			$("#main-tab").empty();
//			$("#main-tab").append("<tr>"
//					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">员工编号</th>"
//					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">姓名</th>"
//					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">电子邮箱</th>"
//					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">联系电话</th>"
//					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">入职时间</th>"
//					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">等级</th>"
//					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">部门</th>"
//					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">是否在职</th>"
//					+"<th align=\"center\" valign=\"middle\">操作</th>"
//					+"</tr>");
//			for(var i=0;i<array.length;i++){
//                $("#main-tab").append(" <tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">"
//						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+datas.eid+"</td>"
//						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+datas.name+"</td>"
//						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+datas.email+"</td>"
//						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+datas.tel+"</td>"
//						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+datas.enrollTime+"</td>"
//						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+datas.level+"</td>"
//						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+datas.department+"</td>"
//						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+datas.shifouzaizhi+"</td>"
//						+"<td align=\"center\" valign=\"middle\" class=\"borderbottom\"><a href=\"employeeInfoDetail.jsp?eid="+datas.eid+"\" target=\"mainFrame\" onFocus=\"this.blur()\" class=\add\">详情</a><span class=\"gray\">&nbsp;|&nbsp;</span><a href=\"employeeModify.jsp?eid="+datas.eid+"\" target=\"mainFrame\" onFocus=\"this.blur()\" class=\"add\">编辑</a><span class=\"gray\">&nbsp;|&nbsp;</span><a href=\"EmployeeQuit?eid="+datas.eid+"\" target=\"mainFrame\" onFocus=\"this.blur()\" class=\"add\">设为离职</a></td>"
//						+"</tr>");
//			} 
//		}
//	})	
}


function getEmployeeList(department) {
	var url="/company/servlet/EmployeeList";
	var params = "department=" + department;
//	alert(params);
	$.ajax({
		type:'POST',
		url:url,
		dataType:'html',
		data:params,
		beforeSend:function(){},
		complete:function(){},
		success:function(json){
			var datas = eval('(' + json + ')');
			var array=datas.array;
			$("#main-tab").empty();
			$("#main-tab").append("<tr>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">员工编号</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">姓名</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">电子邮箱</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">联系电话</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">入职时间</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">等级</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">部门</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">是否在职</th>"
					+"<th align=\"center\" valign=\"middle\">操作</th>"
					+"</tr>");
			for(var i=0;i<array.length;i++){
		
                $("#main-tab").append(" <tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].eid+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].name+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].email+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].tel+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].enrollTime+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].level+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].department+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].shifouzaizhi+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderbottom\"><a href=\"employeeInfoDetail.jsp?eid="+array[i].eid+"&department="+department+"\" target=\"mainFrame\" onFocus=\"this.blur()\" class=\add\">详情</a><span class=\"gray\">&nbsp;|&nbsp;</span><a href=\"employeeModify.jsp?eid="+array[i].eid+"&department="+department+"\" target=\"mainFrame\" onFocus=\"this.blur()\" class=\"add\">编辑</a><span class=\"gray\">&nbsp;|&nbsp;</span><a href=\"../servlet/EmployeeQuit?eid="+array[i].eid+"\" target=\"mainFrame\" onFocus=\"this.blur()\" class=\"add\">设为离职</a></td>"
						+"</tr>");
			} 
		}
	})
}

function getListByName(department){
	var url="/company/servlet/EmployeeInfoByName";
	
	var name = document.getElementById("name").value;
	var params = "department=" + department+"&name="+name;
//	alert(params);
	$.ajax({
		type:'POST',
		url:url,
		dataType:'html',
		data:params,
		beforeSend:function(){},
		complete:function(){},
		success:function(json){
			var datas = eval('(' + json + ')');
			var array=datas.array;
			$("#main-tab").empty();
			$("#main-tab").append("<tr>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">编号</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">姓名</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">电子邮箱</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">联系电话</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">入职时间</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">等级</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">部门</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">是否在职</th>"
					+"<th align=\"center\" valign=\"middle\">操作</th>"
					+"</tr>");
			for(var i=0;i<array.length;i++){
		
                $("#main-tab").append(" <tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].eid+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].name+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].email+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].tel+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].enrollTime+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].level+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].department+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].shifouzaizhi+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderbottom\"><a href=\"employeeInfoDetail.jsp?eid="+array[i].eid+"&department="+department+"\" target=\"mainFrame\" onFocus=\"this.blur()\" class=\add\">详情</a><span class=\"gray\">&nbsp;|&nbsp;</span><a href=\"employeeModify.jsp?eid="+array[i].eid+"&department="+department+"\" target=\"mainFrame\" onFocus=\"this.blur()\" class=\"add\">编辑</a><span class=\"gray\">&nbsp;|&nbsp;</span><a href=\"../servlet/EmployeeQuit?eid="+array[i].eid+"\" target=\"mainFrame\" onFocus=\"this.blur()\" class=\"add\">设为离职</a></td>"
						+"</tr>");
			} 
		}
	})		
}
function getListByEid(department){
	var url="/company/servlet/EmployeeInfoByEid";
	
	var eid = document.getElementById("eid").value;
	var params = "department=" + department+"&eid="+eid;
//	alert(params);
	$.ajax({
		type:'POST',
		url:url,
		dataType:'html',
		data:params,
		beforeSend:function(){},
		complete:function(){},
		success:function(json){
			var datas = eval('(' + json + ')');

			$("#main-tab").empty();
			$("#main-tab").append("<tr>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">编号</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">姓名</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">电子邮箱</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">联系电话</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">入职时间</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">等级</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">部门</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">是否在职</th>"
					+"<th align=\"center\" valign=\"middle\">操作</th>"
					+"</tr>");
			if(datas.eid!=null){
                $("#main-tab").append(" <tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+datas.eid+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+datas.name+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+datas.email+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+datas.tel+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+datas.enrollTime+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+datas.level+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+datas.department+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+datas.shifouzaizhi+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderbottom\"><a href=\"employeeInfoDetail.jsp?eid="+datas.eid+"&department="+department+"\" target=\"mainFrame\" onFocus=\"this.blur()\" class=\add\">详情</a><span class=\"gray\">&nbsp;|&nbsp;</span><a href=\"employeeModify.jsp?eid="+datas.eid+"&department="+department+"\" target=\"mainFrame\" onFocus=\"this.blur()\" class=\"add\">编辑</a><span class=\"gray\">&nbsp;|&nbsp;</span><a href=\"../servlet/EmployeeQuit?eid="+datas.eid+"\" target=\"mainFrame\" onFocus=\"this.blur()\" class=\"add\">设为离职</a></td>"
						+"</tr>");
			} 
		}
	})		
}

function getEmployeeDetail(eid,department){
	//var eid = document.getElementById("eid").value;
	var params = "eid=" + eid+"&department="+department;
//	var sendinfo;
	var url="/company/servlet/EmployeeInfoByEid";
	$.ajax({
		type : 'POST',
		url : url,
		dataType : 'html',
		data : params,
		beforeSend : function() {
			
		},
		complete : function() {

		},
		success : function(json) {
			var datas = eval('(' + json + ')');
			$("#eid").attr("value", datas.eid);
			$("#name").attr("value", datas.name);
			$("#gender").attr("value", datas.gender);
			$("#email").attr("value", datas.email);
			$("#tel").attr("value", datas.tel);
			$("#enrollTime").attr("value", datas.enrollTime);
			$("#level").attr("value", datas.level);
			$("#department").attr("value", datas.department);
			$("#shifouzaizhi").attr("value", datas.shifouzaizhi);
			
			var skills=datas.skillArray;
			var trainings=datas.trainingArray;
			
			for(var i=0;i<skills.length;i++){
				$("#skillput").append("<input type=\"text\" name=\"\" value=\""+skills[i].description+"\" class=\"text-word-fix-short\" readonly=\"readonly\">");
			}
			for(var i=0;i<trainings.length;i++){
				$("#trainingput").append("<input type=\"text\" name=\"\" value=\""+trainings[i].description+"\" class=\"text-word-fix-short\" readonly=\"readonly\">");
			}
		}
	});
}

function employeeAdd() {
	var eid=document.getElementById("eid").value;
	var name=document.getElementById("name").value;
	var gender=document.getElementById("gender").value;
	var email=document.getElementById("email").value;
	var tel=document.getElementById("tel").value;
	var enrollTime=document.getElementById("enrollTime").value;
	var level=document.getElementById("level").value;
	var department=document.getElementById("department").value;
	var password=document.getElementById("password").value;
	
	var skillArray=document.getElementsByName("skillInput");
	var skillString="|";
	for(var i=0;i<skillArray.length;i++){
		if(skillArray.item(i).value.length!=0){
			skillString=skillString+skillArray.item(i).value+"|";
		}
		
	}
	var trainingArray=document.getElementsByName("trainingInput");
	var trainingString="|";
	for(var i=0;i<trainingArray.length;i++){
		if(trainingArray.item(i).value.length!=0)
			trainingString=trainingString+trainingArray.item(i).value+"|";
	}

	var url="/company/servlet/EmployeeAdd";
	var params="eid="+eid+"&name="+name+"&gender="+gender+"&email="+email+"&tel="+tel+"&enrollTime="+enrollTime+"&level="+level+"&department="+department+"&password="+password+"&skillString="+skillString+"&trainingString="+trainingString;
	alert(params);
	$.ajax({
		type:'POST',
		url:url,
		dataType:'html',
		data:params,
		beforeSend:function(){
			
		},
		complete:function(){
			
		},
		success:function(html){
			var jsonto=eval('('+html+')');
			if(jsonto.result==1){
				//document.getElementById("msg").innerHTML="修改成功";
				alert("添加成功");
			}else{
				//document.getElementById("msg").innerHTML="修改失败";
				alert("添加失败");
			}
		}
	})
}

function employeeModify() {
	var eid=document.getElementById("eid").value;
	var email=document.getElementById("email").value;
	var tel=document.getElementById("tel").value;
	var level=document.getElementById("level").value;
	var department=document.getElementById("department").value;
	var shifouzaizhi=document.getElementById("shifouzaizhi").value;
	//skill…&training也可以修改！！！！！！！！！

	var url="/company/servlet/EmployeeModify";
	var params="eid="+eid+"&email="+email+"&tel="+tel+"&level="+level+"&department="+department+"&shifouzaizhi="+shifouzaizhi;
	alert(params);
	$.ajax({
		type:'POST',
		url:url,
		dataType:'html',
		data:params,
		beforeSend:function(){
			
		},
		complete:function(){
			
		},
		success:function(html){
			var jsonto=eval('('+html+')');
			if(jsonto.result==1){
				//document.getElementById("msg").innerHTML="修改成功";
				alert("修改成功");
			}else{
				//document.getElementById("msg").innerHTML="修改失败";
				alert("修改失败");
			}
		}
	})
}

function getEmployeeModifyDetail(eid,department){
	//var eid = document.getElementById("eid").value;
	var params = "eid=" + eid+"&department="+department;
//	var sendinfo;
	var url="/company/servlet/EmployeeInfoByEid";
	$.ajax({
		type : 'POST',
		url : url,
		dataType : 'html',
		data : params,
		beforeSend : function() {
			
		},
		complete : function() {

		},
		success : function(json) {
			var datas = eval('(' + json + ')');
			$("#eid").attr("value", datas.eid);
			$("#name").attr("value", datas.name);
			$("#gender").attr("value", datas.gender);
			$("#email").attr("value", datas.email);
			$("#tel").attr("value", datas.tel);
			$("#enrollTime").attr("value", datas.enrollTime);
			$("#level").attr("value", datas.level);
			$("#department").attr("value", datas.department);
			$("#shifouzaizhi").attr("value", datas.shifouzaizhi);
			
			var skills=datas.skillArray;
			var trainings=datas.trainingArray;
			
			for(var i=0;i<skills.length;i++){
				$("#skillput").append("<input type=\"text\" name=\"\" value=\""+skills[i].description+"\" class=\"text-word-fix-short\" readonly=\"readonly\"><a href=\"../servlet/EmployeeSkillDelete?sklid="+skills[i].sklid+"\">  ⓧ  </a></input>");
			}
			$("#skillput").append("<input type=\"button\" value=\"添加\" id=\"skillButton\" onclick=\"addSkillInputBoxModify("+eid+")\" >");
			for(var i=0;i<trainings.length;i++){
				$("#trainingput").append("<input type=\"text\" name=\"\" value=\""+trainings[i].description+"\" class=\"text-word-fix-short\" readonly=\"readonly\"><a href=\"../servlet/EmployeeTrainingDelete?tid="+trainings[i].tid+"\">  ⓧ  </a></input>");
			}
			$("#trainingput").append("<input type=\"button\" value=\"添加\" id=\"trainingButton\" onclick=\"addTrainingInputBoxModify("+eid+")\" >");
		}
	});
}

function addSkillInputBoxModify(eid){
	$("#skillput").append("<input type=\"text\" id=\"newSkill\" value=\"\" class=\"text-word-short\" >");
	$("#skillButton").attr("value", "提交");
	$("#skillButton").attr("onclick","submitAddSkill("+eid+")");
	 return false;  
}
function addTrainingInputBoxModify(eid){
	$("#trainingput").append("<input type=\"text\" id=\"newTraining\" value=\"\" class=\"text-word-short\" >");
	$("#trainingButton").attr("value", "提交");
	$("#trainingButton").attr("onclick", "submitAddTraining("+eid+")");
	 return false;  
}

function submitAddSkill(eid){
	var description=document.getElementById("newSkill").value;
	var params="eid="+eid+"&description="+description;
	
	var url="/company/servlet/EmployeeSkillAdd";
//	$("#skillButton").attr("value", "添加");
//	$("#skillButton").attr("onclick","addSkillInputBoxModify("+eid+")");
	$.ajax({
		type:'POST',
		url:url,
		dataType:'html',
		data:params,
		beforeSend:function(){
			
		},
		complete:function(){
			
		},
		
		success:function(html){
			var jsonto=eval('('+html+')');
			if(jsonto.result==1){
				//document.getElementById("msg").innerHTML="修改成功";
				alert("添加成功");
			}else{
				//document.getElementById("msg").innerHTML="修改失败";
				alert("添加失败");
			}
		}
	})
	window.location.reload();
	$("#skillButton").attr("value", "添加");
	$("#skillButton").attr("onclick","addSkillInputBoxModify("+eid+")");
}

function submitAddTraining(eid){
	var description=document.getElementById("newTraining").value;
	var params="eid="+eid+"&description="+description;
	
	var url="/company/servlet/EmployeeTrainingAdd";
	$.ajax({
		type:'POST',
		url:url,
		dataType:'html',
		data:params,
		beforeSend:function(){
			
		},
		complete:function(){
			
		},
		success:function(html){
			var jsonto=eval('('+html+')');
			if(jsonto.result==1){
				//document.getElementById("msg").innerHTML="修改成功";
				alert("添加成功");
			}else{
				//document.getElementById("msg").innerHTML="修改失败";
				alert("添加失败");
			}
		}
	})
	window.location.reload();
	$("#trainingButton").attr("value", "添加");
	$("#skillButton").attr("onclick","addTrainingInputBoxModify("+eid+")");
}