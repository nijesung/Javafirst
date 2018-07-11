package api;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main02 {

	public static void main(String[] args) {
		ArrayList<Integer>al = new ArrayList<>();
		LinkedList<Integer>li = new LinkedList<>();
		
		al.add(1);
		al.add(3);
		al.add(5);
		
		li.add(1);
		li.add(3);
		li.add(5);
		
		
		long start = System.currentTimeMillis(); // al 에 10만 개를 중간 삽입하는 시간 측정
		for(int i=0; i<100000; i=i+1) {
			al.add(1, 2);
		}
		long end = System.currentTimeMillis(); // 시간 측정하는 방법
		System.out.println("al: " + (end - start));
		
		
		long start1 = System.currentTimeMillis(); // li 에 10만 개를 중간에 삽입하는 시간 측정
		for(int i=0; i<100000; i=i+1) {
			li.add(1, 2);
		}
		long end1 = System.currentTimeMillis(); // 현격한 처리속도 차이가 남을 확인 가능하다
		System.out.println("li: " + (end1 - start1));
		
		
		long start2 = System.currentTimeMillis(); // 읽는 시간 측정
		for(int i=0; i<100000; i=i+1) {
			al.get(i); // i 번 째 데이터 읽기
		}
		long end2 = System.currentTimeMillis();
		System.out.println("ai: " + (end2 - start2));
		
		
		
		long start3 = System.currentTimeMillis();
		for(int i=0; i<100000; i=i+1) {
			li.get(i);
		}
		long end3 = System.currentTimeMillis();
		System.out.println("li: " + (end3 - start3));
		
		

	}

}
