<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<div class="start-end">
			<div class="container">
				<c:forEach items="${sessionScope.footer_session}" var="kind_cate">
					<div class="footer-element col-md-3">
					<h4>${kind_cate.title }</h4>
						<ul>
							<c:forEach items="${kind_cate.cates }" var="cate">
								<li><span class="glyphicon glyphicon-share"><a href="../search/recipe?kind=cate&id=${cate.id }"> ${cate.title } (${cate.recipeNumber })</a></li>
							</c:forEach>
						</ul>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="end-footer">
			<h5>© 2017 ngân lê. Giấy phép MXH 540/GP-BTTTT cấp ngày 02/12/2017</h5>
		</div>