---------------------------------------------------------------------
JOIN
---------------------------------------------------------------------
-- Cartesian Product 
   : 증거조건(연결조건)이 잘못되거나 의도적으로 조건을 주지 않은 경우 M * N 의 결과가 반환되는 조인

select last_name, department_name
from employees, departments;

select count(*)
from employees;     

select count(*)
from employees, departments;

select last_name, employees.department_id, department_name
from employees, departments
where employees.department_id = departments.department_id; 
-- 양쪽에 동일한 이름의 컬럼이 존재한다면 어느 테이블의 컬럼을 출력해야하는지 선택해주어야함
-- 한쪽에만 있다 하더라도 항상 소속을 써줘
select employees.last_name, employees.department_id, departments.department_name
from employees, departments
where employees.department_id = departments.department_id; 

-- Equijoin : 두 테이블 간의 컬럼 값들이 정확하게 일치하는 경우 사용

-- 테이블명에도 alias 사용 가능 (공백 + 이름(보통 한 글자 사용))
select e.last_name, 
       e.department_id, 
       d.department_name
from employees e, departments d
where e.department_id = d.department_id; 

-- 부서의 정보 + 도시명 출력하기
select d.department_id,
       d.department_name,
       l.city  
from departments d, locations l       
where d.location_id = l.location_id;

-- 하나의 테이블의 모든 정보 
select d.*,
       l.city  
from departments d, locations l       
where d.location_id = l.location_id;

-- 먼저 출력하고 싶은 정보 & 나머지 모든 정보
-- 동일한 컬럼이 두 번 나올 경우 먼저 출력하는 정보의 이름을 alias로 설정 
select e.salary as sal, e.*
from employees e;

-- Canada에 근무하는 사원의 지역명, 부서명, 사원명 출력하시오
select e.last_name, d.department_name, l.city
from employees e, departments d, locations l, countries c
where e.department_id = d.department_id
  and d.location_id = l.location_id
  and l.country_id = c.country_id 
  and c.country_name = 'Canada';
  
-- 각 사원의 job_id에 해당하는 최대 받을 수 있는 급여와 최소 급여가 얼마인지 출력하시오
select e.last_name, j.job_title, j.min_salary, j.max_salary
from jobs j, employees e
where j.job_id = e.job_id;

-- Oracle 9i부터 지원 (현재 사용하는 방식)
-- INNER JOIN : 증거조건은 on으로 일반조건은 where절에 

-- 테이블명에도 alias 사용 가능 (공백 + 이름(보통 한 글자 사용))
select e.last_name, 
       e.department_id, 
       d.department_name
  from employees e
 inner join departments d
    on e.department_id = d.department_id; 

-- Canada에 근무하는 사원의 지역명, 부서명, 사원명 출력하시오
select e.last_name, d.department_name, l.city
from employees e
inner join departments d
   on e.department_id = d.department_id
inner join locations l
   on d.location_id = l.location_id
inner join countries c
   on l.country_id = c.country_id 
where c.country_name = 'Canada';
  
-- 각 사원의 job_id에 해당하는 최대 받을 수 있는 급여와 최소 급여가 얼마인지 출력하시오
select e.last_name, j.job_title, j.min_salary, j.max_salary
from jobs j 
inner join employees e
on j.job_id = e.job_id;

-- Non-Equijoin : = 연산자 없이 두 테이블을 연결하는 경우
-- 사원의 급여와 급여 등급을 화면에 출력

select e.last_name, e.salary, s.grade
from employees e, salgrade s
where e.salary between s.min_sal and s.max_sal;

select e.last_name, e.salary, s.grade
from employees e
inner join salgrade s
 on e.salary between s.min_sal and s.max_sal;

 
-- SELF JOIN : 자신의 테이블을 연결
-- where manager_id = employee_id 라고 하면 불가능. 테이블은 줄 별로 비교하기 때문에 같은 값이 절대 나올 수 없다.
-- 따라서 별도의 테이블이 필요(사원 테이블 & 관리자 테이블). 똑같은 테이블을 하나 더 복사해서 a와 b로 나눔
-- a.employee_id = b.manager_id 
select e.last_name 사원명, m.last_name 관리자명
from employees e, employees m
where e.manager_id = m.employee_id;

select e.last_name 사원명, m.last_name 관리자명
from employees e
inner join employees m
on e.manager_id = m.employee_id;

