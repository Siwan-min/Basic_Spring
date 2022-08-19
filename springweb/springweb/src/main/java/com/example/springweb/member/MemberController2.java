package com.example.springweb.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController2 {

    @Autowired
    private MemberService memberService;


    @GetMapping("/genderlist")
    public String genderlist(@RequestParam boolean gender, Model model){

        model.addAttribute("members", memberService.findByGender(gender));


        return "memberlist";
    }

}
