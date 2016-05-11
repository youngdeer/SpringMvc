function beforeSave(){
	ajax("post",basePath+"deerSYS/SimpleApply/beforeSave.do",{},function(data){
//		alert("workflowId: "+data.workflowId);
//		alert("workflowStatus: "+data.workflowStatus);
		$("#workflowId").val(data.workflowId);
		$("#workflowStatus").val(data.workflowStatus);
		save("simpleApply");
	});
}