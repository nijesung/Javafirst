package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class ioMain {

	public static void main(String[] args) {
		BufferedReader br = null; // BufferedReader 객체 만들기
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\503-11\\Desktop\\test\\access_log.txt"));

			// 접속한 아이피를 중복 상관없이 저장하기 위한 자료구조
		 //	ArrayList<String> iplist = new ArrayList<>();
		 //	Set<String> ipset = new HashSet<String>(); // 중복 없이 저장하기 위한 Set 설정
			
			HashMap<String, Integer> map = new HashMap<>();
			HashMap<String, Integer> traffic = new HashMap<>();
			
			
			while (true) {
				String line = br.readLine(); // 한 줄 단위로 읽기
				// System.out.println(line); // 데이터를 읽고 있는지 확인

				if (line == null) { // 읽은 데이터가 없으면 종료
					break;
				}
				
				String[] ar = line.split(" "); // 줄 단위로 읽은 데이터를 공백으로 분할하여 첫 번째에 있는 데이터만 출력
			 //	System.out.println(ar[0]);     // 문자열을 분할 할 때는 split 이나 substring 이라는 메소드를 이용
				// iplist.add(ar[0]);          // split 은 문자열이나 패턴을 가지고 분할하고 substring 은 위치를 가지고 분할
			 //	ipset.add(ar[0]);
				Integer count = map.get(ar[0]);
				
				if(count == null) { // 저장된 데이터가 없으면 1을 저장한다
					map.put(ar[0], 1);
				}
				else {
					map.put(ar[0], count + 1); // 저장된 데이터가 있으면 1을 더해서 저장한다
				}
				
				Integer traf = traffic.get(ar[0]);
				if(traf == null) {
					if(!ar[9].equals("\"-\"") && !ar[9].equals("-")){
						traffic.put(ar[0], Integer.parseInt(ar[9]));
					}
				}else {
					if(!ar[9].equals("\"-\"") && !ar[9].equals("-")) {
						traffic.put(ar[0], traf + Integer.parseInt(ar[9]));
					}
				}
				
			

			}
			// System.out.println(iplist);
			// System.out.println(ipset);
			Set<String> keyset = map.keySet(); // 맵의모든 데이터를 출력
			for(String key : keyset) {
				System.out.println(key + ":" + map.get(key));
			}
			
			System.out.println("======================");
			keyset = traffic.keySet();
			for(String key : keyset) {
				System.out.println(key + ":" + traffic.get(key));
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage()); // 문제가 생기면 메시지가 출력된다
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

}
