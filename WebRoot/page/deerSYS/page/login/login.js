/**
 * 用户登陆
 * deer
 */
function userLogin(){
	var username = $("#username").val().trim();
	var password = $("#password").val().trim();
	
	if(username == "" || password == ""){
		alert("something is empty!");
		return false;
	}
	
	var inputData = {
		"username" : username,
		"password" : password
	}
	
	ajax("post",basePath+"deerSYS/userLogin.do",inputData,function(data){
		if(data.result == 1){
			alert("login success");
		}else if(data.result == 2){
			alert("login fail");
		};
	});
}