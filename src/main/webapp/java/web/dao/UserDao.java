package dao;

import model.User;

import javax.validation.Valid;
import java.util.List;

public interface UserDao {
    List<User> getAllUsers ();
    User getUserById(long id);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(@Valid User user);
}
