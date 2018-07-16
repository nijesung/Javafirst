package thread;

public class MutexMain {

	public static void main(String[] args) {
		bank bank = new bank();
		
		thread02 atm = new thread02(bank, "ATM"); // 스레드 인스턴스 만들기
		atm.start();
		
		// 이 상태에서 실행하면 ATM 스레드가 작업하고 있는 도중에 Internet 스레드 또한 작업을 수행하기 때문에 결과가 이상하게 나온다
		// 작업 전 잔액과 작업 후 잔액의 차이가 100이 되어야 하는데 200이 되는 경우가 발생한다
		// 이런 경우에는 작업 내에서 공유 자원을 사용하는 부분을 한번에 수행되도록 수정해 주어야 한다.
		thread02 internet = new thread02(bank, "internet"); // 중첩되어 작용하는 문제가 생긴다
		internet.start();

	}

}
