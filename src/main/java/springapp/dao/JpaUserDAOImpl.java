package springapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springapp.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class JpaUserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

//    @Autowired
//    private InitialDataLoader initialDataLoader;
//
//    public JpaUserDAOImpl() {
//        System.out.println("User DAO initialisation");
//    }

    @Override
    @Transactional (readOnly = true)
    public List<User> getUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        User persistUser = entityManager.find(User.class,user.getId());
        if (persistUser == null) {
            entityManager.persist(user);
        } else {
            persistUser.updateUser(user);
        }
    }

    @Override
    @Transactional (readOnly = true)
    public User getUser(int theId) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id=:ID", User.class);
        return query.setParameter("ID",theId).getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void deleteUser(int theId) {
        User user = entityManager.find(User.class,theId);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        User persistUser = entityManager.find(User.class,user.getId());
        persistUser.updateUser(user);
    }

    @Override
    public User findByLogin(String login) {
        return entityManager.createQuery("select u from User u where u.login=:Login", User.class).setParameter("Login",login).getResultList().stream().findAny().orElse(null);
    }

}
