package com.basetravel.tour.controller;


import com.basetravel.tour.domain.Order;
import com.basetravel.tour.domain.Travel;
import com.basetravel.tour.domain.User;
import com.basetravel.tour.repos.OrderRepo;
import com.basetravel.tour.repos.TravelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Map;

@Controller
public class TravelController {
    @Autowired
    private TravelRepo travelRepo;
    @Autowired
    private OrderRepo orderRepo;

    public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    @GetMapping ("/travelall")
    public String travelList (Map<String, Object> model){

        Iterable<Travel> travels = travelRepo.findAll();

        model.put("travel", travels);
        model.put("travels", travels);
        return "travelall";
    }

    @PostMapping("/traveladd")
    public String add(
                      @RequestParam String name,
                      @RequestParam String description,
                      @RequestParam String location,
                      @RequestParam Date startDate,
                      @RequestParam Date endDate,
                      @RequestParam Long countLimit,
                      Map<String, Object> model

    ){

           Travel travel = new Travel(name,location,description,startDate,endDate,countLimit);


            travelRepo.save(travel);

        return "redirect:/travelall";

    }

    @GetMapping("/traveladd")
    public String travels (Map<String, Object> model){

               return "traveladd";
    }

    @GetMapping("travelall/{travel}")
    public String travel(
            @PathVariable Travel travel,

            Model model){

        model.addAttribute("name", travel.getName());
        model.addAttribute("description",travel.getDescription());
        model.addAttribute("countlimit",travel.getCountLimit());
        model.addAttribute("startdate",travel.getStartDate());
        model.addAttribute("enddate",travel.getEndDate());
        model.addAttribute("location",travel.getLocation());

        Date currentdate = convertJavaDateToSqlDate(new java.util.Date());

        boolean isDate = travel.getStartDate().after(currentdate);
        boolean isLimit = travel.getCountLimit() >0;
        model.addAttribute("isDate", isDate);
        model.addAttribute("isLimit", isLimit);

        return "travel";
    }

    @PostMapping("/travelall/{travel}/orderadd")
    public String orderAdd (
            Model model,
            @AuthenticationPrincipal User currentUser,
            @PathVariable Travel travel


    ){

        Long limit = travel.getCountLimit();
        limit --;
        Order order = new Order();

        order.setUser(currentUser);
        order.setTravel(travel);
        order.setTimeKey(travel.getStartDate());
        order.setConfirmed(true);
        travel.setCountLimit(limit);
        travelRepo.save(travel);
        orderRepo.save(order);
        //order.setConfirmed(true);


        return "redirect:/travelall";
    }

}
