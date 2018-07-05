package Innerclass;

public class Outer {
	/*	class Inner { // 일반 inner class : 클래스 안에 존재하는 클래스
		
	}

}

class Foreign {
  // Inner Inner = new Inner(); // 에러 발생
}*/

	

	
	
 //	class Inner { // static inner class : 내부 클래스 안에 static 멤버가 있으면 일반 inner class 는 에러를 
		          // 발생시킨다. 이 때는 class 앞에 static 을 붙여 주어야 한다.
/*	static class Inner { // static 을 class 앞에 붙여주자 에러가 해결된 모습
		static int n;
	}
	*/
	
	
	
	public void sample() { // local inner class: 메소드 안에 만드는 클래스. 메소드가 호출되어 실행될 때 만들어졌다가 
		                   //                    없어지는 클래스이다.
		                   //                    클래스가 메소드를 호출할 때만 존재하기 때문에 메모리 효율을 높일 수도
		
	}
	
	
}







