<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored ="false" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="clear"></div>
			<div class="login-bg">
				<div class="form-bound" id="loginBound">
					<div class="login-title"><h4>Đăng nhập<h4></div>
					<form method="post" modelAttribute="loginUser" id="loginForm">
						<div class="none-opacity form-group">
							<label class="txtErr" id="txtIncorrect">
								<c:out  value="${incorrectInfo}"></c:out>
							</label>
						  <label for="usr" >Tên đăng nhập:</label>
						  <div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<input type="text" id="txtUserName" name="userName" class="form-control"  placeholder="Tên đăng nhập">
						  </div>
						  <label id="txtUserNameErr"  class="txtErr"></label>
						</div>
						<div class="none-opacity form-group">
						  <label for="usr" >Mật khẩu:</label>
						 <div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
							<input id="txtPassword" type="password" class="form-control" name="password" placeholder="Mật khẩu">
						 </div>
						 	<label id="txtPasswordErr"  class="txtErr"></label>
						</div>
						<div class="remote-login">
							<button type="button" class="btn btn-success btn-uer btn-register">Đăng ký</button>
							<button type="button" class="btn btn-success btn-user btn-login" id="btnDoLogin">Đăng nhập</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
			$(document).ready(function(){
				gotoRegister();
				doLogin();
				doLoginEnter();
				doLoginEnter2();
			})
			
			function gotoRegister(){
				$(".btn-register").click(function(){
					redirect("user/register");		
				});
			}
			

			function validateLogin(){
				var result = true;
					$("#txtIncorrect").text("");
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
				return result;
			}
			
			function doLogin(){
				$("#btnDoLogin").click(function(){
					if(validateLogin()){
						$("#loginForm").attr("action","../user/doLogin");
						$("#loginForm").submit();
					}
				});
			}
			
			function doLoginEnter(){
				$('#txtUserName').keypress(function (e) {
					 var key = e.which;
					 if(key == 13) {   // the enter key code
						 if(validateLogin()){
								$("#loginForm").attr("action","../user/doLogin");
								$("#loginForm").submit();
						}
					  }
				});   
			}
			
			
			function doLoginEnter2(){
				$('#txtPassword').keypress(function (e) {
					 var key = e.which;
					 if(key == 13) {   // the enter key code
						 if(validateLogin()){
								$("#loginForm").attr("action","../user/doLogin");
								$("#loginForm").submit();
						}
					  }
				});
			}
		</script>
		
		