// **연산자
// 단일 비교 연산자 (하나의 값과 비교)
// >, >=, <, <=, =, !=

// 다중 비교 연산자 (여러 개의 값과 비교)
// in

// **Sub Query
// 하나의 SQL 절 안에 포함된 SQL
// 감싸고 있는 외부의 쿼리를 Main Query, 안에 있는 쿼리를 Sub Query 라고 한다.
// Sub Query 를 작성할 때는 반드시 괄호로 감싸야 한다.
// Sub Query 는 Main Query 보다 항상 먼저 수행된다.
// select 구문일 때는 from 절과 where 절 및 having 절에 사용할 수 있다.
// from 절에 사용하는 경우는 오라클에서는 inline view 라고 한다.
// sub query 를 사용하는 이유는 근본적으로 속도 때문이다.
// 반드시 join 이 필요한 경우가 아니라면 sub query 를 사용하는 것이 효율적이다.


// **서브 쿼리 종류
// 1. 단일행 서브쿼리
//    서브 쿼리의 결과가 하나의 행인 경우
//    서브 쿼리의 결과가 하나의 행으로 리턴되는 경우
//    단일 행 연산자를 이용해서 수행 가능

// 2. 다중행 서브쿼리
//    서브 쿼리의 결과가 2개 이상의 행인 경우

// # 정렬은 order by - 데이터베이스는 데이터를 저장할 때 순서라는 개념이 없다. 2개 이상의 데이터를 조회하는 경우에는 order by 를
//                   사용하는 것이 좋다.

// ex) ename 이 MILLER 인 사원의 dname 과 loc 를 조회
//     ename 은 emp 테이블에, dname 과 loc 는 dept 테이블에 존재
//     2개의 테이블을 사용해야 하는 경우는 공통된 의미를 갖는 컬럼을 확인
//     원래는 외래키 설정을 확인하면 된다.
//     deptno 컬럼이 양쪽 테이블에 존재한다,
//     이런 경우 join 을 이용해서 해결 가능하다.

//     select dname, loc
//     from emp, dept
//     where emp.deptno = dept.deptno and ename = 'MILLER';

//     select 절 에서 조회하고자 하는 컬럼들이 하나의 테이블에서 호출 가능하다면 이 때는 sub query 를 이용해서 해결이 가능하다.
//     sub query 를 이용하면 join 을 하지 않아도 되기 때문에 메모리나 시간이 절약될 수 잇다.
//     join 은 2개의 테이블을 합쳐야 하기 때문에 메모리 부담이 크다.
//     양쪽 테이블에 같이 존재하는 컬럼을 확인

//     
//     select dname, loc
//     from dept
//     where deptno = (select  deptno
//                     from emo
//                     where ename = 'MILLER')

// ex) EMP 테이블에서 ename 이 MILLER 인 데이터와 같은 부서(deptno) 에서 근무하는 사원의 이름(ename)과 부서 번호(deptno)
//     를 출력하는 SQL
//     select ename, deptno
//     from emp
//     where deptno = (select  deptno
//                     from emp
//                     where ename = 'MILLER') and ename != 'MILLER'; -- 단일 행 연산자를 이용해 결과에서 밀러를 축출

// ex2) EMP 테이블에서 ename 이 MILLER 인 데이터와 동일한 직급(job) 을 가진 사원의 모든 컬럼 을 출력하는 SQL
//      select *
//      from emp
//      where job = (select job -- 동일한 테이블이 job 이므로 where 다음에 써 준다
//                   from emp
//                   where ename = 'MILLER') and ename != 'MILLER';

// ex3) EMP 테이블에서 ename이 MILLER인 데이터의 급여(SAL)와 동일하거나 더 많이 받는 사원명(ename)과 급여(sal)를 출력하시오.
//      select ename, sal
//      from emp
//      where sal > = (select  sal
//                     from emp
//                     where ename = 'MILLER') and ename != 'MILLER';

// ex4) EMP 테이블에서 DEPT 테이블의 LOC가 DALLAS인 사원의 이름(ename), 부서 번호(deptno)를 조회 하시오.
//      select ename, deptno
//      from emp
//      where deptno =  (select  deptno
//                       from dept
//                       where loc = 'DALLAS');

