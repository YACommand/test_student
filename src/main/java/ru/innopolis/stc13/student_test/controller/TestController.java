package ru.innopolis.stc13.student_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.innopolis.stc13.student_test.dao.AdminDao;
import ru.innopolis.stc13.student_test.dao.GroupDao;
import ru.innopolis.stc13.student_test.pojo.Admin;
import ru.innopolis.stc13.student_test.pojo.Group;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private GroupDao groupDao;

    @RequestMapping("/testAdminDao")
    public @ResponseBody
    Iterable<Admin> testAdmin() {
        return adminDao.findAll();
    }

    @RequestMapping("/testGroupDao")
    public @ResponseBody
    Iterable<Group> testGroup() {
        return groupDao.findAll();
    }

    @RequestMapping("/")
    public String test() {
        return "index";
    }
}