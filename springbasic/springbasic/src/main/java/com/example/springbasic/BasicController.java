package com.example.springbasic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class BasicController {

    ArrayList<Menu> menus = new ArrayList<>() {{

        add(new Menu("[게시판]", "/page1"));
        add(new Menu("[자료실]", "/page2"));
        add(new Menu("[Q&A]", "/page3"));

    }};

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

    @GetMapping("/page")
    public String page(Model model) {

        model.addAttribute("menus", menus);
       // model.addAttribute("current", menus.get(2).getName());

        return "page";
    }

    @GetMapping("/page1")
    public String page1(Model model) {

        model.addAttribute("menus", menus);
        model.addAttribute("current", menus.get(0).getName());

        return "page1";
    }

    @GetMapping("/page2")
    public String page2(Model model) {

        model.addAttribute("menus", menus);
        model.addAttribute("current", menus.get(1).getName());

        return "page2";
    }

    @GetMapping("/page3")
    public String page3(Model model) {

        model.addAttribute("menus", menus);

        model.addAttribute("current", menus.get(2).getName());

        return "page3";
    }

    @RequestMapping("/mission")
    public String thymeleafapp(Model model){

        model.addAttribute("genders", new boolean[]{true, true, false, true});

        int[] seats = {1, 5, 10};

        boolean[] list = new boolean[10];

        for(int seat : seats)  {
            list[seat-1] = true;
        }

        model.addAttribute("seats", list);

        return "mission";
    }
}
