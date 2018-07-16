package thread;

public class bank {
	
	private int balance = 10000; // 잔액을 저장할 변수
	
	public void job(String msg) {
		synchronized(this) { // this - 내 자신의 자원을 사용하는 경우 이 코드는 한 번에 수행되어야 한다
		System.out.println("현재 잔액: " + balance);
		balance = balance - 100;
		try {
			Thread.sleep(1000); // 1초 대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(msg + "작업 후 현재 잔액: " + balance);
		}
	}

}
