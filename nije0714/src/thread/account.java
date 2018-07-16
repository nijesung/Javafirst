package thread;

public class account {
	private int balance;

	public synchronized void save() {
		System.out.println("출금 전 잔액: " + balance);
		balance = balance + 1000;
		notify(); // wait 중인 메소드 깨우기
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("출금 후 잔액: " + balance);

	}

	// 잔액을 감소시키는 메소드
	public synchronized void decrease() {
		if(balance < 10000) {
			try {
				wait();  // notify 를 호출할 때 까지 대기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("출금 전 잔액: " + balance);
		balance = balance - 1000;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("출금 후 잔액: " + balance);

	}

}
