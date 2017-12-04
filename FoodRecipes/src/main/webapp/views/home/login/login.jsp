<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>	
<div class="clear"></div>
			<div class="login-bg">
				<div class="form-bound" id="loginBound">
					<div class="login-title"><h4>Đăng nhập<h4></div>
					<form method="post">
						<div class="none-opacity form-group">
						  <label for="usr" >Tên đăng nhập:</label>
						  <div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<input type="text" class="form-control"  placeholder="Tên đăng nhập">
						  </div>
						</div>
						<div class="none-opacity form-group">
						  <label for="usr" >Mật khẩu:</label>
						 <div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
							<input id="password" type="password" class="form-control" name="password" placeholder="Mật khẩu">
						 </div>
						</div>
						<div class="remote-login">
							<button type="button" class="btn btn-success btn-uer btn-register">Đăng ký</button>
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
		
		