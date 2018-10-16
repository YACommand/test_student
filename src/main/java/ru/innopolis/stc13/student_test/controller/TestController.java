package ru.innopolis.stc13.student_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.innopolis.stc13.student_test.dao.AnswerDao;
import ru.innopolis.stc13.student_test.dao.QuestionDao;
import ru.innopolis.stc13.student_test.dao.TestDao;
import ru.innopolis.stc13.student_test.pojo.Test;

import java.util.List;

@Controller
public class TestController {

    private TestDao testDao;
    private QuestionDao questionDao;
    private AnswerDao answerDao;

    @Autowired
    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }

    @Autowired
    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Autowired
    public void setAnswerDao(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    @GetMapping("/tests")
    public String getAll(Model model) {
        List<Test> tests = testDao.findAll();
        model.addAttribute("tests", tests);
        return "tests";
    }
}
