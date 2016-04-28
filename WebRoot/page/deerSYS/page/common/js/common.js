/**
 * ajax封装
 * deer
 */
function ajax(type,url,data,callback){
	 $.ajax({
         type: type,
         url: url,
         data: data,
         dataType: "json",
         success: callback
     });
}

/**
 * save单表封装
 * param tableName
 */
function save(tableName){
	var data = "{";
	$("#"+tableName).find("input").each(function(index,item){
		var key = $(item).attr("id");
		var value = $(item).val();
		data += ""+key+":'"+value+"',";
	});
	data +="}";
	ajax("post",basePath+"deerSYS/save.do",
		{
			"tableName":tableName,
			"data":data
		},function(data){
			alert(data);
			window.location = basePath+"deerSYS/toUserInfoList.do";
	});
}