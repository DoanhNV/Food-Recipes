 <%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<style>
	.checkBox-admin-cate{
		float:left !important;
		margin-left: 5px;
	}
	#cke_1_contents{
		height: 600px !important; 
	}
	.required{
		color:red !important;
	}
	.control-label{
		text-align: left !important;
	}
</style>      
            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Form Design <small>Danh mục mẹo vặt</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Settings 1</a>
                          </li>
                          <li><a href="#">Settings 2</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <br />
                    <form id="demo-form2" action="../tip/doCreate" method="post" modelAttribute="tip" enctype="multipart/form-data" data-parsley-validate class="form-horizontal form-label-left">
                      <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-12" for="first-name">Tiêu đề mẹo vặt<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" name="title" id="first-name" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-12" for="first-name">Tên danh mục<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                         	<c:forEach items="${tipcate}" var="cate"  varStatus="status">
                         	  	<div class="checkbox checkBox-admin-cate">
                         	  	 	<label><input type="checkbox" name="cateids"  value="${cate.id}">${cate.cateName}</label>
                         	  	</div>
                         	  	<c:if test="${(status.index+1) % 3 == 0}">
                         	  		<div style="clear:both;"></div>
                         	  	</c:if>
                         	</c:forEach>
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-12" for="first-name">Ảnh đại diện<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="file" name="profileImage" id="first-name" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                       <div class="form-group">  <label class="control-label col-md-2 col-sm-2 col-xs-12" for="first-name">Nội dung<span class="required">*</span></label></div>
                       <div class="form-group">
                       		<textarea rows="" class="ckeditor"  name="editor1"  cols=""></textarea>
			           </div>
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
						  <button class="btn btn-primary" type="reset">Reset</button>
                          <button type="submit" class="btn btn-success">Tạo mới</button>
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/ckeditor/ckeditor.js" ></script>
<script src="<%=request.getContextPath()%>/resources/ckfinder/ckfinder.js" type="text/javascript"></script>
<script type="text/javascript">
  	var editor = CKEDITOR.replace( 'editor1');
  	CKFinder.setupCKEditor( editor, '../resources/ckfinder/' );
</script>
