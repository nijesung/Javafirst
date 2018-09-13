// **Spring DI 실습을 위한 프로젝트 생성
// 1. Simple Spring Maven 프로젝트 생성
// 2. Spring Version 변경
//	  pom.xml 파일의 properties 태그의 내용을 수정
//	  <!-- Spring -->
//    <spring-framework.version>4.1.0.RELEASE</spring-framework.version>

// 	  hibernate 나 junit 을 다운로드 받지 못해 에러가 나는 경우에는 dependency 를 제거
//    maven 자체가 업데이트가 되지 않아 pom.xml 파일에 에러가 나는 경우가 있는데 이 경우에는
//    maven plugin 에 관한 dependency 를 추가해 주면 된다.

// 3. IoC 와 DI 를 실습하기 위한 클래스를 생성
// 	  property(getter & setter) 를 2개 갖는 클래스
//	  vo.Sample

// 4. src/main/resources 디렉토리에 spring bean configuration(Spring Container 역할을 수행하는 파일)파일 추가
//	  applicationContext.xml

// 5. 3번에서 만든 클래스의 객체를 생성해 주는 코드를 applicationContext.xml 파일에 작성

// 6. main 메소드를 소유한 실행 클래스를 만들어 실행 코드를 작성


// **DI(Dependency Injection - 의존성 주입)
//	인스턴스 변수의 값을 외부에서 대입하는 것
//	1. 생성자를 이용하는 방법
//	   생성자를 이용하고자 하는 경우에는 클래스에 매개변수를 대입받을 수 있는 생성자가 존재해야 한다.
//	1-1. 값을 대입하는 경우
//	     bean 태그 안에 순서대로 <constructor-arg><value>값</value><constructor-arg>

//  1-2. 다른 bean 의 id 를 참조하는 경우
//	     <constructor-arg><ref bean="다른 bean의 id"/></constructor-arg>

//  1-3. c 라는 namespace 를 추가한 경우에는
//	     <constructor-arg c:_인덱스 = "값" 또는 c:_인덱스-ref="다른 bean 의 id" />

//  2. property(접근자 메소드) 를 이용하는 방법
//	2-1. 값을 대입하는 경우
//	     bean 태그 안에 순서대로 <property name="프로퍼티이름"><value>값</value></property>

//  2-2. 다른 bean 의 id 를 참조하는 경우
//	     <property name="프로퍼티이름"><ref bean="다른 bean의 id"/></property>

//  2-3. p 라는 namespace 를 추가한 경우에는
//	     <bean p:이름 = "값" 또는 p:이름-ref="다른 bean 의 id" />

// ex) 프로퍼티를 이용한 주입: applicationContext.xml 파일에서 작업
// 	   1). num 의 값을 주입

// ex) namespace 를 추가한 경우: c 와 p namespace 를 추가한 경우
//	   namespace 는 특정 문자로 시작하는 태그의 해석 위치를 지정하는 것
//	   xml 태그는 해석 위치에서 실제 코드로 변환을 한다.
//	   네임스페이스를 이용하면 코드 길이를 획기적으로 줄일 수 있다.


// # <bean id="name" class="java.lang.String"></bean>
// = String name = new String();

// # <bean id="name" class="java.lang.String"
// 	 c:_0="볼칸 위즈데미르"></bean>
// = String name = new String("볼칸 위즈데미르");

// # <bean id="sample" class="vo.Sample" p:num="10"></bean>
// = Sample sample = new Sample();
//	 sample.setNum(10);


// ex) 프로퍼티의 자료형이 Collection(데이터의 모임- list, set, map, Property) 인 경우
// 1). 위 4가지 자료형의 인스턴스 변수를 갖는 클래스를 생성
// 	   vo.CollectionBean

// 2). applicationContext.xml 파일에 CollectionBean 객체를 만들고
//	   프로퍼티에 값을 대입하는 코드를 작성


