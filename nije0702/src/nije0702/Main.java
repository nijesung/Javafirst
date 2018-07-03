// local variable (지역 변수).
// 메소드나 제어문 안에서 만들어지는 변수. 자기 영역이 끝나면 메모리에서 제거된다.
// 처음 만들면 데이터가 없어서 없는 것 처럼 간주되다 처음 값을 대입할 때 만들어 진다.
// stack영역- "( )", "{ }" 로 감싼 변수들은 전부 "지역변수" 이다. (일시적인 성질을 가지고 있다). 스택이 끝나면 지워진다.

// instance variable (멤버 변수)
// heap영역 - "인스턴스", "배열" 은 삭제가능한 변수이다. 자신과 링크된 것이 없으면 지워진다. 가비지 컬렉션이 자동으로 지워준다.
// 선언은 클래스 안에서 접근 지정자와 함께 하고 실제 생성은 객체 별로 별도로 소유하는 변수.
// 초기화 하지 않으면 0이나 0.0 또는 false 또는 null로 자동 초기화가 됩니다. 
// 자신의 멤버에 접근 할 때는 "." 을 이용해서 접근합니다.
// 이렇게 클래스 안에 static 없이 만들어진 변수를 instance 변수라고 한다.
// 이 변수들은 객체가 만들어질 때 각 객체마다 별도로 메모리를 할당받는다.

// static variable (정적 변수)
// 클래스 안에서 스태틱 이라는 키워드와 함께 선언하는 변수
// 무조건 1개만 생성된다.
// 한번 만들면 프로그램이 종료될 때 까지 메모리에 유지.
// 여러 곳에서 공유할 목적으로 생성합니다.
// 클래스 이름으로 호출해도 되고 객체 이름으로 호출해도 됩니다.
// 객체 이름으로 호출하면 Eclipse 에서는 경고.

package nije0702;



class Panacea { // Panacea 라는 클래스를 생성    // 생성자 이름은 클래스 이름과 같다. new를 이용해서 호출할 때
	int num;
	String name; 
	String phone;
	
	static String schoolname; // static 변수 - 공유. 기울어진 글씨체가 특징이다.
	                          // static은 하나만 만들어서 공유하기 때문에 누군가가 변경하면 다른 모두에 영향을 미친다.
	                          // 단점은 한번 만들면 절대로 없어지지 않는다. 남용하면 메모리 낭비가 된다.
	
	
}

public class Main {

	public static void main(String[] args) { //클래스와 독립적으로 호출 가능한 메소드 (형식은 정해져있다)
		
		Panacea Panacea1 = new Panacea(); // 인스턴스 2개 생성
		Panacea Panacea2 = new Panacea();
		
		System.out.println("Panacea1:" + Panacea1.num); // 각 인스턴스의 num 값을 출력
		System.out.println("Panacea2:" + Panacea2.num);
		
		Panacea1.num = 1; // Panacea1의 을 1로 변경
		Panacea2.num = 3; // Panacea2의 을 3로 변경
		
		System.out.println("Panacea1:" + Panacea1.num); // 1로 변경 된 것을 확인 가능
		System.out.println("Panacea2:" + Panacea2.num); // 3으로 변경 된 것을 확인 가능
		
		Panacea ins = new Panacea(); //Panacea 라는 클래스의 인스턴스를 생성
		
		System.out.println(ins); //인스턴스 이름을 출력하면 toString()이라는 메소드의 결과가 호출
		                         //보통은 클래스 이름과 해시코드가 출력
		                         //실패하면 null 이라고 나오던지 아니면 예외 발생
		                         //제대로 만들어졌는지 확인하는 일련의 작업이다. 코딩 중간중간에 실행할 것.
		
	  //for(int i=0; i<3; i=i+1) { //++; 를 안 쓰는 이유는 알고리즘에서도 이렇게 쓰기 때문
			                       
	          //System.out.println("what the java");
		
		Panacea.schoolname = "염광중학교"; // 경고 표시가 없다.
		System.out.println("Panacea1:" + Panacea1.schoolname); // 왜 경고 표시가 나는가?
		System.out.println("Panacea2:" + Panacea2.schoolname); // heap영역을 우회했기 때문이다.
		
		
		
		}
		//int k; // 지역변수는 반드시 초기화 해서 사용해야 한다.
		       // i는 제어문 안에서 만들었기 때문에 바깥에서는 사용할 수 없다.
		//System.out.println(k);


	}


