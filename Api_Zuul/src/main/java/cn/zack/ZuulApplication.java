package cn.zack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import cn.zack.filter.ZuulFilterTest;

import javax.servlet.MultipartConfigElement;

/**
 * @author zack
 * 使用@EnableZuulProxy注解,声明一个zuul代理
 * 该代理使用ribbon来定位注册在eureka server上的服务
 * 该代理还整合了hystrix,从而实现了容错,所有经过zuul的请求都会在hystrix命令包裹中执行
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    /**
     * 注入文件上传配置类, 修改文件上传参数, 以防止zuul进行调用时文件上传服务时超时
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
        // 单文件最大100M, 单次请求最大1G
        multipartConfigFactory.setMaxFileSize("1024000KB");
        multipartConfigFactory.setMaxRequestSize("102400KB");
        return multipartConfigFactory.createMultipartConfig();
    }
    @Bean
    public ZuulFilterTest preRequestLogFilter(){
        return new ZuulFilterTest();
    }
}