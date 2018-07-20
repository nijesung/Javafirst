package byteStream;

import java.util.Scanner;

public class ScannerMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 키보드로부터 입력받는 Scanner 인스턴스 만들기
		
		System.out.println("int: ");
		int x = sc.nextInt();
	//	String x = sc.nextLine();
	//	System.out.println(x);
		
		System.out.println("name: ");
		String name = sc.nextLine();
		System.out.println(name); // 이름 입력이 되지 않는다
		
		
		sc.close();

	}

}
