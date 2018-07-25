// **관계형 데이터베이스
// 데이터를 테이블의 집합으로 표현
// 종류
// 1. Oracle : 가장 안정적이나 비용이 많이 든다. 공공기관 과 대기업에서 주로 이용
// 2. MySQL(Maria DB) : Open Source 로 출발
// 3. MSSQL Server : MS 에서 만든 상용화 된 DB
// 4. DB2 : IBM-금융
// 5. Tibero : 대한민국 T-Max 사 개발
// 6. Access : MS 에서 만든 상용화 된 DB
// 7. SQLife : 스마트폰에 내장된 관계형 DB. 임베디드에서 에서도 이용. 경량화 프로그램에 이용

// **Key
// row 를 구분하기위한 Column 또는 Column 의 집합

// 1. Primary key (기본 키)
//    테이블 내에서 행을 구분하기 위해서 선정한 키
//    1개의 테이블에 1개만 존재

// 2. Foreign key (외래키, 참조키)
//    다른 데이블에서 기본키(Unique)인 컬럼

// 3. Integrity (무결성)
// 3-1. 개체 무결성
//      기본 키는 Null 이거나 중복될 수 없다.

// 3-2. 참조 무결성
//      외래 키는 Null 이거나 참조할 수 있는 값만을 가져야 한다.

// **SQL(Structure Query Language)
// 관계형 데이터베이스를 조작하기 위한 언어
// 비 절차적 언어 - 작성한 순서대로 실행이 되지 않는다
// 하나의 명령문은 ';' 으로 종료

// 1. DQL(Database Query Language)
//    데이터 조회 : Select
//    데이터를 변경하지 않음 (동시에 해도 된다)

// 1-2. DML(Database Mainpluation Language)
//      데이터 조작 (동시에 할 수 없다)
//      삽입 : Insert
//      갱신 : Update
//      삭제 : Delete

// 1-3. TCL(Transaction Control Language)
//      트랜잭션 제어 - 한번에 이루어져야 하는 작업단위 (예: 유저 2명의 아이템 거래)
//      Commit : 작업 완료 -> 반영
//      Rollback : 철회

// 4. DDL(Database Definition Language)
//    기본 작업 단위가 테이블
//    데이터베이스 구조 생성, 변경, 삭제
//    Create, Alter, Drop, Truncate, Rename 이 포함

// **Oracle
// 오라클 사에서 만든 관계형 데이터베이스

// **데이터 베이스 사용의 조건
// 1. Database Server 가 필요
//    사용할 데이터베이스

// 2. Database Modeling Tool 을 사용
//    데이터베이스 설계 후 자동으로 테이블을 생성하도록 할 때 필요
//    ER-Win 이 가장 대표적

// 3. Database 접속 도구 사용
//    데이터베이스에 SQL 을 실행하기 위한 프로그램

// # 설치 확인
//   1. 콘솔 창에서 sqlplus 라고 입력하고 아이디는 system, 비밀번호는 설치할 때 설정한 비밀번호를 입력해서 제대로 설치 되었는지 확인
//   2. 서비스에서 확인 : Oracle Service 와 Oracle TNS Listener 항목 확인

// **Oracle 접속도구
// 오라클을 설치하면 sqlplus 라는 접속도구가 자동으로 설치가 된다.
// 관리자는 sqlplus 를 많이 사용한다.
// 오라클을 전문적으로 다룰 때는 sqlplus 에서 작업을 권장
// 실습은 sqlplus 를 추천한다.

// sqldeveloper : 오라클에서 무료로 제공하는 java 로 만든 gui 접속도구

// toad : 개발 현업에서 많이 사용하는 데이터베이스 접속도구

// **오라클을 설치하고 난 후 처음 제공되는 계정
// sysdba : 수퍼 관리자
// system : 관리자 계정
// 데이터베이스에 문제가 생긴 경우 sysdba 에서 그 이외의 경우는 system 에서 작업한다.
// 오라클은 기본적으로 1521 번 포트를 사용하도록 설치되고 8080번 포트도 사용한다.
// 데이터베이스 이름을 SID 라고 하는데 Express Edition 은 기본적으로 xe 라는 이름으로 설치되고
// enterprise edition 을 설치하면 orcl 로 설치된다. 

