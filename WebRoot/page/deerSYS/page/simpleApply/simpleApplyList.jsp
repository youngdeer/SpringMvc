<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<title>简易申请流程审批List页面</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%@include file="/page/deerSYS/page/common/incCssjs.jsp"%>

		<script src="<%=basePath%>page/deerSYS/page/simpleApply/simpleApplyList.js"></script>
	</head>

	<body>
		<%@include file="/page/deerSYS/page/common/top.jsp"%>
		<div id="container" class="container">
			<table class="table table-bordered">
				<thead>
					<th>
						simpleApplyId
					</th>
					<th>
						applyTitle
					</th>
					<th>
						applyContext
					</th>
					<th>
						workflowId
					</th>
					<th>
						workflowStatus
					</th>
					<th>
						operate
					</th>
				</thead>
				<tbody>
					<c:forEach items="${simpleApplyList}" var="v">
						<tr>
							<td>
								${v.simpleApplyId}
							</td>
							<td>
								${v.applyTitle}
							</td>
							<td>
								${v.applyContext}
							</td>
							<td>
								${v.workflowId}
							</td>
							<td>
								${v.workflowStatus}
							</td>
							<td>
								<button type="button" onclick="doAction('${v.simpleApplyId}')">agree</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<hr>
			<%@include file="/page/deerSYS/page/common/footer.jsp"%>
		</div>
	</body>
</html>
