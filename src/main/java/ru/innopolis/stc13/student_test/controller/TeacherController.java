package ru.innopolis.stc13.student_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.stc13.student_test.pojo.Teacher;
import ru.innopolis.stc13.student_test.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<Teacher> list = teacherService.getAll();
        model.addAttribute("teachers", list);
        return "teachers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        teacherService.delete(id);
        return "redirect:/teachers";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "editTeacher";
    }

    @GetMapping("/edit/{teacher}")
    public String edit(@PathVariable Teacher teacher) {
        return "editTeacher";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Teacher teacher, Model model) {
        if (teacherService.get(teacher.getId()) != null) {
            boolean isUpdated = teacherService.update(teacher);
            if (!isUpdated) {
                model.addAttribute("error", "updated_error");
                return "editTeacher";
            }
        } else {
            boolean isCreated = teacherService.add(teacher);
            if (!isCreated) {
                model.addAttribute("error", "created_error");
                return "editTeacher";
            }
        }
        return "redirect:/teachers";
    }
}