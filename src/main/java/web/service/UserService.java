package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void editUser(User user);

    void deleteUser(long id);

    List<User> listUsers();

    User getUserById(long id);

}
