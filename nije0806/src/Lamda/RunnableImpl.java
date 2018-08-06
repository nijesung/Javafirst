package Lamda;

public class RunnableImpl implements Runnable {

	@Override
	public void run() {
		// 1초씩 간격을 두고 1부터 10 까지 출력
		int i = 1;
		while(i <= 10) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("i:" + i);
			i = i + 1;
		}

	}

}
