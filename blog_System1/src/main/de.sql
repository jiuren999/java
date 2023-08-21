--一般对于建表的sql都会单独搞一个 .sql文件保存
--后续程序可能需要再不同的主机上部署,部署的时候就需要把对应的主机上的数据库也给创建好
--把建表sql保存好, 方便再不同的机器上建库建表

create database if not exists java107_blog_system charset=utf8;

use java107_blog_system;

drop table if exists blog;
create table blog (
    blogId int primary key auto_increment,
    title varchar(128),
    content varchar(4096),
    userId int ,
    postTime datetime
);

drop table if exists user;
create table user (
    userId int primary key auto_increment,
    username varchar(50) unique ,
    password varchar(50)
);


insert into user values(null ,'bai','123'),(null ,'xiaotongtong','250'),(null ,'niuzi','250');

insert into blog values(null ,'我的第一篇博客','这是正文',1,'2023-06-06 12:00:00');
insert into blog values(null ,'我的第二篇博客','这是正文',1,'2023-06-07 12:00:00');