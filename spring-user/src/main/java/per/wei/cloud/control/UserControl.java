package per.wei.cloud.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import per.wei.cloud.client.DbClient;
import per.wei.cloud.service.BaseDataService;
import per.wei.cloud.until.Util;

import java.util.List;
import java.util.Map;


/**
 * <p>
 *
 * </p>
 *
 * @author wei
 * @since 2020-08-28
 */
@CrossOrigin
@Controller
public class UserControl {
    @Autowired
    Util util;
    @Autowired
    BaseDataService baseDataService;

    @RequestMapping(value = "/getmenulist")
    public ResponseEntity getmenulist(@RequestBody Map map) {
        List res = baseDataService.getmenulist(map);
        ResponseEntity responseEntity = null;
        if (res != null) {
            responseEntity = util.createOkResult(null, res, null);
        } else {
            responseEntity = util.createErrorResult(null, null, null);
        }
        return responseEntity;
    }

    @ResponseBody
    @RequestMapping(value = "/checkuser")
    public ResponseEntity checkuser(@RequestBody Map<String, Object> map) {
        Map<String, Object> res = baseDataService.checkisuser(map);
        ResponseEntity responseEntity = null;
        String remsg = null;
        if (res != null) {
            Integer code = (Integer) res.get("rescode");
            switch (code) {
                case 0:
                    remsg = "用户不存在";
                    responseEntity = util.createOkResult(null, res, remsg);
                    break;
                case 1:
                    remsg = "密码错误";
                    responseEntity = util.createOkResult(null, res, remsg);
                    break;
                case 2:
                    responseEntity = util.createOkResult(null, res, null);
                    break;
                default:
            }
        } else {
            responseEntity = util.createErrorResult(null, null, null);
        }
        return responseEntity;
    }

    @ResponseBody
    @RequestMapping(value = "/checkuserpermission")
    public ResponseEntity checkuserpermission(@RequestBody Map<String, Object> map) {
        List res = baseDataService.checkuserper(map);
        ResponseEntity responseEntity = null;
        if (res != null) {
            responseEntity = util.createOkResult(null, res, null);
        } else {
            responseEntity = util.createErrorResult(null, null, null);
        }
        return responseEntity;
    }

    @ResponseBody
    @RequestMapping(value = "/getUserData")
    public ResponseEntity getUserData(@RequestBody Map<String, Object> map) {
        Map res = baseDataService.getUserData(map);
        ResponseEntity responseEntity = null;
        if (res != null) {
            responseEntity = util.createOkResult(null, res, null);
        } else {
            responseEntity = util.createErrorResult(null, null, null);
        }
        return responseEntity;
    }
     @Autowired
     DbClient dbClient;

    @ResponseBody
    @RequestMapping(value = "/test")
    public ResponseEntity test(@RequestBody Map<String, Object> map) {
//        System.out.println(map);
        String res = dbClient.test();
        System.out.println();
        ResponseEntity responseEntity = null;
        if (map != null) {
            responseEntity = util.createOkResult(null, res, null);
        } else {
            responseEntity = util.createErrorResult(null, null, null);
        }
        return responseEntity;
    }
}
