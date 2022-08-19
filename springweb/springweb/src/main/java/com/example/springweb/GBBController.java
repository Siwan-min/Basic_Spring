package com.example.springweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GBBController {

    @GetMapping("/gbb")
    public String gbb(@RequestParam(defaultValue = "-1") int my, Model model) {

        if(my == -1) {
            model.addAttribute("my", null);
            return "gbb";
        }

        int com = (int)(Math.random() * 3);

        int compare = (my - com + 3) % 3;

        String[] label = {"img/Scissors.jpg", "img/Rock.jpg", "img/Paper.jpg" };
        String[] result = {"img/Draw.jpg", "img/Win.jpg", "img/Lose.jpg"};

        model.addAttribute("my", label[my]);
        model.addAttribute("com", label[com]);
        model.addAttribute("result", result[compare]);

        return "gbb";
    }

}
