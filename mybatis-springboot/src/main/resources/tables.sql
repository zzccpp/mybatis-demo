-- 创建mybatis-demo数据库,注意数据名不能带"-"
create database if not exists mybatis_demo default charset utf8 collate utf8_general_ci;
-- 创建t_city表
create table if not exists t_city(
    id int primary key auto_increment,
    cityName varchar(20),
    state  char(1)
)engine=innodb charset=utf8 collate=utf8_general_ci;

-- 添加记录
insert into t_city(cityName,state) value('xxxxx','1');

-- 创建t_user表
create table if not exists t_user(
    id int primary key auto_increment,
    name varchar(20),
    age int
)engine=innodb charset=utf8 collate=utf8_general_ci;

-- 添加记录
insert into t_user(name,age) value('zhangsan',18);
insert into t_user(name,age) value('lisi',20);

-- 修改字段长度
alter table t_user modify name VARCHAR(100)
-- 查询表的结构
desc t_user;