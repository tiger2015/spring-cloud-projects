package tiger.dao;

import org.apache.ibatis.annotations.Mapper;
import tiger.model.Permission;

import java.util.List;

@Mapper
public interface PermissionDao {
    Long insert(Permission permission);

    Permission select(int id);

    List<Permission> selectByName(String name);

    boolean delete(int id);
}
