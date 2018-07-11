package api;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
	//	Vector<String> vector = new Vector<String>(); 
	//	ArrayList<String> arrayList = new ArrayList<>();  // 문자열을 저장할 수 있는 ArrayList 생성
		LinkedList<String> arrayList = new LinkedList<>();  // 문자열을 저장할 수 있는LinkedList 생성
		
		arrayList.add("장구애비"); // 데이터를 삽입
		arrayList.add("장수풍뎅이");
		arrayList.add("소금쟁이");
		
		System.out.println("데이터 갯수: " + arrayList.size()); // 데이터 갯수
		
		for(String temp : arrayList) {
			System.out.println(temp); // 전체 데이터 출렭
		}
		System.out.println(arrayList);
		
		
	}

}
