package dataStructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class scannerMain {

	public static void main(String[] args) {
		// 키보드로부터 한 줄을 입력받아서 출력
		Scanner sc = new Scanner(System.in);
		
		/*
		System.out.println("이름 입력: "); 
	 //	String msg = sc.nextLine(); // 한 줄을 입력받는 객체
		String msg = sc.next(); // 공백 단위로 구분해서 입력받는 객체. 띄어 쓰기를 해도 끝났다고 생각한다
		System.out.println(msg);
		
		sc.close(); // 스캐너를 사용하면 마지막에 닫아 주어야 한다
		
		// 문자열로부터 받기
		sc = new Scanner("funin Java");
		System.out.println(sc.next()); // 공백 단위로 읽어오는 것을 확인할 수 있다
		System.out.println(sc.next());
		*/
		
		
		File f = new File("C:\\집게벌레.txt"); // File 객체 만들기 // 파일 경로는 역슬래시 2번 씩 "//"
		// 파일은 있는데 내용을 못 읽어내는 경우는 2가지 경우가 있다
		// 구분문자가 없는 경우와 한들 인코딩이 서로 다른 경우이다.
		// 한글 인코딩이 잘못되면 글자가 깨지는 것이 아니고 Scanner가 읽지 못한다.
		// 공백 문자를 찾아야 하는데 인코딩이 다르면 공백문자의 코드 값이 다르기 때문이다.
		
		try {
			sc = new Scanner(f); // File 과 연결되는 스캐너 객체 만들기
			while(sc.hasNext()) { // 데이터가 있을 때 까지 읽기
				System.out.println(sc.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
