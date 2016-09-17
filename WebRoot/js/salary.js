function getSalaryList() {
	var url="/company/servlet/SalaryListSelf";
	
	var year = document.getElementById("year").value;
	var params="year="+year;
	//var month = document.getElementById("month").value;
	//var params = "year=" + year + "&month=" + month;
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
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">年月</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">基本工资</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">奖金</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">罚金</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">总计</th>"
					+"</tr>");
			for(var i=0;i<array.length;i++){
                $("#main-tab").append(" <tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].year+"-"+array[i].month+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].basic+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].bonus+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].penalty+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].total+"</td>"
					+"</tr>");
			} 
		}
	})
}

//-------------------------------------manage

function getSalaryListByMonth(department) {
	var url="/company/servlet/SalaryListByMonth";
	
	var year = document.getElementById("year").value;
	var month = document.getElementById("month").value;
	var params="year="+year+"&month="+month+"&department="+department;
	//var month = document.getElementById("month").value;
	//var params = "year=" + year + "&month=" + month;
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
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">年月</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">基本工资</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">奖金</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">罚金</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">总计</th>"
					+"</tr>");
			for(var i=0;i<array.length;i++){
                $("#main-tab").append(" <tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">"
            			+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].eid+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].name+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].year+"-"+array[i].month+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].basic+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].bonus+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].penalty+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].total+"</td>"
					+"</tr>");
			} 
		}
	})
}


function getSalaryListByEid(department) {
	var url="/company/servlet/SalaryListByEid";
	
	var eid = document.getElementById("eid").value;
	var params="eid="+eid+"&department="+department;
	//var month = document.getElementById("month").value;
	//var params = "year=" + year + "&month=" + month;
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
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">年月</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">基本工资</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">奖金</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">罚金</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">总计</th>"
					+"</tr>");
			for(var i=0;i<array.length;i++){
                $("#main-tab").append(" <tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">"
            			+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].eid+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].name+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].year+"-"+array[i].month+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].basic+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].bonus+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].penalty+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].total+"</td>"
					+"</tr>");
			} 
		}
	})
}

function getUnsetList(department) {
	var url="/company/servlet/SalaryListUnset";
	
	var year = document.getElementById("year").value;
	var month = document.getElementById("month").value;
	var params="year="+year+"&month="+month+"&department="+department;
	//var month = document.getElementById("month").value;
	//var params = "year=" + year + "&month=" + month;
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
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">年月</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">等级</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">奖金</th>"
						+"<th align=\"center\" valign=\"middle\">操作</th>"
					+"</tr>");
			for(var i=0;i<array.length;i++){
                $("#main-tab").append(" <tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">"
            			+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].eid+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].name+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+year+"-"+month+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].level+"</td>"
						//+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\" id=\""+array[i].eid+"\">"+"999"+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\"><input type=\"text\" id=\""+array[i].eid+"\"></td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderbottom\"><a href=\"\" onclick=\"salaryAdd("+array[i].eid+","+year+","+month+")\" target=\"mainFrame\" onFocus=\"this.blur()\" class=\"add\">提交</a>"
					+"</tr>");
			} 
		}
	})
}

function salaryAdd(eid,year,month){
	var bonus=document.getElementById(eid).value;

	
	var url="/company/servlet/SalaryAdd";
	var params="eid="+eid+"&year="+year+"&month="+month+"&bonus="+bonus;
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
				alert("设置成功");
			}else{
				//document.getElementById("msg").innerHTML="修改失败";
				alert("设置失败");
			}
		}
	})
	
//	var url="/company/servlet/SalaryListUnset";
//	var params="year="+year+"&month="+month+"&department="+department;
//	$.ajax({
//		type:'POST',
//		url:url,
//		dataType:'html',
//		data:params,
//		beforeSend:function(){},
//		complete:function(){},
//		success:function(json){
//			var datas = eval('(' + json + ')');
//			var array=datas.array;
//			$("#main-tab").empty();
//			$("#main-tab").append("<tr>"
//						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">编号</th>"
//						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">姓名</th>"
//						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">年月</th>"
//						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">等级</th>"
//						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">奖金</th>"
//						+"<th align=\"center\" valign=\"middle\">操作</th>"
//					+"</tr>");
//			for(var i=0;i<array.length;i++){
//                $("#main-tab").append(" <tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">"
//            			+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].eid+"</td>"
//						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].name+"</td>"
//						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+year+"-"+month+"</td>"
//						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].level+"</td>"
//						//+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\" id=\""+array[i].eid+"\">"+"999"+"</td>"
//						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\"><input type=\"text\" id=\""+array[i].eid+"\"></td>"
//						+"<td align=\"center\" valign=\"middle\" class=\"borderbottom\"><a href=\"\" onclick=\"salaryAdd("+array[i].eid+","+year+","+month+","+department+")\" target=\"mainFrame\" onFocus=\"this.blur()\" class=\"add\">提交</a>"
//					+"</tr>");
//			} 
//		}
//	})
	
	
}

