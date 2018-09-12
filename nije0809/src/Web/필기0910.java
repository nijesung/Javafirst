// **File Upload
// 클라이언트의 브라우저 에서 서버에게 파일을 업로드하기 위해서는 클라이언트의 로컬 파일을
// 선택할 수 있도록 해 주는 <input type="file"> 태그가 존재해야 한다.
// 파일을 전송하는 form 태그의 method 속성은 반드시 post 이어야 하며
// enctype="multipart/form-data" 이어야 한다.
// post 를 설정하는 이유는 get 은 전송할 수 있는 데이터의 크기에 제한이 있기 때문이며
// enctype 을 설정하는 이유는 내용이 많을 때는 분할 전송이 가능해야 하기 때문이다.

// 파일 업로드를 서버에서 처리하는 방식은 여러 가지가 있는데 그 중에서 cos 라이브러리를 이용하는
// 경우에는 MultipartRequest 라는 클래스의 객체를 만드는 것만으로 업로드가 가능해 진다.

// ex) 파일을 업로드하면 현재 프로젝트의 upload 라는 디렉토리에 저장하기

// 	   1. 다이나믹 웹 프로젝트를 생성(Web.xml 포함)
//     2. 프로젝트에 필요한 라이브러리를 추가
//     2-1. servlet-api(HttpServlet 클래스 사용을 하기 위해)
//     2-2. jstl.jar(jstl 을 사용하기 위해)
//     2-3.	cos.jar(파일 업로드 기능을 사용하기 위해)
//     3. 시작 페이지로 사용할 index.jsp 파일을 Webcontent 디렉토리에 생성하고 링크를 추가
//     4. 확장자가 file 인 요청을 처리하는 Servlet 클래스 만들기: Controller
//	      controller.FileController
//     5. fileupload.file 요청을 처리하기 위한 코드를 FileController 클래스의
//	   6. WebContent 디렉토리에 views 라는 디렉토리를 만들고 fileupload.jsp 파일에
//		  파일 업로드 화면을 디자인
//     7. 파일 업로드 처리를 위한 메소드를 소유한 인터페이스 생성
// 		  service.FileUploadService
//     8. 파일 업로드 처리를 위한 메소드를 구현한 클래스를 생성
//		  service.FileUploadSeviceImpl
//     9. Controller 클래스에 파일 업로드 요청을 위한 코드를 작성
//	   9-1. fileupload.jsp 파일의 action 에 요청 경로를 생성

//     10. 업로드 결과를 출력할 페이지를 생성하고 작성
// 		   views/result.jsp
//     11. Webcontent 디렉토리에 파일이 업로드 될 디렉토리를 생성하고 실행
//     12. 파일이 업로드 된 결과는 프로젝트 에서는 확인이 되지 않으며 프로젝트가 실행되는 디렉토리로
//         가야만 확인이 가능하다.
//         workspace 의 .metadata 를 확인해야 한다.
//	       이 때 .metadata 는 숨김 디렉토리이다.
// 		   숨긴 디렉토리를 보고자 할 때는 shift + command + .
//		   리눅스나 유닉스에서 앞에 . 을 붙이면 숨김파일 이다.
//	       윈도우 에서는 바로 보인다.
//		   

// **파일 업로드 처리
// 파일 업로드를 처리할 라이브러리를 프로젝트에 추가
// # 파일을 저장할 디렉토리를 생성- 서버를 직접 운영하는 경우는 프로젝트 내부 이외의 디렉토리에 저장이 가능
//   서버를 직접 운영하지 않고 호스팅을 이용하는 경우에는 프로젝트 내부 디렉토리에 저장 하도록 설정해야 한다.
//   서버 내부 디렉토리의 절대 경로를 가져오는 메소드
//   request 객체의 getRealPath("/프로젝트내부경로")를 이용 하거나 application 객체의
//   getRealPath("/프로젝트내부경로") 를 이용하는데 request 객체의 메소드는 서블릿 3.0부터
//   deprecated 이다.

// cos 라이브러리를 이용해서 파일을 업로드 할 때는 MultipartRequest 객체를 생성하면 된다.
// 이후에 파라미터를 읽을 때는 request 대신에 MultipartRequest 객체를 이용해야 한다.


