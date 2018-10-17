package ru.innopolis.stc13.student_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc13.student_test.pojo.Group;
import ru.innopolis.stc13.student_test.service.GroupService;

import java.util.List;

@Controller
@RequestMapping
public class GroupController {

    private GroupService groupService;

    @Autowired
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/groups")
    public String getGroups(Model model) {
        List<Group> list = groupService.getAll();
        model.addAttribute("groups", list);
        return "groups";
    }

    @GetMapping("/groups/add")
    public String addGroups(Model model) {
        model.addAttribute("group", new Group());
        return "editGroup";
    }

    @GetMapping("/groups/edit/{groups}")
    public String editGroup(@PathVariable Group groups, Model model) {
        model.addAttribute("group", groups);
        return "editGroup";
    }

    @GetMapping("/groups/delete/{id}")
    public String deleteGroup(@PathVariable Integer id) {
        groupService.deleteById(id);
        return "redirect:/groups";
    }

    @PostMapping("/groups/save")
    public String saveGroup(@ModelAttribute("group") Group group, Model model) {

        boolean isGroupExist = groupService.isGroupExist(group);

        if (!groupService.validate(group)) {
            model.addAttribute("error", "validation_error");
            return "editGroup";
        }

        boolean isNumberExist = groupService.isNumberExist(group);
        if (isGroupExist) {
            boolean isNumberExist2 = groupService.isNumberExist(group);
            if (groupService.checkAddNumber(group)) {
                if (groupService.update(group)) {
                    return "redirect:/groups";
                } else if (isNumberExist2) {
                    model.addAttribute("error", "updated_error");
                    return "editGroup";
                }
            }
        } else {
            if (isNumberExist) {
                model.addAttribute("error", "number_error");
                return "editGroup";

            } else {
                groupService.add(group);
                return "redirect:/groups";
            }
        }
        model.addAttribute("error", "updated_error");
        return "editGroup";
    }
}
