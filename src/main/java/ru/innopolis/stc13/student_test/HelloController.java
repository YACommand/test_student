package ru.innopolis.stc13.student_test.student_test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String hello(Model model){
        model.addAttribute("hello", "hello");
        return "greeting";
    }
}
