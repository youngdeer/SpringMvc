/**
 * 注册账号提交
 * luy
 */
function submitRegist(){
	var username = $("#username").val().trim();
	var password = $("#password").val().trim();
	var passwordrepeat = $("#password-repeat").val().trim();
	if(username == "" || password == "" || passwordrepeat ==""){
		alert("something is empty!");
		return false;
	}
	
	if(password != passwordrepeat){
		alert("password and password-repeat is not same!");
		return false;
	}
	var inputData = {
		"username" : username,
		"password" : password
	}
	ajax("post",basePath+"deerSYS/submitRegist.do",inputData,function(data){
		if(data.result == 1){
			alert("success");
		}else if(data.result == 2){
			alert("username is exist");
		};
	});
}