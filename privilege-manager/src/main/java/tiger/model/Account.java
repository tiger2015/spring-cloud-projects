package tiger.model;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Account
 * @Description TODO
 * @Author zeng.h
 * @Date 2019/10/29 18:48
 * @Version 1.0
 **/
public class Account implements Serializable {
    private static final long serialVersionUID = -8205624531255044905L;

    private long id;
    private String name;
    private String password;

    private List<Role> roleList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
