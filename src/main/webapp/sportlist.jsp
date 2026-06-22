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
                        <span class="page-tab"><i class="fas fa-list me-2"></i>QUẢN LÝ MÔN THỂ THAO</span>
                    </div>
                </div>

                <c:set var="isEdit" value="${not empty sportEdit}" />

				<div class="mb-5 mt-4">
				    <h5 class="fw-bold text-success mb-3">
				        <c:if test="${isEdit}"><i class="fas fa-edit"></i> CẬP NHẬT THÔNG TIN</c:if>
				        <c:if test="${!isEdit}"><i class="fas fa-plus-circle"></i> THÊM MỚI MÔN THỂ THAO</c:if>
				    </h5>
				    
				    <c:if test="${not empty error}">
					    <div class="alert alert-danger alert-dismissible fade show" role="alert">
					        <i class="fas fa-exclamation-triangle me-2"></i> <strong>Lỗi:</strong> ${error}
					        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					    </div>
					</c:if>
				    <form action="${isEdit ? 'UpdateSportServlet' : 'AddSportServlet'}" method="post">
				        
				        <div class="row g-3 align-items-end">
				            <div class="col-md-2">
				                <label class="form-label fw-bold text-secondary small">Mã số</label>
				                <input type="text" name="sportId" class="form-control" 
				                       value="${sportEdit.sportId}" 
				                       ${isEdit ? 'readonly style="background-color: #e9ecef;"' : ''} required>
				            </div>
				
				            <div class="col-md-3">
				                <label class="form-label fw-bold text-secondary small">Môn thể thao</label>
				                <input type="text" name="sportName" class="form-control" 
				                       value="${sportEdit.sportName}" required>
				            </div>
				
				            <div class="col-md-4">
				                <label class="form-label fw-bold text-secondary small">Mô tả</label>
				                <input type="text" name="description" class="form-control" 
				                       value="${sportEdit.description}">
				            </div>
				
				            <div class="col-md-3 d-flex gap-1">
				                <c:choose>
				                    <c:when test="${isEdit}">
				                        <button type="submit" class="btn text-white w-100 fw-bold" 
				                                style="background-color: #006a4e; border-radius: 6px;">
				                            <i class="fas fa-save me-1"></i> Lưu lại
				                        </button>
				                        <a href="SportServlet" class="btn btn-secondary" style="border-radius: 6px;">
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
                                <th class="text-center" style="width: 100px;">ID</th>
                                <th style="width: 25%;">Môn thể thao</th>
                                <th>Mô tả</th>
                                <th class="text-center" style="width: 150px;">Hành động</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${dataSport}" var="list">
                                <tr>
                                    <td class="text-center fw-bold text-secondary">${list.sportId}</td>
                                    <td class="fw-bold" style="color: var(--primary-color);">${list.sportName}</td>
                                    <td class="text-muted small">${list.description}</td>
                                    <td class="text-center">
									    <a href="UpdateSportServlet?id=${list.sportId}" class="action-btn btn-edit" title="Sửa">
									        <i class="fas fa-pen"></i> </a> 
									    <c:if test="${sessionScope.account.roleId == 2}">
									    	<a href="#" onclick="doDelete('${list.sportId}')" class="action-btn btn-delete" title="Xóa">
									        	<i class="fas fa-trash"></i> </a>
									    </c:if>
									    
									</td>
                                </tr>
                            </c:forEach>
                            
                            <c:if test="${empty dataSport}">
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
		function doDelete(sportId) {
			if (confirm("Bạn có chắc chắn xoá môn thể thao có id = " + sportId)) {
			window.location = "DeleteSportServlet?sportId=" + sportId;
			}
		}
	</script>
</body>
</html>