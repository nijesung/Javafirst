// **Vendor Prefix
// css3 에서 표준으로 채택은 했지만 브라우저 별로 다르게 적용되는 속성들이 있는데 이 때 이러한 속성들은
// 브라우저 회사의 접두어를 붙여서 사용해야 한다.

// Safari,Chrome: webkit
// Internet explorer: ms
// Firefox: moz
// Opera: o

// transform
// 원본을 기본 값들을 변경하지 않고 출력을 할 때 3*3 행렬과의 연산을 해서 출력하는 것
// translate(이동), scale(크기), rotate(회전) 이 있다.
// origin 은 이동이나 크기 및 회전을 적용할 기준점이다.
// 대부분의 GUI 프로그램에서는 왼쪽 상단을 기준으로 하고 그래픽 카드를 직접 제어하는 OpenGL 에서는 정중앙을
// 기준으로 한다.

// 적용 방법
// -접두어-transform:함수명(매개변수)

// **Cross Browsing
// 모든 브라우저에서 동일한 콘텐츠를 사용할 수 있도록 해 주어야 한다.
// jquery 가 이 목적에서 출발한 자바스크립트 라이브러리 이다.

// **반응형 웹 디자인
// 브라우저의 크기에 상관없이 동일한 콘텐츠를 사용할 수 있도록 해주어야 한다.
// 이 목적에서 나온 자바스크림트 라이브러리가 bootstrap 이라는 라이브러리 이다.
// css 와 media query 를 이용하여 작업한다.

// **N-Screen
// 하나의 콘텐츠를 여러 디바이스에 사용하는 것

// **JavaScript
// html 문서에 동적인 기능을 부여하기 위한 언어
// 지금은 이 목적 이외에 응용프로그램을 만드는 데에도 사용하는데 순수 자바스크립트 로는 무리가 있고 자바스크립트로 작성
// 한 내용을 번역해서 일반 프로그래밍 언어의 내용을 호출하는 라이브러리와 함께 사용해야 한다.
// react native 라이브러리를 이용해서 하이브리드 앱을 만들거나 phonegap 라이브러리를 이용해서 하이브리드 앱을
// 만들기도 하고 web os 가 장착된 스마트 TV 등의 애플리케이션을 만들기도 하는데 이러한 web os 방식의 운영체제로는
// tizen 이 있다.

// 1. 사용 방법
// 1-1. 다른 파일에 만들고 호출해서 사용
//      <script src="스크립트 파일의 경로"></script>

// 1-2. html 문서 내에서 사용
//      <script>
//        스크립트 내용
//      </script>

// 1-3. 태그 내에서 사용
//      <태그 이벤트="스크립트 내용"></태그>

// 2. 내용 출력
// 2-1. 대화 상자로 출력
//      alert(출력 내용)

// 2-2. body 태그 안에 출력- 태그가 적용된다
//      Document.write(출력 내용)
//      Document.writeln(출력 내용)

// 2-3. 디버그 창에 출력
//      console.log(출력내용)

// 3. 작성 시 주의사항
//    ; 은 생략해도 되나 한 줄에 2개의 명령문이 있을 때는 구분하기 위해서 ; 을 사용해야 한다.

// 4. 데이터 상수와 변수
// 4-1. literal 
//      프로그래밍 언어가 제공하는 데이터로 의미를 변경할 수 없다.
//      정수 리터럴: 17
//      실수 리터럴: 10.4
//      bool 리터럴: true, false
//      문자 리터럴: '문자 또는 문자의 집합', "문자 또는 문자의 집합"
//      참조 리터럴: null

// 4-2. constant
//      개발자가 만든 값을 변경할 수 없는 데이터

// 4-3. variable
//      개발자가 데이터를 저장하기 위한 용도로 만든 이름

// # 리터럴과 컨스턴트를 묶어 상수라고 이야기하는 경우도 꽤 많다.

// 4-4. 자바스크립트 에서 변수 만들기
//      var 변수명 = 값
//      또는 
//      var 변수명
//      변수명 = 값
//      주의할 점은 자바스크립트 에서는 값을 대입하기 전 까지는 변수가 만들어진 것이 아니기 때문에 선언만 하게 되면
//      undefined 가 된다.
//      자바스크립트는 동적 바인딩을 하는 언어라서 변수를 선언할 때 자료형을 기재하지 않고 변수에 값이 대입될 때
//      자료형이 결정된다.
//      데이터의 자료형은 typeof 를 이용해서 확인이 가능하다.

// 5. 배열(Array)
//    동일한 자료형의 데이터 모임
//    비교 가능한 데이터를 묶어 주어야 한다.
//    자바스크립트 에서는 배열이 배열과 더불어 list 의 역할을 같이 한다.

//    생성
//    var 배열명 = [데이터 나열]
//    var 배열명 = new Array(초기개수)

// 배열의 모든 요소 출력
// toString 이나 valueOf 라는 메소드 호출
// join(구분문자열) 을 호출해서 각 요소마다 구분 문자열을 추가해 하나의 문자열로 리턴을 받아 출력
// toString 은 직접 호출하지 않고 배열의 이름만 출력하는 메소드에 대입해도 출력된다.

// 6. 연산자(operator)
//    계산을 도와주는 기호나 명령어

// 6-1. 증감연산자
//      ++ , --
//      정수, 변수에만 사용 가능한 연산자로 변수의 값을 1 증감하는 연산자이다.
//      변수의 앞에 사용되면 변수의 값을 먼저 증감하고 명령에 이용한 뒤 사용하면 명령에 사용하고 변수의 값을 증감한다.

// 6-2. 산술 연산자
//      %, *, /, +, -

// 6-3. 대입-할당 연산자
//      =, +=, -=, /=, %=
//      가장 마지막에 수행된다.

//      a = 10 : a 라는 변수에 10을 할당한다.
//      a += 10 : a = a + 10

// 6-4. 조건 연산자
//      (조건)?참일 때 내용:거짓일 때 내용
//      자바스크립트 에서는 숫자의 경우 0이 아니면 true 로 간주하고 참조형의 경우는 null 이 아니면 true 로 간주한다.

// 6-5. 논리 연산자
//      >, >=, <, <=, ==, !=, !, &&, ||
//      연산의 결과가 true 나 false 로 나오는 연산자
//      !(not), &&(논리 and), ||(논리 or)
//      don't care: && 연산자는 둘 다 true 인 경우에만 true 가 리턴된다.
//      || 연산자는 둘 다 false 인 경우에만 false 가 리턴된다.
//      && 연산자의 경우는 앞의 조건이 false 이면 뒤의 내용을 조사하지 않는다.
//      || 연산자의 경우는 앞의 조건이 true 이면 뒤의 내용을 조사하지 않는다.

// 그래픽 프로그래밍 임베디드 책 찾아보기



package Web;

public class 필기0813 {

}
