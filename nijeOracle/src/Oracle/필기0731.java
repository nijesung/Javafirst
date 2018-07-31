// 복습 순서 select -> DML(Insert undate delete) -> TCL(commit rollback) -> inlineView -> DDL,제약조건

// # Oracle 에서는 from 줄에 서브쿼리를 사용 가능한데 이것을 inline view 라고 한다.

// from emp, dept
// where emp.deptno = dept.deptno and gender = 'F'

// from (select gender, deptno from emp where gender = 'F') e,
//      (select deptno.loc from dept) d
//      where e.deptno = d.deptno

// # 밑의 구문이 필터링이 우수해 조인하는 갯수가 적고 처리 속도도 빠르다. 잘 쓰지 않는 문법이지만 알아두면 좋다.

// # AND 를 쓸 때는 거짓일 확률이 높은 것을 앞에 써주면 좋다. 
// # 합쳐서 필터링 할 것인가, 필터링 후 합칠 것인지 무엇이 좋은지 생각해 보자. 속도는 당연히 필터링 후 합치는 방식이 더 빠르다.
//   후자를 map-reduce 프로그래밍 이라고 부르며 일반적으로 전자보다 더 우수하다.
//   from 절에서 미리 필터링하면 된다.

// ex) select rnum, empno, ename
//     from (select rownum rnum, empno, ename from emp) e
//     where e.rnum >  3;

// **Inline View
// 오라클은 from 절에 sub query 를 사용할 수 있다.
// sub query : 다른 sql 문장의 절에 포함된 sql 문장. 괄호 안에 기재해야 하고 main query 를 수행하기 전에 1번만 수행된다.
// inline view 는 테이블에서 조회된 결과이므로 이름이 없어서 별명을 만들지 않으면 이후에 다시 사용할 수 없다.

// ex) select *
//     from (select empno, ename from emp) e1
//     where e1.ename like '%C%';

// **rownum
// 오라클에서 제공하는 행 번호와 유사한 개념
// 모든 테이블에서 사용 가능한 컬럼
// from 절에서 임시적으로 부여했다가 where 절의 조건을 만족하면 확정되는 개념. from 절에서는 이전에 확정된 번호보다 1개 큰 형태로 
// 부여한다. (관측을 통한 양자파동의 붕괴로 원자의 위치를 확정짓는 것과 비슷한 개념)

// ex) emp 테이블에서 rownum 과 empno, ename 을 조회
//     select rownum, empno, ename
//     from emp;

// ex2) emp 테이블에서 rownum 과 empno, ename 을 조회하는데 처음 3개만 조회
//     select rownum, empno, ename
//     from emp
//     where rownum < = 3;

// ex3) emp 테이블에서 rownum 과 empno, ename 을 조회하는데 처음 3개를 제외하고 조회
//     select rownum, empno, ename
//     from emp
//     where rownum > 3; // 아무 데이터도 출력되지 않는다. rownum 은 where 절을 만족해야만 확정이 되기 때문이다. 확정된 번호 다음에
                         // +1 을 한 후 행을 가져오게 되는데 where 절 조건을 만족하지 못하면 이전 번호가 계속 되풀이되기 때문이다.
                         // 이 문제를 해결하기 위해서는 where 절에 오기 전 번호를 확정해서 그 확정된 번호와 비교해야 한다.

// ex4) ex3 을 해결한 모습
//      select rnum, empno, ename
//      from (select rownum rnum, empno, ename from emp) e -- 해결 된 모습
//      where e.rnum >  3;

// ex5) emp 테이블에서 hiredate 가 가장 빠른 3명의 ename, hiredate 를 조회
//      SMITH, ALLEN, WORD 가 조회되어야 한다.
//      select ename, hiredate
//      from (select rownum rnum, ename, hiredate from emp order by hiredate)
//      where rnum <= 3; -- 맞는 것처럼 보이지만 아니다.
//      정렬을 한 후 데이터를 가져와야 하는 경우에는 정렬을 선행하여 데이터를 나열한 후 그 이후에 행 번호를 부여해야 한다.

