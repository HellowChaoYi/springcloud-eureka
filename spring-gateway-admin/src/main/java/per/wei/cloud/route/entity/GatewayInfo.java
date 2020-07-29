package per.wei.cloud.route.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * InnoDB free: 10240 kB
 * </p>
 *
 * @author wei
 * @since 2019-09-11
 */
@Data
//@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GatewayInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value="gateway_id")
    private Integer gatewayId;

    private String routId;

    private String predicates;

    private String filters;

    private String uri;

    private Integer orderId;

    private Date createTime;

    private Date updateTime;

    public String getPredicates() {
        return predicates;
    }

    public void setPredicates(String predicates) {
        this.predicates = predicates;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }
}
