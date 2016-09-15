function getSalaryList() {
	var url="/company/servlet/SalaryListSelf";
	
	var year = document.getElementById("year").value;
	var params="year="+year;
	//var month = document.getElementById("month").value;
	//var params = "year=" + year + "&month=" + month;
	alert(params);
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

