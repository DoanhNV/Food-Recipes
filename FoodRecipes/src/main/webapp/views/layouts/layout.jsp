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
<style>
	.cate-child-bg {
		box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19) !important;
	}
	
	.footer-element h4{
		color: #000000;
	    margin-left: 10px;
	    font-size: 27px;
	    font-weight: bold;
	}
	.glyphicon-share:before {
	    color: green !important;	
	      font-size: 20px;
	}
		hr.style-seven {
	    overflow: visible; /* For IE */
	    height: 30px;
	    border-style: solid;
	    border-color: green;
	    border-width: 1px 0 0 0;
	    border-radius: 20px;
	}
	hr.style-seven:before { /* Not really supposed to work, but does */
	    display: block;
	    content: "";
	    height: 30px;
	    margin-top: -31px;
	    border-style: solid;
	     border-color: green;
	    border-width: 0 0 1px 0;
	    border-radius: 20px;
	}
</style>
</head>
<body class="bodyHtml" style="background-color: #e4e4e4 !important;">
	<div class="container" style="background-color: #fbfbfb !important;">
		<tile:insertAttribute name="header"/>
		<tile:insertAttribute name="body" />
		<tile:insertAttribute name="footer"/>
	</div>
</body>
</html>