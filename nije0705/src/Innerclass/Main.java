package Innerclass;

public class Main {

	public static void main(String[] args) {
		ThreadEx obj = new ThreadEx();
		obj.start();
		
		
		Thread th = new Thread()  { // Thread 클래스의 Anonymous 만들기
			public void run() {     // extends Thread 를 하지 않고 만들었다
				try {
					for(int i = 10; i < 20; i=i+1) {
						System.out.println(i);
						Thread.sleep(500);
					}
				}
			catch(Exception e) {}
			}
		};
        th.start();
	}

}
