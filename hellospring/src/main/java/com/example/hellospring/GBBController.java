package com.example.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
public class GBBController {



    @RequestMapping(value = "/gbb")
    public String view1(Model model) {

        String my = "";
        String com = "";
        String result = "";

        Random random = new Random();


        int myNum = (int)(Math.random() * 3);
        int comNum = (int)(Math.random() * 3);

        String[] label = {"img/Rock.jpg", "img/Scissors.jpg", "img/Paper.jpg"};
        my = label[myNum];
        com = label[comNum];

        if(myNum < comNum) {
            result = "img/Win.jpg";
        }else if(myNum > comNum) {
            result = "img/Lose.jpg";
        }else {
            result = "img/Draw.jpg";
        }

        model.addAttribute("my", my); // 이 값을 전달 시킴
        model.addAttribute("com", com); // 이 값을 전달 시킴
        model.addAttribute("result", result); // 이 값을 전달 시킴

        return "gbb";
    }
}
