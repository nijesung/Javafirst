package ExceptionHandling;

public class Main {

	public static void main(String[] args) {
		try { // 문제가 생길 가능성이 있는 구간을 try 로 묶어 준다
		int i = 10;
		int j = 0;
		int result = i/j;
		System.out.println("결과: " + result);
		}
		catch(Exception e) { // 그후 캐치를 써준다
			}
		
		System.out.println("예외 발생 후 실행"); // 예외 처리를 해주자 문제가 있는 구간을 넘어 실행한다

		
	 //	String str = null; // NullPointerException 예외 발생. 이 부분이 예외의 근원

	 //	str.charAt(10); // 이 부분이 문제가 아닌 null이 무언가를 호출한 것이 문제이다.
		
		
		String[]ar = {"what", "the", "fun"}; // 문자열 배열을 생성
		
		try { // 문제가 발생할 가능성이 높은 곳에 트라이 블럭 시전
		int size = ar.length; // 배열의 데이터를 순회하면서 출력
		
		for(int i = 0; i<=size; i= i+1) { // java.lang.ArrayIndexOutOfBoundsException: 3 예외발생
			                              // size 까지 진행해서 예외가 발생
		//	System.out.println(ar[i]);
		//	System.out.println(Integer.parseInt(ar[i])); // NumberFormatException 예외 발생
			if(i>2) {
				throw new NumberFormatException("강제로 예외 발생.");
			}
		}
		} // 트라이 블록 끝 부분
		
        catch(Exception e) { // 보통은 이렇게 처리
			
			System.out.println(e.getMessage()); // 예외 내용 출력. 가장 많이 쓰는 방법
			e.printStackTrace(); // 예외 내용을 추적
		}
		
	 //	catch(ArrayIndexOutOfBoundsException e) { // 예외가 생겼을 때만 동작
			
	   // System.out.println(e.getMessage()); // 예외 내용 출력. 가장 많이 쓰는 방법
	   // e.printStackTrace(); // 예외 내용을 추적
	   // }
	 //	catch(NumberFormatException e) {
			
	    // System.out.println(e.getMessage());
	    // e.printStackTrace();
	    // }
		
		finally {
			System.out.println("예외 발생 여부에 상관없이 출력"); // 예외 발생 여부와 상관없이 실행
		}
		
		
	}

}
