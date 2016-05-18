window.onload = function(){
	ajax("get",basePath+"deerSYS/getRoleTree.do",{},function(data){
		var render = {
			content : ""
		};
		renderRoleTree(data,render);
//		alert(render.content);
		$("#roleTree").append(render.content);
		
		$('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title', 'Collapse this branch');
  　　	$('.tree li.parent_li > span').on('click', function (e) {
    　　		var children = $(this).parent('li.parent_li').find(' > ul > li');
    　　		if (children.is(":visible")) {
      　　			children.hide('fast');
      　　			$(this).attr('title', 'Expand this branch').find(' > i').addClass('icon-plus-sign').removeClass('icon-minus-sign');
    　　		} else {
      　　			children.show('fast');
      　　			$(this).attr('title', 'Collapse this branch').find(' > i').addClass('icon-minus-sign').removeClass('icon-plus-sign');
    　　		}
    　　		e.stopPropagation();
  　　	});
	});
	
	
}


/**
 * 组装roleTree
 * deer
 */
function renderRoleTree(data,render){
	render.content += "<ul>"
	$.each(data,function(index,item){
		render.content +="<li><input type='checkbox' value='"+item.roleId+"'/><span><i class='icon-folder-open'></i>"+item.roleName+"</span>";
		if(item.children.length > 0){
			renderRoleTree(item.children,render);
		}
		render.content +="</li>";
	});
	render.content += "</ul>";
}


/**
 * userrole关系绑定前操作
 * deer
 */
function beforeBind(){
	var checkedUser = ""
	$("#userList").find("input[type='checkbox']").each(function(index,item){
		if($(item).prop("checked")){
//			alert("userlist: "+$(item).val());
			checkedUser += $(item).val()+",";
		}
	});
	
	var checkedRole = "";
	$("#roleTree").find("input[type='checkbox']").each(function(index,item){
		if($(item).prop("checked")){
//			alert("roleTree: "+$(item).val());
			checkedRole += $(item).val()+",";
		}
	});
	
	$("#checkedUser").val(checkedUser);
	$("#checkedRole").val(checkedRole);
}

/**
 * userrole绑定操作
 * deer
 */
function bind(){
	beforeBind();
	ajax("post",basePath+"deerSYS/submitUserRole.do",{
		checkedUser:$("#checkedUser").val(),
		checkedRole:$("#checkedRole").val(),
	},function(data){
		
	});
}
