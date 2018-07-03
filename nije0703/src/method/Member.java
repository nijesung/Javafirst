package method;

import java.util.Scanner;

public class Member {
	private String email;

	public String getEmail() {// email의 getter
		return email;
	}

	Scanner sc = new Scanner(System.in);

	public void setEmail(String arg) {// email의 getter
		email = arg;
	}

	private String password;
	private String nickname;
	private int age;
	boolean momey;

	public String getPassword() { // 소스 메뉴에 자동으로 만들어주는 기능이 있다
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMomey() {
		return momey;
	}

	public void setMomey(boolean momey) {
		this.momey = momey;
	}
	
	

	@Override // 소스 메뉴에서 자동으로 toString 만들어주는 기능이 있다
	public String toString() {
		return "Member [email=" + email + ", password=" + password + ", nickname=" + nickname + ", age=" + age
				+ ", momey=" + momey + "]";
	}

	
	// 클래스 안에서 클래스에 만들어진 변수들을 사용할 때는 인스턴스나 클래스 이름을 기재하지 않는다.
	public void display() {
		System.out.print("roto315@naver.com"); // 인스턴스 변수들을 출력해주는 메소드
	  //System.out.println("이메일:" + "roto315@naver.com"); // 인스턴스 변수들을 출력해주는 메소드
		System.out.println("비밀번호:" + "123123");
		System.out.println("나이:" + 90);
		System.out.println("닉네임:" + "연오랑과새우녀");

	}
	
	public static int sum(int ... ar) { //static 메소드는 클래스 이름으로 호출할 수 있다.
		                            // 매개변수에 ... 이 있으면 매개변수 "개수에 상관 없이" 대입이 가능하다.	
		int tot = 0; // heap에 있는 데이터를 stack 에 저장
		             // 자주 사용하기 때문에 heap에 있으면 효율이 떨어짐
		int len = ar.length; // 반복문을 쓸 때는 이 쪽으로 꺼내서 쓰는 것이 메모리절약
		for(int i = 0; i<len; i=i+1) {
			tot = tot + ar[i];
		}
		return tot;
		
		
	}

}
