package per.wei.cloud.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wei
 * @date 2020/8/7 13:33
 **/
@FeignClient(value = "server-db", fallback = DBClientFallBackFactory.class)
@Component
public interface DbClient {
    @RequestMapping(value = "/getmenulist")
    String resttest();
}
