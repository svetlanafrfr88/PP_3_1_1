package mvc_springboot.web.dao;

import mvc_springboot.web.model.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void removeUser(int id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void saveUser(User user) {
        entityManager.unwrap(Session.class).saveOrUpdate(user);
    }
}
