package thread;

public class threadMain {

	public static void main(String[] args) {
		
		/*
		threadEx01 th01 = new threadEx01(); // 앞에서 만든 클래스의 인스턴스를 만들기
		th01.run(); // run 메소드 호출하기
		
		threadEx01 th02 = new threadEx01(); // 앞의 메소드의 작업이 모두 끝난 뒤에야 작동하는 것을 확인 가능하다
		th02.run();
		*/
		
		// 스레드로 실행
		threadEx01 th01 = new threadEx01();
		th01.start(); // start 메소드 호출
		
		threadEx01 th02 = new threadEx01(); // 스레드로 인해 잉여 시간동안 다음 스레드의 작업도 병행한다
		th02.start();
		
		
	}

}
