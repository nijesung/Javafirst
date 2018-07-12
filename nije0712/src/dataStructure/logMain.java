package dataStructure;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class logMain {

	public static void main(String[] args) {
		// log 파일의 내용을 읽을 수 있는 Scanner 만들기
		File f = new File("C:\\log.txt");
		HashSet<String> set = new HashSet<String>();
		
		try {
			Scanner sc = new Scanner(f);
			
			while(sc.hasNextLine()) {
				String temp = sc.nextLine();
				
				String[]ar = temp.split(" ");
				set.add(ar[0]);
			}
			System.out.println(set);
		
		    sc.close();
		    }
		catch(Exception e) {
			
		}
	}
}