// ex5) EMP 테이블에서 DEPT 테이블의 dname이 SALES(영업부)인 부서에서 근무하는 사원의 이름(ename)과 급여(sal)를 출력하시오.
//      select ename, sal
//      from emp
//      where deptno = (select deptno
//                      from dept
//                      where dname = 'SALES');

// ex6) EMP 테이블에서 직속상관(mgr)의 이름이 KING인 사원의 이름(ename)과 급여(sal)를 출력하시오.
//      KING 을 관리자로 하는 사원을 찾고자 하면 KING 의 사원번호가 mgr 인 사원을 조회 하면 된다.
//      select ename, sal
//      from emp
//      where mgr = (select empno
//                   from emp
//                   where ename = 'KING');

// **다중 행 서브쿼리
// 1. 오류 발생
//    
// ex) emp 테이블에서 sal 이 3000인 사원과 동일한 부서(deptno) 에 근무하는 사원의 ename 과 deptno 를 조회
//     select ename, deptno
//     from emp
//     where deptno = (select deptno
//                     from emp
//                     where sal >= 3000);
//    에러가 생기는 이유는 서버쿼리 반환 결과가 1개 보다 많이 리턴되었기 때문이다.
//    >= 은 단일 행 연산자이기 때문에 값이 2개 이상이면 비교할 수 없다.
//    2개 이상이 리턴되면 = 로는 비교할 수 없다.

// ex2) emp 테이블에서 부서별로 가장 급여를 많이 받는 사원들과 동일한 급여를 받는 사원 번호(empno), 사원이름(ename), 
//      급여(sal), 부서번호(deptno)를 출력하시오.(IN 연산자 이용)
//      select max(sal) -- 부서별로 가장 큰 급여를 조회
//      from emp
//      group by deptno;

//      select empno, ename, sal, deptno
//      from emp
//      where sal in (select max(sal)
//                    from emp
//                    group by deptno);

// ex3) emp 테이블에서 직급(JOB)이 MANAGER인 사람이 속한 부서의 부서 번호(deptno)와 부서명(dname)과 지역(loc)을 출력하시오.
//      select deptno, dname, loc
//      from dept
//      where deptno in (select deptno
//                       from emp
//                       where job = 'MANAGER');

// ex4) deptno 가 30인 부서의 사원들 전체보다 sal 이 많은 사원의 ename 과 sal 을 조회

// 2. 다중 행 연산자
// 2-1. in : 요소 중에 일치하는 것이 최소 1개라도 있으면 조회 ( = 나 != 를 이용)
// 2-2. any : 요소 중에 조건을 만족하는 것이 최소 1개라도 있으면 조회 ( >, >=, <, <= 이용) (최소값과 비교해도 된다)
// 2-3. all : 요소 모두가 조건을 만족해야만 조회 (최대값과 비교해도 된다)

// 연습문제
// 1. EMP 테이블에서 ename이 BLAKE 인 데이터와 같은 부서(deptno)에 있는 모든 사원의 이름(ename)과 
//    입사일자(hiredate)를 출력하는 SELECT문을 작성하시오.
//    select ename, hiredate
//    from emp
//    where deptno =  (select deptno
//                     from emp
//                     where ename = 'BLAKE');

// 2. EMP 테이블에서 평균 급여(sal) 이상을 받는 모든 종업원에 대해서 종업원 번호(empno)와 이름(ename)을 출력하는 
//    SELECT문을 작성하시오. 단 급여가 많은 순으로 출력하여라.
//    select empno, ename
//    from emp
//    where sal > (select avg(sal)
//                 from emp)
//                 order by sal desc;



// **DDL(Data Definition Language) (데이터 정의 언어)

// 1. Create
//    구조 생성
// 2. Alter
//    구조 변경
// 3. Drop
//    구조 삭제
// ---------- 이곳 까지는 표준 ------------
// 4. Truncate
//    테이블의 모든 데이터 삭제 (구조는 남겨 놓는다)
// 5. Rename
//    이름 변경

// 1~5번은 수행하면 철회가 불가능하다.
// 즉 백업을 항상 하는 습관을 가져야 한다.


//**DDL
// 구조를 만들고 변경하고 삭제하는 SQL
// 성공하면 철회를 할 수 없다.

// 1. 테이블 생성
//    create table 테이블이름(
//    컬럼이름 자료형 제약조건,
//    컬럼이름 자료형 제약조검,....
//    테이블 제약조건)

