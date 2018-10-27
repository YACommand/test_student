package ru.innopolis.stc13.student_test.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {

    @GetMapping("/login")
    public String login(Model model){


        return "login";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String loginPage(@RequestParam(value = "error", required = false) String error,
//                            @RequestParam(value = "logout", required = false) String logout,
//                            Model model) {
//        String errorMessge = null;
//        if(error != null) {
//            errorMessge = "Username or Password is incorrect !!";
//        }
//        if(logout != null) {
//            errorMessge = "You have been successfully logged out !!";
//        }
//        model.addAttribute("errorMessge", errorMessge);
//        return "login";
//    }

}