-- OUTER JOIN : 조인 조건에 일치하지 않는데도 불구하고 출력하고 싶을 때 사용
-- 데이터의 수가 부족한 곳에 +를 줘서 null값으로 채워줌
select e.last_name 사원명, m.last_name 관리자명
from employees e, employees m
where e.manager_id = m.employee_id(+);

-- 관리자가 없는 사원은 "관리자 없음"을 출력한다.
select e.last_name 사원명, 
       case when m.last_name is null then '관리자 없음'
       		else m.last_name
       		end as 관리자명
from employees e, employees m
where e.manager_id = m.employee_id(+);

select e.last_name 사원명, 
       nvl(m.last_name,'관리자 없음') 관리자명
from employees e, employees m
where e.manager_id = m.employee_id(+);

-- [full | right | left ] outer join
-- full : 양쪽 다 채우기 (9i부터 지원)
-- right: 테이블 기준 left의 데이터가 모자란 경우
-- left : 테이블 기준 right의 데이터가 모자란 경우
-- right와 left는 모자란 곳의 반대쪽을 적어줘

select e.last_name 사원명, 
       nvl(m.last_name,'관리자 없음') 관리자명
from employees e
left outer join employees m
 on e.manager_id = m.employee_id;

---------------------------------------------------------------------
SET: 여러 개의 sql 연결 가능
형식: order by는 제일 마지막에 한 번만
---------------------------------------------------------------------
-- union all : 정렬 X, 중복 허용 O (통계 쪽에서 많이 사용함)
select no, data
from tc_seta
union all
select no, data
from tc_setb;

-- union: 중첩된 데이터는 한 번만 출력. 자동 정렬됨
select no, data
from tc_seta
union
select no, data
from tc_setb;

-- intersect : 교집합, 결과의 공통된 부분만을 출력
select no, data
from tc_seta
intersect
select no, data
from tc_setb;

-- minus : 차집합, 앞에서 뒤를 뺀 결과를 반환
select no, data
from tc_seta
minus
select no, data
from tc_setb;

-- 주의 1. 컬럼의 개수가 동일해야 한다. (틀리면 출력X)
select last_name, salary
from employees
union all
select department_name
from departments;

-- 주의 2. 동일한 열(=컬럼)의 위치에서는 데이터 타입이 같아야한다.
select last_name, salary
from employees
union all
select department_id, department_name
from departments;

-- 주의 3. order by절은 제일 마지막에 위치하여 문장을 끝내는 역할을 한다. (사용X)
select last_name, salary
from employees
order by last_name
union all
select department_name, department_id
from departments;

-- 주의 4. 컬럼명은 첫번째 SQL문의 컬럼명이 사용된다. 
select 'data', last_name, salary
from employees
union all
select 'total', department_name, department_id
from departments;


---------------------------------------------------------------------
SubQuery : 쿼리 내에 포함된 쿼리. ()를 묶어 구분짓는다.
-- optimizer 최적의 쿼리 실행 계획. 시간이 오래 걸리는 부분을 튜닝할 수 있음
---------------------------------------------------------------------
select avg(salary)
from employees
where department_id = 10;

-- Chen 사원과 같은 부서에 있는 사원들의 평균 급여를 출력하시오
select avg(salary)
from employees
where department_id = Chen 사원의 부서번호;

-- Chen 사원의 부서번호를 출력하시오
select department_id
from employees
where last_name = 'Chen';

-- SubQuery의 결과행이 하나인 경우 : 스칼라 서브쿼리, Single Row SubQuery
select avg(salary)
from employees
where department_id = (select department_id
                         from employees
                         where last_name = 'Chen');
                         
-- King 사원과 같은 부서에 있는 사원들의 평균 급여를 출력하시오                       
select avg(salary)
from employees
where department_id = (select department_id
                         from employees
                        where last_name = 'King'); 
-- King이 두 명이어서 결과값이 두 개가 반환되어 오류 발생

-- SubQuery의 결과행이 여러개인 경우 : Multi Row SubQuery
-- Multi Row SubQuery일 경우에는 관련된 연산자를 사용
-- [in | all | any]

-- 결과값이 하나 이상이므로 = 이 아닌 여러 개의 결과를 받을 수 있는 연산자인 "in"을 사용
select avg(salary)
from employees
where department_id in (select department_id
                         from employees
                        where last_name = 'King');
-- 출력 : 사원의 정보 
-- 집합 : employees
-- 조건 : 30번 부서의 평균 급여보다 급여를 많이 받는
select avg(salary)
from employees
where department_id = 30

