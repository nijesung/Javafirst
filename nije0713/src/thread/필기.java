// **Thread
// 작업의 수행 도중 쉬는 시간이 생기거나 일정한 시간이 되면 자신의 작업을 중지하고 다른 작업으로 제어권을 이동할 수 있는 작업 단위
// Process(실행 중인 프로그램 - 함수나 메소드 호출) 안에 상주하며 실행
// 하나의 Process 는 하나 이상의 Thread 로 구성

// **Thread 생성 및 시작
// 1. Thread 생성
// 1-1. Thread 클래스로 부터 상속받는 클래스를 만들고 스레드로 수행할 내용을 run 메소드에 작성 한 후 인스턴스를 생성
// 1-2. Runnable 인터페이스를 구현한 클래스를 만들고 스레드로 수행할 내용을 run 메소드에 작성한 후 인스턴스를 생성하고 Thread
//      클래스의 생성자에 인스턴스를 대입해서 Thread 인스턴스를 생성
// 2. Thread 시작
//    1 에서 만든 Thread 인스턴스를 가지고 start() 를 호출하면 된다.

// **클래스와 인터페이스
// 클래스는 내용을 가지고 있다.
// 인터페이스는 내용은 없고 이름만 가지고 있다.

// **스레드 작업 순서
// 1. Thread 클래스나 Runnable 인터페이스를 implements 한 클래스를 생성
// 2. 스레드로 수행할 내용을 run 메소드에 재정의(overriding)

// **스레드 클래스의 멤버
// 1. constructor(생성자): 인스턴스를 생성할 때 호출하는 메소드 - new
// Thread(): 이름을 디폴트로 해서 스레드 인스턴스 생성
// Thread(String name): 매개변수로 대입된 문자열을 스레드의 이름으로 사용
// Thread(Runnable runnable): Runnable 을 이용해서 스레드 인스턴스 생성
// Thread(Runnable runnable, String name): Runnable 을 이용하고 name 을 스레드 이름으로 사용

// 2. 주요 메소드
// String getName(): 스레드의 이름을 문자열로 리턴
// int getPriority(): 스레드의 우선순위를 정수로 리턴
// void interrupt(): 스레드에게 interrupted Exception 을 발생시킨다 (중요)
// void run(): 스레드로 수행할 내용을 가지는 메소드로 반드시 재정의 해야 한다 (중요)
// void setDaemon(boolean b): 데몬 스레드 설정 여부
// void setName(String name): 스레드 이름 설정
// void setPriority(int priority): 스레드의 우선 수누이 설정
// void start(): 스레드 시작
// static void sleep(long millis) throws InterruptedException: 인스턴스 생성 없이 클래스 이름만으로 호출이
// 가능하고 이 메소드를 호출할 때는 interruptedException 을 처리해야 한다.
// void wait(): 스레드를 대기
// void notify(): 대기중인 스레드 1개의 작업을 시작
// void notifyAll(): 대기중인 모든 스레드를 시작

// Daemon 스레드
// 백그라운드에서 동작해서 다른 스레드의 수행을 돕는 스레드
// setDaemon 이라는 메소드에 true 를 대입해서 생성
// 다른 스레드가 동작 중이 아니면 자동으로 종료된다.

// **스레드 우선순위
// 여러 개의 스레드가 실행 중 일때 조금 더 자주 먼저 실행할 수 있도록 우선순위를 조정할 수 있다.
// 엄밀하게는 정확하게 동작하지는 않는다.
// Thread 객체를 만들고 setPriority 메소드에게 우선순위 값을 설정하면 된다

// **스레드의 종료
// 스레드를 강제 종료하기 위해서는 스레드의 run 메소드에 InterruptedException 이 발생했을 때 run 메소드의 수행을 종료하는
// 코드(return)을 삽입하고 다른 스레드에서 interrupt()를 호출하면 된다.

// **상호배제(Mutual Exclusion)
// 하나의 스레드가 사용 중인 공유 자원을 다른 스레드가 수정할 수 없다.
// 1. 32bit 시스템에서 64bit 자료형을 사용하는 경우
//    변수를 만들 때 자료형 앞에 volatile 을 붙여주면 작업을 나누어서 하더라도 중간에 멈추지 않고 연산을 수행한다.
// 2. 공유 자원을 사용하는 메소드의 결과형 앞에 synchronized 를 추가해서 이 메소드를 스레드가 호출할 경우 작업 중인지 확인하고
//    호출하도록 해서 해결
// 3. 공유 자원을 사용하는 코드 영역을 synchronized(공유자원){} 으로 감싸서 동시에 공유자원을 사용할 수 없도록 해서 해결

// **생산자와 소비자 문제
// 생산자와 소비자는 하나의 진열대를 공유해서 사용할 수 있다.
// 동시에 작업을 수행하는 것을 허용한다.
// 생산자와 소비자는 하나의 진열대를 사용하는 방법이 다르기 때문에 상호배제의 영향을 받지 않는다. (같이 사용해도 아무런 문제가 되지 않는다)
// wait() 는 사용할 데이터가 없는 경우 대기하기 위한 메소드
// notify() 는 대기하고 있는 스레드를 깨우는 메소드
// 위 2개의 메소드는 synchronized 메소드에서만 제대로 동작한다.
// 일반 메소드에서는 wait() 와 notify() 가 제대로 동작하지 않는다.
// 문자를 저장하는 List 를 공유해서 하나의 스레드는 List에 데이터를 26번 저장하고, 하나의 스레드는 List 에서 26번 꺼낸다고 해보자
// 1. 문자를 저장할 수 있는 List 를 가진 클래스를 생성 (List 를 static 으로 선언 : 인스턴스 생성 없이 바로 사용이 가능하다)
// 2. 위의 공유 자원을 생성자에서 넘겨받아 list에 A-Z 까지 저장하는 스레드 클래스 


package thread;

public class 필기 {

}
