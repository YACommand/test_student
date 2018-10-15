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
        studentService.delete(id);
        return "redirect:/students";
    }

    @GetMapping("/add")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        return "studentEdit";
    }

    @GetMapping("/edit/{student}")
    public String edit(@PathVariable Student student){
        return "studentEdit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Student student,Model model) {
        if (studentService.get(student.getId())!=null){
            boolean isUpdate= studentService.update(student);
            if (isUpdate){
                model.addAttribute("error","updated_error");
                return "studentEdit";
            }
            else {
                boolean isCreated= studentService.add(student);
                if (!isCreated){
                    model.addAttribute("error","created_error");
                    return "studentEdit";
                }
            }
        }
        return "redirect:/students";
    }
}
