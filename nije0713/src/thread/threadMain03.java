package thread;

public class threadMain03 {

	public static void main(String[] args) {
		// Runnable 인터페이스를 implements 한 클래스를 이용해서 스레드 시작
		threadEx03 th03 = new threadEx03();
		Thread th = new Thread(th03); // start 라는 메소드가 스레드 클래스에 있기 때문에 한번 더 작업해야 한다
		th.start();

	}

}
