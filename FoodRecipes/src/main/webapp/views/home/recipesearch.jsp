<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<style>
.recipe-search-contain {
	width: 100%;
}

.recipe-search {
	width: 22% !important;
	margin-right: 39px;
}

.recipe-bg2 {
	
}

.recipe-4 {
	margin-right: 0px !important;
}

.parent-pop {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 200%;
	background-color: rgba(12, 11, 11, 0.5);
	z-index: 5;
	display: none;
}

.nav-md {
	position: relative !important;
}

.child-pop {
	width: 80%;
	height: 1200px;
	padding: 20px;
	margin: auto;
	margin-top: 50px;
	background-color: #d5d7da;
	overflow: auto;
	border: solid 10px brown;
	z-index: 80;
}

.child-content {
	height: 100px;
	float: left;
	border: solid 0.5px green;
	border-radius: 2px;
	margin-right: 5px;
}

#submitMaterial {
	margin-left: 82.7%;
}

.check-mater {
	zoom: 5;
	margin: 0px !important;
	display: inline;
}

.mater-img {
	vertical-align: top !important;
	width: 80px;
	height: 60px
}

.mater-name {
	font-size: 11px;
	color: black;
	font-weight: bold;
}


.bound-page{
	width: 100%;
}

.pagination {
    display: inline-block;
    margin-left: 30% !important;
}

.pagination a {
    color: black;
    float: left;
    padding: 8px 16px;
    text-decoration: none;
    transition: background-color .3s;
    border: 1px solid #ddd;
    font-size: 22px;
}

.pagination a.active {
    background-color: #4CAF50;
    color: white;
    border: 1px solid #4CAF50;
}

.green {
	background-color: green;
	color: white;
}

.yellow {
	background-color: yellow;
	color: balck;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}

.checkbox-inline {
	color: #021b02;
}

.center-content{
	margin-top: 63px !important;
}

.content-recipe-info {
	    position: absolute;
	    margin-top: -20px;
	    font-size: 14px;
	    color: #1ff31f;
	    margin-left: 10px;
	    background-color: black;
}
</style>

<!-- Popup create -->
<div class="parent-pop">
	<div class="child-pop ">
		<c:forEach items="${listmaterial}" var="material">
			<div class="child-content ">
				<div>
					<input type="checkbox" ${material.checked} value="${material.id}" class="check-mater"
						name="materialIds"> <img src="${material.featureImage}"
						class="mater-img" />
				</div>
				<div class="clear"></div>
				<span class="mater-name" id="materialid-${material.id}">${material.title}</span>
			</div>
		</c:forEach>
	</div>
	<div class="clear"></div>
	<button type="button" class="btn btn-success" id="submitMaterial">Hoàn thành</button>
