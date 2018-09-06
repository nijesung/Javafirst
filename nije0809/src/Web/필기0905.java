// **SubQuery
// 다른 SQL 문장의 절 안에 사용된 SQL
// 서브쿼리는 select 구문
// 서브쿼리를 만들 때는 () 로 감싸야 한다.
// 서브쿼리는 메인쿼리가 실행되기 전에 1번 실행된다.

// 1. 단일 행 서브 쿼리
// 	  서브쿼리의 결과가 1개의 행인 경우

// ex) usertbl 에서 name 이 구하라인 사람이 구입한 productname 을 buytbl 에서 조회

// 2. 다중 행 서브쿼리
//    서브쿼리의 결과가 여러 개인 경우
// 	  단일 행 연산자 사용불가(=, !=, >, >=, <, <=...)
// 	  in, not, any, all 등을 이용해야 한다.
//    any 나 all 은 max 나 min 함수를 이용하면 가능

// ex) productname 이 운동화 인 제품을 구매한 사람의 이름(name) 과 태어난 해(birthyear) 를 조회


// **Java 에서 관계형 데이터베이스 사용(JDBC)
// 1. 사용할 관계형 데이터베이스 드라이버 파일을 프로젝트의 build path 에 추가해야 한다.

// 2. 드라이버 클래스를 로드해야 한다.
//    Class.forName("드라이버 클래스 이름");

// 오라클
// oracle.jdbc.driver.OracleDriver
// MySQL
// com.mysql.jdbc.Driver

// 3. 데이터베이스 접속(Connection 타입으로 저장한다)
// 	  DriberManager.getConnection(데이텀베이스URL,계정,비밀번호);

//	  oracle URL
//    jdbc:oracle:thin:@IP 또는 localhost:포트번호:sid
//    IP: 192.168.10.100 - 1521 - xe

//    MySQL URL
//    jdbc:mysql://IP 또는 localhost:포트번호/데이터베이스이름?characterEncoding=인코딩방식&serverTimezone=UTC

// 4. Connection 을 이용해서 사용할 Statement 객체를 생성
//	  Statement, PreparedStatment(데이터 바인딩 가능), CallableStatement(프로시저 실행)

//    SQL 실행
//    1) select 구문
//       ResultSet executeQuery()
//       조회된 데이터의 모임이 리턴

//    2) select 이외의 구문
// 	     int executeUpdate()
//		 영향받은 행의 개수가 리턴
//       0이 리턴되는 경우는 SQL 은 정상적으로 수행되나 영향받은 행이 없다는 의미이다.
//		 SQL 이 잘못 된 경우는 예외가 발생한다.

// 5. 사용한 자원 정리
//    드라이버 다운로드: http://www.mvnrepository.com 에서 mysql 을 검색
// 	  http://www.mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.11 추천

// # 순서
// Dynamic Web Project 생성
// 1). mysql-connection.jar(MySQL 사용), servlet-api.jar(Servlet 사용), jstl.jar(jstl 사용)
//     파일을 WEB-INF 디렉토리의 lib 디렉토리에 복사
// 2). index.jsp(welcome 파일) 파일을 WenContent 디렉토리에 생성하고 작성
//     <%@ page language="java" contentType="text/html; charset=UTF-8"
//     pageEncoding="UTF-8"%>
//	   <!DOCTYPE html>
//	   <html>
//	   <head>
//	   <meta charset="UTF-8">
//	   <title>데이터베이스 사용</title>
//	   </head>
//	   <body>
//	   <a href="mysql.db">MySQL 연결</a><br />
//	   </body>
//	   </html>

// 3). 확장자가 do 인 요청을 처리할 수 있는 Servlet 클래스를 만들고 doGet 을 수정

// 4). 프로젝트를 실행하고 링크를 클릭했을 때 콘솔에 클래스이름과 해시코드가 출력되는 지 확인


// # 오라클 접속
// 1. ojdbc.jar 파일을 WEB-INF lib 디렉토리에 복사

// 2. index.jsp 파일에 오라클 접속 링크 생성

// 3. Servlet 클래스의 


// **Statement
// 데이터베이스 작업을 할 때 데이터베이스에 SQL 을 전송해서 실행하고 그 결과를 받아오는 인터페이스
// SQL 을 물음표를 이용해서 작성한 후 나중에 데이터를 바인딩 하여 사용할 수 있는 PreparedStatement 와
// 프로시저를 실행하기 위한 CallableStatement 가 있다.
// 다른 프로그래밍 언어에서도 preparedStatement 형식으로 데이터베이스에 SQL 을 전송한다.

// 1. 생성
// 	  PreparedStatement ppsm = Connection객체.preparedStatement(sql 작성);

// 2. sql 에 물음표를 사용한 경우에는 값을 바인딩
//	  ppsm.set자료형(물음표 번호, 대입할 데이터);
//    물음표의 자리는 insert 의 경우는 values 절에 대입되는 값들이다.
//    update 는 set 절과 where 절에서 변경할 내용이나 where 절의 조건이다.
//    delete 구문 또한 where 절의 조건이다.
//    select 구문이면 where 절의 조건에 대입되는 값이다.

// 3. SQL 실행
// 3-1.	select 구문이 아닌 경우
//      영향 받은 행의 개수 리턴
//		int executeUpdate()

// 3-2. select 구문의 경우
//      조회된 결과를 리턴
//      ResultSet executeUpdate()

// 4. ResultSet
//	  select 구문의 결과를 저장하는 인터페이스
// 4-1. boolean next()
// 	    다음 데이터의 존재 여부를 리턴 - false 를 리턴하면 더 이상 읽을 데이터가 없다는 뜻

// 4-2. 데이터 읽기
//	    ResultSet객체.get자료형(인덱스)
//	    인덱스 번째 컬럼의 값을 자료형으로 가져온다.
//		인덱스 대신에 컬럼이름을 문자열로 대입해도 된다.

// 4-3. getMetaData()
//	    조회된 데이터들에 대한 정보를 리턴하는 메소드

// ex) MySQL 의 usertbl 테이블에 데이터를 삽입

//     1). index.jsp 파일에 데이터 삽입 링크를 생성
//     2). 


// **buytbl 테이블의 전체 데이터를 가져와서 콘솔에 출력하기
// select * from buytbl
// * 대신에 컬럼 이름을 기재해도 된다.
// num(정수), userid(문자열), productname(문자열), groupname(문자열), price(정수), amount(정수)

// 1. 여러 개의 컬럼을 하나의 인스턴스로 만들 수 있는 VO 클래스를 생성
// 	  vo.Buy

// 2. index.jsp 파일에 링크 추가

// 3. Controller 클래스의 위의 요청을 처리하는 코드를 doGet 에 추가


// # num 을 파라미터로 전달해서 buytbl 테이블에서 num 에 해당하는 데이터 1개를 찾아오기
// 




package Web;

public class 필기0905 {

}