function getSalaryListByMonthBoss() {
	var url="/company/servlet/SalaryListByMonthB";
	
	var year = document.getElementById("year").value;
	var month = document.getElementById("month").value;
	var params="year="+year+"&month="+month;
	//var month = document.getElementById("month").value;
	//var params = "year=" + year + "&month=" + month;
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
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">年月</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">基本工资</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">奖金</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">罚金</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">总计</th>"
					+"</tr>");
			for(var i=0;i<array.length;i++){
                $("#main-tab").append(" <tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">"
            			+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].eid+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].name+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].year+"-"+array[i].month+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].basic+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].bonus+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].penalty+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].total+"</td>"
					+"</tr>");
			} 
		}
	})
}


function getSalaryListByEidBoss() {
	var url="/company/servlet/SalaryListByEidB";
	
	var eid = document.getElementById("eid").value;
	var params="eid="+eid;
	//var month = document.getElementById("month").value;
	//var params = "year=" + year + "&month=" + month;
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
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">年月</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">基本工资</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">奖金</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">罚金</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">总计</th>"
					+"</tr>");
			for(var i=0;i<array.length;i++){
                $("#main-tab").append(" <tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">"
            			+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].eid+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].name+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].year+"-"+array[i].month+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].basic+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].bonus+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].penalty+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].total+"</td>"
					+"</tr>");
			} 
		}
	})
}

function getUnsetListBoss() {
	var url="/company/servlet/SalaryListUnsetB";
	
	var year = document.getElementById("year").value;
	var month = document.getElementById("month").value;
	var params="year="+year+"&month="+month;
	//var month = document.getElementById("month").value;
	//var params = "year=" + year + "&month=" + month;
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
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">年月</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">等级</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">奖金</th>"
						+"<th align=\"center\" valign=\"middle\">操作</th>"
					+"</tr>");
			for(var i=0;i<array.length;i++){
                $("#main-tab").append(" <tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">"
            			+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].eid+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].name+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+year+"-"+month+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].level+"</td>"
						//+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\" id=\""+array[i].eid+"\">"+"999"+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\"><input type=\"text\" id=\""+array[i].eid+"\"></td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderbottom\"><a href=\"\" onclick=\"salaryAdd("+array[i].eid+","+year+","+month+")\" target=\"mainFrame\" onFocus=\"this.blur()\" class=\"add\">提交</a>"
					+"</tr>");
			} 
		}
	})
}

function salaryAdd(eid,year,month){
	var bonus=document.getElementById(eid).value;

	
	var url="/company/servlet/SalaryAdd";
	var params="eid="+eid+"&year="+year+"&month="+month+"&bonus="+bonus;
	//alert(params);
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
				alert("设置成功");
			}else{
				//document.getElementById("msg").innerHTML="修改失败";
				alert("设置失败");
			}
		}
	})
	
//	var url="/company/servlet/SalaryListUnset";
//	var params="year="+year+"&month="+month+"&department="+department;
//	$.ajax({
//		type:'POST',
//		url:url,
//		dataType:'html',
//		data:params,
//		beforeSend:function(){},
//		complete:function(){},
//		success:function(json){
//			var datas = eval('(' + json + ')');
//			var array=datas.array;
//			$("#main-tab").empty();
//			$("#main-tab").append("<tr>"
//						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">编号</th>"
//						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">姓名</th>"
//						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">年月</th>"
//						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">等级</th>"
//						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">奖金</th>"
//						+"<th align=\"center\" valign=\"middle\">操作</th>"
//					+"</tr>");
//			for(var i=0;i<array.length;i++){
//                $("#main-tab").append(" <tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">"
//            			+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].eid+"</td>"
//						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].name+"</td>"
//						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+year+"-"+month+"</td>"
//						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].level+"</td>"
//						//+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\" id=\""+array[i].eid+"\">"+"999"+"</td>"
//						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\"><input type=\"text\" id=\""+array[i].eid+"\"></td>"
//						+"<td align=\"center\" valign=\"middle\" class=\"borderbottom\"><a href=\"\" onclick=\"salaryAdd("+array[i].eid+","+year+","+month+","+department+")\" target=\"mainFrame\" onFocus=\"this.blur()\" class=\"add\">提交</a>"
//					+"</tr>");
//			} 
//		}
//	})
	
	
}