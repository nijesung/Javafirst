package abstraction;

public class Android extends SmartPhone {
	public void call() {
		
		double x = 10.75;
		
		System.out.println("x:" + (int)(x + 0.5)); // 소수 첫째 자리 반올림해서 출력하기
		
		System.out.println("x:" + ((int)(x*10+0.5))/10.0); // 소수 두번째 자리 반올림해서 출력하기
		
	}

}
