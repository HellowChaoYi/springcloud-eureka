package com.spring.gatewayadmin.route.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.gatewayadmin.route.entity.GatewayInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * InnoDB free: 10240 kB Mapper 接口
 * </p>
 *
 * @author wei
 * @since 2019-09-11
 */
@Mapper
@Component(value = "GatewayInfoMapper")
public interface GatewayInfoMapper extends BaseMapper<GatewayInfo> {

}
