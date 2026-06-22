package model;

public class Class {
	private int classId;
	private String className;
	private int sportId;
	private int sportFieldId;
	private String image;
	private int quantity;
	private int quantityMax;
	private int monthlyTuition;
	private int months;
	private String time;

	public Class() {
	}

	public Class(int classId, String className, int sportId, int sportFieldId, String image, int quantity, int quantityMax, int monthlyTuition, int months, String time) {
		this.classId = classId;
		this.className = className;
		this.sportId = sportId;
		this.sportFieldId = sportFieldId;
		this.image = image;
		this.quantity = quantity;
		this.quantityMax = quantityMax;
		this.monthlyTuition = monthlyTuition;
		this.months = months;
		this.time = time;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public int getSportFieldId() {
		return sportFieldId;
	}

	public void setSportFieldId(int sportFieldId) {
		this.sportFieldId = sportFieldId;
	}
	
	public int getSportId() {
		return sportId;
	}

	public void setSportId(int sportId) {
		this.sportId = sportId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantityMax() {
		return quantityMax;
	}

	public void setQuantityMax(int quantityMax) {
		this.quantityMax = quantityMax;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public int getMonthlyTuition() {
		return monthlyTuition;
	}

	public void setMonthlyTuition(int monthlyTuition) {
		this.monthlyTuition = monthlyTuition;
	}
	
	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Class [sportFieldId=" + sportFieldId + ", classId=" + classId + ", sportId=" + sportId + ", className=" + className + ", image=" + image + ", quantity=" + quantity + ", quantityMax=" + quantityMax + ", monthlyTuition=" + monthlyTuition + ", months=" + months + ", time=" + time + "]";
	}
}
