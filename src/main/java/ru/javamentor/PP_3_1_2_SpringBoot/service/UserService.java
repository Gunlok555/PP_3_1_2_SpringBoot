package ru.javamentor.PP_3_1_2_SpringBoot.service;



import ru.javamentor.PP_3_1_2_SpringBoot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Integer id);

    void saveUser(User user);

    void updateUser(Integer id, User updatedUser);

    void dropUser(Integer id);
}
