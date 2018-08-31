// **VO(Variable Object - Data Transfer Object)
// 여러 개의 속성을 묶어서 하나의 데이터를 표현하기 위한 객체
// 이 객체의 클래스를 만들 때는 아래와 같은 방식으로 만든다.

// 1). 데이터를 저장할 속성을 private 나 protected 지정자를 이용해 생성한다.
//     최근에는 확장이 가능하도록 protected 로 설정하는 것을 권장한다.

// 2). 속성은 private 이나 protected 로 선언했기 때문에 외부에서 접근이 불가능하므로
//     접근자 메소드(getter&setter) 를 만들어 준다.

// 3). 각 속성의 값을 빠르게 확인이 가능하도록 toString 메소드를 overriding 한다.
//     *이 과정 까지는 필수

// 4). 외부에서 데이터를 가져와 대입할 때 빠르게 하고자 하는 경우에는 생성자를 추가한다.

// 5). 인스턴스 단위로 전송하거나 기록하고자 하는 경우에는 Serializable 인터페이스를 implements 한다.

// 6). 여러 개의 데이터를 묶어서 배열이나 List 에 보관하고자 하는 경우에는 크기 비교를 위해서
//     Comparator 인터에피스를 구현해서 compareTo 메소드를 overriding 한다.

// 7). 값의 동일성 여부를 비교하고자 하면 equals	메소드를 overriding 한다.

// 8). 응용 프로그램 등에서 사용하는 경우 데이터를 복제할 수 있는 clone 메소드를 overriding 한다.



// **<jsp:useBean>
// 자바 클래스의 인스턴스를 생성해 주는 태그
// 자바 클래스의 인스턴스는 생성자를 호출하여 생성해야 하지만 jsp 파일에서는 태그를 이용하여
// 생성이 가능한데 이 때 클래스에 매개변수가 없는 생성자가 있어야 한다.
// 태그를 이용해서 인스턴스를 생성할 때는
// class 속성에 클래스의 완전한 이름을 설정하고 scope 에 유효범위를 설정하며 id 에 이름을 설정한다.
// scope 는 page, request, session, application 이 가능하다.

// **예외나 에러가 발생했을 때 보여지는 페이지
// 1. 예외나 에러가 발생했을 때 보여질 페이지 생성
//    페이지 상단에 <%@page isErrorPage="true" %> 을 추가한다.
//    이 페이지에서는 예외가 발생했을 때 예외 내용을 저장한 exception 객체를 사용할 수 있다.

// 2. 보여지는 페이지에서 예외나 에러가 발생했을 때 출력될 페이지를 설정
//    <%@ page errorPage="보여질 페이지 경로" %>

// 3. IE 에서는 에러 페이지의 크기가 513바이트가 되지 않으면 자체 페이지를 보여준다.
//    주석을 추가해서 513바이트 이상이 되도록 해야 모든 브라우저에서 동일한 에러페이지를
//    출력할 수 있다.

// # 에러 페이지 경로를 설정할 때 / 로 시작하면 WebContent 디렉토리에서 부터 경로를 찾아간다.
//   / 를 추가하지 않으면 현재 디렉토리를 시작 기점으로 찾는다.

// 4. 에러 코드 별 에러 페이지 설정
//    위의 방법을 이용하면 에러가 발생했을 때 에러 페이지를 출력할 수 있지만 모든 페이지에
//    직접 설정을 하게되면 설정을 너무 자주 해야 해서 에러 종류나 코드별로 보여지는 에러페이지
//    를 설정 할 수 있다.
//    web.xml 파일에 아래처럼 설정
//    <error-code>에러코드</error-code>
//    <location>에러페이지의 경로</location>
//    </error-page>

// # 404 에러에 대해서는 이런 방식으로 처리하는 경우가 많다.

// # web.xml 파일은 웹 프로젝트 설정 파일이다.
//   프로젝트가 실행될 때 처음 한 번만 읽어서 수행된다.
//   이 파일의 내용이 잘못되면 프로젝트는 실행되지 않는다.
//   이 파일을 수정하면 프로젝트는 반드시 재실행 해야 한다.


// **주요 응답 상태 코드
// 200 : 요청이 정상적으로 처리
// 307 : 임시로 페이지가 리다이렉트
// 400 : 클라이언트의 요청이 잘못된 구문
// 401 : 접근이 허용되지 않음
// 404 : 자원이 존재하지 않음
// 405 : 요청된 메서드는 허용되지 않음
// 500 : 서버 내부 에러(JSP에서 예외 발생)
// 503 : 서버가 일시적으로 서비스 할 수 없음(과부하나 임시 보수 중)



// ** 자바(jsp)에서 처리를 수행한 후 결과 페이지로 이동하기
// 1. forwaring
//    URL 을 변경하지 않고 이동
//    새로고침을 하면 처리를 다시 수행한다.

// 1-1.	태그로 이동하는 방법
//      <jsp:forward page="이동할 URL"/>

// 1-2. 자바 코드로 이동하는 방법
//      RequestDispatcher ? = request.getRequestDispatcher("이동할 URL");
//      ?.forward(request, response);

// 2. redirect
//    URL 을 변경해서 이동
//    URL 을 변경했기 때문에 새로고침을 하면 처리를 다시 수행하지 않고 결과 페이지만 다시 출력

//    response.sendRedirect("이동할 URL")

