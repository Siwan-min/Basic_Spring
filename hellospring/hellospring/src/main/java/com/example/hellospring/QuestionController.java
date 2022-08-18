package com.example.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Random;

@Controller
public class QuestionController {

    @RequestMapping(value = "/question")
    public String question(Model model) {

        String questions[] = {"1", "2", "3", "4", "5", "6"};
        boolean check[] = new boolean[6];
        Arrays.fill(check, false);
        String image[] = {"1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg"};
        String answer[] = {};

        int cnt = 0;


        while(cnt < 3) {

            int quesNum = (int)(Math.random() * 6);
            if(check[quesNum]) continue;

            check[quesNum] = true;

            String ques = String.format("question%s", cnt);
            String img = String.format("question_image%s", cnt);

            model.addAttribute(ques, questions[quesNum]);
            model.addAttribute(img, "img/"+ image[quesNum]);

            cnt++;
        }

        return "question";
    }

}
