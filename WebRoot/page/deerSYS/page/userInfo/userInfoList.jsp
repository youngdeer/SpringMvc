<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<title>userInfo列表页面</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%@include file="/page/deerSYS/page/common/incCssjs.jsp"%>

		<script src="<%=basePath%>page/deerSYS/page/userInfo/userInfoList.js"></script>
	</head>

	<body>
		<%@include file="/page/deerSYS/page/common/top.jsp"%>
		<div id="container" class="container">
			<form id="headSearch">
				<span>truename</span><input id="truename">
				<span>age</span><input id="age">
				<input id="pageNo" type="hidden" value="${currentPageNo}">
				<input id="pageSize" type="hidden" value="3">
				<button type="button" onclick="search('UserInfo')">search</button>
			</form>
			<hr>
			<table class="table table-bordered">
				<thead>
					<th>
						userInfoId
					</th>
					<th>
						truename
					</th>
					<th>
						age
					</th>
					<th>
						sex
					</th>
					<th>
						dec1
					</th>
					<th>
						dec2
					</th>
				</thead>
				<tbody>
					<c:forEach items="${userInfoList}" var="v">
						<tr>
							<td>
								${v.UserInfoId}
							</td>
							<td>
								${v.truename}
							</td>
							<td>
								${v.age}
							</td>
							<td>
								${v.sex}
							</td>
							<td>
								${v.dec1}
							</td>
							<td>
								${v.dec2}
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:if test="${currentPageNo > 1}"><button type="button" onclick="previous('UserInfo')">previous</button></c:if>
			<c:if test="${currentPageNo < totalPageNo}"><button type="button" onclick="next('UserInfo')">next</button></c:if>		
			<hr>
			<%@include file="/page/deerSYS/page/common/footer.jsp"%>
		</div>
	</body>
</html>
