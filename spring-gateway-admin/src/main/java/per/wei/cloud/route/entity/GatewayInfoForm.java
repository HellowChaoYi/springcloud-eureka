package per.wei.cloud.route.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

@Data
public class GatewayInfoForm{

    private static final long serialVersionUID = 1L;

    private Integer gatewayId;

    private String routId;

    private String uri;

    private Integer orderId;

    private Date createTime;

    private Date updateTime;

    public List<GatewayPredicates> getPredicates() {
        return predicates;
    }

    public void setPredicates(List<GatewayPredicates> predicates) {
        this.predicates = predicates;
    }

    public List<GatewayFilters> getFilters() {
        return filters;
    }

    public void setFilters(List<GatewayFilters> filters) {
        this.filters = filters;
    }

    private List<GatewayPredicates> predicates;
    private List<GatewayFilters> filters;

    public GatewayInfo topo(){
        GatewayInfo gatewayRoute = new GatewayInfo();
        BeanUtils.copyProperties(this, gatewayRoute);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            gatewayRoute.setFilters(objectMapper.writeValueAsString(this.getFilters()));
            gatewayRoute.setPredicates(objectMapper.writeValueAsString(this.getPredicates()));
        } catch (JsonProcessingException e) {
//            log.error("网关filter或predicates配置转换异常", e);
            System.out.println("网关filter或predicates配置转换异常");
        }
        return gatewayRoute;

    }
}
