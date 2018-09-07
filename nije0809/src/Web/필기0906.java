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
//   html 이나 jsp 파일에서 출력할 때 /로 시작하는  URL을 작성하면 서버로부터 시작하는 경로가 됩니다.
// 	 프로젝트 부터 시작하는 절대경로를 만들때는 ${pageContext.request.contextPath}를 사용하면 됩니다.
//   Servlet 이나 web.xml 파일에서 경로를 입력할 때는 /로 시작하면 프로젝트 로부터의 경로가 됩니다.
//	 java 파일들은 src 로부터의 경로가 되고 jsp 나 html 등의 파일들은 WebContent 디렉토리로부터의 경로 입니다. 
//	 따라서 HTML 이나 JSP 파일에서는 /로 부터 시작하는 경로를 사용하지 않는 것이 좋습니다.

// 3. WebContent 디렉토리에 fighter 디렉토리를 생성하고 register.jsp 파일을 생성

// 4. userDao 인터페이스에 회원가입 처리 메소드를 선언
//	  Dao 메소드의 매개변수는 1개로 만드는 것이 바람직하다.
//	  public boolean registerFighter 이름(Fighter fighter);

// 5. UserDaoImpl 클래스에 회원가입 처리를 위한 메소드를 구현

// 6. 위에서 만든 메소드를 테스트 하기 위해 프로젝트에 JUnit 라이브러리를 추가
// 	  Test 어노테이션 안에 두고 마우스 오른쪽을 눌러 런애스->제이유닛테스트

// 7. UserService 인터페이스에 회원가입을 처리해주는 메소드를 선언
//    public boolean registerFighter (HttpServletRequest request);

// 8. UserServlet

// 9. UserController 클래스에 user/insert 요청이 왔을 때 처리하는 코드를 doGet 메소드에 추가

// 10. jsp 파일에 json 데이터 출력하기
// 10-1. json 을 사용하려면 json 라이브러리를 프로젝트에 추가해 주어야 한다.
// 10-2. JSONObject 나 JSONArray 클래스의 인스턴스를 이용해서 JSON 데이터를 생성 할 수 있다.
// 10-3. jsp 에서 출력할 때는 contentType 을 text/json 으로 변경해서 하면 된다.

// **이메일 중복 검사하기
// 1. json 라이브러리를 WEB-INF/lib 디렉토리에 복사
// 2. UserDao 인터페이스에 이메일 중복검사를 위한 메소드를 선언
// 	  public boolean emailCheck(String email);
// 3. UserDao 클래스에 이메일 중복검사를 위한 메소드를 구현	

// 4. UserService 인터페이스에 이메일 중복 체크를 위한 메소드를 선언
// 	  public boolean emailCheck(HttpServletRequest request);

// 5. UserServiceImpl 클래스에 이메일 중복체크를 위한 메소드를 구현

// 6. UserController 클래스에 이메일 중복 체크 요청(user/emailcheck)을 처리하는 코드를 doGet 메소드에 추가

// # 404 에러의 대부분은 컨트롤러와 관련이 있거나 주소를 잘못 쓴 것이다.
//   ora 로 시작하는 에러는 데이터베이스 에러이다. - DaoImpl 클래스

// 7. 이메일 중복체크 결과를 출력할 emailcheck.jsp 파일을 fighter 디렉토리에 생성

// 8. register.jsp 파일에서 이메일 중복 체크를 위한 코드를 추가
// 8-1.	jquery 파일을 프로젝트에서 사용할 수 있도록 다운로드 받아서 저장
//		www.jquery.com 에 접속하여 다운로드를 클릭
// 8-2.	google CDN 이나 MicrosoftCDN 을 찾아 클릭
// 8-3. 1.x 버전의 주소를 복사해서 브라우저 창에 입력하고 엔터
//      (IE 브라우저이면 다운로드가 되고 다른 브라우저는 화면에 출력된다)

// 8-4. 코드를 전부 복사
// 8-5. 프로젝트의 WebContent 디렉토리에 resources 디렉토리를 만들고 그 안에 하위 디렉토리 js 디렉토리를 만든 후
// 		그 안에 jquery.js 파일을 생성하고 복사했던 코드를 붙여넣는다.
//		이 파일의 절대 경로는 ${pageContext.request.contextPath}/resources/js/jquery.js 가 된다.
//	    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

// jquery 의 ajax 요청 
// $.ajax({
//	url:요청 url
//  method: get 이나 post(생략하면 get),
// 	dataType: 리턴되어 오는 데이터 타입(txt, json, xml..)
// 	data: {파라미터이름:파라미터값....},
//	success:function(result){
//    // 데이터를 가져오는 데 성공했을 때 호출될 함수
//	  // 매개변수는 결과 데이터 이다.
//	  // json 은 파싱된 결과이다.( { 로 시작하면 객체이고 [ 로 시작하면 배열이다.)
//  },
//  error:function(result){
//	  // 데이터를 가져오는 데 실패했을 때 호출될 함수
//	  // 매개변수는 에러 내용
//  },
// })

// $.ajax({
//	url:'user/emailcheck',
//  dataType:'json',
//  data:{'email"이메일},
//  success:function(result){
//		result.result
//  }

// })


// **데이터 삽입 시 고려할 사항
// 데이터 유효성 검사를 하여 유효성 검사를 통과하지 못할 시 서버로 전송하지 않도록 하는 것이 바람직하다.
// primary key 의 값을 입력받는 경우(대부분 아이디) 중복 검사를 직접 해야 한다.


// ***중요
// 개발환경에서 운영환경(실행) 으로 이행할 때 소스를 컴파일하면 절대 안 된다.

// ***변경 가능성이 있는 고정된 문자열은 web.xml 에 context.param 으로 만들어 불러온다.
// 별도의 파일에 저장한다.
// DB 에 가능
// WAS -Server.xml -> WebProject -> web.xml -> Context.xml


// **Connection Pool을 사용하도록 프로젝트 수정
// 1.META-INF 디렉토리에 데이터베이스 접속 정보를 저장할 context.xml 파일을 생성하고 작성

// 2. WEB-INF 디렉토리의 web.xml 파일

// 3. DaoImpl 클래스를 수정
// 3-1.	드라이버 클래스를 로드하는 코드를 제거





package Web;


public class 필기0906 {

}
