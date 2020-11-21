package cn.tedu.sp09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class Sp09FeighApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sp09FeighApplication.class, args);
	}

}
