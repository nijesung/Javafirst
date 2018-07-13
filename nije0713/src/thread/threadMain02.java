package thread;

public class threadMain02 {

	public static void main(String[] args) {
		
		threadEx02 th02 = new threadEx02(); // 스레드를 생성
		th02.start(); // 스레드로 실행
		
		System.out.println("리얼루다가 스레드?"); // 스레드 확인 문구 (작업 도중에 출력되는 것이니 스레드가 맞음을 확인)
		

	}

}
