// **<jsp:include>
// 다른 페이지의 수행 결과를 가져와서 사용하고자 할 때 사용하는 태그
// page 속성에 가져올 페이지 URL	을 설정
// flush 속성에 boolean 문자열로 flush 여부를 설정 - 보통은 false
// 수행 결과를 가져와 삽입하는 개념이다.
// 변수를 공유할 수는 없다.

// # sub.jsp 파일의 결과가 main.jsp 파일에 포함이 되는데 불필요한 태그가 중복으로 만들어져
//   제거할 때 밑의 태그는 삭제하면 안 된다.
//   <!-- 사용하는 프로그래밍 언어를 설정하고 출력하는 파일의 종류를 설정하는 구문
//   현재 페이지 코딩의 인코딩 방식을 설정한다.
//   출력하는 jsp 파일의 경우 이 태그는 삭제하면 안 된다. -->
//   <%@ page language="java" contentType="text/html; charset=UTF-8"
//   pageEncoding="UTF-8"%>

// # 포함하는 페이지에서 포함된 페이지에게 데이터를 넘기는 방법
// <jsp:include page="포함될 페이지 경로" flush="버퍼 내용을 내보내는 옵션">
//    <jsp:param name="이름" value="값" />
// </jsp:include>

// 위처럼 작성하면 포함되는 페이지에서 request.get.Parameter("이름") 을 이용해서 가져올 수 있다.

// ex) main.jsp 파일에서 sub.jsp 파일로 데이터 넘기기

// # 파라미터를 읽었는데 null 이 나오면 파라미터 이름을 확인한다.
//   한글이 깨지면 requset.setCharacterEncoding("인코딩 방식")	 을 확인해야 한다.
//   현재 인코딩 방식은 특별한 경우가 아니면 utf-8 이다.
//   이 기능은 동일한 레이아웃을 가진 페이지가 여러 개 있는 경우 사용


// **include 디렉티브
// 중복된 코드를 삽입하기 위한 디렉티브
// java 에서는 보통 상속으로 이 부분을 해결
// 여러 곳에서 사용되는 코드는 하나의 코드를 만들어서 동적으로 삽입하는 방식을 사용하는 것이 좋은데
// 그 이유는 유지보수 때문이다.
// 동일한 코드가 여러 곳에 존재하는 것을 스파게티 코드라고 하는데 스파게티 코드는 유지보수를 어렵게 하는
// 대표적인 코드이다. 수정을 해야 하는 경우 개발자가 전부 찾아 직접 수정해야 하기 때문이다.
// 자바의 상속이나 jsp 의 include 디렉티브를 이용하면 한 번만 수정하면 된다.
// 파이썬이나 자바스크립트 같은 언어가 함수형 프로그래밍 언어이면서도 객체 지향을 받아 들인 이유이기도 하다.
// 최근 자바스크립트는 객체 지향 문법을 받아들인 Type Script 나 ECMA Script 쪽으로 변화하고 있다.

// 1. 파일의 소스 코드를 포함시키는 방법
//    <%@ include file="파일경로" %>
//    이 기능은 소스코드를 포함시키는 것이므로 일반적으로 출력하는 용도로는 잘 사용하지는 않는다.
//    구분하기 위해서 확장자를 jspf 로 하는 경우가 많다.
//    we리는 Model2 방식을 사용하기 때문에 이 기능을 사용하는 경우는 극히 드물다.

// ex2)	프로젝트의 WebContent 디렉토리에 include 라는 디렉토리 만들기
//      포함되는 파일을 include 디렉토리에 생성하고 코드를 작성: sub.jspf
//      sub.jspf 파일의 코드를 포함하는파일을 include 디렉토리에 생성하고 코드를 작성: main.jsp

// **url 패턴
// 여러 개의 url 을 묶어서 표현하기 위한 방법
// 1. 모든 URL
//    /*
//    ( / 는 확장자가 .jsp 인 url 을 제외한 모든 url 을 뜻하며 Spring 에서만 사용 가능)

// 2. 확장자로 끝나는 URL
//    *. 확장자
//    (우리나라 공공기관은 확장자를 do로 끝내는 형식을 많이 사용하고 네이버는 nhn 이라는 확장자를 사용한다.

// 3. 디렉토리가 포함된 URL (최근의 URL 은 디렉토리 패턴을 사용하는 것을 권장)
//    /디렉토리이름/*

// 4. 일반 URL
//    URL



// **클라이언트 브라우저에서 서버에게 요청하는 방법
// 1. a 태그
//    사용자의 입력 없이 이동할 때 사용
//    <a href="요청할 URL">텍스트 또는 img</a>

// 2. form 태그
//    <form action="서버URL">
//
//    </form>

// 3. java script 이용
// 3-1. 페이지 요청
//      location.href="요청 URL"
//      window.location="요청 URL"

// 3-2. history 객체 이용
//      history.back()
//      이전	URL	요청
//      history.forword()
//      다음 URL 요청
//      history.go(숫자)
//      숫자 만큼 back() 을 하거나 forword() 수행
//      history.go(url)
//      url 로 이동

// 3-3. 현재 URL 새로고침
//      location.reload()

// 3-4. 폼 데이터 전송
//      폼객체.submit()

