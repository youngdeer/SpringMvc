<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<title>userRole编辑页面</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%@include file="/page/deerSYS/page/common/incCssjs.jsp"%>

		<script src="<%=basePath%>page/deerSYS/page/role/userRole.js">
</script>
	</head>

	<body>
		<%@include file="/page/deerSYS/page/common/top.jsp"%>
		<div id="container" class="container">
			<form id="userRole" method="post">
				<fieldset>
					<legend>
						userRole
					</legend>
					<input type="hidden" id="checkedUser" />
					<input type="hidden" id="checkedRole" />
				</fieldset>
			</form>

			<div class="row">
				<div class="span6">
					<h4>
						userAccountList
					</h4>
					<ul id="userList" class="list-unstyled">
						<c:forEach items="${userAccountList}" var="v">
							<li>
								<input type="checkbox" value="${v.id}"/>
								${v.username}
							</li>
						</c:forEach>
					</ul>
				</div>
				<div class="span6">
					<h4>
						roleTree
					</h4>
					<div id="roleTree" class="tree well">
	    
	  				</div>
				</div>
			</div>
			<button type="button" class="btn btn-info" onclick="bind()">
				bind
			</button>
			<hr>
			<%@include file="/page/deerSYS/page/common/footer.jsp"%>
		</div>
	</body>
</html>