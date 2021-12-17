#### Feign

启动类添加注解：

```
@EnableFeignClients(basePackages = "")
```

basePackages 值为Feign接口所在的包位置

新建Feign接口：

```
@FeignClient(value = "")
public interface ClientFeign {
}
```

其中value值为需要请求的服务名

添加方法：

```
@GetMapping("/info")
String getClientInfo();
```

注：方法的返回值需与要请求的方法保持一致，此处以`eureka-client2`服务中的`@GetMapping("/info")`举例。 当调用`ClientFeign` 类中`getClientInfo`
方法时，会请求`eureka-client2` 服务的`getInfo`方法并返回数据。完整类如下：

```
@FeignClient(value = "eureka-client2")
public interface ClientFeign {

    @GetMapping("/info")
    String getClientInfo();

}
```

请求入口如下：

```
@RestController
public class ClientController {

    @Autowired
    private ClientFeign clientFeign;

    @GetMapping("/feign/client")
    public String feignClient() {
        return clientFeign.getClientInfo();
    }
}
```