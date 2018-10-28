package ru.innopolis.stc13.student_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/edit")
    public String editTest(@RequestParam String id, @RequestParam String description) {
        testService.updateDescription(id, description);
        return "redirect:/tests/edit/" + id;
    }

    @GetMapping("/get/{test}")
    public String get(@PathVariable Test test) {
        return "test";
    }

    @GetMapping("/delete/{testId}")
    public String delete(@PathVariable Integer testId) {
        testService.delete(testId);
        return "redirect:/tests/all";
    }
}
