package ru.innopolis.stc13.student_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc13.student_test.pojo.Group;
import ru.innopolis.stc13.student_test.pojo.Role;
import ru.innopolis.stc13.student_test.pojo.Specialization;
import ru.innopolis.stc13.student_test.pojo.User;
import ru.innopolis.stc13.student_test.service.GroupService;
import ru.innopolis.stc13.student_test.service.SpecializationService;
import ru.innopolis.stc13.student_test.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private SpecializationService specializationService;
    private GroupService groupService;

    @Autowired
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

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

        model.addAttribute("groups", groupService.getAll());

        model.addAttribute("roles", Role.values());
        return "editTeacher";
    }

    @PostMapping("/teachers/save")
    public String saveTeacher(@ModelAttribute("teacher") User teacher, Model model) {
        if (!userService.validate(teacher)) {
            model.addAttribute("error", "validation_error");

            model.addAttribute("groups", groupService.getAll());

            model.addAttribute("roles", Role.values());
            List<Specialization> specializations = specializationService.getAll();
            model.addAttribute("specializations", specializations);
            model.addAttribute("teacher", teacher);
            return "editTeacher";
        }
        boolean isUserExist = userService.isUserExist(teacher);
        if (isUserExist) {
            boolean isUpdated = userService.update(teacher);
            if (!isUpdated) {
                model.addAttribute("error", "updated_error");
                model.addAttribute("roles", Role.values());
                List<Specialization> specializations = specializationService.getAll();
                model.addAttribute("specializations", specializations);
                model.addAttribute("teacher", teacher);
                return "editTeacher";
            }
        } else {
            boolean isCreated = userService.add(teacher);
            if (!isCreated) {
                model.addAttribute("error", "created_error");
                model.addAttribute("roles", Role.values());
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

        model.addAttribute("groups", groupService.getAll());

        model.addAttribute("roles", Role.values());
        return "editTeacher";
    }

    @GetMapping("/teachers/delete/{id}")
    public String deleteTeacher(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/users/teachers";
    }

    @GetMapping("/students")
    public String getStudents(Model model) {
        List<User> students = userService.getAllByRole(Role.STUDENT);
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/students/edit/{student}")
    public String editStudent(@PathVariable User student, Model model) {
        model.addAttribute("student", student);
        model.addAttribute("groups", groupService.getAll());
        model.addAttribute("roles", Role.values());
        return "editStudent";
    }

    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute("student") User student, Model model) {
        if (!userService.validate(student)) {
            model.addAttribute("error", "validation_error");
            model.addAttribute("roles", Role.values());
            model.addAttribute("student", student);
            return "editStudent";
        }
        boolean isUserExist = userService.isUserExist(student);
        if (isUserExist) {
            boolean isUpdated = userService.update(student);
            if (!isUpdated) {
                model.addAttribute("error", "updated_error");
                model.addAttribute("groups", groupService.getAll());
                model.addAttribute("roles", Role.values());
                model.addAttribute("student", student);
                return "editStudent";
            }
        } else {
            boolean isCreated = userService.add(student);
            if (!isCreated) {
                model.addAttribute("error", "created_error");
                model.addAttribute("roles", Role.values());
                return "editStudent";
            }
        }
        return "redirect:/users/students";
    }

    @GetMapping("/students/add")
    public String addStudent(Model model) {
        model.addAttribute("student", new User());
        model.addAttribute("groups", groupService.getAll());
        model.addAttribute("roles", Role.values());
        return "editStudent";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/users/students";
    }


    @GetMapping("/admins")
    public String getAdmins(Model model) {
        List<User> admins = userService.getAllByRole(Role.ADMIN);
        model.addAttribute("admins", admins);
        return "admins";
    }

    @GetMapping("/admins/edit/{admin}")
    public String editAdmin(@PathVariable User admin,
                            Model model) {
        model.addAttribute("admin", admin);
        model.addAttribute("roles", Role.values());
        return "editAdmin";
    }

    @PostMapping("/admins/save")
    public String saveAdmin(@ModelAttribute("admin") User admin, Model model) {
        if (!userService.validate(admin)) {
            model.addAttribute("error", "validation_error");
            model.addAttribute("roles", Role.values());
            model.addAttribute("admin", admin);
            return "editAdmin";
        }
        boolean isUserExist = userService.isUserExist(admin);
        if (isUserExist) {
            boolean isUpdated = userService.update(admin);
            if (!isUpdated) {
                model.addAttribute("error", "updated_error");
                model.addAttribute("roles", Role.values());
                model.addAttribute("admin", admin);
                return "editAdmin";
            }
        } else {
            boolean isCreated = userService.add(admin);
            if (!isCreated) {
                model.addAttribute("error", "created_error");
                model.addAttribute("roles", Role.values());
                return "editAdmin";
            }
        }
        return "redirect:/users/admins";
    }

    @GetMapping("/admins/add")
    public String addAdmin(Model model) {
        model.addAttribute("admin", new User());
        model.addAttribute("roles", Role.values());
        return "editAdmin";
    }

    @GetMapping("/admins/delete/{id}")
    public String deleteAdmin(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/users/admins";
    }

    @GetMapping
    public String getAll(Model model) {
        List<User> list = userService.getAll();
        model.addAttribute("users", list);
        return "users";
    }
}
