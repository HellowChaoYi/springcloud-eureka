package per.wei.cloud.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author wei
 * @date 2020/7/30 15:35
 **/
@FeignClient(name = "server-config", fallback = ConfigClientFallBackFactory.class)
@Component
public interface ConfigClient {
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String get(@RequestBody Map<String,Object> params);
}