// 1. 실습용 계정 생성 - system 으로 로그인 하여 생성
//    오라클 에서는 보통 scott 이나 hr 계정으로 연습을 한다.
//    scott 을 만들 때는 보통 비밀번호를 tiger 로 한다.

// 2. scott 계정에 샘플 데이터베이스를 삽입
//    scott.sql 파일의 내용을 실행하면 된다.

// 3. 샘플 데이터 확인
//    select * from emp;
//    최근의 데이터베이스를 다운로드 받은 경우에는 12개의 데이터가 출력되고 과거 버전에서는 14개의 데이터가 조회된다.

// # 실습을 할 때 관리자 계정을 사용하는 것은 위험
//   그래서 보통 계정을 생성하는데 오라클에서 제공하는 샘플 sql 이 전부 scott 이나 hr 로 되어 있어서 계정을 scott 나 hr 로 생성한다.
//   scott 이 테스트 해 볼 데이터는 scott.sql 이라는 파일로 제공되고 이 데이터를 삽입해서 사용한다.

// **테이블 구조 확인하기
// desc 테이블이름;
// emp, dept, salgrade 테이블의 구조 확인

// 1. emp - 테이블
//    empno - 사원번호로 숫자 4자리 primary key
//    ename - 사원 이름으로 문자 10자리
//    jop - 업무로 문자 9자리
//    mgr - 관리자의 사원번호로숫자 4자리
//    hiredate - 입사일로 날짜 형식
//    sal - 급여로 숫자 7자리
//    comm - 상여금으로 숫자 7자리
//    deptno - 부서명으로 dept 테이블의 외래키이고 숫자 2자리

// 2. dept 테이블 (부서 테이블)
//    deptno - 부서번호로 숫자 2자리 primary key
//    dname - 부서명으로 문자 14자리
//    Ioc - 위치로 문자 13자리

// 3. salgrade 테이블 (호봉 테이블)
//    grade - 등급으로 숫자로 구성
//    losal - 최저 급여
//    hisal - 최대 급여

// **select
// 데이터를 조회할 때 사용하는 구문으로 6개의 절로 구성된다.

// select 조회하고자 하는 컬럼이나 연산식 *
// from 조회하고자 하는 테이블 이름을 나열
// where 조회하고자 하는 조건
// group by 그룹화하고자 하는 컬럼이나 연산식
// having 그룹화(group by) 이후의 조건
// order by 정렬할 컬럼이나 연산식을 나열

// 이 중 select 와 from 은 필수적으로 포함된다.
// 실행 순서는 from -> where -> group by -> having -> select -> order by
// 예약어와 테이블 이름 그리고 컬럼 이름은 대소문자 구분을 하지 않는다.
// 예악어 다음에는 반드시 한 칸 이상의 공백이 있어야 한다.(중요)

// 1. 테이블의 전체 데이터 조회
//    select *
//    from 테이블이름;

// ex) emp 테이블의 전체 데이터를 조회
//     select *
//     from emp;

// 2. 특정 컬럼에 해당하는 데이터만 조회
//    select 컬럼이름을 나열
//    from 테이블 이름;

// ex) emp 테이블에서 ename 과 jop 을 조회
//     select ename, jop
//     from emp;

// 3. 컬럼의 연산식( +, -, *, / ) 을 조회할 수 있다.
//    데이터베이스 에서는 날짜도 산술 연산을 할 수 있다.
//    하루를 1로 설정해서 연산을 한다.

// ex) emp 테이블에서 ename 과 sal * 12 한 결과를 조회
//     select ename, sal*12
//     from emp;

// ex)2 emp 테이블에서 ename 과 입사한 후 몇 일이 지났는지 조회
//    입사일은 hiredate 컬럼이고 현재 시간 및 날짜는 sysdate
//    select ename, sysdate-hiredate
//    from emp;

