<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
	.post-recipes-date {
	    font-size: 12px;
	    color: green;
	}
	
	.user-comment-bg {
	    width: 46px;
	    height: 44px;
	    border-radius: 40px;
	    float: left;
	}
	
	.step-content {
		border-radius: 4px;
    	background-color: #eceafd;
    	padding-top: 10px;
    	 border: none !important;
	}
	
	.post-center { 
		border-bottom: oldlace;
		background-color: #fdf9f9;
	}
	
	.method-title {
		background-color: #7ff3cc;
	}
	
	.step-image2 {
	    width: 100%;
	    height: 369px;
	}
</style>
<div class="clear">
			</div>
			<div class="post post-center">
				<div class="recipe-profile">
					<iframe class="recipe-profile-bg"
						src="https:${recipe_detail.videoUrl }" frameborder="0" allowfullscreen>
					</iframe>
				</div>
				<div class="post-cate-info">
					<span class="cate-purpose">Mục đích:</span><b> ${recipe_detail.cateTitle }</b>
					<span class="cate-purpose">Thời gian:</span><b>${recipe_detail.estimateTime } </b>
					<span class="cate-purpose">Đăng ngày:</span><b>${recipe_detail.createTime }</b>
				</div>
				<h1 style="font-family: 'Times'">${recipe_detail.title }</h1>
					<c:choose>
						<c:when test="${sessionScope.sessionUser != null && fn:contains(recipe_detail.listSavedId,sessionScope.sessionUser.id) }">
							<div class="post-recipe-save" data-id="${recipe_detail.id }">
								<a href="#"><div class="post-recipe-save"><span class="save-icon glyphicon glyphicon-heart"></span>Lưu món ăn (<b id="number">${recipe_detail.savedNumber }</b>)</div></a>
							</div>
						</c:when>
						<c:otherwise>
							<div class="post-recipe-save" id="saveRecipe" data-id="${recipe_detail.id }">
								<a href="#"><div class="post-recipe-save"><span style="color:white;" id="colorSaved" class="save-icon glyphicon glyphicon-heart"></span>Lưu món ăn (<b id="number">${recipe_detail.savedNumber }</b>)</div></a>
							</div>
						</c:otherwise>
					</c:choose>
				
				
				<hr class="style-seven"/>
				<h2 class="post-material-title">Nguyên liệu</h2>
				<div class="post-material">
					<ul>
						<c:forEach items="${recipe_detail.materials }" var="material">
							<li><a href="../recipe/search?kind=2&data=${material.id }"><span class="mater-element glyphicon glyphicon-plus"></span>${material.title}</a></li>
						</c:forEach>
					</ul>
				</div>
				<div class="method-title">Cách thực hiện</div>
				<c:forEach items="${recipe_detail.steps }" var="step" varStatus="status">
					<div class="recipe-step">
					<div class="step-title"><span class="step-icon glyphicon glyphicon-check"></span><br/>Bước ${status.index + 1}</div>
					<div class="step-content">
						<p>${step.text }</p>
						<c:if test="${step.filePath  != null }">
							<div class="step-img ">
								<img src="${step.filePath }" class="step-image2"/>
							</div>
						</c:if>
					</div>
					</div>
					<div class="clear"></div>
				</c:forEach>
				<div class="clear"></div>
				<div class="method-title"></div>
				<div class="comments">
					<div class="comment-contain">
						<div class="comment" style="display:none;"></div>
						<c:forEach items="${list_comment }" var="comment">
							<div class="comment">
								<c:choose>
									<c:when test="${comment.userProfile eq '/resources/asset/img/cooker.png' }">
										<img src="<%=request.getContextPath()%>${comment.userProfile}" class="user-comment-bg"/>
									</c:when>
									<c:otherwise>
										<img src="${comment.userProfile}" class="user-comment-bg"/>
									</c:otherwise>
								</c:choose>
								
								<div class="comment-info">
									<b class="comment-content">${comment.content }</b><br/>
									<span class="comment-author"><a href="../user/profile?id=${comment.userId }">${comment.userFullName }</a></span>
									<span class="comment-date">${comment.createTime }</span><br/>
									<button class="btn" data-id="${comment.userId}" >quan tâm</button>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="method-title"></div>
					<form modelAttribute="comment" id="commnetForm">
					<span class="txtErr" id="contentErr"></span>
					<div class="input-comment input-group">
							<input type="text"  name="content" class="text-comment form-control" placeholder="Nội dung thảo luận" id="txtContent"/>
							<input type="hidden" id="recipeId" name="recipeId" value="${recipe_detail.id }"  />
							<input type="hidden" id ="userId" name="userId" value="${sessionScope.sessionUser.id}"  />
							<div class="input-group-btn ">
							  <button class="btn btn-default sent-button" type="button" id="btnComment">
								Gửi bình luận
							  </button>
							</div>
					</div>
					</form>
				</div>
			</div>
			<div class="post post-right">
				<div class="choose-container">
					<h3 style="font-family:'Droid Sans';">Cùng nguyên liệu</h3>
				</div>
				<c:forEach items="${recipe_detail_suggest }" var="recipe">
					<div class="post-recipe-info">
					<img src="${recipe.featureImage }" class="post-recipe-bg"/>
						<div class="recipe-element-info">
							<span class="post-recipe-title"><a href="../recipe/detail?id=${recipe.id }">${recipe.title }</a></span>
							<div class="clear"></div>
							<span class="post-recipes-view"><b>${recipe.views } </b>lượt xem</span>
							<div class="clear"></div>
							<span class="post-recipes-date">${recipe.createTime }</span>
						</div>
					</div>
					<div class="clear"></div>
				</c:forEach>
			</div>
		</div>
		<script type="text/javascript">
			$(document).ready(function(){
				comment();
				saveRecipe();
			});
			
			function saveRecipe(){
				$("#saveRecipe").click(function() {
					var userId = $("#userId").val();
					var recipeId = $(this).data("id");
					$.ajax({
						type: "post",
						data: userId + "-" + recipeId,
						url: "../user/save",
						success: function(data){
							if(data === "login"){
								alert("Bạn phải login để lưu công thức");
							}else if(data === "success"){
								var number = $("#number").text();
								alert("Lưu công thức  thành công!");
								number++;
								$("#colorSaved").attr("style","color:red");
								$("#saveRecipe").removeAttr("id");
								$("#number").text(number);
							}
						},
						error: function (){
							alert("error");
						}
					});
				});
			}
			
			function comment(){
				$("#btnComment").click(function(){
					if($("#txtContent").val().trim() == ""){
						$("#contentErr").text("Bạn phải nhập nội dung");
					}else{
						var commentData = {
								"recipeId" : $("#recipeId").val(),
								"userId" : $("#userId").val(),
								"content" : $("#txtContent").val()
						};

						$.ajax({
							type : "POST",
							data : JSON.stringify(commentData),
							url : "../recipe/doComment",
							contentType: "application/json",
							success: function(data){
								if(data.content  === 'usernull'){
									alert("Bạn phải đăng nhập để bình luận");
									return;
								}
								var content = data.content;
								var fullName = data.userFullName;
								var createTime = data.createTime;
								var image = data.userProfile;
								var  userId = data.userId;
								var preffix = "";
								if( image == '/resources/asset/img/cooker.png'){
									preffix = '<%=request.getContextPath()%>';
								}
								var comment = '<div class="comment">'
									+'<img src="'+preffix+image+'" class="user-comment-bg"/>'
								+'<div class="comment-info">'
									+'<b class="comment-content">'+content+'</b><br/>'
										+'<span class="comment-author"><a href="../user/profile?id='+userId+'">'+fullName+'</a></span>'
										+'<span class="comment-date">'+createTime+'</span><br/>'
										+'<button class="btn" >quan tâm</button>'
										+'</div>'
								+'</div>';
								$(".comment:last").after(comment);
							},
							error: function(data){
								alert(data.id);
								alert("err");
							},
							done: function(){
								alert("done");
							}
						});
					}
				});
			}
			
			
		</script>