//	**어노테이션을 이용한 bean 생성
// 1. 어노테이션을 이용한 설정과 xml 을 이용한 설정을 같이 사용
// 	  xml 파일에 context 네임스페이스를 추가하고 <context:annotation-config/> 태그를 추가한다.
// 2. bean 의 자동 생성
//	  기본 생성자를 이용해 bean 을 자동으로 생성하는 클래스를 만들 때는 클래스 이름 위에 @Component,
//	  @Controller, @Service, @Repository 어노테이션을 추가하고 xml 파일에 <context:component-scan
//	  base-packge="조회할 패키지 이름"/> 을 추가하면 된다
//	  이 때 Controller 를 추가하면 Controller 가 되어 클라이언트의 요청을 받아 처리하는 역할을 수행한다.
//	  나머지 어노테이션의 역할은 거의 유사해서 혼용해서 사용해도 큰 문제는 없지만 되도록이면 
//	  역할에 맞게 사용하는 것이 좋다.
//	  이 때 생성되는 아이디는 클래스 이름의 첫 글자만 소문자로 변경한 형태로 만들어 진다.

// 3. 프로퍼티를 자동 연결
//	  인스턴스 변수 위에 @Autowired 를 추가하면 setter 를 자동으로 추가하고
//	  동일한 자료형의 bean 이 있으면 자동으로 주입을 받는다.
//	  Autowired 를 사용하면 반드시 동일한 자료형의 bean 이 1개 존재해야 한다.
//    없거나 2개 이상이면 예외를 발생시킨다.
//    없는 경우에 예외를 발생시키지 않고자 하면 @Autowired(required=false) 형식으로 설정하면 된다.
//	  2개 이상인 경우에 예외를 발생 시키지 않으려면 @Autowired @Qualifier("연결할 bean 의 id")형식으로
//	  설정하면 된다.
// 	  jdk1.8 이상 버전의 경우는 @Autowired 대신에 @Resource(name="bean 의 id") 를 이용해서 설정할 수 있다.
//    inject 라이브러리를 추가하면 @Autowired 대신에 @inject 를 사용할 수 있다.

// # 구조
// Controller <- Service <- Dao <- 데이터베이스 프레임워크


// **Anotation 과 XML 설정을 혼용한 bean 자동 생성
// 1). Siple Spring Maven 프로젝트 생성

// 2). Spring 버전 변경 - pom.xml 파일

// 3). Dao 클래스를 생성하고 메소드 생성
//	   문자열을 리턴하는 메소드
//	   com.pk.dao.SampleDao

// 4). src/main/resources 디렉토리에 spring bean cinfiguration 파일을 추가하고
//     설정 코드를 추가
//	   applicationContext.xml
// 4-1). context name space 추가
// 4-2). annotation 과 xml 설정을 같이 사용할 수 있도록 해 주는 설정을 추가
// 4-3). 패키지를 검색해서 클래스 위에 어노테이션이 추가된 클래스의 bean 을 자동으로 생성해 주는 설정을 추가

// 5. main 메소드를 소유한 클래스를 만들어서 bean 이 자동 생성되었는지의 여부를 확인

// 6. SampleService	클래스를 만들고 자동으로 객체를 생성하고 SampleDao 를 주입받는 코드를 작성
// 	  com.pk.service.SampleService

// 7. main 메소드를 수정해서 테스트

// 8. Controller 클래스를 생성

// 9. main 메소드를 수정해 테스트

// **시스템 프로퍼티 읽기
// ApplicationContext 객체가 getEnvironment() 를 호출하면 ConfigurationEnvironment 타입의 객체를
// 리턴하는데 이 객체의 getProperty 메소드에 String 타입으로 프로퍼티 이름을 대입하면 시스템 프로퍼티의 값을
// 찾아올 수 있다.
// java.version, os.name, os.version, Path 등
 
// 프로퍼티 파일에 작성된 프로퍼티도 읽어올 수 있는데 이 떄는 프로퍼티 파일을 만들고 Environment 객체가
// getPropertySource() 를 호출하면 MutablePropertySource 타입의 인스턴스를 리턴하는데 이 리턴되는
// 객체를 가지고 addLast 나 addFirst 메소드에 프로퍼티 파일의 경로를 설정하면 된다.

// 1). src/main.resources 디렉토리에 properties 파일을 생성하고 property 를 작성
// 	   db.properties

// 2). main 메소드를 수정하고 실행
//     
	

package Web;

public class 필기0913 {

}
