package model;

public class SportField {
	private int sportFieldId;
	private String sportFieldName;
	private int sportId;
	private String description;
	private String image;
	private String status;
	private int price;

	public SportField() {
	}

	public SportField(int sportFieldId, String sportFieldName, int sportId, String description, String image, String status, int price) {
		this.sportFieldId = sportFieldId;
		this.sportFieldName = sportFieldName;
		this.sportId = sportId;
		this.description = description;
		this.image = image;
		this.status = status;
		this.price = price;
	}

	public int getSportFieldId() {
		return sportFieldId;
	}

	public void setSportFieldId(int sportFieldId) {
		this.sportFieldId = sportFieldId;
	}

	public String getSportFieldName() {
		return sportFieldName;
	}

	public void setSportFieldName(String sportFieldName) {
		this.sportFieldName = sportFieldName;
	}
	
	public int getSportId() {
		return sportId;
	}

	public void setSportId(int sportId) {
		this.sportId = sportId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "SportField [sportFieldId=" + sportFieldId + ", sportFieldName=" + sportFieldName + ", sportId=" + sportId + ", description=" + description + ", image=" + image + ", status=" + status + ", price=" + price + "]";
	}
}
