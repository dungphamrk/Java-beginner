package business.dao.user;

public interface UserDao {
    boolean login(String username,String password);
    void logout();
}
