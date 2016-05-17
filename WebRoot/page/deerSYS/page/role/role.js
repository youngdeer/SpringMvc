window.onload = function(){
	ajax("get",basePath+"deerSYS/getRoleList.do",{},function(data){
		$.each(data,function(index,item){
			$("#parentRole").append("<option value='"+item.roleId+"'>"+item.roleName+"</option>");
		});
	});
}

/**
 * parentRole  select onchange方法
 * deer
 */
function chooseParentRole(obj){
	$("#parentId").val($(obj).val());
}