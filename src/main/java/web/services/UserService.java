package web.services;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(Long id);
    void addUser(User user);
    void removeUser(Long id);
    void updateUser(User user);

}
