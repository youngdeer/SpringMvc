<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<title>deerSYS注册</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%@include file="/page/deerSYS/page/common/incCssjs.jsp"%>

		<script src="<%=basePath%>page/deerSYS/page/regist/regist.js"></script>
	</head>

	<body>
		<%@include file="/page/deerSYS/page/common/top.jsp"%>
		<div id="container" class="container">
			<form method="post" class="form-horizontal">
				<fieldset>
					<legend>
						regist
					</legend>
					<div class="control-group">
						<label for="username" class="control-label">
							username
						</label>
						<div class="controls">
							<input id="username" type="text" name="username"
								class="input-xlarge">
							<p class="help-block">
								your account number,to regist and display
							</p>
						</div>
					</div>
					<div class="control-group">
						<label for="password" class="control-label">
							password
						</label>
						<div class="controls">
							<input id="password" type="password" name="password"
								class="input-xlarge">
						</div>
					</div>
					<div class="control-group">
						<label for="password-repeat" class="control-label">
							repeat password
						</label>
						<div class="controls">
							<input id="password-repeat" type="password"
								name="password-repeat" class="input-xlarge">
						</div>
					</div>
					<div class="form-actions">
						<button type="button" class="btn btn-primary" onclick="submitRegist()">
							regist
						</button>
					</div>
				</fieldset>
			</form>
			<hr>
			<%@include file="/page/deerSYS/page/common/footer.jsp"%>
		</div>
	</body>
</html>
