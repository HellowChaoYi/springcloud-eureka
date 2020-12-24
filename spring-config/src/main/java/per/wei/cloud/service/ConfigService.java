package per.wei.cloud.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;
import per.wei.cloud.constant.ConfigConstant;
import per.wei.cloud.constant.ReturnConstant;
import per.wei.cloud.service.serviceimpl.ConfigServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author wei
 */
@Component
public class ConfigService implements ConfigServiceImpl {
    @Value("${nacos.server-addr}")
    String serverAddr;

    @Override
    public Map<String,Object> get(Map<String, Object> params) {
        String dataId = (String) params.get(ConfigConstant.DATAID);
        String group = (String) params.get(ConfigConstant.GROUP);
        String namespace = (String) params.get(ConfigConstant.NAMESPACE);

        Map<String,Object> res = new HashMap<>();
        try {
            if (namespace == null && namespace.equals(null)) {
                namespace = "";
            }
            Properties properties = new Properties();
            properties.put(ConfigConstant.SERVERADDR, serverAddr);
            properties.put(ConfigConstant.NAMESPACE, namespace);
            com.alibaba.nacos.api.config.ConfigService configService = NacosFactory.createConfigService(properties);
            String content = configService.getConfig(dataId, group, 5000);
            if (content != null && !content.equals(null)) {
                Yaml yaml = new Yaml();
                Map<String, Object> resultYamlMap = yaml.load(content);
                return resultYamlMap;
            } else {
                res.put(ReturnConstant.FAILMSG,"无此配置，请检查yaml文件");
                return res;
            }
        } catch (NacosException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public String updata(Map<String, Object> map) {
        return null;
    }
}
