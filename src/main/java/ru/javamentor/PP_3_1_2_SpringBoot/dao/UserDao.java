package ru.javamentor.PP_3_1_2_SpringBoot.dao;




import ru.javamentor.PP_3_1_2_SpringBoot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUserById(Integer id);

    void saveUser(User user);

    void updateUser(Integer id, User updatedUser);

    void dropUser(Integer id);
}
