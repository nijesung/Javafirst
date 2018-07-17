// **java.awt 패키지의 Component
// 1. TextField: 한 줄의 텍스트를 입력받는 클래스    
// 1-1. Constructor(생성자)
// TextField()
// TextField(int columns)
// TextField(String text)
// TextField(String text, int columns)

// 1-2. 주요 메소드
//      void setEchoChar(char c): 화면에 보여지는 글자를 설정
//      String getText(): 입력된 문자열 가져오기
//      void setText(String)

// 2. TextArea
//    여러 줄 입력을 받을 수 있는 Component
// 2-1. Constructor(생성자)
//      TextArea() : 행 수와 열 수를 지정하지 않은 텍스트 영역
//      TextArea(int rows, int columns) : 행 수와 열 수를 지정
//      TextArea(String text) : 텍스트를 설정
//      TextArea(String text, int rows, int columns) : 텍스트와 행 수 및 열 수를 지정
//      TextArea(String text, int rows, int columns, int scrollbars) : 텍스트와 행 수 및 열 수를 지정하고 스
//                                                                     크롤바 표시 여부를 설정. 스크롤 바는
//                                                                     정수이지만 TextArea의 상수로 설정
// 2-2. 주요 메소드
//      void append(String str)
//      String getText()
//      void setText(String str)

// 3. ScrollBar
//    범위 내의 값을 입력받기 위한 Component

// 4. ScrollPane
//    출력 영역 보다 더 큰 컴포넌트를 출력하기 위한 Container
//    출력 영역 보다 더 큰 컴포넌트를 Panel 이나 Frame 에 바로 배치하면 출력 영역 이외의 영역은 잘려서 출력이 되지 않는다.
//    이런 경우에는 Scroll 에 배치한 후 출력해야 스크롤 바가 생성되고 나머지 영역도 볼 수 있다.

// 5. Canvas
//    별도의 출력 영역을 만드는 것으로 이미지나 그림을 그리고자 할 때 사용

// 6. Menu
//    MenuBar, Menu, MenuItem, CheckboxMenuItem 으로 구분
//    MenuBar 는 Frame 에 배치하고 Menu 를 MenuBar 나 Menu 에 배치하고 MenuItem 은 Menu 에 배치
//    PopupMenu 는 마우스 오른쪽 버튼을 눌렀을 때 보여주는 메뉴

// 7. FileDialog
//    파일 열기와 저장을 위한 대화상자
//    자주 사용하기 때문에 API 에서 제공한다.

// **배치 관리자(Layout)
//   Container 에 Component 들을 어떤 식으로 배치할 것인지를 설정하는 것
//   Frame 이나 Panel 의 setLayout 메소드를 이용하여 설정
//   Panel 의 경우는 생성자에 Layout 인스턴스를 대입해서 생성할 수도 있다.

// 1. FlowLayout
//    Panel 의 기본 레이아웃으로 수평으로 순서대로 배치하고 옆으로 더 이상 배치할 수 없으면 아래에 배치하는 방식

// 2. BorderLayout
//    Frame 의 기본 레이아웃으로 5개의 영역으로 나우어서 배치
//    각 영역에는 하나의 Component 만 배치가 가능
//    하나의 영역에 여러 개를 배치하고자 하면 Panel 을 만들어서 여러 개를 배치한 후 다시 배치하면 된다.
//    각 영역의 이름은 Center, North, South, West, East 이다.
//    영역에 컴포넌트를 배치할 때는 add("영역이름", 컴포넌트) 의 형태이며 영역이름을 생략하면 자동으로 Center 에 배치된다.
//    컴포넌트가 배치도지 않은 영역은 Center 에 포함된다.

// 3. GridLayout
//    표 처럼 격자를 만들어서 컴포넌트를 배치하는 레이아웃
//    모든 셀의 크기는 동일하고 하나의 셀에는 하나의 컴포넌트만 배치할 수 있다.
//    add를 호출하면 순서대로 배치가 된다.
//    셀이 부족하면 행과 열의 수를 조정한다.
//    생성자에 행과 열의 수를 대입할 수 있고 셀의 가로와 세로 여백을 설정할 수 있다.

