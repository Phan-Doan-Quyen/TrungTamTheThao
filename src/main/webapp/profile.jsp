<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><title>Thông tin cá nhân - Sporapp</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/profile.css">
<link rel="icon" type="image/jpeg" href="images/login/logo.jpg">
</head>
<body>
	<jsp:include page="sidebar.jsp" />

    <div class="main-wrapper">
        <jsp:include page="navbar.jsp" />

        <div class="content-body">
            
            <div class="content-card p-0">
                <div class="profile-header">
                    <div class="profile-avatar-wrapper">
                        <img src="${empty sessionScope.account.avatar ? 'https://cdn-icons-png.flaticon.com/512/3135/3135715.png' : sessionScope.account.avatar}" 
                             alt="Avatar" class="profile-img">
                        <div class="profile-name">
                            ${sessionScope.account.fullName}
                            <div class="small fw-normal opacity-75" style="font-size: 14px;">Chỉnh sửa hồ sơ</div>
                        </div>
                    </div>
                </div>

                <div class="p-4 pt-5 mt-2">
                    <c:if test="${not empty message}">
                        <div class="alert alert-success alert-dismissible fade show">
                            ${message}
                            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                        </div>
                    </c:if>
                    <c:if test="${not empty error}">
                        <div class="alert alert-danger alert-dismissible fade show">
                            ${error}
                            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                        </div>
                    </c:if>

                    <ul class="nav nav-tabs mb-4" id="profileTabs" role="tablist">
                        <li class="nav-item">
                            <button class="nav-link active" id="info-tab" data-bs-toggle="tab" data-bs-target="#info" type="button">
                                <i class="far fa-id-card me-2"></i>Hồ sơ
                            </button>
                        </li>
                        <li class="nav-item">
                            <button class="nav-link" id="password-tab" data-bs-toggle="tab" data-bs-target="#password" type="button">
                                <i class="fas fa-key me-2"></i>Mật khẩu
                            </button>
                        </li>
                    </ul>

                    <div class="tab-content" id="profileTabsContent">
                        
                        <div class="tab-pane fade show active" id="info">
                            <form action="UpdateProfileServlet" method="post" enctype="multipart/form-data">
                                <div class="row g-3">
                                    <div class="col-md-6">
                                        <label class="form-label fw-bold small text-secondary">Mã nhân viên</label>
                                        <input type="text" class="form-control" value="${sessionScope.account.staffId}" disabled readonly style="background-color: #e9ecef;">
                                    </div>
                                    <div class="col-md-6">
                                        <label class="form-label fw-bold small text-secondary">Họ và tên</label>
                                        <input type="text" name="fullName" class="form-control" value="${sessionScope.account.fullName}" required>
                                    </div>
                                    
                                    <div class="col-md-6">
                                        <label class="form-label fw-bold small text-secondary">Email</label>
                                        <input type="email" name="email" class="form-control" value="${sessionScope.account.email}">
                                    </div>
                                    <div class="col-md-6">
                                        <label class="form-label fw-bold small text-secondary">Số điện thoại</label>
                                        <input type="text" name="phone" class="form-control" value="${sessionScope.account.phone}">
                                    </div>

                                    <div class="col-md-6">
                                        <label class="form-label fw-bold small text-secondary">Ngày sinh</label>
                                        <input type="date" name="birthday" class="form-control" value="${sessionScope.account.birthday}">
                                    </div>
                                    
                                    <div class="col-md-6">
                                        <label class="form-label fw-bold small text-secondary">Giới tính</label>
                                        <div class="mt-2">
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="gender" value="Nam" 
                                                    ${sessionScope.account.gender == 'Nam' ? 'checked' : ''}>
                                                <label class="form-check-label">Nam</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="gender" value="Nữ"
                                                    ${sessionScope.account.gender == 'Nữ' ? 'checked' : ''}>
                                                <label class="form-check-label">Nữ</label>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="col-12">
                                        <label class="form-label fw-bold small text-secondary">Địa chỉ</label>
                                        <input type="text" name="address" class="form-control" value="${sessionScope.account.address}">
                                    </div>
                                    
                                    <div class="col-12 mt-3">
								        <label class="form-label fw-bold small text-secondary">Ảnh đại diện</label>
								        <div class="d-flex align-items-center gap-3">
								            <img src="${empty sessionScope.account.avatar ? 'images/default-user.png' : sessionScope.account.avatar}" 
								                 id="avatarPreview" alt="Avatar" style="width: 60px; height: 60px; border-radius: 50%; object-fit: cover; border: 1px solid #ddd;">
								            
								            <div class="w-100">
								                <input type="file" name="avatarFile" class="form-control" accept="image/*" onchange="previewImage(this)">
								                <div class="form-text small">Chấp nhận file ảnh: .jpg, .png, .jpeg</div>
								            </div>
								        </div>
								    </div>

                                    <div class="col-12 mt-4">
                                        <button type="submit" class="btn text-white fw-bold" style="background-color: #006a4e;">
                                            <i class="fas fa-save me-1"></i> Cập nhật hồ sơ
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>

                        <div class="tab-pane fade" id="password">
                            <form action="ChangePasswordServlet" method="post" >
                                <div class="row g-3">
                                    <div class="col-md-12">
                                        <label class="form-label fw-bold small text-secondary">Mật khẩu hiện tại</label>
                                        <input type="password" name="currentPass" class="form-control" required>
                                    </div>
                                    <div class="col-md-6">
                                        <label class="form-label fw-bold small text-secondary">Mật khẩu mới</label>
                                        <input type="password" name="newPass" class="form-control" required>
                                    </div>
                                    <div class="col-md-6">
                                        <label class="form-label fw-bold small text-secondary">Xác nhận mật khẩu mới</label>
                                        <input type="password" name="confirmPass" class="form-control" required>
                                    </div>
                                    <div class="col-12 mt-4">
                                        <button type="submit" class="btn fw-bold text-white" style="background-color: #006a4e;">
                                            Đổi mật khẩu
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </div>

        </div> 
    </div>
    
    <script src="js/index.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript">
	    function previewImage(input) {
	        // Kiểm tra xem người dùng đã chọn file chưa
	        if (input.files && input.files[0]) {
	            var reader = new FileReader();
	
	            reader.onload = function(e) {
	                // Gán đường dẫn ảnh mới vào thẻ img có id="avatarPreview"
	                document.getElementById('avatarPreview').src = e.target.result;
	            }
	
	            // Đọc file ảnh dưới dạng URL
	            reader.readAsDataURL(input.files[0]);
	        }
	    }
	</script>
	<script>
	    <% if (request.getAttribute("activeTab") != null || request.getParameter("tab") == "password") { %>
	        var triggerEl = document.querySelector('#password-tab');
	        var tab = new bootstrap.Tab(triggerEl);
	        tab.show();
	    <% } %>
	</script>
</body>
</html>