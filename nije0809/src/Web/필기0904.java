// I.C
// 제어의 역전
// DI
// 의존성 주입
// AOP
// 관점 지향 프로그래밍

// # 자바 웹 쪽으로 취업할 경우 외워서 면접에 활용

// **데이터베이스
// 데이터를 저장하고 관리하는 소프트웨어
// 1. 종류
// 1-1. 관계형 데이터베이스
//      테이블의 집합으로 데이터를 관리하고 SQL 을 사용
//      ex) Oracle, MySQL, MSSQL, SQLite ...

// 1-2. NoSQL
//      Map 의 List 구조로 데이터를 관리하고 자바스크립트 함수를 이용해서 데이터베이스 작업을 수행
//      MongoDB, Cassandra, Hive ...

// 2. Oracle & MySQL
//    Oracle
//    무조건 유료
//    MySQL
//    무료 버전과 유료 버전이 있음

// MySQL 은 작업 단위가 database
// 1). 사용 가능한 데이터베이스 확인
//     show databases;

// 2). 데이터베이스 사용
//	   use 데이터베이스 이름;

// 3). 데이터베이스 생성
//     create database 데이터베이스 이름;

// 4). 데이터베이스 삭제
//     drop database 데이터베이스 이름;

// 5). 테이블 생성
//     create table 테이블이름(
//	   컬럼이름 자료형 제약조건,
//     ...
//     테이블 제약조건);

// 6). 테이블 구조 확인
//     desc 테이블이름;

// 7)  테이블 데이터 확인
//     select * from 테이블이름

// 8)  테이블에 컬럼 추가
//	   alter table 테이블이름 add 새로운 컬럼이름 컬럼타입(first 또는 after 컬럼명;

// 9)  테이블의 컬럼을 삭제
//	   alter table 테이블이름 drop 삭제할 컬럼이름;

// 10) 테이블의 컬럼명 변경
//     alter table 테이블이름 change 이전 컬럼명 새로운 컬럼명 컬럼 타입

// 11) 테이블의 컬럼 자료형 변경
//     alter table 테이블 modify 컬럼이름 새로운 자료형;
//     동일한 형식의 자료형 으로만 변경이 가능하며 자릿수를 늘리는 것은 관계없지만 
//	   줄일 때는 데이터가 변경될 수도 있으니 주의해야 한다.

// 12) 테이블을 삭제
//     drop table 테이블이름;

// 13) 데이터 삽입
//     auto increment 로 설정된 컬럼은 데이터 삽입하지 않아도 일련번호 형태로 자동으로 삽입된다.
//	   insert into 테이블이름(컬럼이름 나열) values(값을 나열);
//     insert into 테이블이름 values(값을 나열)
//	   모든 컬럼의 값을 순서대로 나열해야 한다.
// 	   date 는 문자열 형태로 바로 대입이 가능하다. 'yyyy-mm-dd'

// 14) 데이터 수정
//	   update 테이블이름
//	   set 수정할 내용
//	   [where 조건];
//	   where 절에 없으면 테이블의 데이터 전체를 수정한다.
//	   수정할 내용이 여러 개이면 , 를 이용해서 나열하면 된다.

// 15) 데이터 삭제
//     delete from 테이블 이름
//     [where 조건];
//     조건이 없으면 테이블의 데이터 전부 삭제

// 16) 트랜잭션 제어어(TCL)
//	   commit
//     현재까지 작업 내용을 원본에 반영

//	   rollback
//	   현까지 작업 내용을 취소

//	   auto commit
//	   접속 프로그램의 정상 종료, DDL(create, alter, drop)의 정상 수행
//     DCL(grant, revoke)

//	   auto rollback
//	   접속 프로그램이 비 정상적으로 종료된 경우

// # MySQL 은 default 로 테이블을 만들면 Engine 이 MyISAM	으로 설정되는 경우가 있어서
//   commit 과 rollback 이 동작을 안할 수도 있다.
//   트랜잭션을 사용할 것 같으면 테이블을 생성할 때 engine 옵션을 innodb 로 설정해야 한다.

// # DB Server
//   데이터를 저장
//   DB Client
//	 접속 도구


// **데이터 조회
// 1. 테이블의 모든 컬럼을 조회
//    select *
//    from 테이블이름;

