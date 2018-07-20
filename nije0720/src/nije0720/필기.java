// **추상 클래스(abstract class)
// 인스턴스를 생성할 수 없는 클래스
// 자바에서 만들 때는 class 앞에 abstract 를 붙여서 사용
// 인스턴스를 만들 수 없기 때문에 상속을 통해서만 사용
// 여러 클래스에서 공통으로 사용할 메소드들을 소유하고 있는데 대부분의 경우 메소드를 비어 있는 상태로 가지고 있다.
// 인터페이스는 메소드를 추상 메소드로 가지고 있다. 추상 클래스의 메소드는 상속받은 클래스에서 필요한 것만 구현하면 되지만
// 인터페이스의 메소드는 전부 구현을 해야 한다. 즉 인터페이스와 추상 클래스는 다르다.

// **Stream
// JVM 외부에 있는 파일이나 네트워크에 입출력하기 위한 통로
// 단방향성 성질을 가지고 있어 읽는 스트림과 쓰는 스트림이 구분되어 있다.
// 1. Byte Stream: 바이트 단위로 입출력하는 스트림으로 InputStream 과 OutputStream 이라는 추상 클래스에 공통으로 사용하는
//                 메소드를 선언해 두었다.
// 2. Character Stream: 문자 단위로 입출력하는 스트림으로 Reader 와 Writer 라는 추상 클래스에 공통으로 사용하는 메소드를
//                      선언해 두었다.

// **ByteStream
// 바이트 단위로 입출력하는 스트림
// 1. InputStream 
//    바이트  단위로 데이터를 읽어오기 위한 스트림
//    
//    메소드: 
//    void close(): 스트림의 닫기 위한 메소드
//    int available(): 읽을 수 있는 바이트 크기를 리턴하는 메소드
//    int read(): 1 바이트의 데이터를 읽어서 정수로 리턴하는 메소드로 리턴값이 음수이면 읽을 데이터가 없는 것 이다. 
//    int read(byte [] b): b 배열의 크기만큼을 읽어서 b 에 저장하고 읽은 바이트 수를 리턴하는 메소드
//                         이 메소드의 리턴 값이 0보다 작거나 같으면 읽을 데이터가 없는 것이다.
//    int read(byte [] b, int offset, int length): b 배열에 offset 부터 length 만큼 읽어서 저장하는 메소드로
//                                                 읽은 개수를 리턴한다. 이 메소드의 리턴 값이 0보다 작거나 같으면
//                                                 읽을 데이터가 없는 것이다.
//    long skip(long n): n 바이트 만큼 스킵

// 2. OutputStream
//    데이터를 바이트 단위로 출력하기 위한 메소드를 소유한 추상 클래스
//
//    메소드:
//    void close(): 스트림 닫기
//    void write(int b): b를 출력
//    void write(byte [] b): b 배열의 모든 내용을 기록
//    void write(byte [] b, int offset, int length): b 배열의 offset 부터 length 만큼을 기록
//    void flush(): 버퍼에 저장된 내용을 기록

// 3. java.FileOutputStream
//    파일에 바이트 단위로 기록하는 클래스
//    생성자:
//    FileOutputStream(String name): 파일의 경로를 문자열로 대입하여 생성하는데 기록 시 무조건 처음부터 기록한다.
//                                   파일이 존재하지 않으면 생성한다.
//    FileOutputStream(String name, boolean append): append 가 true 이면 파일이 존재하는 경우에 맨 마지막에 추가
//                                                   해서 기록한다.
//    FileOutputStream(File file): 파일의 경로를 문자열로 주는 대신에 File 인스턴스를 생성해서 대입한다.
//    FileOutputStream(File file, boolean append)

// 4. java.io.FileInputStream
//    파일에서 바이트 단위로 읽어오는 클래스
//    생성자:
//    FileInputStream(String name): 파일 경로를 문자열로 대입해서 생성
//    FileInputStream(File file): 파일 경로를 File 인스턴스로 만들어서 대입

// # 읽을 때는 반복문을 이용해서 읽어야 하고 읽은 것이 없으면 반복문을 종료하도록 설정해 주어야 한다.

// 5. 입 출력을 할 때 버퍼를 이용하는 이유
//    파일 입출력이나 네트워크 입출력은 운영체제의 자원을 이용하기 때문에 운영체제의 native 메소드를 호출해야 한다.
//    입출력을 빈번히 수행하게 되면 운영체제와 통신을 많이 해야 하기 때문에 비 효율적일 수 있다. 
//    즉 입출력할 내용을 버퍼에 모아서 처리하도록 하면 native method 호출의 횟수를 줄일 수 있기 때문에 버퍼를 이용하는 것이다.

