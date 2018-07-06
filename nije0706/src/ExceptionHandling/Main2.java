package ExceptionHandling;

public class Main2 {


	public static void main(String[] args) throws Exception {
		
	 // public static void main(String[] args) throws Exception { // 운영체제에 예외처리 떠 맡기기
			// java.lang.Thread 라는 클래스에는 sleep 이라는 메소드가 있는데
		// 이 메소드에는 매개변수로 대입된 시간만큼 실행을 중지 시키는 역할을 한다.
		// 이 메소드를 이용해서 1~10까지를 1초씩 쉬면서 출력
		/*
		for(int i=1; i<11; i=i+1) { // 1부터 10까지 출력 시키는 메소드
			System.out.println(i);
			try {
				Thread.sleep(1000); // InterruptedException 을 핸들링하지 않아 예외가 발생
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		*/
		
		
		/*
		int idx = 0;
		for(;;) { // 0, 1, 2 를 1초마다 번갈아가면서 무한 반복해서 출력하는 로직을 작성
			System.out.println("image" + (idx % 3) + ".png");
			try {
				Thread.sleep(1000); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			idx = idx + 1;
			*/
		
		
		String [] ar = {"what", "the", "fun", "jesus"}; 
		int size = ar.length; // what, the, fun, jesus 을 번갈아 가면서 무한 반복해서 출력하는 로직을 작성
		int idx = 0;
		
		while(true){
			System.out.println(ar[idx % size]);
			idx = idx + 1;
			try {
				Thread.sleep(1000); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		    
		}
	}
}
			

				
	   
    
  

