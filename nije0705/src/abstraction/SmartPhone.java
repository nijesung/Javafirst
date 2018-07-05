// "abstract(추상)*
// abstract class
// class 앞에 abstract 라는 단어를 추가하면 추상 클래스가 된다.
// 추상 클래스는 자신의 인스턴스를 생성할 수 없다.
// 이 클래스는 상속을 통해서만 사용할 수 있다.

// abstract method
// 메소드의 결과형 앞에 abstract 를 추가하면 추상 메소드가 된다.
// 추상 메소드는 내용을 가질 수 없다.
// { } 가 없다.
// 이 메소드는 추상 클래스와 인터페이스만 존재해야 한다.
// 이 메소드가 있는 클래스를 상속하거나 인터페이스를 구현하면 메소드를 반드시 재정의 해야 한다.
// 메뉴의 역할을 한다 - 이 메소드가 반드시 있다라는 보장을 할 수가 있다.

// *final(종단)*
// 1. final 변수: 변수 앞에 final 을 붙이면 이 변수의 값은 변경이 불가능하다.
//    변수를 상수화 할 때 사용한다.
//    JAVA API 에서는 옵션을 나타날 때 주로 이용한다.
//    프로그램을 이해하기 쉽게 만들기 위한 용도로도 많이 사용한다.
//    <final 변수는 관례 상 이름을 모두 대문자로만 구성한다>

// 2. final 메소드: 메소드의 결과형 앞에 final을 붙여서 만들고 이 메소드는 오버라이딩이 불가능하다.
//    오버라이딩 하면 안 된다.

// 3. final 클래스: class 앞에 붙여서 만들고 이 클래스는 상속이 안 된다.
//    상속을 하거나 오버라이딩을 하게 되면 기존 기능을 변경할 수 있다. 그렇기에
//    시스템과 관련된 기능을 수행하는 클래스나 메소드는 기능을 변경하면 안 되므로 상속을 못하게 하거나 재정의를 못하게 한다.

// *interface - Protocol(규칙,규약,약속)
// 추상 메소드와 final 변수만을 가진 Java 객체
// 추상 클래스는 일반 변수나 메소드도 소유할 수 있지만 intherface 는 추상 메소드 만을 소유한다.
// <인터페이스는 다중 상속과는 어떠한 관계도 없다.>
// 선언과 구현을 분리하기 위한 것
// 메소드를 선언할 때 abstract 를 붙이지 않아도 abstract 가 자동 삽입된다.
// 변수를 만들 때 final 을 붙이지 않아도 final 이 자동으로 삽입된다.

// 1. 생성
//    interface 인터페이스 이름{
//    메소드 선언
//    변수 선언  
//    }

// 2. 클래스가 인터페이스를 사용
//    class 클래스이름 extends 상위 클래스 이름 implements 인터페이스 이름 나열 {
//    }
//    인터페이스는 내용이 없기 때문에 상속하는 것이 아니고 구현하는 것이다.
//    인터페이스는 하나의 클래스에 여러 개 implements 할 수있다.

// 3. 인터페이스도 내용이 없기 때문에 인스턴스를 생성할 수 없지만(new 불가) 변수는 선언이 가능하다.
//    클래스 처럼 인터페이스 변수도 자신을 implements 한 클래스의 인스턴스 주소를 대입받을 수 있다.

package abstraction;

// public class SmartPhone { // 안드로이드와 아이폰 클래스의 인스턴스 주소를 하나의 변수에 저장할 수 있도록 하기 위해
	                         // 작성한 클래스 - 인스턴스를 생성할 필요 없음
	
	
public abstract class SmartPhone { // 추상 클래스가 되어 인스턴스를 만들 수 없는 클래스가 되었다
	
	
	
  // public void call () {} // 하위 클래스의 메소드와 오버라이딩 관계를 만들기 위해 생성한 메소드
	
	public abstract void call(); // 추상 메소드: 내용이 없는 메소드로 상속받은 곳에서 반드시 재 정의해야 한다

}
