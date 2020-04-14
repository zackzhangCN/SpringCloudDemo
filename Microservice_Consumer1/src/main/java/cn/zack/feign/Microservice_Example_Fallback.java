package cn.zack.feign;

import cn.zack.pojo.User;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zack
 * feign调用失败处理类
 */
@Component
public class Microservice_Example_Fallback implements Microservice_Example_FeignClient {
    public String getFun1() {
        return "fail";
    }

    public String getFun2(String param1, String param2) {
        return "fail";
    }

    public String getFun3(Map<String, Object> map) {
        return "fail";
    }

    public String getFun4(User user) {
        return "fail";
    }
}
