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
                        <span class="page-tab"><i class="fas fa-users me-2"></i>QUẢN LÝ HỌC VIÊN</span>
                    </div>
                </div>

                <c:set var="isEdit" value="${not empty hocVienEdit}" />

                <div class="mb-5 mt-4">
                    <h5 class="fw-bold text-success mb-3">
                        <c:if test="${isEdit}"><i class="fas fa-edit"></i> CẬP NHẬT THÔNG TIN HỌC VIÊN</c:if>
                        <c:if test="${!isEdit}"><i class="fas fa-plus-circle"></i> THÊM MỚI HỌC VIÊN</c:if>
                    </h5>
                    
                    <c:if test="${not empty error}">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            <i class="fas fa-exclamation-triangle me-2"></i> <strong>Lỗi:</strong> ${error}
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                    </c:if>

                    <form action="${isEdit ? 'UpdateHocVienServlet' : 'AddHocVienServlet'}" method="post">
                        
                        <div class="row g-3 align-items-end">
                            <div class="col-md-1">
                                <label class="form-label fw-bold text-secondary small">Mã HV</label>
                                <input type="number" name="MaHocVien" class="form-control" 
                                       value="${hocVienEdit.maHocVien}" 
                                       ${isEdit ? 'readonly style="background-color: #e9ecef;"' : ''} required placeholder="Nhập số">
                            </div>
                            
                            <div class="col-md-2">
                                <label class="form-label fw-bold text-secondary small">Mã Lớp HL</label>
                                <input type="number" name="MaLopHuanLuyen" class="form-control" 
                                       value="${hocVienEdit.classId}" required placeholder="Nhập số">
                            </div>
                            
                            <div class="col-md-3">
                                <label class="form-label fw-bold text-secondary small">Tên Học Viên</label>
                                <input type="text" name="TenHocVien" class="form-control" 
                                       value="${hocVienEdit.tenHocVien}" required>
                            </div>
                            
                            <div class="col-md-2">
                                <label class="form-label fw-bold text-secondary small">Ngày Sinh</label>
                                <input type="date" name="NgaySinh" class="form-control" 
                                       value="${hocVienEdit.ngaySinh}">
                            </div>
                            
                            <div class="col-md-2">
                                <label class="form-label fw-bold text-secondary small">Giới tính</label>
                                <select name="GioiTinh" class="form-select">
                                    <option value="" disabled selected hidden>-- Chọn --</option>
                                    <option value="Nam" ${hocVienEdit.gioiTinh == 'Nam' ? 'selected' : ''}>Nam</option>
                                    <option value="Nữ" ${hocVienEdit.gioiTinh == 'Nữ' ? 'selected' : ''}>Nữ</option>
                                    <option value="Khác" ${hocVienEdit.gioiTinh == 'Khác' ? 'selected' : ''}>Khác</option>
                                </select>
                            </div>
                            
                            <div class="col-md-2 d-flex gap-1" style="margin-top: 15px;">
                                <c:choose>
                                    <c:when test="${isEdit}">
                                        <button type="submit" class="btn text-white w-100 fw-bold" 
                                                style="background-color: #006a4e; border-radius: 6px;">
                                            <i class="fas fa-save me-1"></i> Lưu lại
                                        </button>
                                        <a href="HocVienServlet" class="btn btn-secondary" style="border-radius: 6px;">
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
                            <tr class="bg-light">
                                <th class="text-center">Mã HV</th>
                                <th>Mã Lớp</th>
                                <th>Tên Học Viên</th>
                                <th>Ngày Sinh</th>
                                <th>Giới Tính</th>
                                <th class="text-center">Hành động</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${dataHocVien}" var="h">
                                <tr>
                                    <td class="text-center fw-bold text-secondary">${h.maHocVien}</td>
                                    <td>${h.classId}</td>
                                    <td class="fw-bold">${h.tenHocVien}</td>
                                    <td>${h.ngaySinh}</td>
                                    <td>
                                        <span class="badge ${h.gioiTinh == 'Nam' ? 'bg-primary' : (h.gioiTinh == 'Nữ' ? 'bg-danger' : 'bg-secondary')} bg-opacity-75">
                                            ${h.gioiTinh}
                                        </span>
                                    </td>
                                    <td class="text-center">
                                        <a href="UpdateHocVienServlet?MaHocVien=${h.maHocVien}" class="btn btn-sm btn-outline-primary" title="Sửa">
                                            <i class="fas fa-pen"></i>
                                        </a> 
                                        
                                        <a href="#" onclick="doDelete('${h.maHocVien}')" class="btn btn-sm btn-outline-danger" title="Xóa">
                                            <i class="fas fa-trash"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            
                            <c:if test="${empty dataHocVien}">
                                <tr>
                                    <td colspan="7" class="text-center py-4 text-muted">
                                        <i class="fas fa-inbox fa-2x mb-2"></i><br>
                                        Chưa có dữ liệu học viên
                                    </td>
                                </tr>
                            </c:if>
                        </tbody>
                    </table>
                </div>

                <div class="d-flex justify-content-between align-items-center mt-3 border-top pt-3">
                    <div class="small text-muted">
                        Đang hiển thị danh sách
                    </div>
                    <nav>
                        <ul class="pagination pagination-sm mb-0">
                            <li class="page-item disabled"><a class="page-link" href="#">Trước</a></li>
                            <li class="page-item active"><a class="page-link" href="#" style="background-color: var(--primary-color); border-color: var(--primary-color);">1</a></li>
                            <li class="page-item"><a class="page-link text-secondary" href="#">Tiếp</a></li>
                        </ul>
                    </nav>
                </div>

            </div> 
        </div> 
    </div>

    <script src="js/index.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript">
        function doDelete(maHocVien) {
            if (confirm("Bạn có chắc chắn muốn xóa học viên có Mã = " + maHocVien + " không?")) {
                window.location = "DeleteHocVienServlet?maHocVien=" + maHocVien;
            }
        }
    </script>
</body>
</html>