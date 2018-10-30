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
import ru.innopolis.stc13.student_test.service.UserService;

import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/tests" )
public class TestController {

    private TestService testService;

    private TestResultService testResultService;
    private UserService userService;

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @Autowired
    public void setTestResultService(TestResultService testResultService) {
        this.testResultService = testResultService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all" )
    public String getAll(Model model) {
        List<Test> tests = testService.getAll();
        model.addAttribute("tests", tests);
        return "tests";
    }

    @GetMapping("/add" )
    public String addTestPage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("test",
                new Test("",
                        user, new HashSet<>(),
                        new HashSet<>()));
        return "addTest";
    }

    @PostMapping("/add" )
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String description,
                      Model model) {
        User teacher = userService.get(user.getId());
        Test test = testService.add(new Test(description,
                teacher,
                new HashSet<>(),
                new HashSet<>()));
        if (test != null) {
            model.addAttribute("add_test_status", "success" );
            model.addAttribute("test", test);
        } else {
            model.addAttribute("add_test_status", "error" );
        }
        return "editTest";
    }

    @GetMapping("/edit/{test}" )
    public String add(@PathVariable Test test, Model model) {
        model.addAttribute("test", test);
        model.addAttribute("questions", test.getQuestions());
        return "editTest";
    }

    @PostMapping("/edit" )
    public String editTest(@RequestParam String id, @RequestParam String description) {
        testService.updateDescription(id, description);
        return "redirect:/tests/edit/" + id;
    }

    @GetMapping("/get/{test}" )
    public String get(@PathVariable Test test) {
        return "test";
    }

    @GetMapping("/delete/{testId}" )
    public String delete(@PathVariable Integer testId) {
        testService.delete(testId);
        return "redirect:/tests/all";
    }


    @GetMapping("/results")
    public String getAllResults(Model model) {
        List<TestResult> results = testResultService.getAll();
        model.addAttribute("results", results);
        return "results";
    }

}
