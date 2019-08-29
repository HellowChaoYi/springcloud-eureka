package com.test.cloud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserControl {
	@RequestMapping(value = "/login")
    public String getlogin() {
        return "login";
    }
	@RequestMapping(value = "/index")
    public String getIndex() {
        return "index";
    }
	@RequestMapping(value = "/test")
    public String gettest(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "test";
    }
}
