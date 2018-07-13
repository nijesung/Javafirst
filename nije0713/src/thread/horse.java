package thread;

import java.util.Random;

public class horse extends Thread {
	private static int rank; // 이 클래스로부터 만들어진 모든 인스턴스가 스태틱 변수를 공유한다
	                         // 순위 등을 만들 때 스태틱 변수를 사용하라
	
	public void run() { // 스레드로부터 상속받았을 때 무조건 만들어 주어야 한다
		System.out.println(getName() + "출발");
		
		int pos = 0; // 현재 위치를 저장할 변수
		
		Random r= new Random(); // 랜덤한 값을 가져오기 위한 변수
		
		while(true) {
			try {
				Thread.sleep(200);
				pos = pos + r.nextInt(10);
				if(pos > 1000) {
					break;
				}
				System.out.println(getName() + ":" + pos);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		rank = rank + 1;
		System.out.println(getName() + "도착");
		System.out.println(getName() + rank + " 등");
	}

}
