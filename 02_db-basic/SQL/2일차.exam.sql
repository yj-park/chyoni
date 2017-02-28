select *
  from s_emp;

1. 
select name, title, salary
from s_emp
where dept_id in (112,118)
group by name, title, salary
having title = '과장' or title = '사원'
   and salary between 1500 and 4000
order by salary desc;
 
2. 
select name, title, salary
from s_emp
where manager_id is null;

3.
select name, title, salary
from s_emp
where title like '%부장' and salary >= 3000;

4. 
select name, title, salary
from s_emp
where dept_id in (112,113,117,118)
group by name, title, salary
having title like '%부장' or title = '과장'
     and salary between 2300 and 3000;
     
5.
select name, title, salary, start_date
from s_emp
where to_char(start_date, 'mm') = '03'
group by name, title, salary, start_date
having title like '%부장' or title = '과장';

6. 
select name, (salary * 16) + 1000 as sal
from s_emp;

7.
select name||' '|| title || '의 급여 ' || salary as 직원급여
from s_emp;

8.
select name
from s_emp
where commission_pct is not null
  and manager_id is not null;

9.
select dept_id, min(salary) min_sal
from s_emp
group by dept_id
order by dept_id;

10. 
select title, min(salary) min_sal
from s_emp
group by title
having title not like '%부장'
order by min_sal;

11.
select title, avg(salary) avg_sal
from s_emp
group by title
order by avg_sal;

12.
select title, count(name) member
from s_emp
group by title;

13. 
select title, max(salary) max_sal
from s_emp
group by title
having max(salary) >= 2000;

14.
select title, min(salary) min_sal
from s_emp
group by title
having title not like '%부장'
order by min_sal desc;

15.
select title, avg(salary) avg_sal
from s_emp
group by title
having title != '사원'
order by avg_sal;

16.
select title, sum(salary) sum_sal
from s_emp
group by title
having title != '사원' 
   and sum(salary) >= 2000
order by sum_sal desc;

17.
select name, upper(substr(mailid, 1, 1)) || lower(substr(mailid, 2, length(mailid))) as email
from s_emp;

18. 
select name
from s_emp
where name like '___%';

19. 
select name, trunc(months_between(sysdate, start_date)) * salary sum_sal
from s_emp;

20.
select name 사원명, 
       case when to_char(commission_pct) is null then '커미션 없음' 
            else to_char(commission_pct)
       end as 커미션
from s_emp;

select *
from s_emp;

21.
select name 사원명 , 
       case when title like '%과장%' then salary * 1.2 
            else salary * 1.1
       end as 월급
from s_emp;

22.
select name 사원명, salary 급여,
       rpad('*', (salary / 100), '*') 급여표시
from s_emp;

23.
select department_id 부서번호,
       case when title = '사원' then 
from s_emp
where 
group by department_id
having
order by department_id;
