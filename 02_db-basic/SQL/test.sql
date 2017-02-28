 create table tb_account (
      id varchar2(10),
      money number(8)
  );
  
  insert into tb_account(id, money) values ('a', 100000);
  insert into tb_account(id, money) values ('b', 200000);
  
  select *
  from tb_account;