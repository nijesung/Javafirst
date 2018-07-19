package swing;

public class Main {

	public static void main(String[] args) {
		Object obj = new Object();
		
		System.out.println(obj.toString()); // obj 인스턴스의 toString 결과 출력
		System.out.println(obj); // 직접 호출하든 인스턴스 이름만 설정하든 결과는 같음을 확인

		Integer i = 100; // toString 의 결과가 저장하고 있는 데이터인 100
		
		System.out.println(i.toString());
		System.out.println(i);
		
		Object str = "what the fun"; // 상위 클래스 타입의 참조형 변수에  하위 클래스 타입의 인스턴스 참조를 대입할 수 있다
		System.out.println(str); // 출력할 때는 형변환 없이 사용해도 된다
		                         // toString() 은 Object 가 가지고 있으므로 호출할 수 있기 때문이다
	//	str = ((String)str);
	//	String imsi = ((String)str); // Obeject 타입의 변수는 출력할 때를 제외하고는 아래처럼 강제 형변환 하여 사용 
	//	for(int j = 0; j<str.length(); j = j+1) {
			
		
		}
	}


