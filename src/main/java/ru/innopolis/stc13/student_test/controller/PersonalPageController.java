package ru.innopolis.stc13.student_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc13.student_test.pojo.Group;
import ru.innopolis.stc13.student_test.pojo.Test;
import ru.innopolis.stc13.student_test.pojo.User;
import ru.innopolis.stc13.student_test.service.GroupService;
import ru.innopolis.stc13.student_test.service.TestService;
import ru.innopolis.stc13.student_test.service.UserService;

import java.util.List;

@Controller
public class PersonalPageController {

    private UserService userService;
    private TestService testService;
    private GroupService groupService;

    @Autowired
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/teacher")
    public String viewGroups(@AuthenticationPrincipal User userPrincipal, Model model) {

        Integer id = userPrincipal.getId();
        User user = userService.get(id);
        List<Test> test = testService.getTestByUserId(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("tests", test);
        model.addAttribute("groups", user.getGroups());
        return "teacherPage";
    }

    @GetMapping("/teacher/groups/{group}")
    public String getStudents(@PathVariable Group group,
                              Model model) {
        List<User> userList = userService.getByGroup(group);
        model.addAttribute("users", userList);
        return "studentsByGroup";
    }

    @PostMapping("/teacher/assignmentGroupsForTests")
    public String assignmentGroupsForTests(@RequestParam  Integer testId,
                                           Model model, @RequestParam(required = false) String[] groups) {
        if (groups == null) {
            groups = new String[0];
        }
        testService.assignmentGroupForTest(testId, groups);
        List<Group> groupList = groupService.getAll();
        model.addAttribute("testId", testId);
        model.addAttribute("test", testService.get(testId));
        model.addAttribute("groups", groupList);
        return "redirect:/teacher";
    }

    @GetMapping("/teacher/assignmentGroupsForTests/{testId}")
    public String assignmentGroupsForTests(@PathVariable  Integer testId,
                                           Model model) {
        model.addAttribute("testId", testId);
        model.addAttribute("groups", groupService.getAll());
        return "assignmentGroupsForTests";
    }

    @PostMapping("/teacher/assignmentTestForGroups")
    public String assignmentTestForGroups(@RequestParam  Integer groupId,
                                           Model model, @RequestParam(required = false) String[] tests) {
        if (tests == null) {
            tests = new String[0];
        }
        testService.assignmentTestForGroup(groupId, tests);
        List<Test> testList = testService.getAll();
        model.addAttribute("groupId", groupId);
        model.addAttribute("group", groupService.get(groupId));
        model.addAttribute("tests", testList);
        return "redirect:/teacher";
    }

    @GetMapping("/teacher/assignmentTestForGroups/{groupId}")
    public String assignmentTestForGroups(@AuthenticationPrincipal User userPrincipal, @PathVariable  Integer groupId,
                                           Model model) {
        Integer id = userPrincipal.getId();
        User user = userService.get(id);
        List<Test> testList = testService.getTestByUserId(user.getId());
        model.addAttribute("groupId", groupId);
        model.addAttribute("group", groupService.get(groupId));
        model.addAttribute("tests", testList);
        return "assignmentTestForGroups";
    }
}
