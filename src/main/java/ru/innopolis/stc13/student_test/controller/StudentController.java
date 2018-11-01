package ru.innopolis.stc13.student_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc13.student_test.pojo.Test;
import ru.innopolis.stc13.student_test.pojo.TestResult;
import ru.innopolis.stc13.student_test.pojo.User;
import ru.innopolis.stc13.student_test.service.TestResultService;
import ru.innopolis.stc13.student_test.service.TestService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    private TestService testService;

    private TestResultService testResultService;

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @Autowired
    public void setTestResultService(TestResultService testResultService) {
        this.testResultService = testResultService;
    }

    @GetMapping("/mytests")
    public String getAll(@AuthenticationPrincipal User user, Model model) {
        List<Test> tests = testService.getByUser(user.getId());
        model.addAttribute("tests", tests);
        return "mytests";
    }

    @GetMapping("/passtest/{test}")
    public String pass(@PathVariable Test test, Model model) {
        model.addAttribute("test", test);
        model.addAttribute("questions", test.getQuestions());
        return "passTest";
    }

    @PostMapping("/done")
    public String process(@AuthenticationPrincipal User user, @RequestParam Map<String, String> allRequestParams, Model model) {
        int score = testResultService.process(allRequestParams, user);
        model.addAttribute("score", score);
        return "score";
    }

    @GetMapping("/myresults")
    public String getAllResults(@AuthenticationPrincipal User user, Model model) {
        List<TestResult> results = testResultService.getByUser(user.getId());
        model.addAttribute("results", results);
        return "myresults";
    }
}
