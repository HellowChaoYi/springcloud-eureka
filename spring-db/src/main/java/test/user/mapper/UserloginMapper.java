package test.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import test.user.entity.Userlogin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * InnoDB free: 10240 kB Mapper 接口
 * </p>
 *
 * @author wei
 * @since 2019-09-12
 */
@Mapper
@Component(value = "UserloginMapper")
public interface UserloginMapper extends BaseMapper<Userlogin> {

}