// **처리한 후 결과를 출력하는 페이지에 전달하기
// request, session, application 이용 가능
// request 는 forwarding 했을 때만 데이터가 전달
// session 과 application 은 이동 방법 상관없이 데이터가 전달

// 1. 저장하는 메소드
//    setAttribute(String name, Object value);

// 2. 읽어오는 메소드
//    Object getAttribute(String)

// 3. 삭제하는 메소드
//    void removeAttribute(String name)

// **EL
// Expression Language
// jsp 에서 java	로 만들어진 데이터를 편리하게 출력하기 위한 식

// 1. attribute	출력
//    ${attribute}
//    null 은 출력이 안 된다.
//    자동으로 형 변환하기 때문에 숫자 데이터나 문자 데이터의 경우 연산이 가능
//    Boolean, 숫자 데이터, 문자열이 아닌 경우는 toString 의 결과를 출력

// 실습
// attribute 를 생성하고 forwarding 하는 파일: el/attrcreate.jsp
// attribute 를 출력하는 파일: el/attrdisplay.jsp

// 2. el 에서 전달되는 데이터가 없는 경우 null 로 간주해 출력을 하지 않으나
//    산술 연산의 경우는 0으로 간주해서 연산을 한다.

// 3. el 에서 이름만 사용한 경우 page -> request -> session -> application 순으로
//    찾아서 데이터를 사용한다.
//    직접 지정을 하고자 하는 경우에는 pageScoped.이름 의 형태로 scope	를 직접 지정 해 주면 된다.

// **parameter
// 클라이언트 에서 서버로 전달하는 데이터

// 1. 전달 방법
// 1-1. url?이름=값&이름=값...

// 1-2. form 을 만들어서 사용자의 입력을 받아 전송
//      name이 있는 데이터만 전송

// 2. el 로 parameter 를 출력하고자 하는 경우
//    ${param.파라미터이름}
//    ${paramValues.파라미터이름}

// **Cookie
// 클라이언트의 정보를 클라이언트의 브라우저에 저장하고 서버가 이용하는 데이터
// 1. 생성 및 저장
//    Cookie ? = new Cookie(String name, String value);
//    response.addCookie(?);

// 2. 모든 쿠키 가져오기
//    Cookie [] ? = request.getCookies();
//    배열을 순회 하면서 getName(), getValue() 을 이용해서 쿠키의 이름과 값을 읽을 수 있다.

// 3. 쿠키 삭제
//    setMaxAge(초단위) 를 이용해서 삭제되는 시간을 지정하여 시간이 되면 삭제하도록 한다.

// 4. el 에서 쿠키 출력
//    ${cookie.쿠키이름}


// **초기화 파라미터
// web.xml 파일에 name 과 value 를 설정 해 두고 애플리케이션이 시작할 때 읽어서
// application 객체에 저장하는 데이터
// 초기화 파라미터는 처음에 설정된 내용을 읽을 수는 있지만 수정할 수는 없다.
// 설정 내용이 변경 가능성이 있는 경우 web.xml 파일에 작성해 두는 것이 좋다.
// 변경 가능성이 있는 내용을 java 코드에 문자열 상수를 이용해서 대입해 변경을 하게 되면
// 문자열 상수를 변경해야 하는데 코드가 변경된 상황이므로 java 파일들을 다시 컴파일 해서 class
// 파일로 만들어 주어야 한다.
// # 컴파일을 다시 해서 클래스를 다시 만들게 되면 예기치 않은 에러가 발생할 수 있다.
//   이러한 오류를 줄이는 방법으로는 변경 가능성이 있는 설정 내용을 파일에 기록해 두고 읽게 되면
//   내용이 변경 되더라도 자바코드를 변경한 것이 아니기 때문에 컴파일을 다시 할 필요가 없다.

// .java(Source File - 개발자가 작성) -> .class(중간 코드 - IDE 가 생성하거나 직접 컴파일) -> run
// .java 를 만들거나 .java 파일을 수정하면 IDE	가 자동으로 인식해서 .class 를 다시 만들어준다.
// IDE 가 종종 class 파일을 만드는데 실패하는 경우가 있다.
// .java 는 있어도 .class 가 없기 때문에 ClassNotFoundException 이 발생한다.

// # 변경 가능성이 있는 숫자나 문자열 데이터는 되도록이면 별도의 파일에 작성해서 
//   읽도록 해 주는 것이 권장된다.
//   이 방식은 숫자나 문자열 데이터가 변경 되더라도 소스 코드 변경 없이 데이터를 사용할 수 있다.

// # java web application 은 시작될 때 web.xml 파일을 읽고 시작한다.
//   변경 가능한 데이터를 web.xml 파일에 기록해 두게 되면 다른 파일을 생성해서 저장할 필요가 없다.

// 1. 데이터 저장 - web.xml
//    <context-param>
//      <param-name>파라미터이름</param-name>
//      <param-value>파라미터 데이터</param-value>
//    </context-param>

// 2. 데이터 읽기
//    String application.getInitPatameter(String 파라미터이름)

// 3. EL 을 이용해서 출력하기
//    ${initParam.파라미터이름}

// # 데이터베이스 접속 정보를 이러한 형태로 저장하는 경우가 많다.


// # 자바 알고리즘 학습 사이트
// http://www.jungol.co.kr/
// https://algospot.com/judge/problem/list/18

// 자바 문법 샘플 코드 사이트
// http://www.java2s.com/Tutorial/Java/CatalogJava.htm


package Web;

public class 필기0829 {

}
