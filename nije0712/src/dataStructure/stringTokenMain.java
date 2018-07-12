package dataStructure;

import java.util.StringTokenizer;

public class stringTokenMain {

	public static void main(String[] args) {
		String msg = "msg 는 먹어도 유해한 물질이다. "; // msg 를 공백단위로 분할 해서 출력
		                                        
		String [] ar = msg.split(" "); // 1. Split 메소드 이용
		for(String token : ar) {
			System.out.println(token);
		}
		System.out.println("=================");
		
		StringTokenizer st = new StringTokenizer(msg," "); // 2. StringTokenizer 메소드 이용
		                                                   // 값이 잘 안 나오는 경우 역슬래시 // 2회
		while(st.hasMoreElements()) {
			System.out.println(st.nextElement());
		}
		
		String data = "500,100,1000,2000"; // data 를 , 단위로 분할해서 합계를 구하기
		
		String [] tokens = data.split(",");
		int sum = 0;
		for(String token : tokens) {
			sum = sum + Integer.parseInt(token); // 잘라진 토큰을 정수로 변환해서 더하기
		}
		System.out.println("합계: " + sum);

	}

}
