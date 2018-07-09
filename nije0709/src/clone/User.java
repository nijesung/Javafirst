package clone; // 데이터를 저장하는 클래스

import java.util.Arrays;

public class User {
	private int num;
	private String name;
	private String[] insect;
	
	
	public int getNum() { // 인스턴스 변수를 사용하기 위한 접근자 메소드 getters & setters
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override // 인스턴스 변수의 값을 빠르게 확인하기 위한 "디버깅" 메소드
	public String toString() {
		return "User [num=" + num + ", name=" + name + ", insect=" + Arrays.toString(insect) + "]";
	}
	public String[] getInsect() {
		return insect;
	}
	public void setInsect(String[] insect) {
		this.insect = insect;
	}
	
	/*
	public User clone() { // 잘못 만든 복제 메소드
		User user = new User();
		user.num = this.num;
		user.name = this.name;
		user.insect = this.insect;
		return user;
	}
	*/
	
	public User clone() { // 현재 인스턴스를 이용해서 새로운 인스턴트를 생성해 주는 메소드
		User user = new User();
		user.num = this.num;
		user.name = this.name;
	 // user.insect = this.insect;
		user.insect = new String[this.insect.length]; // 참조형은 다시 복제를 해 주어야 한다
		for(int i = 0; i<this.insect.length; i = i+1) {
			user.insect[i] = this.insect[i];
		}
		return user;
	}
	
	

}
