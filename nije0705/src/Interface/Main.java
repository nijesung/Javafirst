package Interface;

import java.util.Scanner;

public class Main { // 안에서 다른 클래스를 불러다 쓰는 것을 has a 관계라고 한다

	
	public static void main(String[] args) {
		MemberService MemberService = new MemberServiceImpl();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력하시오: ");
		String id = sc.nextLine();
		boolean r = MemberService.idCheck(id);
		if(r == true) {
			System.out.println("사용 가능한 아이디 입니다.");
		}
		else {
			System.out.println("이미 존재하는 아이디 입니다.");
		}
		
		System.out.println("로그인 할 아이디를 입력하시오: ");
		id = sc.nextLine();
		
		System.out.print("비밀번호를 입력하시오: ");
		String password = sc.nextLine();
		
		int result = MemberService.login(id, password);
		if(result == 0) {
			System.out.println("로그인 성공.");
		}
		else if (result == 1) {
			System.out.println("비밀번호가 틀렸습니다.");
		}
		else if (result == 2) {
			System.out.println("존재하지 않는 id 입니다.");
		}
		
		
        sc.close();
	}

}
