package web.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void deleteUser(long id) {
        em.createQuery("delete from usersEntity where id=:id").setParameter("id", id).executeUpdate();
    }

    @Override
    public void editUser(User user) {
        em.merge(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = em.createQuery("from usersEntity u join fetch u.roles ").getResultList();
        return userList;
    }

    @Override
    public User getUserById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public User getUserByName(String name) {
        User user = (User) em.createQuery("from usersEntity u where u.login=:name").setParameter("name", name).getSingleResult();
        Hibernate.initialize(user.getRoles());
        return user;
    }
}