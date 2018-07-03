package method;

public class Main {

	 //public static void main(String[] args) {
		 public static void main(String[]arg) { // 메인을 가진 것만 실행이 된다.
				test01.display();
			
		/*
		for(int i=0; i<3; i=i+1) { // 유지 보수를 위해 반복문 사용
			
		System.out.println("what the");
		}
		
		System.out.println("what the f"); // 연속하지 않아서 묶을 수 없다. 이 경우에 메소드를 이용하여 묶을 수 있다.
		
		for(int i=0; i<3; i=i+1) { 
			
		System.out.println("what the");
			}
			*/
		
		//test 클래스의 인스턴스 생성
	    test01 ins = new test01();
		
		System.out.println("what the f");
		
		//메소드 호출
		ins.whatthesave();
		
	   //new test01().tot(); // . 을 붙여 메소드를 호출
	     
	   //int result = new test01().tot(5);
	   //System.out.println("합계:" + result);
		
		
		boolean r = new test01().login("xxx","yyy"); // 로그인
		if(r == true) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("없는 아이디 이거나 비밀번호가 다릅니다");
		}
		
		
	    boolean r1 = new test01().login("xxx","yyy"); // 회원탈퇴
		if(r1 == true) {
			System.out.println("회원탈퇴 성공");
		}
		else {
			System.out.println("없는 아이디 이거나 비밀번호가 다릅니다");
		}
		
	
		int x = 10; // 메소드에게 value형의 데이터를 넘겨주었습니다.
		test01.incvalue(x);
		System.out.println(x); // 결과는? : 때려 죽여도 10. 절대 바뀔 수 없다.
		
		int[]ar = {100,200}; // 메소드에게 reference형의 데이터를 넘겨주었습니다.
		                     // 넘겨준 데이터에 변화가 발생할 수 있습니다.
		                     // 이런 경우는 document를 읽어보거나 데이터를 확인해보아야 합니다.
		test01.incReference(ar);
	    System.out.println(ar[0]); // 결과는? : 바뀔 수 있음을 염두에 둬야 한다.
		
		
		// 1
		test01 test01 = new test01();
		System.out.println(test01.sum(1000));
		
		System.out.println(test01.fiboRecursion(1000));
			
	}

}
