// # 구현된 코드에서 설계 정보 추출 : Reverse Engineering(역 공학)
// 설계 -> 구현 과정에서의 자동화 도구 : Modeling Tool

// **Database Modeling 도구
// 데이터베이스 에서 설계를 하면(ER-Diagram 작성) 실제 데이터베이스에 구현을 해 주고 이미 구현된 데이터베이스로 부터
// 설계 정보를 추출해주는 도구
// E-R Win 이라는 프로그램이 가장 유명하다.
// 실습에서는 무료 도구인 EX-ERD 를 사용

// EXERD 설치
// 이클립스 플러그인을 이용하여 설치
// http://exerd.com/update

// 역공학 : 구현된 데이터베이스 에서 설계 정보를 추출하는 것
// perspective 를 Exerd 로 변경

// **데이터베이스 작업을 위한 테이블 생성
// 초안산 생물군 테이블(choan_biota)
// 번호(num - 정수 8자리, primary key)
// 개체수(population - 정수 8자리, primary key)
// 이름(specific_name - 한글 10자이내, not null)
// 발견일자(detect_day - date)

// # 생성 순서
// 새로운 ExERD 파일을 생성
// 테이블을 디자인
// 스키마의 물리적 이름을 생성할 계정으로 변경
// exERD 메뉴에서 포워드 엔지니어링 선택
// (!)테이블 이름과 컬럼 이름은 띄어쓰기를 금지한다.

// **DAO(Data Access Object)
// 데이터베이스에 접속해서 작업을 수행하는 객체
// 1. Singleton
//    클래스의 객체가 1개만 만들어지는 디자인 패턴
//    관리자나 공유 객체를 만들거나 서버에서 작업하는 객체를 만들 때 이용
//    관리자 클래스의 객체는 2개나 있을 필요가 없고 서버에서 작업을 처리하는 클래스들의 객체도 특별한 경우가
//    아니면 2개 이상 존재할 필요가 없다.

// ex) 자신이 만든 테이블에 CRUD 작업을 수행하는 프로젝트
//     create table contact(
//     number(8) primary key,
//     specific_name varchar2(30) not null;

//     초안산 생물군 테이블(choanbiota)
//     번호(num - 정수 8자리, primary key)
//     개체수(population - 정수 8자리, primary key)
//     이름(specific_name - 한글 10자이내, not null)
//     발견일자(detect_day - date)

// 1) choan_biota 테이블의 데이터를 저장할 수 있는 DTO 클래스 만들기
//    Date 는 날짜만 필요한 경우는 java.sql.Date 로 선언하고 날짜와 시간 모두 필요한 경우는
//    java.util.Date 를 사용해야 한다.
// 2) 저장해야 하는 컬럼들을 private 변수로 선언
// 3) getters and setters 를 생성
// 4) toString 재정의

// insert into Chaonbiota(num, specific_name, population, detect_day)

// **템플릿 메소드 패턴
// 실제 사용할 메소드의 원형을 갖는 인터페이스를 만들고 구현은 별도의 클래스에서 담당하는 디자인 패턴
// 2. 데이터베이스 작업을 위한 인터페이스 생성 : Chaon_
// 기능: 데이터 삽입, 데이터 삭제, 데이터 수정, 데이터 전체보기, 데이터 조회
// 3. 데이터베이스 관련 메소드가 구현될 클래스를 생성하고 메소드를 구현
//    choanbiota 인터페이스를 implements 한 클래스 생성: ChoanbiotaDaoimpl

// 4. 데이터베이스 관련 메소드가 구현될 클래스를 생성하고 메소드를 구현
//    ChoanbiotaDao 인터페이스를 implements 한 클래스 생성 : ChoanbiotaDaoImpl
//    데이터를 삽입할 때 기본키 저장 문제
//    기본키나 unique 옵션이 설정된 컬럼은 동일한 값을 가질 수 없다.
//    id 나 email, nickname 처럼 사용자로부터 직접 입력받는 항목은 중복검사를 수행해서 중복검사를 통과한 경우에만
//    삽입이 되도록 해야 하며 글번호 처럼 자동으로 만들어진 항목은 오라클의 경우는 sequence 그리고 MySQL 은
//    aute_increment 로 해결할 수 있는데 다른 방법으로는 가장 큰 번호를 찾아서 +1을  하는 방법도 있다.

// # 수정
//   삽입과 마찬가지로 모든 데이터를 매개변수로 받아서 처리한다.
//   특별한 경우가 아니면 기본키를 조건으로 해서 나머지 항목을 수정한다.

//   ex)
//   update Choanbiota
//   set    specific_name = ?, population = ?, detect_day = ?
//   where  num = ?;

// # 삭제
//   기본키를 입력받아서 기본키를 조건으로 해 삭제를 한다.
//   delete from Choanbiota
//   where num = ?

// # 작업 순서
//   1. 데이터베이스 연결 - connect()
//   2. SQL 생성 - ppsm 생성
//   3. ppsm 에 물음표가 있으면 실제 데이터를 바인딩
//   4. SQL 을 실행
//   5. 결과를 사용
//   6. 데이터베이스 연결 해제 - close();

// **View
// Dao 를 이용해서 데이터베이스 작업 내용을 출력할 View 만들기
// 입력받아서 데이터를 삽입하거나 수정을 할 때는 유효성 검사를 해야 한다.
// 유효성 검사는 프로그램 에서 할 수 있고 데이터베이스 에서 할 수 도 있다.
// 클라이언트 서버 시스템이라면 클라이언트 에서 할 수도 있고 서버에서 할 수도 있다.
// 속도나 트래픽 면에서는 앞쪽(프론트엔드=클라이언트)에서 하는 것이 좋고 보안의 측면 에서는 뒤쪽(백엔드:서버)에서 하는 것이 좋다.

package DB;

public class 필기 {

}
