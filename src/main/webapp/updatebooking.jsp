<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/jpeg" href="images/login/logo.jpg">
    <title>Hệ thống quản lý trung tâm thể thao</title>
    <link rel="stylesheet" href="css/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="sidebar.jsp" />

    <div class="main-wrapper">
        <jsp:include page="navbar.jsp" />

        <div class="content-body">
            <div class="content-card">
                <div class="page-header mb-4">
                    <span class="page-tab fw-bold"><i class="fas fa-plus-circle me-2"></i>CẬP NHẬT LỊCH ĐẶT SÂN</span>
                </div>

                <form action="UpdateBookingServlet" method="POST">
                    
                    <div class="row g-3">
                        <div class="col-md-6">
                            <label class="form-label fw-bold text-secondary small">Mã số</label>
                            <input type="text" name="bookingId" class="form-control" value="${booking.bookingId}" readonly style="background-color: #e9ecef;">
                        </div>

                        <div class="col-md-6">
                            <label class="form-label fw-bold text-secondary small">Lớp huấn luyện (Nếu có)</label>
                            <select name="classId" class="form-select">
                            	<option value="" disabled selected hidden style="color:gray">-- --</option>
                                <c:forEach items="${dataClass}" var="c">
                                    <option value="${c.classId}">${c.className}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="col-md-6">
                            <label class="form-label fw-bold text-secondary small">Sân thể thao</label>
                            <select name="sportFieldId" class="form-select" required>
                                <c:forEach items="${dataSportF}" var="s">
                                    <option value="${s.sportFieldId}" ${s.sportFieldId == booking.sportFieldId ? 'selected' : ''}>
                                        ${s.sportFieldName}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="col-md-6">
                            <label class="form-label fw-bold text-secondary small">Tên khách hàng</label>
                            <input type="text" name="customerName" class="form-control" value="${booking.customerName}" required>
                        </div>

                        <div class="col-md-6">
                            <label class="form-label fw-bold text-secondary small">Số điện thoại</label>
                            <input type="text" name="phone" class="form-control" value="${booking.phone}" required>
                        </div>

                        <div class="col-md-6">
                            <label class="form-label fw-bold text-secondary small">Ngày đặt</label>
                            <input type="date" name="createDate" class="form-control" 
                                   value="${booking.createDate}" readonly style="background-color: #e9ecef;">
                        </div>

                        <div class="col-md-6">
                            <label class="form-label fw-bold text-secondary small">Thời gian</label>
                            <input type="text" name="time" class="form-control" 
                                   value="${booking.time}" readonly style="background-color: #e9ecef;">
                        </div>

                        <div class="col-md-6">
                            <label class="form-label fw-bold text-secondary small">Phương thức thanh toán</label>
                            <select name="paymentMethod" class="form-select">
                            	<option value="" disabled hidden style="color:gray">-- --</option>
        
						        <option value="Tiền mặt" ${booking.paymentMethod == 'Tiền mặt' ? 'selected' : ''}>
						            Tiền mặt
						        </option>
						        
						        <option value="Chuyển khoản" ${booking.paymentMethod == 'Chuyển khoản' ? 'selected' : ''}>
						            Chuyển khoản
						        </option>
                            </select>
                        </div>

                        <div class="col-md-6">
                            <label class="form-label fw-bold text-secondary small">Số tiền (VNĐ)</label>
                            <input type="number" name="price" class="form-control" value="${booking.price}" required>
                        </div>

                        <div class="col-md-6">
                            <label class="form-label fw-bold text-secondary small">Trạng thái</label>
                            <select name="status" class="form-select">
                            	<option value="" disabled hidden style="color:gray">-- --</option>
        
						        <option value="Đã thanh toán" ${booking.status == 'Đã thanh toán' ? 'selected' : ''}>
						            Đã thanh toán
						        </option>
						        
						        <option value="Chưa thanh toán" ${booking.status == 'Chưa thanh toán' ? 'selected' : ''}>
						            Chưa thanh toán
						        </option>
                            </select>
                        </div>
                    </div>

                    <div class="mt-4 d-flex justify-content-end gap-2">
                        <a href="BookingServlet?id=${booking.sportFieldId}" class="btn btn-secondary">Hủy bỏ</a>
                        <button type="submit" class="btn btn-success fw-bold"><i class="fas fa-save me-2"></i>Lưu lại</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
    <script src="js/index.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>