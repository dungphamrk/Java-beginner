package business.service.user;

import business.dao.user.UserDao;
import business.dao.user.UserDaoImp;

public class UserServiceImp implements UserService {
    private final UserDao userDao;

    public UserServiceImp() {
        userDao = new UserDaoImp();
    }

    @Override
    public boolean login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public void logout() {
        userDao.logout();
    }
}