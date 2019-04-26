package com.basetravel.tour.controller;


import com.basetravel.tour.domain.Travel;
import com.basetravel.tour.repos.TravelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Map;

@Controller
public class TravelController {
    @Autowired
    private TravelRepo travelRepo;


    @GetMapping ("/travel")
    public String travelList (Map<String, Object> model){

        Iterable<Travel> travels = travelRepo.findAll();

        model.put("travel", travels);
        model.put("travels", travels);
        return "travel";
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

        return "redirect:/travel";

    }

    @GetMapping("/traveladd")
    public String travels (Map<String, Object> model){

               return "traveladd";
    }

}
