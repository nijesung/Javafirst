// **웹 프로젝트 배포
// 웹 프로젝트를 배포할 때는 war 파일로 만들어서 WAS 의 실행 디렉토리에 넣어주면 된다.
// war 파일은 압축된 파일이지만 WAS가 실행할 때는 압축을 풀어서 실행 한다.
// 동일한 형태로 자바에서는 jar 파일이고 안드로이드에서는 apk 압축을 이용한다.

// 1.WAS가 실행할 수 있는 war 파일로 만들기
// 1-1. 프로젝트를 선택하고 마우스 오른쪽을 클릭해서 [export] - web - war 을 선택

// 1-2. 저장 위치를 선택
//      export source file: 확장자가 java 파일도 같이 압축할 것인지 여부
//					        다른 곳에 가져가서 소스 파일을 편집할 것이면 체크하고 배포할 것이면 체크하지 않는다.

// Overwrite Existing File: 동일한 파일명이 존재할 때 덮어씌울 지의 여부

// 2. war 파일 배포
// 2-1. war 파일을 tomcat 디렉토리의 webapps 디렉토리에 복사

// 2-2. tomcat 구동

// 2-3. 집에서 할 때는 방화벽을 해제해야 한다.
//      방화벽을 해제하면 해킹에 대한 위험은 감수를 해야 한다.

// 3. 배포된 프로젝트를 원래의 프로젝트로 복원
//    maven 기반의 프로젝트를 배포하게 되면 일반 웹 프로젝트가 된다.

// 3-1.	복원한 프로젝트를 maven 프로젝트로 변환

// 3-2. META-INF 디렉토리에 있는 pom.xml 파일의 내용을 복사해서 새로 만들어진 pom.xml
//      파일에 붙여넣기 하면 된다.
// 3-3. webapp -> WebContent 로 변환되어 있다.


// **상세보기 출력 구현
// 1. detail.jsp 구현

// 2. 이미지 파일이 있는 img 디렉토리를 WebContent 나 webapp 디렉토리에 복사
//    내부 파일의 경로는 URL 을 기준으로 하는 것
// 3. 모든 요청은 기본적으로 Controller 가 처리하고 Controller 가 처리하지 못하면
//    404 에러가 발생한다.
//    Controller 가 처리하지 못하는 요청은 WAS	 가 처리하도록 설정을 해주어야 한다.
//    servlet-context.xml 파일에 아래 태그를 추가
//    <default-servlet-handler/>


// **다양한 형식의 출력(excel, pdf, json, csv, xml, 파일 다운로드)
// 1. Spring MVC Project 를 생성
// 2. java version 과 spring version 변경
// 3. web.xml 파일에 파라미터 인코딩 설정
// 4. servlet-context.xml 파일 설정
//    <default-servlet-handler/>

// 4-1. Controller 가 처리하지 못하는 요청은 WAS 가 처리하도록 하는 설정을 추가
// 4-2. jsp 이외의 출력을 위한 설정
//      view 이름 별로 출력할 수 있도록 해 주는 뷰 설정을 추가하고 이름이 없을 때는 html
//      로 출력할 수 있도록 설정을 변경


// **엑셀로 출력
// apache.poi 라이브러리 이용
// AbstractXlsView 로 부터 상속받은 View 를 이용해 출력하면 된다.

// 1. poi 라이브러리를 다운로드 받을 수 잇도록 pom.xml 파일에 의존성 추가
// 2. home.jsp 파일을 새로 생성하고 엑셀 출력 링크를 추가
// 3. homeController 에 excel.xls 요청을 처리할 수 있는 메소드를 작성
// 4. 데이터를 출력할 ExcelView 클래스를 생성
//    AbstractXslView 를 상속받아야 한다.
//    com.pk.view.service.ExcelView

// 5. servlet-context.xml 파일에 Controller 에서 리턴한 View 이름이 온 경우
//    ExcelView 로 출력하도록 설정을 추가
//    <beans:bean id="리턴한 뷰 이름" class="출력할 뷰 클래스 이름"/>


// **PDF 출력
// itext 라이브러리를 이용
// AbstractPdfView 클래스를 상속한 View 로 출력하면 된다.

// 1. pom.xml 파일에 pdf 출력 라이브러리 추가
// 2. home.jsp 파일에 pdf 요청 경로를 생성
// 3. HomeController 클래스에 data.pdf 요청을 처리하는 메소드를 생성
// 4. 데이터를 출력할 PDF View 만들기
//    AbstractPdfView 를 상속
//	  com.pk.
// 5. servlet-context.xml 파일에 Controller 에서 리턴한 뷰 이름과 출력할 뷰 클래스를 연결


