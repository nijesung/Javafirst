// 배열과 List는 인덱스로 구분 vs Class 와 Map 은 이름으로 구분
// 즉 2차원 배열보다 대부분의 상황에서 클래스와 맵이 우수하다.

// 테이블 형식의 데이터를 만들 때는 Map 이나 Class 의 List 나 배열을 생성하면 된다.
// 배열(List 나 Set 포함) 의 배열을 만들어야 하는 경우 의미를 부여할 필요가 있다면 일차원 배열을 포함한 Map 을 만들고 이 Map 을
// 이용하여 List 를 생성하는 것이 좋다.

// **Properties
// key 와 value 를 같이 저장하는 자료 구조인데 key 와 value 모두 String 만 허용한다.
// String getProperty(String key): key 에 해당하는 값을 리턴하는 메소드
// void setProperty(String key, String value): key 에 value 를 저장하는 메소드로 동일한 key 에 데이터가 저장되어
// 있으면 수정한다.

// **Collections 클래스
// List, Set, Map 인스턴스를 변경을 불가능하게 만들거나 동시에 수정할 수 없도록 만들어주는 메소드를 소유한 클래스
// 모든 메소드가 Static 이므로 직접 메소드를 생성할 필요는 없다.
// Synchronized 가 붙는 메소드는 동시에 수정할 수 없는 데이터 모임을 만들어 주는 메소드이고, Unmodifiable 이 붙는 메소드는
// 변경기 불가능한 데이터 모임을 만들어 주는 메소드이다.

// **Random
// 랜덤한 숫자를 생성하기 위해서 사용하는 클래스
// 게임이나 많은 양의 데이터에서 랜덤한 샘플을 뽑을 때

// **StringTokenizer
// 문자열을 분할해주는 클래스
// String 클래스의 split 이라는 메소드가 하는 역할과 유사한 역할을 수행하는데
// split 은 배열로 리턴하고 StringTokenizer 는 Enumeration 으로 리턴

// java.util.Date

// 날짜와 시간에 관련된 클래스
// 데이터베이스의 날짜와 연동할 때 사용할 수 있는 클래스
// 1970년 1월 1일 자정(Epoch Time) 이후 부터 지나온 시간을 1/1000초 단위의 정수로 가지고 있다가 년월일시분초로 변환해서 출력한다
// 1. 생성자
//    Date(): 현재 시간으로 초기화 된다.
//    Date(long timeInMillis): 1970년 1월 1일 자정 이후에 지나온 시간을 기준으로 초기화
// 2. 메소드
//    toString(): 년월일시분초를 분할하여 문자열로 만들어서 리턴

// **java.util.Calender
// 날짜와 시간을 가지는 클래스
// Date 보다 정확하게 날짜와 시간을 저장한다.
// 이 클래스를 상속받은 클래스로는 GregorianCalendar, BuddistCalendar 클래스가 존재한다.
// 1. 인스턴스 생성
//    static 메소드인 getInstance() 를 이용한다.
// 2. 1970년 1월 1일 자정으로 부터 지나온 시간을 1/1000초 단위의 정수로 가져오는 메소드로 getTimeInmillis() 가 있다
// 3. 년월일시분초 등을 설정 하거나 가져올 때는 get(Calendar 상수) 그리고 set(Calendar상수, 데이터)를 호출하면 된다.
// 4. Date 와의 변환
// 4-1. Calendar 객체를 가지고 Date 객체 만들기
//      new Date(Calendar객체.getTimeInmillis())
// 4-2. Date 객체를 가지고 Calendar 객체 만들기
//      Calendar객체.setTime(Date 객체)

// # 날짜를 가지고 가장 많이 하는 작업
//   날짜를 저장해서 출력하는 것과 날짜 사이의 차이를 구하는 것입니다.

//** 문자열 포맷 클래스 - java.text 패키지에 존재
// 1. SimpleDateFormat
//    Date 객체의 날짜를 원하는 형식의 문자열로 만들어주는 클래스
//    SimpleDateFormat 변수명 = new SimpleDateFormat("날짜 및 시간 서식");
//    String 문자열변수 = 변수명.format(Date 객체);
// 2. DecimalFormat
//    숫자를 원하는 형식의 문자열로 만들어주는 것으로 SimpleDateFormat 과 사용법이 동일하다.
//    0: 없으면 0으로 채우기
//    #: 없으면 없는 대로
//    ,: 천단위 구분 기호
//    %: 백분율
//    \u00A4: 통화기호

// **java.util.Scanner
// 파일이나 문자열 또는 InputStream 으로부터 입력을 받는 클래스
// 키보드 로부터 입력받을 때는 System.in 을 대입하여 인스턴스를 생성하면 된다.
// 입력받는 메소드는 next(), nextInt(), nextDouble() 등이 있는데 이 메소드들은 공백이나 탭 또는 엔터가 올 때까지 입력을 받는다.
// 변경할 수 없는 자료형의 데이터가 오면 예외를 발생시킨다.
// nextLine은 한 줄의 문자열을 입력받는 메소드



package dataStructure;

public class 필기 {

}