</div>
<div class="clear"></div>
<div class="center-content" style="margin-top: 100px;">
	<div class="search-tool">
		<div class="search-subject">
			<div>
				<button type="button" class="btn btn-success" id="btnSearchCate"><span class="glyphicon glyphicon-search" style="font-size:20px;"></span> Tìm kiếm theo loại món </button>
			</div>
		</div>
		<div class="clear"></div>
		<div class="search-cate">
			<c:forEach items="${list_recipecate }" var="cate">
				<label class="checkbox-inline"><input type="checkbox" name="cate-check" ${cate.checked } value="${cate.id }">${cate.title }</label>
			</c:forEach>
		</div>
		<div class="search-material">
			<div class="bound-button">
				<button type="button" class="btn btn-danger" id="btnChooseM" style="margin-bottom:20px;"><span class="glyphicon glyphicon-search" style="font-size:20px;"></span>Tìm kiếm theo nguyên liệu</button>
			</div>
			<div class="choosed-materials">
				<c:forEach items="${list_material_title }" var="item">
					<button type="button" id="tagElement" class="btn btn-success" name="" value="1">${item}<span class="glyphicon glyphicon-tags title-material-tag"></span>
				</c:forEach>
			</div>
		</div>
	</div>
	<div class="recipe-container recipe-search-contain">
		<div class="cate-title">
			<h2>Kết quả tìm kiếm</h2>
		</div>
		<div class="left">
			<c:forEach items="${list_recipe }" var="tRecipe" varStatus="status">
				<c:choose>
					<c:when test="${(status.index + 1) % 4 == 0 }">
							<div class="recipe recipe-search recipe-4">
									<a href="../recipe/detail?id=${tRecipe.id }">
										<img src="${tRecipe.featureImage }" class="recipe-bg recipe-bg2"/>
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
					</c:when>
					<c:otherwise>
							<div class="recipe recipe-search">
									<a href="../recipe/detail?id=${tRecipe.id }">
										<img src="${tRecipe.featureImage }" class="recipe-bg recipe-bg2"/>
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
					</c:otherwise>
				</c:choose>
			</c:forEach> 
		</div>
		<div class="clear"></div>
						<c:if test="${list_recipe != null && fn:length(list_recipe) != 0 }">
							<div class="bound-page">
		                    <div class="pagination">
		                    	<a href="../recipe/search?page=${first}&kind=${kind}&data=${data_buffer}">&laquo;</a>
		                     	<c:forEach items="${materialpages}" var="page">
		                     		 <c:choose>
				                      	<c:when test="${page != '...' && page == currentpage}">
				                      		<a href="../recipe/search?page=${page}&kind=${kind}&data=${data_buffer}" id="pageActive" class="active" data-id="${page}">${page}</a>
				                      	</c:when>
				                      	<c:when  test="${page == '...'}">
				                      		<a>${page}</a>
				                      	</c:when>
				                      	<c:otherwise>
				                      		<a href="../recipe/search?page=${page}&kind=${kind}&data=${data_buffer}">${page}</a>
				                      	</c:otherwise>
				                     </c:choose>
		                     	</c:forEach>
							  <a href="../recipe/search?page=${last}&kind=${kind}&data=${data_buffer}">&raquo;</a>
							</div>
        					</div>
						</c:if>
	</div>
</div>
</div>
<div class="clear"></div>
<script type="text/javascript">
	$(document).ready(function(){
		getMaterial();
		chooseM();
		searchByCate();
		cancleM();
		preventErro();
	});
	
	function getMaterial(){
		$("#submitMaterial").click(function(){
			$(".parent-pop").attr("style","display:none");
			var data = "";
			$('input[type="checkbox"][name="materialIds"]:checked').each(function(i){
		          var id = $(this).val();
		          data += id + "@";
		     });
			search("recipe/search",2,data);
			var arr = data.split("||");
			if(arr.length > 2){
				 $("#tagRecipeCate").empty();
			}
			for(var i = 0; i < arr.length - 1; i ++){
				 var content = '<button type="button" id="tagElement" class="btn btn-success" name="" value="1">'+arr[i]+'<span class="glyphicon glyphicon-tags title-material-tag"></span>';
		         $("#tagRecipeCate").append(content);
			}
		});
	}
	
	function chooseM() {
		$("#btnChooseM").click(function(){
			$(".parent-pop").attr("style","display:block");
		});
	}
	
	function searchByCate(){
		$("#btnSearchCate").click(function(){
			var data = "";
			$('input[type="checkbox"][name="cate-check"]:checked').each(function(i){
		          var id = $(this).val();
		          data += id + "@";
		     });
			search("recipe/search",1,data);
		});
	}
	
	function cancleM(){
		$(".parent-pop").click(function(){
			$(this).attr("style","display:none");
		});
	}
	function preventErro(){
		$(".parent-pop .child-pop").click(function(e){
			 e.stopPropagation();
		});
	}
	
	function search(url,kind,data){
		window.location.href = "../"+ url +"?kind="+ kind +"&data=" + data;
	}
</script>