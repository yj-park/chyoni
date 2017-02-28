create table tb_sticky(
	id	number primary key,
	pos_x number,
	pos_y number,
	content varchar2(4000)
);

create sequence seq_sticky_id;
