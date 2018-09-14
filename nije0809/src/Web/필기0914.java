// **Spring JDBC
// spring 프레임워크 안에서의 데이터베이스 연동
// 1. 장점
// 	  기존의 SQLException 을 조금 더 구체적인 이름의 예외로 변경해서 리턴하기 때문에
//    예외가 발생했을 때 이해 하기가 쉽다.
//	  다른 데이터베이스 프레임워크 와의 연동이 쉽다.

// ex) 순수 Java 코드를 이용해서 데이터베이스 연결
//     1. Simple maven 디렉토리 생성

//	   2. Java Version 변경
//		  프로젝트를 선택하고 [Build Path] - [Configure Build Path]
//	      프로젝트를 선택하고 [Properties] 를 클릭 한 후 자바 컴파일러에서 가능

//	   3. Spring Version 변경
//	      pom.xml 파일의 properties 태그 안의 스프링 버전 태그의 값을 수정

// 	   4. spring-test 의 scope 제거
//	      scope 를 제거하지 않으면 spring-test 라이브러리의 클래스들이 import 가 안 되는 경우 존재

// 	   5. 오라클 사용을 위한 의존성 라이브러리를 설정 - pom.xml
//	   5-1. 오라클의 경우에는 repository 가 별도로 설정 되어야 한다.
//     5-2. 오라클 라이브러리의 의존성을 dependencies 태그 안에 추가

//     6. 데이터베이스 접속 정보를 하나의 bean 으로 생성
//		  src/main/resources 디렉토리에 SpringBeanConfiguration 파일을 만들어서 작성
//	      Spring-JDBC 와 @Inject 를 사용하기 위한 라이브러리 설정을 pom.xml 파일의
//		  dependencies 태그에 추가:
//	      spring-jdbc 는 필수이고 @Inject 는 @Autow

//     7. 연결 테스트를 위해 src/test/java 디렉토리에 클래스를 추가하고 코드를 작성


// # driver 클래스를 load 하지 못해서 나는 예외
//   1. pom.xml 파일에서 dependency 를 설정하지 않은 것
//      dependency 는 반드시 dependencies 태그 안에 있어야 한다.
//	 2. driver class name 을 잘못 기재한 경우

// # 오라클에 접속하지 못해서 나는 예외
//   1. url 을 잘못 작성한 경우
//		The Network Adapter could not establish
//	    ip 주소와 포트 번호 확인
//	    TNS::listener dose
//	    데이터베이스 이름 확인

//   2. username 이나 password 를 잘못 작성한 경우
//	    invalid username/password; login denied


// **MyBatis
// SQL Mapper Framework(SQL 과 프로그래밍 언어 코드를 분리)
// 파라미터 와 select 구문의 결과를 프로그래밍 언어의 자료구조와 자동 매핑
// 1. Spring 에서의 사용 방법
// 1-1. Spring-jdbc, mybatis-spring 라이브러리를 추가해서 사용
// 1-2. 매퍼 파일을 이용하는 방식과 어노테이션을 이용하는 방식으로 나눌 수 있음

// 2. 매퍼 파일을 이용하는 경우
//    1개의 환경 설정 파일과 1개 이상의 매퍼 파일을 이용한다.
//    설정 내용을 저장하는 SqlSessionFactoryBean 클래스와 SQL 을 실행하는 SqlSessionTemplate
//    클래스를 이용한다.
// 2-1.	환경 설정 파일에는 경로를 줄여쓰기 위한 설정이나 매핑 정보가 설정된다.
// 2-2. 매퍼 파일에는 SQL 이 작성된다.

// ex) 환경 설정 정보를 저장하기 위한 클래스의 인스턴스 까지 만들어 지는지 확인
//     1). pom.xml 파일에 spring 에서 mybatis 를 사용하기 위한 라이브러리의 의존성을 주입

//	   2). MyBatis 환경 설정 파일을 생성
//	       resources 디렉토리에 mybatis 디렉토리를 만들고 그 안에 mybatis-config.xml

//	   3). 스프링 설정 파일에 SqlSessionFactoryBean 클래스의 bean 을 만드는 코드를 추가
//	       xml 을 이용해서 Mybatis 를 연동할 때는 dataSource, configuration, mapperLocation
//		   3개의 속성값을 설정한다.
//		   이 때 데이터 소스와 매퍼 로케이션은 필수 설정이다.

//     4). SqlSessionFactoryBean 이 제대로 생성 되었는지 클래스에서 확인

