package mvc_springboot.web.dao;

import mvc_springboot.web.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    User getUserById(int id);

    void saveUser(User user);

    void removeUser(int id);

}
