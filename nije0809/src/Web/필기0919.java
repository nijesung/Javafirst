// **확장자가 do 인 요청을 처리하는 Spring MVC Project 생성
// 1. Spring MVC Project 생성
//    패키지 이름을 정해준다
//    com.pk.0919mvc

// 2. Java Version(1.7~)
//    try 안에 auto close, <> 사용 가능
//    1.8- 람다와 스트림 API 사용 가능
//    Spring Version(4.0.0)
//    RestController 를 이용해 JSON 이나 CSV 출력을 쉽게 생성

// 3. pom.xml 파일에 필요한 라이브러리의 의존성을 설정

// 4. web.xml 파일에 프로젝트 설정을 한다.
//    경로는 src/main/webapp/WEB-INF/web.xml
//    파라미터 인코딩 추가하기

// 5. 모든 곳에서 사용할 수 있는 bean 을 생성해 주는 root-context.xml 파일을 확인하고 설정

// 6. FrontController 역할을 수행하는

// 7. 처음부터 기본 제공되는 HomeController 확인
//    시작 요청이 왔을 때 처리하는 메소드의 내용을 수정
//    불필요한 메소드를 지워준다.

// 8. home.jsp 파일은 삭제하고 다시 생성

// 9. HomeController 클래스에 input 요청을 처리하는 메소드를 생성

// 10. WEB-INF/views 디렉토리에 article.jsp 파일을 만들고

// 11. 프로젝트를 실행해 요청을 클릭하면 jsp 페이지로 이동


// **Spring 의 Controller 에서 파라미터 읽기
// 1. 이전에 사용하던 HttpServletRequest 이용
//    Controller 의 요청 처리 메소드에 매개변수로 HttpServletRequest 를 추가해서
//    getParameter("파라미터 이름") 또는 getParameterValues("파라미터 이름") 으로 읽는 방법

// 2. @RequestParam
//    요청 처리 메소드의 매개변수로 @RequestParam("파라미터 이름") 자료형 변수명 을 추가
//    파라미터 이름에 해당하는 파라미터의 값이 변수에 저장
//    1번째 방법은 무조건 String 으로 받지만 이 방법을 이용하면 스프링이 형 변환을 자동으로 해 준다.

// 3. Command 객체를 이용
//    파라미터 이름과 동일한 이름의 프로퍼티를 갖는 클래스를 만들어 요청 처리 메소드의 매개변수로
//    추가해 주면 파라미터들을 전부 매개변수에 저장 해 준다.
//    이 방법은 파라미터를 저장한 객체를 결과 페이지에 자동으로 전송 해 준다.
//    domain 클래스를 만들어 이용한다.

// ex). HomeController 클래스의 form 의 데이터를 전송할 때 처리할 수 있는 메소드 생성
//      1). httpServiceRequest 를 이용해서 파라미터 읽기

//      2). 위의 메소드를 수정해서 @RequestParam 을 이용해서 처리
//			파라미터를 변수의 자료형으로 형변환을 스프링이 대신 해 준다.

//      3). Command 객체를 이용해서 파라미터 읽기
// 		3-1). 파라미터 이름들을 프로퍼티로 전부 가지는 클래스를 생성
//			  com.pk.mvc0919.vo.Article
//      3-2). HomeController 의 요청 처리 메소드를 변경


// **결과 페이지로 이동
// 1. 포워딩
//	  요청 처리 메소드가 String 을 리턴하는 경우
// 	  String 과 ViewResolver 설정을 조합해서 결과 페이지를 결정 한다.
// 	  요청 처리 메소드의 리턴 타입이 void 이면 요청 URL 이 결과 출력 페이지의 이름이 된다.

// 2. 리다이렉트
//	  String 을 리턴하는 메소드에서 "redirect : 리다이렉트할 URL" 을 기재하면 된다.
//	  리다이렉트할 URL	을 만들 때 jsp 나 html 의 경로를 입력하는 것이 아니라
//    Controller 가 처리할 수 있는 URL 을 기재해서 Controller 가 다시 처리해 포워딩 하도록
//    만들어 주어야 한다.


