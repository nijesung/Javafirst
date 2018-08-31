// **파라미터 전송 방식
// 1. get
//    url 에 파라미터를 붙여서 전송
// 2. post
//    본문에 저장해서 전송
//    (passward, file textarea) 가 있으면 반드시 post 로 전송


// **파라미터 생성
// 1. URL 가장 뒤에 ? 를 추가하고 이름 = 값 & 이름 = 값...
//    게시판의 상세 보기 구현에 많이 이용

// 2. form 의 name 이용

// 3. ajax 의 경우는 파라미터를 별도로 만들어서 전송


// **서버에서 파라미터 읽기
// HttpSevlet Requset 클래스의 객체 이용
// JSP 에서는 request	라는 이름으로 이미 존재(내장 객체)
// Servlet 에서는 doGet 과 doPost	의 첫 번째 매개변수로 제공
// ex) String getParameter(String name) - name 이 form 의 name 과 같아야 한다.
//     입력 된 내용이 없을 때는 ""
//     없는 name 을 사용하면 null
// ex2) String[]getParameterValues(String name)
//      배열로 리턴하는 경우는 checkbox, select 만들었을 때


// **파라미터의 인코딩(어떤 문자를 컴퓨터에 저장하기 위해 숫자로 변환하는 방법) 처리
//                ([WEB]euc-kr, utf-8)([응용 프로그램]ms949, cp949)
// # 겟과 포스트 방식은 면접 볼 때 꼭 보고 갈 것!
// 1. get 방식일 때
//    주소에 붙어서 올 때는 WAS 가 처리
// 2. post 방식일 때
//    java 에서 처리
//    request.setCharacter Encoding("인코딩 방식")


// **Parameter
// 클라이언트 에서 서버에게 전송하는 데이터
// 1. 전송 방식
// 1-1. get
//      URL 뒤에 붙여서 전송하는 방식
//      속도는 빠르지만 보안이 취약하고 길이에 제한이 있다.

// 1-2. post
//      본문에 저장해서 보이지 않게 전송하는 방식
//      보안이 우수하고 길이에 제한이 없다.

// 2. 작성 방식
// 2-1. URL	뒤에 직접 ? 를 추가하고 이름=값& 의 형식으로 직접 추가하는 방법
//      get	방식으로만 전송할 수 있다.
// 2-2. form 을 만들고 그 안에 name 을 갖는 개체들을 만드는 방법
//      get 과 post 모두 가능
// 2-3. ajax 의 경우 별도로 파라미터를 묶어서 전송
//      get 과 post 모두 가능

// 3. 파라미터 읽기
// 3-1. String getParameter(String name)
//      하나의 값만 넘겨주는 경우 호출

// 3-2. String [] getParameterValues(String name)
//      여러 개의 값을 넘겨주는 경우 호출
//		select 태그에 multiple 속성을 설정한 경우와 checkbox 인 경우

//      request 객체를 이용해서 읽는다.

// ex) get 방식으로 전달된 파라미터 읽기

// 4. 파라미터의 인코딩 처리
//    get 방식
//    WAS 가 인코딩 처리를 하는데 tomcat7.0 이상 버전 부터는
//    utf-8 로 인코딩을 설정 해 준다.
//    그 이하 버전에서는 requestURI='utf-8' 이라는 옵션을 서버 설정에 추가해 주어야 한다.

//    post 방식
//    파라미터를 읽는 곳에서 해야 한다.
//    파라미터를 읽기 전에 requset.setCharacterEncoding("utf-8"); 을 호출해서
//	  파라미터의 인코딩을 설정해 주어야 한다.


// #request	에는 header의 값을 읽는 메소드도 존재


// **response
// 응답 객체- 클라이언트 에게 응답하기 위해서 사용하는 객체
// 1. 헤더에 데이터를 저장
//    setHeader, addHeader 메소드를 이용해서 맵과 같은 방식으로 데이터를 저장해서
//    전달 할 수 있다.
// 2. 현재 페이지를 캐싱하지 않도록 하고자 할 때는 Cache-Control 과 Pragma 라는 키에
//    no-cache 를 설정하면 된다.
//    firefox 에서는 인식을 못 하는 경우가 있을 수 있으므로 Cache-Control 에
//    no-store 도 추가해 주어야 한다.

