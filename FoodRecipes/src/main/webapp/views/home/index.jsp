<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
	.recipet {
		height: 273px !important;
	}
	
	.overlay {
	  position: absolute;
	  top: 0;
	  bottom: 0;
	  left: 0;
	  right: 0;
	  width: 107%;
	  height: 189px;
	  opacity: 0.3;
	  transition: .5s ease;
	  background-color: #008CBA;
	}
	
	.content-recipe-info {
	    position: absolute;
	    margin-top: -20px;
	    font-size: 14px;
	    color: #1ff31f;
	    margin-left: 10px;
	    background-color: black;
	}
	
	hr.style-seven {
	    overflow: visible; /* For IE */
	    height: 30px;
	    border-style: solid;
	    border-color: green;
	    border-width: 1px 0 0 0;
	    border-radius: 20px;
	}
	hr.style-seven:before { /* Not really supposed to work, but does */
	    display: block;
	    content: "";
	    height: 30px;
	    margin-top: -31px;
	    border-style: solid;
	     border-color: green;
	    border-width: 0 0 1px 0;
	    border-radius: 20px;
	}
	
	
	.cate-title h2{
		border-bottom: none;
	}
</style>
			<div class="clear"></div>
			<div class="content-container">
				<div class="top-content row">
					<div class="slide-bound" >
					<c:forEach items="${slide }" var="slide">
						<div class="slide col-md-8" style="background-image: url('${slide.featureImage }');">
							<div class="title-slide-element"><a href="../recipe/detail?id=${slide.id}"><h4>${slide.title }</h4></a></div>
							<div class="clear"></div>
							<div class="title-slide-element category-slide"><span class="glyphicon glyphicon-list-alt"></span><a href="../recipe/search?kind=1&data=${slide.cateId}">${slide.cateName }</a></div>
							<div class="triangle-topleft"></div>
						</div>
					</c:forEach>
					</div>
					<div class="top-user col-md-4">
						<c:forEach items="${top_recipe }" var="top">
						<div class="top-recipe">
							<div class="bound-image"><img src="${top.featureImage }" class="recipe-image"/></div>
							<div class="recipe-info">
								<div class="recipe-top-title"><a href="../recipe/detail?id=${top.id}">${top.title }</a></div>
								<div class="author-top">${top.createTime }</div>
								<div class="view-top"><span class="glyphicon glyphicon-signal"></span>&nbsp views: ${top.views }</div>
							</div>
						</div>
						</c:forEach>
					</div>
				</div>
				<div class="clear"></div>
				<div class="category-container row">
					<c:forEach items="${recipecate }" var="cate">
					<div class="cate-element col-md-2">
						<a href="../recipe/search?kind=1&data=${cate.id}">
							<img src="${cate.image }" class="cate-child-bg"/>
							<div class="element-child">
								<h4>${cate.title }</h4>
								<h5>số món: ${cate.numberOfRecipes}</h5>
							</div>
						</a>
					</div>
					</c:forEach>
				</div>
				<div class="clear"></div>
				<div class="center-content">
					
					<div class="recipe-container">
						<div class="cate-title">
							<h2 style="font-family:'Arial'; ">Công thứ mới nhất</h2>
							<hr class="style-seven"/>
						</div>
						<div class="left">
							<c:forEach items="${top_new_recipe }" var="tRecipe">
								<div class="recipe recipet">
									<a href="../recipe/detail?id=${tRecipe.id }">
										<img src="${tRecipe.featureImage }" class="recipe-bg"/>
									</a>
									<div class="content-recipe-info">
										<span class="glyphicon glyphicon-time"></span>&nbsp ${tRecipe.time }
										<span class="glyphicon  glyphicon-usd"></span>&nbsp ${tRecipe.cost }
										<span class="glyphicon  glyphicon-signal"></span>&nbsp ${tRecipe.views }
									</div>
									<div class="main-recipe-info">
										<h4>${tRecipe.title }</h4>
										<h6>Đăng ngày:<a href="#"> ${tRecipe.createTime }</a></h6>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
					
					<div class="top-content-user">
						<div>
							<h3>Top User</h3>
							<c:forEach items="${listuser }" var="user" varStatus="status">
								<div class="user-index-image">
								<c:choose>
									<c:when test="${user.featureImage eq '/resources/asset/img/cooker.png' }">
										<img src="<%=request.getContextPath()%>${user.featureImage}" class="user-index-bg"/>
									</c:when>
									<c:otherwise>
											<img src="${user.featureImage}" class="user-index-bg"/>
									</c:otherwise>
								</c:choose>
								</div>
								<div class="user-index-info">
									<div class="uer-info-name"><a href="../user/profile?id=${user.id }">${user.fullName}</a></div>
								<div class="clear"></div>
								<div class="view-body-user"><span class="glyphicon glyphicon-heart"></span>&nbsp lưu: ${user.recipeSavedNumber }</div>
								<div class="view-body-user"><span class="glyphicon glyphicon-pencil"></span>&nbsp mẹo: ${user.tipSavedNumber}</div>
								<div class="clear"></div>
								</div>
								<div class="clear"></div>
								<c:if test="${status.index != (fn:length(listuser) - 1) }">
									<hr style="border: solid 1px green" />
								</c:if>
							</c:forEach>
						</div>
					</div>	
				</div>				
				<div class="clear"></div>
				<div class="cate-title">
					<h2>Nguyên liệu nổi bật</h2>
					<hr class="style-seven"/>
				</div>
				<div class="content-material row">
					<c:forEach items="${listmaterial}" var="material">
						<div class="material-element col-md-1">
							<a href="../recipe/search?kind=2&data=${material.id}">
								<img src="${material.featureImage}" class="material-bg img-circle"/>
								<h4>${material.materialName}</h4>
							</a>
						</div>
					</c:forEach>
				</div>
				<div class="clear"></div>
				<div class="cate-title">
					<h2>Công thức nổi bật</h2>
					<hr class="style-seven"/>
				</div>
				<div class="tips-container">
					<c:forEach items="${list_tip}" var="tip" varStatus="status">
						<c:choose>
							<c:when test="${(status.index + 1) % 4 == 0 }">
								<div class="recipe tips tips-fouth">
									<a href="../tipv1/detail?id=${tip.id}">
										<img src="${tip.featureImage }" class="recipe-bg"/>
									</a>
									<div class="content-recipe-info">
										<span class="glyphicon  glyphicon-signal"></span>&nbsp ${tip.views }
									</div>
									<div class="main-recipe-info">
										<h4>${tip.title }</h4>
										<h6>công thức bởi:<a href="../home/index"> FoodRecipes</a></h6>
										<h6>Danh mục:<a href="../tipv1/view?cateId=${tip.cateId}"> ${tip.cateName }</a></h6>
									</div>
								</div>
								<div class="clear"></div>
							</c:when> 
							<c:otherwise>
								<div class="recipe tips">
									<a href="../tipv1/detail?id=${tip.id}">
										<img src="${tip.featureImage }" class="recipe-bg"/>
									</a>
									<div class="content-recipe-info">
										<span class="glyphicon  glyphicon-signal"></span>&nbsp ${tip.views }
									</div>
									<div class="main-recipe-info">
										<h4>${tip.title }</h4>
										<h6>công thức bởi:<a href="../home/index"> FoodRecipes</a></h6>
										<h6>Danh mục:<a href="../tipv1/view?cateId=${tip.cateId}"> ${tip.cateName }</a></h6>
									</div>
								</div>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			$(document).ready(function(){
				slideShow();
			});
			
			function slideShow(){
				var slides = $(".slide");
				for(var i = 1; i < slides.length; i ++){
					var currentStyle = $(slides[i]).css( "background-image");
					$(slides[i]).attr("style","background-image:"+currentStyle+";display:none");
				}
				var index = 0;
				setInterval(() => {
					showSlide(slides,index);
					if(index == (slides.length - 1)){
						index = 0;
					}else{
						index++;
					}
				}, 3000);
			}
			
			function showSlide(slides,index){
				for(var i = 0; i < slides.length; i ++){
					var currentStyle = $(slides[i]).css( "background-image");
					if(index == i){
						$(slides[i]).attr("style","background-image:"+currentStyle+";display:block");
					}else {
						$(slides[i]).attr("style","background-image:"+currentStyle+";display:none");
					}
				}
			}
		</script>


