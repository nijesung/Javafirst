package byteStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FightMain {

	public static void main(String[] args) {
		// 키보드로부터 줄 단위로 입력을 받을 수 있는 클래스의 참조형 변수 선언
		// final 절 에서 close 를 할 수 있도록 try 밖에서 변수를 선언한다.
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in)); // 키보드로 부터 입력받는 인스턴스 생성
			
			System.out.print("name: ");
			String name = br.readLine(); // 문자열 한 줄을 읽어오기
			
			System.out.print("height: ");
			String height = br.readLine();
			
			System.out.print("reach: ");
			String reach = br.readLine();
			
			
			Fighter figther = new Fighter(); // 3개의 데이터를 하나로 저장하기 위한 인스턴스를 생성
			figther.setName(name);
			figther.setHeight(Integer.parseInt(height)); // 정수로 변환해서 저장
			figther.setReach(Double.parseDouble(reach)); // 실수로 변환해서 저장
			
			Map<String, Object> map = new HashMap<>(); // 맵을 이용해서 저장
			map.put("name", name);
			map.put("height", Integer.parseInt(height));
			map.put("reach", Double.parseDouble(reach));
			
			System.out.println(figther); // 출력할 때는 VO 클래스와 Map 이 별 차이가 없다.
			System.out.println(map);
			
			int r = figther.getHeight() + 1; // 그러나 사용할 때는 다르다. 키를 1씩 더해보자
		//	r = map.get("height") + 1; // map 에서는 데이터를 가져와서 사용할 때 강제 형 변환을 해야 한다.
			r = (Integer)map.get("height") + 1; // 강제 형 변환이 완료되어 예외가 사라진 모습
			
			
			
		} catch(Exception e) {
			System.out.println("exception: " + e.getMessage());
		} finally {
			if(br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		
		
		
	}
}
