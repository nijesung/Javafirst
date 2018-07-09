package clone;

import java.io.IOException;

public class main3 {

	public static void main(String[] args) {
		/*
		long start = System.currentTimeMillis(); // 작업시간 확인
		
		for(int i=0; i<1000000; i=i+1) {
			System.out.println("halo");
		}
		long end = System.currentTimeMillis();
		System.out.println("작업시간: " + (end-start));
		*/
		
		// 환경변수 확인
		System.out.println(System.getenv("path"));
		
		// 시스템 속성 확인
		System.out.println(System.getProperty("java.version"));
		
		Runtime r = Runtime.getRuntime();
		try {
			// 앞에는 프로그램 이름 뒤에는 매개변수를 입력해 프로그램을 실행시킬 수 있다. 이 경우에는 한글 실행
			r.exec("\"C:\\Program Files (x86)\\Hnc\\Hwp80\\Hwp.exe\""); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
