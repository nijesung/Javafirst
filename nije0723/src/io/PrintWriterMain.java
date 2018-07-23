package io;

import java.io.PrintWriter;

public class PrintWriterMain {

	public static void main(String[] args) {
		// 파일, 네트워크, 데이터베이스 관련 클래스들은 예외처리를 강제하는 특성이 있다
		
		PrintWriter pw = null;
		try {
			
			pw = new PrintWriter("C:\\Users\\503-11\\Desktop\\test\\filetest.txt"); // 지정한 경로에 파일을 생성
			pw.println("what the fun"); // 파일에 문자열을 기록
			pw.flush(); // 마지막에 버퍼의 내용을 모두 출력
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pw != null) {
				pw.close();
			}
		}

		
		
		
		
		
		
		
		
	}
}
