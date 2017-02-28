--------------------------------------------------------
WHERE
--------------------------------------------------------
-- desc는 오라클에서만 사용할 수 있음. 

-- between a and b : a와 b사이의 값을 선택한다.(a, b는 포함)

-- 급여가 10000이상이고 15000이하인 사원의 정보를 출력
select *
  from employees
 where salary >= 10000 
   and salary <= 15000;
   
-- between 사용
-- 작은 것을 a에 쓰고 큰 것을 b에 쓴다   
select *
  from employees
 where salary between 10000 and 15000;

-- 사원의 부서가 90, 100, 110, 120, 130, 150에 소속된 사원의 정보를 출력
select *
  from employees
 where department_id = 90 
    or department_id = 100
    or department_id = 110
    or department_id = 130
    or department_id = 150;

-- IN 연산자 : 컬럼명 in (값,...)
-- 동일한 연산자를 사용하는 경우 in 사용

select *
  from employees
 where department_id in(90, 100, 110, 120, 130, 150);

select *
  from employees
 where (department_id between 90 and 150) and department_id != 140;

-- LIKE 연산자 : 컬럼명 like '패턴', 패턴 안에는 %(0개 이상의 문자), _(한 개 문자만 꼭 필수)

-- 사원의 이름이 L로 시작하는 사원 정보를 출력
select *
  from employees
 where last_name like 'L%';

-- 이메일이 D로 시작하고 T로 끝나는 사원의 정보
select *
  from employees
 where email like 'D%T';

-- 이름이 'King'인 사원의 정보를 출력
select *
  from employees
 where last_name = 'King';
 
-- 같은 이름을 찾을 때는 그냥 = 을 쓰면 됨ㅋㅋ 괜히 프로그램을 고생시킬 필요 없어. like는 패턴으로 찾을 때만 사용

-- IS NULL 연산자
-- null은 미정의 값
-- null과의 산술연산의 결과는 null
-- null과의 비교연산의 결과는 false

select last_name, salary, commission_pct
  from employees;
  
-- 커미션을 받지 않는 사원의 정보를 출력
select last_name, salary, commission_pct
  from employees
 where commission_pct = null;
-- null은 비교연산을 하면 무조건 false이기 때문에 값이 출력될 수 없음

select *
  from employees
 where commission_pct is null;

-- 커미션을 받는 사원의 정보를 출력
select *
  from employees
 where commission_pct is not null;
-
-- 사원의 연봉을 출력합니다.(이름, 급여, 연봉) 연봉은 급여 * 15 + 급여 * 15 * 커미션
select last_name, 
	   salary, 
	   salary * 15 + salary * 15 * nvl(commission_pct,0) as year_sal 
  from employees;

-- null과의 산술연산은 무조건 null
-- null에 값을 주는 nvl 함수 이용
-- nvl(컬럼명, 설정값)
-- nvl(commission_pct,0) : 만약 commission_pct가 null이라면 0을 대입하세요.  

  
--------------------------------------------------------
ORDER BY : ASC(오름차순), DESC(내림차순)
ORDER BY 표현식 | 컬럼명 [ASC(default : 생략가능) | DESC]
--------------------------------------------------------
-- order by는 항상 제일 마지막에 수행된다. 내가 원하는 순서대로 보여주기 위해서

-- 급여가 높은 사원부터 화면에 출력하시오.
  select last_name, salary
    from employees
order by salary desc;

-- 급여가 낮은 사원부터 화면에 출력하시오.
  select last_name, salary
    from employees
order by salary asc;
-- asc는 default 값이므로 생략 가능
  select last_name, salary
    from employees
order by salary;

-- 사원의 정보를 출력합니다(이름, 부서번호, 급여)
-- 단, 부서번호순으로 출력하시오.
  select last_name, department_id, salary
    from employees
order by department_id;
  
-- 사원의 정보를 출력합니다(이름, 부서번호, 급여)
-- 단, 부서번호순으로 출력하시오. 부서번호가 같은 사원들은 급여순으로 출력합니다.
  select last_name, department_id, salary
    from employees
order by department_id, salary;

-- 사원의 정보를 출력합니다(이름, 급여, 연봉)
-- 단, 연봉이 많은 사원부터 출력하시오
select last_name, 
	   salary, 
	   salary * 15 + salary * 15 * nvl(commission_pct,0) 
  from employees
order by salary * 15 + salary * 15 * nvl(commission_pct,0) desc;
-- 이렇게 쓰는 경우 쿼리문이 수정될 경우 오류가 발생할 가능성이 높음. select절의 쿼리만 수정하고 order by절은 생략할수도 

-- order by는 맨 마지막에 수행되기때문에 메모리에 올라온 컬럼의 이름을 접근해서 사용할 수 있으므로 alias명을 사용할 수 있다.
select last_name, 
	   salary, 
	   salary * 15 + salary * 15 * nvl(commission_pct,0) as year_sal 
  from employees
order by year_sal desc;
  
