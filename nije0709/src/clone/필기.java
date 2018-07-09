// **참조형 데이터의 복사
// 참조형 데이터를 = 를 이용해서 복사를 하게 되면 데이터가 저장된 곳의 주소를 복사하게 된다.
// = 를 이용해서 복사를 한 경우 어느 한 곳에서 내부 데이터를 변경하면 다른 쪽에도 영향을 미치게 된다.
// 영향을 미치치 못하도록 하려면 새로운 데이터 영역을 생성해서 내부 데이터를 복사해주는 방법을 사용해야 한다.
// 자바에서는 이런 역할을 수행하는 메소드의 이름을 clone 이라고 부를 것을 권고한다.
// 응용 프로그램을 만들 때 데이터를 읽어내는 부분에 clone 을 사용해야 한다.
// 원본을 유지한 상태에서 복제된 데이터를 가지고 작업을 수행하다가 작업이 완료되면 복제된 데이터를 원본화 시키는 작업을 반복한다.

// **Wrapper Class
// value 형을 reference 형으로 사용하기 위한 클래스이다.
// 인스턴스(객체) 만드는 방법
// 1. 생성자 이용
//    # new 생성자(값) 예): Integer i = new Integer(10);
// 2. 문자열 이용
//    # 클래스이름.parse 클래스("문자열") 예): Integer.parse int("10)
// 3. 오토 박싱 이용
//    value 형의 데이터를 자동으로 reference 형으로 변환해 주는 것
//    예): Integer i = 10
// *숫자 관련 클래스
// java.math Big Integer
// java.math Big decimal
// 문자열로 데이터(숫자) 저장 - 큰 수와 정밀한 수를 다루기 위해 추가

// **java.lang.System
// public final class System extends Object
// =>Object 클래스로부터 상속받았고 상속할 수 없는(final) 클래스

// =>시스템 관련 클래스

// 1.Field Summary
// 1)err: 표준 에러 스트림 - 이 필드를 이용해서 print를 호출하면 빨간색으로 콘솔창에 출력됩니다.

// 2)in: 표준 입력 스트림 - 표준 입력 장치를 가리키는 필드
// 보통은 키보드입니다.

// 3)out: 표준 출력 스트림 - 표준 출력 장치를 가리키는 필드
// 보통은 모니터입니다.

// 2.Constructor(생성자) 가 없습니다.
// =>모든 메소드가 static이기 때문에 인스턴스를 생성할 필요가 없어서 private으로 숨겨두었습니다.

// 3.주요 메소드
// static long currentTimeMillis(): 현재 시간을 1/1000초 단위의 정수로 리턴해주는 메소드입니다.
// 1970년 1월 1일 자정 이후 지나온 시간 : epoch time

// static void exit(int status): JVM 종료 하는 메소드 - 자바 프로그램 종료
// 매개변수로 대입하는 정수는 시스템 오류 코드입니다.
// 0이면 정상 종료

// static String getEnv(생략하거나 환경변수이름): 환경 변수 값 가져오기 
// static String getProperty(프로퍼티 이름): 프로퍼티 이름에 해당하는 속성 값 가져오기 - os.name, user.name, 
//                                       user.home, java.home, java.version

// **java.lang.Class
// 클래스에 대한 정보를 저장한 클래스
// 인스턴스의 getClass()를 호출하면 Class 타입의 인스턴스를 리턴한다.

// java.lang.Math
// 수학 관련 클래스
// 모든 멤버가 static 이기 때문에 인스턴스 생성이 필요 없어 생성자는 private 로 숨겨져 있다.
// 운영체제에 따라 다르게 동작하는데 이에 대한 보완으로 StrictMath 라는 클래스를 제공한다.
// PI 라는  field 와 random() 이라는 메소드를 자주 사용한다.

// **java.lang.Runtime
// 프로세스 실행과 관련된 클래스
// 생성자가 private 이다.
// 추상 클래스도 아니고 모든 멤버가 static 도 아니다.
// 이 클래스의 인스턴스는 getRuntime()이라는 static 메소드로 생성한다.
// 인스턴스 생성을 자신의 생성자를 이용하지 않고 static 메소드로 만드는 경우는 싱글톤 패턴의 클래스이다.
// 싱글톤 패턴은 인스턴스를 1개만 생성하는 클래스이다.

// exec("프로그램이름 매개변수")
// 프로그램을 매개변수와 함께 실행한다.
// 매개변수를 대입하지 않으면 프로그램만 실행된다.

// #어떤 클래스의 Constructor 가 없는데 static 이 아닌 메소드가 존재하는 경우 자기 자신을 리턴하는 static 메소드가 있는지
// 확인해 봐야 한다. 만약 없다면 "클래스이름Factory" 클래스가 있는지 확인해야 한다.

// *String 클래스
// 변하지 않는 문자열을 저장하는 클래스
// 1. 인스턴스 생성
// 1-1. 문자열 상수 대입: "what"
// 1-2. 디폴트 생성자: new String()
// 1-3. 문자열을 대입해서 생성하는 생성자: new String("문자열")
// 1-4. 바이트 배열을 가지고 만드는 생성자: new String(btye[])
// 1-5. 바이트 배열과 인코딩을 이용해서 만드는 생성자: new String(byte[],String encType)

// 2. 주요 메소드
// char charAt(index idx): idx 번 째 문자를 리턴
// int length(): 문자열의 개수를 리턴
// byte [] getByte(): 문자열을 바이트 배열로 리턴
// byte [] getByte(String encType): 문자열을 인코딩 방식에 맞는 바이트 배열로 리턴

// 3. + 연산자
// 문자열이나 숫자 또는 boolean 과 사용하면 결합을 해 준다.
// 사용할 때 조심해야 한다. String 은 변할 수 없는 문자열을 저장하기 때문에  + 로 결합하면 이전 내용을 복사해서 새로운 공간에서 작업을
// 하기 때문이다. 주소가 지워지지 않기 때문이다(공간 낭비).

package clone;

public class 필기 {

}
