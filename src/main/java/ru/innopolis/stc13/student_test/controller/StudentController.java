package ru.innopolis.stc13.student_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.stc13.student_test.pojo.Student;
import ru.innopolis.stc13.student_test.service.StudentService;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/students")
    public String getBrands(Model model) {
        List<Student> list = studentService.getAll();
        model.addAttribute("students", list);
        return "students";
    }
}
