package per.wei.cloud.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.wei.cloud.dao.daoentity.SysMenu;
import per.wei.cloud.dao.daomapper.SysMenuMapper;
import per.wei.cloud.dao.daoservice.ISysMenuService;
import per.wei.cloud.until.Util;

import java.util.List;
import java.util.Map;

/**
 * @author wei
 * @date 2020/9/3 14:28
 **/
@RestController
public class DbPermissionControl {
    @Autowired
    ISysMenuService iSysMenuService;
    @Autowired
    SysMenuMapper sysMenuMapper;
    @Autowired
    Util util;

    @RequestMapping(value = "/getmenulist")
    public ResponseEntity Dbgetmenulist() {
        List<SysMenu> list = iSysMenuService.list();
        ResponseEntity responseEntity = util.createErrorResult(null, null, null);
        if (list != null) {
            responseEntity = util.createOkResult(null, list, null);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/getmenulistbyuser")
    public ResponseEntity DbgetmenulistByUser(@RequestBody Map map) {
//        List<SysMenu> list = iSysMenuService.list(map);
        List<Map<String,Object>> list = sysMenuMapper.getMenuByPer(map);
        ResponseEntity responseEntity = util.createErrorResult(null, null, null);
        if (list != null) {
            responseEntity = util.createOkResult(null, list, null);
        }
        return responseEntity;
    }
}
