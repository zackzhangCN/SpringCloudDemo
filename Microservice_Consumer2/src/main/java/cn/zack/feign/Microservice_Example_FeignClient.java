package cn.zack.feign;

import cn.zack.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zack
 * 使用@FeignClient声明要调用的微服务是哪个,调用失败时交由fallbackfactory处理
 */
@FeignClient(name = "microservice-example", fallbackFactory = Microservice_Example_FeignClient_FallbackFactory.class)
public interface Microservice_Example_FeignClient {
    @PostMapping(path = "/fun4")
    String getFun4(@RequestBody User user);
}