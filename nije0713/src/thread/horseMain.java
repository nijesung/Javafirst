package thread;

public class horseMain {

	public static void main(String[] args) {
		horse 땅강아지 = new horse();
		horse 길앞잡이 = new horse();
		horse 조랑말 = new horse();
		horse 당나귀 = new horse();
		horse 노새 = new horse();
		horse 얼룩말 = new horse();
		
		땅강아지.start();
		길앞잡이.start();
		조랑말.start();
		당나귀.start();
		노새.start();
		얼룩말.start();
		
	}

}
