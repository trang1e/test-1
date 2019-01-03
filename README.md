更改数据库链接配置在src\main\resources\application.properties
只需修改下面属性的值
spring.datasource.name = test
spring.datasource.url = jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf-8&useSSL=false&autoReconnect=true
spring.datasource.username = test
spring.datasource.password = test

数据库脚本：
create table test_hello(
id bigint(20) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '自增主键',
statement varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '打招呼语句',
author varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '作者'
);

插入数据:
postman请求
http://127.0.0.1/test/insert post方法
参数：类型：json
{
    "statement": "Hello world",
    "author": "wulha"
}

查询数据：
http://127.0.0.1/test/sayHi
http://127.0.0.1/test/sayHi1