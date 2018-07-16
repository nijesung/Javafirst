package thread;

public class thread02 extends Thread {
	private bank bank;
	private String name;
	
	public thread02(bank bank, String name) { // 생성자에서 bank 와 문자열 1개를 대입받기
		this.bank = bank;
		this.name = name;
	}
	
	public void run() { // 스레드로 동작할 메소드
		for(int i = 0; i<3; i=i+1) { // bank 의 메소드를 3회 호출
			bank.job(name);
		}
		
	}

}
