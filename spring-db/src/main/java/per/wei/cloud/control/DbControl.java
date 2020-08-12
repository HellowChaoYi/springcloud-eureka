package per.wei.cloud.control;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.wei.cloud.dao.daoentity.SysMenu;
import per.wei.cloud.dao.daomapper.SysUserMapper;
import per.wei.cloud.dao.daoservice.ISysMenuService;
import per.wei.cloud.until.Util;

import java.util.List;
import java.util.Map;

//@CrossOrigin
@RestController
public class DbControl {
    @Autowired
    ISysMenuService iSysMenuService;
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    Util util;

    @RequestMapping(value = "/getmenulist")
    public ResponseEntity resttest() {
        List<SysMenu> list = iSysMenuService.list();
        ResponseEntity responseEntity = util.createErrorResult(null, null, null);
        if (list != null) {
            responseEntity = util.createOkResult(null, list, null);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/test")
    public String test() {
        List res = sysUserMapper.getUserRole();
        System.out.println(JSON.toJSON(res));
        return null;
    }
}
