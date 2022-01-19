create table coffee2(
c_name varchar2(10 char) not null,
c_price number(4) not null
);

insert into coffee2 values('테스트', 1000);
insert into coffee2 values('테스트2', 1000);

select * from coffee2;