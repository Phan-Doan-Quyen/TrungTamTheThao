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
                        <span class="page-tab"><i class="fas fa-list me-2"></i>QUẢN LÝ LỊCH ĐẶT SÂN</span>
                    </div>
                </div>

				<div class="d-flex justify-content-between align-items-center mb-4 mt-4 bg-white p-3 rounded shadow-sm border">
    
				    <h4 class="fw-bold text-success m-0">
				        <c:forEach items="${dataSportF}" var="sf">
				            <c:if test="${sf.sportFieldId == param.id}">
				                ${sf.sportFieldName}
				            </c:if>
				        </c:forEach>
				    </h4>
				
				    <form action="BookingServlet" method="GET" class="d-flex align-items-center">
				        <input type="hidden" name="id" value="${param.id}">
				        
				        <div class="input-group">
				            <span class="input-group-text bg-white text-success border-end-0"></span>
				            <input type="date" name="viewDate" class="form-control border-start-0 fw-bold text-secondary" 
				                   value="${viewDate}" 
				                   onchange="this.form.submit()" 
				                   style="cursor: pointer;">
				        </div>
				    </form>
				
				</div>

                <div class="table-responsive">
                    <table class="table table-hover table-bordered align-middle mb-0">
                        <thead>
                            <tr>
                            	<th class="text-center">Khung giờ</th>
	                            <th class="text-center">Thông tin đặt sân</th>
                                <th class="text-center" style="width:10%">Hành động</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="i" begin="5" end="21">
						        <c:set var="startH" value="${i < 10 ? '0' : ''}${i}" />
						        <c:set var="endH" value="${i+1 < 10 ? '0' : ''}${i+1}" />
						        <c:set var="timeSlot" value="${startH}:00 - ${endH}:00" />
						        
						        <c:set var="isBooked" value="false" />
						        <c:set var="currentBooking" value="" />
						
						        <c:forEach items="${dataBooking}" var="b">
								    <c:if test="${b.time eq timeSlot && b.sportFieldId == param.id && b.createDate eq viewDate}">
								        <c:set var="isBooked" value="true" />
								        <c:set var="currentBooking" value="${b}" />
								    </c:if>
								</c:forEach>
						
						        <tr>
						            <td class="text-center align-middle text-muted fw-bold" style="width: 150px;">
						                ${timeSlot}
						            </td>
						
						            <td class="align-middle">
									    <c:choose>
									        <c:when test="${isBooked}">
									            
									            <div class="d-flex align-items-center justify-content-center">
									                
									                <i class="far fa-user-circle fa-2x text-success me-3"></i>
									                
									                <div class="text-start">
									                    <div class="fw-bold text-dark text-uppercase">
									                        ${currentBooking.customerName}
									                    </div>
									                    
									                    <div class="small text-muted mb-1">
									                        <i class="fas fa-phone-alt me-1"></i>${currentBooking.phone}
									                    </div>
									                    
									                    <c:choose>
									                        <c:when test="${currentBooking.status eq 'Đã thanh toán'}">
									                            <div class="badge bg-success bg-opacity-10 text-success border border-success fw-normal">
									                                <i class="fas fa-check-circle"></i> ${currentBooking.price} đ (Đã thanh toán)
									                            </div>
									                        </c:when>
									                        <c:otherwise>
									                            <div class="badge bg-warning bg-opacity-10 text-dark border border-warning fw-normal">
									                                <i class="fas fa-clock"></i> ${currentBooking.price} đ (Chưa thanh toán)
									                            </div>
									                        </c:otherwise>
									                    </c:choose>
									                </div>
									            </div>
									
									        </c:when>
									        <c:otherwise>
									            </c:otherwise>
									    </c:choose>
									</td>
						
						            <td class="text-center align-middle">
						                <c:choose>
						                    <c:when test="${isBooked}">
						                        <div class="d-flex justify-content-center gap-2">
						                            <a href="UpdateBookingServlet?id=${currentBooking.bookingId}" class="action-btn btn-edit" title="Sửa">
						                                <i class="fas fa-pen"></i>
						                            </a>
						                            <a href="#" onclick="doDelete('${currentBooking.bookingId}', '${param.id}')" class="action-btn btn-delete" title="Xóa">
						                                <i class="fas fa-trash"></i>
						                            </a>
						                        </div>
						                    </c:when>
						                    <c:otherwise>
						                        <a href="AddBookingServlet?time=${timeSlot}&sportFieldId=${param.id}&viewDate=${viewDate}" class="action-btn btn-list" title="Thêm mới">
						                            <i class="fas fa-plus-circle fa-lg"></i>
						                        </a>
						                    </c:otherwise>
						                </c:choose>
						            </td>
						        </tr>
						    </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div> </div> 
    </div>
	<script src="js/index.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">
		function doDelete(bookingId, sportFieldId) {
			if (confirm("Bạn có chắc chắn xoá lịch đặt sân có id = " + bookingId)) {
			window.location = "DeleteBookingServlet?bookingId=" + bookingId + "&sportFieldId=" + sportFieldId;
			}
		}
	</script>
</body>
</html>