-- distinct : 중복된 결과를 제거  
select department_id
  from employees;

select distinct department_id
  from employees;

--------------------------------------------------------
GROUP BY: ASC(오름차순), DESC(내림차순)
GROUP BY 표현식 | 컬럼명 [ASC(default : 생략가능) | DESC]
GROUP BY : 데이터를 소그룹으로 묶는다.
통계 정보와 함께 쓰임.
그룹 함수 : 여러 개의 데이터를 받아서 하나의 결과를 반환
       : count(표현식 | 컬럼명), sum(표현식 | 컬럼명), max(표현식 | 컬럼명)
       : min(표현식 | 컬럼명), avg(표현식 | 컬럼명)
null값은 제외하고 실행함 (굳이 nvl로 일 시키지 말자)
--------------------------------------------------------
select count(last_name), sum(salary), max(salary), min(salary), avg(salary),
       sum(commission_pct)
  from employees;

-- 50번 부서의 사원들의 급여 중에서 가장 많은 급여가 얼마인지 출력
select max(salary)
  from employees
 where department_id = 50;

-- 전체가 대상이 아닌 대상을 여러 개로 쪼갤 때 group by 사용
-- max(salary)가 그룹 당 하나만 나올 수 있는 값이니까 같이 select할 수 있는 값도 하나만 나오면 같이 사용할 수 있어
-- (즉, group 함수를 쓰면 값이 하나만 출력되는 값을 선택할 수 있다)

-- 각 부서별 최대 급여를 화면에 출력합니다.
-- 최대급여가 10000이상인 부서를 대상으로
-- 단, 최대급여가 높은 부서부터 출력

select department_id, max(salary) max_sal
  from employees
 where max(salary) >= 10000 -- 오류 발생, 그룹함수는 grouping 된 후 사용 가능-> group과 관련된 조건을 처리하기위한 having
group by department_id
order by max_sal desc;

--------------------------------------------------------
HAVING : 그룹에 대한 제약을 처리한다. (조건)
--------------------------------------------------------

select department_id, max(salary) max_sal
  from employees
group by department_id
having max(salary) >= 10000
order by max_sal desc;

-- 부서별 평균 급여를 출력합니다.
-- 단, 100번보다 큰 부서는 제외하고 부서의 평균 급여가 5000 이상인 부서만 출력합니다.
-- 부서번호 순으로 출력합니다.

-- 100번보다 큰 부서 -> having 보다 where로 처리해서 범위를 줄여주는 것이 더 좋다

select department_id, avg(salary) avg_sal
from employees
where department_id < 100
group by department_id  
having avg(salary) >= 5000
order by department_id;

-- 실행순서
FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY
(전체 테이블 -> 부분 선택-> 그룹 나누기-> 그룹의 조건-> 필요한 정보 -> 순서대로 출력)

--------------------------------------------------------
내장함수 : DBMS에서 기본적으로 제공되는 함수(단일행, 그룹행) 
--------------------------------------------------------
단일행 - 문자, 숫자, 날짜, 변환형, 기타

-- 문자 함수 
-- 소문자: lower / 대문자: upper / 
-- concat : 첫번째 매개변수와 두번째 매개변수를 합친 것. 합성연산자와 같음(= ||)
select last_name, lower(last_name), upper(last_name), concat(last_name, '사원')
from employees;

-- 함수 간의 중첩된 사용이 가능함
-- () 안쪽에 있는 것부터 실행됨

select last_name, first_name, concat(upper(last_name), first_name)
from employees;

-- 자바의 SubString과 비교
String str = "hello";
str.substring(0,3)

-- substr(자를 컬럼, 위치, 크기)
select last_name, substr(last_name, 1, 2)
from employees;

select last_name,
       substr(last_name, 1, 2), 
       '20161229'
 from employees;

-- 2016 12 29 자르기
select last_name,
       substr(last_name, 1, 2), 
       '20161229'
       substr('20161229', 1, 4), 
       substr('20161229', 5, 2), 
       substr('20161229', 7, 2), 
 from employees;

-- length(컬럼명) : (컬럼명)의 길이값 반환
select last_name, length(last_name)
  from employees;

-- lpad: 왼쪽에 확보시켜서 출력하다 (컬럼명, 채울 공간, 채울 것)
-- rpad: 오른쪽에 확보시켜서 출력하다 (컬럼명, 채울 공간, 채울 것)

select last_name, length(last_name),
       lpad(last_name, 10, '*'), rpad(last_name, 10, '*')
  from employees;
  
-- replace: 단어 당 변화 ('AB'가 세트로 있어야 바꿈)
-- translate: 문자 당 변화('A'는 u로 'B'는 k로 바꿈)
select last_name,
       translate(last_name, 'AB', 'uk'),
       replace(last_name, 'AB', 'uk')
from employees;

-- 숫자형 함수
select 'a'
  from employees
 where department_id = 30;
-- employees의 30번 부서 내 행의 개수만큼 'a'가 수행

