package method;

public class test01 {


		
		public void whatthesave(){
			for(int i=0; i<3; i=i+1) { 
				
				System.out.println("what the");
			}
		}

		
	  //public void tot(){ // 1부터 10까지 더해서 출력하는 메소드
	  //public int tot(){ // 1부터 10까지 더한 결과를 리턴해주는 메소드
			public int tot(int n){ // 1부터 n까지 더한 결과를 리턴해주는 메소드
			int sum = 0;
			for(int i=1; i<11; i= i+1) {
				sum = sum + i;
			}
		  //System.out.println("합계:" + sum);
			
			return sum; // return 뒤에 어떤 문장도 와서는 안 된다.
			
		}
		
			
		//로그인 처리 메소드
		public boolean login(String id, String pw){
			boolean result = false;
			if(id.equals("root") && pw.equals("123123")){
				result = true;
			}
			return result;
			
		}
		
		
		//회원 탈퇴 메소드 
		/*
		public boolean withdraw(String id, String pw){
			boolean result = false;
			if(id.equals("root") && pw.equals("123123")){
				result = true;
			}
		      return result;
			*/
			
			public static void display() {
				System.out.println("static메소드");
			}
			
			public static void incvalue(int n) { // Call by value
				n = n + 1;
			}
			
			public static void incReference(int[] n) { // Call by reference
				n[0] = n[0] + 1;
			}
			
			//재귀함수만들기
			  //if(중단조건) return 중단했을 떄의 값
			  //else 재귀함수를 호출
			public int sum(int n) {
				if(n==1) {
					return 1; // 중단했을 때의 값
				}
				else {
					return n + sum(n-1); // 재귀조건
					
				}
			}
			
		    
			public int fiboRecursion(int n) { // 재귀
				if(n==1 || n==2) {
					return 1;
				}
				else{
					return fiboRecursion(n-1) + fiboRecursion(n-2);
				}
				
			
				
 }
}

		

