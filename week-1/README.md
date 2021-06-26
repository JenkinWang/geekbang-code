### week-1
- 编写一个 Servlet 程序，该 Servlet Forward 到某一个 Servlet 或 jsp 页面。
- 熟悉 `RequestDispatcher` 。

代码仓库：https://github.com/JenkinWang/geekbang-code/tree/master/week-1

执行代码：
```bash
mvn clean
mvn package
mvn tomcat7:run
```
执行请求： `curl localhost:8080/week-1/week-1`