package cn.zack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zack
 * 开启eureka server
 */
@SpringBootApplication
@EnableEurekaServer
public class Example_Eureka2_Application {
    public static void main(String[] args) {
        SpringApplication.run(Example_Eureka2_Application.class, args);
    }
}
