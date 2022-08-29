package mvc_springboot.web.service;

import mvc_springboot.web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(int id);

    void saveUser(User user);

    void removeUser(int id);

}
