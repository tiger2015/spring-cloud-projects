package tiger.service;

import tiger.model.Url;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UrlService
 * @Description TODO
 * @Author tiger
 * @Date 2019/10/31 20:37
 * @Version 1.0
 **/
public interface UrlService {

    void addUrl(Url url);

    void deleteUrl(int id);

    List<Url> getByName(String name);

    Url getUrl(int id);

    Map<String,Object> getUrlByPage(int pageNumber, int pageSize);
}
