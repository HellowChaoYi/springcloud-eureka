package per.wei.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
public class OAspringapplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(OAspringapplication.class, args);
	}
	
	
}
