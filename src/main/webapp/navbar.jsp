<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Hệ thống quản lý trung tâm thể thao</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/index.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
</head>
<body>
       <header class="top-navbar">
           <div class="d-flex align-items-center gap-3">
               <i class="fa-solid fa-bars fa-lg cursor-pointer" id="sidebarToggle"></i>
           </div>

           <div class="user-info">
               <div class="notification-icon">
                   <i class="fa-regular fa-bell fa-lg"></i>
                   <span class="badge-count">6</span>
               </div>
               
               <div class="dropdown">
                <div class="user-profile d-flex align-items-center gap-2" id="userDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                    <div class="avatar">
                        <%-- Logic: Nếu có đường dẫn ảnh -> Hiện ảnh. Nếu chưa có -> Hiện icon mặc định --%>
					    <c:choose>
					        <c:when test="${not empty sessionScope.account.avatar}">
					            <img src="${sessionScope.account.avatar}" alt="User" 
					                 style="width: 100%; height: 100%; object-fit: cover; border-radius: 50%;">
					        </c:when>
					        <c:otherwise>
					            <i class="fa-solid fa-user"></i>
					        </c:otherwise>
					    </c:choose>
                    </div>
                    <div class="d-flex flex-column text-end" style="line-height: 1.2;">
                        <span class="fw-bold" style="font-size: 14px;">
					        ${sessionScope.account.fullName != null ? sessionScope.account.fullName : 'Khách'}
					    </span>
                        <span style="font-size: 12px; opacity: 0.8;">
					        <c:forEach items="${sessionScope.dataRole}" var="s">
						        <c:if test="${s.roleId == sessionScope.account.roleId}">
						            ${s.role}
						        </c:if>
						    </c:forEach>
					    </span>
                    </div>
                    <i class="fa-solid fa-chevron-down fa-xs ms-1"></i>
                </div>

                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
                    <li>
                        <a class="dropdown-item info-btn" href="profile.jsp">
                            <i class="fa-regular fa-user"></i>
                            Thông tin cá nhân
                        </a>
                    </li>
                    
                    <li><hr class="dropdown-divider"></li>
                    
                    <li>
                        <a class="dropdown-item logout-btn" href="LogoutServlet">
                            <i class="fa-solid fa-arrow-right-from-bracket"></i>
                            Đăng xuất
                        </a>
                    </li>
                </ul>
            </div>
           </div>
       </header>
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>