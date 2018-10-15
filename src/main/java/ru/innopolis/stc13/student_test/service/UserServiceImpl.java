package ru.innopolis.stc13.student_test.service;

import org.springframework.stereotype.Service;
import ru.innopolis.stc13.student_test.pojo.Role;
import ru.innopolis.stc13.student_test.pojo.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean add(User user) {
        return false;
    }

    @Override
    public User get(Integer id) {
        return null;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean isUserExist(User user) {
        return false;
    }

    @Override
    public List<User> getAllByRole(Role role) {
        return null;
    }

}
