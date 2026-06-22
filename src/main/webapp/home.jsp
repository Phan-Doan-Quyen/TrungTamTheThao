<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/jpeg" href="images/login/logo.jpg">
<title>Hệ thống quản lý trung tâm thể thao</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/table.css">
<link rel="stylesheet" href="css/home.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="sidebar.jsp" />
	
	<div class="main-wrapper">
        <jsp:include page="navbar.jsp" />

        <div class="content-body">
    
		    <div class="row g-4 d-flex align-items-stretch">
		        
		        <div class="col-lg-4 d-flex flex-column gap-4">
		            
		            <div class="card stat-card flex-fill"> <div class="d-flex justify-content-between align-items-start mb-2">
		                    <div>
		                        <h6 class="text-muted mb-2">Lượt đặt sân</h6>
		                        <h3 class="fw-bold mb-0">${luotDatSan} </h3>
		                    </div>
		                    <div class="icon-box bg-purple-light">
		                        <i class="fa-solid fa-calendar-check"></i>
		                    </div>
		                </div>
		                <div class="d-flex align-items-center text-success small mt-auto">
		                    <i class="fa-solid fa-arrow-trend-up me-1"></i>
		                    <span class="fw-bold">8.5%</span>
		                    <span class="text-muted ms-1">so với tháng trước</span>
		                </div>
		            </div>
		
		            <div class="card stat-card flex-fill">
		                <div class="d-flex justify-content-between align-items-start mb-2">
		                    <div>
		                        <h6 class="text-muted mb-2">Số người đăng ký học</h6>
		                        <h3 class="fw-bold mb-0">${nguoiDangKy}</h3>
		                    </div>
		                    <div class="icon-box bg-blue-light">
		                        <i class="fa-solid fa-users"></i>
		                    </div>
		                </div>
		                <div class="d-flex align-items-center text-success small mt-auto">
		                    <i class="fa-solid fa-arrow-trend-up me-1"></i>
		                    <span class="fw-bold">1.3%</span>
		                    <span class="text-muted ms-1">so với tháng trước</span>
		                </div>
		            </div>
		
		        </div>
		
		        <div class="col-lg-8">
		            <div class="chart-container h-100"> <h5 class="mb-3 text-secondary fw-bold" style="font-size: 16px;">Môn thể thao ưa chuộng</h5>
		                
		                <div class="chart-content-wrapper h-100">
		                    <div style="width: 65%; height: 100%; position: relative;">
		                        <canvas id="sportChart"></canvas>
		                    </div>
		
		                    <div style="width: 35%; padding-left: 20px; display: flex; flex-direction: column; justify-content: center;">
		                        <div class="legend-item">
								    <span class="legend-dot" style="background-color: #6366f1;"></span>
								    <div>
								        <div class="text-dark fw-bold">Bóng đá</div>
								        <small class="text-muted">${tiLeBongDa}%</small> </div>
								</div>
								
								<div class="legend-item">
								    <span class="legend-dot" style="background-color: #8da1f7;"></span>
								    <div>
								        <div class="text-dark fw-bold">Pickleball</div>
								        <small class="text-muted">${tiLePickleball}%</small> </div>
								</div>
								
								<div class="legend-item">
								    <span class="legend-dot" style="background-color: #ff9fb3;"></span>
								    <div>
								        <div class="text-dark fw-bold">Khác</div>
								        <small class="text-muted">${tiLeKhac}%</small> </div>
								</div>
		                    </div>
		                </div>
		            </div>
		        </div>
		    </div> 
		    
		    <div class="row g-4 mt-1">
			    <div class="col-lg-8">
			        <div class="card stat-card h-100" style="min-height: 400px;">
			            <div class="d-flex justify-content-between align-items-center mb-4">
			                <h5 class="text-secondary fw-bold mb-0" style="font-size: 16px;">Xu hướng đặt sân (7 ngày qua)</h5>
			                <select class="form-select form-select-sm" style="width: 120px;">
			                    <option>Tuần này</option>
			                    <option>Tháng này</option>
			                </select>
			            </div>
			            <div style="flex-grow: 1; position: relative; width: 100%;">
			                <canvas id="lineChart"></canvas>
			            </div>
			        </div>
			    </div>
			
			    <div class="col-lg-4">
			        <div class="card stat-card h-100">
			            <h5 class="text-secondary fw-bold mb-3" style="font-size: 16px;">Đặt sân mới nhất</h5>
			            
			            <div class="table-responsive">
			                <table class="table table-hover align-middle mb-0">
			                    <thead class="table-light">
			                        <tr>
			                            <th class="small text-muted border-0">Khách hàng</th>
			                            <th class="small text-muted border-0 text-end">Trạng thái</th>
			                        </tr>
			                    </thead>
			                    <tbody>
			                        <tr>
			                            <td class="border-bottom-0 py-3">
			                                <div class="d-flex align-items-center">
			                                    <div class="bg-light rounded-circle d-flex align-items-center justify-content-center me-3" style="width: 35px; height: 35px; color: #006a4e;">
			                                        <i class="fa-solid fa-user"></i>
			                                    </div>
			                                    <div>
			                                        <div class="fw-bold" style="font-size: 14px;">Nguyễn Văn A</div>
			                                        <div class="small text-muted" style="font-size: 12px;">Sân bóng số 1 - 17:00</div>
			                                    </div>
			                                </div>
			                            </td>
			                            <td class="border-bottom-0 text-end">
			                                <span class="badge bg-success-subtle text-success rounded-pill px-3">Đã cọc</span>
			                            </td>
			                        </tr>
			
			                        <tr>
			                            <td class="border-bottom-0 py-3">
			                                <div class="d-flex align-items-center">
			                                    <div class="bg-light rounded-circle d-flex align-items-center justify-content-center me-3" style="width: 35px; height: 35px; color: #006a4e;">
			                                        <i class="fa-solid fa-user"></i>
			                                    </div>
			                                    <div>
			                                        <div class="fw-bold" style="font-size: 14px;">Trần Thị B</div>
			                                        <div class="small text-muted" style="font-size: 12px;">Sân Pickleball 2 - 18:30</div>
			                                    </div>
			                                </div>
			                            </td>
			                            <td class="border-bottom-0 text-end">
			                                <span class="badge bg-warning-subtle text-warning rounded-pill px-3">Chờ duyệt</span>
			                            </td>
			                        </tr>
			                        
			                        <tr>
			                            <td class="border-bottom-0 py-3">
			                                <div class="d-flex align-items-center">
			                                    <div class="bg-light rounded-circle d-flex align-items-center justify-content-center me-3" style="width: 35px; height: 35px; color: #006a4e;">
			                                        <i class="fa-solid fa-user"></i>
			                                    </div>
			                                    <div>
			                                        <div class="fw-bold" style="font-size: 14px;">Lê Văn C</div>
			                                        <div class="small text-muted" style="font-size: 12px;">Sân bóng số 3 - 19:00</div>
			                                    </div>
			                                </div>
			                            </td>
			                            <td class="border-bottom-0 text-end">
			                                <span class="badge bg-danger-subtle text-danger rounded-pill px-3">Đã hủy</span>
			                            </td>
			                        </tr>
			                        
			                        <tr>
			                            <td class="border-bottom-0 py-3">
			                                <div class="d-flex align-items-center">
			                                    <div class="bg-light rounded-circle d-flex align-items-center justify-content-center me-3" style="width: 35px; height: 35px; color: #006a4e;">
			                                        <i class="fa-solid fa-user"></i>
			                                    </div>
			                                    <div>
			                                        <div class="fw-bold" style="font-size: 14px;">Phạm Minh H</div>
			                                        <div class="small text-muted" style="font-size: 12px;">Sân bóng số 2 - 20:00</div>
			                                    </div>
			                                </div>
			                            </td>
			                            <td class="border-bottom-0 text-end">
			                                <span class="badge bg-success-subtle text-success rounded-pill px-3">Hoàn thành</span>
			                            </td>
			                        </tr>
			
			                    </tbody>
			                </table>
			            </div>
			            
			            <div class="mt-auto text-center pt-3 border-top">
			                <a href="BookingServlet" class="text-decoration-none small fw-bold" style="color: #006a4e;">Xem tất cả đơn hàng <i class="fa-solid fa-arrow-right ms-1"></i></a>
			            </div>
			        </div>
			    </div>
		    </div>
		</div>
		</div>
    </div> 
    <script src="js/index.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    
    <script>
	    const ctx = document.getElementById('sportChart').getContext('2d');
	    new Chart(ctx, {
	        type: 'doughnut',
	        data: {
	            labels: ['Bóng đá', 'Pickleball', 'Các môn khác'],
	            datasets: [{
	                data: [${tiLeBongDa}, ${tiLePickleball}, ${tiLeKhac}],
	                backgroundColor: [
	                    '#6366f1',
	                    '#8da1f7',
	                    '#ff9fb3'
	                ],
	                borderWidth: 0,
	                hoverOffset: 4
	            }]
	        },
	        options: {
	            responsive: true,
	            maintainAspectRatio: false, 
	            cutout: '75%', 
	            plugins: {
	                legend: {
	                    display: false
	                },
	                tooltip: {
	                    enabled: true
	                }
	            }
	        }
	    });
	</script>
	<script>
	    // --- BIỂU ĐỒ ĐƯỜNG (LINE CHART) ---
	    const ctxLine = document.getElementById('lineChart').getContext('2d');
	    
	    // Tạo gradient màu xanh cho đẹp
	    var gradient = ctxLine.createLinearGradient(0, 0, 0, 400);
	    gradient.addColorStop(0, 'rgba(0, 106, 78, 0.2)'); // Màu xanh đậm nhạt dần
	    gradient.addColorStop(1, 'rgba(0, 106, 78, 0)');
	
	    new Chart(ctxLine, {
	        type: 'line',
	        data: {
	            // Lấy dữ liệu từ Servlet truyền sang (JSP Expression)
	            labels: ['Thứ 2', 'Thứ 3', 'Thứ 4', 'Thứ 5', 'Thứ 6', 'Thứ 7', 'CN'], 
	            datasets: [{
	                label: 'Lượt khách',
	                data: [15, 22, 18, 25, 30, 45, 40], // Bạn thay bằng ${chartData} nếu dùng mảng thật
	                borderColor: '#006a4e', // Màu đường kẻ (Xanh chủ đạo của web bạn)
	                backgroundColor: gradient, // Màu nền dưới đường kẻ
	                borderWidth: 2,
	                pointBackgroundColor: '#fff',
	                pointBorderColor: '#006a4e',
	                pointRadius: 4,
	                pointHoverRadius: 6,
	                fill: true, // Tô màu bên dưới
	                tension: 0.4 // Làm cong đường kẻ cho mềm mại
	            }]
	        },
	        options: {
	            responsive: true,
	            maintainAspectRatio: false,
	            plugins: {
	                legend: {
	                    display: false // Ẩn chú thích vì chỉ có 1 đường
	                },
	                tooltip: {
	                    mode: 'index',
	                    intersect: false,
	                }
	            },
	            scales: {
	                y: {
	                    beginAtZero: true,
	                    grid: {
	                        borderDash: [5, 5], // Kẻ nét đứt cho lưới
	                        color: '#f0f0f0'
	                    }
	                },
	                x: {
	                    grid: {
	                        display: false // Ẩn lưới dọc
	                    }
	                }
	            }
	        }
	    });
	</script>
</body>
</html>