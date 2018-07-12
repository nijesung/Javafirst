package dataStructure;

import java.util.HashMap;

public class mapMain03 {

	public static void main(String[] args) {
		// 계통분류 명단을 배열로 만들기
		String[]Insect = {"길앞잡이","나방","파리","사슴벌레"};
		String[]Arthropoda  = {"지네","거미","노래기"};
		String[]Newts = {"게코","개구리","올름"};
		String[]Collembola = {"톡토기"}; // 계통을 추가해도 출력하는 부분은 고치지 않아도 된다. 즉 유지보수에 유리
		
		// 동일한 의미를 갖는 배열들을 묶을 때 바로 배열이나 리스트로 묶는 것은 바람직하지 않다
		// 배열이나 리스트는 인덱스를 가지고 구분하기 때문에 의미를 부여하는 것이 불가능하다
		// 배열이나 리스트를 다시 배열이나 리스트로 묶을 때는 먼저 Map 으로 의미를 부여해 묶은 다음 다시 배열이나 리스트로 묶어야 한다
		
		HashMap <String, Object> map1 = new HashMap<>();
		map1.put("line", "Insect");
		map1.put("data", Insect);
		
		HashMap <String, Object> map2 = new HashMap<>();
		map2.put("line", "Arthropoda");
		map2.put("data", Arthropoda);
		
		HashMap <String, Object> map3 = new HashMap<>();
		map3.put("line", "Newts");
		map3.put("data", Newts);
		
		HashMap <String, Object> map4 = new HashMap<>();
		map4.put("line", "Collembola");
		map4.put("data", Collembola);
		
		HashMap [] lines = {map1, map2, map3, map4};
		
		for(int i = 0; i< lines.length; i = i+1) {
			HashMap temp = lines[i];
			System.out.println(temp.get("line")); // 계통 이름 출력
			String [] in = (String[])temp.get("data"); // 종명 명단 가져오기
			                                           // 저장을 하거나 사용을 할 때는 원래의 자료형으로 강제 형
			                                           // 변환을 해서 사용해야 한다
			for(int j = 0; j < in.length; j = j+1) {
				System.out.print(in[j] + "\t");
			}
			System.out.println("");
		}

	}

}
