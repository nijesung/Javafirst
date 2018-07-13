package mutex;

import java.util.ArrayList;

public class shareData { // 공유 자원을 가진 클래스
	// 저장 공간을 생성
	public ArrayList<Character> list = new ArrayList<>();
	
	// 데이터를 저장하는 메소드
	public synchronized void save(char ch) {
		list.add(ch);
		System.out.println(ch + " 를 저장했습니다.");
		notifyAll(); // wait 중인 스레드 깨우기
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	// 리스트에서 하나를 꺼내어 출력하는 메소드
	public synchronized void get() {
		if(list.size()==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		char ch = list.remove(0);
		System.out.println(ch + " 를 소비했습니다");
	}
}
