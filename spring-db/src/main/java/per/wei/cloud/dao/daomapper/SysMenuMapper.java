package per.wei.cloud.dao.daomapper;

import per.wei.cloud.dao.daoentity.SysMenu;
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
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    List<Map<String,Object>> getMenuByPer(Map map);
}
