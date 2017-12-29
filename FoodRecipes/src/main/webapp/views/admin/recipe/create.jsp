
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
		width:80px;
		height:60px
	}
	
	.mater-name {
		font-size: 11px;
		color: black;
		font-weight: bold;
	}
	
	.material-search-box {
		margin-top: -10;
		margin-bottom: 5px;
	}
	
	.material-search {
		text-align: center;
	}
	
	.material-search input {
		border-radius: 5px;
	}
</style>
<form method="POST" action="../admin_recipe/doCreate"  enctype="multipart/form-data" >
<input type="hidden" id="listMaterials" name="listMIds" />
<!-- Popup create -->
	<div class="parent-pop">
		<div class="child-pop ">
			<div style="width:100%;height:200px;" class="material-search-box row">
				  <div class="input-group col-xs-12 ">
				    <span class="input-group-addon">Tìm kiếm</span>
				    <input id="txtMKeyWord" type="text" class="form-control" name="msg" placeholder="nhập tên nguyên liệu">
				  </div>
				  <div class="clear appendMaterial"></div>
			</div>
			<div style="width:100%;height:5px;margin-top:5px;margim-bottom:5px;"></div>
			<c:forEach items="${listmaterial}" var="material">
				<div class="child-content ">
					<div>
						<input type="checkbox" value="${material.id}" class="check-mater" name="materialIds"> 
						<img src="${material.featureImage}"  class="mater-img"/>
					</div>
					<div class="clear"></div>
					<span class="mater-name" id="materialid-${material.id}">${material.materialName}</span>
				</div>
			</c:forEach>
		</div>
		<div class="clear"></div>
		<button type="button" class="btn btn-success" id="submitMaterial">Hoàn thành</button>
	</div>
<div class="clear"></div>
<div class="create-recipe-title">
	<h1 style="padding-top: 40px;">Tạo mới và chia sẻ công thức</h1>
