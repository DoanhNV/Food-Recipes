<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

	
			<div class="clear"></div>
			<div class="create-recipe-title">
				<h2>Tạo mới và chia sẻ công thức</h2>
			</div>
			<div class="clear"></div>
			<div class="create-recipe-title create-header">
				
			</div>
			<div class="create-recipe">
				<div class="create create-left">
					<div class="create-left-content">
						<form method="POST">
							<div class="recipe-create-title">Tên món ăn</div>
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
								<input type="text" class="form-control" placeholder="Nhập tên món ăn">
							</div>
							<div class="recipe-create-title">Ảnh đại diện</div>
							<input type="file" id="upload-file-profile" name="img" class="file-upload-profile" style="display:none;" />
							<button type="button" id="openfile" class="btn btn-upload" ><span class="glyphicon glyphicon-upload"></span>Upload</button>
							<div class="preview-recipe-profile" id="image-temp">
								<img src="" id="img-temp" style="width: 100%;height: 100%;" alt="preview Profile image"/>
							</div>
							<div class="clear"></div>
							<div class="recipe-create-title">Thời gian</div>
							<select class="form-control select" >
								<option>Giờ</option>
								<option>0 Giờ</option>
								<option>1 Giờ</option>
								<option>2 Giờ</option>
							</select>
							<select class="form-control select" >
								<option>Phút</option>
								<option>0 Phút</option>
								<option>1 Phút</option>
								<option>2 Phút</option>
							</select>
							<div class="clear"></div>
							<div class="recipe-create-title">Chi phí</div>
							<select class="form-control select cost-select" >
								<option>rẻ</option>
								<option>trung bình</option>
								<option>đắt</option>
							</select>
							<div class="clear"></div>
							<div class="recipe-create-title">Nguyên liệu</div>
							<div class="cate-step-content">
								<div class="checkbox cate-check ">
								  <label><input type="checkbox" value="">Option 1</label>
								</div>
								<div class="checkbox cate-check ">
								  <label><input type="checkbox" value="">Option 1</label>
								</div>
								<div class="checkbox cate-check ">
								  <label><input type="checkbox" value="">Option 1</label>
								</div>
								<div class="checkbox cate-check ">
								  <label><input type="checkbox" value="">Option 1</label>
								</div>
								<div class="checkbox cate-check ">
								  <label><input type="checkbox" value="">Option 1</label>
								</div>
								<div class="checkbox cate-check ">
								  <label><input type="checkbox" value="">Option 1</label>
								</div>
								<div class="checkbox cate-check ">
								  <label><input type="checkbox" value="">Option 1</label>
								</div>
								<div class="checkbox cate-check ">
								  <label><input type="checkbox" value="">Option 1</label>
								</div>
								<div class="clear"></div>
								<div class="checkbox cate-check ">
								  <label><input type="checkbox" value="">Option 1</label>
								</div>
								<div class="checkbox cate-check ">
								  <label><input type="checkbox" value="">Option 1</label>
								</div>
								<div class="checkbox cate-check ">
								  <label><input type="checkbox" value="">Option 1</label>
								</div>
								<div class="clear"></div>
								<div class="checkbox cate-check ">
								  <label><input type="checkbox" value="">Option 1</label>
								</div>
								<div class="checkbox cate-check ">
								  <label><input type="checkbox" value="">Option 1</label>
								</div>
								<div class="checkbox cate-check ">
								  <label><input type="checkbox" value="">Option 1</label>
								</div>
								<div class="clear"></div>
							</div>
							<div class="clear"></div>
							<div class="add-material" >
								<h4>Thêm nguyên liệu</h4>
								<div class="mater-left">
									<div class="material-add-title">Tên nguyên liệu</div>
									<input type="text" class="form-control" placeholder="nhập tên nguyên liệu"/>
								</div>
								<div class="mater-left mater-right">
									<input type="file" id="uploadfileMater" name="img" class="file-upload" style="display:none;" />
									<button type="button" id="openfileMater" class="btn btn-upload-mater" ><span class="glyphicon glyphicon-upload"></span>Upload</button>
									<div class="preview-recipe-mater" id="image-temp">
										<img src="" id="img-temp-mater" style="width: 100%;height: 100%;" alt="preview Profile image"/>
									</div>
								</div>
								<div class="clear"></div>
								<button type="button" class="btn btn-danger" >Thêm</button>
							</div>
						</form>
					</div>	
					<div class="clear"></div>
					<div class="recipe-create-title">Các bước thực hiện</div>
					<div class="create-left-content step-practise" id="step1">
						<div class="step-post step-element-number">
							<div class="number-title">1</div>
						</div>
						<div class="step-post step-element-content">
							<div class="form-group">
							  <textarea class="form-control baby-step-content" rows="5" ></textarea>
							</div>
							<div class="clear"></div>
							<input type="file" id="upload-file-step1" name="image-step1" class="file-upload1" style="display:none;" multiple/>
							<button type="button" class="btn upload-step" id="uploadStep1"><span class="glyphicon glyphicon-camera"></span></button>
							
							<!-- hidden -->
							<div class="preview-step-img " id="preview1">
								<div class="preview-step-img-element">
									<img src="" class="preview-element-img" id="img-preview1" />
								</div>
							</div>
						</div>
					</div>
					<div class="clear"></div>
					<div class="last-step add-step" id="addStep"><btn class="btn btn-success">Thêm bước thực hiện</btn></div>
					<button type="button" class="last-step btn btn-success btn-last">Hoàn thành</div>
				</div>
				<div class="create create-right">
					<div class="recipe-create-title">Phân loại</div>
					<div class="cate-step">
						<div class="cate-step-title">Công thức</div>
						<div class="cate-step-content">
							<div class="checkbox cate-check ">
							  <label><input type="checkbox" value="">Option 1</label>
							</div>
							<div class="checkbox cate-check ">
							  <label><input type="checkbox" value="">Option 1</label>
							</div>
							<div class="checkbox cate-check ">
							  <label><input type="checkbox" value="">Option 1</label>
							</div>
							<div class="clear"></div>
							<div class="checkbox cate-check ">
							  <label><input type="checkbox" value="">Option 1</label>
							</div>
							<div class="checkbox cate-check ">
							  <label><input type="checkbox" value="">Option 1</label>
							</div>
							<div class="checkbox cate-check ">
							  <label><input type="checkbox" value="">Option 1</label>
							</div>
							<div class="clear"></div>
						</div>
					</div>
				</div>
			</div>
			
			<script type="text/javascript">
				$(document).ready(function(){
					
					uploadProfileFile();
					uploadStepFile();
					addStep();
					uploadProfileMaterial();
					
				});
				
				function uploadProfileFile(){
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
				
				function uploadProfileMaterial(){
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
				
				function uploadStepFile(){
					var number = 0;
					var uploadId = "";
					
					$(document).on('click', '.upload-step' ,function() {
						var id = $(this).attr("id");
						number = id.substring(id.length-1,id.length);
						uploadId = "#upload-file-step"+number;
						$(".file-upload"+number).trigger('click');
						$(".file-upload"+number).change(function(){
							var filePaths = $("#upload-file-step"+number)[0].files;

							var filePath = $("#upload-file-step"+number)[0].files[0];
							var reader = new FileReader();
							reader.readAsDataURL(filePath);
							
							reader.onload = function(event) {
								$("#img-preview"+number).attr("src", reader.result);
								$("#preview"+number).attr("style", "display:block");
							};
						});
					});
				}
				
				function addStep(){
					
					$("#addStep").off("click").click(function(){
						var lastNumber = $(".step-practise").length;
						var nextNumber = lastNumber+1;
						var step = '<div class="create-left-content step-practise" id="step'+nextNumber+'">'
							+'<div class="step-post step-element-number">'
							+'<div class="number-title">'+nextNumber+'</div>'
							+'</div>'
							+'<div class="step-post step-element-content">'
							+'<div class="form-group">'
							+'<textarea class="form-control baby-step-content" rows="5" ></textarea>'
							+'</div>'
							+'<div class="clear"></div>'
							+'<input type="file" id="upload-file-step'+nextNumber+'" name="image-step'+nextNumber+'" class="file-upload'+nextNumber+'" style="display:none;" multiple/>'
							+'<button type="button" class="btn upload-step" id="uploadStep'+nextNumber+'"><span class="glyphicon glyphicon-camera"></span></button>'

							+'<div class="preview-step-img " id="preview'+nextNumber+'">'
							+'<div class="preview-step-img-element">'
							+'<img src="" class="preview-element-img" id="img-preview'+nextNumber+'" />'
							+'</div>'
							+'</div>'
							+'</div>'
							+'</div>';
						var script = '<>function uploadStepFile(){'
							+'var number = 0;'
							+'var uploadId = "";'
							+'$(".upload-step").off("click").click(function() {'
							+'var id = $(this).attr("id");'
							+'number = id.substring(id.length-1,id.length);'
							+'uploadId = "#upload-file-step"+number;'
							+'$(".file-upload"+number).trigger("click");'
							+'$(".file-upload"+number).change(function(){'
							+'var filePaths = $("#upload-file-step"+number)[0].files;'

							+'var filePath = $("#upload-file-step"+number)[0].files[0];'
							+'var reader = new FileReader();'
							+'reader.readAsDataURL(filePath);'
								
							+'reader.onload = function(event) {'
							+'$("#img-preview"+number).attr("src", reader.result);'
							+'$("#preview"+number).attr("style", "display:block");'
							+'};'
							+'});'
							+'});'
							+'}';
						var root = $("#step"+lastNumber);		
						root.after(step);
						var body = $("body");
						body.append(script);
					});
				}
				
			
			</script>
	
