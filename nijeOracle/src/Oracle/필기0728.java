// 트랜잭션(Transaction)
// 데이터베이스에서 한 번에 이루어져야 하는 논리적인 작업 단위
// 물건을 사고파는 거래라면 어느 한쪽에서는 물건이 없어지고 금액이 변경되어야 하고 다른 한 쪽에서는 물건이 추가되고 금액이 변경되어야 한다.
// 이 작업들은 반드시 한 번에 이루어져야 한다.
// 이렇게 sql은 여러 개 이지만 한번에 이루어져야 하는 작업을 트랜잭션 이라고 한다.
// 트랜잭션의 ACID 성질 참고.

// 트랜잭션 명령어
// 1. commit : 현재까지의 작업 내용을 원본 데이터베이스에 반영
// 2. savepoint : rollback 할 수 있는 위치를 만드는 명령어
// 3. rollback[to savepoint 이름] : 이름을 생략하면 트랜잭션의 시작 지점으로 이동
//                                 이름을 설정하면 이름이 있는 위치로 이동
// 트랜잭션의 시작
// commit 이나 rollback 을 수행한 후 첫 번쨰 DML(insert, delete, update) 문장을 수행하면 트랜잭션은 생성된다.
// commit 되는 경우
// 1. commit 명령을 사용한 경우
// 2. DDL(create, alter, drop). DCL(grant, revoke) 을 성공적으로 수행한 경우
// 3. 접속 프로그램을 정상적으로 종료한 경우

// rollback 되는 경우
// 1. rollback 명령을 수행한 경우
// 2. 접속 프로그램이 비 정상적으로 종료된 경우

// 연습)
// ex) dept 테이블의 모든 데이터를 복사해서 nije 라는 테이블을 생성
//     create table nije
//     as
//     select * from dept;

// ex2) 테이블 복사 된 것을 확인
//      구조 확인 : desc nije;
//      데이터 확인 : select * from nije;
//      데이터 삽입 (이 부분에서 트랜잭션 생성)
//      insert into nije(deptno, dname, loc)
//      values('29', '인간', '노원구');

// ex3) nije 테이블에서 deptno 가 10번인 데이터를 dname 은 동물 loc 는 서울로 변경
//      update nije
//      set dname = '동물', loc = '서울'
//      where deptno = 10;

// ex4) 작업을 데이터베이스에 반영
//      commit;

// ex5) park 테이블에서 deptno 가 30번인 데이터를 삭제
//      delete from nije
//      where deptno = 30;

// ex6) 되돌리기 (10번 데이터는 수정이 되어 있고  30번 데이터는 다시 포함된 상태)
//      rollback;

// ex7) nije 테이블에서 deptno 가 20번인 데이터를 삭제
//      delete from nije
//      where deptno = 20;


// ex8) s1 이라는 savapoint 설정
//      savepoint s1;

// ex9) nije 테이블에서 deptno 가 30번인 데이터의 loc 를 팔달산 으로 변경
//      update nije
//      set loc = '팔달산'
//      where deptno = 30;

// ex10) s2 라는 savepoint 설정
//       savepoint s2;

// ex11) s1 라는 savapoint 로 rollback
//       rollback to s1;

// 중간확인 - 30번은 원래대서 시카고 이어야 하고 20번은 삭제가 되어야 한다.

// ex12) commit
//       commit;

// ex13) s2 라는 savepoint 로 rollback?
//       rollback to s2; -- s1 지점으로 이동하게 되면 s2 라는 savepoint 를 만드는 명령도 취소된 것이므로 
//       s2로 rollback 할 수 없다.

// ex14) -- ex14) commit
//          commit;

// ex15) rollback to s1; -- 앞에서 커밋을 수행했기 때문에 지금까지의 모든 작업이 데이터베이스에 반영되고 savepoint 는 소멸된다.
//                       -- 즉 s1이라는 savepoint 가 소멸되었기 때문에 에러 발생

// **제약조건(Constraint)
// 데이터베이스의 무결성(Integrity) 을 유지하기 위해서 지켜야 하는 조건
// 무결성은 데이터베이스의 결함을 없애기 위한 성질을 의미한다.
// 이론에서는 무결성 제약조건 이라고 일컫는 경우가 많다.
// primary key, not null, unique, check, foreign key 가 있다.
// 데이터베이스 에서는 제약조건은 아니지만 default 도 동일한 방법으로 사용할 수 있도록 되어 있다.

