package test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


//@SpringBootApplication声明让spring boot自动给程序进行必要的配置
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class Springbootdb {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Springbootdb.class, args);
		
		System.out.println(System.getProperty("user.dir"));
		
	}

}
