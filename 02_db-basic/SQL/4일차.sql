---------------------------------------------------------------------
시퀀스(sequence) : 고유번호 생성기
공용객체
어느 테이블에서나 시퀀스 사용이 가능함
일반적으로는 특정 테이블의 특정 컬럼에서 사용
---------------------------------------------------------------------
-- 시퀀스 생성하기
-- 생성 옵션을 설정하지 않은 경우
-- 시작 : 1, 증가 : 1 
create sequence s_board_no;
-- board 테이블에 있는 no 컬럼에서 사용하게 시퀀스를 만들었다는 의미로 쓰여짐
-- 공용이면 common을 주거나 다른 네이밍룰 사용

-- 생성된 시퀀스에서 고유번호 얻기 : nextVal(대소문자 상관X)
-- 시퀀스명.nextVal
select s_board_no.nextVal from dual;

-- 시퀀스 삭제하기
drop sequence s_board_no;

-- 시퀀스를 이용한 게시글 등록
insert into tb_board(no, title, writer, content)
values (s_board_no.nextVal, '제목', '글쓴이', '내용');
-- DB에서 관리하기 때문에 동시처리 가능. 숫자 중복 발생 x

select * 
from tb_board;

---------------------------------------------------------------------
alter : 테이블 변경
-- 컬럼 추가, 컬럼 삭제, 컬럼 변경(타입, 크기, default, not null)
-- add : 컬럼 추가시 사용
-- drop : 컬럼 삭제시 사용
-- modify : 컬럼 변경시 사용

alter table 테이블명
add (컬럼...)

alter table 테이블명
drop (컬럼...)

alter table 테이블명
modify (컬럼...)

9i부터 추가된 기능 : 컬럼의 이름 변경
alter table 테이블명
rename colume A to B;
---------------------------------------------------------------------
create table t_alter (
	nama varchar2(10),
	age  varchar2(3)
);

-- email 컬럼 추가
alter table t_alter
add (email varchar2(30)not null, 
     phone_num varchar2(11));

desc t_alter;
-- desc는 이클립스에서 실행 X

-- 컬럼 이름 변경
alter table t_alter
rename column nama to name;

-- email 컬럼 삭제
alter table t_alter
drop (email);
-- 삭제시 주의점 : 데이터가 많으면 지우는데 시간이 많이 걸리기 때문에 사용자들이 많이 사용하지 않는 시간에 실행
set unused column 컬러명
-- 운영할 때 삭제된 것처럼 없애고 싶으나 drop은 아니기 때문에 데이터에서는 빠지지 않고 테이블에서만 삭제한 것 
-- 후에 사용하지 않는 시간에 drop unused column을 통해 파일에서 삭제 

-- age 컬럼 타입 변경 (컬럼 선언과 동일하게 하면 됨)
alter table t_alter
modify (age number(3));

insert into t_alter (name, age)
values ('test', 22);

-- age 컬럼 크기 증가
alter table t_alter
modify (age number(5));

-- age 컬럼 크기 감소 : null인 경우만 가능
alter table t_alter
modify (age number(3));
-- 컬럼의 크기를 감소시킬 때에는 컬럼의 값이 비어있을 때만 가능
-- 오라클이 데이터를 개별적으로 몇 자리가 들어있는지 확인하지 않기 때문에 추후에 문제가 발생할 수 있으므로 막아둠


---------------------------------------------------------------------
트랜잭션 : transaction
하나의 트랜잭션 : 논리적으로 묶인 여러개의 dml(insert, update, delete) 작업들
---------------------------------------------------------------------

create table t_tran (
    id varchar2(3),
    msg varchar2(100)
);


SQL> select * from t_tran;

ID
------
MSG
--------------------------------------------------------------------------------

a
aaa


SQL> update t_tran set msg = 'bbb' where id = 'a';

1 행이 갱신되었습니다.

SQL> select * from t_tran;

ID
------
MSG
--------------------------------------------------------------------------------

a
bbb


SQL> commit;

커밋이 완료되었습니다.

SQL> select * from t_tran;

ID
------
MSG
--------------------------------------------------------------------------------

a
bbb


SQL> select * from t_tran;

ID
------
MSG
--------------------------------------------------------------------------------

a
ccc


SQL>
-- 이전 사용자가 완벽하게 처리하기 전까진 다른 사용자가 수정할 수 없다.
