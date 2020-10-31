package cn.tedu.sp08;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Administrator
 * 2020/10/31 - 22:19
 */
@EnableHystrixDashboard
@SpringBootApplication
public class Sp08HystrixDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(Sp08HystrixDashboardApplication.class, args);
    }
}
