// **데이터베이스 연동 방법
// 1. 언어에서 제공하는 코드 만을 이용하는 방법(JDBC 코드 만을 이용해 작성)
//	  프로그램을 잘 만들면 성능은 가장 우수
//    개발 시간이 오래 걸릴 가능성이 높음
// 2. 프레임워크를 이용하는 방법
//	  개발시간이 단축될 가능성이 높고 프로그램에 대한 깊은 지식이 없더라도 성능이 나쁘지 않은
//    프로그램을 개발할 수 있다.
// 	  성능은 조금 떨어질 수 있고 프레임워크 변화에 민감

// 2-1.	SQL Mapper
//      SQL	과 프로그래밍 언어의 분리, 자동 매핑, 예외를 좀 더 구체적으로 표현
//		MyBatis 가 대표적인 SQL Mapper Framework

// 2-2.	ORM
//      데이터베이스의 하나의 행과 객체를 직접 매핑, SQL 없이 작업 가능
// 	    일반적으로 성능이 SQL Mapper 보다 우수하나 데이터베이스를 잘 알아야 한다.
//		Java 에서는 Hibernate 가 대표적이다.
//      JPA 는 구현 방식이고 Hibernate 가 구현체 이다.

// **하이버네이트
// Java ORM(Object Relation Mapping) Framework
// Java 객체 1개와 테이블의 하나의 행을 매핑시켜 동작시키는 프레임워크
// MyBatis 보다 성능이 우수한 편이지만 다소 어렵다.
// 좋은 성능이 필요한 분야인 솔루션 개발에는 적합하지만 기간이 중요한 SI에는 부적합하다.

// **하이버네이트 연동 실습
// 1. 하이버네이트 연동할 데이터 테이블 생성
// 2. Simple Spring Maven 프로젝트를 생성
//	  스프링을 사용하는 일반 Application 생성
// 3. Java Version 을 1.8 , 스프링 버전을 4.1.0으로 변경   
// 4. 사용하고자 하는 라이브러리의 의존성을 설정
//    이 작업은 모두 pom.xml 에서 처리한다.
//    oracle, spring-jdbc(데이터베이스 사용 시 반드시포함), spring-orm, hibernate(이미 포함된 상태)
// 4-1. 오라클을 사용하는 경우에는 repository 를 추가해야 한다.
// 4-2. 의존성을 dependencies 태그 안에 작성
// 5. fruit 테이블과 연동할 Domain 클래스를 생성
//    com.pk.domain.Fruit
// 6. fruit 테이블과 Fruit 클래스를 매핑하기 위한 하이버네이트 설정 파일을 생성하고 작성
//    src/main/resources/hibernate/fruit.hbm.xml
// 7. Spring Bean Configuration 파일을 추가해서 하이버네이트 사용 객체를 생성하는 코드를 추가
//	  src/main/resources/applicationContext.xml
//    1). context, tx 네임스페이스 추가
//    2). bean 생성 코드 추가
// 8. Hibernate 를 사용할 Dao 클래스 생성
//	  com.pk.dao.FruitDao
// 9. main 메소드를 소유한 Main 클래스를 만들고 FruitDao 를 가져와서 삽입하는 메소드 수행


// **데이터 수정하기
// 1. FruitDao 클래스에 데이터를 수정하는 메소드 만들기

// 2. main 메소드 수정해서 실행하고 확인


// **전체 데이터 조회하기
// 1. Dao 클래스에 전체 데이터를 조회하는 메소드를 만들기
// 

package Web;

public class 필기0918 {

}
