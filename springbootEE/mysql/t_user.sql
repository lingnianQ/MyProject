drop table if exists t_user;
create table t_user
(
    id           bigint unsigned auto_increment
        primary key,
    username     varchar(50)            null comment '用户名',
    password     char(64)               null comment '密码（密文）',
    login_count  int unsigned default 0 null comment '累计登录次数（冗余）',
    gmt_create   datetime     default CURRENT_TIMESTAMP,
    gmt_modified datetime     default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP
) comment '用户' charset = utf8mb4;