// ex6) 확인하기 위해 이번에는 4번째 부터 6번째 까지 조회 해 보자
///     select ename, hiredate
//      from (select rownum rnum, ename, hiredate from emp order by hiredate)
//      where rnum >= 4 and rnum <=6; -- 존스 블레이크 마틴이라는 잘못된 값이 출력되는 것을 확인 가능

// ex7) ex5 의 문제를 해결한 모습
//      select ename, hiredate
//      from (select rownum rnum, ename, hiredate from (select * from emp order by hiredate))
//      where rnum > = 4 and rnum < = 6; -- 맞는 것처럼 보이지만 아니다.

// ex8) emp 테이블에서 hiredate 순으로 5개씩 출력
//      select ename, hiredate
//      from (select rownum rnum, ename, hiredate from (select * from emp order by hiredate))
//      where rnum > = 11 and rnum < = 15;


// **sequence
// 오라클에서 일련번호를 만들기 위해서 사용하는 개체
// 오라클에서는 sequence 라는 별도의 개체를 제공하기 때문에 하나의 테이블에 여러개의 sequence 를 적용할 수 잇는데 mysql 은
// 하나의 테이블에 하나의 일련번호만 사용할 수 있다.

// 1. 생성
//    create sequence 시퀀스이름
//    start with 시작번호
//    increment by 증가할 간격;

// 2. 삭제
//    drop sequence 시퀀스이름

// 3. 수정
//    alter sequence 시퀀스이름
//    start with 시작번호
//    increment by 증가할 간격;

// 4. 사용
//    시퀀스이름.nextval

// 5. 현재 값 확인
//    시퀀스이름.currval
//    이 명령은 nextval 을 한 번은 수행한 후 실행해야 한다.

// ex) 시퀀스를 생성 - start with 와 increment 는 생략 가능
//     create sequence boardseq;

// ex2) 정수와 문자열을 갖는 테이블을 생성
//      create table temp(
//      boardnum number(3),
//      baardtitle varchar2(10));

// ex3) 이전에 생성한 테이블에 데이터 추가 후 확인
//      insert into temp(boardnum, boardtitle)
//      values(boardseq.nextval, '안녕');

//      insert into temp(boardnum, boardtitle)
//      values(boardseq.nextval, '꺼져');

//      select * from temp;

// ex4) sequence 삭제
//      drop sequence boardseq;

// **Index
// 데이터를 빠르게 조회하기 위한 개체
// primary key 나 unique 는 중복검사를 위해서 데이터를 조회하는 경우가 많기 때문에 자동으로 인덱스를 생성한다.
// 인덱스의 장점은 빠르게 조회할 수 있다는 것이지만 인덱스를 만들기 위한 시간이 필요하고 저장 공간이 별도로 추가되어야 한다는 단점도 있다.
// 삽입, 삭제, 수정 작업을 주로 하는 경우에는 인덱스를 사용하지 않는 것이 바람직하다.

// 1. 생성
//    create index 인덱스이름
//    on 테이블이름(컬럼이름 나열);
// 2. 삭제
//    drop index 인덱스이름;

// **synonym(별명)
// 오라클 개체에 별명을 부여해서 사용하는 것
// 1. 생성
//    create synonym 별명
//    for 원래 이름
// 2. 삭제
//    drop synonym 별명

// # 프로그램과 연동할 때 별명을 이용하면 테이블의 이름이나 다른 개체를 변경해도 프로그램을 고칠 필요가 없다.

// ex) emp 테이블인데 synonym 을 만들어서 e 라고 붙여놓고 프로그램에서는 e 라는 이름을 사용한다.
//     emp 테이블의 이름을 변경하더라도 synonym 만 새로 만들면 프로그램 에서는 수정을 하지 않아도 된다.

// **procedure
// 자주 사용하는 SQL 문장을 하나의 이름으로 만들어 두고 사용하는 개체
// 관계형 데이터베이스 마다 만드는 방법이 다름
// 오라클에서 프로시저를 만드는 문법을 PL/SQL 이라고 하고 MSSQLServer 에서 만드는 문법을 T-SQL 이라고 한다.
// 프로시저를 만들어서 사용하면 서버의 메모리에 프로시저가 상주하기 때문에 매 번 SQL 문장을 실행하는 것보다 트래픽을 줄일 수 있다.

