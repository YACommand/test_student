package ru.innopolis.stc13.student_test.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import ru.innopolis.stc13.student_test.dao.UserDao;
import ru.innopolis.stc13.student_test.pojo.Role;
import ru.innopolis.stc13.student_test.pojo.User;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserDao userDao;

    final static Logger LOOGGER = Logger.getLogger(UserService.class);

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean add(User user) {

        if (user != null && !userDao.existsByLogin(user.getLogin())) {
            String password = user.getPassword();
            user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
            LOOGGER.info("has been added " + user.toString());
            return userDao.save(user) != null;
        }
        LOOGGER.info("failed to add");
        return false;
    }

    @Override
    public User get(Integer id) {
        if (id != null && userDao.existsById(id)) {
            LOOGGER.info("received " + userDao.findById(id));
            return userDao.findById(id).orElse(null);
        }
        LOOGGER.info("user extraction error");
        return null;
    }

    @Override
    public boolean update(User user) {
        if (user != null && userDao.existsById(user.getId())) {
            LOOGGER.info("update " + user.toString());
            return userDao.save(user) != null;
        }
        LOOGGER.info("update error");
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        if (userDao.existsById(id)) {
            userDao.deleteById(id);
            LOOGGER.info("user(id " + id + ") has been deleted");
            return true;
        }
        LOOGGER.info("error deleting user");
        return false;
    }

    @Override
    public List<User> getAll() {
        LOOGGER.info("user list received");
        return userDao.findAll();
    }

    @Override
    public boolean isUserExist(User user) {
        if (user != null && user.getId() != null && userDao.existsById(user.getId())) {
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllByRole(Role role) {
        List<User> list = userDao.getByRoles(role);
        LOOGGER.info("the requested list " + role.toString().toLowerCase() + "s");
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

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userDao.getByLogin(login);
    }
}
