package thread;

public class threadMain01 {

	public static void main(String[] args) {
		
		thread01 th1 = new thread01(); // 클래스 의 run 메소드 사용
		
		th1.setDaemon(true); // 데몬 스레드로 설정
		                     // 다른 스레드가 작업 중이 아니면 자동 종료
		
		th1.start(); // 스레드 시작
		
		try {
			Thread.sleep(2000);
			
			th1. interrupt(); // InterrupteException 을 발생시킨다
			
			Thread.sleep(3000);
			System.out.println("메인 종료");
			//System.exit(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}

}
