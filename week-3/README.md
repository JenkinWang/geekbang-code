### week-3
- 分析 Tomcat 容器调用 `shutdown.sh` 脚本最终如何关闭 Tomcat 服务器，提示: 参考引导类 `org.apache.catalina.startup.Bootstrap`
  
---
命令行输入 `stop` 参数，进入类 `org.apache.catalina.startup.Bootstrap` 的 `main` 方法 调用 `stopServer` 方法，利用反射调用类 `org.apache.catalina.startup.Catalina` 的 `stopServer` 方法。

在类 `org.apache.catalina.startup.Catalina#stopServer` 方法中：

- 调用 `getServer()` 方法获取 `Server` 对象，如果 `Server()` 为 `null`，
    - 先调用 `createStopDigester()` 方法创建一个  `Digester` 对象，设置 `digester.setUseContextClassLoader(true);`，并对 `Digester` 对象配置关闭规则：

       ```java
       digester.addObjectCreate("Server","org.apache.catalina.core.StandardServer", "className");
       digester.addSetProperties("Server");
       digester.addSetNext("Server", "setServer", "org.apache.catalina.Server");
       ```
    - 然后读取 `server.xml` 文件内容，交给 `Digester` 进行解析。

- 重新获取 `Server` 对象
- 建立 `Socket` 连接，获取输出流
- 调用 `org.apache.catalina.core.StandardServer#getShutdown` 方法，获取 `SHUTDOWN` 字符串，并写到输出流中
-  `org.apache.catalina.core.StandardServer#await` 方法接收到 `SHUTDOWN` 的指令

> 首先在 tomcat 启动时，当前线程会进入 `org.apache.catalina.core.StandardServer#await` 方法，该方法有一个死循环一直等待接收 `SHUTDOWN` 指令字符串，当接收到 `SHUTDOWN` 指令后跳出循环，并关闭 `Socket`连接。继续执行 `org.apache.catalina.startup.Catalina#stop` 方法。

a) 执行 `org.apache.catalina.util.LifecycleBase#stop` 方法：

- `org.apache.catalina.core.StandardService#stopInternal` 方法
    - `setState(LifecycleState.STOPPING);`
    - 停止所有 `StandardService` 服务
    - `org.apache.catalina.core.StandardService#stopInternal`
        - 先暂停所有的 `connector`，关闭绑定在 `start` 上的 `Socket` 服务
        - `setState(LifecycleState.STOPPING);`
        - `org.apache.catalina.core.ContainerBase#stopInternal`
            - 停止后台线程
            - `setState(LifecycleState.STOPPING);` 设置 `stop` 状态
            - 关闭 `pipeline` 中的所有的 `Valve`
            - 关闭所有的子容器
            - 关闭所有的 `Realm` 、 `Cluster`
    - 第二次停止容器 `StandardEngine`
    - 关闭所有的连接 `connector`
    - 判断是否存在 `MapperListener` ，若存在则进行停止操作
    - 关闭所有 `Executor`
    - 关闭所有 `globalNamingResources` 资源
    - 调用 `org.apache.catalina.core.StandardServer#stopAwait` 方法：
        - 设置 `stopAwait` 的值为 `true`

- `org.apache.catalina.util.LifecycleBase#setStateInternal` 设置各组件状态为 `after_stop`

b) 执行 `org.apache.catalina.util.LifecycleBase#destroy` 方法：
- `setStateInternal(LifecycleState.DESTROYING, null, false);` 设置组件状态为 `before_destroy`
- 执行 `org.apache.catalina.core.StandardServer#destroyInternal` 方法
    - 销毁所有 `services`
    - 销毁所有 `globalNamingResources` 资源
    - 注销 `MBeanFactory`
    - 注销 `StringCache`
    - `org.apache.catalina.util.LifecycleMBeanBase#destroyInternal`
        - 注销 `Server`
- `setStateInternal(LifecycleState.DESTROYED, null, false);` 设置组件状态为 `after_destroy`

服务停止。

