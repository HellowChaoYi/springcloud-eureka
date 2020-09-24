package per.wei.cloud.dao.daoservice.daoserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import per.wei.cloud.dao.daoentity.RoleWithPer;
import per.wei.cloud.dao.daoentity.SysUser;
import per.wei.cloud.dao.daoentity.UserWithRole;
import per.wei.cloud.dao.daomapper.SysUserMapper;
import per.wei.cloud.dao.daoservice.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wei
 * @since 2020-07-29
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public List checkPer(Map map) {
////        Map map1 = new HashMap(16);
//        map.put("user_id", "1");
        List res = sysUserMapper.getUserRole(map);
        List returndata = new ArrayList();
        for (int i = 0; i < res.size(); i++) {
            Map<String,Object> userWithRole = (Map<String, Object>) res.get(i);
//            Map<String, Object> rolemap = (Map<String, Object>) res.get(i);
            Map<String, Object> roleidmap = new HashMap<>();
            String roleid = (String) userWithRole.get("id");
            String rolename = (String) userWithRole.get("rolename");
            roleidmap.put("roleid", roleid);
            Map roleper = sysUserMapper.getRolePer(roleidmap);
            Map<String, Object> roleperreturnmap = new HashMap<>();
            roleperreturnmap.put("rolename",rolename);
            roleperreturnmap.put("permission",roleper);
            returndata.add(roleperreturnmap);
        }
        return returndata;
    }
}
