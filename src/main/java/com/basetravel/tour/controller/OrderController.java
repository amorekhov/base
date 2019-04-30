package com.basetravel.tour.controller;

import com.basetravel.tour.domain.Order;
import com.basetravel.tour.domain.Travel;
import com.basetravel.tour.domain.User;
import com.basetravel.tour.repos.OrderRepo;
import com.basetravel.tour.repos.TravelRepo;
import com.basetravel.tour.repos.UserRepo;
import com.basetravel.tour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
    public String home(Model model){
        return "main";
    }

    @GetMapping("/order")
    public String hello (Model model, Travel travel){
        Iterable<Order> orders = orderRepo.findAll();

        model.addAttribute("orders", orders);
        model.addAttribute("travel",travel);
        return "order";
    }

    @PostMapping("/order")
    public String saveOrder(Model model, @RequestParam User user, @RequestParam Travel travel) {

        model.addAttribute("travel",travel);

        return "order";
    }

    @GetMapping("/order/{user}")
    public String myOrder(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            @RequestParam (required = false) Order order,
            Model model
    ){
        //Order order = new Order();

        List<Order> orders =  user.getOrders();

            model.addAttribute("orders", orders);
            //model.addAttribute("travel",travel);



        return "myorder";
    }






}
