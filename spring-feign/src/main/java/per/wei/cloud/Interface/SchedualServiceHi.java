package per.wei.cloud.Interface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "spring-user")
public interface SchedualServiceHi {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    String sayHiFromClientOne();
}
