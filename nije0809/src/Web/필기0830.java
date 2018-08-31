// **EL(Java data 를 jsp 에서 출력하기 위한 식) 에서의 배열과 List
// 배열과 List(ArrayList, LinkedList, Stack, Deque) 모두 비교 가능한
// 여러 개의 데이터를 하나의 이름으로 묶는 것이 목적이다.
// java 에서 각각의 데이터를 접근할 때 배열은 [인덱스] 를 이용하고 List 는 get(인덱스) 를
// 이용한다.
// EL 에서는 [인덱스] 를 이용해서 List 의 데이터도 접근할 수 있도록 해 준다.
// 이런 이유로 EL 을 이용해서 출력하게 되면 배열과 List 는 동일한 접근 방법을 이용하게 된다.
// 요청 -> 처리 -> 출력 을 구분해서 프로그램을 작성하게 되면 처리 부분에서 자료구조를 변경 하더라도
// 출력 부분도 같이 변경하지 않아도 된다. MVC 패턴을 사용하는 근본적인 이유이다.

// 실습
// 배열과 List 의 출력
// 배열과 List 를 만들어서 데이터를 전달 해 주는 페이지 - 나중에 java 파일로 변경된다.


// **EL 에서의 Map 과 DTO(VO)
// EL 에서는 Map 과 DTO 가 프로퍼티에 접근하는 방법도 동일하다.
// ["키이름이나 프로퍼티이름"] 또는 .키이름이나 프로퍼티이름 을 이용해도 된다.
// 프로퍼티는 변수명이 아니라 getter 와 setter 에서 get 과 set 을 제외한 부분이다.
// 프로퍼티 라고 할 때는 접근자 메소드를 의미하는 것이다.

// 1. Map
// 1-1.	Map 생성
//      Map <String, Object> 변수명 = new HashMap<>();

// 1-2. 데이터 저장
//      변수명.put("키이름", 데이터);

// 1-3. 데이터 읽기
//      변수명.get("키이름")

// 1-4. 데이터 삭제
//      변수명.remove("키이름")

// 2. property
//    사용은 변수처럼 하는데 실제로는 getter 와 setter 메소드를 호출하는 것

// 실습
// Map 과 VO 를 생성해서 전달하고 출력


// **Java Project 에서 외부 라이브러리 파일을 사용하는 방법
// 1. 일반 Java Application 의 경우
//    사용하고자 하는 jar 파일을 선택하고 build path 에 추가해 주면 된다.
//    프로젝트를 선택하고 마우스 오른쪽을 눌러서 configure build path 메뉴에서 하면 된다.

// 2. Java Web Application 의 경우
//    WebContent/WEB-INF/lib 디렉토리에 복사 해 주면 된다.

// 3. Maven 이나 Gradle 의 경우는 설정 파일에 사용 할 라이브러리의 이름을 설정하면 된다.
//    안드로이드가 grade 방식


// **JSTL	
// jsp 파일에서 자주 사용하는 java 의 기능들을 태그로 만들어서 사용하는 것
// apache 재단에서 만들어 배포
// jstl.jar 파일을 프로젝트에 포함 시켜 주어야만 사용 가능

// 1. Core Library
//    자바의 변수 선언이나 제어문을 사용하기 위한 라이브러리
//    접두어는 일반적으로 c 를 사용하는 것이 관례
//    태그 라이브러리 URL: http://java.sun.com/jsp/jstl/core
//    사용하기 위한 설정
//    <%@ tag lib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
//    c: 으로 시작하는 태그는 브라우저가 해석하지 않고 http://java.sun.com/jsp/jstl/core 에서 해석
//    웹 주소 형태로 되어 있지만 실제로는 jar 파일에서 해석한다.

// 1-1. set
//      변수를 선언할 때 사용하는 태그
//      속성 var, value, scope 가 있다.
//      var 는 변수명을 설정
//      value 는 초기값
//      scope 는 유효 범위로 page, request, session, application 이 있다.

// 1-2. remove
//      set 으로 만든 변수를 삭제하기 위한 태그
//      var 와 scope 속성이 있다.

// 1-3.	if
//      조건에 맞는 경우에만 작업을 수행하기 위한 태그
//      형식
//      <c:if test="${조건}">
//        조건에 맞는 경우 수행할 내용
//      <c:if>

// 1-4.	c:choose
//      여러 개의 조건을 나열하고 조건에 맞는 경우에만 내용을 수행하도록 해 주는 태그
//      형식
//      <c:choose>
//      	<c:when test="${조건}">
//      		조건이 true 일 때 수행할 내용
//			</c:when>
//           ...<c:when> 여러 가능

//      	<c:ohterwise>
//			
//      	</c:ohterwise>
//      </c:choose>

// 2. Format Library
//    날짜나 숫자 출력 서식 설정, 지역 설정, 다국어 지원 등의 기능을 수행 해 주는 태그 라이브러리
//    사용하기 위한 설정
//    <%@ tag lib prefix="fat" uri="http://java.sun.com/jsp/jstl/fmt" %>

// 2-1.	<fmt:formatNumber>
//      숫자 출력 서식을 위한 태그

// 2-2. <fmt:formatDate>
//		날짜 출력 서식 지정을 위한 태그

// formatNumber	의 pattern 은 java.text.NumberFormat 클래스 참조
// formatDate 의 pattern 은 java.text.SimpleDateFormat 클래스 참조

// 2-3. <fmt:setLocale>
//      지역 설정을 위한 태그
//      날짜나 숫자 서식이 지역 설정에 따라 출력된다.



package Web;

public class 필기0830 {

}