// 2. 자료형
//    char(사이즈) : 사이즈까지의 문자열을 고정으로 저장하는 자료형
//    varchar2(사이즈) : 사이즈까지의 문자열을 가변으로 저장하는 자료형
//    한글은 일반적으로 2개의 1개의 문자로 간주하지만 사용하는 접속 도구에 따라서 3개를 1문자로 간주하는 경우도 있다.
//    SQL Developer 에서는 3개를 1개의 한글문자로 간주한다.
//    char(10) 으로 설정한 경우 3개의 문자만 저장하면 항상 10byte 를 할당받아서 나머지는 공백으로 채워 놓는다.
//    varchar(10) 으로 설저앟고 3개의 문자를 저장하면 10byte 를 할당 받았다가 3개의 저장공간을 제외한 공간은 없애 버린다.
//    메모리 효율 면에서는 varchar2 가 좋지만 varchar2 는 수정이 발생하는 경우 잘못하면 많은 양의 데이터가 이주해야 하는 상황이
//    벌어질 수 있다. 이렇게 많은 양의 데이터가 이동하는 것을 row migration(행 이주) 라고 한다.
//    number(전체자릿수,소수자릿수) : 숫자를 저장하고자 하는 경우 사용
//                              자릿수를 생략하면 38자리로 생성된다.
//                              정수를 입력하고자 하는 경우는 소수자릿수를 생략하면 된다.
//    Date : 날짜와 시간을 저장하는데 1/1000초 까지 저장 가능.
//    timestamp : 날짜와 시간을 1/1000000초 까지 저장 가능.
//    CLOB : 긴 문자열을 저장할 때 사용
//           1000자 이상의 문자를 저장할 때 사용
//           이 자료형을 사용하면 인덱스(빠르게 검색하기 위해서 설정하는 것) 생성이 불가능하다.
//    BLOB : 큰 바이트를 저장할 때 사용
//           파일의 내용을 저장하고자 할 때 사용
//           머신러닝 분야 등에서 이미지의 내용을 저장하고자 할 때 사용

// ex) 회원정보를 저장하는 테이블
//     컬럼       자료형        특징
//     이메일    문자 50자   변할가능성 없음
//     비밀번호 문자 20자   변할가능성 다수
//     이름       문자 30자   변할가능성 없음
//     별명       문자 30자   변할가능성 없음
//     전번       문자 11자   변할가능서이 존재
//     주소       문자200자  변할가능성 존재
//     생일       날짜       
//     키          실수
//     몸무게    실수
//     IQ    정수

//     create table member(
//     email varchar2(50),
//     password char(200,
//     name varchar2(30),
//     nickname varchar2(30),
//     phone varchar2(11),
//     address char(200),
//     birthday date
//     height number(5,1)
//     weight number(4,1)
//     iq rating(3)
//     species varchar2(50));

// 3. 기존 테이블의 검색결과를 가지고 테이블을 생성
//    create table 테이블이름
//    as
//    select 구문

// ex) dept 테이블의 모든 데이터를 가지고 있는 deptcopy 테이블을 생성
//     create table deptcopy
//     as
//     select *
//     from dept;

// ex2) dept 테이블의 구조만 복사해서 depttemp 테이블을 생성
//      데이터는 복사하지 않는다.

// 4. alter table
//    테이블의 구조를 변경하는 명령어
//    컬럼을 추가하거나 삭제 그리고 변경을 하는 명령어
//    alter table 명령은 모든 관계형 데이터베이스에 존재하지만 실제 사용하는 방식은 조금씩 다르다.
// 4-1. 컬럼 추가
//      alter table 테이블이름
//      add(컬럼이름 자료형 제약조건);
// 4-2. 컬럼 수정
//      기존 데이터가 있는 경우 주의해야 한다.
//      자료형이 변경되는 경우 기존 데이터가 삭제될 수 있다.
//      alter table 테이블이름
//      modify(컬럼이름 자료형 제약조건)
// 4-3. 컬럼 삭제
//      alter table 테이블이름
//      drop column 컬럼이름;
// 4-4. 컬럼의 사용을 못하도록 하기
//      alter table 테이블이름
//      set unused(컬럼이름)
//      실제 삭제시에는
//      alter table 테이블이름
//      drop unused columns;
//      데이터가 많은 경우에 컬럼을 삭제하게 되면 시간이 오래 걸린다.
//      컬럼을 삭제하게 되면 데이터가 삭제되기 떄문에 락이 걸려서 다른 곳에서 접근을 못한다.
//      사용만 금지 시켜 놓고 사용을 하지 않는 시간에 실제 삭제를 수행한다.

