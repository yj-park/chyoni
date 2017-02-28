-- 현재 사용자의 전체 테이블 목록 보기 (HR유저의 테이블 목록)
select *
  from tab;

select * from tb_user;
 
-- create: 테이블 생성하기
-- 테이블명, 컬럼명은 내부적으로 대문자로 관리됨.(별도의 대소문자 구분 처리가 없는 경우 - ex: "aaa")
create table 테이블명 (
	컬럼명 타입(크기), 
	컬럼명 타입(크기)
);
create Table Member - > 내부적으로 MEMBER로 표시됨
테이블명 규칙 -> t_앞에 붙이거나 tb_, tc_(공통의 테이블인 경우 테이블의 역할 표시), ...
 		  -> 단어와 단어 사이는 _(언더바)로 활용
 		  -> 단어의 약어(3~4자)를 사용

게시판을 표현하는 테이블 생성 스크립트(SQL) 작성하기
참고 : BoardVO 클래스

create table tb_board (
	no number(6),
	title varchar2(200),
	writer varchar2(30),
	content varchar2(4000),
	reg_date date
);

-- drop: 테이블 삭제
drop table tb_board;

BIN$LrBN+xolSZ+4w5uYU4FYog==$0	TABLE	- drop하면 이렇게 휴지통에 쌓임
purge recyclebin; : 휴지통 비우기
휴지통에서 지우면 살릴 수 없음. 끝!
다시만들게

★(검색필수!! 개인공부필수!)
-- 제약조건 : 테이블레벨 제약조건- 모든 컬럼의 선언이 끝난 후 맨 밑에 / 컬럼레벨 제약조건 - 컬럼 선언시 테이블 옆에
         : 제약조건 이름 설정(사용자 정의) - constraint 이름 (이름을 설정하지 않으면 시스템이 자동 설정)
			create table 테이블명 (
				컬럼명 타입(크기) 제약조건(컬럼레벨), 
				컬럼명 타입(크기),
				컬럼명 타입(크기) default 값,
				제약조건...(테이블레벨)
			);
-- 1.PK : Primary Key
	하나의 테이블에 무조건 하나의 키만 존재. 기본키.고유키. 테이블을 구분할 수 있는 키 (ex: no). 여러 개의 컬럼을 합쳐서 만들 수 있음(합쳐서 만든 값이 고유하고 NULL이 아니면 다 가능)
	제약조건 두 가지를 합친 의미. unique + not null
-- 2.UNIQUE 
	테이블 내 값은 고유해야한다. (null허용) 중복허용 X
-- 3.NN : NOT NULL
	null값을 허용하지 않는다. 무조건 값이 입력되어야함
-- 4.FK : FOREIGN KEY
	다른 테이블 또는 자기 자신의 다른 컬럼 값을 참조. 외래키.
-- 5.CK : CHECK
	값의 입력시 제약 설정 (ex: 성별 입력시 F or M 말고 안돼 설정)
-- 주의 : 여러 개의 컬럼을 묶어서 제약조건을 설정하려면 테이블레벨을 이용해야함.

-- default : 값이 입력되지 않은 경우 기본으로 값을 설정함. 항상 똑같은 값이 들어가야할 때 사용

-- sysdate : 현재 시간 정보를 반환하는 함수.

create table tb_board (
	no number(6) constraint pk_no(사용자가 이름을 직접 정의한 제약조건) primary key,
	title varchar2(200) not null,
	writer varchar2(30) not null,
	content varchar2(4000) not null,
	reg_date date default sysdate
);

-- 테이블명 변경하기
RENAME A(원래 테이블명) TO B(변경할 테이블명);

RENAME TB_BOARD TO BOARD_TB;

-- 생성된 테이블의 구조 살펴보기
DESCRIBE 테이블명; 
DESC 테이블명;

DESC TB_BOARD;

create table tb_board (
	no number(6) NOT NULL,
	title varchar2(200) not null,
	writer varchar2(30) not null,
	content varchar2(4000) not null,
	reg_date date default sysdate,
	primary key(NO, TITLE),
);

-- INSERT : 데이터 입력하기 
-- 입력시 주의점 : 문자를 입력할 때는 반드시 '으로 묶는다.
insert into tb_board(no, title, writer, content, reg_date)
values(1, '제목', '글쓴이', '내용', sysdate);

-- 데이터 확인하기
select *
  from tb_board;

insert into tb_board(no, title, writer, content)
values(2, '제목2', '글쓴이2', '내용2');
-- 날짜는 default로 설정되어있어서 없어도 찍힘

