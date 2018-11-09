--1
select p.* from product p inner join type t on p.type_id = t.id
where t.name = 'МОЛОКО'

--2
select * from product where name like '%мороженное%'

--3
select * from product where date_part('month', expired_date) = date_part('month', now())

--4
select * from product where price in (select max(price) from product)

--5
select count(*) from product where type_id=2

--6
select * from product p inner join type t on p.type_id = t.id
where t.name in ('СЫР', 'МОЛОКО')


select p.type_id, count(p.id) from product p
group by p.type_id

--7
select t.name, count(p.id) from product p inner join type t on p.type_id = t.id
group by t.name having count(p.id)<10

--8
select p.*, t.name as type from product p inner join type t on p.type_id = t.id