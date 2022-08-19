package com.example.springweb.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    // @Autowired를 통해 Spring Container 에서 MemberService 가 있는지 확인 후 객체를 생성 해준다.
    // Autowired -> MemberService
    @Autowired
    private MemberService memberService;

    @GetMapping("/memberlist")
    public String memberList(Model model){

        model.addAttribute("members", memberService.findAll());
        return "memberlist";
    }

    @GetMapping("/memberread") // /memberRead?UserId=hong
    public String memberRead(@RequestParam String userId, Model model) {

        model.addAttribute("member", memberService.findByUserId(userId));

        return "memberread";
    }

    @GetMapping("/memberdelete")
    public String memberDelete(@RequestParam String userId, Model model) {

        memberService.delete(userId);

        return "redirect:/memberlist";
    }

    @GetMapping("/membergender")
    public String memberByGender(@RequestParam boolean gender, Model model) {

        model.addAttribute("members", memberService.findByGender(gender));

        return "membergender";
    }


}
