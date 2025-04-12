package business.dao;

import java.util.List;

public interface AppDao<T> {
    List<T> findAll();
    int save(T t);
    boolean update(T t);
    boolean delete(T t);
}
