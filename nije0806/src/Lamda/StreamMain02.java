package Lamda;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMain02 {

	public static void main(String[] args) {
		// 문자열 배열을 생성
	    String [] ar = {"장티푸스", "뇌일혈", "교모세포종", "췌장암", "파타우증후군", 
	    		"교모세포종","대동맥류", "헌팅턴무도병"};
	    // 스트림 변환
	    Stream<String> stream = Arrays.stream(ar);
	    
	    // 모든 데이터 출력
	 // stream.forEach(name -> {System.out.println(name);});
	    
	    // 중복 제거
	 // stream.distinct().forEach(name -> {System.out.println(name);});
	 // stream.distinct().skip(2).limit(3).forEach(name -> {System.out.println(name);});
	    
	    // 뇌로 시작하는 데이터만 찾아서 출력
	    // retrun 문장 하나 밖에 없을 때는 return 이라는 단어를 생략가능
	    // 수행되는 코드가 한줄 일 때는 {} 생략 가능
	 // stream.filter(name -> name.startsWith("뇌"))
	 // .forEach(name -> System.out.println(name));
	    
	    // 3글자인 단어를 제외하고 출력
	    stream.filter(name -> name.length() != 3)
	    .forEach(name -> System.out.println(name));

	}

}
