package arraytest;

public class array {

	public static void main(String[] args) {
		
		int max = 0;
		int j = 0;
		int [] ar = {10,20,30,40,50};
		
		for(int i=0; i < ar.length; i=i+1) {
			if(ar[max] < ar[i]){ // 최대값을 구한다
			    max = i; // 최대 값이 있는 자리 i를 max 변수에 저장
			    j = i; // 최대 값이 들어있는 자리를 가리키는 수 i를 j에 저장
			   
			  System.out.println("최대 값은 "+ar[max]); // max에 저장된 수는 최대값이 있는 자리의 수를 의미하기 때문에 ar[max]는 최대값을 출력한다.
			  System.out.println("출력된 값은 " + (j+1) + "번째 숫자 입니다.");


		}
		}
	}
}

	


