// **Oracle 연동
// 1. 데이터베이스 연결 및 해제
// 1-1. 프로젝트의 build path 에 오라클 드라이버를 추가
//      프로젝트에 ojdbc6.jar 파일을 복사
//      복사한 파일을 선택하고 마우스 오르쪽을 클릭 후 [빌드 패스] -> [애드 투 빌드 패스] 를 수행

// 1-2. 오라클 클래스를 로드
//      Class.forName("oracle.jdbc.driver.OracleDriver"); - 예외 처리를 해 주어야 한다.

// 1-3. Connection 을 생성
//      Connection 변수명 = DriverManager.getConnection("데이터베이스 URL", 
//					"계정", "비밀번호");
//      반드시 닫아야 하기 때문에 일반적으로 변수는 try 바깥에 null 을 대입해서 선언하고 try 안에서 코드를 호출해서 객체를 생성
//      URL 은 데이터베이스마다 입력하는 방법이 결정되어 있다.
//      # Oracle 의 URL 작성
//      "jdbc:oracle:thin:@데이터베이스위치:포트번호:sid

// 1-4. Connection 을 닫기
//      변수명.close();

// 2. SQL 연동 클래스
// 2-1. Statement : 완성된 SQL 을 대입해야 하는 SQL 실행 클래스
//                  보안상의 문제 때문에 실제 사용은 권장하지 않는다.

// 2-2. PreparedStatement : 객체를 생성할 때 미리 SQL 을 입력해야 하고 나중에 대입할 데이터는 ? 로 선언하고 값을 바인딩하는 구조
//                          대다수 프로그래밍 언어가 이 방식을 이용한다.
//                          1) 객체 생성
//                             PreparedStatement 변수 = Connection변수.PreparedStatement("sql");
//                          2) 데이터 바인딩
//                             sql 에 물음표가 있으면 데이터를 바인딩(값을 대입)
//                             물음표가 여러 개 있으면 물음표가 있는 만큼 바인딩 해야 한다.
//                             변수.set자료형(물음표번호, 실제데이터);
//                          3) SQL 실행
//                             select 를 제외한 구문 실행
//                             리턴되는 정수는 영향받은 행의 개수 이다.
//                             create, alter, drop 을 실행하면 성공시 0이 리턴된다.
//                             int 변수명 = PreparedStatement변수.executeUpdate();
//                           # select 구문
//                             ResultSet 변수명 = PreparedStatement변수.executeQuery();
//                          4) 사용이 종료되면 close() 를 호출해야 한다.

// 2-3. CallableStatment : 프로시저를 실행하는 클래스

// **dept 테이블 구조
// deptno : 숫자 2자리, primary key(not null 이고 unique)
// dname : 문자 14자리 (한글 4자 정도)
// loc : 문자 13자리 (한글 3자 정도)

// insert into dept(deptno, dname, loc) values(50, '집게벌레', '초안산');

// # sql 을 작성할 때 예약어는 한 칸 이상 공백을 주어야 한다.
// create table 테이블이름(컬럼이름 datatype constraint..)
// alter table 테이블이름 [add | modify | drop](컬럼이름 datatype constraint..)
// drop table 테이블이름
//
// select 컬럼이름 나열
// from 테이블이름 나열
// where 조건
// group by 그룹화할 조건
// having 그룹화 이후 조건
// order by 정렬할 컬럼 이름
//
// insert into 테이블이름(컬럼이름나열) values(값을 나열)
// update 테이블이름 set 수정할컬럼이름=수정할내용 where 조건
// delete from 테이블이름 where 조건
// # where 에 들어가는 조건을 제외하고는 대소문자 구분하지 않는다.

// # java 는 기본적으로 auto commit 이다.
//   commit 을 호출하지 않아도 insert, delete, update 한 내용이 자동으로 데이터베이스에 반영된다.

// **데이터 바인딩
// deptno, dname, loc 를 키보드로 부터 입력받아서 삽입
// sql 을 문자열로 완성해서 대입해야 한다면 문자열 마다 작은 따옴표를 기재해야 하고 Date 같은 자료형들을 삽입하는 것은 매우 지겨운 작업이
// 된다.
// sql 에서 값을 대입할 수 있는 자리에는 ?로 작성을 하고 실제 데이터는 PreparedStatement 객체를 만든 후 set자료형(물음표번호,
// 실제데이터) 를 이용하여 바인딩하는 방법을 제공하고 있다.
// 자료형으로는 int, double, String, blob 등을 제공하고 있다.

