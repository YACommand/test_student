package ru.innopolis.stc13.student_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import ru.innopolis.stc13.student_test.pojo.Group;
import ru.innopolis.stc13.student_test.pojo.Test;

import ru.innopolis.stc13.student_test.pojo.User;
import ru.innopolis.stc13.student_test.service.TestService;
import ru.innopolis.stc13.student_test.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class PersonalPageController {

    private UserService userService;
    private TestService testService;

    @Autowired
    private UserDao userDao;

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/user_page")
    public String viewGroups(Principal principal, Model model) {
        String userLogin = principal.getName();

        User user = userService.getByLogin(userLogin);
        List<Test> test = testService.getTestByUserId(user.getId());

        model.addAttribute("user", user);
        model.addAttribute("tests", test);
        model.addAttribute("groups", user.getGroups());
        return "teacherPage";
    }

    @GetMapping("/user_page/groups/{group}")
    public String getStudents(@PathVariable Group group,
                              Model model) {
        List<User> userList = userService.getByGroup(group);
        model.addAttribute("users", userList);
        return "studentsByGroup";
    }
}
