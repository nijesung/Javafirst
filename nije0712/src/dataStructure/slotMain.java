package dataStructure;

import java.util.ArrayList;
import java.util.Random;

public class slotMain {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("!");
		list.add("@");
		list.add("#");
		list.add("$");
		list.add("%");
		list.add("^");
		list.add("&");
		list.add("*");

		String slot =""; // 문자열을 초기화한다. newString 보다 편하다
		Random r = new Random(); // list 에 있는 모양 3개를 랜덤하게 추출해서 slot 에 추가
		
		for(int i=0; i<3; i=i+1) {
			slot = slot + list.get(r.nextInt(list.size()));
		}
		System.out.println(slot);
		// 3개의 문자가 동일한 지 확인
		if(slot.charAt(0) == slot.charAt(1) && slot.charAt(1) == slot.charAt(2)) {
			System.out.println(slot.charAt(0) + "이 3개");
		}
		// 앞의 2개 문제만 동일한지 확인
		else if(slot.charAt(0) == slot.charAt(1)) {
			System.out.println(slot.charAt(0) + "이 2개");
		}
		// 그 이외의 경우
		else {
			System.out.println("탈락입니다. go home");
		}
		
	}

}
