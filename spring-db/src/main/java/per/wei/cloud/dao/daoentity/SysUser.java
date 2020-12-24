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
 * @since 2020-09-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String username;

    private String password;

    private Integer sex;

    private String mobilephone;

    private String email;

    private String name;

    private LocalDateTime createtime;


}
