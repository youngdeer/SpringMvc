<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link href="<%=basePath%>page/deerSYS/page/common/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>page/deerSYS/page/common/css/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>page/deerSYS/page/common/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>page/deerSYS/page/common/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=basePath%>page/deerSYS/page/common/js/common.js"></script>
<script type="text/javascript">var basePath = "<%=basePath%>"</script>