// not null : null 일 수 없다는 제약조건
//            데이터베이스는 null 을 표시할 때 별도의 바이트를 할당하여 표시하는 방법을 사용

// unique : 유일해야 한다는 제약조건
//          unique 를 이용하게 되면 인덱스(데이터를 빠르게 찾기 위한 포인터) 생성이 된다.

// check : 값의 범위에 제한을 두는 것

// Foreign (외래키, 참조키)
// 2개 테이블의 일관성을 유지하기 위해 생성
// 다른 테이블 에서 primary 인 속성
// 부모 테이블 에서는 unique 이거나 primacy key 인 경우만 생성

// 1. 제약조건 설정
//    컬럼단위 제약조건 과 테이블단위 제약조건 으로 나뉜다.
//    컬럼을 만들 때 제약조건을 설정할 수 있고 컬럼을 전부 만든 후에 제약조건을 설정할 수도 있다.

// ex) 제약조건 위반 확인
//     dept 테이블에 deptno 가 10이고 dname 은 회계 loc 는 부산인 데이터 삽입

// 2. 제약조건 확인
//    desc user_constraints;

// ex2) 제약조건 이름과 종류 및 테이블 이름 확인
//      select constraint_name, constraint_type, table_name
//      from user_constraints;

// 3. 제약조건 종류에 따른 분류
//    P : Primary key
//    R : Foreign key
//    U : Unique
//    C : Check, Not Null

// 4. Not Null
//    필수 입력 설정을 위한 제약조건
//    컬럼 단위에서만 설정이 가능
//    Not Null 은 별도의 바이트를 추가해서 만들어야 하기 때문에 컬럼을 만들 때 생성해야 한다.

// 5. unique
//    동일한 데이터가 없어야 한다는 제약조건


// 6. 제약조건이름
//    제약조건만 입력해서 만들면 오라클이 자동으로 제약조건이름을 만들어 준다.
//    제약조건이름을 모르면 제약조건을 지울 수 없기 때문에 불편하다.
//    제약조건이름을 만들고자 할 때는 제약조건 설정 앞에 contraint 제약조건이름 을 기재하면 된다.

// ex) 회원 테이블(Member)
//     id 영문자 20자리 유일해야 한다.
//     pw 영문자 20자리 Not Null 로 설정

//     drop table member;
//     create table memeber(
//     id char(20) unique,
//     pw char(20) constraint memeberNN not null);

// Primary key(기본키, 주키)
// 테이블 내에서 해을 구분하기 위한 유일한 식별자
// 하나의 테이블에 하나만 설정 가능
// 하나의 컬럼으로만들어도 되고 2개 이상의 컬럼으로 만들어도 된다.
// not null 이고 unique

// ex) member 테이블
//     id : 영문 30자 변경 불가능, 기본 키
//     pw : 영문 20자 변경 가능
//     name : 한글 이름 10자 이내, 필수 입력
//     nickname : 한글 10자 이내, 유일해야 한다.

// 8. Foreign key
//    다른 테이블의 데이터와의 일관성을 유지하기 위해서 설정하는 제약조건
//    테이블 사이의 대응수(cardinality) 를 보고 설정한다.
//    1:1 관계 : 양 쪽의 기본키를 다른 테이블의 외래키로 추가해 주면 된다.
//    1:N 관계 : 한 쪽의 기본키를 다른 테이블의 외래키로 추가해 주면 된다.
//    N:N 관계 : 양 쪽의 기본키를 가지고 새로운 테이블을 만들어서 외래키로 설정하면 된다.

// # 설정할 때
// constraint 제약조건이름 references 상대방테이블이름(컬럼이름) [on delete cascade | on delete set null |
// on update cascade]
// on delete cascade 옵션을 사용하면 참조 당하는 쪽에서 데이터가 지워지면 외래키를 가진 테이블 에서도 데이터가 삭제된다.
// on delete set null 옵션을 사용하면 참조당하는 쪽에서 데이터가 지워지면 외래키를 가진 테이블에서는 외래키의 값이 null 로 변경된다.

