package api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "eureka-client2")
public interface Client2Feign {

}
