package com.example.springform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SurveyController {


    @RequestMapping("/survey")
    public String survey(Model model) {
        ArrayList<Survey> surveys = new ArrayList<>() {{
            add(new Survey(1, "여행에 대한 만족도는1?", 0));
            add(new Survey(2, "여행에 대한 만족도는2?", 0));
            add(new Survey(3, "여행에 대한 만족도는3?", 0));
            add(new Survey(4, "여행에 대한 만족도는4?", 0));
            add(new Survey(5, "여행에 대한 만족도는5?", 0));
        }};
        model.addAttribute("surveys", model);
        return "survey";
    }

    @RequestMapping("/commit")
    public String survey(@RequestParam HashMap<String, String> query, Model model) {

        // 쿼리 파싱
        // key 값을 알아와 내용을 해석
        String[] answers = new String[query.size()];
        for (Map.Entry<String, String> entry: query.entrySet()) {
            int index = Integer.parseInt(entry.getKey().replace("ans", ""));
            answers[index-1] = entry.getValue();
        }

        model.addAttribute("answers", answers);

        return "commit";

    }
}
