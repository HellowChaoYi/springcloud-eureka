package per.wei.cloud.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.wei.cloud.dao.daoentity.SysMenu;
import per.wei.cloud.dao.daoservice.ISysMenuService;

import java.util.List;

@RestController
public class DbControl {
    @Autowired
    ISysMenuService iSysMenuService;
    @RequestMapping(value = "/getmenulist")
    public List<SysMenu> resttest () {
        List<SysMenu> list = iSysMenuService.list();
        return list;
    }

}