// 4. null
//    레이아웃을 설정하지 않는 것으로 컴포넌트의 크기와 위치를 개발자가 직접 설정해야 하는 레이아웃
//    권장하지는 않으나 컴포넌트를 움직이거나 크기 조절을 할 필요성이 있을 때 사용한다

// **java.awt 의 이벤트 처리
// swing, android 가 동일한 방식으로 처리
// event: 사용자 또는 프로그램에 의해 발생하는 사건
// Listener: 이벤트를 처리해 줄 수 있는 인스턴스
// EventHandler: 이벤트가 발생했을 때 호출되는 함수 또는 인스턴스
// awt 는 이벤트가 발생하면 jvm 에게 이벤트가 전달되고 jvm 은 이 이벤트 객체를 가지고 등록된 리스너를 찾아서 이벤트 핸들러를 호출한다.
// 이벤트 리스너 등록
// 컴포넌트.add이벤트리스너(이벤트 리스너 인스턴스);

// 1. ActionListener 인터페이스
//    버튼을 클릭하거나 메뉴 또는 리스트를 선택하거나 텍스트 필드에서 Enter를 눌렀을 때 발생하는 이벤트를 처리하기 위한 인터페이스

// 2. Event Routing
//    여러 컴포넌트의 이벤트를 하나의 리스너가 처리하도록 만드는 것
//    이벤트를 처리하는 메소드의 매개변수가 이벤트가 발생한 객체의 주소를 가지고 있기 때문에 가능하다.
//    이벤트 객체의 getSource() 를 호출하면 이벤트가 발생한 객체의 주소를 알 수 있다.
//    ActionEvent 의 경우는 getActionCommand() 를 호출하면 이벤틀가 발생한 객체의 문자열을 리턴 해 준다.
//    버튼의 경우는 버튼에 작성된 타이틀을, 메뉴의 경우는 메뉴에 보여지는 문자열을 리턴한다.

// 3. ItemEvent
//    Checkbox 나 Radio Button 을 선택했을 때 그리고 ComboBox 에서 항목을 선택했을 때 발생하는 이벤트를 처리하기 위한 리스너
//    ItemEvent 클래스의 인스턴스가 이벤트에 대한 정보를 가지고 있다.
//    체크박스를 선택하면 선택한 체크박스의 문자열과 상태를 텍스트 영역에 출력하고 카테고리 콤보박스를 선택하면 카테고리 내의 항목을
//    세부내용 콤보박스에 출력하고 버튼을 누르면 선택한 콤보박스의 항목을 텍스트 영역에 출력하기
// 3-1. 윈도우를 만들어서 출력하기
//      윈도우 클래스 만들기: Frame 으로부터 상속받는 클래스를 생성
// 3-2. 윈도우에 컴포넌트들을 배치
// 3-3. 이벤트를 처리
//      setVisible 호출 전에 추가
//      버튼을 눌렀을 때를 처리해주는 리스너: ActionListener
//      1) ActionListener 인스턴트를만들기
//      2) 사용할 컴포넌트와 연결

// **GUI 이벤트 처리
// 이벤트를 처리하는 리스너를 찾아야 한다.

// **Eclipse 설치
// 과거에는 압축 파일을 다운로드 받아서 압축을 해제하는 형식으로 사용
// www.eclipse.org 에서 설치 프로그램을 다운받아 설치

// **Java 설치
// www.oracle.com 에서 다운로드 받아서 설치
// 현재는 1.8버전을 가장 많이 사용
// java se jdk 를 설치하면 된다
// 설치가 끝나면 path, Java_HOME, JER_HOME 이라는 환경 변수를 설정(맥은 할필요 없음)
// 리눅스에서는 필수 작업이고 윈도우 에서는 하지 않아도 자바 프로그래밍을 할 수는 있지만 매우 불편하다.




package awt;

public class 필기 {

}
