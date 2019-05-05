package springapp.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import springapp.dao.JpaUserDAOImpl;
import springapp.dao.UserDAO;
import springapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
//    @Qualifier ("JpaUserDAOImpl")
    private UserDAO userDAO;

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public User getUser(int theId) {
        return userDAO.getUser(theId);
    }

    @Override
    public void deleteUser(int theId) {
        userDAO.deleteUser(theId);
    }
}
