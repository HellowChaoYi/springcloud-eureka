package per.wei.cloud.dao.daoservice;

import per.wei.cloud.dao.daoentity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wei
 * @since 2020-07-29
 */
public interface ISysUserService extends IService<SysUser> {
    List checkPer(Map map);
}
