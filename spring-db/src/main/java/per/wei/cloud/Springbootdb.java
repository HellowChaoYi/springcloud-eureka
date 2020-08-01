package per.wei.cloud;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


//@SpringBootApplication声明让spring boot自动给程序进行必要的配置
//排除druid原生加载方式DruidDataSourceAutoConfigure
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@EnableDiscoveryClient
@EnableFeignClients
public class Springbootdb {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SpringApplication.run(Springbootdb.class, args);
    }

}