// ex) member 테이블의 id 를 참조하는 board 테이블 생성
//     boardnum : 정수 5자리, 기본키
//     boardtitle : 문자열 100자
//     boardcontent : 문자열 2000자
//     id - varchar(30) : member 테이블의 id 를 참조하는 외래키

// # 참조 무결성
//   외래키는 null 이거나 상대방 테이블에 있는 값 만을 가져야 한다.

// ex) 아래 데이터 삽입
//     insert board(boardnum, boardtitle, boardcontent)
//     values(2, '게시글제목2', '게시글내용2');
//     외래키는 null 일 수 있기 때문에 생략하고 삽입이 가능

// ex) 아래 데이터 삽입
//     insert board(boardnum, boardtitle, boardcontent, id)
//     values(3, '게시글제목3', '게시글내용3', 'nije3');
//     외래키는 상대방 테이블에 없는 데이터는 삽입할 수 없어서 에러 발생

// # 외래키를 옵션 없이 생성하면 참조 당하는 테이블의 데이터 중에서 외래키를 가진 테이블이 사용하고 있는 데이터는 삭제할 수 없다.

// ex) select * from member;
//     nije1 과 nije2 라는 아이디가 존재

// ex) select * from board;
//     nije 1을 사용 중

// # 외래 키를 옵션 없이 생성했기 때문에 member 테이블에서 nije2 는 삭제할 수 있지만 nije1 은 삭제할 수 없다.

// ex) delete from member where id ='nije2';
//     delete from member where id ='nije1';
//     drop table member; -- member 테이블은 board 테이블에 의해서 참조되기 때문에 삭제할 수 없어 에러가 발생한다.
//     drop table board; -- board 테이블 부터 지운 후에야 member 테이블이 삭제된다.

// ex) 회원 테이블
//     id : 문자열 30자, 기본키
//     pw : 문자열 20자, 필수
//     name : 문자열 10자, 필수

//     create table member(
//     id varchar2(30) primary key,
//     pw varchar2(20) not null,
//     name varchar(30) not null);

//     게시판 테이블
//     boardnum : 정수 6자리, 기본키
//     boardtitle : 한글 포함 문자열 100자 이내
//     boardcontent : 한글 2000자 까지
//     boarddate : 날짜 형식
//     id - 회원 테이블의 id 를 참조 : 회원 테이블에서 삭제되면 같이 삭제되도록 옵션을 설정

// ex) member 테이블에 데이터 1개 추가
//     insert into member(id, pw, name)
//     values('nije','123123','root');

// ex) board 테이블에 데이터 2개 추가
//     insert into board(boardname, boardtitle, boardcontent, boarddate, id)
//     values(1, '가입인사', '자료먹튀하고탈퇴ㅅㄱ링ㅋ', sysdate, 'nije1);

//     insert into board(boardname, boardtitle, boardcontent, boarddate, id)
//     values(2, '날짜 입력', '날짜를 입력하는 방법입니다', to_date('2018-07-29', 'yyyy-mm-dd', 'nije1);

// # 외래키를 생성할 때 삭제 옵션이 없어서 board 테이블에서 사용 중인 member 테이블의 데이터는 삭제할 수 없었다.
//   삭제 옵션을 가지고 만들었으므로 사용 중인 데이터도 삭제가 가능하다.

// # member 테이블에서 id 가 nije1 인 데이터를 삭제하고 board 테이블을 확인
//   delete from member
//   where id = 'nije1';

//   select *
//   from nije;

// 9. check 제약조건
//    입력되는 데이터의 값을 제한하기 위해서 사용하는 제약조건
//    컬럼이름 자료형 constraint 제약조건이름 check(컬럼이름 조건)
//    제약조건이름은 생략 가능

// 10. default
//     기본값을 설정하기 위한 것으로 제약조건은 아니다.

// 11. 테이블 레벨 제약조건
//     제약조건을 모든 컬럼을 생성하고 난 후에 설정하는 것
//     not null 은 테이블 레벨에서 설정이 불가능하다.
//     primary key, foreign key, unique, check 제약조건만 설정 가능
//     하나의 컬럼에 여러 개의 제약조건을 설정해야 하거나 기본키가 2개 이상의 컬럼으로 구성되어야 하는 경우 사용

