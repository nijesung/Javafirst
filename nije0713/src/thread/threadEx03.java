package thread;

public class threadEx03 implements Runnable { // Runnable 인터페이스를 구현한 클래스

	@Override
	public void run() {
		String msg = "글루타민산나트륨";
		int idx = 0;
		while(true) {
			String str = "";
			for(int i = 0; i<msg.length(); i = i+1) {
				char ch = msg.charAt((idx+i)%msg.length());
				str = str + ch;
			}
			System.out.println(str);
			
			try {
				Thread.sleep(1000);
				idx = idx + 1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
