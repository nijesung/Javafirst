// **scott
// 1. DUAL 테이블
//    오라클에서 제공하는 가상의 테이블
//    연산식이나 현재 날짜 등을 확인하고자 하는 경우에 사용
//    관계형 데이터베이스는 무엇인가를 출력하고자 할 때 select 구문을 이용해야 합니다.
//    select 절과 from 절이 필수 입력 요소입니다.
//    연산식이나 현재 날짜 등은 select 절에 기재할 수 있지만 테이블이 없어서 출력을 할 수가 없다.
//    이런 경우에는 dual 이라는 테이블을 이용해서 출력한다.

//    ex)현재 날짜 확인
//       select sysdate
//       from dual;

// 2. Round 함수
//    반올림하는 함수
//    round(값이나 컬럼이름[,자릿수]) : 자릿수를 생략하면 소수 첫 째 자리에서 반올림해서 정수 부분만 표시하고 양수를 대입하면 소수를
//                               양수까지 표시한다. 음수를 대입하면 정수 자리 반올림을 할 수 있다.
//                               java 에서 Math 클래스에 있는 round 함수도 동일한 기능을 수행한다.

// ex) emp 테이블에서 empno 와 sal 을 조회
//     sal 은 10의 자리에서 반올림해서 100의 자리부터 나오도록 설정

// 3. upper, lower
//    대문자로 또는 소문자로 변경해 주는 함수
//    아이디나 검색어는 대소문자 구분을 하지 않는다.
//    비교할 때는 모두 대문자나 소문자로 변경해서 비교해야 한다.

// 4. length
//    글자 수

// 5. substr
//    특정 위치에서 글자를 분할해서 가져오는 것
//    첫 번째 매개변수는 문자열 이고 두 번째 매개변수가 시작 위치, 세 번째 매개변수는 글자 수
//    시작 위치에 음수를 대입할 수 있는데 음수는 뒤에서 부터 센다.
//    최근에 등장한 언어들은 대부분 인덱스에 음수를 사용할 수 있다.

// ex) emp 테이블에서 ename 에 r 이 포함된 데이터의 ename 과 job 을 조회
//     ename 은 대소문자 구분없이 조회

//     select ename, job
//     from emp
//     where lower(ename) like '%r%';

// ex2) emp 테이블에서 hiredate 가 81로 시작하는 데이터의 모든 컬럼을 조회
//      like 를 사용하지 않고 substr 을 사용한다.

//      select *
//      from emp
//      where substr(hiredate, 0, 2) = '81'

// 6. trim
//    좌우 공백을 제거해주는 함수
//    데이터베이스는 문자열을 2가지로 저장한다.
//    하나는 문자 길이를 변경할 수 없도록 하는 char 이고, 다른 하나는 문자 길이가 변경되며 저장되는 varchar(varchar2) 이다.
//    char 의 경우는 문자 길이보다 작은 개수를 저장하면 뒤에 공백이 같이 저장된다.
//    이럴 때는 뒤의 공백을 제거하고 출력 하거나 비교해야 한다.

// 7. to_date
//    문자열을 날짜 형식으로 변경 해 주는 함수
//    to_date(문자열, 날짜 서식)

// 8. nvl
//    null 을 대체할 수 있는 함수
//    nvl(null 을 가질 수 있는 컬럼이나 연산식, 대체할 값)

// ex) emp 테이블에서 1981년 6월 30일 이후에 입사한 사원의 이름(ename) 과 입사일(hiredate) 을 조회

//     select ename, hiredate
//     from emp
//     where hiredate >= to_date('1981/06/30','yyyy/mm/dd');

// ex2) emp 테이블에서 ename 과 sal*12+comm 의 값을 조회하시오.
//      comm 은 null 을 포함할 수 있는 컬럼이다.
//      # 덧셈을 할 때는 대부분 null 을 0으로 곱셈을 할 때는 1로 변경해서 계산한다.

//      select ename, sal*12+nvl(comm, 0)
//      from emp;

// **그룹함수
// 전체 행을 하나로 묶어서 연산을 수행 해 주는 함수
// sum, avg, max, min, count, stddev, variance
// null 은 제외하고 연산한다.
// 산술연산은 null 과 하게 되면 null 이 리턴

