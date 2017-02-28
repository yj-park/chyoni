create table salgrade (
    grade char(1),
    min_sal number(6),
    max_sal number(6)
);

insert into salgrade values ('1', 20000, 100000);
insert into salgrade values ('2', 10000, 19999);
insert into salgrade values ('3', 6000, 9999);
insert into salgrade values ('4', 3000, 5999);
insert into salgrade values ('5', 1, 2999);

select *
 from salgrade;