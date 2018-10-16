package ru.innopolis.stc13.student_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc13.student_test.dao.UserDao;
import ru.innopolis.stc13.student_test.pojo.Role;
import ru.innopolis.stc13.student_test.pojo.User;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean add(User user) {
        if (user == null) {
            return false;
        } else if (userDao.getByLogin(user.getLogin()) != null) {
            return false;
        }
        return userDao.save(user) != null;
    }

    @Override
    public User get(Integer id) {
        if (id == null) {
            return null;
        }
        return userDao.getOne(id);
    }

    @Override
    public boolean update(User user) {
        if (user == null || user.getId() == null) {
            return false;
        } else {
            return userDao.save(user) != null;
        }
    }

    @Override
    public boolean delete(Integer id) {
        if (userDao.existsById(id)) {
            userDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public boolean isUserExist(User user) {
        if (user == null) {
            return false;
        } else {
            return user.getId() != null && userDao.existsById(user.getId());
        }
    }

    @Override
    public List<User> getAllByRole(Role role) {
        List<User> list = userDao.getByRoles(role);
        return list == null ? Collections.emptyList() : list;
    }

    @Override
    public boolean validate(User user) {
        if (user == null) {
            return false;
        }
        String name = user.getName();
        String login = user.getLogin();
        String password = user.getPassword();
        Set<Role> roles = user.getRoles();
        return name != null && !name.equals("") &&
                login != null && !login.equals("") &&
                password != null && !password.equals("") &&
                roles != null && !roles.isEmpty();
    }
}
