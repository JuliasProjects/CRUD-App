package service;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();


    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void removeUser(long id) {
        userDao.removeUser(id);

    }

    @Override
    public void updateUser(@Valid User user) {
        userDao.updateUser(user);

    }
}
