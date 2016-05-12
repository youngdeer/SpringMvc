<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a data-toggle="collapse" data-target=".nav-collapse"
				class="btn btn-navbar"><span class="icon-bar"></span><span
				class="icon-bar"></span><span class="icon-bar"></span>
			</a><a href="<%=basePath%>deerSYS/toIndex.html" class="brand">deerSYS</a>
			<div class="nav-collapse">
				<ul class="nav">
					<c:if test="${empty username}">
						<li>
							<a href="<%=basePath%>deerSYS/toIndex.do">Home</a>
						</li>
						<li>
							<a href="<%=basePath%>deerSYS/toLogin.do">Login</a>
						</li>
						<li>
							<a href="<%=basePath%>deerSYS/toRegist.do">Register</a>
						</li>
						<li>
							<a href="/mobileReg">mobileReg</a>
						</li>
					</c:if>
					<c:if test="${not empty username}">
						<li>
							<a href="<%=basePath%>deerSYS/toIndex.do">Home</a>
						</li>
						<li>
							<a href="<%=basePath%>deerSYS/toUserInfoEdit.do">UserInfoEdit</a>
						</li>
						<li>
							<a href="<%=basePath%>deerSYS/toUserInfoList.do">UserInfoList</a>
						</li>
						<li>
							<a href="<%=basePath%>deerSYS/SimpleApply/toSimpleApply.do">SimpleApply</a>
						</li>
						<li>
							<a href="<%=basePath%>deerSYS/SimpleApply/toSimpleApplyList.do">SimpleApplyList</a>
						</li>
						<li>
							<a href="<%=basePath%>deerSYS/userLogout.do">Logout</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>