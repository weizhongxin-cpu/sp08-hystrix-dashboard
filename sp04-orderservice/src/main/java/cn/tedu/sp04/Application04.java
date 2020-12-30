package cn.tedu.sp04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Administrator
 * @CreateTime 2020/10/3 - 10:40
 */
@EnableCircuitBreaker
@EnableFeignClients
@SpringBootApplication
public class Application04 {
    public static void main(String[] args) {
        SpringApplication.run(Application04.class, args);
    }
}
