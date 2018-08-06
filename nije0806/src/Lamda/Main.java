package Lamda;

public class Main {

	public static void main(String[] args) {
		/*
		// 별도의 클래스를 만들어서 이용
		RunnableImpl r = new RunnableImpl();
		
		Thread th = new Thread(r);
		th.start();
		
		// 이 방법의 장점은 인스턴스 2개 만들 때. 클래스를 재활용할 수 있다.
        RunnableImpl r2 = new RunnableImpl();
		
		Thread th2 = new Thread(r);
		th2.start();
		*/
		
		// 이 방법의 단점은 재사용을 하지 못한다는 것이다.
	 //	Runnable r = new Runnable() {
		Runnable r = () -> { // 람다 이용

		 //	@Override
		 //	public void run() { // 람다 이용시 런이라는 메소드 이름도 없어져 버렸다
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

		 //	}
			
		};
		Thread th = new Thread(r);
		th.start();
	}
}

