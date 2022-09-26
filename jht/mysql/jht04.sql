#课堂练习
##创建一门课程表
drop table if exists course;
create table course
(
    id            bigint       not null auto_increment comment '自增id',
    name          varchar(100) not null comment '课程名称',
    created_time  datetime default CURRENT_TIMESTAMP comment '创建时间',
    modified_time datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
    primary key (id)
) engine = InnoDB
  character set utf8mb4;
##向表中插入一些课程信息
insert into course (name)
values ('MySQL'),
       ('Oracle'),
       ('DB2');
insert into course (name)
values ('MySQL'),
       ('Oracle'),
       ('DB2');
insert into course (name)
values ('MySQL'),
       ('Oracle'),
       ('DB2');
select *
from course;
##删除表中课程名重复的记录？
# explain
# 1)
DELETE c1
FROM course c1
         INNER JOIN course c2
WHERE c1.id > c2.id
  AND c1.name = c2.name;

# 2)mysql8.x
delete c1
FROM course c1
WHERE c1.id <> (
    select tb.max_id
    from (select max(c2.id) max_id
          from course c2
          where c1.name = c2.name) tb
);
# 3)
delete
from course
where id not in (
    select dt.id
    from (select min(id) as id
          from course
          group by name) dt);
# 4)
delete
from course
where id not in (
    select min_id
    from (select min(id) as min_id
          from course
          group by name
          having count(*) > 1
         ) as x
);


# 5)方案5适合mariadb(MySQL不成功，mysql中不允许在查询当前表数据时，对数据进行更新操作)
# delete
# from course
# where id not in (
#     select max(id)
#     from course
#     group by name
# );

# delete
# from course c
# where c.id <> 1;


# 视图
drop table if exists score;
create table score(
                      sid bigint comment '学生id',
                      cid bigint comment '课程id',
                      score int comment '成绩',
                      primary key (sid,cid)
)engine = InnoDB;;
insert into score(sid,cid,score)values (1,112,89);

CREATE VIEW score_view as
select st.name student_name,co.name course_name,sc.score
from student st join score sc on st.id=sc.sid
                join course co on sc.cid=co.id
where st.name='Jack' and co.name='mysql';
select * from score_view;

# 事务回滚，事务控制
set autocommit =0;
start transaction;
insert into student(name,phone,class_id) values ('Jack','1115',1);
savepoint p1;
insert into student(name,phone,class_id) values ('Jason','1116',1);
insert into student(name,phone,class_id) values ('Mike','1117',1);
rollback to p1;
commit;

