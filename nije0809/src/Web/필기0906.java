// Oracle 을 이용한 회원 관리

// 1. Oracle 에 회원 테이블 생성
//	  Oracle 은 보통 대문자를 사용
// 	  MySQL	은 보통 소문자를 사용

//	  ufc
//    email varchar2(50) primary key
//	  pw char(15) not null,
//	  name char(20),
// 	  phone varchar2(11) not null
//	  addr char(200)

// 	  # 요소
// 	  로그인
//    로그아웃
//    회원가입
//	  정보수정
//	  삭제
//    샘플 데이터생성(회원가입 중복 확인을 위해)

// 2. 오라클에 접속해서 테이블 생성

//    create table fighter(
//	  email varchar2(50) primary key,
//	  pw char(15) not null,
//	  name char(20),
//	  phone varchar2(11),
//	  addr char(200));

// 3. 샘플 데이터를 생성
//	  반드시 마지막에 commit;

// 4. Dynamic Web Project 생성(web.xml 파일을 포함)

// 5. 필요한 라이브러리를 WEB-INF 디렉토리의 lib 디렉토리에 복사
//	  servlet-api, jstl-api, ojdbc6.jar
//						     mysql-connector (mysql 의 경우)

// 6. Java Resource/src 디렉토리에 VO 클래스 생성
//	  vo.fighter
//	  각 컬럼을 저장할 수 있는 프로퍼티(변수 & 접근자 메소드) 생성

// 7. 프로젝트 구조 만들기
// 7-1. WebContent 디렉토리에 시작 페이지로 사용할 index.jsp 파일을 생성

// 7-2. /user 가 포함되어 있는 URL 을 처리할 수 있는 Controller	를 생성
// 7-3.	데이터베이스 처리를 위한 메소드를 선언할 인터페이스를 생성
// 7-4.	데이터베이스 처리를 위한 메소드를 선언할 인터페이스를 구현한 클래스를 생성
// 7-5.	비지니스 로직 처리를 위한 메소드를 선언할 인터페이스를 생성
// 7-6.	비지니스 로직 처리를 위한 메소드를 선언할 인터페이스를 구현한 클래스를 생성

// 8. 서버에서 작업을 처리하는 클래스에 싱글톤 디자인 패턴(클래스의 인스턴스를 1개만 생성할 수 있도록 해 주는 디자인 패턴)을 적용
//	  서버에서 작업을 처리하는 클래스의 인스턴스는 스레드를 이용해서 작업을 처리한다.
//	  (병렬 처리를 이용하는 것이 아니기 때문에 인스턴스가 여러 개 존재할 필요가 없다)

// 8-1. UserDaoImpl 클래스에 싱글톤 디자인 패턴을 적용하는 코드를 추가
// 8-2. UserServiceImpl 클래스에 싱글톤 디자인 패턴을 적용하는 코드를 추가

// 9. 의존성 설정
//	  Controller 가 Service 인스턴스를 사용하고 Service 가 Dao 인스턴스를 사용한다.
//	  작업을 할 때마다 객체를 생성하면 작업 시간이 오래 걸릴 수 있기 때문에 생성자에서 미리
//	  만들어 두고 사용하는 것을 권장한다.

// 9-1. UserServiceImpl 클래스에 UserDao 클래스의 인스턴스 생성 코드를 추가
// 9-2. UserController 클래스에 UserService 클래스의 인스턴스 생성 코드를 추가

// 10. index.jsp 파일에 로그인 화면 디자인

// 11. UserDao 인터페이스에 로그인 처리를 위한 메소드를 선언

// 12. UserDaoImpl 클래스에 로그인 처리를 위한 메소드를 구현
//	   드라이버를 로드하는 것은 처음 한 번만 하면 된다.
//	   드라이버를 로드하는 코드는 생성자에서 한 번만 호출하는 것이 바람직
//	   Connection, PreparedStatment, ResultSet 은 여러 메소드에서 사용하기 때문에
//	   인스턴스로 선언하는 것이 좋다.

// 13. 3개의 인스턴스 변수를 추가

// 13-2. 생성자에서 드라이버 클래스 로드

// 14. UserService 인터페이스에 로그인을 처리 해 주는 메소드를 선언
//     // 로그인을 처리한 결과는
//	   public Fihgter login(HttpServletRequset request);

// 15. User

// 16. UserController 의 doGet 메소드 에서 로그인 요청을 처리하는 코드를 작성

// 17. Index.jsp 파일에 session 의 user 를 출력

// # where 절을 만들 때 컬럼의 자료형이 char 인 경우 공백이 같이 붙어 문제가 될 수 있으므로
//	 trim 함수를 이용해서 작성하는 것이 좋다.

// 18. index.jsp 파일에서 session 의 user 가 null 일 때와 그렇지 않을 때의 출력을 다르게 설정
//	   jstl 의 core 의 c:if 를 이용

// 19. 로그아웃 처리
//     로그아웃은 세션을 초기화 해서 세션에 저장된 데이터를 지우는 방법을 사용한다.
//	   session.invalidate()
//	   일정 시간동안 동작이 없으면 세션을 초기화 하기도 한다.
//	   web.xml 파일에 sessionconfig 태그를 설정하면 된다.

// 19-1. Controller 의 doGet 메소드에 user/logout 처리를 위한 코드를 추가
//	     xml 파일에 2분동안 아무런 조작도 하지 않으면 세션이 자동 초기화되도록 하는 코드를 설정
//  	 <session-config>
// 		  	<session-timeout>2</session-timeout>
//		 </session-config>


// **회원가입
// 회원가입 링크를 누르면 회원정보를 입력할 수 있는 화면으로 이동
// 회원정보를 입력하고 전송을 누르면 실제 회원가입이 되어야 한다.
// 단순한 페이지 이동은 대부분 forwarding 을 한다.

// 1. index.jsp 파일에 로그인이 안되어 있는 경우 회원가입 링크를 추가
//	  <input type="button" value="회원가입" onclick="location.href='user/register'" />

// 2. Controller 클래스의 doGet 메소드에 user/register 요청이 왔을 때 처리를 위한 코드를 추가

// # 페이지 이동하는 URL 이나 HTML 파일에 적는 src 의 위치는 파일의 위치를 기준으로 하는 것이 아니라
//   URL 을 기준으로 하는 것이다.


package Web;

public class 필기0906 {

}
