package com.spring.gatewayadmin.route.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.spring.gatewayadmin.route.entity.GatewayInfo;
import com.spring.gatewayadmin.route.entity.GatewayInfoForm;
import com.spring.gatewayadmin.route.mapper.GatewayInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * InnoDB free: 10240 kB 前端控制器
 * </p>
 *
 * @author wei
 * @since 2019-09-11
 */
@RestController
@RequestMapping("/route/gateway")
public class GatewayInfoController {
    @Autowired
    GatewayInfoMapper gatewayInfoMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping(value = "/selectAll")
    public JSONObject selectAll() {
        List<GatewayInfo> users = gatewayInfoMapper.selectList(null);
        JSONObject result = new JSONObject();
        result.put("route_info", users);
        return result;
    }
    @RequestMapping(value = "/add")
    public int add(@RequestBody GatewayInfo gi) {
        int res_add = 0;
        try{
            res_add = gatewayInfoMapper.insert(gi);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return res_add;
    }
    @RequestMapping(value = "/updata")
    public int add(@RequestBody GatewayInfoForm gf) {
        GatewayInfo gatewayInfo =gf.topo();
        int res_add = 0;
        try{
            res_add = gatewayInfoMapper.updateById(gatewayInfo);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return res_add;
    }
    @RequestMapping(value = "/delete")
    public int delete(Long id) {
        int res_delete = 0;
        try{
            res_delete = gatewayInfoMapper.deleteById(id);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return res_delete;
    }

    @RequestMapping(value = "/routes")
    public String getRouteList() {
        String res_routes = redisTemplate.opsForValue().get("gateway-dynamic-route");
        if(!StringUtils.isEmpty(res_routes)){
            System.out.println("返回 redis 中的路由信息......");
        }else{
            System.out.println("返回 mysql 中的路由信息......");
            res_routes = JSON.toJSONString(selectAll());
            //再set到redis
            redisTemplate.opsForValue().set("gateway-dynamic-route" , res_routes);
        }
        System.out.println("路由信息：" + res_routes);
        return res_routes;
    }
}
