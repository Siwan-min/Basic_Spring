package com.example.springform;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class QueryController {

    //http://localhost:8080/q?keyword=hello
    @GetMapping("/q")
    @ResponseBody
    public String q(String keyword){
        return "keyword = " + keyword;
    }

    @GetMapping("/q1")
    @ResponseBody
    public String q1(@RequestParam(required = true) String keyword){
        return "keyword = " + keyword;
    }

    @GetMapping("/q2")
    @ResponseBody
    public String q2(@RequestParam String keyword, Integer page){
        return "keyword = " + keyword + "/ page:" + page;
    }

    @GetMapping("/q3")
    @ResponseBody
    public String q3(@RequestParam String keyword, @RequestParam int page) {
        return "keyword: " + keyword + "/ page: " + page;
    }

    @GetMapping("/q4")
    @ResponseBody
    public String q4(@RequestParam(required = false) String keyword, @RequestParam(defaultValue = "1") Integer page){
        page = page * 5;
        return "keyword = " + keyword + "/ page:" + page;
    }

    // q5/5
    @GetMapping("/q5/{id}")
    @ResponseBody
    public String q5(@PathVariable int id) { return "id = " + id;}


    @GetMapping("/q6/{id}/{name}")
    @ResponseBody
    public String q6(@PathVariable int id, @PathVariable String name) {
        return "id = " + id + "  name = " + name;
    }

    // q7?id=7&name=hello
    @GetMapping("/q7")
    @ResponseBody
    public String q7(@RequestParam Map<String, String> query) {

        return "data : " + query + "<br/>";
    }

    @GetMapping("/q8")
    @ResponseBody
    public String q8(Member member) {
        return "data :" + member;
    }

    //http://localhost:8080/weather/서울
    @GetMapping("/weather/{city}")
    @ResponseBody
    public String weather(@PathVariable String city) {

        return String.format("<a href=https://search.naver.com/search.naver?where=nexearc&query=서울 target='_blank'>%s</a>", city, city);
    }


}
