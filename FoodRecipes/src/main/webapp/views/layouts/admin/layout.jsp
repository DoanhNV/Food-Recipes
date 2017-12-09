<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Gentelella Alela!</title>

<!-- Bootstrap -->
<link
	href="<%=request.getContextPath()%>/resources/admin/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="<%=request.getContextPath()%>/resources/admin/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="<%=request.getContextPath()%>/resources/admin/vendors/nprogress/nprogress.css"
	rel="stylesheet">
<!-- iCheck -->
<link href="<%=request.getContextPath()%>/resources/admin/vendors/iCheck/skins/flat/green.css"
	rel="stylesheet">

<!-- bootstrap-progressbar -->
<link
	href="<%=request.getContextPath()%>/resources/admin/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet">
<!-- JQVMap -->
<link href="<%=request.getContextPath()%>/resources/admin/vendors/jqvmap/dist/jqvmap.min.css"
	rel="stylesheet" />
<!-- bootstrap-daterangepicker -->
<link
	href="<%=request.getContextPath()%>/resources/admin/vendors/bootstrap-daterangepicker/daterangepicker.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="<%=request.getContextPath()%>/resources/admin/build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<tiles:insertAttribute name="leftmenu" />
			<tiles:insertAttribute name="navmenu" />
			<div class="right_col" role="main">
				<tiles:insertAttribute name="body" />
			</div>
			<!-- <div class="right_col" role="main"></div> -->
			<div class="right_col" role="main"></div>
			<footer>
			<div class="pull-right">
				Gentelella - Bootstrap Admin Template by <a
					href="https://colorlib.com">Colorlib</a>
			</div>
			<div class="clearfix"></div>
			</footer>
			<!-- /footer content -->
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/resources/admin/vendors/jquery/dist/jquery.min.js"></script>
	<!-- jQuery -->
	<script src="<%=request.getContextPath()%>/resources/admin/vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script
		src="<%=request.getContextPath()%>/resources/admin/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script src="<%=request.getContextPath()%>/resources/admin/vendors/fastclick/lib/fastclick.js"></script>
	<!-- NProgress -->
	<script src="<%=request.getContextPath()%>/resources/admin/vendors/nprogress/nprogress.js"></script>
	<!-- Chart.js -->
	<script src="<%=request.getContextPath()%>/resources/admin/vendors/Chart.js/dist/Chart.min.js"></script>
	<!-- gauge.js -->
	<script src="<%=request.getContextPath()%>/resources/admin/vendors/gauge.js/dist/gauge.min.js"></script>
	<!-- bootstrap-progressbar -->
	<script
		src="<%=request.getContextPath()%>/resources/admin/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
	<!-- iCheck -->
	<script src="<%=request.getContextPath()%>/resources/admin/vendors/iCheck/icheck.min.js"></script>
	<!-- Skycons -->
	<script src="<%=request.getContextPath()%>/resources/admin/vendors/skycons/skycons.js"></script>
	<!-- Flot -->
	<script src="<%=request.getContextPath()%>/resources/admin/vendors/Flot/jquery.flot.js"></script>
	<script src="<%=request.getContextPath()%>/resources/admin/vendors/Flot/jquery.flot.pie.js"></script>
	<script src="<%=request.getContextPath()%>/resources/admin/vendors/Flot/jquery.flot.time.js"></script>
	<script src="<%=request.getContextPath()%>/resources/admin/vendors/Flot/jquery.flot.stack.js"></script>
	<script src="<%=request.getContextPath()%>/resources/admin/vendors/Flot/jquery.flot.resize.js"></script>
	<!-- Flot plugins -->
	<script
		src="<%=request.getContextPath()%>/resources/admin/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/admin/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/admin/vendors/flot.curvedlines/curvedLines.js"></script>
	<!-- DateJS -->
	<script src="<%=request.getContextPath()%>/resources/admin/vendors/DateJS/build/date.js"></script>
	<!-- JQVMap -->
	<script src="<%=request.getContextPath()%>/resources/admin/vendors/jqvmap/dist/jquery.vmap.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/admin/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/admin/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
	<!-- bootstrap-daterangepicker -->
	<script src="<%=request.getContextPath()%>/resources/admin/vendors/moment/min/moment.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/admin/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

	<!-- Custom Theme Scripts -->
	<script src="<%=request.getContextPath()%>/resources/admin/build/js/custom.min.js"></script>

</body>
</html>
