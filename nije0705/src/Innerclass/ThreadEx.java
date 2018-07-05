package Innerclass;

public class ThreadEx extends Thread { // Thread를 상속받은 클래스
	
	@Override // 오버라이딩 한 메소드라는 것을 나타내는 이노베이션
	public void run() {
		try {
			for(int i=0; i<10; i=i+1) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		}
		catch(Exception e) {}
	}

}