// **결과 페이지에 데이터 전달
// 1. Model 타입의 매개변수를 요청 처리 메소드의 매개변수로 만들고 addAttribute("키이름,데이터)
//    형태로 저장하면 request 객체에 저장된다.

// 2. HttpSession 타입의 매개변수를 요청 처리 메소드의 매개변수로 만들고 세션에 저장할 수 있다.

// 3. Spring 에 추가된 RedirectAttribute 타입의 매개변수를 만들고 addFlashAttribute("키이름,데이터)
//    를 호출해서 저장하면 결과 페이지에서 1번만 사용할 수 있는 데이터를 전달할 수 있다.

// 4. 요청 처리 메소드에서 Command 객체를 매개변수로 받으면 결과 페입지에 클래스의 이름이 첫글자를
//    소문자로 변경한 이름으로 request	 객체에 저장되어 전달된다.

// 5. Controller 클래스에서 @ModelAttribute("데이터이름")을 메소드 선언문 위에 추가하면
//    Controller 가 처리하는 모든 요청에 데이터 이름으로 메소드가 리턴한 데이터를 전달한다.

// ex). 이전 프로젝트의 FrontController 의 요청 처리 메소드를 변경하면서 데이터 전달하기
//		1). 요청 처리 메소드 구성
//      2). views 디렉토리에 result.jsp 파일을 만들고 데이터 출력


// **요청 처리 메소드를 수정하고 다시 실행시켜 결과를 확인한다.
// 포워딩 할 때는 Model, HttpSession, Command 객체가 전달된다.
// 리다이렉트 할 때는 HttpSession, RedirectAttributes 객체가 전달된다.


// **실습: MyBatis 를 이용해 데이터베이스를 연동시키고 전체 보기와 상세 보기를 구현
// 1. 사용할 데이터 생성
//    오라클에 접속해서 실행
// 2. Spring MVC Project 생성
//    com.pk.ufc 라는 패키지를 사용
// 3. Spring Version 과 Java Version 변경
// 4. pom.xml 파일에 필요한 의존성 라이브러리를 추가한다.
//    oracle, spring-jdbc, mybatis, mybatis-spring
// 6. 프로젝트를 실행
// 7. Ufc 테이블의 데이터를 저장할 수 있는 Domain 클래스 생성
//    com.pk.domain.ufc
// 8. MyBatis 환경 설정 파일 만들기
//    src/main/resources/mybatis/mybatis-config.xml
// 9. MyBatis 에서 SQL 을 가지고 있는 mapper 파일을 생성
//    src/main/resources/mybatis/mappers/ufc.xml
// 10. applicationContext.xml(root-context.xml 파일에 XML 파일을 활용하는 
//     MyBatis 인스턴스(SqlSessionTemplate)을 생성해 주는 코드를 작성
// 11. MyBatis 설정이 제대로 되었는지 테스트
// 11-1. pom.xml 파일에 spring-test 라이브러리의 의존성을 추가
// 11-2. src/test/java 디렉토리에 테스트 용 클래스를 제작하고 메소드를 만든 후 
//       SqlSession 생성 여부 확인
// 12. Dao 구조를 만들고 전체 데이터를 가져오는 메소드를 구현
// 12-1. 기본 패키지 안에 Dao 인터페이스를 생성
//       com.pk.ufc.dao.UfcDao
// 12-2. 인터페이스를 implements 한 DaoImpl 클래스를 생성
//       com.pk.ufc.dao.UfcDaoImpl
//       클래스 선언 위에 @Repository 추가 해야 한다.
//       사용하고자 하는 데이터베이스 프레임워크 객체를 @Autowired 를 이용해 주입받아야 한다.

package Web;

public class 필기0919 {

}
