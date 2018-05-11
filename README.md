# bigdata_rest

通过 rest 访问 impala 和 hbase
好处：
1.方便各种语言、系统调用
2.可以对查询的语句进行权限管理

工具springboot

实现原理：
1.用户通过 rest 访问 本系统，系统再通过调用与impala的连接池访问 impala。
2.用户通过 rest 访问 本系统，系统通过把 用户的请求进行转发，调用hbase的rest 服务。


例子：
1.
通过 rest 访问 impala
![Alt text](https://github.com/liuche20083736/bigdata_rest/blob/master/screenshot/impala_sql.png)

sql 为需要在impala中执行的sql。

权限，可以在系统中通过 username 查询用户权限，并查看是否有执行 sql 中某张表的权限。

2.
通过rest 访问 hbase
![Alt text](https://github.com/liuche20083736/bigdata_rest/blob/master/screenshot/hbase_queryall.png)



----

负载均衡  前面可以通过 nginx 转发请求