package com.example.eureka.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import java.util.concurrent.TimeUnit;

public class TestHystrixService {


    //一旦该方法失败并抛出了异常信息后，会自动调用  @HystrixCommand 注解标注的 fallbackMethod 指定的方法
    @HystrixCommand(fallbackMethod = "dept_TimeoutHandler", commandProperties =
            //规定 5 秒钟以内就不报错，正常运行，超过 5 秒就报错，调用指定的方法
            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
    public String timeout(Integer id) {

        int outTime = 6;
        try {
            TimeUnit.SECONDS.sleep(outTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "  timeout,id:   " + id + "  耗时: " + outTime;
    }

    public String dept_TimeoutHandler(Integer id) {
        return "系统繁忙请稍后再试！" + "线程池：" + Thread.currentThread().getName() + "  deptInfo_Timeout,id:   " + id;
    }

}
