package ru.innopolis.stc13.student_test.service;

import ru.innopolis.stc13.student_test.dao.UserDao;
import ru.innopolis.stc13.student_test.pojo.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public boolean add(User user) {
        if (user == null){
            return false;
        } else if (userDao.getByLogin(user.getLogin())!=null){
            return false;
        }
        return userDao.save(user)!=null;
    }

    @Override
    public User get(Integer id) {
        if (id == null){
            return null;
        }
        return userDao.getOne(id);
    }

    @Override
    public boolean update(User user) {
        if (user ==null||user.getLogin()!=null){
            return false;
        }else {
            return userDao.save(user)!=null;
        }
    }

    @Override
    public boolean delete(Integer id) {
        if (userDao.existsById(id)){
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
        if (user ==null){
            return false;
        }else {
            return user.getId()!=null&&userDao.getOne(user.getId())!=null;
        }
    }

    @Override
    public List<User> getAllByRole(User user) {
        return null;
    }

    @Override
    public List<User> getRoleById(Integer id) {
        return null;
    }
}
