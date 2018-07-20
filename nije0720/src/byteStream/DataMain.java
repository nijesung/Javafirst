package byteStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DataMain {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\503-11\\Desktop\\test\\access_log.txt"));
			
			// 접속한 아이피를 중복 상관없이 저장하기 위한 자료구조
			ArrayList<String> iplist = new ArrayList<>();
			Set<String>ipset = new HashSet<String>(); // 중복 없이 저장하기 위한 Set 설정
			while(true) {
				String line = br.readLine(); // 한 줄 읽기
			 //	System.out.println(line); // 데이터를 읽고 있는지 확인
				
				if(line == null) { // 읽은 데이터가 없으면 종료
					break;
				}
				String [] ar = line.split(" "); // 공백으로 분할
				System.out.println(ar[0]);
			 //	iplist.add(ar[0]);
				ipset.add(ar[0]);
				
		    }
		 //	System.out.println(iplist);
			System.out.println(ipset);
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
