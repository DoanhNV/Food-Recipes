<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<style>
.recipe-search-contain {
	width: 76%;
	float:left;
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
}
.tip-menu ul li a {
	color: white;
	font-size: 14px;
	margin-left: 3px;
}

.tip-menu ul li a:hover {
	text-decoration: none;
	color: silver;
}


.suggest-title{
	padding-top: 5px;
	padding-bottom: 5px;
	font-size: 20px;
	margin-auto;
}

.tip-menu ul li:first-child {
	text-align: center;
}

.post-recipe-bg{
	width: 60px;
	height: 65px;
}

.post-tip-info {
	margin-top: 0px !important;
	padding-top: 3px;
	padding-bottom: 3px;
}
.post-recipe-info:first-child {
	margin-top: 0px !important;
}

.cate-title h2{
	border: none;
}

.cate-title {
	border-bottom: solid 1px green;
}

.recipe-container {
	 box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
	 padding: 10px;
}
</style>
<div class="clear"></div>
<div class="center-content" style="margin-top: 38px;">
	<div class="recipe-container recipe-search-contain">
		<div class="cate-title">
			<h2>${tip.title }</h2>
			<div class="post-cate-info">
					<span class="cate-purpose">Danh mục:</span><b> ${tip.cateName}</b>
					<span class="cate-purpose">Lượt xem:</span><b>${tip.views} </b>
			</div>
		</div>
		${tip.content }
		<div class="left">
				 <h1 class="tip title">Mobile Menu Hamburger jQuery Plugin Demo</h1>
		    <div class="jquery-script-ads">
		    <p> Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy
		      eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam
		      voluptua. At vero eos et accusam et justo duo dolores et ea rebum.
		      Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor
		      sit amet. </p>
		    <p> Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy
		      eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam
		      voluptua. </p>
		    <p> Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy
		      eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam
		      voluptua. At vero eos et accusam et justo duo dolores et ea rebum.
		      Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor
		      sit amet. </p>
		    </div>
		</div>
</div>
<div class="tip-menu">
		<ul>
			<c:forEach items="${list_tipcate }" var="cate">
			</c:forEach>
			<li><b class="suggest-title">Đề xuất</b> </li>
			<c:forEach items="${tip_suggest }" var="tip">
				<li>
					<div  class="post-tip-info">
						<a href="../tipv1/detail?id=${tip.id }"><img src="https://media.cooky.vn/recipe/g1/669/s400x400/recipe669-635519913531386016.jpg" class="post-recipe-bg"/></a>
						<h5>${tip.title }</h5>
					</div>
				</li>
			</c:forEach>
			<li>
				<div class="post-tip-info">
					<a href="#"><img src="https://media.cooky.vn/recipe/g1/669/s400x400/recipe669-635519913531386016.jpg" class="post-recipe-bg"/></a>
					<h5>cách làm cho thức ăn ngon hơn khi có nhiều dầu</h5>
				</div>
			</li>
		</ul>
</div>
</div>
</div>