// 4. 컬럼에 별명을 설정해서 출력할 수 잇다.
//    별명은 한 칸 공백을 주고 설정해주면 된다.
//    대문자나 공백이 있으면 별명을 "" 로 감싸야 한다.

//    ex) emp 테이블에서 ename 과 sal * 12 를 조회. 단 sal * 12 는 년봉이라고출력

// 5. 데이터베이스 에서의 NULL
//    데이터베이스는 모든 자료형에 대하여 NULL 을 대입할 수 있다.
//    데이터베이스 에서는 NULL 을 실제로 저장하는 것이 아니라 NULL 을 판단할 수 있는 별도의 비트를 할당해서 NULL 여부를 저장
//    NULL 과 산술연산을 수행하면 NULL 이 된다.

// ex) emp 테이블에서 ename 과 sal*12+comm 의 결과를 조회

// COMM 이 NULL 인 컬럼의 값이 NULL 로 출력된다.

// NVL 함수
// 컬럼이나 연산식의 결과가 NULL 일 때 이를 다른 값으로 치환하기 위한 함수
// NVL(컬럼이름 또는 연산식, 치환할 값)의 형식으로 사용한다.

// ex) emp 테이블에서 ename 과 sal*12+comm 의 결과를 조회
//     comm 컬럼의 값이 NULL 일 때는 0으로 해서 계산
//     sal*12+comm 컬럼의 이름을 지급액이라고 출력

// 6. 결합 연산자 ||
//    문자열을 결합할 때 사용하는 연산자
//    컬럼들을 하나로 합쳐서 출력하고자 할 때 사용하는 연산자
//    날짜 같은 데이터를 저장할 때 Date 를 이용하지 않고 년 월 일을 각각의 컬럼으로 저장한 후 조회할 때 하나로 합치기 위한 목적으로 사용

// ex) emp 테이블에서 ename 과 job 을 하나로 묶어서 조회
//     select ename || job
//     from emp;

// 7. Literal
//    사용자가 직접 입력하는 데이터
//    프로그램의 상수 영역에 별도로 저장해서 다음에 사용할 때 저장된 데이터를 이용한다.
//    리터럴은 한 번 메모리를 할당받으면 프로그램이 종료될 때 까지 소멸되지 않는다.
//    리터럴은 사용할 때 상수 영역을 확인해서 상수 영여겡 존재하면 그 데이터를 이용하고 존재하지 않으면 새로 저장해서 사용한다.
//    오라클에서는 문자 리터럴은 작은 따옴표 안에 기재한다.
//    '문자 또는 문자열'

// 8. distinct
//    select 절의 맨 앞에 기재할 수 있는 예약어
//    컬럼의 중복을 제거하고 조회할 때 사용한다.
//    컬럼 이름이 하나일 때는 컬럼 1개의 중복을 제거하지만 컬럼을 여러 개 나열할 경우 나열 된 모든 컬럼의 값이 동일한 경우에만 중복을 제거
//    # distinct 는 select 절의 맨 앞에 1번만 올 수 있다.

// ex) emp 테이블에서 job 의 중복을 제거하고 조회
//     select

// 9. where 절
//    테이블에 조건을 적용하여 조건에 맞는 행 만 필터링
//    select 가 테이블를 열 단위로 필터 링하는데 where 은 행단위로 필터링 한다.
//    from 다음으로 수행된다.

// 1. 단일 행 연산자
// >, >=, <, <= 
// =, !=(<>)
// 앞에 not 을 붙이면 결과는 반대가 된다.
// 날짜도 숫자로 간주하기 때문에 크기 비교 연산자 사용 가능하다.
// 문자열도 크기 비교 연산자를 사용할 수 있는데 코드 값을 가지고 비교한다.

// ex) EMP 테이블에서 sal 이 3000 이상인 사원의 empno, ename, job, sal 을 조회
//     select empno, ename, job
//     from emp
//     where sal >= 3000;

