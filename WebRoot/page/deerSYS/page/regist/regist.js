/**
 * 注册账号提交
 * luy
 */
function submitRegist(){
	ajax("post",basePath+"deerSYS/submitRegist.html",{name:"deer"},function(data){
		alert(data.result);
	});
}