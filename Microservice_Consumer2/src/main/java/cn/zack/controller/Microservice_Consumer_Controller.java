package cn.zack.controller;

import cn.zack.feign.Microservice_Example_FeignClient;
import cn.zack.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zack
 * 消费者二, 使用feign调用microservice_example微服务
 */
@RestController
public class Microservice_Consumer_Controller {
    @Autowired
    private Microservice_Example_FeignClient microservice_example_feignClient;

    @GetMapping(path = "getFun4")
    public String getFun4() {
        User aaa = new User("aaa", "123456");
        String s = microservice_example_feignClient.getFun4(aaa);
        return s;
    }
}