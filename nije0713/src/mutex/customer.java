package mutex;

import java.util.ArrayList;

public class customer extends Thread { // List 에서 데이터를 26번 꺼내는 스레드
	private shareData shareData;
	
	public customer( shareData shareData) {
		this.shareData = shareData;
	}
	
	public void run() { // 스레드로 수행할 내용을 가지는 메소드
		for(int i=0; i<26; i=i+1) {
			shareData.get();
		}
	}
}
