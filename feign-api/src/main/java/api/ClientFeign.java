package api;

import base.RestResult;
import dto.DemoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import vo.DemoVO;

@FeignClient(value = "eureka-client2")
public interface ClientFeign {
    @GetMapping("/info")
    RestResult<DemoVO> getClientInfo(@SpringQueryMap DemoDTO dto);

    @PostMapping("/info")
    RestResult<DemoVO> postClientInfo(@RequestBody DemoDTO dto);

    @PutMapping("/info")
    RestResult<DemoVO> putClientInfo(@RequestBody DemoDTO dto);

    @DeleteMapping("/info")
    RestResult<DemoVO> deleteClientInfo(@SpringQueryMap DemoDTO dto);
}
