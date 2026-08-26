package thuc.ute.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String email;
	private String username;
	private String password;
	private String fullname;
	private String avatar;
	private int roleid;
	private String phone;
	private Date createdDate;

	public UserModel() {
	}

	public UserModel(int id, String username, String password, String fullname) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
	}

	public UserModel(String email, String username, String fullname, String password, String avatar, int roleid,
			String phone, Date createdDate) {
		this.email = email;
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.avatar = avatar;
		this.roleid = roleid;
		this.phone = phone;
		this.createdDate = createdDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Override
	public String toString() {
		return "UserModel [id=" + id
				+ ", email=" + email
				+ ", userName=" + username
				+ ", fullName=" + fullname
				+ ", passWord=" + password
				+ ", avatar=" + avatar
				+ ", roleid=" + roleid
				+ ", phone=" + phone
				+ ", createdDate=" + createdDate
				+ "]";
	}
}
