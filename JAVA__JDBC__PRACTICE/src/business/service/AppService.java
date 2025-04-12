package business.service;
import java.util.List;
public interface AppService<T> {
    List<T> findAllWithPaging();
    int save(T entity);
    boolean update(T entity);
    boolean delete(T entity);
}