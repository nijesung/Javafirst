package io;

public class Member {
	private String email;
	private String pw;
	private String phone;
	
	@Override
	public String toString() {
		return "Member [email=" + email + ", pw=" + pw + ", phone=" + phone + "]";
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
