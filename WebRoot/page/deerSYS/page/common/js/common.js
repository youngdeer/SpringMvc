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