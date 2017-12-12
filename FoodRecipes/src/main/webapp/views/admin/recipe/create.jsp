
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
	.parent-pop{
		position: absolute;
		top:0;
		left:0;
		width: 100%;
		height: 100%;
		background-color:  rgba(12,11,11,0.5);
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
	}
	
	.child-content{
		height: 100px;
		float: left;
		border: solid 0.5px green;
		border-radius: 2px;
		margin-right: 5px;
	}
	
	#submitMaterial{
		margin-left: 82.7%;
	}
	
	.check-mater {
		zoom: 5;
		margin: 0px !important;
		display: inline;
	}
	
	.mater-img {	
		vertical-align: top !important;
		width:80px;
		height:60px
	}
	
	.mater-name{
		font-size: 11px;
		color: black;
		font-weight: bold;
	}
</style>
<!-- Popup create -->
	<div class="parent-pop">
		<div class="child-pop ">
			<c:forEach items="${listmaterial}" var="material">
				<div class="child-content ">
					<div>
						<input type="checkbox" value="${material.id}" class="check-mater"> 
						<img src="${material.featureImage}"  class="mater-img"/>
					</div>
					<div class="clear"></div>
					<span class="mater-name">${material.materialName}</span>
				</div>
			</c:forEach>
		</div>
		<div class="clear"></div>
		<button type="button" class="btn btn-success" id="submitMaterial">Hoàn thành</button>
	</div>
<div class="clear"></div>
<div class="create-recipe-title">
	<h2>Tạo mới và chia sẻ công thức</h2>
</div>
<div class="clear"></div>
<div class="create-recipe-title create-header"></div>
<form method="POST" action="../admin_recipe/doCreate" modelAttribute="recipe" enctype="multipart/form-data" >
<div class="">
	<div class="create create-left">
		<div class="create-left-content">
				<div class="recipe-create-title">Tên món ăn</div>
				<div class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-pencil"></i></span> <input type="text" name="title"
						class="form-control" placeholder="Nhập tên món ăn">
				</div>
				<div class="recipe-create-title">Ảnh đại diện</div>
				<input type="file" id="upload-file-profile" name="img"
					class="file-upload-profile" style="display: none;" />
				<button type="button" id="openfile" class="btn btn-upload">
					<span class="glyphicon glyphicon-upload"></span>Upload
				</button>
				<div class="preview-recipe-profile" id="image-temp">
					<img src="" id="img-temp" style="width: 100%; height: 100%;"
						alt="preview Profile image" />
				</div>
				<div class="clear"></div>
				<div class="recipe-create-title">Thời gian</div>
				<select class="form-control select">
					<option>Giờ</option>
					<option>0 Giờ</option>
					<option>1 Giờ</option>
					<option>2 Giờ</option>
				</select> <select class="form-control select">
					<option>Phút</option>
					<option>0 Phút</option>
					<option>1 Phút</option>
					<option>2 Phút</option>
				</select>
				<div class="clear"></div>
				<div class="recipe-create-title">Chi phí</div>
				<select class="form-control select cost-select">
					<option>rẻ</option>
					<option>trung bình</option>
					<option>đắt</option>
				</select>
				<div class="clear"></div>
				<div class="recipe-create-title">Nguyên liệu</div>
				<div class="cate-step-content">
					<div class="checkbox cate-check ">
						<button type="button" name='testField' class="btn btn-success" name="" value="1">Cà chua<span class="glyphicon glyphicon-tags title-material-tag"></span>
						</button>
						
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
				<div class="add-material">
					<h4>Thêm nguyên liệu</h4>
					<div class="mater-left">
						<div class="material-add-title">Tên nguyên liệu</div>
						<input type="text" class="form-control"
							placeholder="nhập tên nguyên liệu" />
					</div>
					<div class="mater-left mater-right">
						<input type="file" id="uploadfileMater" name="img"
							class="file-upload" style="display: none;" />
						<button type="button" id="openfileMater"
							class="btn btn-upload-mater">
							<span class="glyphicon glyphicon-upload"></span>Upload
						</button>
						<div class="preview-recipe-mater" id="image-temp">
							<img src="" id="img-temp-mater"
								style="width: 100%; height: 100%;" alt="preview Profile image" />
						</div>
					</div>
					<div class="clear"></div>
					<button type="button" class="btn btn-danger">Thêm mới</button>
					<button type="button" class="btn btn-danger" id="btnChooseM">chọn nguyên liệu</button>
				</div>
			
		</div>
		<div class="clear"></div>
		<div class="recipe-create-title">Các bước thực hiện</div>
		<div class="create-left-content step-practise" id="step1">
			<div class="step-post step-element-number">
				<div class="number-title">1</div>
			</div>
			<div class="step-post step-element-content">
				<div class="form-group">
					<textarea class="form-control baby-step-content" rows="5"></textarea>
				</div>
				<div class="clear"></div>
				<input type="file" id="upload-file-step1" name="recipeFiles"
					class="file-upload1" style="display: none;" multiple />
				<button type="button" class="btn upload-step" id="uploadStep1">
					<span class="glyphicon glyphicon-camera"></span>
				</button>

				<!-- hidden -->
				<div class="preview-step-img " id="preview1">
					<div class="preview-step-img-element">
						<img src="" class="preview-element-img" id="img-preview1" />
					</div>
				</div>
			</div>
		</div>
		<div class="clear"></div>
		<div class="last-step add-step" id="addStep">
			<btn class="btn btn-success">Thêm bước thực hiện</btn>
		</div>
		<button type="button" class="last-step btn btn-success btn-last" id="mainSubmit">Hoàn thành
	</div>
