package byteStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StringBuilderMain {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\503-11\\Desktop\\test\\access_log.txt"));
			
			StringBuilder sb = new StringBuilder();
			
			while(true) {
				String line = br.readLine(); // 한 줄 읽기
				
				if(line == null) { // 읽은 데이터가 없으면 종료
					break;
				}
				sb.append(line); // 읽은 데이터가 있으면 sb에 추가
			}
			
			String content = sb.toString(); // 읽은 내용을 String 에 저장하기
			
			sb = null; // 메모리 정리를 위한 처리
			System.out.println(content);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

}
