package model;
import java.sql.Date;


public class Staff {
	    private int staffId;
	    private String userName;
	    private String passWord;
	    private String fullName;
	    private String avatar;
	    private Date birthday;
	    private String gender;
	    private String phone;
	    private String email;
	    private String address;
	    private int roleId;

	    
	    public Staff() {
	    }

	    public Staff(int staffId, String userName, String passWord, String fullName,
	                 String avatar, Date birthday, String gender, String phone,
	                 String email, String address, int roleId) {
	        this.staffId = staffId;
	        this.userName = userName;
	        this.passWord = passWord;
	        this.fullName = fullName;
	        this.avatar = avatar;
	        this.birthday = birthday;
	        this.gender = gender;
	        this.phone = phone;
	        this.email = email;
	        this.address = address;
	        this.roleId = roleId;
	    }

	    // Getter & Setter
	    public int getStaffId() {
	        return staffId;
	    }

	    public void setStaffId(int staffId) {
	        this.staffId = staffId;
	    }

	    public String getUserName() {
	        return userName;
	    }

	    public void setUserName(String userName) {
	        this.userName = userName;
	    }

	    public String getPassWord() {
	        return passWord;
	    }

	    public void setPassWord(String passWord) {
	        this.passWord = passWord;
	    }

	    public String getFullName() {
	        return fullName;
	    }

	    public void setFullName(String fullName) {
	        this.fullName = fullName;
	    }

	    public String getAvatar() {
	        return avatar;
	    }

	    public void setAvatar(String avatar) {
	        this.avatar = avatar;
	    }

	    public Date getBirthday() {
	        return birthday;
	    }

	    public void setBirthday(Date birthday) {
	        this.birthday = birthday;
	    }

	    public String getGender() {
	        return gender;
	    }

	    public void setGender(String gender) {
	        this.gender = gender;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public int getRoleId() {
	        return roleId;
	    }

	    public void setRoleId(int roleId) {
	        this.roleId = roleId;
	    }

	    @Override
		public String toString() {
			return "Staff [staffId=" + staffId + ", userName=" + userName + ", passWord=" + passWord + ", fullName=" + fullName + ", avatar=" + avatar + ", birthday=" + birthday + ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", address=" + address + ", roleId=" + roleId + "]";
		}
}
