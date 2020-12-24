package per.wei.cloud.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author wei
 * @date 2020/8/7 13:33
 **/
@FeignClient(value = "server-db", fallback = DBClientFallBackFactory.class)
@Component
public interface DbClient {
    @RequestMapping(value = "/getmenulist")
    String Dbgetmenulist();

    @RequestMapping(value = "/checkUserPermission")
    String DbcheckUserPermission(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/checkUser")
    String DbcheckUser(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/getmenulistbyuser")
    String DbgetmenulistByUser(@RequestBody Map map);

    @RequestMapping(value = "/test")
    String test();
}
