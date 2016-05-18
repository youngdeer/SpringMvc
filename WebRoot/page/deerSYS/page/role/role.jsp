<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<title>role编辑页面</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%@include file="/page/deerSYS/page/common/incCssjs.jsp"%>

		<script src="<%=basePath%>page/deerSYS/page/role/role.js"></script>
	</head>

	<body>
		<%@include file="/page/deerSYS/page/common/top.jsp"%>
		<div id="container" class="container">
			<form id="Role" method="post">
				<fieldset>
					<legend>
						Role
					</legend>
					<div class="control-grouo">
						<label for="roleName" class="control-label">
							roleName
						</label>
						<div class="controls">
							<input id="roleName" type="text" name="roleName"
								class="input-xlarge">
						</div>
					</div>
					<div class="control-group">
						<label for="parentRole" class="control-label">
							parentRole
						</label>
						<div class="controls">
							<select id="parentRole" onchange="chooseParentRole(this)">
								<option value="">please choose</option>
							</select>
							<input id="parentId" type="hidden" name="parentId" value=""
								class="input-xlarge">
						</div>
					</div>
					<div class="form-actions">
						<button type="button" class="btn btn-primary" onclick="save('Role',false)">
							save
						</button>
					</div>
				</fieldset>
			</form>
			<hr>
			<%@include file="/page/deerSYS/page/common/footer.jsp"%>
		</div>
		
		<div id="roleTree" class="tree well">
	    
	  	</div>
	</body>
</html>