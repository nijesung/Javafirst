package mutex;

public class syncMain {

	public static void main(String[] args) { // 공유 자원을 가진 클래스
		shareData shareData = new shareData();
		
		producer pro = new producer(shareData);
		customer cus = new customer(shareData);
		
		pro.start();
		cus.start();

	}

}
