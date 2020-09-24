package per.wei.cloud.service.serviceimpl;

import com.alibaba.fastjson.JSON;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.wei.cloud.client.DbClient;
import per.wei.cloud.constant.ReturnConstant;
import per.wei.cloud.service.BaseDataService;


import java.util.*;

/**
 * @author wei
 * @date 2020/8/11 15:13
 **/
@Component
public class BaseDataServiceImpl implements BaseDataService {
    @Autowired
    DbClient dbClient;

    @Override
    public List getmenulist(Map map) {
        List IDs = (List) map.get("perIDs");
        System.out.println(IDs);
        List listall = new ArrayList();
        for (int i = 0; i < IDs.size(); i++) {
            Object o = IDs.get(i);
            Map IDmap = new HashMap(1);
            IDmap.put("permission_id", o);
            String res1 = dbClient.DbgetmenulistByUser(IDmap);
            Map resmap = JSON.parseObject(res1);
            List reslist = (List) resmap.get("result");
            System.out.println(res1);
            listall.addAll(reslist);
        }
        listall = new ArrayList<Object>(new LinkedHashSet<>(listall));
        System.out.println(listall);
        List menulist = new ArrayList();
        if (!listall.isEmpty()) {
            List parentlist = new ArrayList();
            List childlist = new ArrayList();
            for (int i = 0; i < listall.size(); i++) {
                Map resmap = (Map) listall.get(i);
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
                String sortId = (String) parentMap.get("sort");
                List genchildlist = getChildList(parentId, childlist, sortId);
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
                String chlidshortId = (String) map.get("sort");
                String newchildshortId = sortId + "-" + chlidshortId;
                map.put("sort", newchildshortId);
                List rowlist = getChildList(menuId, childlist, newchildshortId);
                if (!rowlist.isEmpty()) {
                    map.put("children", rowlist);
                }
                newchildlist.add(map);
            }
        }
        return newchildlist;
    }

    @Override
    public Map<String, Object> checkisuser(Map<String, Object> pushmap) {
        Map checkuser = new HashMap(16);
        checkuser.put("username", pushmap.get("username"));
        String userData = dbClient.DbcheckUser(checkuser);
        Map userDataMap = JSON.parseObject(userData);
        Map returnData = new HashMap(2);
        if (userDataMap != null) {
            String msg = (String) userDataMap.get("msg");
            String info = (String) userDataMap.get("info");
            if (ReturnConstant.PASSMSG.equals(msg) && StringUtil.isNullOrEmpty(info)) {
                Map result = JSON.parseObject(userDataMap.get("result").toString());
                String password = (String) result.get("password");
                String pushpassword = (String) pushmap.get("password");
                if (password.equals(pushpassword)) {
                    returnData.put("rescode", 2);
                    returnData.put("resdata", userDataMap);
                    return returnData;
                } else {
                    returnData.put("rescode", 1);
                    returnData.put("resdata", ReturnConstant.FAILMSG);
                    return returnData;
                }
            }
        } else {
            returnData.put("rescode", 0);
            returnData.put("resdata", ReturnConstant.FAILMSG);
            return returnData;
        }
        returnData.put("rescode", 0);
        returnData.put("resdata", ReturnConstant.FAILMSG);
        return returnData;
    }

    @Override
    public List checkuserper(Map<String, Object> map) {
        String userPermission = dbClient.DbcheckUserPermission(map);
        Map userPermissionMap = JSON.parseObject(userPermission);
        List returnlist = new ArrayList();
        if (userPermissionMap != null) {
            String msg = (String) userPermissionMap.get("msg");
            String info = (String) userPermissionMap.get("info");
            if (ReturnConstant.PASSMSG.equals(msg) && StringUtil.isNullOrEmpty(info)) {
                List result = (List) userPermissionMap.get("result");
                for (int i = 0; i < result.size(); i++) {
                    Map permissionmap = (Map) result.get(i);
                    Map returndata = new HashMap(16);
                    if (!permissionmap.isEmpty()) {
                        returndata.put("rolename", permissionmap.get("rolename"));
                        Map permission = (Map) permissionmap.get("permission");
                        returndata.put("permissionId", (String) permission.get("id"));
                    }
                    returnlist.add(returndata);
                }
            }
        }
        return returnlist;
    }

    @Override
    public Map getUserData(Map map) {
        String userPermission = dbClient.DbcheckUser(map);
        Map userPermissionMap = JSON.parseObject(userPermission);
        Map returndata = new HashMap(16);
        if (userPermissionMap != null) {
            String msg = (String) userPermissionMap.get("msg");
            String info = (String) userPermissionMap.get("info");
            if (ReturnConstant.PASSMSG.equals(msg) && StringUtil.isNullOrEmpty(info)) {
                returndata = (Map) userPermissionMap.get("result");
            }
        }
        return returndata;
    }
}