// **Restful Service
// 하나의 서비스는 하나의 URL 로 제공되어야 한다.
// 모바일 웹 브라우저 그리고 PC 의 웹 브라우저, 아니면 애플리케이션 등이 요청을 해도
// 동일한 방법으로 응답해야 한다.
// url 은 모두 소문자로 작성하는 것을 권장하고 서버는 뷰를 제공하는 것이 아니라
// 데이터를 제공하는 역할을 수행하도록 만들어야 한다.
// 화면 출력은 클라이언트 들이 서버의 데이터를 받아 자신에게 맞게 출력 하도록 하는 것
// 서버가 뷰를 만들어서 클라이언트 에게 제공하는 것은 서버에게 부담이 커 효율이 나빠진다.
// 이 때 사용하는 데이터 포맷으로 3가지(csv, xml, json) 가 많이 사용된다.
// 클라이언트 프로그램을 만들 때는 웹(ajax, websocket), 일반 애플리케이션(Thread, HttpURLConnection)
// , XMl Parsing, JSON Parsing 이 중요해 졌다.


// **JSON
// JavaScript 의 데이터 표현 방법으로 데이터를 만드는 방식
// [ ]: 배열
//      배열은 , 로 구분하면서 데이터를 나열
// { }: Map
// 	    Map 에서는 키 이름:데이터 를 , 로 구분하면서 데이터를 나열
// 		키 이름은 문자열로 만든다.

// 1. Java Web 에서 json 데이터를 리턴하는 방법
// 1-1. Java 의 데이터를 MappingJacksonJsonView 를 이용해서 출력
// 1-2. Spring 4.0 의 RestController 에서 배열(List 포함)이나 Map 을 리턴
// 1-3. 직접 JSONObject 나 JSONArray 데이터를 만들어 리턴하는 방법 (이 방법은 복잡하다)

// ex) MappingJacksonJsonView 을 이용하는 방법
// 1. pom.xml 에 jackson-databind 라이브러리 설정
// 2. home.jsp 파일에 요청을 생성
// 3. HomeController 클래스에 jsonview.json 요청을 처리하는 메소드를 생성
// 4. servlet-context.xml 파일에 jsonview 를 JSON 으로 출력 하도록 설정
//    <bean id="" class="" />


// **RestController
// Spring 4.0 에서 Restful 을 구현하기 위해 추가된 클래스
// 생성을 할 때는 클래스 이름 위에 @RestController 만 추가하면 된다.
// 요청을 처리하는 메소드에서 String 을 리턴하면 문자열로 출력이 된다.
// Map 이나 Domain Class 객체를 리턴하면 { } 형식을 만들어서 출력한다.
// List, Set, 배열 객체를 리턴하면 [ ] 형식을 만들어 출력한다.
// jackson-databind 라이브러리를 추가해 주어야 한다.

// ex). csv, json, ajax-json 출력
// 1. home.jsp 파일에 3가지 요청을 생성

// 2. 클라이언트의 요청을 처리할 클래스를 생성하고 @RestController 어노테이션을 추가
//    com.pk.view.DataController

// 3. DataController 클래스에 data.csv 요청을 처리하는 메소드를 생성

// 4. DataController 클래스에 data.json 요청을 처리하는 메소드를 생성


// **위의 데이터를 가져와 jsp 파일에 출력하기
// 1. ajax 사용을 쉽게 하기 위해 jquery.jsp 를 다운로드 받아 프로젝트에 저장
// 2. home.jsp 파일을 수정


// **아이디 중복 검사를 수행하는 AJAX
// 1. 데이터베이스에 접속해 회원 테이블 만들기
// 2. 데이터베이스 연동에 필요한 의존성을 pom.xml 파일에 설정
// 2-1. 오라클의 repository
// 2-2. 오라클, spring-jdbc, mybatis, mybatis-spring 의 의존성을 dependencies에 추가
// 3. MyBatis 환경 설정 파일과 매퍼 파일 생성
//    src/main/resources/mybatis/mappers/member.xml
// 3-1. mybatis-config.xml
// 3-2. member.xml
// 3-3. root-context.xml 파일에 MyBatis 사용을 위한 bean 생성 코드 추가
// 3-4.	home.jsp 파일에 회원가입 화면을 만들기
// 5. Memberdao 클래스 생성
// 6. MemberService 클래스를 만들고 아이디 중복 체크 메소드를 생성
// 7. DataController 클래스에 아이디 중복 체크를 처리해 주는 메소드를 구현
// 8. home.jsp 파일의 스크립트에 추가

package Web;

public class 필기0920 {

}
