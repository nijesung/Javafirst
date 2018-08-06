// **Procedure
// 한번에 수행되는 코드 블럭
// Function, Method 와 동일한 개념이다.
// 리턴이 있는 구조를 Function, 리턴이 없는 구조는 Procedure
// 데이터베이스 에서는 자주 사용하는 SQL 구문을 하나의 이름으로 만들어 두고 사용하는 것을 의미

// Oracle 에서의 형식
// Create or Replace procedure xxx
// (변수명 자료형)
//        -> 테이블이름.컬럼이름%Type
// is
// 지역변수
// begin
// 수행할 구문;
// end;
// /

// ex)
// Create or Replace procedure insertDeptProc
// (vdeptno dept.deptno%TYPE,
// (vdname dept.dname%TYPE,
// (vloc detp.loc%TYPE)
// is
// begin
// insert into dept(deptno, dname, loc)
// values(vdeptno, vdname, vloc);
// end;
// /

// Java 에서의 형식
// Callable Statement 로 프로시저 실행
// {call 프로시저이름(; ...)}

// # 삭제는 Primary key 를 조건으로 해서 삭제

// **Java 에서의 프로시저 연동
// 1. Procedure
//    프로그램 에서는 한번에 수행되어야 하는 코드 블럭을 의미하는데 함수나 메소드와 유사한 개념이다.
//    데이터베이스 에서는 자주 사용하는 SQL 구문을 하나의 이름으로 묶어서 사용할 수 있도록 해주는 개체로 한 번 호출되면 메모리에 상주한다.
//    데이터베이스 에서는 보안과 속도 때문에 사용한다.

// 2. Oracle 에서의 프로시저 생성과 실행
// 2-1. 생성
//      Create or Replace procedure 프로시저이름
//      (매개변수명 자료형)
//                -> 테이블이름.컬럼이름%Type
//      is
//      지역변수 선언
//      begin
//      수행할 SQL 구문;
//      end;
//      /
// 2-2. 실행
//      execute 프로시저이름(매개변수);

// 3. Java 에서의 데이터베이스 연동
// 3-1. 프로젝트 build path 에 데이터베이스 드라이버 파일을 추가
// 3-2. 사용할 데이터베이스 드라이버 클래스 로드
//      Class.forName("드라이버 클래스 이름")
// 3-3. Connection 객체를 생성
//      DriberManager.getConnection("데이터베이스 URL", "계정", "비밀번호");
// 3-4. Statement 객체를 생성
//      Connection객체.prepareStatement 또는 prepareCall
// 3-5. sql 에 물음표가 있으면 데이터 바인딩
//      Statememt객체.set자료형(물음표 번호,실제 데이터);
// 3-6. sql 실행
//      select 가 아닌 구문
//      int 변수명 = Statement객체.executeUpdate()
//      select 구문
//      ResultSet 변수명 = Statement객체.executeQuery()
// 3-7. 결과 사용
//      select 가 아닌 경우는 영향받은 행의 개수를 리턴하고 select 의 경우는 결과 셋이다.
//      next() 와 get자료형(select 절에서의 번호 또는 "컬럼이름") 을 이용해서 결과를 사용한다.
// 3-8. 사용한 객체 닫기
//      

// 4. Java 에서의 Oracle 프로시저 실행
// 4-1. PreparedStatement 대신에 CallableStatement 클래스 이용
//      Connection객체.prepareCall("{call 프로시저이름(매개변수만큼 ?)}");
//      물음표에서 값 바인딩
//      executeUpdate 나 executeQuery 호출

// ex) 삭제 프로시저 실행

// **람다(lamda) 식
// java 에서 함수적 프로그래밍을 적용하기 위해 1.8버전에서 추가한 문법
// 람다는 이름없는 함수를 만들기 위한 문법이다.
// java 에서는 하나의 추상 메소드만을 가진 인터페이스의 익명 객체를 만들 때 사용할 수 있다.
// 람다 메소드 구현
// (매개변수)->{
// 수행할 내용
// return
// }

// Thread 인터페이스: Runnable 인터페이스
// 이 인터페이스는 public void run() 이라는 추상 메소드만을 소유하고 있다.
// 스레드를 만들기 위해서는 인터페이스를 implements 하는 클래스를 만들고 인스턴스를 만들어서 사용하거나 anonymous class
// 를 만들어서 사용하는 방법이 있다.
// 추상 메소드가 1개라면 람다를 이용할 수도 있다.

// 1. 스레드 만들기
//    별도의 클래스를 만들어서 사용하는 방법

// 2. 클래스를 만들지 않고 Thread 객체를 만들어 사용
//    anonymous class 만들기

// 3. 람다를 이용한 스레드
//    Runnable 인터페이스에는 메소드가 1개만 존재한다.
//    1개의 메소드만 소유한 인터페이스를 상속받고자 하는 경우에는 람다를 이용할 수 있다.
//    () -> {
//             내용
//          }
// 메소드 이름을 기재하지 않기 때문에 인터페이스에 메소드가 1개만 존재해야 한다.

