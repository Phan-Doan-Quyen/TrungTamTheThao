<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/jpeg" href="images/login/logo.jpg">
	<title>Hệ thống quản lý trung tâm thể thao</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/table.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="sidebar.jsp" />

    <div class="main-wrapper">
        
        <jsp:include page="navbar.jsp" />

        <div class="content-body">
            
            <div class="content-card">
                
                <div class="page-header d-flex justify-content-between align-items-center">
                    <div>
                        <span class="page-tab"><i class="fas fa-list me-2"></i>QUẢN LÝ SÂN THỂ THAO</span>
                    </div>
                </div>

                <c:set var="isEdit" value="${not empty sportEdit}" />

				<div class="mb-5 mt-4">
				    <h5 class="fw-bold text-success mb-3">
				        <c:if test="${isEdit}"><i class="fas fa-edit"></i> CẬP NHẬT THÔNG TIN</c:if>
				        <c:if test="${!isEdit}"><i class="fas fa-plus-circle"></i> THÊM MỚI SÂN THỂ THAO</c:if>
				    </h5>
				    
				    <c:if test="${not empty error}">
					    <div class="alert alert-danger alert-dismissible fade show" role="alert">
					        <i class="fas fa-exclamation-triangle me-2"></i> <strong>Lỗi:</strong> ${error}
					        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					    </div>
					</c:if>
				    <form action="${isEdit ? 'UpdateSportFieldServlet' : 'AddSportFieldServlet'}" method="post">
				        
				        <div class="row g-3 align-items-end">
				            <div class="col-md-2">
				                <label class="form-label fw-bold text-secondary small">Mã số</label>
				                <input type="text" name="sportFieldId" class="form-control" 
				                       value="${sportEdit.sportFieldId}" 
				                       ${isEdit ? 'readonly style="background-color: #e9ecef;"' : ''} required>
				            </div>
				
				            <div class="col-md-2">
				                <label class="form-label fw-bold text-secondary small">Sân thể thao</label>
				                <input type="text" name="sportFieldName" class="form-control" 
				                       value="${sportEdit.sportFieldName}" required>
				            </div>
				            
				            <div class="col-md-2">
				                <label class="form-label fw-bold text-secondary small">Môn thể thao</label>
							    <select name="sportId" class="form-select">
							    	<option value="" disabled selected hidden style="color:gray">-- --</option>
							        <c:forEach items="${dataSport}" var="s">
							            <option value="${s.sportId}" ${s.sportId == sportEdit.sportId ? 'selected' : ''}>
							                ${s.sportName}
							            </option>
							        </c:forEach>
							    </select>
				            </div>
				            
				            <div class="col-md-2">
				                <label class="form-label fw-bold text-secondary small">Giá sân</label>
				                <input type="text" name="price" class="form-control" 
				                       value="${sportEdit.price}" required>
				            </div>
				            
				            <div class="col-md-2">
				                <label class="form-label fw-bold text-secondary small">Trạng thái</label>
				                <input type="text" name="status" class="form-control" 
				                       value="${sportEdit.status}" required>
				            </div>
				            
				            <div class="col-md-2">
				                <label class="form-label fw-bold text-secondary small">Hình ảnh</label>
				                <input type="text" name="image" class="form-control" 
				                       value="${sportEdit.image}" required>
				            </div>
				        </div>
				        <div class="row g-3 align-items-end" style="margin-top:10px">
				        	<div class="col-md-2 d-flex gap-1">
				                <c:choose>
				                    <c:when test="${isEdit}">
				                        <button type="submit" class="btn text-white w-100 fw-bold" 
				                                style="background-color: #006a4e; border-radius: 6px;">
				                            <i class="fas fa-save me-1"></i> Lưu lại
				                        </button>
				                        <a href="SportFieldServlet" class="btn btn-secondary" style="border-radius: 6px;">
				                            <i class="fas fa-times"></i>
				                        </a>
				                    </c:when>
				                    <c:otherwise>
				                        <button type="submit" class="btn text-white w-100 fw-bold" 
				                                style="background-color: #006a4e; border-radius: 6px;">
				                            <i class="fas fa-plus-circle me-1"></i> Thêm mới
				                        </button>
				                    </c:otherwise>
				                </c:choose>
				            </div>
				        </div>
				    </form>
				</div>

                <div class="table-responsive">
                    <table class="table table-hover table-bordered align-middle mb-0">
                        <thead>
                            <tr>
                                <th class="text-center">ID</th>
                            	<th>Hình ảnh</th>
	                            <th>Sân thể thao</th>
                                <th>Môn thể thao</th>
                                <th>Giá</th>
	                            <th>Trạng thái</th>
                                <th class="text-center">Hành động</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${dataSportF}" var="list">
                                <tr>
                                    <td>${list.sportFieldId}</td>
	                            	<td><img src="images/sportfield/${list.image}" class="field-img"></td>
                                    <td>${list.sportFieldName}</td>
                                    <td>
									    <c:forEach items="${dataSport}" var="s">
									        <c:if test="${s.sportId == list.sportId}"> 
									            ${s.sportName} </c:if>
									    </c:forEach>
									</td>
                                    <td>${list.price}</td>
                                    <td>${list.status}</td>
                                    <td class="text-center">
                                    	
									    <a href="BookingServlet?id=${list.sportFieldId}" class="action-btn btn-list" title="">
									        <i class="fa-solid fa-list-ul"></i> </a> 
									        
									    <a href="UpdateSportFieldServlet?id=${list.sportFieldId}" class="action-btn btn-edit" title="Sửa">
									        <i class="fas fa-pen"></i> </a> 
									    
									    <c:if test="${sessionScope.account.roleId == 2}">
									    	<a href="UpdateSportFieldServlet?id=${list.sportFieldId}')" class="action-btn btn-delete" title="Xóa">
									        	<i class="fas fa-trash"></i> </a>
									    </c:if>
									    
									</td>
                                </tr>
                            </c:forEach>
                            
                            <c:if test="${empty dataSportF}">
                                <tr>
                                    <td colspan="4" class="text-center py-4 text-muted">
                                        <i class="fas fa-inbox fa-2x mb-2"></i><br>
                                        Chưa có dữ liệu nào
                                    </td>
                                </tr>
                            </c:if>
                        </tbody>
                    </table>
                </div>

                <div class="d-flex justify-content-between align-items-center mt-3 border-top pt-3">
                    <div class="small text-muted">
                        Xem 10 mục
                    </div>
                    <nav>
                        <ul class="pagination pagination-sm mb-0">
                            <li class="page-item disabled"><a class="page-link" href="#">Trước</a></li>
                            <li class="page-item active"><a class="page-link" href="#" style="background-color: var(--primary-color); border-color: var(--primary-color);">1</a></li>
                            <li class="page-item"><a class="page-link text-secondary" href="#">2</a></li>
                            <li class="page-item"><a class="page-link text-secondary" href="#">Tiếp</a></li>
                        </ul>
                    </nav>
                </div>

            </div> </div> 
    </div>
	<script src="js/index.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">
		function doDelete(sportFieldId) {
			if (confirm("Bạn có chắc chắn xoá sân thể thao có id = " + sportFieldId)) {
			window.location = "DeleteSportFieldServlet?sportFieldId=" + sportFieldId;
			}
		}
	</script>
</body>
</html>