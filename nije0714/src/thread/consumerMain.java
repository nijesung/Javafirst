package thread;

public class consumerMain {

	public static void main(String[] args) {
		
		account account = new account();
		
		thread03 th3 = new thread03(account);
		th3.start();
		thread04 th4 = new thread04(account);
		th4.start();

	}

}
