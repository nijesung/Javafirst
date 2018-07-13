package dataStructure;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class logMain {

	public static void main(String[] args) {
		// log 파일의 내용을 읽을 수 있는 Scanner 만들기
		File f = new File("C:\\log.txt"); // 읽어낼 파일 인스턴스 만들기
		HashSet<String> set = new HashSet<String>();
		
		try {
			Scanner sc = new Scanner(f); // 파일의 내용을 읽을 Scanner 인스턴스 생성
			// 합계를 저장할 변수를 생성
			int sum = 0;
			
			while(sc.hasNextLine()) { // 읽을 다음 줄이 있을 때 까지 수행
				String temp = sc.nextLine(); // 한 줄 읽기
				
			 //	System.out.println(ar[9]); // 10번째 데이터 확인
				String[]ar = temp.split(" "); // 공백으로 분할하기
				sum = sum + Integer.parseInt(ar[9]); // 10번째 문자열을 정수로 변환해서 sum 에 더하기
				
			}
			System.out.println("트래픽 합계: " + sum);
		    sc.close();
		    }
		catch(Exception e) {
			
		}
	}
}


