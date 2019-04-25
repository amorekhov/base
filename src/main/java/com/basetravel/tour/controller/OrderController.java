package com.basetravel.tour.controller;

import com.basetravel.tour.domain.Order;
import com.basetravel.tour.domain.Travel;
import com.basetravel.tour.domain.User;
import com.basetravel.tour.repos.OrderRepo;
import com.basetravel.tour.repos.TravelRepo;
import com.basetravel.tour.repos.UserRepo;
import com.basetravel.tour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Map;

@Controller
public class OrderController {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private TravelRepo travelRepo;


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String hello (Map<String,Object> model){
        Iterable<Order> orders = orderRepo.findAll();

        model.put("orders", orders);
        return "main";
    }



    @PostMapping("/main")
    public String saveOrder(Model model, @RequestParam User user, @RequestParam Travel travel) {

        model.addAttribute("travel",travel);

        return "main";
    }




}
