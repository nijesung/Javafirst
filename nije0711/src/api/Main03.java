package api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class Main03 {

	public static void main(String[] args) {
		
		ArrayList<Integer>list1 = new ArrayList<>(); // 정수 List 와 문자열 List 의 정렬
		list1.add(10);
		list1.add(30);
		list1.add(50);
		
		Comparator<Integer>comp = new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				Integer first = (Integer)o1;
				Integer second = (Integer)o2;
				return first - second;
			}
			
		};
		list1.sort(comp); // List 는 toString 이 재정의 되어 있어서 인스턴스를 출력하면 데이터가 순서대로
		                  // toString 을 호출한다.
		
		LinkedList<String>list2 = new LinkedList<>(); // 정수 List 와 문자열 List 의 정렬
		list2.add("루크 락홀드");
		list2.add("크리스 와이드먼");
		list2.add("파울로 코스타");
		
		Comparator<String>comp2 = new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
			 //	String first = (String)o1; 
			 //	String second = (String)o1;
				String first = (String)o1; // sort 를 반대로 하고 싶을 땐 first 와 second 의 위치를 바꾼다
			 //	String first = (String)o1;
				String second = (String)o1;
				
			 //	return first.compareTo(second); // 문자열은 뺄셈이 되지 않는다
				return second.compareTo(first); // 문자열은 뺄셈이 되지 않는다
			}
			
		};
		list2.sort(comp2);
		System.out.println(list2);
		

	}

}
