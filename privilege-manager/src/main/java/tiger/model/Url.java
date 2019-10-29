package tiger.model;

import java.io.Serializable;

/**
 * @ClassName Url
 * @Description TODO
 * @Author zeng.h
 * @Date 2019/10/29 18:53
 * @Version 1.0
 **/
public class Url implements Serializable {
    private static final long serialVersionUID = 3445021238903554372L;
    private int id;
    private String url;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
