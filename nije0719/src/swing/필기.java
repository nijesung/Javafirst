// **Object 클래스
// java 의 최상위 클래스
// java 의 모든 클래스는 Object 클래스를 상속한다.
// Object 타입의 변수에는 어떤 종류의 데이터든 대입할 수 있다.
// Object 타입의 대입된 데이터는 출력을 할 때는 제외하고 항상 원래의 자료형으로 형변환을 해서 사용해야 한다.
// Object 클래스에는 toString 메소드가 만들어져 있는데 이 메소드는 클래스이름@해시코드 를 문자열로 리턴하도록 되어 있다.
// 출력하는 메소드(print,println,printf)에 인스턴스 이름을 대입하면 toString 의 결과를 출력한다.

// **Swing
// 1. javax.swing.JList
//    여러 개의 항목을 출력하고 그 중 여러 개의 항목을 선택할 수 있도록 해주는 컴포넌트
//    데이터 없이 생성할 수 있고 Generic 을 이용하거나 배열을 이용해서 생성할 수 있고 Vector 를 이용해서도 생성할 수 있다. 

// 2. javax.swing.JTable
//    행과 열로 구성된 데이터를 출력하기 위한 스윙의 컴포넌트
// 2-1. MVC(Model View Controller)
//      Model: 데이터를 만드는 부분
//      View: 데이터를 출력하는 부분
//      Controller: Model 과 View 를 연결 시켜 주는 부분
//      MVC Pattern: 역할 별로 별도로 구현해서 어느 한 부분에 변화가 생기더라도 다른 부분을 수정하지 않아도 되도록 구현하는 패턴
//                   Model 에 변화가 생기더라고 View 를 수정할 필요가 없도록 하는 패턴

// 2-2. Swing의 JTable 은 데이터를 만드는 TableModel 과 화면 출력을 위한 JTable 을 별도로 구현해서 연결하는 방식을 취한다.
//      데이터의 수정과 삭제는 TableModel 을 이용하고 화면 출력은 JTable 을 이용한다.
//      TableModel 에서 데이터를 수정하고 JTable 에서 UpdateUI 메소드만 호출하면 변경된 내용이 JTable 에 적용되어 출력이
//      되는 구조이다.

// 2-3. JTable 은 JScrollPane 위에 배치해야 출력 영역 크기를 벗어나게 될 때 스크롤 바를 만들어 준다.

// 2-4. 데이터는 컬럼 이름을 나타내는 1차원 배열 또는 Vector 와 셀에 보여질 데이터를 나타내는 2차원 배열 또는 Vector 의 Vector
//      가 있어야 한다. 이 2가지 배열이나 Vector 를 이용해서 TableModel 을 만들고 이 Model 을 JTable 의 생성자에 대입하
//      거나 setModel 메소드에 대입하여 연결시킨다. 편집하기 위해서 가져올 때는 getModel 메소드를 이용한다.

// ex1) 테이블에 데이터 출력 (종명,크기,계통 을 출력)

// 3. JOptionPane
//    미리 만들어 둔 대화상자이다.
//    메시지를 출력하는 대화상자, 예 or 아니오 와 같은 버튼을 선택하는 대화상자, 한 줄의 텍스트를 입력받는 대화상자가 있다.
//    static 메소드인 showMessageDialog, showConfirmDialog, showInputDialog 를 호출해서 화면에 출력한다.
//    3가지 메소드 모두 3번째 매개변수 까지는 동일한데 각각 부모의 주소, 타이틀, 메시지 이다.
//    4번째 에서 매개변수가 달라지게 되는데 MessageDialog 는 아이콘 모양을 설정해야 하고 ConfirmDialog 는 버튼 모양을 설정해야
//    하고 InputDialog 는  YES_NO 를 설정한다.
//    MessageDialog 는 리턴하지 않고 ConfirmDialog 는 누른 버튼 값을 정수로 리턴하고 InputDialog 는 예를 누르면
//    입력한 텍스트를 String 으로 리턴하고 아니오를 누르면 Null 을 리턴한다.

// 4. Common Dialog
//    GUI 프로그램을 할 때 자주 사용하는 기능의 대화상자를 미리 만들어서 제공
//    Swing 에서는 파일을 선택하고 저장할 수 있는 JFileChooser 와 색상을 선택할 수 있는 JColorChooser 를 제공한다.

// 5. Menu
//    메뉴는 프로그램의 상단에 고정적으로 부착되는 메뉴와 화면에 떠다니는 메뉴(Popup Menu)로 구분한다.
//    JMenuBar, JMenu, JMenuItem(체크박스와 라디오 버튼 메뉴 아이템도 존재) 으로 구성
//    JMenu 와 JMenuItem 은 setMnemonic(int key)를 이용해서 ALT+key 로 단축키를 만들 수 있다.

// 5-1. 상단 메뉴
//      JMenuBar 를 만들어서 Frame 에 부착
//      JMenu 를 만들어서 JMenuBar 나 JMenu 에 부착
//      JMenuItem 을 만들어서 JMenu 에 부착

// 5-2. JPopupMenu
//      JPopupMenu 인스턴스를 만들고 메뉴를 추가하게 되는 Menu 를 여러 개의 컬럼으로 만들지는 못 한다.
//      출력할 때는 show(부모윈도우,x좌표,y좌표)를 호출하면 된다.

// **Swing 의 이벤트 처리는 AWT 와 동일하다.

// **Swing 의 메소드
// int length(): 문자열의 길이를 리턴하는 메소드
// char charAt(int idx) : idx 번 째 문자를 리턴
// String trim(): 좌우공백을 제거

// # 데이터 작업을 할 때는 항상 유효성 검사를 하고 작업을 수행해야 한다.
//   유효성 검사를 선행하지 않으면 올바르지 않은 데이터가 삽입되거나 예외가 발생해서 프로그램이 중단하는 문제가 발생할 수 있다.
//   작업을 완료하거나 실패하고 나면 작업에 대한 완료 메시지를 출력해 주는 것이 좋다.
//   이 때 메시지는 친절하고 길게 작성하는 것이 좋다.

// **java.io.File
// 파일에 대한 정보를 가지고 있고 파일에 대한 작업을 수행 할 수 있는 클래스
// 1. 생성자
//    File(String 파일의 전체 경로)
//    File(String 디렉토리 경로, String 파일 이름)
//    File(File 디렉토리, String 파일 이름)

// 2. 주요 메소드
//    boolean exists(): 파일의 존재 여부를 리턴
//    long length(): 파일의 길이를 리턴
//    long lastModified(): 파일의 최후 수정 시간을 1/1000초 단위의 정수로 리턴

// # 파일을 다운로드 해야 하는 프로그램을 만들 때 항상 파일의 존재 여부를 확인해서 다운로드 해 주어야 하고
//   이미 존재하는 파일이 업데이트 되어 다운로드 해줄 때는 최후 수정시간이나 길이를 확인해서 다운로드 해 주어야 한다.
//   또한 파일 다운로드는 되도록이면 스레드를 이용해서 해 주는 것이 좋다.
   



package swing;

public class 필기 {

}
