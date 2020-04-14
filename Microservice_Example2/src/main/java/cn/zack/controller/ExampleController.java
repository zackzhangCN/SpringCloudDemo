package cn.zack.controller;

import cn.zack.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zack
 * 服务提供者二
 */
@RestController
public class ExampleController {

    @GetMapping(path = "fun1")
    public String fun1() throws InterruptedException {
        // Thread.sleep(100000);
        return "调用example2";
    }

    @GetMapping(path = "fun2")
    public String fun2(String param1, String param2) {
        return "param1 : " + param1 + "\r\nparam2 : " + param2;
    }

    @PostMapping(path = "/fun4")
    public String fun4(@RequestBody User user) {
        return "username: " + user.getUsername() + "\r\npassword: " + user.getPassword();
    }
}
