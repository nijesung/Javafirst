// **동기와 비동기
// 동기
// 순서대로 수행되는 것
// 작성 순서와 실행 순서가 동일하다.
// 비동기
// 작성한 순서대로 실행되지 않음
// 스레드 처럼 현재 작업은 작업대로 진행하고 자신의 작업을 수행하는 방식
// 콜백 메소드를 찾아 작성해야 한다.
// HTML5 에서 Image 객체는 이미지 파일의 내용을 비동기적으로 읽어냄
// 이미지 파일의 내용을 메모리에 전부 로드하면 onload 이벤트가 발생한다.
// 이미지 파일의 경로는 src 속성에 설정한다.

// 이미지를 읽어서 출력
// ex) Var image = new Image();
//     Image.sec= "이미지 파일의 경로를 설정"
//     image 를 사용하는 코드 // 이 줄은 동작하지 않을 수 있다.
//     image.onload=function(){
//       image 를 사용하는 코드 작성
//     }

// **XML 과 JSON	의 용도
// 개발자가 작성해서 데이터를 주고 받는 용도
// 프레임워크 를 만드는 개발자가 XML 과 JSON 을 이용해서 설정을 하도록 하는 용도
// 프레임워크의 작성 비준을 따라야 하고 이 파일의 해석 위치를 작성해야 한다.
// XML 파일에서 첫 번째 태그의 xmlns 속성이 태그의 내용을 해석하는 위치이다.
// 이 위치를 URL 형식으로 작성해야 한다.
// URL 이기는 하지만 실제 웹으로 나가서 해석하는 경우도 있고 로컬에서 해석하는 경우도 있다.


// **form
// 사용자의 입력을 하나로 묶어서 전송하기 위한 태그
// 1. form 속성
// 1-1. action
//      데이터를 전송하기 위한 URL 을 설정하는 옵션으로 생략하면 현재 URL	이 된다.
// 1-2. method
//		요청 방식으로 get 과 post가 있는데 생략하면 get
//      get은 매개변수를 URL에 붙여서 전송- 데이터의 길이에 제한이 있고 보안이 취약하나 자동재전송 가능
//      post는 매개변수를 헤더에 숨겨서 전송- 보안이 우수, 데이터의 길이에 제한이 없으나 자동재전송 안됨.
//      반드시 post를 사용해야 하는 경우는 password	 가 있는 경우인데 보안 때문에 숨겼으나 최근에는
//      password 를 password	로 만들지 않고 text 로 만드는 경우도 있다.
//      Textarea 가 있는 경우는 길이 때문에 보통 post 로 설정한다.

//      file 이 있는 경우는 반드시 post 로 해야 한다.
//      file 이 있으면 내용이 길기 때문에 분할해서 전송해야 한다.

// 1-3. enctype
//      폼의 데이터를 전송할 때 한번에 보낼 것인지 아니면 나누어서 보낼 것인지를 설정하는 옵션인데
//      file 이 있을 때 나누어서 전송할 수 있도록 multipart/form-data 를 설정해 주어야 한다.

// 1-4. onsubmit 이 발생했을 때 false 를 리턴하면 form 의 데이터가 서버로 전송되지 않는다.

// 2. lable
//    value 속성에 텍스트를 설정하면 화면에 출력된다.
//    for 속성에 다른 입력도구의 id 를 대입하면 묶여서 하나로 취급된다.

// 3. input
//    입력 상자
//    type 속성을 설정하면 입력 도구가 만들어진다.

// 3-1. text
//      기본값으로 문자열을 입력받을 수 있는 도구이다.
//      입력한 내용은 value 속성으로 가져올 수 있다.

// 3-2. password	
//      text 와 동일하나 화면에 보여질 때 echo char 로 보여진다.

// 3-3. checkbox
//      0개 이상 여러 개를 선택할 수 있도록 할 때 사용하는 type 으로 value 를 설정하면
//      선택되었을 때 value 값이 넘어간다.
//      여러 개를 한 묶음으로 만들기 위해서는 name 속성의 값을 일치시키면 된다.

// 3-4. radio
//      여러 개 중에서 반드시 1개의 값만 선택하도록 할 때 사용하는 type 으로 value 를 설정하면
//      선택 되었을 때 value 의 값이 넘어간다.
//      역시 한 묶음으로 만들고자 하면 name	 속성의 값을 일치시키면 된다.

