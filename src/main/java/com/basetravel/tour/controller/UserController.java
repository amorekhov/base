package com.basetravel.tour.controller;

import com.basetravel.tour.domain.User;
import com.basetravel.tour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;


    @GetMapping()
    public String getUser(Model model, @AuthenticationPrincipal User user){

        model.addAttribute("username", user.getUsername());
        model.addAttribute("firstname", user.getFirstName());
        model.addAttribute("lastname", user.getLastName());
        model.addAttribute("birthday", user.getBirthday());

        model.addAttribute("email", user.getEmail());

        return "user";
    }
    @GetMapping("/useredit")
    public String getUserEdit(Model model, @AuthenticationPrincipal User user){

        model.addAttribute("username", user.getUsername());
        model.addAttribute("firstname", user.getFirstName());
        model.addAttribute("lastname", user.getLastName());
        model.addAttribute("birthday", user.getBirthday());

        model.addAttribute("email", user.getEmail());

        return "useredit";
    }

    @PostMapping("/useredit")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String password,
            @RequestParam String firstName,
            @RequestParam String email,
            @RequestParam String lastName,
            @RequestParam Date birthday

            ){

        userService.updateProfile(user,  password, email, firstName,lastName,birthday);

        return "redirect:/user";
    }



}
