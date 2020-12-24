package per.wei.cloud.dao.daomapper;

import per.wei.cloud.dao.daoentity.RoleWithPer;
import per.wei.cloud.dao.daoentity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wei
 * @since 2020-07-29
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    List getUserRole (Map map);
    Map getRolePer(Map map);
    Map getuser();
}
