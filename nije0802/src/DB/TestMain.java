package DB;

public class TestMain {

	public static void main(String[] args) {
	 //	T obj1 = new T(); // 생성자를 이용해서 객체를 생성
	 //	T obj2 = new T();
		
	 //	System.out.println(obj1.hashCode()); // 해시코드 출력(기존의 방법)
	 //	System.out.println(obj2.hashCode());
		
		
		T obj1 = T.getInstance(); // 싱글톤 패턴을 적용할 클래스의 객체 만들기
		T obj2 = T.getInstance();
		
		System.out.println(System.identityHashCode(obj1)); // 이방법이더조은거
		System.out.println(System.identityHashCode(obj2));
		
		int a = 10; // 두 상수의 저장공간은 똑같다, 해시코드를 출력 해보면 확인 가능하다.
		int b = 10;
		
		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(b));
		

	}

}
