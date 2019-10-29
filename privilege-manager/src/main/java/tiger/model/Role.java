package tiger.model;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Role
 * @Description TODO
 * @Author zeng.h
 * @Date 2019/10/29 18:51
 * @Version 1.0
 **/
public class Role implements Serializable {
    private static final long serialVersionUID = 3384977850523387046L;

    private int id;
    private String name;
    private String description;

    private List<Permission> permissionList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
