package ru.innopolis.stc13.student_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc13.student_test.pojo.Test;
import ru.innopolis.stc13.student_test.pojo.TestResult;
import ru.innopolis.stc13.student_test.service.TestResultService;
import ru.innopolis.stc13.student_test.service.TestService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tests")
public class TestController {

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

    @GetMapping("/pass/{test}")
    public String pass(@PathVariable Test test, Model model) {
        model.addAttribute("test", test);
        model.addAttribute("questions", test.getQuestions());
        return "passTest";
    }

    @PostMapping("/done")
    public String process(@RequestParam Map<String,String> allRequestParams, Model model) {
        int score = testResultService.process(allRequestParams);
        model.addAttribute("score", score);
        return "score";
    }

    @GetMapping("/results")
    public String getAllResults(Model model) {
        List<TestResult> results = testResultService.getAll();
        model.addAttribute("results", results);
        return "results";
    }

}
