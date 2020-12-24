package per.wei.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@RestController
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class FeignMain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(FeignMain.class, args);
	}
	
	@RequestMapping("/hi")
	@HystrixCommand(fallbackMethod = "hiError")
	public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
	    return "hi " + name ;
	}
	public String hiError(String name) {
	    return "hi,"+name+",sorry,error!";
	}
}