// ex) deptcopy 테이블에 한글 5자까지 저장할 수 있는 location 이라는 컬럼을 추가
//     접속 도구에 따라 한글을 2 또는 3byte 로 저장하기 때문에 되도록이면 글자수 * 3을 하는 것이 좋다.
//     alter table deptcopy
//     add(location char(15));

//     desc depycopy;
//     insert into deptcopy value

// ex2) location 컬럼의 크기를 한글 10자를 저장할 수 있도록 변경
//      alter table deptcopy
//      modify(location char(30);

// ex3) location 컬럼 삭제
//      alter table deptcopy
//      drop column location;

// 5. 테이블 삭제
//    drop table 테이블이름;
//    외래키로 설정된 컬럼이 있으면 테이블 삭제는 불가능하다.

// ex) deptcopy 테이블 삭제
//     drop table deptcopy;

// ex2) dept 테이블 삭제
//      emp 테이블에 외래키가 설정되어 있기 때문에 테이블은 삭제되지 않는다.
//      삭제하고자 하는 경우에는 외래키 설정을 해제하던지 외래키를 가지는 테이블을 먼저 삭제 해야 한다.
//      drop table dept;

// 6. 테이블의 모든 데이터 삭제
//    truncate table 테이블이름;
//    테이블 구조는 남겨두고 데이터만 모두 삭제
//    데이터가 전부 삭제되지 않는 경우가 발생할 수 있는데 외래키로 설정되어 있는 경우이다.

// 7. 테이블 이름 변경
//    rename 예전이름 to 원본이름;


// **DML(Data Manipulation Language)
// 테이블에 데이터를 삽입하고 삭제하고 갱신하는 명령어
// 이 명령어는 실행에 성공한다 해서 테이블에 바로 반영되지는 않는다.
// 트랜잭션 관련 명령이 수행되어야만 반영이 되거나 철회가 된다.

// 1. 데이터 삽입
// 1-1. 데이터를 직접 입력해서 삽입
//      insert into 테이블이름(컬럼이름나열) values(값을 나열);
//      insert into 테이블이름 values(값을 나열 - 모든 컬럼의 값을 나열해야하고 순서대로 나열);

//      데이터를 삽입하다가 오류가 발생하는 경우는 컬럼의 개수와 값의 개수가 맞지않는 경우
//      컬럼의 자료형과 맞지 않는 값을 대입한 경우
//      제약 조건을 어긴 경우 
//      (primary key 나 unique 로 설정된 컬럼에 중복 값을 입력한 경우)
//      (not null 컬럼의 값을 대입하지 않은 경우)
//      (foreign key 로 설정된 데이터의 값을 다른 테이블에 없는 값을 대입한 경우)

// # 실습을 위해서 테이블 구조 확인
// emp 테이블
// EMPNO    NOT NULL NUMBER(4)    
// ENAME             VARCHAR2(10) 
// JOB               VARCHAR2(9)  
// MGR               NUMBER(4)    
// HIREDATE          DATE         
// SAL               NUMBER(7,2)  
// COMM              NUMBER(7,2)  
// DEPTNO            NUMBER(2)
// empno 가 기본키 : not null 이고 unique
// deptno 는 dept 테이블의 dept 컬럼을 참조하는 foreign key

// dept 테이블
// DEPTNO          NOT NULL NUMBER(2)    
// DNAME           VARCHAR2(14) 
// LOC             VARCHAR2(13)
// deptno 가 primary key

// ex) dept 테이블에 데이터를 삽입
// insert into dapt(deptno, dname, loc) values(50,'스폰지밥','파인애플집');
// insert intp dept values(60, '집게리아','비키니시티');

// 확인
// select * from dept;

// 실패 이유
// insert into dapt(deptno, dname, loc) value(70, '총무;);
// not enough values 
// 컬럼의 개수에 비해서 값이 부족하게 입력된 에러

// insert into dapt(deptno, dname, loc) value(70, '총무', '바보', '멍청이');
// too many values
// 컬럼의 개수에 비해서 값을 많이 대입한 경우 발생하는 에러

// # 게시판 처럼 컬럼의 개수가 많은 경우 빈번히 발생하는 에러

