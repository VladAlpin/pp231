package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void addUser(User user);

    User getUserById(Long id);

    void removeUser(Long id);

    void updateUser(User user);
}
