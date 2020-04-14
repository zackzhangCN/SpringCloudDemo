package cn.zack.feign;

import cn.zack.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author zack
 * 使用@FeignClient声明要调用的微服务是哪个,并指定调用失败时的回退处理类
 */
@FeignClient(name = "microservice-example", fallback = Microservice_Example_Fallback.class)
public interface Microservice_Example_FeignClient {

    /**
     * 指定要调用的具体的某个服务
     *
     * @return
     */
    @GetMapping(path = "/fun1")
    String getFun1();

    @GetMapping(path = "/fun2")
    String getFun2(@RequestParam("param1") String param1, @RequestParam("param2") String param2);

    @GetMapping(path = "/fun2")
    String getFun3(@RequestParam Map<String, Object> map);

    @PostMapping(path = "/fun4")
    String getFun4(@RequestBody User user);
}
