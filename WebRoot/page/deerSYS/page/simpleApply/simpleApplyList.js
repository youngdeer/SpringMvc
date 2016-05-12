/**
 * 流程操作
 * deer
 */
function doAction(simpleApplyId){
	ajax("post",basePath+"deerSYS/SimpleApply/doAction.do",
		{
			"simpleApplyId":simpleApplyId
		},function(data){
			alert(data);
			window.location.reload();
	});
}