// **Map
// key 와  value 를 쌍으로 저장하는 자료구조
// key 와 value 모두 Generic 을 적용 가능
// key 는 set 으로 구성 (set 은 중복 되지 않는 특성)
// 구현된 클래스는 Hashmap, LinkedHashMap, TreeMap
// HashMap 은 어떤 순서로 저장 되어있는지 정확히는 알 수 없다.
// LinkedHashMap 은 입력한 순서를 기억한다.
// TreeMap 는 정렬이 되어 있는 구조이다.

// Stream ex)
// 1. 읽을 수 있는 Stream 생성 
// 2. 줄단위 읽는 코드 생성
// 3. 줄 단위로 읽은 데이터를 가지고 IP 별 접속횟수를 계산

// # import 단축키: 컨트롤 + 시프트 + O

// **PrintWriter
// 파일이나 네트워크에서 문자 단위로 데이터를 전송하기 위한 클래스
// 버퍼링을 이용해서 전송을 하기 떄문에 네이티브 메소드 횟수를 줄여서 출력 효율을 높여 준다.

// 1. 생성자
//    문자열로 파일의 경로를 받아서 생성 가능
//    File 객체로 파일을 받아서 생성 가능
//    OutputStream 객체를 받아서 생성 가능
//    Writer 객체를 받아서 생성 가능

// 2. 메소드
//    print, printf, println 으로 전송할 수 있고 flush 메소드를 이용해서 버퍼의 내용을 전부 전송한다.

// **Serializable
// 파일이나 네트워크에 데이터를 전송할 때 객체 단위로 전송할 수 있도록 해 주는 인터페이스 이다.
// ObjectInputStream 과 ObjectOutputStream 클래스를 이용한다.
// Serializable 인터페이스를 implements 한 객체 단위로 데이터를 전송하게 되면 그 클래스가 없으면 데이터를 읽을 수 없다.
// 응용 프로그램을 만들 때는 데이터를 위한 클래스를 만들고 이 클래스의 객체 단위로 데이터를 저장해서 다른 응용 프로그램에서 데이터를 읽을 수
// 없도록 만든다.
// Serializable 에서 제외하고자 라는 변수가 있는 경우에는 transient 라는 예약어를 이용하면 된다.

// 1. ObjectInputStream
//    객체 생성은 InputStream 을 받아서 한다.
//    파일에서 읽어 올 때는 FileInputStream 을 만들어서 대입하면 되고 네트워크 일 때는 네트워크의 InputStream 을 받아서 생성
//    데이터를 읽을 때는 readObject 메소드를 이용 하는데 리턴되는 데이터 타입이 Object 로 리턴되기 때문에 출력만 할 때는 바로 하면
//    되지만 사용을 할 때는 강제 형 변환을 통해 원래의 자료형으로 되돌려서 사용해야 한다.

// 2. ObjectOutputStream
//    객체 생성은 OutputStream 을 받아서 한다.
//    파일에 기록 할 때는 FileOutputStream 을 만들어서 대입하면 되고 네트워크 일 때는 네트워크의 OutputStream 을 받아서 생성
//    기록은 writeObject 메소드를 이용해서 저장할 객체를 대입하면 된다.

// 3. 안드로이드의 Activity 전환에서 데이터를 전달 할 때는 이 방식을 이용하기 때문에 Serializable 인터페이스를 implements 한
//    객체만 전달이 가능하다.

// **파일에 객체 단위로 기록하고 읽기
// 1. 기록할 객체의 클래스 생성 - Serializable 인터페이스를 implements
// 2. 1번에서 만든 클래스의 객체를 파일이 기록하는 작업을 위한 Main 메소드를 소유한 클래스를 생성

// # 연습문제
//   Date 1개와 실수 2개를 저장할 수 있는 클래스를 만들고 이 클래스의 객체를 파일에 저장해 보고 읽어오기

// **네트워크 관련 명령어
// ipconfig /all : 자신의 컴퓨터 주소 정보
// netstat -ano : 사용 중인 포트와 연결된 컴퓨터에 대한 정보 및 프로세스 ID 출력
// taskkill -p 프로세스 아이디 /f : 프로세스 강제 종료

// **java.net.InetAddress
// 주소 정보와 관련된 클래스
// 객체 생성은 생성자를 이용하지 않고 static 메소드를 이용
// getLocalHost() : 자기 컴퓨터에 대한 주소 정보 리턴
// getByName(호스트이름) : 호스트 이름에 해당하는 하나의 주소 정보  리턴
// getAllByName(호스트이름): 호스트 이름에 해당하는 모든 주소 정보를 배열로 리턴

// **TCP 통신
// Server 와 Client 간의 연결형 통신
// ServerSocket 클래스 : 접속을 당하는 쪽에서 생성하는 소켓
//                     포트번호 또는 포트번호와 동시접속자 수 를 매개변수로 받아서 생성
//                     accept() 를 호출하여 클라이언트의 접속을 대기
//                     클라이언트의 접속이 이루어지면 accept() 는 클라이언트와 통신할 수 있는 Socket 객체를 리턴
//                     접속하는 쪽에서는 Socket 을 생성할 때 ip 주소와 포트번호를 이용해서 서버에 접속

// **UDP 통신
// 1. DatagramSocket : UDP 통신을 위한 소켓 클래스
// 1-1. 생성자
//      DatagramSocket(): 보내는 쪽
//      DatagramSocket(int port): 받는 쪽
// 1-2. 메소드
//    void send(DategramPacket dp): 데이터를 전송하는 메소드
//    void receive(DatagramPacket dp): 데이터를 읽어오는 메소드

// 2. DatagramPacket: UDP 통신을 할 때 데이터를 저장하기 위한 클래스
// 2-1. DatagramPacket(byte [] b, int length): 데이터를 전송받을 때 생성
//      DatagramPacket(byte [] b, int length, InetAddress addr, int port): 
//      addr 의 주소에 port 번호를 사용하는 서비스에 b 배열에서 lenth 만큼을 전송한다.

//      byte [] getData(): 전송받은 데이터를 읽을 때 사용하는 메소드
//      int getLength(): 전송받은 데이터의 크기      

// 3. String 과 byte 배열 변환
//    String 을 byte 배열로 변경: getBytes() 호출
//    byte 배열을 가지고 String 을 생성: new String(바이트 배열, 시작위치, 길이)




package 필기;

public class 필기 {

}
