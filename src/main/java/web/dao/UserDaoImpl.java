package web.dao;

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
        return em.createQuery("from usersEntity").getResultList();
    }

    @Override
    public User getUserById(long id) {
        return em.find(User.class, id);
    }
}
