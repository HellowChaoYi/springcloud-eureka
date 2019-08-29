package com.feign.Interface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.feign.FeiControl;

@FeignClient(value = "server-db",fallback=FeiControl.class)
public interface Logininterface {
	@RequestMapping(value = "/db/getUsers",method = RequestMethod.POST)
    String login(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password);
	
	@RequestMapping(value = "/db/getyml")
    String getyml();
}
