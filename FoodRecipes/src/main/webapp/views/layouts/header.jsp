<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored ="false" %>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	 <%@taglib prefix="tag" uri="http://java.sun.com/jstl/core" %>
		<form id="redirectForm"></form>
		<div class="head">
				<div class="top-head">
					<ul>
						<li><a href="../home/index"><img src="<%=request.getContextPath()%>/resources/asset/img/head-logo.jpg"  class="head-logo"/></a></li>
						<li>
							<div class="search-block row">
								<input type="text"  class="search-box col-md-10"/>
								<button type="button" class="btn btn-success btn-search col-md-2">
								  <span class="glyphicon glyphicon-search"></span>
								</button>
							</div>
						</li>
						<li>
							<div class="head-right">
								<button type="button" class="btn btn-success" id="btnCreateRecipe">
								  <span class="glyphicon glyphicon-plus"></span> Tạo công thức
								</button>
								
								<c:choose>
								    <c:when test="${empty sessionScope.sessionUser}">
								    	<button type="button" class="btn btn-success" id="btnLogin">
									  		<span class="glyphicon glyphicon-user" ></span> Đăng nhập
										</button>
								    </c:when>
								    <c:otherwise>
								    	<button type="button" class="btn btn-success" id="btnLogOut">
									  		<span class="glyphicon glyphicon-log-out" ></span> 	&nbsp; LogOut 
										</button>
								    </c:otherwise>
								</c:choose>
							</div>
						</li>
					</ul>
				</div>
				<nav class="menu">
					<ul>
						<li><a href="../home/index"><span class="glyphicon glyphicon glyphicon-home"></span></a></li>
						<li><a href="../recipe/create-recipe">Công thức</a></li>
						<li><a href="../recipe/detail">Cộng đồng</a></li>
						<li><a href="#">Bộ sưu tập</a></li>
						<li><a href="#">Video</a></li>
						<li><a href="#">Blog</a></li>
					</ul>
				</nav>
			</div>
<script type="text/javascript">
	$(document).ready(function(){
		gotoCreateRecipe();
		gotoLogin();
		logOut();
	});

	function gotoCreateRecipe(){
		$("#btnCreateRecipe").unbind().on("click",function(){
			redirect("recipe/create-recipe");
		});
	}
	
	function gotoLogin(){
		$("#btnLogin").unbind().on("click",function(){
			redirect("user/login");
		});
	}
	
	function logOut(){
		$("#btnLogOut").unbind().on("click",function(){
			redirect("user/logout");
		});
	}
	

	function redirect(url){
		window.location.href = "../"+url;
	}
</script>