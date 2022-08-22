package com.example.springform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@Controller
public class SeatController {

    @RequestMapping("/seats")
    public String seats(@RequestParam HashMap query, Model model) {

        boolean[] seats = new boolean[10];

        for(Object key : query.keySet()) // key만 가져옴
        {
           int index = Integer.parseInt(key.toString().replace("ans",""));
           seats[index-1] = true;
        }
        model.addAttribute("seats", seats);

        return "seats";
    }

}
