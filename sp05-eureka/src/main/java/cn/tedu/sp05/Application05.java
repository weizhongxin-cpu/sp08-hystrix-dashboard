package cn.tedu.sp05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author Administrator
 * @CreateTime 2020/10/3 - 10:54
 */
@EnableEurekaServer
@SpringBootApplication
public class Application05 {
    public static void main(String[] args) {
        SpringApplication.run(Application05.class, args);
    }
}
