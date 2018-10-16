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

    @GetMapping("/teachers/edit/{teacher}")
    public String editTeacher(@PathVariable User teacher) {
        return "editTeacher";
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
    public String addTeacher(Model model) {
        model.addAttribute("teacher", new User());
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

    @GetMapping("/students/edit/{student}")
    public String editStudent(@PathVariable User student) {
        return "editStudent";
    }

    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute User user, Model model) {
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
    public String addStudent(Model model) {
        model.addAttribute("user", new User());
        return "editStudent";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/students";
    }

    @GetMapping("/admins")
    public String getAdmins(Model model) {
        List<User> admins = userService.getAllByRole(Role.ADMIN);
        model.addAttribute("admins", admins);
        return "admins";
    }

    @GetMapping("/admins/edit/{admin}")
    public String editAdmin(@PathVariable User admin) {
        return "editAdmins";
    }

    @PostMapping("/admins/save")
    public String saveAdmin(@ModelAttribute User user, Model model) {
        boolean isUserExist = userService.isUserExist(user);
        if (isUserExist) {
            boolean isUpdated = userService.update(user);
            if (!isUpdated) {
                model.addAttribute("error", "updated_error");
                return "editAdmin";
            }
        } else {
            boolean isCreated = userService.add(user);
            if (!isCreated) {
                model.addAttribute("error", "created_error");
                return "editAdmin";
            }
        }
        return "redirect:/admins";
    }

    @GetMapping("/admins/add")
    public String addAdmin(Model model) {
        model.addAttribute("user", new User());
        return "editAdmin";
    }

    @GetMapping("/admin/delete/{id}")
    public String deleteAdmin(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/admins";
    }


    @GetMapping
    public String getAll(Model model) {
        List<User> list = userService.getAll();
        model.addAttribute("users", list);
        return "users";
    }
}
