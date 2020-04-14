package cn.zack;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zack
 * 开启admin server
 */
@EnableAdminServer
@SpringBootApplication
public class Admin_ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(Admin_ServerApplication.class, args);
    }
}
