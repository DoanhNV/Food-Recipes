<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="clear"></div>
			<div class="login-bg">
				<div class="form-bound">
					<div class="login-title"><h4 class="register-title">Đăng ký<h4></div>
					<form method="post">
						<div class="form-group">
						  <label for="usr" >Tên đăng nhập:</label>
						  <div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<input type="text" class="form-control"  placeholder="Tên đăng nhập">
						  </div>
						</div>
						<div class="form-group">
						  <label for="usr" >Mật khẩu:</label>
						 <div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
							<input id="password" type="password" class="form-control" name="password" placeholder="Mật khẩu">
						 </div>
						</div>
						<div class="form-group">
						  <label for="usr" >Email:</label>
						 <div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
							<input id="password" type="password" class="form-control" name="password" placeholder="Email">
						 </div>
						</div>
						<div class=" form-group">
						  <label for="usr" >Tên hiển thị:</label>
						 <div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
							<input id="password" type="password" class="form-control" name="password" placeholder="tên hiển thị">
						 </div>
						</div>
						<div class="regist-page">
							<button type="button" class="btn btn-success btn-uer btn-register ">Đăng ký</button>
							<button type="button" class="btn btn-success btn-user btn-login">Đăng nhập</button>
						</div>
					</form>
				</div>
			</div>
			</div>
			
		<script type="text/javascript">
			$(document).ready(function(){
				gotoRegister();
				gotoLogin2();
			})
			
			function gotoRegister(){
				$(".btn-register").click(function(){
					redirect("user/register");		
				});
			}
			
	
			function gotoLogin2(){
				$(".btn-login").click(function(){
					redirect("user/login");		
				});
			}
		</script>