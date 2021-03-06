// **상속(Inheritance)
// =>상위 클래스의 모든 멤버를 하위 클래스가 물려 받는 것
// 1.하는 이유
// =>중복된 코드를 제거해서 코드를 간결하게 만들고 유지보수를 편리하게 하기 위해서
// =>기존에 제공된 기능에 내용을 추가하고자 해서

// 2.하는 방법
//   클래스 이름 뒤에 extends를 쓰고 상위 클래스 이름을 적어주면 된다.

// 3.private 멤버는 상속은 되는데 하위 클래스에서 접근을 할 수 없다.
//   하위 클래스에서 접근하도록 하기 위해서는 접근 지정자를 protected 나 public으로 변경해야 한다.

// 4.상위 클래스와 하위 클래스에 동일한 이름의 인스턴스 변수를 만들 수는 있지만 이 경우 하위 클래스에서는 
//   상위 클래스의 변수에 접근할 수 없기 때문에 의미가 없습니다.

//  *상속을 받으면*
//   생성자의 첫번째 라인에 상위클래스의 디폴트 생성자를 호출하는 구문이 자동으로 삽입된다.

// *super*
// super는 하위 클래스에서 상위 클래스의 멤버를 사용할 때 붙이는 지시자(포인터)
// 상위 클래스와 하위 클래스에 동일한 이름의 변수나 메소드가 존재하는 경우 하위 클래스에서 이름만 사용하면 자신의 변수나 메소드만 이용 가능
// 이 경우 super. 을 이용하면 상위 클래스의 변수나 메소드를 사용할 수 있다 .
// 예): super(매개변수) : 상위 클래스의 생성자를 호출하는 구문. 생성자에만 사용. "반드시" 첫번째 라인에 와야 한다.
// 다른 클래스로부터 상속을 받으면 생성자의 첫 번째 라인에 상위 클래스의 디폴트 생성자를 호출하는 구문이 자동으로 삽입된다.
// 상위 클래스에 디폴트 생성자가 없으면 상속을 받으면 에러가 발생하게 된다. (상위 클래스에서는 상위 클래스의 디폴트 생성자를 호출하기 때문)
// 이런 경우에는 하위 클래스에 생성자를 만들고 첫 번째 라인에서 super() 를 이용해서 상위 클래스의 생성자를 직접 호출해 주어야 한다.

// *Method Overriding(재정의)*
// 상속관계에 있는 클래스에 동일한 원형의 메소드가 존재하는 경우
// 상위 클래스 타입의 변수에 하위 타입의 인스턴스를 대입할 수 있다
// 오버라이딩 된 메소드는 대입된 인스턴스의 것을 호출한다
// 메소드 원형: 메소드 이름과 매개변수의 자료형과 갯수
// 1. 기능을 추가시키려는 용도
// 2. 이름을 맞추려는 용도

//*참조형 변수간의 대입(객체 지향 언어에서 가장 중요)*
// 변수를 선언할 때 사용한 자료형의 데이터만 대입이 가능
// 객체 지향 언어에서는 예외적으로 상위 클래스 타입의 변수에 하위 클래스 타입의 인스턴스 주소를 대입할 수 있다.
// 상위 클래스 타입이 원하는 모든 것을 하위 클래스 타입의 인스턴스가 줄 수 있기 때문이다.
// 하위 클래스 타입의 변수에 상위 클래스 타입의 인스턴스 주소를 대입할 때는 강제 형 변환을 해야하고 그 결과는 프로그래머가 책임져야 한다.

// *polymorphism(다형성)
//  동일한 메시지에 대하여 다르게 반응하는 성질
//  동일한 코드에 어떤 객체가 대입되었는지에 따라서 다른 메소드를 호출하는 것
//  참조형 사이의 대입과 overriding 을 이용해서 구현한다.
//  참조형 변수는 변수를 선언할 때 사용한 자료형을 가지고 자신의 멤버를 호출하는데 예외적으로 overriding 된 메소드는 선언할 때
//  사용한 자료형을 가지고 호출하는 것이 아니고 대입될 때 사용한 자료형을 가지고 멤버를 호출한다.

package Inheritance;

public class Employee { // 직원 정보를 저장하기 위한 클래스
	

	//	private int num; // 번호를 저장하기 위한 변수 // 상속 해 주고 싶으면 Protected 로 바꿔야 한다.
	//	private String name; // 이름을 저장하기 위한 변수
		
	//	private static int autoincrement;  // num 값을 일련번호로 만들기 위한 공유 변수 - static
	
	    protected int num; // protected 로 바꾸자 은닉되어있던 변수가 공개되었다
	    protected String name;
		
		protected static int autoincrement;
		
		public Employee(int n) { // 생성자 (인스턴스를 만들 때 생성자부터 찾아라)
			autoincrement = autoincrement + 1;
			num = autoincrement;
		}
		
		
		
		public int getNum() { // 인스턴스 변수를 사용할 수 있도록 하기 위한 접근자 메소드(Getters Setters)
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
		@Override // 값을 확인하기 쉽게 하기 위한 메소드 (to String)
		public String toString() {
			return "Employee [num=" + num + ", name=" + name + "]";
		}
		
		
		
		
		
	
		
		
		

}