// ex) deptno 를 입력받아서 dept 테이블에서 제거해 보자
//     deptno 는 정수라는 것을 인지.
//     deptno 를 입력받는 것과 | dept 테이블에서 제거하는 것은 별개의 독립적인 과정이다.
//     1. deptno 를 입력(Scanner) 받는 작업을 선행

//     데이터베이스에서 deptno 에 해당하는 데이터 제거
//     Connection 과 Prepared Statement 타입의 변수 생성

// 4. 데이터베이스 연동 프로그램 사용 시 무한 대기상태에 빠지는 경우
//    다른 프로그램에서 insert, delete, update 를 수행하고 commit 이나 rollback 을 하지 않는 경우 자신이 작성한 프로그램에서
//    insert, delete, update 를 수행하면 무한 대기상태에 빠질 수 있다.
//    다른 접속 프로그램에서 commit 이나 rollback 을 수행하면 해결된다.

// 5. autocommit 
//    java 는 데이터베이스 연동을 할 때 기본적으로 auto commit 으로 설정되어 있다.
//    sql 을 하나 실행할 때 마다 commit 을 한다.
//    한꺼번에 이루어 져야 하는 작업이 있을 때는 auto commit 은 위험하다.
//    Connection 객체를 만들고 난 후 setAutoCommit(boolean b) 메소드를 이용해서 auto commit 을 해제하고
//    menual commit 으로 변경할 수 있다. 이 때는 작업을 완료하고 난 후 commit 이나 rollback 을 호출해야 한다.

// 6. select
//    select 구문은 executeUpdate 대신에 executeQuery 메소드로 실행한다.
//    결과는 ResultSet 이라는 인터페이스의 인스턴스로 리턴된다.

// 7. ResultSet
//    select 구문의 실행 결과를 저장해서 사용할 수 있도록 해주는 인터페이스 이다.
// 7-1. next()
//      읽을 데이터가 있으면 true 를 리턴하고 읽을 데이터를 가리킨다.
//      읽을 데이터가 없으면 false 를 리턴한다.

// 7-2. get자료형(인덱스 또는 컬럼이름)
//      인덱스는 정수로 입력하고 컬럼 이름일 때는 문자열로 입력
//      데이터를 컬럼 단위로 읽어서 리턴하는 메소드 이다.
//      컬럼의 자료형이 어떤 자료형이든 String 으로 읽을 수 있다.

// ex) select deptno, dname, loc from dept;
//     ResultSet rs = ppsm.executeQuery();
//     while(rs.next()){ // 읽을 데이터가 없을 때 까지 반복
//       int deptno = rs.getInt("deptno");
//       // 혹은 int deptno = rs.getInt(1);
//       String dname = rs.getString("dname");
//       String loc = rs.getString(3);
//     }

// ex) dept 테이블의 모든 데이터를 읽어서 출력하기
//     dept 테이블 : deptno(정수-기본키),dname(문자열), loc(문자열)
//     dept 테이블의 모든 데이터를 읽는 sql : select deptno, dname, loc from dept

// ex2) dept 테이블의 모든 데이터를 Map 의 List 로 저장하기
//      HashMap
//      1) 생성자 : HashMap<K, E>() - K 는 특별한 경우가 아니면 String E 는 Object
//      2) 데이터 저장 : put(키이름, 데이터)
//      3) 데이터 읽기 : Object(키이름) - 출력할 때는 바로 사용하면 되고 다른 용도로 사용하고자 하는 경우는 저장할 때의 자료형으로
//                                  강제 형 변환해서 사용한다.
//      ArrayList
//      1) 생성자 : ArrayList<E>() - E 는 데이터 1개의 자료형
//      2) 데이터 저장 : add(데이터)
//      3) 데이터 가져오기 : E get(인덱스)
//      4) 빠른 열거 사용 가능
//         for(E e : List 이름){
//
//         }
//         >List 의 모든 요소가 순서대로 e에 대입된다.

// ex3) dept 테이블의 모든 데이터를 DTO 의 List 로 저장하기
//      DTO(Data Transfer Object) 패턴 - VO(Variable Object) 라고 부르기도 한다.
//      하나의 행을 저장할 클래스
//      여러 명이 공동으로 작업하는 프로젝트에서 많이 사용
//      저장할 컬럼들을 private 변수로 선언
//      변수들을 사용하기 위한 getter 와 setter 메소드를 생성
//      디버깅을 빠르게 하기 위해서 toString 을 재정의

//      1) 하나의 행을 저장하기 위한 DTO 클래스를 생성 : Dept

package DBex;

import java.sql.DriverManager;

public class 필기 {

}
