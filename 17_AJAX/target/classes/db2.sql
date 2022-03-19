create table menu2(
m_name varchar2(10 char) primary key,
m_price number(5) not null
);

insert into MENU2 values ('테스트', 1000);
insert into MENU2 values ('테스트2', 2000);
insert into MENU2 values ('테스트3', 3000);
insert into MENU2 values ('테스트4', 4000);
insert into MENU2 values ('테스트5', 5000);

select * from menu2;