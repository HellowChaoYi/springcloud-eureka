package per.wei.cloud.dao.daoentity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author wei
 * @date 2020/8/27 11:23
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserWithRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String rolename;

    private String roleid;
}
