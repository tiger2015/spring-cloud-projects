package tiger.dao;

import org.apache.ibatis.annotations.Mapper;
import tiger.model.Role;

import java.util.List;

@Mapper
public interface RoleDao {

    int insert(Role role);

    Role select(int id);

    List<Role> selectByName(String name);

    boolean delete(int id);
}
