package Lamda;

import java.util.ArrayList;
import java.util.List;

interface T{
    public void method(int n);
}

interface V{
public int add(int n1, int n2);
}

public class LamdaMain {
	
/*
	public static void main(String[] args) {
		T ob1 = (n) ->{
			System.out.println("n:" + n);
		};
		
		ob1.method(10);

	}
	*/
	
	public static void main(String[] args) {
		V ob2 = (n1, n2) ->{
			return n1 + n2;
		};
		
		System.out.println(ob2.add(100,3000));
		
		// 배열은 [인덱스]를 통해서 각각의 데이터에 접근한다
		int [] ar = {10, 30, 20};
		
	 //	for(int i=0; i<ar.length; i=i+1) {
	//  ar 의 모든 요소를 temp 에 대입해서 하나씩 수행한다.
		for(int temp : ar) {	// Iterator 방식
		 //	System.out.println(ar[i]);
			System.out.println(temp);
		}
		System.out.println("==================================");
		
		// List 는 get(인덱스)를 통해서 각각의 데이터에 접근한다.
		List<Integer> list = new ArrayList<>();
		list.add(30);
		list.add(70);
		list.add(40);
		
	 //	for(int i=0; i<list.size(); i=i+1) {
		for(int temp : list) {	
		 //	System.out.println(list.get(i));
			System.out.println(temp);
		}

	}
}
