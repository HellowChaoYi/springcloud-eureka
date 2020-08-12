package per.wei.cloud.dao.daoentity;

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
 * @since 2020-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    private String menuId;

    private String title;

    private String icon;

    private String parentId;

    private Integer sort;

    private Integer level;

    private String name;

    private String path;

    private String compent;

    private String description;

    private Integer state;


}
