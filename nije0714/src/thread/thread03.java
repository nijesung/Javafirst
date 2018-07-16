package thread;

public class thread03 extends Thread {
	private account account;
	
	public thread03(account account) {
		this.account = account;
	}
	public void run() {
		for(int i=0; i<5; i=i+1) {
			account.save();
		}
	}

}
