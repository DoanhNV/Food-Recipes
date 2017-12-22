<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<style>
.recipe-search-contain {
	width: 76%;
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

.tips {
	width: 24% !important;
	margin-right: 80px;
}

.tip-menu {
	float:right;
	width: 22%;
	border: solid 1px black;
	height: 600px;
	margin-top: 10px;
	border-top: solid 3px silver;;
}

.tip-menu ul li {
	width: 100%;
	background-color: green;
	color: white;
	margin-left: 0;
	border-bottom: solid 1px silver;
	height: 40px;
}
.tip-menu ul li a {
	line-height: 40px; 
	color: white;
	font-size: 14px;
	margin-left: 3px;
}

.tip-menu ul li a:hover {
	text-decoration: none;
	color: silver;
}

</style>
<div class="clear"></div>
<div class="center-content" style="margin-top: 38px;">
	<div class="recipe-container recipe-search-contain">
		<div class="cate-title">
			<h2>Kết quả tìm kiếm</h2>
		</div>
		<div class="left">
			<c:forEach items="${list_tip }" var="tip" varStatus="status">
				  <div class="recipe tips">
						<a href="../tipv1/detail?id=${tip.id }">
							<img src="${tip.featureImage }" class="recipe-bg"/>
						</a>
						<div class="content-recipe-info">
							<span class="glyphicon  glyphicon-signal"></span>&nbsp ${tip.views }
						</div>
						<div class="main-recipe-info">
							<h4>${tip.title }</h4>
							<h6>Danh mục:<a href="../tipv1/view?cate=${tip.cateId }">${tip.cateName }</a></h6>
						</div>
					</div>
			</c:forEach> 
		</div>
		<div class="clear"></div>
						<c:if test="${list_tip != null && fn:length(list_tip) != 0 }">
							<div class="bound-page">
		                    <div class="pagination">
		                    	<a href="../tipv1/view?cate=${cate.id }&page=${first}">&laquo;</a>
		                     	<c:forEach items="${materialpages}" var="page">
		                     		 <c:choose>
				                      	<c:when test="${page != '...' && page == currentpage}">
				                      		<a href="../tipv1/view?cate=${cate.id }&page=${page}" id="pageActive" class="active" data-id="${page}">${page}</a>
				                      	</c:when>
				                      	<c:when  test="${page == '...'}">
				                      		<a>${page}</a>
				                      	</c:when>
				                      	<c:otherwise>
				                      		<a href="../tipv1/view?cate=${cate.id }&page=${page}">${page}</a>
				                      	</c:otherwise>
				                     </c:choose>
		                     	</c:forEach>
							  <a href="../tipv1/view?cate=${cate.id }&page=${last}">&raquo;</a>
							</div>
        					</div>
						</c:if>
	</div>
	
	<div class="tip-menu">
		<ul>
			<c:forEach items="${list_tipcate }" var="cate">
				<li><a href="../tipv1/view?cate=${cate.id }"><span class="glyphicon glyphicon-send"  > </span> ${cate.cateName}</a></li>
			</c:forEach>
		</ul>
	</div>
</div>
</div>
<div class="clear"></div>
