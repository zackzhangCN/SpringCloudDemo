package cn.zack.controller;

import cn.zack.feign.Microservice_Example_FeignClient;
import cn.zack.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author zack
 * 消费者一, 使用feign调用microservice_example微服务
 */
@RestController
public class Microservice_Consumer_Controller {

    /*注入一个microservice_example的feign客户端*/
    @Autowired
    private Microservice_Example_FeignClient microservice_example_feignClient;

    @GetMapping(path = "getFun1")
    public String getFun1() {
        String s = microservice_example_feignClient.getFun1();
        return s;
    }

    @GetMapping(path = "getFun2")
    public String getFun2() {
        String str1 = "aaa";
        String str2 = "bbb";
        String s = microservice_example_feignClient.getFun2(str1, str2);
        return s;
    }

    @GetMapping(path = "getFun3")
    public String getFun3() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("param1", "111");
        map.put("param2", "222");
        String s = microservice_example_feignClient.getFun3(map);
        return s;
    }

    @GetMapping(path = "getFun4")
    public String getFun4() {
        User aaa = new User("aaa", "123456");
        String s = microservice_example_feignClient.getFun4(aaa);
        return s;
    }
}
