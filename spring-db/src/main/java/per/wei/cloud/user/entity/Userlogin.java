package per.wei.cloud.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * InnoDB free: 10240 kB
 * </p>
 *
 * @author wei
 * @since 2019-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Userlogin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("Id_key")
    private String idKey;

    private String username;

    private String password;


}
