package thread;

public class thread01 extends Thread {
	
	public void run() { // 스레드로 동작할 메소드
		// 1초 마다 길앞잡이 라는 글자를 총 10번 출력
		
		int i = 0;
		while(i<10) {
			System.out.println("길앞잡이");
			
			try {
				Thread.sleep(1000); // 1초씩 대기하는 것은 Thread 클래스의 sleep 메소드를 이용
			} catch (InterruptedException e) {
				
				System.out.println("스레드 강제 종료"); // 스레드를 강제 종료 할 수 있도록
				                                   // 예외가 발생하면 run 메소드 종료
				
				/*
				System.out.println(e.getMessage());
				e.printStackTrace();
				*/
				return; // 실무에서는 이 부분에 "항상" 리턴이 들어가야 한다
			}
			i = i+1; // i 의 값 증가는 모듈 맨 마지막에
		}
	}
}
