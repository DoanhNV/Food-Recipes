<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="tile" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><tile:getAsString name="title" /></title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/asset/css/style.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/asset/bootstrap-3.3.7/dist/css/bootstrap.min.css" />
<script src="<%=request.getContextPath()%>/resources/asset/bootstrap-3.3.7/dist/js/bootstrap.min.js" ></script>
<script src="<%=request.getContextPath()%>/resources/asset/js/script.jsp" ></script>
<script src="<%=request.getContextPath()%>/resources/asset/js/jquery-3.2.1.min.js" ></script>
<title>this is index page</title>
</head>
<body>
	<div class="container">
		<tile:insertAttribute name="header"/>
		<tile:insertAttribute name="body" />
		<tile:insertAttribute name="footer"/>
	</div>
</body>
</html>