package ru.innopolis.stc13.student_test.service;

import org.springframework.stereotype.Service;
import ru.innopolis.stc13.student_test.dao.GroupDao;
import ru.innopolis.stc13.student_test.dao.UserDao;
import ru.innopolis.stc13.student_test.pojo.Group;
import ru.innopolis.stc13.student_test.pojo.Role;
import ru.innopolis.stc13.student_test.pojo.User;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

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
        if (user == null || user.getLogin() != null) {
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
            return user.getId() != null && userDao.getOne(user.getId()) != null;
        }
    }

    @Override
    public List<User> getAllByRole(Role role) {
        List<User> list = userDao.getByRole(role);
        return list == null ? Collections.emptyList() : list;
    }


}
