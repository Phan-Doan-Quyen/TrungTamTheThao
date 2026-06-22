-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 11, 2026 lúc 03:17 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qltttt`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `booking`
--

CREATE TABLE `booking` (
  `BookingId` int(11) NOT NULL,
  `ClassId` int(11) DEFAULT NULL,
  `SportFieldId` int(11) DEFAULT NULL,
  `CustomerName` varchar(50) DEFAULT NULL,
  `Phone` varchar(10) DEFAULT NULL,
  `CreateDate` date DEFAULT NULL,
  `Time` varchar(20) DEFAULT NULL,
  `PaymentMethod` varchar(50) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  `Status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `booking`
--

INSERT INTO `booking` (`BookingId`, `ClassId`, `SportFieldId`, `CustomerName`, `Phone`, `CreateDate`, `Time`, `PaymentMethod`, `Price`, `Status`) VALUES
(1, NULL, 1, 'Nguyễn Hoàng Phong', '0397654875', '2025-12-17', '17:00 - 18:00', 'Chuyển khoản', 180000, 'Đã thanh toán'),
(2, NULL, 1, 'Phan Văn Trung', '0483948766', '2025-12-17', '18:00 - 19:00', 'Tiền mặt', 180000, 'Chưa thanh toán'),
(3, 1, 2, '', '0', '0000-00-00', '17:00 - 18:00', '', 0, ''),
(4, NULL, 1, 'Phạm Minh Vũ', '0397654365', '2025-12-18', '17:00 - 18:00', 'Tiền mặt', 180000, 'Đã thanh toán'),
(5, NULL, 2, 'Long', '0912345681', '2026-01-09', '10:00 - 11:00', 'Chuyển khoản', 200000, 'Đã thanh toán'),
(6, NULL, 1, 'Nguyễn Hoàng Long', '0912345678', '2026-01-11', '05:00 - 06:00', 'Chuyển khoản', 200000, 'Đã thanh toán');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `class`
--

