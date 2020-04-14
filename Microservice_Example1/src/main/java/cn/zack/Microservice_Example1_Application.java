package cn.zack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zack
 * 只对外提供服务的服务提供者一
 */
@SpringBootApplication
public class Microservice_Example1_Application {
    public static void main(String[] args) {
        SpringApplication.run(Microservice_Example1_Application.class, args);
    }
}