// 4. 매개변수가 있는 메소드 구현
//    매개변수의 자료형은 기재할 필요가 없다.
//    매개변수가 하나일 때는 () 를 생략해도 된다.

// ex) 아래와 같은 인터페이스가 있는 경우
//     interface T{
//                public void method(int n);
//                }

// 5. return 타입이 있는 메소드
//    메소드 내에서 타입에 해당하는 데이터만 리턴하면 된다.
//     interface V{
//                public int add(int n1, int n2);
//                }

// 6. 직접 인터페이스를 만들어서 람다를 사용할 일은 거의 없다.
//    스트림 API 를 사용할 때 스트림 API 의 많은 메소드들이 이미 만들어져 있는 인터페이스의 객체를 매개변수로 
//    대입해야 동작하는 경우가 많다. 이 때 익명 클래스를 사용하는 것 보다는 람다 형식을 사용하는 것을 권장한다.
//    안드로이드 스튜디오 에서는 메소드가 1개 뿐인 인터페이스의 익명 클래스를 코드 최적화를 위해 람다 코드로 변경을 한다.

// 7. 표준 API 람다 인터페이스
// 7-1. Consumer 인터페이스
//      매개변수는 있고 리턴 값은 없는 메소드 소유
// 7-2. Supplier
//      매개변수는 없고 리턴 값만 있는 메소드 소유
// 7-3. Function
//      매개변수도 있고 리턴 값도 있는 메소드 소유 - 대부분 가공해서 리턴
// 7-4. Operator
//      매개변수가 있고 리턴 값도 있다 - 연산해서 리턴
// 7-5. Predicate
//      매개변수가 있고 리턴 값이 boolean - 필터링 할 때 사용

// **Stream API
// 컬렉션(배열, List, Set, 다른 언어에서는 문자열과 Map 도 컬렉션으로 취급) 의 데이터를 접근하는 로직과 작업을 수행하는 로직을
// 하나의 구문으로 처리할 수 있도록 해주는 API 로 1.8 버전에서 추가된 API
// 작업을 처리하는 로직은 람다를 이용해서 대입하는 것을 권장
// 컬렉션의 데이터를 반복문을 이용해서 접근하는 것 보다 간결하게 작성할 수 있고 병렬처리가 쉽다.

// 1. 스트림의 특징
//    컬렉션의 모든 데이터를 접근하는 방법이 동일하다.
//    반복문을 메소드의 내부에 숨기기 때문에 반복문을 잘못 작성하는 경우가 없다.
//    원본 데이터를 변경하지 않는다.
//    1회용 이기 때문에 한 번 사용하고 나서 다시 사용할 때에는 재생성해야 한다.

// 2. 스트림 생성
//    List 나 Set 은 stream() 이나 parellelStream() 이라는 인스턴스 메소드로 생성 가능
//    배열은 Array.stream 이라는 메소드의 매개변수로 배열을 대입해서 생성

// ex) 배열과 List 를 스트림으로 만들어 데이터를 전부 출력하자

// 3. 중간 처리 메소드
//    스트림의 데이터를 변경하거나 조건에 맞는 데이터만 골라내기 위한 작업
//    skip(정수): 정수 만큼 넘어가기
//    limit(정수): 정수 만큼만 가져오기
//    distinct(): 동일한 데이터를 제거하고 가져오는데 equals 메소드를 이용한다.
//    filter(): 매개변수가 1개이고 boolean 을 리턴하는 람다 식을 대입하면 람다 식이 true 를 리턴하는 데이터만 가져온다.
//    중간처리 메소드는

// mapTo자료형(클래스이름::getter 메소드)
// 인스턴스의 getter 메소드의 값으로 인스턴스가 대체

// ex) String msg = "hello"
//     mapToString(String::toUpperCase) : toUpperCase 메소드의 값으로 변경

// ex) 이름, 성별, 점수, 학과, 나이를 갖는 VO 클래스를 생성
//     이름은 문자열
//     성별은 남자, 여자를 저장할 수 있는 문자열
//     정수는 정수
//     학과는 문자열
//     나이는 정수

// sorted(), sorted((매개변수1, 매개변수2) -> {정수 리턴})
// 매개변수가 없는 sorted 는 Comparable 인터페이스의 compareTo 라는 메소드를 이용해서 오름 차순 정렬해주는 메소드 이다.
// 매개변수가 있는 메소드는 리턴되는 정수 값을 가지고 정렬을 해주는 메소드 이다.
// 양수가 리턴되면 앞쪽의 데이터가 더 크다고 판단하고 뒤에 배치하고 0을 리턴하면 순서에 변화가 없고 음수를 리턴하면
// 앞쪽의 데이터가 더 작다고 판단하여 앞쪽의 데이터를 그대로 앞에 배치한다.

package Procedure;

public class 필기 {

}
