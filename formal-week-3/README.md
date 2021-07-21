### formal-week-3
- 通过 MicroProfile REST Client 实现 POST 接⼝去请求项⽬中的 ShutdownEndpoint，URI： http://127.0.0.1:8080/actuator/shutdown
- 可选：完善 my-rest-client 框架 POST ⽅法，实现 org.geektimes.rest.client.DefaultInvocationBuilder#buildPost ⽅法

---
实现 `POST` 接口请求 `http://127.0.0.1:8080/actuator/shutdown`：
```java
    interface PostShutDown {
        @POST
        @Path("/actuator/shutdown")
        String shutdown();
    }
```

```java
public class PostShutDownDemo {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:8080");
        PostShutDown postShutDown = RestClientBuilder.newBuilder()
                .baseUrl(url)
                .build(PostShutDown.class);
        postShutDown.shutdown();
    }
}

```