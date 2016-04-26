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
	
}