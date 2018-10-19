package ru.innopolis.stc13.student_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc13.student_test.pojo.Answer;
import ru.innopolis.stc13.student_test.pojo.Question;
import ru.innopolis.stc13.student_test.service.TestService;

import java.util.ArrayList;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private TestService testService;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("question", new Question());
        return "editQuestion";
    }

    @GetMapping("/edit/{question}")
    public String add(@PathVariable Question question, Model model) {
        model.addAttribute("question", question);
        model.addAttribute("answers", new ArrayList<Answer>());
        return "editQuestion";
    }

    @PostMapping("/save")
    public String save(@RequestParam Integer questionId,
                       @RequestParam String text,
                       Integer[] id,
                       String[] content,
                       Boolean[] correct) {
        testService.updateQuestion(questionId, text, id, content, correct);
        return "";
    }
}