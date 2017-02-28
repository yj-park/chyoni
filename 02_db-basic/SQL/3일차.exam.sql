
-- 문제 1
select e.job_id, max(salary), min(salary)
from employees e, jobs j
where e.job_id = j.job_id
 group by job_id
having job_id like 'SA_%'; 

-- 문제 2
select e.job_id, j.max_salary
from employees e
inner join jobs j
on e.job_id = j.job_id
order by j.max_salary desc;

-- 문제 3



select *
from jobs;