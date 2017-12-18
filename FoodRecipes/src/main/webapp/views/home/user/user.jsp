<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif}
.w3-row-padding,.w3-third {
	padding: 0px !important;
}

.tips2 {
	width: 24% !important;
	 margin-right: 66px !important;
}

.load-food:hover {
	text-decoration: none;
	color: green;
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

.pagination a:hover:not(.active) {background-color: #ddd;}

.updateDiv{
	margin-top: 20px;
}

.w3-light-grey {
	background-color: white !important;
}

.w3-row-padding {
	margin-top: 60px !important;
	background-color: #f1f1f1!important;
}
</style>
<body class="w3-light-grey">

<!-- Page Container -->
<div class="w3-content w3-margin-top" style="max-width:1400px;">

  <!-- The Grid -->
  <div class="w3-row-padding">
  
    <!-- Left Column -->
    <div class="w3-third">
    
      <div class="w3-white w3-text-grey w3-card-4">
        <div class="w3-display-container">
        <c:choose>
        	<c:when test="${user_profile.profileImage eq '/resources/asset/img/cooker.png' }">
        		<img src="<%=request.getContextPath()%>${user_profile.profileImage}" style="width:100%" alt="Avatar">
        	</c:when>
        	<c:otherwise>
        		<img src="${user_profile.profileImage}" style="width:100%" alt="Avatar">
        	</c:otherwise>
        </c:choose>
          <div class="w3-display-bottomleft w3-container w3-text-black">
            <h2 style="color:green">${user_profile.fullName }</h2>
          </div>
        </div>
        <div class="w3-container">
          <p style="margin-top:15px;"><i class="fa fa-home fa-fw w3-margin-right w3-large w3-text-teal"></i>Ngày sinh: ${user_profile.birthDay }</p>
          <p><i class="fa fa-envelope fa-fw w3-margin-right w3-large w3-text-teal"></i>Email: ${user_profile.email }</p>
          <hr>
          <c:if test="${sessionScope.sessionUser.id == user_profile.id}">
          	 <p class="w3-large" style="margin: 0 0 18px;">
			  <b><i class="fa fa-asterisk fa-fw w3-margin-right w3-text-teal">
			  </i>
			  	<a href="#" id="btnUpdate"><span><img src="<%=request.getContextPath()%>/resources/asset/img/refresh-arrows.png" /></span></a>
			  </b>
			  </p>
          </c:if>
          <p class="w3-large" style="margin: 0 0 18px;"><b><i class="fa fa-asterisk fa-fw w3-margin-right w3-text-teal"></i>Food</b></p>
          <p> <span><img src="<%=request.getContextPath()%>/resources/asset/img/clipboard.png" /></span><a href="../user/profile?id=${user_profile.id }&kind_cate=1" class="load-food" >Công thức đã lưu </a> </p>
          <div class="w3-light-grey w3-round-xlarge w3-small">
            <div class="w3-container w3-center w3-round-xlarge w3-teal" style="width:100%">${user_profile.recipeSavedNumber}</div>
          </div>
          <p style="margin: 0 0 18px;" ><span><img src="<%=request.getContextPath()%>/resources/asset/img/package.png" /><a href="../user/profile?id=${user_profile.id }&kind_cate=2" class="load-food" > Mẹo vặt đã lưu </a></p>
          <div class="w3-light-grey w3-round-xlarge w3-small">
             <div class="w3-container w3-center w3-round-xlarge w3-teal" style="width:100%">${user_profile.tipSavedNumber}</div>
          </div>
          <br>
        </div>
      </div><br>

    <!-- End Left Column -->
    </div>

    <!-- Right Column -->
    <div class="w3-twothird">
    
      <div class="w3-container w3-card w3-white w3-margin-bottom" id="divChange">
      	<div style="width:100%;height:100%; display:none;" class="updateDiv">
      			<h3 style="font-weight:bold; color:green">Cập nhật thông tin</h3>
      			<form action="../user/update" modelAttribute="user"  enctype="multipart/form-data" method="POST">
      				<input type="hidden" name="id"  value="${user_profile.id }" id="valueUserId"/>
					 <div class="form-group">
  						<label for="usr">Mật khẩu:</label>
						  <div class="input-group">
						    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
						    <input required="required" id="txtPassword" name="password" type="password" class="form-control" name="password" placeholder="mật khẩu">
						  </div>
				 	 </div> 
				  	<div class="form-group">
  						<label for="usr">Tên hiển thị:</label>
						  <div class="input-group">
						    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
						    <input required="required"  id="txtFullName" type="text" name="fullName" class="form-control"  placeholder="tên hiển thị">
						  </div>
					 </div> 
					 <div class="form-group">
  						<label for="usr">Ngày sinh:</label>
						  <div class="input-group">
						    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
						    <input required="required" id="txtBirthday"  type="date" name="userBirthday" class="form-control"  placeholder="Ngày sinh">
						  </div>
					 </div> 
					 <div class="form-group">
  						<label for="usr">Email:</label>
						  <div class="input-group">
						    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
						    <input required="required" id="txtEmail" type="email" name="email" class="form-control" name="email" placeholder="Email">
						  </div>
					 </div> 
					 <div class="form-group">
					 		<label for="usr">Ảnh đại diện:</label>
							<div class="input-group input-file" name="Fichier1">
								<span class="input-group-btn">
					        		<button class="btn btn-default btn-choose" type="button" id="btnChooseImg">Choose</button>
					    		</span>
					    		<input type="text" class="form-control" id="fileVal" placeholder='Giữ ảnh cũ...' />
					    		<span class="input-group-btn">
					       			 <button class="btn btn-warning btn-reset" type="button" id="btnResetFile">Reset</button>
					    		</span>
					    		<input type="file" name="profileFile" id="profileId" style="display:none;"/>
							</div>
					 </div>
					 <div class="form-group"> 
					    <div class="">
					      <button type="submit" class="btn btn-success" id="btnUpdateUserInfo">Cập nhật</button>
					      <button type="button" class="btn btn-danger" id="btnCancle">Cancle</button>
					    </div>
					  </div>
				</form>
      	</div>
      	<div class="content">
      	
        <h2 class="w3-text-grey w3-padding-16"><i class="fa fa-suitcase fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i></h2>
        		<c:choose>
        			<c:when test="${fn:length(list_recipe) == 0 }">
        				<h3>0 công thức  đã lưu</h3>
        			</c:when>
        			<c:otherwise>
        				<c:forEach items="${list_recipe }" var="recipe">
	        				<div class="recipe tips tips2">
	        					<c:choose>
	        						<c:when test="${kind_cate == 1 }">
	        							<a href="../recipe/detail?id=${recipe.id }">
											<img src="${recipe.featureImage }" class="recipe-bg"/>
										</a>
	        						</c:when>
	        						<c:otherwise>
	        							<a href="../tip/detail?id=${recipe.id }">
											<img src="${recipe.image }" class="recipe-bg"/>
										</a>
	        						</c:otherwise>
	        					</c:choose>
								<div class="content-recipe-info">
									<c:choose>
		        						<c:when test="${kind_cate == 1 }">
		        							<span class="glyphicon  glyphicon-signal"></span>&nbsp ${recipe.views }
		        						</c:when>
		        						<c:otherwise>
		        							<span class="glyphicon  glyphicon-signal"></span>&nbsp ${recipe.view}
		        						</c:otherwise>
	        						</c:choose>
									
								</div>
								<div class="main-recipe-info">
									<h4>${recipe.title }</h4>
									<h6>Đăng ngày:<a href="#"> ${recipe.createTime }</a></h6>
								</div>
							</div>
        				</c:forEach>
        				<div class="clear"></div>
        				 <div class="bound-page">
		                    <div class="pagination">
		                    	<a href="../user/profile?id=${user_profile.id}&page=${first}&kind_cate=${kind_cate}">&laquo;</a>
		                     	<c:forEach items="${materialpages}" var="page">
		                     		 <c:choose>
				                      	<c:when test="${page != '...' && page == currentpage}">
				                      		<a href="../user/profile?id=${user_profile.id}&page=${page}&kind_cate=${kind_cate}" id="pageActive" class="active" data-id="${page}">${page}</a>
				                      	</c:when>
				                      	<c:when  test="${page == '...'}">
				                      		<a>${page}</a>
				                      	</c:when>
				                      	<c:otherwise>
				                      		<a href="../user/profile?id=${user_profile.id}&page=${page}&kind_cate=${kind_cate}">${page}</a>
				                      	</c:otherwise>
				                     </c:choose>
		                     	</c:forEach>
							  <a href="../user/profile?id=${user_profile.id}&page=${last}&kind_cate=${kind_cate}">&raquo;</a>
							</div>
                    	</div>
        			</c:otherwise>
        		</c:choose>
        		</div>
     </div>

    </div>
  </div>
</div>
</div>


<script type="text/javascript">
	$(document).ready(function(){
		update();
		upload();
		resetFile();
		cancle();
	});
	
	
	function update(){
		$("#btnUpdate").click(function(e){
			e.preventDefault();
			$(".content").remove();
			$("#divChange").attr("style","height:800px;");
			$.ajax({
				type : "POST",
				data : $("#valueUserId").val(),
				dataType :  "json",
				url : "../user/getdata",
				async : false,
				success : function(data) {
					$("#txtFullName").val(data.fullName);
					$("#txtEmail").val(data.email);
					$("#txtBirthday").val(data.birthDay);
				},
				error: function (){
					alert("error");
				}
			});
			$(".updateDiv").attr("style","display:block");
		});
	}
	
	function upload(){
		$("#btnChooseImg").click(function(){
			$("#profileId").trigger("click");
			$("#profileId").change(function(){
				$("#fileVal").val($("#profileId").val());
			});
		});
		
	}
	
	function resetFile(){
		$("#btnResetFile").click(function(){
			$("#fileVal").val("");
			$("#profileId").val("")
		});
	}
	
	function cancle(){
		$("#btnCancle").click(function(){
			window.location.href = "../user/profile?id="+$("#valueUserId").val();
		});
	}
</script>
