package per.wei.cloud.control;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.wei.cloud.dao.daoentity.SysControl;
import per.wei.cloud.dao.daoentity.SysMenu;
import per.wei.cloud.dao.daoentity.SysUser;
import per.wei.cloud.dao.daomapper.SysControlMapper;
import per.wei.cloud.dao.daomapper.SysUserMapper;
import per.wei.cloud.dao.daoservice.ISysControlService;
import per.wei.cloud.dao.daoservice.ISysMenuService;
import per.wei.cloud.dao.daoservice.ISysUserService;
import per.wei.cloud.dao.daoservice.daoserviceimpl.SysControlServiceImpl;
import per.wei.cloud.until.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @CrossOrigin
 */
@RestController
public class DbUserControl {
    @Autowired
    ISysMenuService iSysMenuService;
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    ISysUserService iSysUserService;
    @Autowired
    Util util;
    @Autowired
    SysControlMapper sysControlMapper;
    @Autowired
    ISysControlService iSysControlService;

    @RequestMapping(value = "/checkUserPermission")
    public ResponseEntity dbcheckUserPermission(@RequestBody Map map) {
        List res = iSysUserService.checkPer(map);
        ResponseEntity responseEntity = util.createErrorResult(null, null, null);
        if (res != null) {
            responseEntity = util.createOkResult(null, res, null);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/checkUser")
    public ResponseEntity dbcheckUser(@RequestBody Map<String, Object> map) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        SysUser sysuser = sysUserMapper.selectOne(queryWrapper.allEq(map));
        ResponseEntity responseEntity = util.createErrorResult(null, null, null);
        if (sysuser != null) {
            responseEntity = util.createOkResult(null, sysuser, null);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/test")
    public ResponseEntity test() {
//        SysControl sysControl = iSysControlService.
        Map map = sysUserMapper.getuser();
        System.out.println(map);
        ResponseEntity responseEntity = null;
        return responseEntity;
    }
}
