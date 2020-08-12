package per.wei.cloud.service;

import com.alibaba.fastjson.JSON;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.wei.cloud.client.DbClient;
import per.wei.cloud.service.serviceimpl.BaseDataServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wei
 * @date 2020/8/11 15:13
 **/
@Component
public class BaseDataService implements BaseDataServiceImpl {
    @Autowired
    DbClient dbClient;

    @Override
    public List getmenulist() {
        String res1 = dbClient.resttest();
        Map res = JSON.parseObject(res1);
        List menulist = new ArrayList();
        if (res != null) {
            List list = (List) res.get("result");
            List parentlist = new ArrayList();
            List childlist = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Map resmap = (Map) list.get(i);
                String parentId = resmap.get("parentId").toString();
                if (StringUtil.isNullOrEmpty(parentId)) {
                    parentlist.add(resmap);
                } else {
                    childlist.add(resmap);
                }
            }

            for (int i = 0; i < parentlist.size(); i++) {
                Map parentMap = (Map) parentlist.get(i);
                String parentId = (String) parentMap.get("menuId");
                Integer sortId = (Integer) parentMap.get("sort");
                List genchildlist = getChildList(parentId, childlist,String.valueOf(sortId));
                if (!genchildlist.isEmpty()) {
                    parentMap.put("children", genchildlist);
                }
                menulist.add(parentMap);
            }
        }
        return menulist;
    }

    private List getChildList(String parentId, List childlist, String sortId) {
        List newchildlist = new ArrayList();
        for (int i = 0; i < childlist.size(); i++) {
            Map map = (Map) childlist.get(i);
            String id = (String) map.get("parentId");
            if (id.equals(parentId)) {
                String menuId = (String) map.get("menuId");
                Integer chlidshortId = (Integer) map.get("sort");
                String newchildshortId = sortId+"-"+chlidshortId;
                map.put("sort",newchildshortId);
                List rowlist = getChildList(menuId, childlist, newchildshortId);
                if (!rowlist.isEmpty()) {
                    map.put("children", rowlist);
                }
                newchildlist.add(map);
            }
        }
        return newchildlist;
    }
}
