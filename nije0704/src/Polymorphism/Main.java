package Polymorphism;

public class Main {

	public static void main(String[] args) {
	  /*Super base = new Super(); // Super 클래스의 인스턴스를 생성
		
		Sub drive = new Sub(); // Sub 클래스의 인스턴스를 생성
		
		
		Super sup = new Sub(); // 상위 클래스 타입의 변수에 하위 클래스 타입의 인스턴스 주소를 대입할 수 있다
		                       // 상속을 받았기에 에러 없이 가능한 것
		
		// 하위 클래스 타입의 변수에 상위 클래스 타입의 인스턴스 주소를 대입하는 것은 강제 형 변환을 통해서만 가능하다.(예외 발생)
		
	//	Sub sup = new Super(); // 에러가 난다
		Sub sup1 = (Sub)(new Super()); // 에러가 나지 않지만 예외가 발생한다
		*/
		
	    Super sup = new Super(); // sup 은 기본적으로 Super 의 것만 호출할 수 있다
	    sup.just();
		
		sup = new Sub(); // 오버라이딩 된 메소드는 변수를 선언할 때 사용한 자료형이 아니라 인스턴스를 만들어서 대입
		sup.just();   // 할 때 사용한 자료형의 것을 호출한다
		

	}

}
