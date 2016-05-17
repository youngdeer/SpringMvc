<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<title>userInfo编辑页面</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%@include file="/page/deerSYS/page/common/incCssjs.jsp"%>

		<script src="<%=basePath%>page/deerSYS/page/userInfo/userInfoEdit.js"></script>
	</head>

	<body>
		<%@include file="/page/deerSYS/page/common/top.jsp"%>
		<div id="container" class="container">
			<form id="UserInfo" method="post">
				<fieldset>
					<legend>
						user Info
					</legend>
					<div class="control-grouo">
						<label for="truename" class="control-label">
							truename
						</label>
						<div class="controls">
							<input id="truename" type="text" name="truename"
								class="input-xlarge">
						</div>
					</div>
					<div class="control-group">
						<label for="age" class="control-label">
							age
						</label>
						<div class="controls">
							<input id="age" type="text" name="age"
								class="input-xlarge">
						</div>
					</div>
					<div class="control-group">
						<label for="sex" class="control-label">
							sex
						</label>
						<div class="controls">
							<input id="sex" type="text" name="sex"
								class="input-xlarge">
						</div>
					</div>
					<div class="control-group">
						<label for="dec1" class="control-label">
							dec1
						</label>
						<div class="controls">
							<input id="dec1" type="text" name="dec1"
								class="input-xlarge">
						</div>
					</div>
					<div class="control-group">
						<label for="dec2" class="control-label">
							dec2
						</label>
						<div class="controls">
							<input id="dec2" type="text" name="dec2"
								class="input-xlarge">
						</div>
					</div>
					<div class="form-actions">
						<button type="button" class="btn btn-primary" onclick="save('UserInfo',true)">
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
