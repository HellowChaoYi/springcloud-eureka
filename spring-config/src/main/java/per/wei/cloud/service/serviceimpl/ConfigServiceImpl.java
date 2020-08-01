package per.wei.cloud.service.serviceimpl;

import java.util.Map;

public interface ConfigServiceImpl {
    public Map<String,Object> get(Map<String,Object> params);
    public String updata(Map<String,Object> params);
}
