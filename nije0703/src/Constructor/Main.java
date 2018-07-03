package Constructor;

public class Main {

	public static void main(String[] args) {
		Practice practice1= new Practice(); // practice 클래스의 인스턴스 생성
	  //practice1.setName("noname:");
		System.out.println(practice1.getName());
		
		Practice practice2= new Practice();
	  //practice2.setName("noname:");
		System.out.println(practice2.getName());
		
		Practice practice3= new Practice("sung"); // 내가 준 이름으로 네임을 설정
		System.out.println(practice3.getName());
		
		String str = "i am grute";
		int r = str.lastIndexOf("gru");
		System.out.println(r); // 몇 번째에 있는지 출력한다
		
		r = str.length();
		System.out.println(r); // 문자열의 길이를 출력한다

	}
 
}
