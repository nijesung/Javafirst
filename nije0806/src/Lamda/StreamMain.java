package Lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain {

	public static void main(String[] args) {
		// 문자열 배열을 생성
		String [] ar = {"길앞잡이", "톡토기", "갯강구"};
		
		// 문자열 리스트를 생성
	    List<String> insect = new ArrayList<String>();
	    insect.add("메뚜기");
	    insect.add("개미");
	    insect.add("어리여치");
	    insect.add("파리");
	    
	    // 문자열 배열을 가지고 스트림 만들기
	    Stream<String> stream = Arrays.stream(ar);
	    // 작업 수행
	    stream.forEach(name -> {System.out.println(name);});
	    System.out.println("========================================");
	    
	    // List 를 가지고 스트림 만들기
	    stream = insect.stream();
	    stream.forEach(name -> {System.out.println(insect);});

	}

}
