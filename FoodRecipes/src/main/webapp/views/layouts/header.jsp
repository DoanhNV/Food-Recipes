<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
		<form id="redirectForm"></form>
		<div class="head">
				<div class="top-head">
					<ul>
						<li><a href="#"><img src="<%=request.getContextPath()%>/resources/asset/img/head-logo.jpg"  class="head-logo"/></a></li>
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
								<button type="button" class="btn btn-success" id="btnLogin">
								  <span class="glyphicon glyphicon-user" ></span> Đăng nhập
								</button>
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
	

	function redirect(url){
		window.location.href = "../"+url;
	}
</script>