create table menu01(
	m_no number(4) primary key,
	m_name varchar2(20 char) not null,
	m_price number(6) not null
);

create sequence menu01_seq;

insert into menu01 values(menu01_seq.nextval, '테스트', 1000);

select * from menu01;