</div>
<div class="clear"></div>
<div class="create-recipe-title create-header"></div>
<div class="">
	<div class="create create-left">
		<div class="create-left-content">
				<div class="recipe-create-title">Tên món ăn <span class="required">*</span></div>
				<div class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-pencil"></i></span> <input type="text" name="title"
						class="form-control" placeholder="Nhập tên món ăn" required="required">
				</div>
				<div class="recipe-create-title">Ảnh đại diện <span class="required">*</span></div>
				<input type="file" id="upload-file-profile" name="featureImage"
					class="file-upload-profile" style="display: none;" />
				<button type="button" id="openfile" class="btn btn-upload">
					<span class="glyphicon glyphicon-upload"></span>Upload
				</button>
				<div class="preview-recipe-profile" id="image-temp">
					<img src="" id="img-temp" style="width: 100%; height: 100%;"
						alt="preview Profile image" />
				</div>
				<div class="clear"></div>
				<div class="recipe-create-title">Thời gian <span class="required">*</span></div>
				<select class="form-control select" name="hour">
					<c:forEach items="${recipe_hours }"  var="recipeHourItem">
								<option value="${recipeHourItem.timeValue}">${recipeHourItem.timeName}</option>
					</c:forEach>
				</select> 
				<select class="form-control select" name="minute">
					<c:forEach items="${recipe_minutes }"  var="recipeMinuteItem">
						<option value="${recipeMinuteItem.timeValue}">${recipeMinuteItem.timeName}</option>
					</c:forEach>
				</select>
				<div class="clear"></div>
				<div class="recipe-create-title">Chi phí (VNĐ) <span class="required">*</span></div>
				<div class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-pencil"></i></span> <input type="number" name="cost"
						class="form-control" placeholder="VNĐ" required="required" style="width: 200px;">
				</div>
				<div class="recipe-create-title">Video (youtube url)</div>
				<div class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-pencil"></i></span> <input type="text" name="video" id="videoField"
						class="form-control" placeholder="https://www.youtube.com/watch?v=KYOHHLaiuXk" style="width: 400px;">
				</div>
				<div class="clear"></div>
				<div class="recipe-create-title">Nguyên liệu <span class="required">*</span></div>
				<div class="cate-step-content" id="tagRecipeCate">
				</div>
				<div class="clear"></div>
				<div class="add-material">
					<button type="button" class="btn btn-danger" id="btnChooseM">chọn nguyên liệu</button>
				</div>
		</div>
		<div class="clear"></div>
		<div class="recipe-create-title">Các bước thực hiện <span class="required">*</span></div>
		<div class="create-left-content step-practise" id="step1">
			<div class="step-post step-element-number">
				<div class="number-title">1</div>
			</div>
			<div class="step-post step-element-content">
				<div class="form-group">
					<textarea class="form-control baby-step-content" rows="5" name="stepText" required="required"></textarea>
				</div>
				<div class="clear"></div>
				<input type="file" id="upload-file-step1" name="stepImg"
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
	<div class="recipe-create-title">Phân loại <span class="required">*</span></div>
	<div class="cate-step">
		<c:forEach items="${list_kind_cate }" var="list">
			<div class="cate-step-title">${list.title}</div>
			<div class="cate-step-content">
				<c:forEach items="${list.cates}" var="cate" varStatus="status">
					<div class="checkbox cate-check ">
						<label><input type="checkbox" name="recipeCate" value="${cate.id}-${list.kindId}">${cate.title}</label>
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
		searchMaterial();
		chooseMaterial();
		unChooseMaterial();
		removeTag();
	});
	
	function searchMaterial(){
		$("#txtMKeyWord").keyup(function(){
			var title = $("#txtMKeyWord").val();
			if(title === ""){
				title = " ";
			}
			$.ajax({
				type : "POST",
				data : title,
				url : "../material/search",
				success: function(response){
					 $(".child-content").remove();
					 $.each(response, function(index) {
				            var content = ' <div class="child-content " id="child'+ response[index].id +'">'
				            			+'<div>'
				            			+'<input type="checkbox" value="'+response[index].id+'" class="check-mater" name="materialIds"> '
				            			+'<img src="'+response[index].featureImage+'" class="mater-img imgMT'+ response[index].id +'"/>'
										+'</div>'
										+'<div class="clear"></div>'
										+'<span class="mater-name" id="materialid-'+response[index].id+'">'+response[index].materialName+'</span>'
										+'</div>';
				            $(".material-search-box").append(content);
				     });
				},
				error: function(){
					alert("error");
				}
			});
		});
	}
	
	function chooseMaterial() {
		$(document).on('click', 'input[type="checkbox"][name="materialIds"]' ,function() {
			if($(this).is(":checked")){
				var id = $(this).val();
		        var id2 =  "#materialid-"+id;
		        text = $(id2).text();
		        var content = '<button type="button" id="tagElement" data-id="'+id+'" class="tag2 btn btn-success" name="" value="1">'+text+'<span class="glyphicon glyphicon-tags title-material-tag"></span>'
		        +' <span id="'+id+'" class="removeTag-Class glyphicon glyphicon-remove" style="margin:0;padding:0;margin-left:3px;color:red; font-size:30px;"></span> </button>';
		        var check = true;
		        $('.tag2').each(function(){
					var id3 = $(this).data("id");
					if(id == id3){
						check = false;
					}
			   });
		        if(check){
		        	 $(".appendMaterial").append(content);
		        }
			} 
	    });
	}
	
	function unChooseMaterial(){
		$(document).on('change', 'input[type="checkbox"][name="materialIds"]' ,function() {
			var id2 = $(this).val();
			if (!$(this).is(":checked")){ 
				  $('.tag2').each(function(){
						var id = $(this).data("id");
						if(id == id2){
							$(this).remove();
							return;
						}
				   });
			 }
		});
	}
	
	function removeTag() {
		$(document).on('click', '.removeTag-Class' ,function() {
			var idFirst = $(this).attr("id");
			$("button[data-id='"+$(this).attr("id")+"']").remove();
			$('input[type="checkbox"][name="materialIds"]').each(function(){
				var id = $(this).val();
				if(id == idFirst){
					$(this).prop("checked",false);
					return;
				}
		   });
		});
	}
	
	function validateMaterialIds(){
		var result = false;
		$('.tag2').each(function(i){
			result = true;
	    });
		if(!result){
			alert("bạn cần chọn ít nhất 1 nguyên liệu.");
		}
		return result;
	}
	
	function validateVideoURL(){
		var prefix = "https://www.youtube.com/watch?v=";
		var prefixLength = prefix.length;
		if($("#videoField"). val().substring(0,prefixLength) !== prefix) {
			alert("Định dạng url video không chính xác, vui lòng nhập vào định dạng youtube video!");
			return false;
		}
		return true;
	}
	
	function getMaterial(){
		$("#submitMaterial").click(function(){
			$(".parent-pop").attr("style","display:none");
			var data = "";
			var dataIds = "";
			$('.tag2').each(function(i){
		          var id = $(this).data("id");
		          text = $(this).text();
		          data += text + "||";
		          dataIds += id + ",";
		     });
			$("#listMaterials").val(dataIds);
			var arr = data.split("||");
			$("#tagRecipeCate").empty();
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
	
	function submitStrigger() {
		$("#mainSubmit").click(function() {
			if(validateCheckBox() && validateVideoURL() && validateMaterialIds()) {
				$("#triggerSubmit").trigger("click");
			}
		});
	}
	
	function validateCheckBox() {
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
									+ '<textarea class="form-control baby-step-content" rows="5" name="stepText" required="required"></textarea>'
									+ '</div>'
									+ '<div class="clear"></div>'
									+ '<input type="file" id="upload-file-step'+nextNumber+'" name="stepImg" class="file-upload'+nextNumber+'" style="display:none;" multiple/>'
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