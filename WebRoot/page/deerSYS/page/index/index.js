function getHtml(){
	ajax("get",basePath+"deerSYS/getHtml.json",{},function(data){
		alert(data.command);
		$("#getHtmlFromController").append(data.command);
	});
}