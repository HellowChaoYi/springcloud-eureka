package per.wei.cloud.client;

import feign.hystrix.FallbackFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author wei
 * @date 2020/7/30 15:38
 **/
@Component
public class ConfigClientFallBackFactory implements FallbackFactory<ConfigClient> {
    @Override
    public ConfigClient create(Throwable throwable) {
        return new ConfigClient() {
            @Override
            public String get(Map<String, Object> params) {
                return null;
            }
        };
    }
}