// # FileNotFoundException 이 발생하면 MyBatis 환경 설정 파일의 경로가 잘못 된 것이므로 확인할 것


// **MyBatis 에서 Mapper 파일을 사용하는 경우
// 1. 데이터베이이스 에 테이블을 생성하고 샘플 데이터 입력
// 2. Project 생성
//	  spring simple maven 프로젝트
//	  nije0914MybatisInsect
// 3. 필요한 의존성 라이브러리를 설정
//	  pom.xml
//    Oracle, MyBatis 사용 : oracle, spring-jdbc, mybatis, spring-mybatis
// 3-1. spring 버전 변경
// 3-2.	oracle 사용을 위한 repository 를 추가
// 3-3.	오라클, spring-jdbc, mybatis, spring-mybatis 의 의존성을 dependencies 태그 안에 추가


// **MyBatis 와 Java 의 자료형 매핑
// 오라클의 number	 와 MySQL 의 숫자 자료형 :
// Byte, Short, Integer, Long, Float, Double, BigDecimal

// String :
// char, varchar(오라클 - varchar2), text(오라클 - clob)

// Date :
// java.sql.Date(날짜만 저장), java.util.Date(날짜와 시간)

// Time :
// java.sql.Time, java.util.Date(1/1000 초 까지)

// TimeStamp :
// java.sql.Timestamp(1/1000000 초 까지)

// blob :
// byte[]


// **Domain	클래스 설계
// 사용하고자 하는 구문의 결과나 파라미터로 사용 될 클래스를 설계
// Map 을 사용하면 클래스를 설계하지 않아도 되는데 Map 을 이용하여 매핑하면 데이터베이스 종류에 따라
// Key 의 이름이 달라지고(Oracle-영문대문자)(MySQL-영문소문자) 오라클의 number 가 매핑될 때
// BigDecimal 로 매핑 되기 때문에 사용 시 메소드를 한 번 더 호출해야 한다.

// # Domain 클래스의 프로퍼티와 데이터베이스 컬럼 이름을 동일하게 하면 매핑에 관련된
//   별도의 설정을 할 필요가 없다.

// 1). 작업할 내용 (CRUD)(create, read, update, delete)
//     insect 테이블의 전체 데이터를 가져오는 일
//	   		select code, name, price, description from insect;
//     insect 테이블에서 code 의 값을 가지고 하나의 데이터를 찾아오는 구문
//     		select code, name, price, description from insect where code = ?;
//     insect 테이블에 데이터를 삽입하는 구문
//	   		insert into insect(code, name, price, description) values(?,?,?,?)
//     insect 테이블에서 code 값을 가지고 데이터를 삭제하는 구문
//     		delete from insect where code = ?;
//     insect 테이블에서 code 값을 가지고 데이터를 수정하는 구문
//     		update insect set name=?, name=?, price=?, where code = ?;

// 2). domain 클래스를 생성
//	   com.mybatis.domain.Insect

// **SQL 을 XML 파일에 작성해서 사용하는 MyBatis 설정
// MyBatis 와 관련된 파일들은 resources 디렉토리에 별도의 디렉토리를 생성해 저장
// 1. MyBatis 환경 설정 파일을 생성한다.
//	  src/main/resources/mybatis/mybatis-config.xml

// 2. MyBatis SQL Mapper 파일을 생성
//    환경 설정 파일과는 별도의 디렉토리에 생성
//    테이블 당 1개씩 만든다.
//    파일명 에는 테이블의 이름을 포함시키는 것이 일반적이다.
//    src/main/resources/mybatis/mappers/insectmapper.xml

// 3. Spring Bean Configuration	파일을 만들어서 DataSource, SqlSessionFactoryBean
//    SqlSessionTemplate 클래스의 객체를 만들어 주는 코드를 삽입
// 3-1. src/main/resources/applicationContext.xml 파일을 Spring Bean Configuration 파일로 추가
// 3-2. spring 에서 xml 과 annotation 을 혼합해서 사용할 수 있도록 해 주고 특정 패키지에
//      존재하는 클래스 들 중에서 어노테이션이 있는 클래스의 bean 을 자동 생성 해 주는 옵션을 추가
//  	context 네임 스페이스 추가 후 작성

// 4. Dao 클래스를 생성해 MyBatis 실행 클래스를 주입하는 코드를 만들기
//	  com.mybatis.dao.InsectDao

package Web;

public class 필기0914 {

}
