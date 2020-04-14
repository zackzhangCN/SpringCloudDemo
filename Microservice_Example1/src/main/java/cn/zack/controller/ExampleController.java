package cn.zack.controller;

import cn.zack.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author zack
 * 服务提供者一
 */
@Slf4j
@RestController
public class ExampleController {

    @GetMapping(path = "fun1")
    public String fun1() throws InterruptedException {
        log.info("test入参======");
        // Thread.sleep(100000);
        return "调用example1.fun1";
    }

    @GetMapping(path = "fun2")
    public String fun2(String param1, String param2) {
        log.info("test入参======, param1:{}, param2:{}", param1, param2);
        return "param1 : " + param1 + "\r\nparam2 : " + param2;
    }

    @PostMapping(path = "/fun4")
    public String fun4(@RequestBody User user) {
        // 手动添加除零异常
        int a = 1 / 0;
        return "username: " + user.getUsername() + "\r\npassword: " + user.getPassword();
    }
}
