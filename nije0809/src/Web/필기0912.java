// **Spring 을 위한 IDE 설치
// eclipse 에서 [Help] - [Market Places] 를 클릭
// Spring 을 검색해서 Spring tool suite 를 install

// ex) 데이터베이스 에서 데이터 1개를 검색하는 프로그램
//	   1. 오라클에 접속해서 테이블과 샘플 데이터를 생성

//	   2. Simple Spring Maven Project 생성
//		  [File] - [New] - ohter 를 선택하고 Spring 을 찾아서 Spring Legacy Project 에서
//		  Simple Spring Maven 프로젝트를 선택하고 프로젝트 이름 입력

//     3. Spring 버전 변경
//		  pom.xml 파일에서 프로퍼티 태그 안의 아래 문장을 수정
//		  <spring-framework.version>4.1.0.RELEASE</spring-framework.version>

//	   4. Oracle 을 사용할 수 있도록 의존성 설정
//		  oracle 의 경우는 별도의 repository(라이브러리 저장소) 를 설정해야 한다.

// 	   4-1. pom.xml 파일에 저장소 설정
// 	   4-2. 오라클 의존성 설정 - dependencies 태그 안에 작성

//	   5. 테이블에 대한 VO(DTO 라고 하기도) 클래스 만들기
//		  vo.InsectVO

// 	   6. 데이터베이스 사용하는 클래스를 생성
//	      템플릿 메소드 패턴과 싱글톤 패턴을 적용
//	  	  이번 프로젝트는 변경을 할 예정이기 때문에 디자인 패턴은 적용하지 않는다.
//	      dao.InsectDao
//		  전체 데이터를 가져오는 메소드만 구현

// 	   7. main 메소드를 가진 클래스를 만들어서 위에 나온 결과를 출력


// 	   **Factory 메소드 패턴
//	   다른 클래스의 객체를 대신 생성하는 클래스를 만들어서 사용하는 패턴
//	   이런 클래스 이름의 마지막은 Factory 이거나 Builder 이다.
//	   이렇게 디자인 하는 이유는 초급 개발자가 불필요한 객체를 만드는 상황을 방지하기 위해서이다.
//	   특히 서버 프로그래밍 에서는 객체 하나를 잘못 생성하는 것이 치명적일 수 있다.

//	ex) 이전 프로젝트에 Factory 메소드 패턴 적용
// 	    1. InsectDao 가 있는 패키지에 InsectDaoFactory 클래스를 생성

// 		2. InsectDaoFactory 클래스에 InsectDao 객체를 생성해서 리턴하는 static 메소드를 생성

//		3. InsectDao 클래스의 생성자를 default(자신의 패키지 내에서는 호출 가능하지만 다른 패키지에서는 호출이 안됨)
//		   으로 생성
//	       InsectDao(){}

//		4. Main 클래스의 main 메소드 수정


//	# Maven
//	  pom.xml 파일을 이용한 프로젝트 관리 도구
//	  자바 소스 파일을 클래스 파일로 만들어 빌드를 대신 수행해 주고 라이브러리 관리를 해 준다.
//	  pom.xml 파일에 repositories 태그에 repository 를 설정하면 설정된 곳에서 라이브러리
//	  를 찾아보고 없으면 maven 중앙 저장소에 가서 다운로드 받아 로컬의 .m2 라는 디렉토리에
//	  저장 해 두고 라이브러리를 사용할 수 있도록 해 준다.
//	  라이브러리에 대한 설정은 dependencies 태그 안에 dependency 라는 태그를 이용해서 설정한다.
//	  장점은 직접 라이브러리를 복사하지 않고 다운로드 받기 때문에 pom.xml 파일의 내용만 복사해 작업하면
//	  모두 동일한 라이브러리를 사용할 수 있게 된다는 점이다.


