package cn.zack.feign;

import cn.zack.pojo.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zack
 * fiegn调用失败回退处理工厂类
 */
@Component
public class Microservice_Example_FeignClient_FallbackFactory implements FallbackFactory<Microservice_Example_FeignClient> {
    private static final Logger logger = LoggerFactory.getLogger(Microservice_Example_FeignClient_FallbackFactory.class);

    public Microservice_Example_FeignClient create(Throwable throwable) {
        // 打印进入回退的原因
        logger.info("fallback; cause:", throwable);
        return new Microservice_Example_FeignClient() {
            public String getFun4(@RequestBody User user) {
                return "fail";
            }
        };
    }
}