// # checkbox 와 radio 는 checked 라는 속성으로 처음 선택을 설정할 수 있다.
//   radio 는 필수 입력을 의미하기 때문에 기본값을 설정해 주는 것이 좋다.

// 3-5. button
//      버튼을 생성한다.
//      value 를 설정하면 버튼의 텍스트가 된다.

// 3-6. submit
//      button 과 모양은 동일하나 누르면 form 의 데이터를 서버로 전송하는 기본 기능을 탑재

// 3-7. reset
//      button 과 모양은 동일하나 누르면 form 안의 데이터를 클리어하는 기본 기능을 탑재

// 3-8. file
//      파일을 선택할 수 있는 버튼을 만들어주는 속성
//      value 를 이용해서 선택된 파일 이름을 가져올 수는 있지만 보안 때문에 설정할 수는 없다.

// 3-9. hidden
//		화면에 보이지는 않으나 서버에게 전송은 되는 속성
//      화면에 보일 필요는 없으나 계속해서 들고 다녀야 하는 데이터가 있으면 hidden 이용

// 3-10. image
//       이미지를 출력하기 위한 속성

// # 서버에게 데이터를 전송하고자 하면 name 속성에 구별되는 이름을 설정해 주어야 한다.
//   서버는 name 을 이용해서 데이터를 읽어내기 때문

// 4. textarea
//    여러 줄의 텍스트를 입력받기 위한 도구
//    크기를 설정할 때는 rows 와 cols 속성을 이용해서 설정한다.
//    태그와 태그 사이에 빈 줄을 만들면 커서가 가운데에서 시작한다.
//    맨 처음 value 설정을 할 때는 태그와 태그 사이에 설정해야 한다.
//    처음 출력할 때는 value 설정이 안 된다.

// 5. select
//    여러 개 중에서 하나를 선택할 수 있도록 해 주는 도구
//    선택할 수 있는 값들은 option 태그를 이용해서 생성을 한다.
//    선택하게 되면 서버에는 option 의 value 값이 넘어간다.

// 6.fieldset
//   입력 도구들을 하나로 묶어줄 때 사용하는 태그로 legend 속성을 이용하면 border 에
//   텍스트가 입력된다.

// **HTML5 폼
// 1. input type 속성이 추가
//    모바일 페이지에서 접속할 때 키보드 종류를 설정할 수 있는 type 이 추가- email, url, number...
//    날짜를 입력받는 type 이 추가되었는데 아직 IE 와 Firefox 에는 적용이 안 되어 있어 2개의
//    브라우저에도 적용하기 위해 jquery 를 이용하는 경우가 많다.
//    사이트 - https://jquery.com/

// **위치 정보 이용하기
// HTML5 에서는 위치 정보를 가져오는 API 가 추가되었다.
// IE 하위 버전이 아니라면 모든 브라우저에서 지원된다.
// 1. 위치 정보 지원 여부 파악
//    navigator.geolocatio

// 2. 위치 정보를 1번 받아오면 호출되는 메소드
//    navagotor.geolocation,getCurrentPosition(function(매개변수){위치 정보를 가져오는데 성공했을 때 수행할 내용}
//    , {function(매개벼수){위치 정보를 가져오는데 실패했을 때 수행할 내용}, {옵션}

//    첫 번째 함수의 매개변수의 coords 를 확인하면 위치 정보를 파악할 수 있다.
//    두 번째 매개변수의 code 나 message 를 확인하면 위치 정보를 가져오는 데
//    실패한 이유를 알 수 있다.

// 3. 주기를 가지고 여러 번 위치정보를 받고자 하는 경우에는 getCurrentPosition 대신에
//    watchPosition	을 이용하면 된다.


// **Open API
// 3rd Party 개발자나 데이터를 가지고 있는 기업이 다른 개발자 들이 사용할 수 있도록
// 함수나 클래스 또는 데이터를 제공하는 것
// 데이터를 XML 이나 JSON 으로 제공하는 형식의 Open API 를 Restful API 이라 부르기도 한다.
// ex) 페이스북, 트위터, 야후, 구글, 네이버, 다음 등이 제공 중
// 이러한 API 들은 대부분 사용랴으이 문제나 불법적인 사용을 감시하기 위해 인증키를 발급받아야
// 사용할 수 있는 경우가 대부분이다.
// kakao - developer.kakao.com
// 63d666ddb68da24d8491ee4e268106ff

package Web;

public class 필기0819 {

}
