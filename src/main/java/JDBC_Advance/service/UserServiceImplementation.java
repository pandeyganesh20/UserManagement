package JDBC_Advance.service;

import JDBC_Advance.dao.UserDao;
import JDBC_Advance.dao.UserDaoImplementation;
import JDBC_Advance.model.User;

import java.util.List;

public class UserServiceImplementation implements UserService {

    UserDao userDao = new UserDaoImplementation();

    @Override
    public int saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }
}
