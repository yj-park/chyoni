create table tb_user (
	user_id varchar2(20) primary key,
	password varchar2(20) not null,
	email varchar2(100)
);

create table tb_board_file (
	-- 파일 고유 번호. 시퀀스로
	file_no number(6) primary key,
    -- 게시판에 있는 번호를 쓸거야. 컬럼명 똑같이. foreign key가 좋지만 일단 넘어가자.
	no number(6) not null,
	-- 사용자가 업로드한 파일명
	ori_name varchar2(100) not null,
	-- 실제 서버에 저장된 네임
	system_name varchar2(100) not null,
	-- 업로드 폴더 제외한 경로
	file_path varchar2(50) not null,
	-- 파일 사이즈
	file_size number not null
	-- 파일 등록 시간 등 추가 가능
);

-- 파일 고유 번호 시퀀스 생성
create sequence s_board_file_no;

-- 댓글 테이블 생성
create table tb_board_comment (
	id varchar2(20) not null,
	no number(6) not null,
	comments varchar2(2000) not null,
	comments_no number(6) primary key,
	reg_date date
);

-- 댓글 고유 번호 시퀀스 생성
create sequence s_board_comment_no;


-- 새로운 댓글 테이블
create table tb_board_comment (
	comment_no number(6) primary key,
	no number(6) not null,
	content varchar2(200) not null,
	user_id varchar2(20) not null,
	reg_date date default sysdate
);

drop table tb_board_comment;

select * from tb_board_comment;
drop table tb_board_comment;

delete from TB_BOARD_COMMENT;

insert into TB_BOARD_COMMENT(id, no, comments, comments_no, reg_date)
     values('root', 182, 'd', s_board_comment_no.nextval, sysdate);