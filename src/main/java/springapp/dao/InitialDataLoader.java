package springapp.dao;


import com.mysql.jdbc.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import springapp.model.User;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.sql.ResultSet;
import java.sql.Statement;

@Component
@Transactional
public class InitialDataLoader {

//    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public InitialDataLoader(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
        InitialFillingUsersTable();
    }

//    @PostConstruct
    public void InitialFillingUsersTable () {
        try {
//            entityManager.getTransaction().begin();
//            entityManager.createNativeQuery("INSERT INTO users (name, password, login, role) VALUES ('user1', 'user1', 'user1', 'user'),  ('admin1', 'admin1', 'admin1', 'admin')").executeUpdate();
//            entityManager.getTransaction().commit();
//            entityManager.persist(new User("user1", "user1", "user1", "user"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        System.out.println("@PostConstruct work");
    }
}
