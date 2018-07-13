package thread;

import java.util.Random;

public class threadEx02 extends Thread {
	
	public void run() { // 스레드로 수행할 내용을 작성하는 메소드
		
		String [] color = {"빨강", "파랑", "노랑"}; // 빨강 파랑 노랑을 랜덤하게 1초 마다 출력하기
		
		Random r = new Random(); // 랜덤을 만들어주는 클래스의 인스턴스 만들기
		
		
		while(true) { // 무한 반복
			System.out.println(color[r.nextInt(color.length)]); // color 배열의 데이터를 랜덤하게 출력
			
			try {
				Thread.sleep(1000); // 1초씩 대기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
