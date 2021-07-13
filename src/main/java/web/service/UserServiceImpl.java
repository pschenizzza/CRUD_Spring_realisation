package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.dao.UserDao;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserDao userDao;
    private RoleDao roleDao;
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao, PasswordEncoder bCryptPasswordEncoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void addUser(web.model.User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleDao.getRoleById(1L));
        user.setRoles(roleSet);
        userDao.addUser(user);
    }

    @Override
    public void editUser(web.model.User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.editUser(user);
    }

    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    public List<web.model.User> listUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public web.model.User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public Role getRoleById(long id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userDao.getUserByName(name);
    }
}