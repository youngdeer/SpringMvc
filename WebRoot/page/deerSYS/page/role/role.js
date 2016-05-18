window.onload = function(){
	ajax("get",basePath+"deerSYS/getRoleList.do",{},function(data){
		$.each(data,function(index,item){
			$("#parentRole").append("<option value='"+item.roleId+"'>"+item.roleName+"</option>");
		});
	});
	
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
 * parentRole  select onchange方法
 * deer
 */
function chooseParentRole(obj){
	$("#parentId").val($(obj).val());
}

/**
 * 组装roleTree
 * deer
 */
function renderRoleTree(data,render){
	render.content += "<ul>"
	$.each(data,function(index,item){
		render.content +="<li><span><i class='icon-folder-open'></i>"+item.roleName+"</span> <a href=''></a>";
		if(item.children.length > 0){
			renderRoleTree(item.children,render);
		}
		render.content +="</li>";
	});
	render.content += "</ul>";
}