// ex) emp 테이블의 sal 합계를 조회
//     select sum(sal)
//     from emp;

// ex2) emp 테이블에서 comm 의 평균을 조회
//      select avg(comm) -- comm 은 null 을 가질 수 있으므로 문제가 발생할 가능성이 있다 (null 을 제외하고 평균을 구한 결과값)
//      select avg(nvl(comm, 0)) -- null 인 데이터는 0으로 간주하여 평균을 구한 결과
//      from emp;

// ex3) emp 테이블의 데이터 개수를 조회
//      select count(*) -- 테이블 내의 전체 행의 개수를 조회할 때 사용 (행의 개수를 알고자 할 때는 * 을 대입하여 조회한다)
//      select count(comm) -- 컬럼의 값이 null 이 아닌 경우의 개수 (null 이 아닌 데이터의 개수를 가져올 때 컬럼 이름을 기재한다)
//      from emp;

// **group by
// select 구문의 4번째 절로 from 과 where 다음에 수행
// 컬럼이나 연산식으로 그룹화하고자 할 때 사용하는 절
// select 보다 먼저 수행하기 때문에 select 에서 만든 별명은 사용할 수 없다.
// group by 를 사용하게 되면 select 구문에 group by 로 묶은 컬럼 이름이나 연산식을 기재하는 것이 좋고 group by 가 잇으면
// select 구문에는 group by 로 묶은 컬럼이나 연산식 그리고 그룹 함수를 이용하는 컬럼만 조회할 수 있다.


// **일의 순서
// 5. select : 조회할 컬럼 이름이나 연산식 나열(조회된 데이터들을 열 단위로 분할)
// 1. from - 조회할 테이블 이름
// 2. where - 조회할 조건 : 테이블의 데이터를 행 단위를 분할(필터링)
// 3. group by : where 에 의해서 조회된 행들을 콩통된 컬럼을 기준으로 그룹화
// 4. having : 그룹화 한 이후의 조건
// 6. order by : 조회된 결과를 컬럼이나 연산식을 기준으로 정렬
// # 5번과 1번은 필수적으로 구성되어야 한다.


// ex) emp 테이블에서 job 별 sal 의 평균을 조회
//     select job, round(avg(sal))
//     from emp
//     group by job
//     order by round(avg(sal)) desc;

// ex2) emp 테이블에서 job 별 데이터 개수를 조회
//      select job, count(*)
//      from emp
//      group by job;

// ex3) emp 테이블에서 입사년도(hiredate) 별 데이터 개수를 조회
//      select substr(hiredate, 0, 2), count(*)
//      from emp
//      group by substr(hiredate, 0, 2);


// **Having
// groub by 이후의 조건을 설정하는 절 이다.
// where 는 group by 이전에 수행되기 때문에 그룹함수(count, max, min, sum, avg) 등을 사용할 수 없다.

// ex) emp 테이블에서 job 별 sal 의 평균을 조회
//     단 job 이 2개 이상 존재하는 데이터만 조회
//     select job, count(*), round(avg(sal))
//     from emp
//  -- where count(job) >= 2 -- 그룹 함수는 group by 다음에 동작하기 때문에 where 는 그룹 함수를 사용할 수 없다
//     group by job
//     having count(job) >= 2; -- group by 이후의 조건을 적는다

// 연습문제

// 1. EMP 테이블에서 데이터 개수, 최대 급여(sal), 최소 급여, 급여의 합을 계산하여 출력하는 SELECT 문장을 작성
//    select count(*), max(sal), min(sal), sum(sal)
//    from emp;

// 2. EMP 테이블에서 각 업무별(job)로 최대 급여(sal), 최소 급여, 급여의 합을 출력하는 SELECT 문장을 작성
//    select job, max(sal), min(sal), sum(sal)
//    from emp
//    group by job;

// 3. EMP 테이블에서 업무별(job) 데이터 개수를 구하여 출력하는 SELECT 문장을 작성하여라.
//    select job, count(*)
//    from emp
//    group by job;

// 4. EMP 테이블에서 최고 급여(sal)와 최소 급여의 차이는 얼마인가 출력하는 SELECT 문장을 작성하여라.
//    select max(sal) - min(sal)
//    from emp;


// **join
// 2개의 테이블을 합쳐서 하나의 테이블로 만드는 것

