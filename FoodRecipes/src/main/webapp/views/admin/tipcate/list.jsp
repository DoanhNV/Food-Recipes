<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
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

.pagination a:hover:not(.active) {background-color: #ddd;}
</style> 
<script src="<%=request.getContextPath()%>/resources/asset/js/jquery-3.2.1.min.js"></script>	
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Table design <small>Tất cả  mẹo vặt</small></h2>
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

                    <p>Add class <code>bulk_action</code> to table for bulk actions options on row select</p>

                    <div class="table-responsive">
                      <table class="table table-striped jambo_table bulk_action">
                        <thead>
                          <tr class="headings">
                            <th class="column-title">Tên Danh mục</th>
                             <th class="column-title">Số mẹo vặt</th>
                            <th class="column-title">Ngày tạo</th>
                            <th class="column-title">Trạng thái </th>
                            <th class="column-title">Cập nhật </th>
                          </tr>
                        </thead>

                        <tbody>
                        	<c:forEach items="${list_tipcate}" var="tipcate">
	                        	<tr class="even pointer">
		                            <td class=" ">${tipcate.title}</td>
		                             <td class=" ">${tipcate.numberOfTips}</td>
		                            <td class=" ">${tipcate.createTime}</td>
		                            <td class=" ">${tipcate.status}</td>
		                             <td class=" "> 
		                              <span class="fa fa-pencil-square-o btn btn-primary btnUpdateM" data-id="${tipcate.id}"></span>
		                             <span class="fa fa-refresh btn btn-success btnChangeStatus" data-id="${tipcate.id}" data-status="${tipcate.status}"></span>
		                             <span class="fa fa-remove btn btn-danger btnDelete" data-id="${tipcate.id}"></span>
		                             </td>
                          		</tr>
                        	</c:forEach>
                        </tbody>
                      </table>
                    </div>
                    <div class="bound-page">
	                    <div class="pagination">
	                    	<a href="../tipcate/list?page=${first}">&laquo;</a>
	                     	<c:forEach items="${materialpages}" var="page">
	                     		 <c:choose>
			                      	<c:when test="${page != '...' && page == currentpage}">
			                      		<a href="../tipcate/list?page=${page}" id="pageActive" class="active" data-id="${page}">${page}</a>
			                      	</c:when>
			                      	<c:when  test="${page == '...'}">
			                      		<a>${page}</a>
			                      	</c:when>
			                      	<c:otherwise>
			                      		<a href="../tipcate/list?page=${page}">${page}</a>
			                      	</c:otherwise>
			                     </c:choose>
	                     	</c:forEach>
						  <a href="../tipcate/list?page=${last}">&raquo;</a>
						</div>
                    </div>
                  </div>
                </div>
              </div>
              <form id="submitForm" method="post"></form>
              <a href="" id="update"></a>
<script type="text/javascript">
	$(document).ready(function(){
		deleteUser();
		changeStatus();
		update();
	});
	
	function deleteUser(){
		$(".btnDelete").off("click").click(function(){
			var isAgree = confirm("Bạn thực sự muốn xóa nguyên liệu này?");
			if(isAgree){
				window.location.href = "../tipcate/delete?id="+$(this).data("id");
			}
		});
	}
	
	function changeStatus(){
		$(".btnChangeStatus").off("click").click(function(){
			var page = $("#pageActive").data("id");
			window.location.href = "../tipcate/change-status?tip-data="+$(this).data("id")+"-"+$(this).data("status")+"-"+page;
		});
	}
	
	function update(){
		$(".btnUpdateM").off().off("click").click(function(){
			window.location.href = "../tipcate/update?id="+$(this).data("id");
		});
	}
	
	
	function submit(url,userid){
		$("#submitForm").attr("action",".."+url);
		var input = $("<input>")
        .attr("type", "hidden")
        .attr("name", "materialid").val(userid);
		$('#submitForm').append($(input));
		$("#submitForm").submit();
	}
	
	
</script>
