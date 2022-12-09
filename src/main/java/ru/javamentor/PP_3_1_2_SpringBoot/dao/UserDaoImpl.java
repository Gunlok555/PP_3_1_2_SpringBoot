package ru.javamentor.PP_3_1_2_SpringBoot.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Repository;
import ru.javamentor.PP_3_1_2_SpringBoot.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<User> getAllUsers() {
        List<User> users = entityManager.createQuery("select us from User us").getResultList();
        return users;
    }

    @Override
    @Transactional
    public User getUserById(Integer id) {
        return entityManager.find(User.class,id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(Integer id, User updatedUser) {
        User user = entityManager.find(User.class,id);
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
    }

    @Override
    @Transactional
    public void dropUser(Integer id) {
        entityManager.remove(getUserById(id));
    }
}
