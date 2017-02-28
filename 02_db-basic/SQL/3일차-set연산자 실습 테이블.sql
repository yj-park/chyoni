create table tc_seta (
    no number,
    data varchar2(2)
);

create table tc_setb (
    no number,
    data varchar2(2)
);

insert into tc_seta values(1, 'a');
insert into tc_seta values(2, 'b');
insert into tc_seta values(3, 'c');
insert into tc_seta values(4, 'd');

insert into tc_setb values(3, 'c');
insert into tc_setb values(4, 'd');
insert into tc_setb values(5, 'e');
insert into tc_setb values(6, 'f');

select *
 from tc_seta;


 
