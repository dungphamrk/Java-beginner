package business.service;
import java.util.List;
public interface AppService<T> {
    List<T> findAllWithPaging(int page, int size);
    int save(T entity);
    int update(T entity);
    int delete(T entity);
}