// emp 테이블: empno(사원번호), ename(사원이름), job(직무), mgr(관리자 사원번호), hiredate(입사일)
//           sal(급여), comm(상여금), deptno(부서번호)

// dept 테이블: deptno(부서번호), dname(부서명), loc(지역)

// salgrade 테이블: grade(호봉), losal(최저급여), hisal(최고급여)

// 1. cross join - catesian product
//    from 절에 테이블 이름을 2개 이상 기재했을 때 수행하는 것
//    2개 테이블의 모든 조합이 만들어지게 된다.
//    행의 개수는 양쪽 테이블 행의 개수를 곱한 것이 되고 열의 개수는 양쪽 테이블의 열의 개수를 더한 것과 같다.

// 2. inner join 과 outer join
//    inner join 은 양쪽 테이블에 모두 존재하는 데이터만 조인에 참여
//    outer join 은 한쪽 테이블에만 존재하는 데이터도 조인에 참여
//    (+) 기호를 이용하며 정보가 부족한 쪽에 붙여주면 된다.

// 3. equi join 과 non-equi join
//    join 조건을 기술할 때 = 로 기술하면 equi join, 그렇지 않으면 non equi join
//    non equi join
//    양쪽 테이블의 조인 조건을 = 가 아닌 연산자로 만드는 경우
//    emp 테이블의 sal 은 급여를 저장하고 있다.
//    salgrade 테이블의 grade 는 급여 등급이고 losal 은 최소급여 그리고 hisal 은 최대급여 컬럼 이다.
//    emp 테이블에 있는 사원의 급여 등급을 알고자 하는 경우
//    emp 테이블의 sal 과 salgrade 테이블의 losal 과 hisal 은 비교할 때 = 를 사용할 수가 없다.

// 4. self join
//    자신의 테이블과 조인
//    하나의 테이블에 동일한 의미를 갖는 컬럼이 2개 이상 존재하는 경우에 수행
//    테이블의 이름이 같기 때문에 반드시 테이블 이름에 별명을 지정하여 사용해야 한다.

// 5. 서로 다른 테이블에 동일한 이름의 컬럼이 존재하는 경우
//    컬럼 이름 앞에 테이블 이름을 붙여 주어야 한다.

// 6. 테이블 이름에 별명 부여
//    대신에 별명을 부여하게 되면 원래의 이름은 사용할 수 없다.

// ex) emp 테이블과 dept 테이블을 equi join 하기
//     where 절에 양쪽 테이블에 동일한 의미를 갖는 컬럼의 값이 같다는 조건을 추가

// ex2) emp 테이블의 ename 과 dept 테이블의 dname 과 loc 을 조회
//      사원의 이름과 사원이 근무하는 부서 이름 그리고 지역을 조회

// ex3) dept 테이블의 loc 과 NEW YORK 인 사원의 emp 테이블의 ename 을 조회


// ex) emp 테이블에서 ename 과 sal 그리고 salgrade 테이블의 grade 를 조회


// ex) emp 테이블에서 자신의 이름(ename) 과 관리자의 이름(ename) 을 조회
//     자신의 관리자에 해당하는 사원의 이름 찾기


// ex) 사원의 이름과 부서명 그리고 지역을 조회
//     emp 테이블에 ename 을 가져와야 하고 dept 테이블에서 dname. loc 를 가져와야 한다.
//     각 테이블의 deptno 가 공통된 의미를 갖는 컬럼
//     사원이 근무하지 않는 부서명과 지역도 조회
//     select ename, loc, dname
//     from emp, dept
//     where emp.deptno(+) = dept.deptno; -- 부족한 쪽에 (+) 기호를 붙여준다


// ============= 여기 까지의 조인 방식은 모든 관계형 데이터베이스에서 동일하게 적용 ==================
// 이제 부터 나오는 조인은 오라클 에서는 가능하지만 다른 관계형 데이터베이스 에서는 지원을 하지 않을 수도 있다. 물론 대부분을 지원한다.


// **ANSI(미국 표준 협회) JOIN
// 미국 표준 협회가 join 에 관련된 SQL 을 간략하게 사용할 수 있도록 추가한 문법
// 1. cross join
//    2개 테이블의 모든 데이터 조합
//    from 절에 테이블 이름과 이름 사이에 cross join 이라고 기재하면 된다.

