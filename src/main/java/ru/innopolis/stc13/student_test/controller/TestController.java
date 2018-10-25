package ru.innopolis.stc13.student_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.stc13.student_test.pojo.Test;
import ru.innopolis.stc13.student_test.service.TestService;

import java.util.List;

@Controller
@RequestMapping("/tests")
public class TestController {

    private TestService testService;

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        List<Test> tests = testService.getAll();
        model.addAttribute("tests", tests);
        return "tests";
    }

    @GetMapping("/add")
    public String add(Model model) {
        return "editTest";
    }

    @GetMapping("/edit/{test}")
    public String add(@PathVariable Test test, Model model) {
        model.addAttribute("test", test);
        model.addAttribute("questions", test.getQuestions());
        return "editTest";
    }

    @GetMapping("/get/{test}")
    public String get(@PathVariable Test test) {
        return "test";
    }

    @GetMapping("/change_status/{test}/{answerId}")
    public String changeStatus(@PathVariable Test test, @PathVariable Integer answerId, Model model) {
        boolean isStatusChanged = testService.changeAnswerStatus(answerId);
        if (!isStatusChanged) {
            model.addAttribute("error", "status_change_error");
        }
        model.addAttribute("questions", test.getQuestions());
        model.addAttribute("test", test);
        return "editTest";
    }
}
