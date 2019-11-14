package tiger.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tiger.entity.SysRole;

/**
 * @ClassName SysRoleMapper
 * @Description TODO
 * @Author tiger
 * @Date 2019/11/14 21:01
 * @Version 1.0
 **/
@Mapper
public interface SysRoleMapper {
    @Select("select * from sys_role where id = #{id}")
    SysRole selectById(Integer id);
}