// 1. 프로시저 생성
//    create [or replace] procedure 프로시저 이름
//    (매개변수이름 용도 자료형....)
//    is
//    사용자 정의 변수
//    begin
//    수행할 내용
//    end;
//    /

// 2. 프로시저 실행
//    excute 프로시저이름(매개변수 나열);

// 3. 프로시저 삭제
//    drop procedure 프로시저이름;

// ex) 매개변수가 없는 프로시저 만들기
//     dept 테이블의 모든 데이터를 삭제하는 프로시저 만들기
//     create or replace procedure deldept
//     is
//     begin
//       delete from dept;
//     end;
//     

// ex2) dept 테이블에 데이터를 삽입하는 프로시저
//      dept - deptno(숫자), dname(문자열), loc(문자열)
//      create or replace procedure insertdept
//      (
//      vdeptno dept.deptno%type,
//      vdname dept.dname%type,
//      vloc dept.loc%type
//      )
//      is
//      begin
//       insert into dept(deptno, dname, loc)
//       values(vdeptno, vdname, vloc);
//      end;
//      /

//      실행
//      execute insertdept(50, '곤충', '노원');

//      확인
//      select *
//      from dept;

// ex3) deptno 를 입력받아서 dept 테이블에서 deptno 에 해당하는 데이터를 삭제하는 프로시저 만들기
//      create or replace procedure deldept
//      (vdeptno dept.deptno%type)
//      is
//      begin
//      delete from dept
//      where deptno = vdeptno;
//      end;
//      /

// **Trigger
// DML 문장 수행 전이나 수행 후에 자동으로 수행되어야 하는 내용을 작성할 수 있는 개체
// 수행 전에 하는 내용은 일반적으로 유효성 검사인데 유효성 검사를 통과한 경우에만 작업을 수행하도록 한다.
// 수행 후에 하는 내용은 하나의 테이블에 데이터가 삽입되면 연쇄적으로 삽입되어야 하는 다른 데이터를 삽입하거나 삭제할 때 다른 테이블의
// 데이터를 연쇄적으로 삭제하거나 다른 테이블에 데이터를 삽입하는 용도등으로 사용된다.
// sqlite3 같은 데이터베이스는 외래키 설정을 가능하나 외래키 옵션이 제대로 동작하지 않는 문제가 삭제 이상을 유발하는 경우가 있는데
// 이 경우는 트리거를 이용해서 해결한다.

// 1. 생성
//    CREATE TRIGGER 트리거이름
//    timing[DML 동작 전이면 BEFORE| DML 동작 후라면 AFTER] event[INSERT|UPDATE|DELETE]
//    ON 테이블이름
//    [FOR EACH ROW] // 여러 행에 동작이 발생했을 때 행마다 동작하려면 for each row
//    [WHEN conditions] // 기타 조건
//    BEGIN 
//    statement // 수행할 SQL 문장
//    END

// 2. 삭제
//    drop trigger 트리거이름;

// ex) 자기 계정에서 emp, dept, salgrade 테이블을 제외하고 모두 삭제
//     drop table 이름;
//     회원 테이블에 데이터를 추가하면 게시판 테이블에 데이터 1개를 자동 추가하는 트리거를 만들어서 사용하기
// 1. 회원
//    id - 문자 30자 기본키
//    pw - 문자 20자 필수
//    name - 문자 한글 10자까지 필수
//    nickname - 문자 한글 10자까지 유일
//    address - 문자 한글 100자까지

// 2. 게시판
//    boardnum(글번호) - 정수 10자리 기본키
//    boardtitle(글 제목) - 한글 100자 까지 기본값은 무제
//    boardcontent(글 내용) - 한글 2000자 까지 기본값은 냉무
//    boarddate(작성일) - 날짜 기본값은 sysdate
//    nickname - 회원 테이블의 nickname 을 참조하는 외래키로 회원 테이블에서 삭제될 때 null 이 되도록 설정

