package clone;

public class Main {
	
	public static void main(String[]arg) {
		int n = 10; // value 형 변수 생성
		int x = n; // value 형의 데이터를 대입
		
		x = 20;
		
		System.out.println(n); // 예상되는 값은 10 이다.
		
		int[]ar = {10,20,30};
		int[]br = ar;
		br[0] = 1000; // 복사된 주소의 첫번째 데이터를 1000 으로 변경
		System.out.println(ar[0]); // 예상되는 값은 1000 이다.
		
		
		// 참조형을 복사해 줄 때 실제 데이터를 복사해주기
		int[]cr = new int[ar.length]; // 배열을 복사하기 위해 새로운 공간을 생성
		
		for(int i=0; i<ar.length; i= i+1) { // 내부 데이터를 복사
			cr[i] = ar[i];
		}
		cr[0] = 500; // 이번에는 데이터를 복사해서 주었기 때문에 영향을 받지 않는다
		System.out.println(ar[0]);
	}

}
