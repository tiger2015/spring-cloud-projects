package tiger.model;

import java.io.Serializable;

/**
 * @ClassName PageInfo
 * @Description TODO
 * @Author tiger
 * @Date 2019/10/31 22:13
 * @Version 1.0
 **/
public class PageInfo implements Serializable {
    private static final long serialVersionUID = 5285145201942354035L;
    private int total;
    private int current;
    private int pageSize;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