// ex2) EMP 테이블에서 job 이 MANAGER 인 사원의 empno, ename, job, sal, deptno 을 조회
//      select empno, ename, job, sal, deptno
//      from emp
//      where job = 'MANAGER';

// 2. 날짜 데이터 사용
//    날짜 - to_date('2008/04/14 22:02:14', yyyy/mm/dd hh24:mi:ss')
//    오늘 날짜 및 시간 - sysdate

// ex) EMP 테이블에서 hiredate 가 1982년 01월 01일 이후인 사원의 empno, ename, job, sal, hiredate, deptno 을 조회
//     select empno, ename, job, sal, hiredate, deptno
//     from emp
//     where hiredate >= to_date(1982/01/01','yyyy/mm/dd');

// 3. and, or
//    and 는 모두 true 일 때만 true
//    or 은 모두 false 일 때만 false
//    and 는 첫 번쨰 결과가 false 이면 결과가 무조건 false 이기 때문에 뒤의 조건은 조사하지 않는다.
//    or 은 첫 번째 결과가 true 이면 결과가 무조건 true 이기 때문에 뒤의 조건은 조사하지 않는다.

// 4. in, not in
//    in 은 여러 개 값 중에서 하나라도 일치하는 것이 있으면 조회
//    not in 은 여러 개 값에 일치하는 것이 없으면 조회

// 5. between A and B
//    A 보다 크거나 같고 B 보다 작거나 같은 데이터 조회
//    반드시 B 의 값이 A 보다 크거나 같아야 한다.

// 6. is null, is not null
//    null 인 데이터를 조회할 때는 is null
//    null 이 아닌 데이터를 조회할 떄는 is not null

// ex) emp 테이블에서 sal 이 1000 이상이고 job 이 clerk 인 사원의 ename 과 job 과 sal 을 조회
//     select ename. job
//     from emp
//     where sal >= 1000 and job = 'clerk';

//     select ename, job (이 방법이 위의 방법보다는 더 좋다)
//     from emp
//     where job = 'clerk' and sal >= 1000;

// ex2) emp 테이블에서 job 이 CLERK 이거나 MANAGER 인 사원의 ename 과 job 을 조회
//      select ename, job
//      from emp
//      where job = 'CLERK' or job = 'MANAGER';

//      select ename, job
//      from emp
//      where job in ('CLERK', 'MANAGER');

// ex3) emp 테이블에서 comm 의 값이 null 이 아닌 데이터의 ename 과 sal 을 조회
//      select ename, sal
//      from emp
//      where comm is not null;

// # null 은 = 나 != 로 비교하지 않는다.

// 7. 부분일치 검색 - like 와 와일드카드 문자 이용
//    - : 반드시 하나의 문자와 매핑
//    % : 0개 이상의 문자

// ex) emp 테이블에서 ename 에 L 이 포함된 사원의 ename 과 job 을 조회
//     select ename, job
//     from emp
//     where ename like '%L%';

// ex2) emp 테이블에서 ename 의 3번째 글자가 L 인 사원의 ename 과 job 을 조회
//     select ename, job
//     from emp
//     where ename like '__L%';

// ex3) emp 테이블에서 hiredate 가 81년인 데이터의 모든 컬럼을 조회
//      select *
//      from emp
//      where hiredate like '81%';

// 10. order by 절
//     데이터를 순서대로 나열(정렬)하기 위한 절
//     select 구문에서 가장 마지막에 작성하고 가장 마지막에 수행된다.
//     ascending(오름차순) : 작은 것에서 큰 것 순서대로 나열하는 것 (기본은 오름차순)
//     descending(내림차순) : 큰 것에서부터 작은 것 순으로 나열하는 것
//     order by 정렬할 컬럼이름 또는 연산식 asc | desc
//     asc 는 생략해도 되는데 오름차순이고 desc 는 내림차순
//     여러 개의 컬럼이나 여러 개의 연산식을 나열해도 되는데 앞의 조건부터 순서대로 적용하게 된다.
//     첫 번째 컬럼을 가지고 정렬을 하고 동일한 값이 있을 때 두번째 컬럼을 가지고 수행한다.
//     데이터 베이스에 데이터가 저장될 때는 순서와 상관없이 저장된다.
//     2개 이상의 데이터를 조회할 때는 정렬을 하는 것이 좋다.