// **Service
// 사용자의 요청을 실제 처리하는 클래스
// 클라이언트의 요청이 단순한 페이지 이동이 아닐 때는 Controller 에서 Service 인스턴스를 이용해
// 처리하도록 해야 한다.
// 템플릿 메소드 패턴을 이용하고 싱글톤 패턴을 이용한다.


// **자료실 만들기
// 1. 데이터베이스에 접속하여 테이블을 생성한다.
// 	  구분하기 위한 번호로 사용할 코드- code(정수, 기본키)
//	  파일이름을 저장하기 위한 문자열- filename(문자열 50자)
//	  파일크기를 저장하기 위한 정수- filesize(정수 10자리)
//	  파일에 대한 설명을 저장하기 위한 문자열- description(문자열 200자)

//	  create table pds(
//	  	code number(10) primary key,
//	    filename varchar2(50),
//	    filesize number(10),
//		description varchar2(200));

// 2. 데이터베이스를 사용할 때는 반드시 데이터베이스 드라이버 파일을 프로젝트에 추가해야 한다,
//	  ojdbc6.jar 파일을 프로젝트의 WEB-INF/lib 디렉토리에 추가

// 3. 업로드 될 파일이 저장될 디렉토리를 생성
//	  WebContent/pdsupload

// 4. 데이터베이스 접속정보를 META-INF 디렉토리의 context.xml 파일에 작성

// 5. web.xml 파일에 context.xml 파일의 내용을 읽는 설정을 추가

// 6. Pds 테이블의 데이터를 표현할 VO 클래스를 생성

// 7. 데이터베이스 작업을 위한 메소드를 소유한 인터페이스를 생성

// 8. 데이터베이스 작업을 위한 메소드를 구현할 클래스를 생성

// 9. 사용자의 요청을 처리할 메소드를 소유한 인터페이스를 생성

// 10. 사용자의 요청을 처리할 메소드를 구현한 클래스를 생성

// 11. Controller 로 사용할 Servlet 클래스에 서비스 변수를 선언하고 생성자에서 인스턴스를 생성해서 대입


// **데이터 저장
// 1. index.jsp 파일에 데이터를 입력하기 위한 파일로 이동할 수 있는 링크를 추가
//    <a href="input.file">데이터 입력</a><br />

// 2. FileController 클래스의 doGet 메소드에 input.file 요청이 왔을 때 데이터 입력 페이지로 포워딩 하는 코드를 추가

// 3. WebContent/views 디렉토리에 input.jsp 파일을 생성하고 데이터 입력화면을 디자인

// 4. PdsDao 인터페이스에 데이터 삽입을 위한 메소드를 선언
//	  가장 큰 code를 메소드, 실제 데이터를 삽입하는 메소드

// 5. PdsDaoImpl 클래스에 메소드 구현

// 6. PdsService 인터페이스에 데이터 삽입을 처리하는 메소드를 선언
//	  데이터 삽입을 처리하기 위한 메소드

// 7. PdsServiceImpl 클래스에 메소드 구현

// 8. FileController 클래스에 데이터 삽입 요청이 왔을 때 처리하는 코드를 doGet 메소드에 추가


// **데이터베이스에서 pds 테이블의 전체 데이터를 가져와서 출력하기
// 1. PdsDao 인터페이스에 전체 데이터를 가져오는 메소드를 선언

// 2. PdsDaoImpl 클래스에 전체 데이터를 가져오는 메소드를 구현

// 3. PdsService 인터페이스에 Pds 테이블의 전체 데이터를 가져오는 메소드를 선언

// 4. PdsServiceImpl 클래스에 Pds 테이블의 전체 데이터를 가져오는 메소드를 구현

// 5. index.jsp 파일에 전체 데이터를 출력하는 요청을 생성

// 6. Controller 클래스에 list.file 요청을 처리하는 코드를 doGet 메소드에 추가

// 7. WebContent 디렉토리의 views 디렉토리에 list.jsp 파일을 만들고 데이터 출력




package Web;

public class 필기0910 {

}
