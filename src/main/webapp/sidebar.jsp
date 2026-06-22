<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Hệ thống quản lý trung tâm thể thao</title>
    <link rel="stylesheet" href="css/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
</head>
<body>
	<nav class="sidebar">
        <div class="logo-section">
            <a href="#" class="logo-text">Sporapp</a>
        </div>
        <ul class="sidebar-menu">
            <li><a href="HomeServlet"><i class="fa-solid fa-chart-line"></i> Thống kê</a></li>
            
            <c:if test="${sessionScope.account.roleId == 2 || sessionScope.account.roleId == 3}">
            	<li><a href="SportServlet"><i class="fa-solid fa-futbol"></i> Quản lý môn thể thao</a></li>
            </c:if>
            
            <c:if test="${sessionScope.account.roleId == 2 || sessionScope.account.roleId == 3}">
            	<li><a href="SportFieldServlet"><i class="fa-solid bi bi-cash-stack"></i> Quản lý sân thể thao</a></li>
            </c:if>
            
            <li><a href="ClassServlet"><i class="fa-solid fa-clipboard-list"></i> Quản lý lớp huấn luyện</a></li>
            
            <c:if test="${sessionScope.account.roleId == 2}">
            	<li><a href="RoleServlet"><i class="fa-solid bi bi-person-fill-gear"></i> Quản lý chức vụ</a></li>
            </c:if>
            
            <c:if test="${sessionScope.account.roleId == 2}">
            	<li><a href="StaffServlet"><i class="fa-solid fa-user-tie"></i> Quản lý nhân viên</a></li>
            </c:if>
        </ul>
    </nav>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
	    var currentUrl = window.location.pathname.split("/").pop();

	    var menuLinks = document.querySelectorAll('.sidebar-menu a');
	
	    menuLinks.forEach(function(link) {
	        var linkHref = link.getAttribute('href');
	        
	        if (linkHref === currentUrl) {
	            link.classList.add('active');
	        } else {
	            link.classList.remove('active');
	        }
	    });
	</script>
</body>
</html>