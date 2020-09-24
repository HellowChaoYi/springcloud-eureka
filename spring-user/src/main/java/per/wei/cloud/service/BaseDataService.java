package per.wei.cloud.service;

import java.util.List;
import java.util.Map;

/**
 * @author wei
 * @date 2020/8/11 15:14
 **/
public interface BaseDataService {
    List getmenulist(Map map);
    Map<String,Object> checkisuser(Map<String,Object> map);
    List checkuserper(Map<String,Object> map);
    Map getUserData(Map map);
}
