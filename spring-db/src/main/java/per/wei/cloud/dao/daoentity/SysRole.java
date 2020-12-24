package per.wei.cloud.dao.daoentity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wei
 * @since 2020-08-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String rolename;

    private String rolecode;

    private LocalDateTime createtime;

    private String desciption;


}