// ex) emp 테이블과 dept 테이블을 cross join
//     select *
//     from emp cross join dept;

// 2. inner join
//    inner join 을 할 때 join 조건을 where 절에 기재하지 않고 where 절 앞에 on 절을 추가해서 기재할 수 있다.
//    where 절의 조건과 구분하기 위함이다.
//    from 절의 테이블 이름 사이에 inner join 을 추가해서 수행한다.

// ex) emp 테이블의 ename 이 MILLER 인 사원의 ename 과 dept 테이블의 loc 를 조회

// join 을 할 때 join 을 수행하는 컬럼의 이름이 동일한 경우는 on 대신에 using(공통 컬럼 이름) 을 기재해도 된다.

// 동일한 컬럼 이름으로 조인하는 경우 using 도 생략하고 inner 대신에 natural 이라고 해도 된다.

// 3. outer join
//    어느 한 쪽에만 존재하는 데이터도 조인에 참여
//    from 절에 테이블 이름1 [left | right | full] outer join 테이블이름2
//    select *
//    from emp full outer join dept
//    on emp.deptno = dept.deptno;


// **데이터의 분할 저장
// 1. 데이터를 세로로 분할
//    테이블을 나누어서 데이터를 저장
//    중복된 데이터 저장을 회피하기 위해서이다.
//    join 을 이용해서 데이터를 조회해야 한다.

// 2. 데이터를 가로로 분할
//    동일한 구조의 테이블을 새로 만들어서 데이터를 저장 (데이터가 너무 많아서)
//    set 연산을 이용해서 데이터를 조회하거나 조회한 후의 결과를 set 연산을 이용해서 사용한다.

// **set(집합)연산자
// 구조가 동일한 조회결과를 하나로 묶는데 사용하는 연산자
// select 구문 사이에 set 을 추가하고 연산자를 기술하면 된다.
// union(합집합 - 중복제거), union all(합집합 - 중복제거하지 않음), interest(교집합), minus(차집합 - 한쪽에만 존재하는 데이터)

// dept 테이블에는 deptno 가 10,20,30,40 이 존재
// emp 테이블에는 deptno 가 10,20,30 이 존재
// select deptno
// from dept
// set 연산자
// select deptno
// from emp;

// 1. EMP 테이블에서 모든 사원에 대한 이름(ename), 부서번호(deptno) DEPT 테이블에서 부서명(dname)을 출력하는 SELECT 문장을 작성
//    select ename, emp.deptno, dname
//    from emp, dept
//    where emp.deptno = dept.deptno;

// 2. DEPT 테이블의 LOC가 NEW YORK에서 근무하고 있는 사원에 대하여 EMP 테이블의 이름(ename), 업무(job), 급여(sal), 
//    DEPT 테이블의 부서명(dname)을 출력하는 SELECT 문장을 작성
//    select ename, job, sal, dname
//    from dept,emp
//    where emp.deptno = dept.deptno and loc = 'NEW YORK';

// 3. EMP 테이블에서 보너스(comm)가 null 이 아닌 사원에 대하여 이름(ename), DEPT 테이블의 부서명(dname), 위치(loc)를 출력하는 
//     SELECT 문장을 작성
//     select ename, dname, loc
//     from emp, dept
//     where emp.deptno = dept.deptno and comm is not null;

// 4. EMP 테이블에서 이름(ename) 중 L자가 있는 사원에 대하여 이름(ename), 업무(job), DEPT 테이블의 부서명(dname), 위치(loc)를 
//    출력하는 SELECT 문장을 작성
//    select ename, job, name, loc
//    from emp, dept
//    where emp.deptno = dept.deptno and ename like '%L%';

// 5. EMP 테이블에서 그들의 관리자(mgr) 보다 먼저 입사한 사원에 대하여 이름(ename), 입사일(hiredate), 관리자(mgr) 이름,  
//    관리자(mgr) 입사일을 출력하는 SELECT 문장을 작성하여라.
//    select e.ename 사원명, e.hiredate 사원입사일, m.ename 관리자명, m.hiredate 입사일
//    from emp e, emp m
//    where e.mgr = m.empno and e.hiredate < m.hiredate;





package Oracle;

public class 필기0726 {

}
