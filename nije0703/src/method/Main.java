package method;

public class Main { // 실행 클래스 - main 메소드를 소유한 클래스

	public static void main(String[] args) {
	
		
		

		Member member1 = new Member(); // member 클래스의 인스턴스를 생성

		// member1.email="roto315@naver.com"; //문자열이라 " " 로 감싸는 것 잊지 말기
	    member1.setEmail("roto315@naver.com"); // 문자열이라 " " 로 감싸는 것 잊지 말기
		
	    System.out.print("이메일: ");
	  //String email = sc.nextLine();
	  //member1.setEmail(email);
		
		member1.setPassword("123123");
		member1.setAge(90);
		// member1.setNickname=("연오랑과새우녀"); // 메소드는 = 이 없어야 한다. = 이 있어서 오류가 발생한 것
		member1.setNickname("연오랑과새우녀");
		member1.setMomey(true);
		
	   //sc.close();

	  //member1.display(); // 메소드를 활용하면 활용이 편해진다.
		System.out.println(member1);
		
		System.out.println(Member.sum(10, 30));
		System.out.println(Member.sum(10, 20, 30));
		System.out.println(member1.sum(10, 20, 30, 40)); // 경고표시가 나는 것은 앞글자가 소문자이기때문

	}

}