</div>
<div class="create create-right">
	<div class="recipe-create-title">Phân loại</div>
	<div class="cate-step">
		<c:forEach items="${list_kind_cate }" var="list">
			<div class="cate-step-title">${list.title}</div>
			<div class="cate-step-content">
				<c:forEach items="${list.cates}" var="cate" varStatus="status">
					<div class="checkbox cate-check ">
						<label><input type="checkbox" name="recipeCate" value="${cate.id}">${cate.title}</label>
					</div>
				</c:forEach>
			</div>
			<div style="clear:both;"></div>
		</c:forEach>

	</div>
</div>
<button type="submit" class="last-step btn btn-success btn-last" id="triggerSubmit" style="display:none;">
</form>



<script type="text/javascript">
	$(document).ready(function() {

		uploadProfileFile();
		uploadStepFile();
		addStep();
		uploadProfileMaterial();
		submitStrigger();
		getMaterial();
		chooseM();
		$("[name='testField']").click(function(){
			alert($("[name='testField']").val());
		});
	});
	
	function getMaterial(){
		$("#submitMaterial").click(function(){
			$(".parent-pop").attr("style","display:none");
		});
	}
	
	function chooseM(){
		$("#btnChooseM").click(function(){
			$(".parent-pop").attr("style","display:block");
		});
	}
	
	function submitStrigger(){
		$("#mainSubmit").click(function(){
			if(validateCheckBox()){
				$("#triggerSubmit").trigger("click");
			}
			
		});
	}
	
	function validateCheckBox(){
		var result = false;
		$("input[type='checkbox'][name='recipeCate']").each(function() {
			  if($(this).is(':checked')) {
				  result = true;
			  }
		});
		if(!result){
			alert("Bạn cần chọn danh mục");
		}
		return result;
	}

	function uploadProfileFile() {
		$("#openfile").off("click").click(function() {
			$(".file-upload-profile").trigger('click');
		});

		$('#upload-file-profile').on('change', function() {
			var filePath = $("#upload-file-profile")[0].files[0];
			var reader = new FileReader();
			reader.readAsDataURL(filePath);

			reader.onload = function(event) {
				$("#img-temp").attr("src", reader.result);
			};
		});
	}

	function uploadProfileMaterial() {
		$("#openfileMater").off("click").click(function() {
			$("#uploadfileMater").trigger('click');
		});

		$('#uploadfileMater').on('change', function() {
			var filePath = $("#uploadfileMater")[0].files[0];
			var reader = new FileReader();
			reader.readAsDataURL(filePath);

			reader.onload = function(event) {
				$("#img-temp-mater").attr("src", reader.result);
			};
		});
	}

	function uploadStepFile() {
		var number = 0;
		var uploadId = "";

		$(document).on('click', '.upload-step', function() {
			var id = $(this).attr("id");
			number = id.substring(id.length - 1, id.length);
			uploadId = "#upload-file-step" + number;
			$(".file-upload" + number).val("");
			$(".file-upload" + number).trigger('click');
			$(".file-upload" + number).change(function() {
				var filePaths = $("#upload-file-step" + number)[0].files;
				var filePath = $("#upload-file-step" + number)[0].files[0];
				var reader = new FileReader();
				reader.readAsDataURL(filePath);

				reader.onload = function(event) {
					$("#img-preview" + number).attr("src", reader.result);
					$("#preview" + number).attr("style", "display:block");
				};
			});
		});
	}

	function addStep() {

		$("#addStep")
				.off("click")
				.click(
						function() {
							var lastNumber = $(".step-practise").length;
							var nextNumber = lastNumber + 1;
							var step = '<div class="create-left-content step-practise" id="step'+nextNumber+'">'
									+ '<div class="step-post step-element-number">'
									+ '<div class="number-title">'
									+ nextNumber
									+ '</div>'
									+ '</div>'
									+ '<div class="step-post step-element-content">'
									+ '<div class="form-group">'
									+ '<textarea class="form-control baby-step-content" rows="5" ></textarea>'
									+ '</div>'
									+ '<div class="clear"></div>'
									+ '<input type="file" id="upload-file-step'+nextNumber+'" name="recipeFiles" class="file-upload'+nextNumber+'" style="display:none;" multiple/>'
									+ '<button type="button" class="btn upload-step" id="uploadStep'+nextNumber+'"><span class="glyphicon glyphicon-camera"></span></button>'

									+ '<div class="preview-step-img " id="preview'+nextNumber+'">'
									+ '<div class="preview-step-img-element">'
									+ '<img src="" class="preview-element-img" id="img-preview'+nextNumber+'" />'
									+ '</div>' + '</div>' + '</div>' + '</div>';
							var root = $("#step" + lastNumber);
							root.after(step);
							var body = $("body");
						});
	}
</script>