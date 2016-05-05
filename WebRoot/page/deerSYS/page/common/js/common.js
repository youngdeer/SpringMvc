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
			window.location = basePath+"deerSYS/to"+tableName+"List.do";
	});
}


/**
 * 列表条件搜索封装
 * form id必须为headSearch
 */
function search(tableName){
	var data = "{";
	$("#headSearch").find("input").each(function(index,item){
		var key = $(item).attr("id");
		var value = $(item).val();
		data += ""+key+":'"+value+"',";
	});
	data +="}";
	window.location = basePath+"deerSYS/to"+tableName+"List.do?searchData="+data;
}


/**
 * 下一页封装
 * form id必须为headSearch
 */
function next(tableName){
	$("#pageNo").val(Number($("#pageNo").val())+1);
	search(tableName);
}

/**
 * 上一页封装
 * form id必须为headSearch
 */
function previous(tableName){
	$("#pageNo").val(Number($("#pageNo").val())-1);
	search(tableName);
}