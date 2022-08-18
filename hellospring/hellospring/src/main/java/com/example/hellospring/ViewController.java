package com.example.hellospring;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class ViewController {

    @RequestMapping(value = "/view1")
    public String view1() {
        return "view1";
    }

    @RequestMapping("/view2")
    public String view2(Model model) {
        model.addAttribute("name", "이순신"); // 이 값을 전달 시킴

        return "view2";
    }

    @RequestMapping("/view3")
    public ModelAndView view3() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "민시완");
        modelAndView.setViewName("view2");
        return modelAndView;
    }

    //object 전달
    @RequestMapping("/view4")
    public String view4(Model model) {

        Person p = new Person("min siwan", 30);

        HashMap map = new HashMap();
        map.put("title", "Spring기초");
        map.put("author", "홍길순");


        model.addAttribute("person", p);
        model.addAttribute("book", map);

        model.addAttribute("url", "http://www.google.com");
        model.addAttribute("image", "img/naver.jpg");
        return "view4";

    }

    @RequestMapping("/viewPractice4")
    public String viewPractice4(Model model) {

        Device device = new Device("iPhone", "Apple", 1000000);
        model.addAttribute("device", device);

        return "viewPractice4";
    }

    @RequestMapping("/view5")
    public String view5(Model model) {

        String main = "main";
        model.addAttribute("title", "포털사이트");
        model.addAttribute("main", "img/0.jpg");

       /* HashMap map = new HashMap();
        map.put("href0", "http://www.google.com");
        map.put("href1", "http://www.naver.com");
        map.put("href2", "http://www.daum.com");
*/
        model.addAttribute("href0", "http://www.google.com");
        model.addAttribute("href1", "http://www.naver.com");
        model.addAttribute("href2", "http://www.daum.com");

        model.addAttribute("src0", "img/google.jpg");
        model.addAttribute("src1", "img/naver.jpg");
        model.addAttribute("src2", "img/daum.jpg");






        return "view5";
    }

}
