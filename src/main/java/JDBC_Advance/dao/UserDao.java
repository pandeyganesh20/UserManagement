package JDBC_Advance.dao;

import JDBC_Advance.model.User;

import java.util.List;

public interface UserDao {

    int saveUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
    User getUserById(int id);
    List<User> getAllUser();
}
