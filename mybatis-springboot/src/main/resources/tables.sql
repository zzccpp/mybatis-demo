--创建mybatis-demo数据库,注意数据名不能带"-"
create database if not exists mybatis_demo default charset utf8 collate utf8_general_ci;
--创建t_city表
create table if not exists t_city(
    id int primary key auto_increment,
    cityName varchar(20),
    state  char(1)
)engine=innodb charset=utf8 collate=utf8_general_ci;

--添加记录
insert into t_city(cityName,state) value('xxxxx','1');