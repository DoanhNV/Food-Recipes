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
							<input type="text"  value="${user_register.userName }" class="form-control" name="userName" id="txtUserName"  placeholder="Tên đăng nhập">
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
							<input id="txtEmail" value="${user_register.email }" name="email" type="email" class="form-control" name="password" placeholder="Email">
						 </div>
							<label id="txtEmailErr"  class="txtErr" ></label>
						</div>
						<div class=" form-group">
						  <label for="usr" >Tên hiển thị:</label>
						 <div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
							<input id="txtFullName" name="fullName" value="${user_register.fullName }" type="text" class="form-control" name="password" placeholder="tên hiển thị">
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
					}else {
						var check = validateLength("#txtUserName","#txtUserNameErr",8,25,"Tên đăng nhập phải lớn hơn 8 và nhỏ hơn 25");
						if(check){
							$("#txtUserNameErr").text("");
						} else {
							result = false;
						}
					}
					
					if($("#txtPassword").val().trim() == ""){
						$("#txtPasswordErr").text("Bạn phải nhập tên mật khẩu");
						result = false;
					}else{
						var check = validateLength("#txtPassword","#txtPasswordErr",8,25,"Mật khẩu phải lớn hơn 8 và nhỏ hơn 25");
						if(check){
							$("#txtPasswordErr").text("");
						} else {
							result = false;
						}
					}
					
					if($("#txtEmail").val().trim() == ""){
						$("#txtEmailErr").text("Bạn phải nhập email");
						result = false;
					}else{
						if(validateEmail($("#txtEmail").val().trim())){
							$("#txtEmailErr").text("");
						}else{
							$("#txtEmailErr").text("Địa chỉ email không hợp lệ");
							result = false;
						}
						
					}
					
					if($("#txtFullName").val().trim() == ""){
						$("#txtFullNameErr").text("Bạn phải nhập tên hiển thị");
						result = false;
					}else{
						var check = validateLength("#txtFullName","#txtFullNameErr",8,25,"Tên hiển thị phải lớn hơn 8 và nhỏ hơn 25");
						if(check){
							$("#txtFullNameErr").text("");
						}else {
							result = false;
						}
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
			
			function validateEmail(email) {
			    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
			    return re.test(email.toLowerCase());
			}
			
			function validateLength(dom,domErr,min,max,errorMessage){
				if($(dom).val().trim().length < min || $(dom).val().trim().length > max){
					$(domErr).text(errorMessage);
					return false;
				}
				return true;
			}
			
		</script>