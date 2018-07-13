package mutex;

import java.util.ArrayList;

public class producer extends Thread {
	private shareData shareData;
	
	public producer(shareData shareData) {
		this.shareData = shareData;
	
	}
 
	public void run() { // 스레드로 동작할 메소드
		for(int i=0; i<26; i=i+1) {
			shareData.save((char)(65+i)); // 65에 i
	  }
	}

}