// 3. 자바 코드로 페이지 이동
// 3-1. forwarding
//      현재의 흐름을 그대로 가지고 이동하는 방법이다.
//      데이터 조회를 할 때 주로 이용한다.
// 3-2.	redirect
//      현재까지의 흐름을 종료하고 새로운 흐름을 만들어서 이동하는 방법
//      데이터 삽입, 삭제, 갱신을 하고 난 후 이동할 때 이용한다.
//      response.sendRedirect("이동할 페이지 경로");


// **out 객체
// jsp 파일에서 html 출력을 위한 객체
// 서블릿 에서는 response.getWriter() 로 받아서 사용을 한다.
// html 출력 메소드
// print(출력 내용)
// 모아서 출력
// println(출력 내용)
// 바로 바로 출력


// **pageContext 를 이용한 forwarding 과 response 를 이용한 redirect
// forwarding 은 현재 도메인 내에서만 이동이 가능하다.
// forwarding 은 URL 을 변경시키지 않는다.
// pageContext.foward(포워딩할 URL 을 문자열로 설정) 를 이용하면 forwarding 할 수 있다.


// **web.xml
// 자바 웹 프로젝트 설정 파일
// 톰캣 기반의 자바 웹 프로젝트의 설정 파일
// 1. server.xml
//    톰캣 설정 파일
//    프로젝트를 실행하면 맨 처음 읽어내는 파일이다.
//    워크스페이스를 변경하거나 서버를 삭제하면 처음 실행될 때 톰캣 디렉토리에서 복사해
//    현재 워크스페이스의 서버에 저장한 후 사용한다.
//    이 파일의 내용은 일반적으로 서버 관리자가 수정을 한다.

// 2. web.xml
//    자바 웹 프로젝트의 설정 파일
//    현재 프로젝트에 추가하면 추가한 설정을 가지고 실행이 되면 추가하지 않으면
//    톰캣 디렉토리에서 복사한 내용을 가지고 실행을 한다.

// 2-1.	프로젝트를 실행했을 때
//      외부에서 별도의 페이지 경로를 입력하지 않고 도메인만 입력했을 때 보여지는 페이지 설정
//      외부에서 도메인만 입력하면 register.jsp 가 출력된다.
//      <welcome-file-list>
//       <welcome-file>register.jsp</welcome-file>
//      </welcome-file-list>
//      네이버만 다음은 index.html 이 웰컴 파일이다.

// 2-2. 초기화 파라미터 설정
//      웹 프로젝트가 시작할 때 읽어올 문자열 데이터를 설정할 수 있다.
//      내용이 많을 때는 별도의 파일을 만들어서 읽어오고 내용이 많지 않을 때는
//      web.xml 파일에 작성한다.
//      이 내용은 application 객체를 이용해서 읽을 수 있다.
//      설정 방법
//      <context-param>
//	        <description>파라미터 설명</description>
//			<param-name>파라미터이름</param-name>
//			<param-value>파라미터값</param-value>
//      </context-param>


// **Application 객체
// 웹 애플리케이션 전체에 1개만 생성되는 객체
// 웹 애플리케이션 내의 모든 페이지와 서블릿이 공유하는 객체

// 1. 초기화 파라미터를 읽는 메소드(web.xml 파일의 context-param)
//    String getInitParameter(String parameter이름)
//    없는 이름을 사용하면 null 이 리턴된다.

// ex) web.xml 파일에 파라미터를 추가
//     <context-param>
//     <param-name>dbname</param-name>
//     <param-value>oracle</param-value>
//     </context-param>

//     register.jsp 파일에서 application 객체를 이용해서 위의 내용을 읽어보기
//     프로젝트를 재실행 해서 확인


// **변경 가능성이 있는 데이터의 저장
// 파일이나 데이터베이스에 저장
// 파일의 내용을 다시 읽어오거나 재 실행하면 된다.

// 자바 클래스에 저장
// 변경이 발생하면 자바 소스 파일을 다시 컴파일 해서 클래스를 만들고 재실행 해야 한다.

// 개발 환경과 배포 환경이 다른 경우가 많은데 개발 환경과 배포 환경이 다른 부분을
// 자바 소스 코드에 작성하게 되면 개발 후 배포 할 때 소스 코드를 변경하게 되어 예측할
// 수 없는 에러가 발생할 가능성이 있다.

// 2. application.log(Srtring msg)
//    WAS 의 logs 라는 디렉토리에 날마다 텍스트 파일을 만들어서 log 안의 내용을 기록한다.
//    일반적으로 log 는 별도의 파일을 생성해서 기록을 한다.
//    자바에서 문자열을 파일에 기록할 때 사용하는 클래스는 PrintStream 클래스 이다.



package Web;

public class 필기0825 {

}
