package com.example.springbasic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class BasicController {

    @GetMapping("/banner")
    public String banner(Model model) {

        ArrayList<Link> banners = new ArrayList<>();

        // 이미지, 링크
        banners.add(new Link("http://www.google.com", "google.jpg"));
        banners.add(new Link("http://www.naver.com", "naver.jpg"));
        banners.add(new Link("http://www.daum.com", "daum.jpg"));


        model.addAttribute("banners", banners);


        return "banners";
    }

    @GetMapping("/memberlist")
    public String memberlist(Model model) {

        ArrayList<Member> members = new ArrayList<>();

        // 이미지, 링크
        members.add(new Member("민시완", 30, true));
        members.add(new Member("김남욱", 30, true));
        members.add(new Member("한서희", 24, false));

        // Anonymous 클래스
        ArrayList<Member> members2 = new ArrayList<>() {{
                add(new Member("민시완", 30, true));
                add(new Member("김남욱", 30, true));
                add(new Member("한서희", 24, false));
         }};
        model.addAttribute("members", members2);


        return "memberlist";
    }
}
