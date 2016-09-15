function getRecordList() {
	var url="/company/servlet/AttendanceRecordListSelf";
	
	var year = document.getElementById("year").value;
	var month = document.getElementById("month").value;
	var params = "year=" + year + "&month=" + month;
	
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
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">日期</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">签到时间</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">签退时间</th>"
					+"</tr>");
			for(var i=0;i<array.length;i++){
                $("#main-tab").append(" <tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].day+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].inTime+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].outTime+"</td>"
					+"</tr>");
			} 
		}
	})
}

function getAttendanceList() {
	var url="/company/servlet/AttendanceListSelf";
	
	var year = document.getElementById("year").value;
	var month = document.getElementById("month").value;
	var params = "year=" + year + "&month=" + month;
	
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
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">日期</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">是否迟到</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">是否缺勤</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">是否被批免</th>"
					+"<th align=\"center\" valign=\"middle\" class=\"borderright\">罚金</th>"
					+"</tr>");
			for(var i=0;i<array.length;i++){
                $("#main-tab").append(" <tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].day+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].isLate+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].isAbsent+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].isAllowed+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].penalty+"</td>"
					+"</tr>");
			} 
		}
	})
}

//____________________________________________________________________manager
function getRecordListByDay(department) {
	var url="/company/servlet/AttendanceRecordListByDay";
	
	var day = document.getElementById("day").value;
	var params = "day=" + day+"&department="+department;
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
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">日期</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">签到时间</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">签退时间</th>"
					+"</tr>");
			for(var i=0;i<array.length;i++){
                $("#main-tab").append(" <tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">"
                		+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].eid+"</td>"
                		+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].name+"</td>"
                		+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].day+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].inTime+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].outTime+"</td>"
					+"</tr>");
			} 
		}
	})
}

function getRecordListByEid(department) {
	
	var url="/company/servlet/AttendanceRecordListByEid";
	
	var eid = document.getElementById("eid").value;
	var params = "eid=" + eid+"&department="+department;
	
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
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">日期</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">签到时间</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">签退时间</th>"
					+"</tr>");
			for(var i=0;i<array.length;i++){
                $("#main-tab").append(" <tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">"
                		+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].eid+"</td>"
                		+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].name+"</td>"
                		+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].day+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].inTime+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].outTime+"</td>"
					+"</tr>");
			} 
		}
	})
}

function getListByDay(department) {
	var url="/company/servlet/AttendanceListByDay";
	
	var day = document.getElementById("day").value;
	var params = "day=" + day+"&department="+department;
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
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">日期</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">是否迟到</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">是否缺勤</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">是否被批免</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">罚金</th>"
					+"</tr>");
			for(var i=0;i<array.length;i++){
                $("#main-tab").append(" <tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">"
                		+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].eid+"</td>"
                		+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].name+"</td>"
                		+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].day+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].isLate+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].isAbsent+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].isAllowed+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].penalty+"</td>"
					+"</tr>");
			} 
		}
	})
}

function getListByEid(department) {
	
	var url="/company/servlet/AttendanceListByEid";
	
	var eid = document.getElementById("eid").value;
	var params = "eid=" + eid+"&department="+department;
	
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
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">日期</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">是否迟到</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">是否缺勤</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">是否被批免</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">罚金</th>"
					+"</tr>");
			for(var i=0;i<array.length;i++){
                $("#main-tab").append(" <tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">"
                		+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].eid+"</td>"
                		+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].name+"</td>"
                		+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].day+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].isLate+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].isAbsent+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].isAllowed+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].penalty+"</td>"
					+"</tr>");
			} 
		}
	})
}



function getAttendanceCountMonthly(department){
	
	var url="/company/servlet/AttendanceCountMonthly";
	
	var year = document.getElementById("year").value;
	var month = document.getElementById("month").value;
	
	var params = "year="+year+"&month=" + month+"&department="+department;
	
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
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">月份</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">月迟到次数</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">月缺勤次数</th>"
						+"<th align=\"center\" valign=\"middle\" class=\"borderright\">罚金</th>"
					+"</tr>");
			for(var i=0;i<array.length;i++){
                $("#main-tab").append(" <tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">"
                		+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].eid+"</td>"
                		+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].name+"</td>"
                		+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+year+"-"+month+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].countLate+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].countAbsent+"</td>"
						+"<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">"+array[i].penalty+"</td>"
					+"</tr>");
			} 
		}
	})
}