-- 30번 부서의 평균 급여보다 급여를 많이 받는 사원의 정보를 출력
select *
from employees
where salary > (select avg(salary)
                from employees
                where department_id = 30);

-- 30번 부서의 사원들이 받는 급여보다 급여를 많이 받는 사원의 정보를 출력
select *
from employees
where salary > (select max(salary)
                from employees
                where department_id = 30);

-- ALL : subquery의 모든 결과를 만족
-- max(salary)와 같은 결과 출력
select *
from employees
where salary > ALL (select salary
                	from employees
                	where department_id = 30);
                	
-- ANY : subquery의 결과 중 하나만 만족
-- min(salary)와 같은 결과 출력
select *
from employees
where salary > ANY (select salary
                	from employees
                	where department_id = 30);
                
-- 각 부서에서 가장 작은 급여를 받는 사원의 정보를 출력하시오
select department_id, last_name, salary
from employees
where salary in (select min(salary)
                  from employees
                 group by department_id);
                 

-- 내가 속한 부서 번호까지 같이 넘겨야함             
-- Multi Column SubQuery : 서브쿼리의 결과가 여러개의 컬럼이 반환됨   
select department_id, last_name, salary
from employees
where (department_id, salary) in (select department_id, min(salary)
        					        from employees
                 				group by department_id);
                 				

-- 서브쿼리는 sql문 어디에나 쓸 수 있다
-- 서브쿼리가 사용되는 다양한 위치
-- insert into 절에서의 SubQuery
insert into tb_board(
	no, 
	title, 
	writer, 
	content
) values (
	 (select max(no) + 1 from tb_board), 
	 't', 
	 'w', 
	 'c'
);

-- join을 subquery로 바꾸기
select e.last_name, 
       e.department_id, 
       (select department_name
          from departments
         where department_id = e.department_id) as department_name
  from employees e;
-- subquery안의 where절에서 e.department_id가 각 사원의 부서번호에 맞게 상수값으로 바뀐다. 
-- where department_id = 30

-----------------------------------------------------------------------  
-- rownum의 이해
-- 오라클에서 자체적으로 제공해주는 컬럼. 자동으로 숫자값을 1씩 증가시키며 넘겨줌
-----------------------------------------------------------------------  
select rownum, last_name, salary
from employees;

select rownum, last_name, salary
from employees
where rownum < 5;

-- rownum은 = 을 사용할 경우 1번을 제외하면 출력되지 않는다.
-- 왜? rownum은 빠져나와야 증가되니까! 1번이 출력되지 않았으니까 rownum도 증가할 수 없어

select rownum, last_name, salary
from employees
where rownum = 4;

-- 사원 중에서 급여를 많이 받는 상위 5명을 출력하시오

-- 실행순서가 from -> where 기 때문에 급여 순의 순서가 아닌 그냥 순서 상의 5명이 출력된 것이기 때문에 오류
-- from절에서 정렬을 시켜야해
select last_name, salary
from employees
where rownum < 6
order by salary desc;

-- from 절에서의 SubQuery : Inline View
-- 물리적으로 있는 데이터에서 잠깐 동안 사용할 수 있는 뷰
select last_name, salary
from (select *
        from employees
       order by salary desc)
where rownum < 6;

  
-- Top-N 서브쿼리

-- 전체 데이터에서 일부분만 가져오려고 하는 쿼리 : 페이징 쿼리  - 게시판에서 활용
-- rownum의 이름을 임의의 이름으로 변경한 다음 부분범위 가져오기 

select *
from(select rownum rnum, last_name, salary
      from (select * 
             from employees
            order by salary desc))
where rnum between 10 and 20;
        
-- 서브쿼리를 이용한 테이블 생성
-- 기존의 employees와 동일한 테이블 만들기
create table employees_copy
as
select * from employees;
  
select *
 from employees_copy;
 
drop table employees_copy;
  
-- 서브쿼리를 이용한 테이블 생성
-- 기존의 employees와 동일한 테이블 구조! 만들기  
-- where절이 false면 select절이 데이터를 가져오지 않는다.
-- 무조건 참을 만드려면 where 1 = 1
create table employees_copy
as
select * from employees
where 1 != 1;

-- 테이블에 데이터를 서브쿼리를 이용해서 입력하기
insert into employees_copy
select * from employees
where last_name = 'King';
  
  
  
  