insert into tb_board(no, title, writer, content)
values(2, '제목2', '글쓴이2', '내용2');
-- no컬럼은 primary key로 설정되었기 때문에 중복된 데이터는 허용하지 않는다.

insert into tb_board(no, title, writer)
values(3, '제목3', '글쓴이3');
-- not null 제약조건에 의해 오류남

insert into tb_board
values(3, '제목3', '글쓴이3', '내용3', sysdate);
-- 컬럼명이 별도로 성정되지 않은 경우 기준점이 없으므로 전부 다 입력하라는 걸로 해석 가능. 가독성이 나쁘고 데이터의 순서를 내가 외워서 쓰기가 힘들기때문에 권장 X

-- truncate : 복구 불가능 데이터 삭제
truncate table tb_board;

-- update : 데이터 수정
update 테이블명
   set 컬럼 = 변경할 값
   	   [,컬럼 = 변경할 값]
[조건절 (where)] 

-- 1번 게시물의 내용을 "추운날"로 변경합니다.
update tb_board
   set content = '추운날'
where no = 1;

-- 2번 게시물의 제목을 "본차로드"로 내용을 "느끼"로 변경합니다.
update tb_board
   set title = '본차로드',
       content = '느끼'
where no = 2;

-- delete : 데이터 삭제
delete
  from 테이블명
[조건절 (where)] 

-- 2번 게시물 삭제하는 쿼리 작성
delete 
  from tb_board
where no = 2;  

-- rollback : delete한 게시물 복구하기 (but 가능한 시점이 정해져있음) / truncate로 지운 데이터는 복구할 수 없다.

==================================================================================
SELECT절
==================================================================================
-- 전체 컬럼 조회
select *           컬럼명
  from tb_board;  테이블명

-- 특정 컬럼 조회
select no, title, writer          
  from tb_board;
  
-- 저장된 컬럼 조회하기 (만약 없으면 desc로 employees 테이블 검색해보기)
select employee_id, first_name
  from employees;  

-- 산술 연산자 사용
-- 사원의 연봉을 출력하시오 (연봉 : 급여 * 15)
select last_name, salary, salary * 15
  from employees;

-- 컬럼의 별칭(alias)사용 : 컬럼(공백)별칭, 컬럼 as 별칭 
    컬럼의 이름이 길어지는 경우가 많기 때문에 화면에 나타나는 컬럼의 이름을 바꾸는 alias를 자주 사용한다.
    공백이나 특수문자를 쓰고 싶다면 ""을 사용한다.(권장X)
select last_name 이름, salary as 급여, salary * 15 "연 봉"
  from employees;

-- 합성 연산자(||) : 자바에서의 "+" 역할
ex) 자바
String name = "홍";
int age = 29;

String msg = name + "님의 나이는" + age + "입니다.";

-- ???사원의 급여는 ???입니다.
사원정보 : employees
출력컬럼: last_name, salary

select last_name || '사원의 급여는' || salary || '입니다' 
  from employees;
  
-- 컬럼 별칭 바꾸기  
select last_name || '사원의 급여는' || salary || '입니다' 사원정보
  from employees;

==================================================================================
WHERE절
==================================================================================
-- select/from/where 절에 필요한 부분 생각하는 연습하기

-- 사원 중에서 급여가 10000 이상인 사원의 정보를 출력하시오
select *
  from employees
 where salary >= 10000;
 
-- 사원 정보를 출력합니다. 단, 100번 부서가 아닌 사원들만 출력합니다.
 select *
   from employees
  where department_id != 100;
  
-- Last_name이 'King'인 사원의 정보를 출력  
-- 주의사항 : sql은 대소문자가 무관하지만 문자열 내의 값은 대소문자는 비교가 되므로 주의해야할 것!
select *
  from employees
 where last_name = 'King';
 
-- 사원의 부서가 100번 부서이면서 급여가 10000이상인 사원의 정보를 출력하시오
 select *
   from employees
  where department_id = 100 and salary >= 10000;

-- 사원의 부서가 100번 또는 90번인 사원의 정보를 출력하시오
 select *
   from employees
  where department_id = 90 or department_id = 100;
  
-- 사원의 부서가 100번 또는 90번에 포함되어 있으면서 급여가 10000 이상인 사원의 정보를 출력하시오
-- 연산에도 우선순위가 있어! and가 더 높음 
select *
  from employees
 where (department_id = 90 or department_id = 100) and salary >= 10000;

-- 급여가 10000이상인 사원의 수 
select count(*)
  from employees
 where salary >= 10000;