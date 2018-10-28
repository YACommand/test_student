package ru.innopolis.stc13.student_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc13.student_test.pojo.Answer;
import ru.innopolis.stc13.student_test.pojo.Question;
import ru.innopolis.stc13.student_test.pojo.Test;
import ru.innopolis.stc13.student_test.service.AnswerService;
import ru.innopolis.stc13.student_test.service.TestService;

import java.util.HashSet;
import java.util.Map;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private TestService testService;

    @Autowired
    private AnswerService answerService;

    @GetMapping("/add/{test}")
    public String addTest(@PathVariable Test test, Model model) {
        Question question = new Question(null, "", new HashSet<>(), test);
        model.addAttribute("question", question);
        return "editQuestion";
    }

    @GetMapping("/edit/{question}")
    public String addQuestion(@PathVariable Question question, Model model) {
        model.addAttribute("question", question);
        return "editQuestion";
    }

    @PostMapping("/save")
    public String save(@RequestParam Map<String, String> params,
                       @RequestParam(required = false) String[] answerId) {
        if (answerId == null) {
            answerId = new String[0];
        }
        if (params.get("questionId") == "") {
            Question addedQuestion = testService.addQuestion(
                    new Question(null,
                            params.get("text"),
                            new HashSet<>(),
                            testService.get(Integer.parseInt(params.get("testId")))));
            params.put("questionId", addedQuestion.getId().toString());
        }
        testService.updateQuestion(params, answerId);
        return "redirect:/question/edit/" + params.get("questionId");
    }

    @GetMapping("/delete_answer/{answer}")
    public String deleteAnswer(@PathVariable Answer answer) {
        answerService.delete(answer.getId());
        return "redirect:/question/edit/" + answer.getQuestion().getId();
    }

    @GetMapping("/delete/{question}")
    public String deleteQuestion(@PathVariable Question question) {
        testService.deleteQuestion(question.getId());
        return "redirect:/tests/edit/" + question.getTest().getId();
    }
}