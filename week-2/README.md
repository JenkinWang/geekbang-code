### week-2
- 在 Tomcat/TomEE 环境下，编写一个 Servlet 程序，通过 `JNDI` 获取 JDBC DataSource，能够获取到正常的 `java.sql.Connection` 对象即可，输出“获取 JDBC 连接成功”等。

代码仓库：https://github.com/JenkinWang/geekbang-code/tree/master/week-2

执行代码：
```bash
mvn clean
mvn package
mvn tomcat7:run
```
执行请求:`curl localhost:8080/week-2/jndi`