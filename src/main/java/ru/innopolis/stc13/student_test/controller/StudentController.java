package ru.innopolis.stc13.student_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/add/{student}")
    public String addStudent(@PathVariable Student student, Model model){
        this.studentService.add(student);
        return "redirect:/students";
    }

    @PostMapping
    public String studentSave(@ModelAttribute Student updatedStudent, Model model) {
        Student student = studentService.get(updatedStudent.getId());
        student.setName(updatedStudent.getName());
        student.setGroup(updatedStudent.getGroup());
        studentService.
        userRepository.save(user);
        return "redirect:/users";
    }
}
