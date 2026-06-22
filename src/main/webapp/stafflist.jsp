<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Hệ thống quản lý trung tâm thể thao</title>
    <link rel="icon" type="image/jpeg" href="images/login/logo.jpg">
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
                        <span class="page-tab"><i class="fas fa-list me-2"></i>QUẢN LÝ NHÂN VIÊN</span>
                    </div>
                </div>

                <c:set var="isEdit" value="${not empty staffEdit}" />

				<div class="mb-5 mt-4">
				    <h5 class="fw-bold text-success mb-3">
				        <c:if test="${isEdit}"><i class="fas fa-edit"></i> CẬP NHẬT THÔNG TIN</c:if>
				        <c:if test="${!isEdit}"><i class="fas fa-plus-circle"></i> THÊM TÀI KHOẢN NHÂN VIÊN</c:if>
				    </h5>
				    
				    <c:if test="${not empty error}">
					    <div class="alert alert-danger alert-dismissible fade show" role="alert">
					        <i class="fas fa-exclamation-triangle me-2"></i> <strong>Lỗi:</strong> ${error}
					        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					    </div>
					</c:if>
				    <form action="${isEdit ? 'UpdateStaffServlet' : 'AddStaffServlet'}" method="post">
				        
				        <div class="row g-3 align-items-end">
				            <div class="col-md-2">
				                <label class="form-label fw-bold text-secondary small">Mã nhân viên</label>
				                <input type="text" name="staffId" class="form-control" 
				                       value="${staffEdit.staffId}" 
				                       ${isEdit ? 'readonly style="background-color: #e9ecef;"' : ''} required>
				            </div>
				
				            <div class="col-md-3">
				                <label class="form-label fw-bold text-secondary small">Tên tài khoản</label>
				                <input type="text" name="userName" class="form-control" 
				                       value="${staffEdit.userName}" required>
				            </div>
				
				            <div class="col-md-2">
				                <label class="form-label fw-bold text-secondary small">Mật khẩu</label>
				                <input type="text" name="passWord" class="form-control" 
				                       value="${staffEdit.passWord}" required>
				            </div>
				            
				            <div class="col-md-2">
				                <label class="form-label fw-bold text-secondary small">Chức vụ</label>
							    <select name="roleId" class="form-select">
							    	<option value="" disabled selected hidden style="color:gray">-- --</option>
							        <c:forEach items="${dataRole}" var="s">
							            <option value="${s.roleId}" ${s.roleId == staffEdit.roleId ? 'selected' : ''}>
							                ${s.role}
							            </option>
							        </c:forEach>
							    </select>
				            </div>
				            
				            <div class="col-md-3 d-flex gap-1">
				                <c:choose>
				                    <c:when test="${isEdit}">
				                        <button type="submit" class="btn text-white w-100 fw-bold" 
				                                style="background-color: #006a4e; border-radius: 6px;">
				                            <i class="fas fa-save me-1"></i> Lưu lại
				                        </button>
				                        <a href="StaffServlet" class="btn btn-secondary" style="border-radius: 6px;">
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
                            	<th>Họ tên</th>
	                            <th>Tên tài khoản</th>
                                <th>Mật khẩu</th>
                                <th>Ngày sinh</th>
	                            <th>Giới tính</th>
                            	<th>Số điện thoại</th>
	                            <th>Email</th>
                                <th>Địa chỉ</th>
                                <th>Chức vụ</th>
                                <th class="text-center">Hành động</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${dataStaff}" var="list">
                                <tr>
                                    <td>${list.staffId}</td>
                                    <td>${list.fullName}</td>
                                    <td>${list.userName}</td>
                                    <td>${list.passWord}</td>
                                    <td>${list.birthday}</td>
                                    <td>${list.gender}</td>
                                    <td>${list.phone}</td>
                                    <td>${list.email}</td>
                                    <td>${list.address}</td>
                                    <td>
									    <c:forEach items="${dataRole}" var="s">
									        <c:if test="${s.roleId == list.roleId}"> 
									            ${s.role} </c:if>
									    </c:forEach>
									</td>
                                    <td class="text-center">
									    <a href="UpdateStaffServlet?id=${list.staffId}" class="action-btn btn-edit" title="Sửa">
									        <i class="fas fa-pen"></i> </a> 
									    
									    <a href="#" onclick="doDelete('${list.staffId}')" class="action-btn btn-delete" title="Xóa">
									        <i class="fas fa-trash"></i> </a>
									</td>
                                </tr>
                            </c:forEach>
                            
                            <c:if test="${empty dataStaff}">
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
		function doDelete(id) {
			if (confirm("Bạn có chắc chắn xoá nhân có id = " + id)) {
			window.location = "DeleteStaffServlet?staffId=" + id;
			}
		}
	</script>
</body>
</html>