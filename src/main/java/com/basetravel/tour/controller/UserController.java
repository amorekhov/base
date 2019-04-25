package com.basetravel.tour.controller;

import com.basetravel.tour.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserRepo userRepo;


    @GetMapping
    public String user (Map<String,Object> model){
        return "user";
    }


}
