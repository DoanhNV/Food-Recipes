<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored ="false" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="clear"></div>
			<div class="login-bg">
				<div class="form-bound">
					<div class="login-title"><h4 class="register-title">Đăng ký<h4></div>
					<form method="post" id="registerForm" modelAttribute="registerUser">
						<div class="form-group">
						  <label for="usr" >Tên đăng nhập:</label>
						  <div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<input type="text" class="form-control" name="userName" id="txtUserName"  placeholder="Tên đăng nhập">
						  </div>
						  <label id="txtUserNameErr"  class="txtErr">
						  	<c:if test="${not empty userexist}">
							 		<c:out value="${userexist}"/>
							 	</c:if>
						  </label>
						</div>
						<div class="form-group">
						  <label for="usr" >Mật khẩu:</label>
						 <div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
							<input id="txtPassword" name="password" type="password" class="form-control" name="password" placeholder="Mật khẩu">
						 </div>
							<label id="txtPasswordErr"  class="txtErr"> </label>
						</div>
						<div class="form-group">
						  <label for="usr" >Email:</label>
						 <div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
							<input id="txtEmail" name="email" type="password" class="form-control" name="password" placeholder="Email">
						 </div>
							<label id="txtEmailErr"  class="txtErr" ></label>
						</div>
						<div class=" form-group">
						  <label for="usr" >Tên hiển thị:</label>
						 <div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
							<input id="txtFullName" name="fullName" type="password" class="form-control" name="password" placeholder="tên hiển thị">
						 </div>
							<label id="txtFullNameErr" class="txtErr" ></label>
						</div>
						<div class="regist-page">
							<button type="button" class="btn btn-success btn-uer btn-register " id="btnRegister">Đăng ký</button>
							<button type="button" class="btn btn-success btn-user btn-login">Đăng nhập</button>
						</div>
					</form>
				</div>
			</div>
			</div>
			
		<script type="text/javascript">
			$(document).ready(function(){
				gotoLogin2();
				doRegister();
			})

			function gotoLogin2(){
				$(".btn-login").click(function(){
					redirect("user/login");		
				});
			}
			
			function validateRegister(){
				var result = true;
					if($("#txtUserName").val().trim() == ""){
						$("#txtUserNameErr").text("Bạn phải nhập tên đăng nhập");
						result = false;
					}else{
						$("#txtUserNameErr").text("");
					}
					
					if($("#txtPassword").val().trim() == ""){
						$("#txtPasswordErr").text("Bạn phải nhập tên mật khẩu");
						result = false;
					}else{
						$("#txtPasswordErr").text("");
					}
					
					if($("#txtEmail").val().trim() == ""){
						$("#txtEmailErr").text("Bạn phải nhập email");
						result = false;
					}else{
						$("#txtEmailErr").text("");
					}
					
					if($("#txtFullName").val().trim() == ""){
						$("#txtFullNameErr").text("Bạn phải nhập tên hiển thị");
						result = false;
					}else{
						$("#txtFullNameErr").text("");
					}
				return result;
			}
			
			function doRegister(){
				$("#btnRegister").click(function(){
					if(validateRegister()){
						$("#registerForm").attr("action","../user/doRegister");
						$("#registerForm").submit();
					}
				});
			}
			
		</script>