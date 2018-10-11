package ru.innopolis.stc13.student_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.stc13.student_test.pojo.Teacher;
import ru.innopolis.stc13.student_test.service.TeacherService;

import java.util.List;

@Controller
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping("/teachers")
    public String getBrands(Model model) {
        List<Teacher> list = teacherService.getAll();
        model.addAttribute("teachers", list);
        return "teachers";
    }
}