-- abs()는 절대값 반환 함수 
select abs(100), abs(-100)
  from employees
 where department_id = 30;
 
-- 범위 테이블 : 단순하게 결과를 확인하기 위해(테이블의 행의 개수만큼 보기에는 너무 비효율적)  
select abs(100), abs(-100)
  from dual;

-- 양수인지 음수인지 알아보기 위한 것: sign 양수 : 1, 0 : 0, 음수 : -1
-- 입력된 값보다 크거나 같으면서 가장 작은 정수 : ceil
-- 입력된 값보다 작거나 같으면서 가장 큰 정수 : floor
select ceil(1.1), floor(1.1), sign(0), sign(12)
  from dual;

-- 통계할 때 필수
-- 양수는 소수점을 오른쪽으로 이동하지만 음수는 소수점을 왼쪽으로 이동
-- round: 반올림/ trunc: 버림
-- 아무것도 안주면 정수값만
select round(73.727), round(73.727, 2), round(73.727, -2),
       trunc(73.727), trunc(73.727, 2), trunc(73.727, -2)
  from dual;

-- 날짜형 함수
-- dual: 한 번만 보기 위해서
-- sysdate : 현재 날짜 
select sysdate
from dual; 

-- add_months(날짜, 숫자)
select sysdate, add_months(sysdate,1), add_months(sysdate,-1)
from dual; 

-- 각 사원의 입사일로부터 1년이 되는 날짜를 출력하시오
select last_name, add_months(hire_date, 12)
from employees;


select last_name, trunc(months_between(sysdate, hire_date))
  from employees;
  
  
select sysdate, last_day(sysdate)
 from dual;

-- 날짜 + 숫자 = 날짜, 날짜 - 숫자 = 날짜, 날짜 - 날짜 = 숫자
-- 일별 단위를 구하기 위해서는 그냥 연산을 해주면 됨
 
select sysdate + 7, sysdate - 7, sysdate + 5/24
from dual;

-- 각 사원의 근무일수를 출력하시오
select last_name, trunc(sysdate - hire_date)
from employees;

-- 변환형 함수
-- to_date : 문자 -> 날짜

-- to_number : 문자 -> 숫자

-- to_char : 날짜 -> 문자 / 숫자 -> 문자

select to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss'),
       to_date('2016-12-31', 'yyyy-mm-dd')
      
insert into tb_board(no, title, writer, content, reg_date)
   values (4,'a', 'b', 'c', to_date('2016-12-30', 'yyyy-mm-dd'));

-- 자리수 표기로 보기 편하게 만들기
-- 패턴문자 : 9(자리수), 0(자리수 - 남는 자리에 0을 표시), ","
select to_char(1000000000,'999,999,999,999')
	   to_char(5000, '99,999') 
	   to_number('51,000', '99,999')
   from dual;
  
  
select * from tb_board;

-- 사원 중에서 5월에 입사한 사원들의 정보만 출력하세요
select *
  from employees
 where to_char(hire_date, 'mm') = '05';

-- 현재 월과 동일한 월에 입사한 사원의 정보를 출력하세요
select *
  from employees
 where to_char(hire_date, 'mm') = to_char(sysdate, 'mm');

-- 기타함수 : decode, case ~ end : 기본적인 통계 정보 추출 시 사용
-- decode : switch문 / case ~ end : if문
select job_id, decode(job_id, 'IT_PROG', '개발자'
                            , 'SA_MAN', '세일즈'
                            , '그냥 직원') as job_type

 from employees;

-- job_id의 직무가 IT_PROG라면 개발자라고, SA_MAN이라면 세일즈라고 나머지는 그냥직원이라고 출력하겠다
-- 즉, switch문의 case처럼 선택한 것. decode는 같다라는 비교 밖에 할 수 없고 범위는 비교 못했음
-- 버전이 업그레이드 되고 case ~ end가 생겨남(범위 비교도 가능!)
-- 하나의 case가 끝났어 하고 알려주는 게 end

select job_id, 
       case job_id when 'IT_PROG' then '개발자'
                   when 'SA_MAN'  then '세일즈'
                   else '그냥 직원' 
       end as job_type

 from employees;

-- 조건을 같다가 아닌 다른 방법으로 마음대로 줄 수 있는 방법
select job_id, 
       case when job_id = 'IT_PROG' then '개발자'
            when job_id = 'SA_MAN'  then '세일즈'
            else '그냥 직원' 
       end as job_type

 from employees;
 
-- 사원의 급여에 따라서 다음과 같이 출력하는 쿼리 작성 (사원이름, 급여, 말)
-- 급여가 10000 이상일 경우 "우후..."
-- 급여가 5000 이상일 경우 "아이..."
-- 급여가 5000 미만일 경우 "에이..."

select last_name, 
       salary, 
       case when salary >= 10000 then '우후...'
            when salary >= 5000 then '아이...'
            else '에이...' 
       end as comment_sal
  from employees;
  
