package per.wei.cloud.dao.daoentity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author wei
 * @since 2020-07-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysDatasource implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private String sourceId;

    private String datasource;

    private LocalDateTime updatatime;


}
