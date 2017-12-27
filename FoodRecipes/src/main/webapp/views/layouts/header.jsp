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
								<input type="text" value="${search_key }" class="search-box col-md-10" id="txtKeyWord"/>
								<button type="button" id="btnSearchText" class="btn btn-success btn-search col-md-2">
								  <span class="glyphicon glyphicon-search"></span>
								</button>
							</div>
						</li>
						<li style="float: right;">
							<div class="head-right">
								<div class="user-profile" id="btnCreateRecipe" >
									<a href="../user/profile?id=${sessionScope.sessionUser.id }">
									<c:if test="${sessionScope.sessionUser != null}">
										<c:choose>
											<c:when test="${sessionScope.sessionUser.profileImage eq '/resources/asset/img/cooker.png'}">
												<img src="<%=request.getContextPath()%>${sessionScope.sessionUser.profileImage}" style="width:50px;height:50px;margin-top: 0px;" />
											</c:when>
											<c:otherwise>
												<img src="${sessionScope.sessionUser.profileImage}" style="width:50px;height:50px;margin-top: 0px;" />
											</c:otherwise>
										</c:choose>
									</c:if>
									</a>
								</div>
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
						<li><a href="../recipe/search">Công thức</a></li>
						<li><a href="../tipv1/view">Mẹo vặt</a></li>
						<c:forEach items="${sessionScope.menu_session}" var="kind_cate">
							<li class="dropdown"><a href="#">${kind_cate.title }</a>
								<div class="dropdown-content" style="left:0;">
									<c:forEach items="${kind_cate.cates }" var="cate">
										<a href="../recipe/search?kind=1&data=${cate.id }"> ${cate.title }</a>
									</c:forEach>
								</div>
							</li>
						</c:forEach>
					</ul>
				</nav>
			</div>
<script type="text/javascript">
	$(document).ready(function(){
		gotoLogin();
		logOut();
		searchByTitle();
		searchByTitleClick();
	});

	
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
	
	function searchByTitle(){
		$('#txtKeyWord').keypress(function (e) {
			 var key = e.which;
			 var data = $(this).val();
			 if(data == ""){
				 return;
			 }
			 if(key == 13) {   // the enter key code
				 searchTitle("recipe/search",3,data);
			  }
			});   
	}
	
	function searchByTitleClick(){
		$("#btnSearchText").click(function(){
			 var data = $("#txtKeyWord").val();
			 if(data == ""){
				 return;
			 }
			 searchTitle("recipe/search",3,data);
		});
	}
	
	function searchTitle(url,kind,data){
		window.location.href = "../"+ url +"?kind="+ kind +"&data=" + data;
	}
</script>