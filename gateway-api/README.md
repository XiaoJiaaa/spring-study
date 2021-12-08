#### Gateway网关

配置Gateway

```
spring:
  application:
    name: gateway-api
  cloud:
    gateway:
      routes:
        #唯一标识
        - id: client1
          #转发地址 (lb:// 以注册中心的方式)
          uri: lb://eureka-client1
          #拦截需要转发的请求
          predicates:
            - Path=/server1/**
          filters:
            #转发请求时去除server1
            - StripPrefix=1
            
        - id: client2
          #实际地址
          uri: http://127.0.0.1:10002
          predicates:
            - Path=/server2/**
          filters:
            - StripPrefix=1
```
负载均衡测试
修改client2项目application.yml
```
spring:
  application:
    name: eureka-client1
```

启动项目后连续访问 [查询接口](http://127.0.0.1:10000/server1/info) ,可以看到返回结果的交替