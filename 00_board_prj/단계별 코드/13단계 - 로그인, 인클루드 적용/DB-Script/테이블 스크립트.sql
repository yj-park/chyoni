create table tb_user (
	user_id varchar2(20) primary key,
	password varchar2(20) not null,
	email varchar2(100)
);

insert into tb_user(user_id, password, email) values('a', '1', 'a@a.com');

create table tb_board_file (
	file_no number(6) primary key,
	no number(6) not null,
	ori_name varchar2(100) not null,
	system_name varchar2(100) not null,
	file_path varchar2(50) not null,
	file_size number not null
);

create sequence s_board_file_no;




