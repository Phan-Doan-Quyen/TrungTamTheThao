package model;

import java.sql.Date;

public class Booking {
	private int bookingId;
	private int classId;
	private int sportFieldId;
	private String customerName;
	private String phone;
	private Date createDate;
	private String time;
	private String paymentMethod;
	private int price;
	private String status;

	public Booking() {
	}

	public Booking(int bookingId, int classId, int sportFieldId, String customerName, String phone, Date createDate, String time, String paymentMethod, int price, String status) {
		this.bookingId = bookingId;
		this.classId = classId;
		this.sportFieldId = sportFieldId;
		this.customerName = customerName;
		this.phone = phone;
		this.createDate = createDate;
		this.time = time;
		this.paymentMethod = paymentMethod;
		this.price = price;
		this.status = status;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	
	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	public int getSportFieldId() {
		return sportFieldId;
	}

	public void setSportFieldId(int sportFieldId) {
		this.sportFieldId = sportFieldId;
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Class [bookingId=" + bookingId + ",classId=" + classId + ",sportFieldId=" + sportFieldId + ",   customerName=" + customerName + ", phone=" + phone + ", createDate=" + createDate + ", time=" + time + ", paymentMethod=" + paymentMethod + ", price=" + price + ", status=" + status + "]";
	}
}
