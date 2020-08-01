package per.wei.cloud.dao.daoservice.daoserviceimpl;

import per.wei.cloud.dao.daoentity.SysUser;
import per.wei.cloud.dao.daomapper.SysUserMapper;
import per.wei.cloud.dao.daoservice.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wei
 * @since 2020-07-29
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
