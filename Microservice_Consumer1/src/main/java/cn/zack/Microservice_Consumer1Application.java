package cn.zack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zack
 * 使用@EnableFeignClients开启SpringCloudFeign的支持
 */
@EnableFeignClients
@SpringBootApplication
public class Microservice_Consumer1Application {
    public static void main(String[] args) {
        SpringApplication.run(Microservice_Consumer1Application.class, args);
    }
}
