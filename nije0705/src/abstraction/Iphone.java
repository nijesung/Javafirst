package abstraction;

public class Iphone extends SmartPhone {
	public void call() {  
		double x = 10.7;
		System.out.println("x:" + (int)x); // 실수를 정수로 강제 형 변환: 소수가 버려진다.
		
		
	    System.out.println("아이폰에서 전화걸기");
	    
	}

}
