<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
	.recipet {
		height: 273px !important;
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
							<h2>Công thứ mới nhất</h2>
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
							<div class="recipe recipet">
								<a href="#">
									<img src="https://media.cooky.vn/recipe/g2/18934/s320x320/recipe18934-636223327393486258.jpg" class="recipe-bg"/>
								</a>
								<div class="content-recipe-info">
									<span class="glyphicon glyphicon-time"></span>&nbsp 30p
									<span class="glyphicon  glyphicon-usd"></span>&nbsp 300.000
									<span class="glyphicon  glyphicon-signal"></span>&nbsp 280
								</div>
								<div class="main-recipe-info">
									<h4>Bún mắm miền tây đúng điệu</h4>
									<h6>công thức bởi:<a href="#"> Chúng ta cùng ăn</a></h6>
								</div>
							</div>
							<div class="recipe recipet">
								<a href="#">
									<img src="https://media.cooky.vn/recipe/g2/19418/s320x320/recipe19418-636264018759086036.jpg" class="recipe-bg"/>
								</a>
								<div class="content-recipe-info">
									<span class="glyphicon glyphicon-time"></span>&nbsp 2h15
									<span class="glyphicon  glyphicon-usd"></span>&nbsp 180.000
									<span class="glyphicon  glyphicon-signal"></span>&nbsp 1000
								</div>
								<div class="main-recipe-info">
									<h4>Cá trắm hấp hành lá</h4>
									<h6>công thức bởi:<a href="#"> Đầu bếp tý hon</a></h6>
								</div>
							</div>
							<div class="recipe recipet">
								<a href="#">
									<img src="https://media.cooky.vn/recipe/g3/25266/s320x200/recipe-cover-r25266.jpg" class="recipe-bg"/>
								</a>
								<div class="content-recipe-info">
									<span class="glyphicon glyphicon-time"></span>&nbsp 25p
									<span class="glyphicon  glyphicon-usd"></span>&nbsp 360.000
									<span class="glyphicon  glyphicon-signal"></span>&nbsp 800
								</div>
								<div class="main-recipe-info">
									<h4>Gỏi xoài cá trê kiểu Thái</h4>
									<h6>công thức bởi:<a href="#"> Tô Vĩnh uyên</a></h6>
								</div>
							</div>
							<div class="recipe recipet">
								<a href="#">
									<img src="https://media.cooky.vn/recipe/g2/18132/s320x320/cooky-recipe-636099895938041859.jpg" class="recipe-bg"/>
								</a>
								<div class="content-recipe-info">
									<span class="glyphicon glyphicon-time"></span>&nbsp 1h15p
									<span class="glyphicon  glyphicon-usd"></span>&nbsp trung bình
									<span class="glyphicon  glyphicon-signal"></span>&nbsp 1000
								</div>
								<div class="main-recipe-info">
									<h4>Sandwich kẹp jambon - bacon</h4>
									<h6>công thức bởi:<a href="#"> Nguyễn Linh Anh</a></h6>
								</div>
							</div>
							<div class="recipe recipet">
								<a href="#">
									<img src="https://media.cooky.vn/recipe/g2/18230/s320x320/cooky-recipe-636114352782603712.jpg" class="recipe-bg"/>
								</a>
								<div class="content-recipe-info">
									<span class="glyphicon glyphicon-time"></span>&nbsp 1h15p
									<span class="glyphicon  glyphicon-usd"></span>&nbsp trung bình
									<span class="glyphicon  glyphicon-signal"></span>&nbsp 692
								</div>
								<div class="main-recipe-info">
									<h4>Cánh gà sốt cay ngọt kiểu Hàn Quốc</h4>
									<h6>công thức bởi:<a href="#"> Ngô Văn Doanh</a></h6>
								</div>
							</div>
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
					<div class="material-element col-md-1">
						<a href="#">
							<img src="https://znews-photo-td.zadn.vn/w660/Uploaded/lepx/2016_09_23/FarmedSalmon.jpg" class="material-bg img-circle"/>
							<h4>cá hồi</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="http://suckhoedoisong.vn/thumb_600x400/Images/_OLD/JRGSJiLd3e5GsxdM0P2pqg65KoKccc/Image/2013/05/An-dac-san-ruong-dong-de-co-nguy-co-mac-benh-san-nhai-fce59.jpg" class="material-bg img-circle"/>
							<h4>ếch</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="http://nangmuisline.info/wp-content/uploads/2017/08/ba-bau-an-thit-vit-loi-hay-hai_KXXO.jpg" class="material-bg img-circle"/>
							<h4>vịt</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="http://meovaobep.com/wp-content/uploads/2015/05/tang-cuong-sinh-ly-hieu-qua-voi-so-huyet.jpg" class="material-bg img-circle"/>
							<h4>sò</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="http://toinayangi.vn/wp-content/uploads/2015/08/m%C3%B3n-%C4%83n-%C4%91%C6%A1n-gi%E1%BA%A3n-t%E1%BB%AB-ngao.jpg" class="material-bg img-circle"/>
							<h4>Ngao</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="http://chonguoiviet.vn/wp-content/uploads/2015/12/mong-gio-lon-sach-hoa-binh-1.jpg" class="material-bg img-circle"/>
							<h4>giò</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="http://giatimac.vn/upload/news/78505869.jpg" class="material-bg img-circle"/>
							<h4>táo</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="https://znews-photo-td.zadn.vn/w660/Uploaded/uopuoka/2015_06_08/muop21433494115951.jpg" class="material-bg img-circle"/>
							<h4>mướp</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="https://cdn02.static-adayroi.com/0/2016/02/25/1456373249253_7717013.jpg" class="material-bg img-circle"/>
							<h4>chân gà</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="http://f5channel.com/wp-content/uploads/2017/07/meo-chon-nam-ngon-va-an-toan-dam-bao-cho-suc-khoe-1.jpeg.jpg" class="material-bg img-circle"/>
							<h4>nấm</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="http://hapigreen.vn/upload/sanpham/large/79-ca-phao-trang.jpg" class="material-bg img-circle"/>
							<h4>cà</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="http://www.canada.com/health/cms/binary/2486247.jpg" class="material-bg img-circle"/>
							<h4>rau cải</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="https://trangvikhang.com/wp-content/uploads/2015/06/9.jpg" class="material-bg img-circle"/>
							<h4>bí đỏ</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="http://vuonraudalat.vn/wp-content/uploads/2017/03/Bi-dao-xanh-1.jpg" class="material-bg img-circle"/>
							<h4>bí xanh</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="http://trangdahieuqua.com/public/frontend/uploads/images/s%C6%B0%C6%A1ng/tr%E1%BB%8B_n%C3%A1m_b%E1%BA%B1ng_kh%E1%BB%95_qua.jpg" class="material-bg img-circle"/>
							<h4>mướp đắng</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="http://thuyhaisanvandung.com/file/2016/01/set-menu-dac-san-cua-tai-nha-hang-nang-cua-201442684042778.jpg" class="material-bg img-circle"/>
							<h4>cua</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="http://3ae.vn/images/L3VwbG9hZC9idWxnb2dpLnZuLzIwMTUvMDYvMjkvbWcyNTU1XzI5MDYyMDE1MzYzODEwMDAwLi5qcGc=_0x99_1.jpg" class="material-bg img-circle"/>
							<h4>tôm</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="http://daihocduochanoi.com/wp-content/uploads/2017/07/ca.jpg" class="material-bg img-circle"/>
							<h4>cá</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="http://picfood.vn/wp-content/uploads/2016/11/gioi-thieu-quy-trinh-san-xuat-thit-ga-tha-vuon.jpg" class="material-bg img-circle"/>
							<h4>gà</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="https://jamja.vn/blog/wp-content/uploads/2017/09/uop-thit-bo-xao.jpg" class="material-bg img-circle"/>
							<h4>thịt bò</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="http://cdn.web30s.vn/datafiles/1/01-03-2017/14883338739865_trung-ga-1.jpg" class="material-bg img-circle"/>
							<h4>trứng</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="https://www.birdseye.com/wp-content/themes/birdseye/assets/images/panels/bg-broccoli-l.jpg" class="material-bg img-circle"/>
							<h4>súp lơ</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="http://eucofel.eu/wp-content/uploads/2016/01/tomato-crop-pakistan-437x270.jpg" class="material-bg img-circle"/>
							<h4>cà chua</h4>
						</a>
					</div>
					<div class="material-element col-md-1">
						<a href="#">
							<img src="http://cdn-img.health.com/sites/default/files/styles/medium_16_9/public/styles/main/public/red-peppers-better-raw-400x400.jpg?itok=8DU0ERUy" class="material-bg img-circle"/>
							<h4>ớt</h4>
						</a>
					</div>
				</div>
				<div class="clear"></div>
				<div class="cate-title">
					<h2>Công thức nổi bật</h2>
				</div>
				<div class="tips-container">
					<c:forEach items="${list_tip}" var="tip" varStatus="status">
						<div class="recipe tips">
							<a href="../search/tip?kind=id&id=${tip.id}">
								<img src="${tip.featureImage }" class="recipe-bg"/>
							</a>
							<div class="content-recipe-info">
								<span class="glyphicon  glyphicon-signal"></span>&nbsp ${tip.views }
							</div>
							<div class="main-recipe-info">
								<h4>${tip.title }</h4>
								<h6>công thức bởi:<a href="../home/index"> FoodRecipes</a></h6>
								<h6>Danh mục:<a href="../search/tip?kind=cate&id=${tip.cateId}"> ${tip.cateName }</a></h6>
							</div>
						</div>
					</c:forEach>
					<div class="recipe tips">
						<a href="#">
							<img src="https://media.cooky.vn/article/s240x240/cooky-article-cover-b4339.jpg" class="recipe-bg"/>
						</a>
						<div class="content-recipe-info">
							<span class="glyphicon  glyphicon-signal"></span>&nbsp 1000
						</div>
						<div class="main-recipe-info">
							<h4>Tổng hợp 4 cách rã đông thịt nhanh chóng, đúng cách và những điều cần lưu ý</h4>
							<h6>công thức bởi:<a href="#"> Ngô Văn Doanh</a></h6>
							<h6>Danh mục:<a href="#"> CẨM NANG & MẸO VẶT</a></h6>
						</div>
					</div>
					<div class="recipe tips">
						<a href="#">
							<img src="https://media.cooky.vn/article/s270x270/cooky-article-cover-b4263.jpg" class="recipe-bg"/>
						</a>
						<div class="content-recipe-info">
							<span class="glyphicon  glyphicon-signal"></span>&nbsp 1000
						</div>
						<div class="main-recipe-info">
							<h4>Những lỗi cơ bản trong làm bánh bông lan lý giải nguyên </h4>
							<h6>công thức bởi:<a href="#"> Cuộc sống quanh ta</a></h6>
							<h6>Danh mục:<a href="#"> ẩm thực hằng ngày</a></h6>
						</div>
					</div>
					<div class="recipe tips tips-fouth">
						<a href="#">
							<img src="https://media.cooky.vn/article/s240x240/cooky-article-cover-b4338.jpg" class="recipe-bg"/>
						</a>
						<div class="content-recipe-info">
							<span class="glyphicon  glyphicon-signal"></span>&nbsp 1000
						</div>
						<div class="main-recipe-info">
							<h4>Gợi ý bữa tiệc tri ân Thầy Cô nhân ngày 20/11 vừa đơn giản </h4>
							<h6>công thức bởi:<a href="#"> Bùi Thị Như Quỳnh</a></h6>
							<h6>Danh mục:<a href="#"> mẹo vặt cuộc sống</a></h6>
						</div>
					</div>
					<div class="clear"></div>
					<div class="recipe tips">
						<a href="#">
							<img src="https://media.cooky.vn/article/s270x270/cooky-article-cover-b4298.jpg" class="recipe-bg"/>
						</a>
						<div class="content-recipe-info">
							<span class="glyphicon  glyphicon-signal"></span>&nbsp 1000
						</div>
						<div class="main-recipe-info">
							<h4>Những thực phẩm càng đen nhưng lại càng bổ dưỡng</h4>
							<h6>công thức bởi:<a href="#"> Phương Hoàng</a></h6>
							<h6>Danh mục:<a href="#">Mẹo vặt quanh ta</a></h6>
						</div>
					</div>
					<div class="recipe tips">
						<a href="#">
							<img src="https://media.cooky.vn/article/s270x270/cooky-article-cover-b4299.jpg" class="recipe-bg"/>
						</a>
						<div class="content-recipe-info">
							<span class="glyphicon  glyphicon-signal"></span>&nbsp 1000
						</div>
						<div class="main-recipe-info">
							<h4>Cách sơ chế sợi hủ tiếu ngon, dai, không bở và bết dính cho </h4>
							<h6>công thức bởi:<a href="#">Mai Linh</a></h6>
							<h6>Danh mục:<a href="#"> Gia đình</a></h6>
						</div>
					</div>
					<div class="recipe tips">
						<a href="#">
							<img src="https://media.cooky.vn/article/s270x270/cooky-article-cover-b4302.jpg" class="recipe-bg"/>
						</a>
						<div class="content-recipe-info">
							<span class="glyphicon  glyphicon-signal"></span>&nbsp 1000
						</div>
						<div class="main-recipe-info">
							<h4>Lợi ích vàng của tâm sen và sử dụng sao cho đúng cách để </h4>
							<h6>công thức bởi:<a href="#">Khánh Hoàng</a></h6>
							<h6>Danh mục:<a href="#">Tiết kiệm</a></h6>
						</div>
					</div>
					<div class="recipe tips tips-fouth">
						<a href="#">
							<img src="https://media.cooky.vn/article/s270x270/cooky-article-cover-b4351.jpg" class="recipe-bg"/>
						</a>
						<div class="content-recipe-info">
							<span class="glyphicon  glyphicon-signal"></span>&nbsp 1000
						</div>
						<div class="main-recipe-info">
							<h4>4 cách kho cá lóc đậm màu chuẩn vị thơm ngon không thể </h4>
							<h6>công thức bởi:<a href="#">Linh Ngân</a></h6>
							<h6>Danh mục:<a href="#">Món ngon mỗi ngày</a></h6>
						</div>
					</div>
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


