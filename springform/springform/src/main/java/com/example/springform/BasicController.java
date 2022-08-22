package com.example.springform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BasicController {

    @GetMapping("/")
    @ResponseBody
    public String main() {
        return "main service";
    }

    @RequestMapping("/valid0")
    @ResponseBody
    public String valid0(Member member) {
        return "-----> " + member;
    }

    @RequestMapping("/valid")
    @ResponseBody
    public String valid(@Valid Member member) {
        return "-----> " + member;
    }


    @RequestMapping("/valid1")
    @ResponseBody
    public String valid1(@Valid Member member, BindingResult bindingResult) {
        return "-----> " + member;
    }

    @RequestMapping("/valid2")
    @ResponseBody
    public String valid2(@Valid Member member, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {

            String html = "";
            List<FieldError> errors = bindingResult.getFieldErrors();

            for(FieldError error : errors) {
                html += error.getField() + " - " + error.getDefaultMessage() + "<br>";
            }

            return html;
        }
        return "-----> " + member;
    }

    @RequestMapping("/valid3")
    public String valid3(@Valid Member member, BindingResult bindingResult, Model model) {


        return "valid3";
    }

    @RequestMapping("/valid4")
    public String valid4(@Valid Member member, BindingResult bindingResult, Model model) {

        if(member.getAge() > 100 ){
            bindingResult.addError(
                    new FieldError("member", "age", "100보다 작아야함")

            );
        }

        return "valid3";
    }
}