// create table member(
//  id varchar2(30) primary key,
//  pw varchar2(20) not null,
//  name varchar2(30) not null,
//  nickname varchar2(30) unique,
//  address varchar2(300));

// create table board(
//  boardnum number(10) primary key,
//  boardtitle varchar2(300) default '무제',
//  boardcontent clob default '냉무',
//  board date default sysdate,
//  nickname varchar2(30) references member(nickname) on delete set null);

// # board 테이블의 boardnum 을 자동으로 일련번호 형태로 만들어주기 위한 sequence 생성
// create sequence 시퀀스이름
// start with 시작번호;

// create sequence boardseq
// start with 1;

// -- 트리거 생성 (멤버 테이블에 데이터가 추가될 때 board 테이블에 데이터를 추가
// boardnum 은 시퀀스 번호로
// boardtitle 은 가입인사로
// boardcontent  는 안녕하세요 로
// nickname 은 가입한 사람의 nickname 으로 데이터를 추가하는 트리거
// CREATE OR REPLACE trigger newboard
// AFTER INSERT ON member
// FOR EACH ROW -- 여러 행에 동작이 발생했을 때 행마다 동작하려면 for each row
// BEGIN 
// insert into board(boardnum, boardtitle, boardcontent, nickname)
// values(boardseq.nextval, '가입인사', '안녕하세요', :NEW.nickname); 
// END;
// /

// insert into member(id, pw, name, nickname) values('nije', '123123', '관리자', 'nijegod');

// **JDBC
// Java 에서 데이터베이스를 사용하는 방법
// JDBC 프로그래밍을 하기 위해서는 데이터베이스와 통신할 수 있도록 해주는 드라이버 파일을 설치해야 한다.
// 데이터베이스 종류마다 다르다.
// Java Application 일 때는 build path 에 추가하면 되고 Java Web Application 일 때는 WEB-INF 디렉토리의
// lib 이라는 디렉토리에 포함시켜 주어야 한다.
// Oracle 의 경우는 ojdbc 라는 파일이다.
// 오라클이 설치되어 있는 경우에는 오라클 디렉토리에서 찾아서 사용할 수 있고 없으면 오라클 홈페이지에서 다운로드 받아서 사용 가능
// # http://www.mvnrepository.com/ (자바 오픈 소스 라이브러리 검색 사이트)에서 검색하여 다운로드 받을 수 있다.

// # 데이터베이스 연동시 기억해야 할 것
// 1. 데이터베이스 종류
// 2. 위치(ip주소 / localhost)와 포트번호와 이름(학원은 xe) - URL // 학원에서는 오라클은 1521번
// 3. 계정(account) - scott
// 4. 비밀번호 - tiger

// # DB 연동시 필요한 클래스
// 1. Connection(연결)
// 2. Statement(SQL 실행)
// 3. ResultSet(select 결과 저장)
// 1~3 순서대로 진행

// **데이터베이스 연결
// 1. 프로젝트에 드라이버 파일을 복사하고 build path 에 추가한다.
// 2. 소스코드에서 데이터베이스 드라이버 파일을 로드한다.
//    Class.forName("데이터베이스 드라이버 이름");
//    오라클의 경우 Oracle.jdbc.driver.OracleDriver
// 3. 데이터베이스와의 연결을 위한 Connection 객체를 생성
//    Connection 변수명 = DriverManager.getConnection("url", "account", "passward")|
//    오라클 url 작성 방법: jdbc:oracle:thin:@컴퓨터주소:포트번호:데이터베이스이름
//    ex) jdbc:oracle:thin:@localhost:1521:xe 192.168.0.100

// # 데이터베이스 연결 실패시 예외 내용
// 1. 드라이버 파일을 buildpath 에 추가하지 않았거나 드라이버 클래스 이름을 틀린 경우
//    -> 드라이버 클래스 이름이 출력
// 2. url 이 잘못 입력된 경우
//    -> IO 오류: The Network Adapter could not establish the connection
// 3. 계정이나 비밀번호가 잘못 된 경우
//    -> ORA-01017: invalid username/password; logon denied

package Oracle;

public class 필기0731 {

}
