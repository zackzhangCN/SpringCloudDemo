package cn.zack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zack
 * 开启eureka server
 */
@EnableEurekaServer
@SpringBootApplication
public class Example_Eureka1_Application {
    public static void main(String[] args) {
        SpringApplication.run(Example_Eureka1_Application.class, args);
    }
}
