package per.wei.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication //spring-boot 启动注解
@EnableFeignClients
@EnableDiscoveryClient
public class UserMain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(UserMain.class, args);
	}

}