// ex) emp 테이블의 모든 컬럼을 조회하는데 ename 의 알파벳 순서로 조회
//     select *
//     from emp
//     order by ename;

// ex2) emp 테이블의 모든 컬럼을 조회하는데 job 의 오름차순으로 정렬하고 job 이 동일한 경우에는 sal 이 많은 데이터부터 조회
//      select *
//      from emp
//      order by job, sal desc;

// **연습문제

// EMP 테이블에서 sal이 3000이상인 사원의 empno, ename, job, sal을 조회하는 SELECT 문장을 작성

// EMP 테이블에서 empno가 7788인 사원의 ename과 deptno를 조회하는 SELECT 문장을 작성

// EMP 테이블에서 hiredate가 1981년 2월 20일 과 1981년 5월 1일 사이에 입사한 사원의 ename, job, hiredate을 조회하는 SELECT 문장을 작성(단 hiredate 순으로 조회)

// EMP 테이블에서 deptno가 10, 20인 사원의 모든 정보를 조회하는 SELECT 문장을 작성(단 ename순으로 조회)

// EMP 테이블에서 sal이 1500이상이고 deptno가 10, 30인 사원의 ename과 sal를 조회하는 SELECT 문장을 작성(단 HEADING을 employee과 Monthly Salary로 조회)

// EMP 테이블에서 hiredate가 1982년인 사원의 모든 정보를 조회하는 SELECT 문을 작성

// EMP 테이블에서 COMM이 NULL이 아닌 사원의 모든 정보를 조회하는 SELECT 문을 작성

// EMP 테이블에서 comm이 sal보다 10% 이상 많은 사원에 대하여 ename,sal, comm를 조회하는 SELECT 문을 작성

// EMP 테이블에서 job이 CLERK이거나 ANALYST이고 sal이 1000, 3000, 5000이 아닌  사원의 모든 정보를 조회하는 SELECT 문을 작성

// EMP 테이블에서 (ename에 L이 두 자 이상이 포함되어 있고 deptno가 30)이거나 mgr이 7782인 사원의 모든 정보를 조회하는 SELECT 문을 작성

/*
-- 연습문제 --

-- 1번 문제
select empno, ename, job, sal
from emp
where sal >=3000;

-- 2번 문제
select ename, deptno
from emp
where empno in (7788);

-- 3번 문제
select  ename, job, hiredate
from emp
where  hiredate between to_date('1982/2/20', 'yyyy/mm/dd') and to_date('1981/05/01','yyyy/mm/dd')
order by hiredate;

-- 4번 문제
select *
from emp
where deptno in (10, 20) -- 혹은 where deptno = 10 or deptno = 20 으로 표현될 수도 있다
order by ename;

-- 5번 문제
select ename, sal "Monthly Salaty"
from emp
where sal >= 1500 and deptno in (10,30); -- 혹은 or 로도 표현 가능하다

-- 6번 문제
select *
from emp
where hiredate like '82%'; -- 혹은 where hiredate >= to_date('1982/01/01',yyyy/mm/dd' and;
                                            --  hiredate <= to_date('1982/12/31','yyyy/mm/dd'); 로도 표현 가능하다

-- 7번 문제
select *
from emp
where comm is not null;

-- 8번 문제
select ename, sal, comm
from emp
where comm >= sal*1.1;

-- 9번 문제
select *
from emp
where job in ('CLERK', 'ANALYST') and sal not in(1000,3000,5000);

-- 10번 문제
select *
from emp
where ename like '%L%L%' and deptno = 30 or mgr = 7782;
*/





package Oracle;

public class write {

}
