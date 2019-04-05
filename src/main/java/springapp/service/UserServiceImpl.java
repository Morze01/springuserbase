package springapp.service;

import org.springframework.stereotype.Service;
import springapp.dao.UserDAO;
import springapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public User getUser(int theId) {
        return userDAO.getUser(theId);
    }

    @Override
    @Transactional
    public void deleteUser(int theId) {
        userDAO.deleteUser(theId);
    }
}
