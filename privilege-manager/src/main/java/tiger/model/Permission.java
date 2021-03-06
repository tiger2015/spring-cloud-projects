package tiger.model;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Permission
 * @Description TODO
 * @Author zeng.h
 * @Date 2019/10/29 18:52
 * @Version 1.0
 **/
public class Permission implements Serializable {
    private static final long serialVersionUID = -3200994688929509194L;
    private Integer id;
    private String description;
    private String name;

    private String url;

    private List<Url> urlList; // 一个权限包含多个URL

    private List<Role> roles; //一个权限可能属于多个角色

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Url> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<Url> urlList) {
        this.urlList = urlList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
