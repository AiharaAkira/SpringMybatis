create table building(
	b_floor number(2) primary key,
	b_shopName varchar2(20 char) not null
);

insert into building values (1, '로비');
insert into building values (2, '임대문의');
insert into building values (3, '헬스장');
insert into building values (4, '볼링장');
insert into building values (5, '학원');
insert into building values (6, '병원');

select * from building;