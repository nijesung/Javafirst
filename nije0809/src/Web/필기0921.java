// ****XML 출력
// XML(eXtensible Markup Languge): 데이터를 태그 형식으로 표현
// 태그의 의미를 브라우저가 해석하는 것이 아니라 맨 위에 선언된 DTD 나 사용하는 곳에서 해석
// 구조적이기 때문에 사람이 알아보기 쉽다.
// json 보다는 크기가 크기 때문에 많은 양의 데이터를 출력할 때는 json 을 사용하는 경우가 많다.

// 1. Spring MVC Project 생성

// 2. Java Version 과 Spring Version 설정

// 3. we.xml 파일에 파라미터 인코딩 설정 태그를 추가

// 4. servlet-context.xml 파일에 Controller 가 처리하지 못하는 URL 은 
//    WAS 가 처리하도록 하는 설정 추가

// 5. XML 출력을 위한 의존성 라이브러리를 pom.xml 파일에 추가

// 6. XML 으로 출력할 Domain 클래스 만들기
//    com.pk.view.domain.DataStructure

// 6. home.jsp 파일을 삭제하고 다시 생성한 후 XML 요청을 생성

// 7. DataStructure 클래스의 List 를 프로퍼티로 갖는 클래스를 생성
//    XML 은 배열의 형태로 출력되기 때문에 Domain 클래스를 배열이나 List 를 프로퍼티로 갖는
//    클래스가 필요

// 8. home.jsp를 삭제하고 다시 생성한 후 요청을 1개 생성

// 9. HomeController 클래스에 위의 요청을 처리하는 메소드를 생성

// 10. servlet-context.xml 파일에 뷰 이름을 가지고 출력할 뷰를 직접 지정하는
//     뷰 리졸버를 설정하고 dataxml 요청이 왔을 때 xml 로 출력하는 설정을 추가
// 10-1. 기존 뷰 리졸버의 우선순위를 설정
// 10-2. 뷰 이름을 가지고 직접 출력할 뷰를  지정할 수 있도록 하는 뷰 리졸버 설정
// 10-3. XML 출력을 위한 설정


// **에러 페이지 출력
// java web programming 에서는 처리 도중 예외가 발생한 경우 에러 페이지를 출력할 수 있는 기능이 있다.
// 각 jsp 페이지에서 @page 를 이용해서 설정할 수 있고 web.xml 파일에 설정해서 사용할 수 있다.
// Spring 에서는 이를 어노테이션을 이용해 처리할 수 있다.
// Controller 클래스에
// @ExceptionHandler(예외클래스 이름)
// public String 메소드이름(Model model){
//    return "출력할 뷰 페이지 이름";
// }
// 형식의 메소드를 만들면 예외가 발생하면 return 되는 페이지를 출력하도록 한다.

// 클래스를 하나 만들고 클래스 선언 위에
// @ControllerAdvice("패키지이름") 를 추가하면 패키지에서 예외가 발생하면 이 클래스의 메소드가 호출된다.

// 에러 페이지를 만들 때 512바이트 보다 작은 내용을 출력하면 IE 에서는 IE 에러 페이지가 출력된다.
// 모든 브라우저에서 동일한 에러 페이지를 출력하고자 할 때는 출력내용을 512 바이트 이상으로
// 만들어야 한다.


// **어떤 요청이 왔을 때 단순하게 페이지 이동만 하는 경우 Controller 에 메소드만 만드는 것은
// 자원의 낭비가 될 수 있다. 이런 경우에는
// <mvc:view-controller path="요청경로" view-name="출력할 뷰 이름"/> 을 추가해서
// 메소드를 대신 할 수 있다.
// 메소드를 이용하지 않고 xml 설정을 이용하게 되면 아무래도 가독성은 떨어진다.


// **URL 패턴

// /*
// 모든 요청

// /
// .jsp 를 제외한 모든 요청

// 위 2개 중 하나의 URL 패턴을 사용하게 되면 거의 모든 요청을(절대 경로로 요청을 하면 Controller 로 가지 않는다)
// Controller 가 처리하려고 한다.
// 이 때 리소스 파일의 링크를 설정해도 하나의 요청으로 간주해서 Controller 에게 요청을 전달한다.
// 별도의 설정이 없으면 Controller 가 처리하지 못해 404 에러가 발생한다.
// 이런 경우에는 <mvc:default-servlet-handler/> 를 설정 파일에 추가해 Controller 가 처리하지
// 못하면 WAS(Web Application Server - Tomcat) 가 처리하도록 해 주어야 한다.


