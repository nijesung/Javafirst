package mutex;

public class mutex01 implements Runnable {
	
	private int result;
	private int idx;
	
 	private void sum() {
 //	private synchronized void sum() { // synchronized를 붙이면 여러 개의 스레드가 동시에 호출할 지라도 하나의 수행이
		                              // 완벽히 종료된 후에 메소드가 호출되기 때문에 오차를 막을 수 있다
		for(int i=0; i<10000; i=i+1) {
			// 자신이 가지고 있는 자원을 사용할 때 이 코드 영역은 동기적으로 동작하도록 해주는 설정
			synchronized(this) { // 모듈의 크기가 더 작은 이 곳에 synchronized 를 붙이는 것이 더 좋다
			idx = idx + 1;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			result = result + idx;
		    }
	    }
    }

	@Override
	public void run() {
		sum();
	}
	
	public int getResult() { // result 값을 리턴해 주는 메소드
		return result;
	}

}
