// **프로젝트 관리 도구(빌드 도구)
// Eclipse 에서 제공하는 Maven,
// intelli J 에서 제공하는 Gradle 이 있다.
// Android Studio 는 Gradle 방식
// 프로젝트 관리 내용에 있어 Maven 은 porm.xml 파일에 기재하고
// Gradle 은 json 파일에 기록한다.


// **Email 보내기
// 1. Maven WebApp 프로젝트 생성

// 2. src/main 에 자바클래스를 보관할 수 있는 java 디렉토리 생성

// 3. 사용할 라이브러리 정보를 porm.xml 파일에 작성

// 4. index.jsp 파일에 메일 보내기 링크를 설정

// 5. 사용자의 요청을 처리할 메소드를 선언할 인터페이스 생성
//	  service.EtcService

// 6. 사용자의 요청을 처리할 메소드를 구현할 클래스 생성
//	  service.EtcServiceImpl

// 7. 확장자가 do 로 끝나는 모든 요청을 처리할 수 있는 Controller 클래스를 만들고 기본 작업

// 8. WebApp 디렉토리에 views 디렉토리를 만들고 emailsend.jsp 파일을 생성하고 작성

// 9. EtcService 인터페이스에 메일 보내기 메소드를 선언

// 10. EtcServiceImpl 클래스에 메일 보내기 메소드를 구현


// **Proxy
// 내부에서 외부 도메인 요청을 할 때 거쳐가도록 하는 서버
// ajax 는 도메인 요청만 가능하다.
// 서버가 다른 도메인의 요청을 ajax 로 요청할 수 있도록 설정을 하면 데이터를 전송할 수 있다.
// ajax 로 외부 도메인의 데이터를 가져오고자 할 때는 proxy 서버를 만들어서 poxy 서버에게
// 데이터를 요청하고 proxy 서버가 외부 도메인의 데이터를 가져와 전달하는 방식으로 해야 한다.
// Java 에서는 URLConnection 클래스를 이용하여 proxy 서버를 구축할 수 있다.

//    **jquery 링크 설정
//	  다운로드 받아 프로젝트에 저장하고 링크를 설정할 수도 있고 그냥 외부 링크를 설정해도 된다.
//	  jquery 에서 ajax 사용
//	  $.ajax({
//		url:요청 url,
//		data:{파라미터이름:값, 파라미터이름:값..},
//		dataType:text | xml | json,
//		method:get 또는 post,
//		success:function(data){
//		// 데이터를 가져오는데 성공했을 때 수행할 내용
//		// data 는 파싱된 결과이다.
//	    },
//		error:function(error){
//		// 실패했을 때 수행할 내용
//		}

// ex) 기상청 xml 데이터를 ajax 로 가져와 파싱한 후 출력하기
// 	   1. EtcService 인터페이스에 기상청 데이터를 가져오는 메소드를 선언
//		  public String proxy(HttpServletRequest request);

//	   2. EtcServiceImpl 클래스에 기상청 데이터를 가져오는 메소드를 구현

//     3. Controller 클래스에 proxy.do 요청을 처리하는 코드를 doGet 메소드에 추가

//	   4. views 디렉토리에 출력할 proxy.jsp 파일을 생성하고 데이터를 출력

//     5. HTML5 의 Web Push	
//		  전통적인 클라이언트 - 서버 시스템의 통신방식
//		  클라이언트가 서버에게 데이터를 요청하고 서버가 요청을 받아 처리하고 그 결과를
//		  클라이언트 에게 전송하는 방식이다.
//		  Web Push 는 클라이언트가 서버에 연결을 한 상태라면 서버가 클라이언트의 요청 없이
//		  데이터를 전송하는 기술
// 		  Web 이 아니라 Apple Server 가 iOS 에게 전송하는 것을 APNS 라 일컫으며
//		  Google 서버가 Android 에게 전송하는 것을 FCM 이라고 한다.

// ex) 5초마다 랜덤한 숫자를 클라이언트에 전송
// 	   1. EtcService 인터페이스에 푸시를 위한 메소드를 선언
//		  public void push(HttpServletRequest request, HttpServletResponse response);

//	   2. EtcServiceImpl 에

//     3. Controller 클래스에 push.do 요청이 왔을 때 처리하는 코드를 doGet 메소드에 추가

//	   4. index.jsp 파일에 웹 푸시를 받을 수 있는 코드를 작성
//	   4-1.	body 태그 안에 버튼과 출력 영역을 생성
//	   4-2. 


// **웹 소켓을 이용한 채팅 만들기
// 1. porm.xml 파일에 웹 소켓 라이브러리를 가져오는 코드를 추가

// 2. 웹 소켓 클래스 생성

// 3. index.jsp 파일에 채팅 창을 생성하는 코드를 추가
//




package Web;

public class 필기0911 {

}