// 6. BufferedInputStream
//    바이트 단위로 버퍼를 이용해서 읽어내는 스트림
//    이 스트림은 다른 스트림을 매개변수로 받아 생성

// 7. PrintStream
//    바이트 단위로 버퍼를 이용해서 기록하는 스트림으로는 BufferedOutputStream 이 있는데 출력하는 메소드로 print 를 사용할
//    수 있는 PrintStream 을 더 많이 사용한다.
//    콘솔에 출력하는 System.out 이나 System.err 이 PrintStream 에 해당된다.
//    File 이나 OutputStream 인스턴스를 이용해서 객체를 생성한다.
//    write 메소드 이외에도 print 메소드를 사용할 수 있다.
//    print 메소드는 출력하라는 명령이 올 때 까지 출력하지 않고 모아서 출력하고 println 은 한 줄의 명령이 올 때 마다 바로바로 출력한다.
//    println 은 한번에 출력해야 하는 내용은 나누어서 출력하면 이상한 결과가 유도될 수 있으므로 반드시 한 번에 출력해야 한다.

// # 주로 사용하는 클래스는 FileReader, FileWriter, BufferedReader, PrintWriter 클래스 이다.

// 1. Reader 클래스
//    문자 단위로 읽기 위한 메소드를 보유한 추상 클래스
//    메소드:
//    char read()
//    int read(char [] ch)
//    int read(char [], int offset, int leng)

// 2. Writer 클래스
//    문자 단위로 기록하기 위한 메소드르 소유한 추상 클래스
//    메소드:
//    void write(String str)

// 3. FileWriter
//    문자 단위로 파일에 기록할 수있는 스트림 클래스
//    생성자:
//    FileWriter(String 파일 경로)
//    FileWriter(String 파일 경로, boolean append): append 에  true 를 대입하면 파일이 있는 경우에는 이어쓰기를 한다.
//    FileWriter(File file)
//    FileWriter(File file, boolean append): append 에 true 를 대입하면 파일이 있는 경우에는 이어쓰기를 한다.

// 4. FileReader
//    파일의 내용을 문자 단위로 읽을 수 있는 스트림 클래스
//    생성자:
//    FileReader(String 파일경로)
//    FileReader(File file)

// 5. BufferedReader
//    버퍼를 이용해서문자 단위로 읽어오는 클래스
//    줄 단위로 읽어서 String 으로 리턴하는 readLine 메소드가 있다.
//    생성자:
//    BufferedReader(Reader reader)
//    FileReader 와 같은 클래스의 인스턴스를 대입해도 되고 new InputStreamReader(InputStream inputStream)
//    을 이용해서 인스턴스를 생성할 수도 있다.
//    네트워크(소켓, 웹) 에서 문자열을 읽어 올 때는 두 번째 방법을 사용한다.

// # Scanner 를 이용해서 정수와 문자열을 연속해서 입력받는 경우 정수를 받을 때 nextInt 를 사용하면 문제가 발생할 소지가 있다.
//   되도록이면 문자열 단위로 입력받은 후 정수로 변환하는 방식을 사용하는 것이 좋다.

// ex1) 이름, 리치, 키를 키보드로부터 입력받아서 저장하기
//      VO(Variable Object-데이터 저장을 위한 클래스) 클래스 이용
//      키보드로부터 입력은 BufferedReader 이용

// ex2) 내용이 많은 파일의 내용을 읽거나 웹에서 다운로드 받는 경우에는 분할 해서 데이터를 가져온다.
//      문자열을 분할해서 읽은 후 하나로 만들 때는 문자열을 계속해서 이어 붙여야 한다.
//      String 은 원래의 문자열에 다른 문자열을 추가하면 복사를 수행한 후 작업을 하기 때문에 이어붙이기를 하면 메모리 낭비가 발생한다.
//      이럴 때는 StringBuilder 를 이용하여 문자열을 이어 붙이고 다 읽은 후에 String 으로 변환하는 작업을 활용해야 한다.

// **csv 파일을 읽어서 통계 작업
// csv: 공백이나 탭 또는 Enter 를 이용하여 데이터를 구분한 텍스트 파일
//      변하지 않는 데이터를 제공하고자 할 때 많이 사용한다.

// # 하나의 텍스트를 분할할 때
// 1)기호로 분할: String [] split("기호") - 기호로 분할해서 String 배열을 만들어 준다. 보통 , 와 공백으로 구분된다.
// 2)위치로 분할: string substring(자를 위치) - 위치 부터 끝까지의 문자열을 리턴
// 3)앞에서부터 자를 때: charAt(int idx) 를 이용

                   

package nije0720;

public class 필기 {

}
