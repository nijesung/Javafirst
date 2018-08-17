// **DOM 찾아오기
// document.getElementById(아이디)
// 아이디를 가진 태그에 대한 포인터를 리턴

// **이벤트 처리
// 1. inline 이벤트 처리
//    태그 안에서 처리
//    <태그 on이벤트="자바스크립트코드"></태그>
//    가장 우선순위가 높다.
//    코드가 여러 줄이면 사용하기가 불편하다.

// 2. 표준 이벤트 처리 - 별도의 스크립트 코드에서 처리
//    DOM 객체.addEventListener(이벤트이름, function(){이벤트처리 코드})
//    별도의 함수를 만들고 함수 이름만 기재해도 된다.

// 3. 이벤트 처리 함수에서 이벤트 객체 사용하기
//    이벤트 처리함수에 매개변수를 하나 만들고 내부에서 var	변수명 = 매개변수 || window.event
//    코드를 작성해서 변수를 이용하면 된다.

// 4. IE 하위 브라우저는 매개변수를 이용하지 않고 window.event	 를 이용해서 객체를 제공하기 때문에
//    위와 같은 코드를 만들어서 사용한다.

// 5. 이벤트 종류
// 5-1. click
// 5-2. dbclick
// 5-3. keydownm keypass, keyup
//      누른 키보드 코드 값은 이벤트 객체의 which 속성이나 keycode 속성을 이용해서 찾을 수 있다.

// 5-4. mousedown, mousemove, mouseout, mouseover, mouseup
// 5-5. move, resize
//      윈도우가 이동하거나 크기가 변경될 때 발생하는 이벤트

// 5-6. blur
//      포커스가 떠날 때 발생하는 이벤트

// 5-7. load
//      window 나 fire 객체에 발생하는 이벤트인데 window 의 모든 요소가 메모리에 적재되거나
//      파일의 모든 내용을 읽엇을 때 발생하는 이벤트
//      자바 스크립트를 body 태그 위에 작설하려면 window.onload 이벤트 발생 후에
//      DOM 을 사용할 수 있다.
//      html 도 순서대로 읽어서 실행하기 때문에 이후에 만들어진 객체는 먼저 사용할 수 없다.

// 5-8. focus
// 5-9. change
//      값이 변경될 때 발생하는 이벤트

// 5-10. submit
//       form 에 발생하는 이벤트로 form 안에 있는 submit 버튼을 눌렀을 때 발생하는 이벤트

// 5-11. reset
//       form 에 발생하는 이벤트로 form 안에 있는 reset 버튼을 눌렀을 때 발생하는 이벤트

// 6. 이벤트 강제 발생
//    DOM객체.on이벤트이름()
//    form 의 데이터를 강제로 전송할 때 form.submit() 을 호출한다.
//    form 의 데이터를 강제로 지울 때는 form.reset()

// 7. 이벤트 버블링
//    이벤트가 연속해서 발생하는 것
//    자신을 감싸고 있는 태그에 동일한 이벤트 처리가 설정된 경우 자신에게 이벤트가 발생하면
//    자신을 감싸고 있는 태그의 이벤트도 같이 발생하는 것
//    자신을 감싸고 있는 태그의 이벤트 처리를 하지 않으려면 이벤트 객체가 stopPropagation
//    을 호출하면 된다.

// 8. 기본 이벤트
//    특정한 이벤트에는 미리 기능이 정해져 있는 경우가 있다.
//    form 의 submit 은 form 의 데이터를 action 으로 전송하는 기능이 정의되어 있다.
//    form 의 reset 	은 form 의 내용을 삭제하는 기능이 정의되어 있다.
//    a 태그의 click 은 href 속성에 저장된 페이지로 이동을 한다.
//    form 에 input type=button 이 아닌 button	 태그를 이용해서 버튼을 만들면
//    submit 기능을 가지고 있다.
//    keydown 이벤트의 경우는 누른 키보드 문자를 input 에 출력하는 기능을 가지고 있다.
//    이러한 기능을 수행하지 않도록 하고자 할 때는 이벤트를 처리하는 함수에서 false 를 리턴하면 된다.

// **Regular Expression(정규 표현식)
// 문자열의 패턴을 정의하는 객체
// 유효성 검사나 조회에 많이 이용
// java 나 python 등의 언어에서도 사용

// 1. 객체 생성
//    New RegExp(패턴 문자열, 한정자)
//    패턴 문자열은 작은 따옴표나 큰 따옴표로 묶어야 한다.

//    /패턴/한정자
//    따옴표로 묶지 않는다.

//    한정자는 생략이 가능하다.

// 2. 정규식 메소드
// 2-1. test()
//      문자열을 대입해서 정규식 패턴의 문자열이 있으면 ture 없으면 false 를 리턴하는 메소드
// 2-2. exec()
//      문자열을 대입해서 정규식 패턴의 문자열이 있으면 그 문자열을 리턴하는 메소드
// 



package Web;

public class 필기0817 {

}
