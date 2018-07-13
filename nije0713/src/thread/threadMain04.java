package thread;

public class threadMain04 {

	public static void main(String[] args) {
		threadEx04 obj01 = new threadEx04("스레드 1"); // start 가 없다
		threadEx04 obj02 = new threadEx04("스레드 2");
		
		Thread th01 = new Thread(obj01); // 스레드 생성
		Thread th02 = new Thread(obj02);
		
		// 스레드의 우선 순위 변경
		th01.setPriority(Thread.MIN_PRIORITY); // 가장 낮은 우선 순위로 설정 (엄밀하게 정확히 동작하지는 않는다)
		th01.setPriority(Thread.MAX_PRIORITY); // 가장 높은 우선 순위로 설정
		
		th01.start(); // 스레드 시작
		th02.start();
		
		try {
			Thread.sleep(3000); // 3초 동안 동작하고 코자기
		    th01.interrupt(); // interrupt 만 추가한다고 멈추는 것은 아니다
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