// **정적 파일(변하지 않는 파일 - image, css, js 등)의 사용
// 1. 웹 브라우저는 어떤 경로의 파일을 요청하면 브라우저 안에서 찾고 없으면 서버에게 요청한다.
//    서버에게 가져와 저장한 후 사용을 하고 URL 을 이름으로 해서 저장한다.
//    동일한 URL 을 사용하는 자원은 다시 다운로드 받지 않고 브라우저 안에서 가져온다.
//    이 기능을 캐싱 이라고 한다.
//    동일한 자원은 되도록이면 동일한 URL 을 사용하도록 만들어 주어야 한다.
//    ${pageContext.request.contextPath} 을 이용하면 WebContent(webapp) 을 기준으로 한다.

// 2. Spring 에서 특정 디렉토리의 내용을 강제로 캐싱하도록 하기
//    <mbc:resources mapping="url 패턴" location="실제 자원의 경로"
//    cache-period="캐싱 주기"/>


// **AOP(Aspect Of Programming - 관점 지향 프로그래밍)
// 어떤 작업을 처리할 때 공통으로 포함되는 내용과 실제 작업을 수행하는 코드가 같이 존재하게 되면
// 프로그램을 알아보기 어렵고 작성하기도 어렵다.
// 관점 지향 프로그래밍 에서는 작업 별로 코드를 분할한다.
// 관점 지향 프로그래밍 에서는 메소드를 직접 호출해서 작업을 수행시키는 것이 아니라
// 설정을 이용해 컴파일 하거나 실행을 할 때 코드를 삽입하는 방법을 이용한다.
// 실제 작업을 수행하는 객체는 개발자가 만든 클래스를 상속받아 만든 클래스가 수행하게 된다.
// 개발자가 만든 클래스를 바로 사용하지 않고 별도의 코드를 붙여 사용하는 디자인 패턴을
// 프록시 패턴이라고 한다.

// Spring 에서는 URL 에 적용하는 HandlerInterceptor 와 메소드 단위로 적용하는 AOP
// 두 가지 기능으로 이 작업을 처리한다.


// **HandlerInterceptor
// 1. Spring MVC Project 생성
// 2. home.jsp 파일을 삭제하고 다시 생성 후 요청을 1개 생성
// 3. HomeController 요청을 처리하는 메소드 생성
// 4. HandlerInterceptor 를 implements 한 클래스를 만들고 메소드 재정의
//    com.pk.aop.util.MeasureInterceptor
// 5. Interceptor 요청이 오면 MeasureIntercpetor 가 동작하도록 설정
//    servlet-context.xml 파일


// **Compile
// .java 파일이 .class 파일로 만들어지는 것
// 1. 클래스 로딩
// 	  자바는 실행이 될 때 필요한 모든 클래스를 JVM 에 적재한다.
//    이 적재하는 것을 클래스 로딩이라고 한다.
// 2. 런타임
//    클래스 또는 클래스를 가지고 만든 인스턴스가 메소드를 호출하는 시점
//    작업을 수행하는 시점


// **AOP
// Intercptor 는 URL 을 기준으로 해서 메소드를 호출하는 것이고 AOP 는 메소드 단위로 설정한다.
// 1. pom.xml 파일에 AOP 를 사용하기 위한 의존성 라이브러리를 추가
// 2. AOP 로 동작할 클래스를 만들고 메소드를 생성
//    클래스 이름은 아무 이름이나 상관 없고 메소드 이름 또한 상관 없다.
//    com.pk.aop.util.LoggingAdvice
// 3. servlet-context.xml 파일에 aop 설정을 추가
// 3-1. aop 네임스페이스 추가
// 3-2. aop 설정 추가


// **Spring 에서의 파일 업로드
// MultipartFile 자료형으로 파일을 받을 수 있다.
// commons-fileupload 라이브러리를 이용
// CommonsMultipartResolver bean 을 생성 해 주어야 한다.
// spring 은 파라미터를 처리하는 방법이 3가지
// Request
// @RequestParam
// Command 객체를 이용하는 방법

// 1. commons-fileupload 라이브러리의 의존성을 pom.xml 에 추가
// 2. servlet-context.xml 파일에 파일 업로드를 위한 리졸버 bean 을 생성하는 코드를 추가
// 3. home.jsp 파일에 파일 업로드 화면으로 이동하는 요청을 생성
// 4. HomeContoller 클래스에 위의 요청을 처리하는 메소드를 생성
// 5. views 디렉토리에 fileupload.jsp 파일을 만들고 디자인
// 6. 파라미터들을 저장할 수 있는 Command 클래스를 생성
//    파라미터 이름과 프로퍼티의 이름이 같아야 한다.
// 7. HomeController 클래스에 폼의 데이터를 처리하는 메소드를 생성
//    


package Web;

public class 필기0921 {

}
