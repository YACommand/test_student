package ru.innopolis.stc13.student_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.stc13.student_test.pojo.Student;
import ru.innopolis.stc13.student_test.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getStudents(Model model) {
        List<Student> list = studentService.getAll();
        model.addAttribute("students", list);
        return "students";
    }

    @GetMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") int id){
        this.studentService.delete(id);
        return "redirect:/students";
    }
}