// ex) constraint 제약조건이름 제약조건을 입력한다
//     컬럼 1이 기본키로 설정되어야 한다면
//     constraint 이름 primary key(컬럼1, 컬럼2)

// ex) 학생 테이블
//     학번 : 문자열 10자리, 기본키
//     이름 : 문자열 5자리
//     나이 : 숫자 2자리, 10~49 사이의 값만 갖도록 설정, 기본값은 1
//     점수 : 숫자 3자리, 기본값은 0

// 12. 제약조건 추가하기
//     primary key, check, unique
//     alter table 테이블이름
//     add constraint 제약조건이름 제약조건유형(컬럼이름)

// 12-2. 외래키
//       alter table 테이블이름
//       add constraint 제약조건이름 foreign key(컬럼이름) references 상대방테이블(컬럼이름)
//       옵션

// 12-3. not null (생성이 아닌 변경의 개념)
//       alter table 테이블이름
//       modify constraint 제약조건이름 컬럼이름 not null 또는 null

// 13. 제약조건 삭제하기
//     alter table 테이블이름
//     drop constraint 제약조건이름;

// 14. 제약조건 활성화 비활성화
//     테스트를 위해 샘플 데이터를 삽입하기 위해서 일시적으로 제약조건을 비 활성화하는 경우가 있다
//     alter table 테이블이름
//     [disable | enble] constraint 제약조건이름;

// **view
// 가상의 테이블
// 자주 사용하는 select 구문을 하나의 이름으로 만들어 두었다가 메모리에 적재한 뒤에 사용하는 것
// view 는 create 와 drop 은 되지만 alter 는 사용할 수 없다.
// 실제 테이블이 아니기 때문에 구조 변경이 되지 않는다.
// 일반 테이블과 거의 유사하게 사용할 수 있다.

// 1. 생성
// CREATE [OR REPLACE][FORCE | NOFORCE]VIEW 뷰이름
// AS
// select 구문
// [WITH CHECK OPTION]
// [WITH READ ONLY];
// or replace 는 존재하는 경우 덮어쓰는 옵션
// force 와 noforce 는 select 구문에 사용한 테이블이 존재하지 않는 경우에도 만들 수 있도록 해주는 옵션
// with check option 은 select 구문에 where 절이 있는 경우 조건에 맞는 데이터만 수정 하거나 삭제할 수 있도록 해 주는 옵션
// with read only 는 읽기 전용 뷰를 만들어 주는 옵션이다.
// 이렇게 만들어진 뷰이름은 마치 하나의 테이블 처럼 사용된다.
// 읽기 전용 옵션이 없다면 삽입, 삭제, 갱신이 가능하다.

// 2. 삭제
// drop view 뷰이름
// # scott 에게 뷰 생성 권한이 없으므로 뷰를 만들 수 있는 권한을 부여
//   grant create view, drop any view
//   to scott;

// ex) dept 테이블의 모든 데이터를 이용해서 view 를 생성
//     뷰 이름은 deptview 라고 설정

// 3. sql 에 deptview 라는 뷰를 테이블 처럼 사용할 수 있다.
//    select *
//    from deptview;

// 4. deptview 에 데이터를 추가
//    insert into deptview(deptno, dname, loc)
//    values(50, '기술개발', '분당');

// 5. view 를 만들 때 with read only 옵션을 추가해서 만들면 읽기 전용이 된다.
//    rollback; 을 수행

// ex) dept 테이블의 모든 데이터를 이용해서 읽기 전용의 뷰를 생성
//     이름은 readdept
//     create or replace view readdept
//     as
//     from dept
//     whit read only;

// # with check option 을 이용한 view 생성
// create or replace view checkdept
// as
// select *
// from dept
// where deptno = 30
// with check option;
// deptno 가 30 인 데이터만 삽입, 삭제, 갱신이 가능하다.

// update checkdept -- deptno 가 30인 데이터만 삽입, 삭제, 갱신이 가능하다. 조건에 맞는 데이터라서 수정이 된다.
// set dname = '동무'
// where deptno = 30;

// update checkdept -- 에러는 아니지만 조건에 맞지 않는 데이터이기 때문에 수정을 하지 않는다.
// set dname = '수령'
// where deptno = 40;


package Oracle;

public class 필기0728 {

}
