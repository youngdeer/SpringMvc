window.onload = function(){
	ajax("get",basePath+"deerSYS/getRoleList.do",{},function(data){
		$.each(data,function(index,item){
			$("#parentRole").append("<option value='"+item.roleId+"'>"+item.roleName+"</option>");
		});
	});
	
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
}

/**
 * parentRole  select onchange方法
 * deer
 */
function chooseParentRole(obj){
	$("#parentId").val($(obj).val());
}