package api;

import java.util.HashMap;
import java.util.Set;

public class mapMain01 {

	public static void main(String[] args) {
		HashMap<String, Object>map = new HashMap<>();
		map.put("name", "독도마뱀");
		map.put("size", 50);
		map.put("kind", "도마뱀과");
		map.put("kind", "독도마뱀과");  // 동일한 키로 다시 저장하면 업데이트가 된다.
		
		// kind 키의 값을 출력하기
		System.out.println(map.get("kinder")); // 없는 키 이름을 사용하면 null 을 리턴한다
		System.out.println(map.get("kind"));
		
		Set<String> keys = map.keySet(); // 모든 데이터 조회 - 저장할 때 사용한 key 를 몰라도 조회가 가능하다
		                                 // 모든 데이터를 Set 으로 저장
		
		for(String key : keys) {
			System.out.println(key + ":" + map.get(key)); // map 에 있던 키의 값이 모두 출력된다
		}

	}

}
