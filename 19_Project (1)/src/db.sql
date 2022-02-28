create table pj_member(
m_id varchar2(20 char) primary key,
m_pw varchar2(30 char) not null,
m_name varchar2(20 char) not null,
m_addr varchar2(100 char) not null,
m_photo varchar2(200 char) not null
)


insert into pj_member values('mz', '1', '1', '1', '1');
insert into pj_member values('js', '1', '2', '2', '2');

select * from pj_member;

delete pj_member;


-------------------------------------------------------
-- 컨셉 차이
		-- 나중에 걸꺼면 위배사항 있는지 확인 (주의사항)
alter table pj_sns
add constraint fk_s_owner
foreign key(s_owner)
references pj_member(m_id)
on delete cascade;

delete pj_sns

create table pj_sns(
s_no number(5) primary key,
s_owner varchar2(20 char) not null,
s_txt varchar2(300 char) not null,
s_date date not null

)
select * from pj_sns, pj_member
where s_owner = m_id and s_txt like '%%';


create sequence pj_sns_seq;

select * from pj_sns;

insert into PJ_SNS values (pj_sns_seq.nextval, 'mz', 'text~!', sysdate);

insert into PJ_SNS values (200, 'mz', 'text~!', sysdate);
insert into PJ_SNS values (201, 'mz', 'text~!asdasd', sysdate);
insert into PJ_SNS values (202, 'js', 'text~!djiaosdjioj3', sysdate);
insert into PJ_SNS values (203, 'js', 'text~!asdasd', sysdate);

insert into pj_sns_reply values (100, 200, 'js', 'sdsdokdskodsko', sysdate)
insert into pj_sns_reply values (101, 200, 'dh', '나 두현', sysdate)
insert into pj_sns_reply values (102, 202, 'hn', '나 하늬', sysdate)


create table pj_sns_reply(
	r_no number(5) primary key, 		
	r_s_no number(5) not null,		-- 소속된 글번호
	r_owner varchar2(10 char) not null,
	r_txt varchar2(100 char) not null,
	r_when date not null,
	constraint s_r
		foreign key(r_s_no)
		references pj_sns(s_no)
		on delete cascade
);

delete pj_sns_reply

create sequence pj_sns_reply_seq;

------------------------------------------------


create table pj_dataroom(
	d_no number(5) primary key, 			
	d_owner varchar2(10 char) not null,
	d_title varchar2(25 char) not null, 
	d_file varchar2(200 char) not null,
	d_category char(6 char) not null
);

create sequence pj_dataroom_seq;
select * from pj_dataroom;


------------------------------------------------

create table pj_gallery(
	g_no number(5) primary key, 			
	g_owner varchar2(10 char) not null,
	g_title varchar2(25 char) not null, 
	g_file varchar2(200 char) not null
);

create sequence pj_gallery_seq;

delete PJ_GALLERY;


---------------------------------------------------
create table pj_community(
	c_no number(5) primary key,
	c_from varchar2(10 char) not null,
	c_to varchar2(10 char) not null,
	c_txt varchar2(200 char) not null,
	c_when date not null
);
create sequence pj_community_seq;








