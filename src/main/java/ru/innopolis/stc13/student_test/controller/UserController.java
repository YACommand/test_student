package ru.innopolis.stc13.student_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc13.student_test.pojo.Role;
import ru.innopolis.stc13.student_test.pojo.User;
import ru.innopolis.stc13.student_test.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/teachers")
    public String getTeachers(Model model) {
        List<User> teachers = userService.getAllByRole(Role.TEACHER);
        model.addAttribute("teachers", teachers);
        return "teachers";
    }

    @GetMapping("/teachers/edit/{user}")
    public String editTeacher(@PathVariable User user) {
        return "editTeachers";
    }

    @PostMapping("/teachers/save")
    public String saveTeacher(@ModelAttribute User user, Model model) {
        boolean isUserExist = userService.isUserExist(user);
        if (isUserExist) {
            boolean isUpdated = userService.update(user);
            if (!isUpdated) {
                model.addAttribute("error", "updated_error");
                return "editTeacher";
            }
        } else {
            boolean isCreated = userService.add(user);
            if (!isCreated) {
                model.addAttribute("error", "created_error");
                return "editTeacher";
            }
        }
        return "redirect:/teachers";
    }


    @GetMapping("/teachers/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "editTeacher";
    }

    @GetMapping("/teachers/delete/{id}")
    public String deleteTeacher(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/teachers";
    }

    @GetMapping("/students")
    public String getStudents(Model model) {
        List<User> students = userService.getAllByRole(Role.STUDENT);
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/students/edit/{user}")
    public String editStudent(@PathVariable User user) {
        return "editStudent";
    }

    @PostMapping("/students/save")
    public String save(@ModelAttribute User user, Model model) {
        boolean isUserExist = userService.isUserExist(user);
        if (isUserExist) {
            boolean isUpdated = userService.update(user);
            if (!isUpdated) {
                model.addAttribute("error", "updated_error");
                return "editStudent";
            }
        } else {
            boolean isCreated = userService.add(user);
            if (!isCreated) {
                model.addAttribute("error", "created_error");
                return "editStudent";
            }
        }
        return "redirect:/students";
    }

    @GetMapping("/students/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "editStudent";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/students";
    }


    @GetMapping
    public String getAll(Model model) {
        List<User> list = userService.getAll();
        model.addAttribute("users", list);
        return "users";
    }
}