// insert into dept(dname, loc)
// values('영업','부산');
// cannot insert NULL into(%s): not null 인 컬럼에 데이터를 대입하지 않은 경우
//                              deptno가 not null 인 컬럼인데 값을 대입하지 않아서 에러가 발생

// insert into dept(deptno, dname, loc)
// values(50, '영업','부산');
// unique constraint (%s.%s) violated : primary key 나 unique 인 컬럼에 중복된 데이터를 대입한 경우 발생하는 에러
//                                      primary kety 의 값을 입력받을 때 중복 검사를 제대로 하지 않거나 자동 생성하도록
//                                      만들 때 로직을 잘못 만들어서 발생 

// 자료형을 잘못 입력한 경우
// 숫자나 날짜를 형식에 맞는 문자열로 입력하면 데이터베이스는 오류를 발생시키지 않는다.
// insert into dept(deptno, dname, loc)
// values('5k', '영업','부산');
// invalid number : 숫자를 대입해야 하는데 문자나 " 대입한 경우 - 웹 프로그래밍에서 많이 발생한다.

// 문자열의 길이가 너무 큰 경우
// insert into dept(deptno, dname, loc)
// values(5, '영업','부산광역시');
// value too large fir column : 문자열의 길이가 너무 큰 경우

// 없는 외래키 값을 대입한 경우
// emp 테이블에 empno 가 9999번이고 deptno 가 30번인 데이터를 삽입
// insert into emp(empno, deptno) values(9999,30);

// emp 테이블에 empno 가 9998번이고 deptno 가 11번인 데이터를 삽입 
// insert into emp(empno, deptno) values(9998,11);
// integrity constraint (%s.%s) violated - parent key not found : 부모 테이블에 없는 값을 삽입하려고 해서 에러

// 2. 데이터 갱신
//    update 테이블이름
//    set 수정할 내용 나열(컬럼이름 = 값 또는 연산식, ....)
//    where 수정할 조건;
//    where 절이 없으면 테이블의 모든 데이터가 수정
//    where 절이 있으면 where 절에 맞는 데이터만 수정

// ex) dept 테이블의 deptno 가 40인 데이터의 dname 은 회계, loc 부산으로 수정
//     확인
//     select * from dept;

// ex2) dept 테이블에서 loc 에 y 자가 포함된 데이터의 dname 을 총무로 수정
//      update dept
//      set dname = '총무'
//      where loc like '%Y%';
//      select * from dept; --갱신 되었는지 확인

// ex3) dept 테이블에서 loc 에 두번째 글자가 A 인 데이터의 dname 을 비서로 수정
//      update dept
//      set dname = '비서'
//      where loc like '_A%';
//      select * from dept;

// 3. 데이터 삭제
//    delete from 테이블이름
//    [where 조건]; // 생략할 시 모든 데이터가 삭제된다
//    다른 테이블의 외래키로 설정되어 있고 외래키에 대입된 경우 삭제가 실패한다.

// **TCL(Transaction Control Language)
// 1. Transaction
//    한번에 이루어져야 하는 데이터베이스 작업 단위 
//    A tomicity (원자성) : All or Nothing
//    C onsistency (일관성) : 수행 전과 수행 후가 일관성
//    I solation (격리성) : 독립적
//    D urability (영속성) : 완료된 트랙잭션은 계속되어야 한다

// 2. 명령어
// 2-1. commit : 작업완료 - 원본 데이터베이스에 반영
// 2-2. savepoint 이름 : 저장점 생성 (rollback 할 수 있는 위치)
// 2-3. rollback (to 저장점) : 저장점이 없으면 트랜잭션 시작 위치로 복원. 저장점을 쓰면 저장점으로 복원.

// 3. 트랙잭션 생성
// 3-1. DML 문장을 처음 사용하면 생성
//      insert, update, delete
// 3-2. DDL, DCL 을 성공하고 DML 문장을 실행하면 생성
// 3-3. Commit 이나 rollback 을 하고 DML 을 실행하면 생성

// 4. Auto Commit
//    DDL(Create, Alter, Drop, Truncate, Rename) 이나
//    DCL(Grant, Revoke) 이 성공한 경우
//    접속 프로그램을 정상 종료한 경우

// 5. Auto Rollback
//    접속 프로그램이 비정상 종료







package Oracle;

public class 필기0727 {

}
