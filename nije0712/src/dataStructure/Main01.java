package dataStructure;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

public class Main01 {

	public static void main(String[] args) {
		
	 //	HashMap<String, Object> map = new HashMap<>(); // 계통과 종명 및 크기를 저장하는 Map 을 생성
	 //	LinkedHashMap<String, Object> map = new LinkedHashMap<>(); // 저장한 순서대로 하고 싶으면 Linked 붙이
	    TreeMap<String, Object> map = new TreeMap<>(); // 키의 순서대로 배치
			map.put("kind", "길앞잡이");
			map.put("size", 15);
			map.put("line", "곤충");
			
			System.out.println(map); // 전체를 한꺼번에 출력하고 싶을 때 - toString 이 재정의 되어 있음
			
			System.out.println("========================");
			
			Set<String> keys = map.keySet(); // 순서에 상관없이 항목별로 출력
			for(String key: keys) {
				System.out.println(key + ": " + map.get(key));
			}
		

	}

}