CREATE TABLE `class` (
  `ClassId` int(11) NOT NULL,
  `ClassName` varchar(100) DEFAULT NULL,
  `SportId` int(11) DEFAULT NULL,
  `SportFieldId` int(11) DEFAULT NULL,
  `StaffId` int(11) DEFAULT NULL,
  `Image` varchar(50) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `QuantityMax` int(11) DEFAULT NULL,
  `MonthlyTuition` int(11) DEFAULT NULL,
  `Months` int(11) DEFAULT NULL,
  `Time` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `class`
--

INSERT INTO `class` (`ClassId`, `ClassName`, `SportId`, `SportFieldId`, `StaffId`, `Image`, `Quantity`, `QuantityMax`, `MonthlyTuition`, `Months`, `Time`) VALUES
(1, 'Lớp bóng đá FB1 (trẻ 5 - 10 tuổi)', 1, 1, NULL, 'football.png', 10, 20, 200000, 5, '17:00 - 18:00'),
(2, 'Lớp bóng đá FB2 (trẻ 15+)', 1, 2, NULL, 'football.png', 15, 20, 200000, 5, '17:00 - 18:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `roles`
--

CREATE TABLE `roles` (
  `RoleId` int(11) NOT NULL,
  `Role` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `roles`
--

INSERT INTO `roles` (`RoleId`, `Role`) VALUES
(1, 'Admin'),
(2, 'Quản lý'),
(3, 'Nhân viên'),
(4, 'Huấn luyện viên');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sportfields`
--

CREATE TABLE `sportfields` (
  `SportFieldId` int(11) NOT NULL,
  `SportFieldName` varchar(255) DEFAULT NULL,
  `SportId` int(11) DEFAULT NULL,
  `Description` varchar(500) DEFAULT NULL,
  `Image` varchar(255) DEFAULT NULL,
  `Status` varchar(50) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `sportfields`
--

INSERT INTO `sportfields` (`SportFieldId`, `SportFieldName`, `SportId`, `Description`, `Image`, `Status`, `Price`) VALUES
(1, 'Sân bóng đá A1', 1, 'Sân bóng đá là nơi diễn ra...', 'football.png', 'Đang hoạt động', 180000),
(2, 'Sân bóng đá A2', 1, 'Sân bóng đá là nơi diễn ra...', 'football.png', 'Đang bảo trì', 5),
(3, 'Sân pickerball B1', 2, 'Sân pickerball là nơi diễn ra...', 'pickerball.png', 'Đang hoạt động', 5),
(4, 'Sân pickerball B2', 2, 'Sân pickerball là nơi diễn ra...', 'pickerball.png', 'Đang bảo trì', 200000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sports`
--

CREATE TABLE `sports` (
  `SportId` int(11) NOT NULL,
  `SportName` varchar(50) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `sports`
--

INSERT INTO `sports` (`SportId`, `SportName`, `Description`) VALUES
(1, 'Bóng đá', 'a'),
(2, 'Pickerball', 'aa');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tb_staff`
--

CREATE TABLE `tb_staff` (
  `StaffId` int(11) NOT NULL,
  `UserName` varchar(50) DEFAULT NULL,
  `PassWord` varchar(50) DEFAULT NULL,
  `FullName` varchar(50) DEFAULT NULL,
  `Avatar` varchar(50) DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  `Gender` varchar(50) DEFAULT NULL,
  `Phone` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `RoleId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tb_staff`
--

INSERT INTO `tb_staff` (`StaffId`, `UserName`, `PassWord`, `FullName`, `Avatar`, `Birthday`, `Gender`, `Phone`, `Email`, `Address`, `RoleId`) VALUES
(1, 'hoapham', '12345678', 'Phạm Thị Hoa', '', '1985-11-03', 'Nữ', '0397654375', 'hoa@gmail.com', 'Nghệ An', 2),
(2, 'hoangphan', '123456789', 'Phan Minh Hoàng', '', '2004-10-18', 'Nam', '0483948374', 'hoang@gmail.com', 'Nghệ An', 3),
(3, 'aaa', '123456', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`BookingId`),
  ADD KEY `ClassId` (`ClassId`,`SportFieldId`),
  ADD KEY `SportFieldId` (`SportFieldId`);

--
-- Chỉ mục cho bảng `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`ClassId`),
  ADD KEY `SportId` (`SportId`,`SportFieldId`,`StaffId`),
  ADD KEY `SportFieldId` (`SportFieldId`),
  ADD KEY `StaffId` (`StaffId`);

--
-- Chỉ mục cho bảng `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`RoleId`);

--
-- Chỉ mục cho bảng `sportfields`
--
ALTER TABLE `sportfields`
  ADD PRIMARY KEY (`SportFieldId`),
  ADD KEY `SportId` (`SportId`);

--
-- Chỉ mục cho bảng `sports`
--
ALTER TABLE `sports`
  ADD PRIMARY KEY (`SportId`);

--
-- Chỉ mục cho bảng `tb_staff`
--
ALTER TABLE `tb_staff`
  ADD PRIMARY KEY (`StaffId`),
  ADD KEY `RoleId` (`RoleId`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`ClassId`) REFERENCES `class` (`ClassId`),
  ADD CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`SportFieldId`) REFERENCES `sportfields` (`SportFieldId`);

--
-- Các ràng buộc cho bảng `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `class_ibfk_1` FOREIGN KEY (`SportId`) REFERENCES `sports` (`SportId`),
  ADD CONSTRAINT `class_ibfk_2` FOREIGN KEY (`SportFieldId`) REFERENCES `sportfields` (`SportFieldId`),
  ADD CONSTRAINT `class_ibfk_3` FOREIGN KEY (`StaffId`) REFERENCES `tb_staff` (`StaffId`);

--
-- Các ràng buộc cho bảng `sportfields`
--
ALTER TABLE `sportfields`
  ADD CONSTRAINT `sportfields_ibfk_1` FOREIGN KEY (`SportId`) REFERENCES `sports` (`SportId`);

--
-- Các ràng buộc cho bảng `tb_staff`
--
ALTER TABLE `tb_staff`
  ADD CONSTRAINT `tb_staff_ibfk_1` FOREIGN KEY (`RoleId`) REFERENCES `roles` (`RoleId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
