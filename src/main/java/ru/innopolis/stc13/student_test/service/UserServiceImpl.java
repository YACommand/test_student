package ru.innopolis.stc13.student_test.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import ru.innopolis.stc13.student_test.dao.UserDao;
import ru.innopolis.stc13.student_test.pojo.Group;
import ru.innopolis.stc13.student_test.pojo.Role;
import ru.innopolis.stc13.student_test.pojo.User;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserDao userDao;

    final static Logger LOGGER = Logger.getLogger(UserService.class);

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean add(User user) {

        if (user != null && !userDao.existsByLogin(user.getLogin())) {

            String password = user.getPassword();
            user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
            LOGGER.info("has been added " + user.toString());
            return userDao.save(user) != null;
        }
        LOGGER.info("failed to add");
        return false;
    }

    @Override
    public User get(Integer id) {
        if (id != null && userDao.existsById(id)) {
            User user = userDao.findById(id).orElse(null);
            LOGGER.info("received " + user);
            return user;
        }
        LOGGER.info("user extraction error");
        return null;
    }

    @Override
    public boolean update(User user) {
        if (user != null && userDao.existsById(user.getId())) {
            User userFromDB = userDao.findById(user.getId()).orElse(null);
            if (userFromDB != null) {
                userFromDB.setRoles(user.getRoles());
                userFromDB.setGroups(user.getGroups());
                userFromDB.setId(user.getId());
                userFromDB.setLogin(user.getLogin());
                userFromDB.setName(user.getName());
                userFromDB.setSpecialization(user.getSpecialization());
                LOGGER.info("update " + user.toString());
                return userDao.save(userFromDB) != null;
            }
        }
        LOGGER.info("update error");
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        if (userDao.existsById(id)) {
            userDao.deleteById(id);
            LOGGER.info("user(id " + id + ") has been deleted");
            return true;
        }
        LOGGER.info("error deleting user");
        return false;
    }

    @Override
    public List<User> getAll() {
        LOGGER.info("user list received");
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
        LOGGER.info("the requested list " + role.toString().toLowerCase() + "s");
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
    public User getByLogin(String login) {
        if (login != null && userDao.existsByLogin(login)) {
            return userDao.getByLogin(login);
        }
        return null;
    }

    @Override
    public List<User> getByGroup(Group group) {
        List<User> list = userDao.getByGroups(group);
        return list == null ? Collections.emptyList() : list;
    }

    @Override
    public boolean updatePassword(Integer id, String password) {
        if (id != null && password != null) {
            User user = get(id);
            if (user != null) {
                user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
                return update(user);
            }
        }
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userDao.getByLogin(login);

    }
}
