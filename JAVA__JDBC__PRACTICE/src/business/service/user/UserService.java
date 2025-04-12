package business.service.user;

public interface UserService {
    boolean login(String username, String password);
    void logout();
}