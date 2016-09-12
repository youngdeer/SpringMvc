<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<title>deerSYS主页</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%@include file="/page/deerSYS/page/common/incCssjs.jsp"%>
		<link href="<%=basePath%>page/deerSYS/page/common/css/jquery.thoughtBubble.css" rel="stylesheet" type="text/css" />
		<script src="<%=basePath%>page/deerSYS/page/index/index.js"></script>
		<script type="text/javascript" src="<%=basePath%>page/deerSYS/page/common/js/jquery.thoughtBubble.js"></script>
	</head>

	<body>
		<%@include file="/page/deerSYS/page/common/top.jsp"%>
		<div id="container" class="container">
			<div class="hero-unit">
				<h3>
					welcome deerSYS
				</h3>
				<p>
					deerSYS is a java system
				</p>
				<p>
					<a href="<%=basePath%>deerSYS/toLogin.do" class="btn btn-primary btn-large">login</a>
					<a href="<%=basePath%>deerSYS/toRegist.do" class="btn btn-large">register</a>
					<a href="javascript:void(0);" class="btn btn-large" onclick="getHtml()">getHtml</a>
					<a href="javascript:void(0);" class="btn btn-large" onclick="pupupu()">pupupu</a>
					<a id="qipao" style="display:none;">qipao</a>
				</p>
			</div>
			<div class="row">
				<div class="span4">
					<h2>
						builder: Deer Young
					</h2>
					<p>
						Welcome
					</p>
				</div>
			</div>
			<hr>
			<%@include file="/page/deerSYS/page/common/footer.jsp"%>
		</div>
		<div id="getHtmlFromController">
		</div>
	</body>
</html>
