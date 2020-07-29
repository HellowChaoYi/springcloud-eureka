package per.wei.cloud.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource")//spring:datasource:
@PropertySource(value = {"classpath:application-dev.yml"})
public class YamlProperties {
	
	@Value("${url}")
	private String url;
	@Value("${username}")
	private String username;
	@Value("${password}")
	private String password;
	@Value("${driver-class-name}")
	private String driver_class_name;
	@Value("${max-idle}")
	private String max_idle;
	@Value("${max-wait}")
	private String max_wait;
	@Value("${min-idle}")
	private String min_idle;
	@Value("${initial-size}")
	private String initial_size;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDriver_class_name() {
		return driver_class_name;
	}
	public void setDriver_class_name(String driver_class_name) {
		this.driver_class_name = driver_class_name;
	}
	public String getMax_idle() {
		return max_idle;
	}
	public void setMax_idle(String max_idle) {
		this.max_idle = max_idle;
	}
	public String getMax_wait() {
		return max_wait;
	}
	public void setMax_wait(String max_wait) {
		this.max_wait = max_wait;
	}
	public String getMin_idle() {
		return min_idle;
	}
	public void setMin_idle(String min_idle) {
		this.min_idle = min_idle;
	}
	public String getInitial_size() {
		return initial_size;
	}
	public void setInitial_size(String initial_size) {
		this.initial_size = initial_size;
	}
	
	
}
