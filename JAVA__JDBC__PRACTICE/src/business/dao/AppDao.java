package business.dao;

import java.util.List;

public interface AppDao<T> {
    List<T> findAll();
    int save(T t);
    int update(T t);
    int delete(T t);
}
