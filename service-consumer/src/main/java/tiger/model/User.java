package tiger.model;


import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author zeng.h
 * @Date 2019/10/26 18:10
 * @Version 1.0
 **/
public class User implements Serializable {
    private static final long serialVersionUID = 7890977077077065476L;

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
