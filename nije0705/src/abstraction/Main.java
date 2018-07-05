package abstraction;

public class Main {

	public static void main(String[] args) {
		
	 // Iphone = new Iphone();
		SmartPhone SmartPhone = new Iphone();
		SmartPhone.call();
		
	 //	SmartPhone SmartPhone = new Android();
		SmartPhone = new Android();
		SmartPhone.call();
		
	 //	SmartPhone = new SmartPhone(); // 스마트폰 클래스에 abstract 룰 붙여서 에러가 발생하는 모습
		
		SmartPhone = new WinPhone(); // 상위 클래스의 변수가 있으면 이용을 할 것
		SmartPhone.call();
		
		final int ZERO = 0; // final 변수 - 값을 변경할 수 없다
		                    // 지역변수지만 전역변수 처럼 메모리에서 소멸되지 않는다
		
	 // ZERO = 1; // 값을 변경하려 하자 에러가 나는 모습
		

	}

}
