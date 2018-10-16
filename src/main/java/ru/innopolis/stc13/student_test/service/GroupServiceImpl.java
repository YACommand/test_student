package ru.innopolis.stc13.student_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc13.student_test.dao.GroupDao;
import ru.innopolis.stc13.student_test.pojo.Group;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private GroupDao groupDao;

    @Autowired
    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public boolean add(Group group) {
        if (group != null && group.getId() == null) {
            return groupDao.save(group) != null;
        }
        return false;
    }

    @Override
    public Group getById(Integer id) {
        return id == null ? null : groupDao.getOne(id);
    }

    @Override
    public boolean update(Group group) {
        if (group != null || groupDao.existsById(group.getId())) {
            return groupDao.save(group) != null;
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        if (groupDao.existsById(id)) {
            groupDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Group> getAll() {
        return groupDao.findAll();
    }

    @Override
    public boolean isGroupExist(Group group) {
        if (group == null) {
            return false;
        } else {
            return group.getId() != null && groupDao.existsById(group.getId());
        }
    }

    @Override
    public boolean validate(Group group) {
        if (group == null) {
            return false;
        }
        String name = group.getName();
        Integer number = group.getNumber();
        return name != null && !name.equals("") &&
                number != null && number>0&& number.equals(number);
    }

    @Override
    public boolean isNumberExist(Group group) {
        if (group==null){
            return false;
        }else{
            return group.getNumber()!=null&& groupDao.getByNumber(group.getNumber())!=null;
        }
    }
}
