package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void editUser(User user);

    void deleteUser(long id);

    List<User> listUsers();

    User getUserById(long id);

    Role getRoleById(long id);

    User getUserByName(String name);

}
