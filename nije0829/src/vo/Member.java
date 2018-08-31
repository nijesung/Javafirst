package vo;

import java.util.Date;

public class Member {
	
	protected String id;
	protected String password;
	protected String nickname;
	protected String phone;
	protected String self_introduction;
	protected Date birthday;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSelf_introduction() {
		return self_introduction;
	}
	public void setSelf_introduction(String self_introduction) {
		this.self_introduction = self_introduction;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", nickname=" + nickname + ", phone=" + phone
				+ ", self_introduction=" + self_introduction + ", birthday=" + birthday + "]";
	}
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Member(String id, String password, String nickname, String phone, String self_introduction, Date birthday) {
		super();
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.phone = phone;
		this.self_introduction = self_introduction;
		this.birthday = birthday;
	}
	
	
	
}
