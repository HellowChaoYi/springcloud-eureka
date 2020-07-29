package per.wei.cloud.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import per.wei.cloud.user.entity.Userlogin;
import per.wei.cloud.user.mapper.UserloginMapper;

import java.util.List;

/**
 * <p>
 * InnoDB free: 10240 kB 前端控制器
 * </p>
 *
 * @author wei
 * @since 2019-09-12
 */
@CrossOrigin
@ComponentScan
@Configuration
@RestController
@RequestMapping("/user/userlogin")
public class UserloginController {
    @Autowired
    UserloginMapper userloginMapper;
    @RequestMapping(value = "/select")
    public List<Userlogin> selectlist(@Param(value = "username") String username, @Param(value = "password") String password){
        System.out.println("user: "+ username+"\n"+"password: "+password);
        List<Userlogin> list = userloginMapper.selectList(new QueryWrapper<Userlogin>()
                .eq("username",username));
        return list;
    }
}
