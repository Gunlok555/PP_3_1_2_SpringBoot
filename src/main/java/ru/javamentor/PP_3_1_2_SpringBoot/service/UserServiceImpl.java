package ru.javamentor.PP_3_1_2_SpringBoot.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.PP_3_1_2_SpringBoot.dao.UserDao;
import ru.javamentor.PP_3_1_2_SpringBoot.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }
    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public User getUserById(Integer id) {
        return dao.getUserById(id);
    }

    @Override
    public void saveUser(User user) {
        dao.saveUser(user);
    }

    @Override
    public void updateUser(Integer id, User updatedUser) {
        dao.updateUser(id,updatedUser);
    }

    @Override
    public void dropUser(Integer id) {
        dao.dropUser(id);
    }
}