// 3-5.	ajax 요청
//        // ajax 요청 객체 생성
//    	  var request = new XMLHttpRequest();
//    	  // 요청을 생성하고 요청
//    	  request.open('파라미터 전송방식', '요청 URL');
//    	  request.send('POST 방식일 때의 파라미터');
//    	  // ajax 요청에 성공하면 호출되는 콜백 메소드 등록
//    	  request.onreadystatechange = function(){
//    		  if(request.readyState == 4){
//    			  if(request.status >= 200 && request.status < 300){
//    				  alert("요청 성공"); // 데이터를 받아오는 데 성공했을 때 수행할 내용
//    			  }
//    		  }
//    	  }

// ex) 요청을 보내는 페이지 - input



// **parameter
// 클라이언트가 서버에게 전송하는 데이터
// 1. 전송 방식
// 1-1. get
//      url 뒤에 ? 를 붙이고 파라미터 이름=값 의 형식으로 전송하는 방식
//      여러 개의 파라미터를 전송하고자 하면 & 를 추가하고 작성하면 된다.
//      한글을 전송할 때는 인코딩 해서 전송해야 한다.
//      자바스크립트는 encodeURI(문자열)을 이용해서 인코딩한다.
//      자바는 java.net.Encoder.encode(String 인코딩할 문자열, String 인코딩방식) 을 이용해서 인코딩

// 1-2. post
//      본문에 데이터를 숨겨서 전송하는 방식
//      폼과 ajax 에서만 가능

// 2. 서버에서 파라미터 읽기
//    String request.getParameter("파라미터이름")
//    String [] request.getParameterValues("파라미터이름"):
//    checkbox, select 의 경우

// 3. 서버에서 파라미터 인코딩 해서 읽기
//    get 방식은 WAS 가 처리
//    post 방식은 파라미터를 읽기전에 request.setCharacterEncoding("인코딩방식")을 호출



// **자바에서 요청을 처리하고 결과 페이지로 이동하는 방법
// 1. forwarding
//    url 을 변경하지 않고 결과 페이지로 이동
//    새로 고침을 하게 되면 요청을 다시 처리한다.(중복구매 생각해보면 됨)

// 1-1.	태그로 이동
//      <jsp:forward page="결과 페이지 경로"/>

// 1-2.	자바 코드로 이동
//      RequestDispatcher 변수명 = request.getRequesDispatcher("결과 페이지경로");
//      변수명.forward(request객체, response객체);

// 2. redirect
//    url 을 변경해서 이동
//    새로 고침을 하게되면 결과 페이지가 새로고침이 된다.
//    response.sendRedirect("리다이렉트 할 URL");

// 3. 자바에서 결과 페이지로 이동할 때 유의사항
//    새로고침을 했을 때 이전 처리가 다시 되지 않아야 한다면 반드시 redirect 를 해야 한다.
//    포워딩은 현재 도메인(자신의 웹 애플리케이션) 내에서만 가능하다.
//    리다이렉트는 다른 도메인으로도 가능하다.

// 4. 처리하는 부분에서 결과 페이지로 데이터를 전달(attribute)
//    attribute	는 4개의 객체가 가지고 있다.
//    page, request, session, application
//    page 는 현재 페이지에만 유효한 객체
//    request 는 포워딩 할 때만 공유되는 객체로 그 이외의 방법으로 페이지 이동을 하게 되면 새로 생성된다.
//    session 은 하나의 웹 브라우저에 해당하는 객체로 웹 브라우저를 종료하지 않는다면
//    계속 동일한 세션을 이용한다.
//    application 은 웹 애플리케이션 내의 모든 곳에서 공유할 수 있는 객체로 1개만 존재한다.
//    전체 접속자 수 등을 저장한다.

// 4-1. 저장하는 메소드
//      void setAttribute("키이름", Object 데이터)
//      데이터는 어떤 자료형이든 대입이 가능하다.

// 4-2. 읽어오는 메소드
//      Object getAttribute("키이름")
//      리턴 타입이 Object 이기 때문에 바로 출력하는 경우를 제외하고는 반드시 저장할 때의
//      자료형으로 형 변환하여 사용해야 한다.
//      없는 키 이름을 사용하면 null 이 리턴된다.

// 4-3.	삭제하는 메소드
//      void removeAttribute("키이름)
//      없는 이름을 사용하면 null 이 리턴되기 때문에 setAttribute("키이름, null)도 지운 것과
//      동일한 효과를 나타낸다.

//      forwarding 하는 코드가 있을 때는 새로 고침을 하면 콘솔에 이전에 입력했던 내용이 다시 출력된다.
//      처리가 다시 수행되는 것이다.
//      결과 페이지에는 리퀘스트 라는 텍스트와 세션이라는 텍스트가 모두 출력된다.
//		forwarding 될 때는 request 객체와 session 객체 모두 공유된다.

//		redirect 하는 코드가 있을 때는 새로 고침을 하면 콘솔에 이전에 입력했던 내용이 다시 출력되지 않는다.
//		결과 페이지만 새로 고침이 된다.
//		결과 페이지에는 null 과 세션이라는 텍스트가 출력된다.
//		redirect 될 때는 request 객체는 새로 만들어지고 session 객체만 공유된다.



// **데이터베이스 접속 IP: 192.168.10.101
//   포트번호: 1521
//   sid: xe
//   계정: user01~ user30
//   비번: user01~ user30

package Web;

public class 필기0827 {

}
