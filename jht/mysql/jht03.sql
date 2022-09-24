-- use hr;
-- 1)
select first_name,salary
from employees
where employee_id=(
    select manager_id
    from employees
    where employee_id=206
);

select m.first_name,m.salary
from employees e join employees m
                      on e.manager_id=m.employee_id
where e.employee_id=206;
-- ----------2)
select first_name,
       salary,
       (case
            when salary > 10000 then '偏高'
            when salary > 8000 then '中等'
            else '偏低' end) level
from employees;

-- 3)统计每个岗位雇员人数
select job_id, count(*) as '工作岗位人数'
from employees
group by job_id
order by 2 desc ;
--   ---------4)


select sum(case when salary>=10000 then '1' end ) '工资大于10000',
       sum(case when salary<10000 then '1' end) '工资低于10000'
from employees;

select count(*) as '人数',
       (IF(salary >= 10000, '大于等于10000', '小于10000')) level
from employees
group by level;


-- ---------5)
select e.first_name,d.department_name,l.city
from employees e
left join departments d on d.department_id = e.department_id
join locations l on d.location_id = l.location_id;
-- ---6) explain--type-- 使用索引优化查询
explain
select employee_id,
       first_name,
       last_name,
       email,
       phone_number,
       hire_date,
       job_id,
       salary,
       commission_pct,
       manager_id,
       department_id
from employees
order by employee_id
limit 10,10;

explain
select e2.*
from (select employee_id
      from employees
      order by employee_id
      limit 10,10) e1
         join employees e2
              on e1.employee_id = e2.employee_id;
-- ---------
show index from employees;

create index index_salary on employees(salary); -- 创建索引
-- 7)查询每年入职人数YEAR()--索引优化
explain
select count(*), YEAR(hire_date)
from employees
group by YEAR(hire_date);
-- mysql8 创建year()函数索引--
alter table employees add index index_year_salary((year(hire_date)));

-- 删除索引
alter table employees drop index index_year_salary;
drop index index_year_salary on employees;
--  使用索引查询year()
explain
select count(*), YEAR(hire_date)
from employees
group by YEAR(hire_date);


-- -mysql mysql -u nick -p root -h 192.168.5.116

--
--   ---8)创建enum ,set,json 类型数据
drop table if exists enum_set_json;
create table enum_set_json (
    id int primary key AUTO_INCREMENT,
    sex enum('男','女','未知'),
    age set('值1','值2','值3','值4'),
    info json
);
insert into enum_set_json(sex, age, info)
values ('男', '值1',
        '{
          "sex": 1,
          "age": 18,
          "nick_name": "小明"
        }');
insert into enum_set_json(sex, age, info)
values ('女', '值3,值4',
        '{
          "sex": 2,
          "age": 20,
          "nick_name": "小红",
          "tag": [3, 5, 90]
        }');
select id, sex, age, info
from enum_set_json;
-- JSON_EXTRACT(json列 , '$.键')
select JSON_EXTRACT(info, '$.sex'), info -> '$.age', info -> '$.nick_name', info -> '$.tag[1]'
from enum_set_json;
-- JSON_UNQUOTE 去除双引号 或者 使用操作符->>
select JSON_UNQUOTE(info -> '$.nick_name') name1,info ->> '$.nick_name' name2
from enum_set_json;

-- ----------9)
drop table if exists class;
drop table if exists student;
create table class
(
    id   bigint not null auto_increment comment '班级id',
    name varchar(50) not null comment '班级名称',
    primary key (id)
) engine = InnoDB
  character set utf8mb4;

create table student
(
    id       bigint      not null auto_increment comment '学生id',
    name     varchar(50) not null comment '学生名',
    phone    varchar(50) default '' comment '手机号',
    class_id bigint comment '班级id',
    unique (phone),
    primary key (id)
) engine = InnoDB
  character set utf8mb4;
insert into class values(1,'1');
insert into student values(null,'小明','16605523478',1);
-- 添加外键
alter table student add foreign key (class_id) references class(id);
-- 无法删除,存在外键约束
-- Cannot delete or update a parent row: a foreign key constraint fails (`hr`.`student`, CONSTRAINT `student_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`))
delete from class where id=1;

--
-- -------
select now();
select year(now());
select version();
-- 查看字符集
show variables like '%collation%';
-- 删除数据库如果存在
drop database if exists dbtest;
-- 创建数据库并指定字符集(会默认指定一些字符的排序规则)
create database if not exists dbtest
 default character set utf8mb4 collate utf8mb4_unicode_ci;
show create database dbtest;

-- help语法
help 'char';
help 'text';
help 'varchar';
help 'create database';
help 'functions';
help 'Date and Time Functions';
help 'YEAR';

-- MyISAM InnoDB 区别
show engines;

show variables like 'datadir';