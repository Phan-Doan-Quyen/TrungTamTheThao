<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập - Hệ thống quản lý trung tâm thể thao</title>
    <link rel="stylesheet" href="css/login.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/jpeg" href="images/login/logo.jpg">
</head>
<body>
    <div class="login-card">
        
        <div class="header">
		    <div class="branding">
		        <img src="images/login/logo.jpg" alt="Logo" class="logo">
		        <h2 class="system-name">HỆ THỐNG QUẢN LÝ<br>TRUNG TÂM THỂ THAO</h2>
		    </div>
		    <h3 class="login-title">Đăng nhập</h3>
		</div>

		<c:if test="${not empty error}">
		    <div class="alert-error">
		        <i class="fas fa-exclamation-triangle me-2"></i> <span>${error}</span>
		    </div>
		</c:if>

        <form action="LoginServlet" method="post">
            <div class="form-group">
                <label for="userName">Tài khoản</label>
                <input type="text" value="${cookie.cUser.value}" name="userName" class="form-control" placeholder="Nhập tên tài khoản" required>
            </div>

            <div class="form-group">
                <label for="passWord">Mật khẩu</label>
                <input type="password" value="${cookie.cPass.value}" name="passWord" class="form-control" placeholder="Nhập mật khẩu" autocomplete="new-password" required>
            </div>

            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="rememberMe" name="remember" 
       				${cookie.cRem != null ? 'checked' : ''}>
                <label for="remember">Lưu mật khẩu</label>
            </div>

            <button type="submit" class="btn-login">Đăng nhập</button>
        </form>
    </div>
</body>
</html>