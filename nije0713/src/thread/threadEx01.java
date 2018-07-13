package thread;

public class threadEx01 extends Thread{
	
	@Override
	public void run() {
		
		for(int i = 0; i<10; i=i+1) { // 1초씩 쉬면서 0~9까지를 순서대로 출력
			
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
