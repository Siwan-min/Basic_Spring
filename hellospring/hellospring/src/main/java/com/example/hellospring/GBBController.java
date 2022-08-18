package com.example.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
public class GBBController {



    @RequestMapping(value = "/gbb")
    public String view1(Model model) {

       /* String my = "";
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
*/
        int myNum = (int)(Math.random()*3);
        int comNum = (int)(Math.random()*3);

        int[][] matrix = {
                {0, 2, 1},
                {1, 0, 2},
                {2, 1, 0}
        };

        int compare = matrix[myNum][comNum];

        String[] label = {"img/Scissors.jpg", "img/Rock.jpg", "img/Paper.jpg" };
        String[] result = {"img/Draw.jpg", "img/Win.jpg", "img/Lose.jpg"};

        model.addAttribute("my", label[myNum]); // 이 값을 전달 시킴
        model.addAttribute("com", label[comNum]); // 이 값을 전달 시킴
        model.addAttribute("result", result[compare]); // 이 값을 전달 시킴

        return "gbb";
    }

    @RequestMapping(value = "/gbb2")
    public String gbb2(Model model) {

        int myNum = (int)(Math.random()*3);
        int comNum = (int)(Math.random()*3);

        int compare = (myNum - comNum + 3)%3;

//        int compare = matrix[myNum][comNum];

        String[] label = {"img/Scissors.jpg", "img/Rock.jpg", "img/Paper.jpg" };
        String[] result = {"img/Draw.jpg", "img/Win.jpg", "img/Lose.jpg"};

        model.addAttribute("my", label[myNum]); // 이 값을 전달 시킴
        model.addAttribute("com", label[comNum]); // 이 값을 전달 시킴
        model.addAttribute("result", result[compare]); // 이 값을 전달 시킴

        return "gbb";
    }
}
