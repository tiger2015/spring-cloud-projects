package tiger.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.dao.PermissionDao;
import tiger.model.Account;
import tiger.model.PageInfo;
import tiger.model.Permission;
import tiger.model.Url;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName PermissionServiceImpl
 * @Description TODO
 * @Author tiger
 * @Date 2019/10/29 23:12
 * @Version 1.0
 **/
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public void addPermission(Permission permission) {
        permissionDao.insert(permission);
    }

    @Override
    public Permission getPermission(int id) {
        return permissionDao.select(id);
    }

    @Override
    public Permission getPermissionByName(String name) {
        return permissionDao.selectByName(name);
    }

    @Override
    public Map<String, Object> searchPermissionByName(String name, int pageNumber, int pageSize) {
        Page<Account> page = PageHelper.startPage(pageNumber, pageSize);
        Map<String, Object> result = new HashMap<>();
        List<Permission> permissions = permissionDao.selectLikeName(name);
        result.put("permissions", permissions);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotal(page.getPages());
        pageInfo.setPageSize(page.getPageSize());
        pageInfo.setCurrent(page.getPageNum());
        result.put("pageInfo", pageInfo);
        return result;
    }

    @Override
    public Map<String, Object> getPermissionByPage(int startPage, int pageSize) {
        Page<Object> page = PageHelper.startPage(startPage, pageSize);
        List<Permission> permissions = permissionDao.selectAll();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotal(page.getPages());
        pageInfo.setPageSize(page.getPageSize());
        pageInfo.setCurrent(page.getPageNum());
        Map<String, Object> result = new HashMap<>();
        result.put("result", permissions);
        result.put("pageInfo", pageInfo);
        return result;
    }

    @Override
    public void removePermission(int id) {
        permissionDao.delete(id);
    }

    @Override
    public void addUrl(int permissionId, int urlId) {
        permissionDao.insertUrl(permissionId, urlId);
    }

    @Override
    public void removeUrl(int permissioinId, int urlId) {
        permissionDao.deleteUrl(permissioinId, urlId);
    }

    @Override
    public List<Url> getAllUrls(int id) {
        return permissionDao.selectAllUrls(id);
    }
}
