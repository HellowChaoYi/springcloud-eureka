package per.wei.cloud.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import per.wei.cloud.constant.ReturnConstant;
import per.wei.cloud.service.serviceimpl.ConfigServiceImpl;
import per.wei.cloud.until.Util;

import java.util.Map;

/**
 * @author wei
 */

@Controller
public class ConfigControl {

    @Autowired
    ConfigServiceImpl configServiceimpl;
    @Autowired
    Util util;
    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public ResponseEntity get(@RequestBody Map<String,Object> params){
        Map res = configServiceimpl.get(params);
        ResponseEntity responseEntity = null;
        if ( !res.containsKey(ReturnConstant.FAILMSG) ) {
            responseEntity = util.createOkResult(null,res,null);
        }else {
            responseEntity = util.createErrorResult(null,null,res.get(ReturnConstant.FAILMSG));
        }
        System.out.println("out put");
        return responseEntity;
    }
}
