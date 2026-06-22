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
                        <span class="page-tab"><i class="fas fa-list me-2"></i>Quản lý chức vụ</span>
                    </div>
                    
                    <div style="margin-bottom: 10px">
				        <a href="AddRoleServlet" class="btn text-white fw-bold" style="background-color: #006a4e; border-radius: 6px;">
				            <i class="fas fa-plus me-1"></i> Thêm chức vụ
				        </a>
				    </div>
                </div>

                <div class="table-responsive">
                    <table class="table table-hover table-bordered align-middle mb-0">
                        <thead>
                            <tr>
                                <th class="text-center" style="width: 100px;">ID</th>
                                <th style="width: 40%;">Chức vụ</th>
                                <th class="text-center" style="width: 150px;">Hành động</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${dataRole}" var="list">
                                <tr>
                                    <td class="text-center fw-bold text-secondary">${list.roleId}</td>
                                    <td class="fw-bold" style="color: var(--primary-color);">${list.role}</td>
                                    <td class="text-center">
									    <a href="UpdateRoleServlet?id=${list.roleId}" class="action-btn btn-edit" title="Sửa">
									        <i class="fas fa-pen"></i> </a> 
									    
									    <a href="#" onclick="doDelete('${list.roleId}')" class="action-btn btn-delete" title="Xóa">
									        <i class="fas fa-trash"></i> </a>
									</td>
                                </tr>
                            </c:forEach>
                            
                            <c:if test="${empty dataRole}">
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
		function doDelete(roleId) {
			if (confirm("Bạn có chắc chắn xoá môn thể thao có id = " + roleId)) {
			window.location = "DeleteSportServlet?roleId=" + roleId;
			}
		}
	</script>
</body>
</html>