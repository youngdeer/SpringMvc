<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<title>简易申请流程页面</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%@include file="/page/deerSYS/page/common/incCssjs.jsp"%>

		<script src="<%=basePath%>page/deerSYS/page/simpleApply/simpleApply.js"></script>
	</head>

	<body>
		<%@include file="/page/deerSYS/page/common/top.jsp"%>
		<div id="container" class="container">
			<form id="SimpleApply" method="post">
				<input type="hidden" id="workflowId"/>
				<input type="hidden" id="workflowStatus"/>
				<fieldset>
					<legend>
						simpleApply
					</legend>
					<div class="control-grouo">
						<label for="applyTitle" class="control-label">
							applyTitle
						</label>
						<div class="controls">
							<input id="applyTitle" type="text" name="applyTitle"
								class="input-xlarge">
						</div>
					</div>
					<div class="control-group">
						<label for="applyContext" class="control-label">
							applyContext
						</label>
						<div class="controls">
							<input id="applyContext" type="text" name="applyContext"
								class="input-xlarge">
						</div>
					</div>
					<div class="form-actions">
						<button type="button" class="btn btn-primary" onclick="beforeSave()">
							save
						</button>
					</div>
				</fieldset>
			</form>
			<hr>
			<%@include file="/page/deerSYS/page/common/footer.jsp"%>
		</div>
	</body>
</html>