//    조회 구문에서는 select 와 from 절은 생략이 안 된다.
//    테이블 이름에 해당하는 테이블에서 모든 컬럼의 값을 가져온다.

// 2. 특정한 컬럼만 추출
//	  select 컬럼이름 나열
//    from 테이블이름;

// 3. 컬럼의 데이터 중복을 제거
//    distinct 는 select 절에서 1번만 사용이 가능하다.
//    distinct 뒤에 2개 이상의 컬럼이름이 나열되면 2개 이상의 컬럼의 값이
//    모두 일치하는 경우만 제외된다.

// 4. order by
//    데이터를 정렬하기 위한 절
//    select 구문의 가장 마지막에 수행
//    데이터베이스는 컬럼의 순서나 행의 순서가 없다.
//    데이터베이스는 해싱을 이용하여 데이터를 저장하기 때문에 순서와는 무관하게 저장된다.
//	  2개 이상의 행을 조회하는 경우는 적절한 조건으로 데이터를 정렬해서 조회하는 것이 좋다.
//	  order by 정렬할 컬럼이름 이나 수식 [asc | desc], 정렬할 컬럼 이름이나 수식...
//    asc 는 오름차순 정렬이고 desc 는 내림차순 정렬이며 생략하면 asc 로 적용

// 5. where (from 다음에 수행됨)
// 5-1. 연산자
//      >, >=, <, <=, =, !=(<>)
//      and, or
//      in(데이터 나열) - 데이터 중 하나와 일치하면 된다

// 		between a and b - a와 b 사이
//      a와 b 포함, b가 a보다 크거나 같아야 한다.

//		in 과 between 에도 not 을 사용할 수 있다.

// # 와일드 카드 문자
//   (한 글자와 매핑)
//   %(글자 수와 상관없이 매핑)
//   와일드 카드 문자 like 와 함께 사용

// 6. 그룹 함수
//    count(컬럼이름 또는 *)
//	  데이터의 개수를 정수로 리턴한다.
//    컬럼이름을 기재하면 컬럼의 값이 null 인 데이터는 제외하고 개수를 센다.
//	  * 을 사용하면 행의 개수를 리턴한다.
//    !count 로 배열의 크기를 확인하고 데이터를 배열에 집어넣으면 메모리낭비를 줄일 수 있다.

//    sum(컬럼이름), avg(컬럼이름), max(컬럼이름), min(컬럼이름)
//	  문자열은 최대 값과 최소 값을 구할 수는 있지만 합계와 평균은 못 구한다.
//    그룹 함수는 select 절과 having 절과 order by 절에서 사용할 수 있다.

// 7. Oracle 에는 null 인 경우 대체 값을 설정할 수 잇는 nvl 이라는 함수가 있다.
//    MySQL	에는 coalesce() 함수가 있다.
//    ifnull 이라는 함수도 동일한 기능을 수행 하는데 mssql 에는 이 함수가 없다. 
//	  coalesce(컬럼 이름이나 연산식, null 일 때 대체값)
//	  avg 나 sum 은 null 인 경우 연산에서 배제한다.

//    ex) money 칼럼
//    10
//    null
//    30
//    avg(money): 20
//    avg(coalesce(money,0)): 13.33333

// 8. group by
// 	  그룹화 하기 위한 컬럼이나 연산식을 기술하는 절
//    where 뒤에 기술하고 where 다음으로 수행된다.
//    !작성 순서(외울 것)
//    select -> from -> where -> group by -> having -> order by
//    실행 순서
//    from -> where -> group by -> having -> select -> order by

// # group by 를 사용하게 되면 select 절에서 group by 한 항목과 그룹 함수만 조회할 수 있다.

// 9. having
//	  그룹화 한 이후의 조건을 설정하기 위한 절
//    조건은 where 절에 기술하지만 where 는 group by 가 수행되기 전에 실행되기 때문에
//	  그룹화 한 이후의 조건을 설정할 수 없다.

// 10. limit
// 	   마지막에 기술하는데 정수 2개 또는 1개를 기술할 수 있다.
//	   1개를 기술하면 이 정수 번째 이후의 데이터를 전부 가져온다.
//     0부터 시작한다.
//     2개를 기술하게 되면 앞 번호는 시작하는 인덱스가 되 뒤의 숫자는 데이터 갯수가 된다. 



package Web;

public class 필기0904 {

}
