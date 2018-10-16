package ru.innopolis.stc13.student_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc13.student_test.pojo.Role;
import ru.innopolis.stc13.student_test.pojo.Specialization;
import ru.innopolis.stc13.student_test.pojo.User;
import ru.innopolis.stc13.student_test.service.SpecializationService;
import ru.innopolis.stc13.student_test.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private SpecializationService specializationService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setSpecializationService(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @GetMapping("/teachers")
    public String getTeachers(Model model) {
        List<User> teachers = userService.getAllByRole(Role.TEACHER);
        model.addAttribute("teachers", teachers);
        return "teachers";
    }

    @GetMapping("/teachers/edit/{teacher}")
    public String editTeacher(@PathVariable User teacher, Model model) {
        List<Specialization> specializations = specializationService.getAll();
        model.addAttribute("specialization", new Specialization());
        model.addAttribute("specializations", specializations);
        model.addAttribute("teacher", teacher);
        model.addAttribute("roles", Role.values());
        return "editTeacher";
    }

    @PostMapping("/teachers/save")
    public String saveTeacher(@ModelAttribute("teacher") User teacher,
                              Model model) {
        boolean isUserExist = userService.isUserExist(teacher);
        if (isUserExist) {
            boolean isUpdated = userService.update(teacher);
            if (!isUpdated) {
                model.addAttribute("error", "updated_error");
                return "editTeacher";
            }
        } else {
            boolean isCreated = userService.add(teacher);
            if (!isCreated) {
                model.addAttribute("error", "created_error");
                return "editTeacher";
            }
        }
        return "redirect:/users/teachers";
    }


    @GetMapping("/teachers/add")
    public String addTeacher(Model model) {
        model.addAttribute("teacher", new User());
        List<Specialization> specializations = specializationService.getAll();
        model.addAttribute("specializations", specializations);
        model.addAttribute("roles", Role.values());
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
    public String addStudent(Model model) {
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
