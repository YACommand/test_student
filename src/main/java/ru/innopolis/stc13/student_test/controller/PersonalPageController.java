package ru.innopolis.stc13.student_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.innopolis.stc13.student_test.pojo.User;
import ru.innopolis.stc13.student_test.service.UserService;

import java.security.Principal;

@Controller
public class PersonalPageController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user_page")
    public String viewUser(Principal principal, Model model) {
        String userLogin = principal.getName();
        User user = userService.getByLogin(userLogin);
        model.addAttribute("user", user);
        return "teacherPage";
    }
}
