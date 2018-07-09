// 1	*      1 - 1 = 1 * i = i // 시작과 끝나는 규칙을 파악한다
// 2	**     1 - 2
// 3	***    1 - 3
// 4	****   1 - 4
// 5	*****  1 - 5
	
// 1	*          1 - 2  =  2 * i
// 2	***        1 - 3
// 3	*****      1 - 5
// 4	*******    1 - 7
// 5	*********  1 - 9
	
// 1	*     1 - 1 // 규칙이 없으니 if 문으로 분할해서 해결  = 1 - i
// 2	**    1 - 2
// 3	***   1 - 3
// 4	**    1 - 2
// 5	*     1 - 1 // 6 - i

// 0 - 중복검사 필요 없음
// 1 - 0-0  (1 * i - 1)
// 2 - 0-1
// 3 - 0-2
// 4 - 0-3
// 5 - 0-4

package clone;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		User user1 = new User();
		user1.setNum(1);
		user1.setName("곤충");
		String[]insect = {"길앞잡이, 곱등이"};
		user1.setInsect(insect); // toString 을 호출해서 내부 내용을 확인하는 작업
		
		System.out.println(user1);
		
		User user2 = user1; // user1 의 데이터가 저장된 곳의 주소를 user 에 복사
		user2.setNum(2);
		
		System.out.println(user1);
		
		User user3 = user1.clone();
		user3.setNum(3);
		user3.setName("영원류");
		user3.getInsect()[0] = "레오파드게코";
		System.out.println(user1);
		System.out.println(user3);
		
		/*
		int x = -1;
		Scanner sc = new Scanner(System.in);
		while(true) { // 무한 반복문을 만든다
			System.out.println("정수를 입력하시오");
			String temp = sc.nextLine();
			try {
			x = Integer.parseInt(temp); // 정수를 문자열로 변환하기 위한 작업
			break; // 정상적인 상황일 때는 브레이크로 끝내야 한다
			}
			catch(Exception e) {
				System.out.println("유효한 입력이 아닙니다. 정수를 입력하시오");
			}
			
		}
		System.out.println(x);
		sc.close();
		*/
		
		// 1~45 까지 중복되지 않는 6개의 정수 저장하는 프로그램
		int[] sixnum = new int [6]; // 배열 생성
		int size = sixnum.length; // 배열의 길이 설정
		
		Scanner sc = new Scanner(System.in); // 데이터를 입력받을 스캐너 객체 생성
		int i;
		int j = 0;
		for(i=0; i<size; i=i+1) {
			try {
				System.out.println("1~45 사이의 정수를 입력하시오");
				String temp = sc.nextLine();
				sixnum[i] = Integer.parseInt(temp);
				if(!(sixnum[i] >=1 && sixnum[i] <=45)) // 1~45사이의 숫자인지 아닌지 판별
				  // sixnum[i] = < 1 || sixnum[i] > 45; // 도 가능하다
				  {
					System.out.println("유효한 입력이 아닙니다. 1~45 사이의 정수를 입력하시오");
					i=i-1;
				 // continue;
					for(j=0; j<=i-1; j=j+1) {
						if(sixnum[i] == sixnum[j]) { // 이전 데이터와 방금 입력받은 데이터가 같으면 반복문 종료
							break;
						}
					}
				  
					if(j != i ) { // 이전 데이터와 방금 입력된 데이터가 동일하면
						System.out.println("동일한 데이터는 허용하지 않습니다.");
						i = i - 1;
						continue;
					}
				 }
		    }
			catch(Exception e) {
				System.out.println("유효한 입력이 아닙니다. 정수를 입력하시오");
				i = i - 1; // 유효한 값이 아닐 때 무효 처리
			}
			
		
		sc.close(); // 스캐너 객체 닫기
		}
	
	}
	
}
