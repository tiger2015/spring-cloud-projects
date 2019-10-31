package tiger.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.dao.UrlDao;
import tiger.model.PageInfo;
import tiger.model.Url;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UrlServiceImpl
 * @Description TODO
 * @Author tiger
 * @Date 2019/10/31 20:39
 * @Version 1.0
 **/
@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlDao urlDao;

    @Override
    public void addUrl(Url url) {
        urlDao.insert(url);
    }

    @Override
    public void deleteUrl(int id) {
        urlDao.delete(id);
    }

    @Override
    public List<Url> getByName(String name) {
        return urlDao.selectByName(name);
    }

    @Override
    public Url getUrl(int id) {
        return urlDao.select(id);
    }


    @Override
    public Map<String, Object> getUrlByPage(int pageNumber, int pageSize) {
        Page<Url> page = PageHelper.startPage(pageNumber, pageSize);
        List<Url> urls = urlDao.selectAllUrls();
        Map<String, Object> result = new HashMap<>();
        result.put("result", urls);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotal(page.getPages());
        pageInfo.setCurrent(page.getPageNum());
        pageInfo.setPageSize(page.getPageSize());
        result.put("pageInfo", pageInfo);
        return result;
    }
}
