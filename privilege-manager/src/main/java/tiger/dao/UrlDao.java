package tiger.dao;

import org.apache.ibatis.annotations.Mapper;
import tiger.model.Url;

import java.util.List;

@Mapper
public interface UrlDao {

    void insert(Url url);

    Url select(int id);

    List<Url> selectByName(String url);

    void delete(int id);

    List<Url> selectAllUrls();
}
