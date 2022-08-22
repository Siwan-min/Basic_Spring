package com.example.springform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class BasicController2 {

    @InitBinder
    public void iniBinder(WebDataBinder dataBinder){ // validator을 초기화하고 생성해서 Controller 가 사용할 수 있도록 함.
        dataBinder.addValidators(new MemberValidator());
    }

    // http://localhost:8080/valid5?age=105
    @RequestMapping("/valid5")
    public String valid5(@Valid Member member, BindingResult bindingResult, Model model) {
        return "valid3";
    }

    @GetMapping("/addform")
    public String addForm(Model model) {

        model.addAttribute("member", new Member("", 0, "aaa@aaa.net"));

        return "addform";
    }

    @GetMapping("/add")
    public String add(@Valid Member member, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) return "addform";

        return "redirect:/";
    }
}
