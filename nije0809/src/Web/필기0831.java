// # JSTL 을 사용하고자 하는 경우 먼저 jstl.jar 파일을 프로젝트의 build path 에
//   추가해 주어야 한다.
//   웹 프로젝트는 WEB-INF/lib 디렉토리에 복사 해 주면 된다.

// **JSTL 의 다국어 설정
// <fmt:setBundle> 과 <fmt:message>	태그 이용
// 다국어로 사용할 문자열을 동일한 대표이름_언어코드 properties 파일을 만들어서
// key = 값 의 형태로 작성하여 WEB-INF/classes 디렉토리에 저장한다.
// 다국어를 사용할 jsp 페이지에서 fmt:setBundle 태그의 basename 속성에 대표이름을 설정한다.
// 사용하 다국어 메시지를 출력할 때는 fmt:message key = key이름 태그를 이용해서 출력한다.

// 실습
// 언어 설정에 따라 title 이 다르게 보이는 예제
// 1) WEB-INF 디렉토리에 classes 디렉토리를 생성

// 2) classes 디렉토리 대표이름_언어코드.properties 파일을 생성해서 작성
// 	  intro_ko_properties
//    title=다국어지원

//	  intro_en.properties
//    title=multilang support

// 3) 다국어를 사용할 페이지를 생성 
//    fmt/multilang.jsp


// **Custom Action 태그
// 자주 사용하는 태그나 jsp 파일의 내용을 별도의 파일로 만들어 두고 태그 형식으로 호출하는 기능
// 작업 방법
// 1. 별도의 디렉토리를 생성
// 2. 디렉토리에 ?.tag 라는 파일을 만들어 자주 사용하는 코드를 작성
// 3. 가져다 사용하고자 하는 파일
//	  <%@ taglib tagdir="태그 파일의 디렉토리 경로" prefix="태그의 접두어를 설정" />
//    <접두어:파일명/>	을 입력하면 ?.tag 의 내용이 삽입된다.  

// 실습
// 1. WEB-INF 디렉토리에 tags 디렉토리를 생성


// **HttpServlet & JSP(Java Server Page)
// 1. HttpServlet
//    URL 을 이용해서 호출할 수 있는 자바 클래스
// 	  이 클래스는 웹 컨테이너가 관리
//	  매핑된 URL 에 해당하는 요청이 처음 왔을 때 인스턴스를 생성하고 요청을 처리한다.
//	  두 번째 요청부터는 앞에서 만든 인스턴스를 이용해서 처리한다.
//    서블릿의 인스턴스는 1개만 존재한다. - Singleton Pattern
//    자바 코드 안에 출력하는 HTML 코드를 삽입할 수 있는데 HTML	 코드를 작성하는 것은 불편하다.
//    용도는 주로 MVC	 패턴에서의 Controller 역할
//    사용자의 요청이 오면 필요한 비지니스 로직을 호출해서 작업을 수행시키고 
//    그 결과를 View 에게 전송하는 역할.(교모세포 같은 브릿지 역할만 가능)

// 2. JSP
//    URL 을 이용해서 호출할 수 있는 자바 파일
//    이 파일도 웹 컨테이너가 관리
//    매핑된 URL 에 해당하는 요청이 오면 먼저 Servlet 클래스 코드로 변환이 된 후
//    인스턴스를 생성하고 처리한다.
//    두 번째 요청이 오면 위의 작업을 반복한다. (싱글톤 패턴이 아님)
//    HTML 코드 안에 자바 코드를 삽입하는 구조이다.
//    자바 코드를 작성하는 것이 불편하다.
//    용도는 Controller 가 전달한 Attribute 를 출력하는 역할을 주로 수행한다.
//    자바 코드를 사용하지 않기 위해 되도록이면 EL 과 JSTL 을 이용해서 출력한다.

// 3. Servlet 과 URL 매핑
//    url 패턴
//    /* : 프로젝트 전체
//         일반 요청을 처리하는 용도로는 잘 사용하지 않고 대부분은 파라미터 인코딩 설정을
//         모든 곳에서 해야 경우에 이 URL 패턴을 이용해서 처리한다.
//    *. : 확장자로 끝나는 모든 요청
//		   예전에 많이 사용하던 패턴으로 공공기관은 확장자를 do 로 설정했고
//         네이버는 nhn 으로 설정했다.
// 		   https://sports.news.naver.com/general/index.nhn
//         
//    /디렉토리이름/* : 디렉토리 이름이 포함된 모든 요청
//    * 을 사용하지 않는 경로 : 경로 1개와 매핑
//    최근에 많이 사용하는 패턴으로 디렉토리를 이용해 서비스를 구분한다.
//    하나의 URL 뿐 아니라 URL 패턴과도 매핑 가능
//    URL 패턴 여러 개를 하나의 서블릿과 매핑이 가능하다.

// 3-1. web.xml 에서 매핑 설정 가능

//		<!— 서블릿 클래스의 이름을 생성 : 1번 만 작성 —>
//		<servlet>
//		     <servlet-name>서블릿이름</servlet-name>
//		     <servlet-class>클래스이름</servlet-class>
//		</servlet>

// <!— url 패턴과 위에서 만든 서블릿을 매핑 :  여러 번 작성 가능 —>
//	    <servlet-mapping>
//	         <servlet-name>서블릿이름</servlet-name>
//	         <url-pattern>/호출url</url-pattern>
//	    </servlet-mapping>

// 3-2. Servlet 클래스의 상단에 어노테이션을 이용해서 설정 가능

//      @WebServlet(“url패턴”)
//		@WebServlet(urlPatterns = {“url패턴”, “url패턴”})

// # 예전에는 web.xml 파일에 설정하는 경우가 많았는데 최근에는 어노테이션을 이용하는 경우가 많습니다.


// **parameter & attribute
// 1. parameter
//    클라이언트가 서버에게 전송하는 데이터
//    URL 뒤에 ? 를 추가하고 이름=값 의 형태로 전송가능
//	  form 에 입력 태그들을 만들고 name 을 설정해서 전송 가능
//    ajax 의 경우에는 별도로 만들어서 전송 가능

// 2. attribute
//	  서버가 결과 페이지에 전송하는 데이터
//    request 나 session 에 저장해서 전송

// 3. Controller(Servlet) 에서 결과 페이지로 이동하는 방법
// 3-1.	forwarding
//		URL	을 변경하지 않고 이동 - request 와 session 모두 공유
// 3-2.	redirect
//		URL 을 변경하고 이동 - session 만 공유

// # 일반적인 흐름 처리
//   요청 페이지 -> 요청을 처리할 수 있는 Servlet -> Service -> Dao -> Service ->
//   Servlet(데이터 저장) -> 결과 페이지	 

// 실습 - 회원가입 처리
// 1). 회원가입 정보를 입력하는 페이지
// 2). 요청을 처리하는 서블릿(URL 로 호출) - Controller
//     파라미터를 읽어서 콘솔에 출력하고 결과 페이지로 이동
//     forwarding

// 3). 결과를 출력하는 페이지 

// 4). form 의 메소드를 post 로 변경
//     한글을 입력해 전송하면 한글이 깨진다.
//     서블릿 에서 한글 파라미터를 처리하기 전에 아래 코드를 추가한다.
//     request.setCharacterEncoding("utf-8");

package Web;

public class 필기0831 {

}