// **Spring의 bean factory
// 객체 생성을 spring 에서 하도록 해 주는 인터페이스
// 어노테이션을 이용해서 할 수 있고 xml 파일을 이용할 수도 있다.
// 어노테이션을 이용할 때는 객체를 생성해 주는 메소드를 소유한 클래스의 상단에
// @Configuration 라는 어노테이션을 추가하고 객체를 리턴하는 메소드 위에는
// @Bean 이라는 어노테이션을 추가한다.
// 객체를 생성하는 메소드를 호출하기 위해서는
// AnnotationConfigApplicationContext 객체를 만들고 이 객체를 가지고 getBean 이라는
// 메소드를 호출하면 된다.
// 이 때 첫번째 매개변수에 객체를 생성해 주는 메소드 이름을 문자열로 대입하고 두 번째 매개변수로
// 클래스 이름을 대입하면 객체를 생성해서 대입 해 준다.
// 이 때 만들어진 객체는 싱글톤 패턴이 적용된 클래스의 객체가 된다.

// 1. InsectDaoFactory 클래스 상단에 @Configuration
// 2. InsectDaoFactory 클래스 create 메소드 상단에 빈 어노테이션 추가
// 3. 메인 메소드에서 객체를 생성하는 부분을 수정


// **xml 을 이용한 bean 생성
// SpringBeanConfiguration 파일을 생성해서 xml 객체를 생성할 수 있도록 해 준다.
// <bean id="구분하기 위한 id" class="객체를 생성하고자 하는 클래스의 경로"></bean> 을 작성

// 빈 설정 파일의 경로를 GenericXmlApplicationContext	 클래스의 생성자에 대입해
// 객체를 생성한 후 getBean("bean의 id", 클래스경로.class) 를 호출하면 싱글톤 객체를 리턴한다.

// 1. src/main/resources 디렉토리 SpringBean
// 2. 추가된 파일의 beans 태그안에 작성
// 3. InsectDao 클래스의 생성자의 접근지정자를 public 으로 변경
// 4. main 메소드에서 InsectDao 클래스의 객체를 생성하는 코드를 변경
// # xml 을 이용하면 별도의 빈 팩토리 클래스를 만들지 않고 객체를 생성할 수 있다.


// **loC(제어의 역전)
// 클래스의 인스턴스를 직접 생성하지 않고 다른 곳에서 생성 해 주는 것

// 1. Simple Spring Maven 프로젝트 생성
// 2. VO 클래스 생성
//	  vo.Person: name, age, phone 을 저장할 수 있는 클래스
// 3. Spring 에서 클래스의 객체를 생성하기 위한 설정 파일을 추가
//	  src/main/resources 디렉토리에 applicationContext.xml 파일
// 4. main 메소드를 소유한 클래스를 만들고 위에서 생성한 bean 을 가져다 사용하는 코드를 작성


// **지연생성
// 객체를 미리 만들지 않고 처음 사용할 때 만드는 것
// 서버 프로그래밍에서는 처음 실행될 때 모든 객체를 만들어 놓고 사용하는 경우가 대부분이다.
// 클라이언트 프로그래밍에서는 처음 사용되는 시점에 객체를 만드는 경우가 많다.
// spring 의 bean 은 실행 될 때 객체를 전부 만들어 놓는다.
// lazy-int 속성에 true 를 대입하면 처음부터 만들어지는 것이 아니라 처음 사용될 때 만들어진다.

// 1. 객체의 생성 시점을 알기 위해 Person 에 디폴트 생성자(Default Constructor-매개변수 없는 생성자) 추가
// 2. main 메소드에 로그를 출력하는 코드를 추가하고 실행 후 로그와 생성자의 호출 시점을 비교
// 3. applicationContext.xml 파일의 bean 을 생성하는 태그에 속성 추가
// 	  lazy-init

// ***면접 시 외워갈 것
// 상속 - is a
// 포함 - has a


// **Dependency Injection(의존성 주입)
// 인스턴스 변수의 값을 외부에서 생성해서 대입하는 것
// 방법은 생성자를 이용하는 <constructor-arg> 와 프로퍼티를 이용하는 <property> 2가지가 있다.
// property 는 setter 메소드가 만들어져 있어야 한다.

// 1. applicationContext.xml 파일의 bean 태그를 수정
//



package Web;

public class 필기0912 {

}
