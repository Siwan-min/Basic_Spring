package com.example.thymeleafview;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class BasicController {


    //book 객체를 담는 ArrayList
    public ArrayList<Book> books = new ArrayList<>();

    public BasicController() {
        books.add(new Book(1, "이것이 자바다", "이순신", "IT", 10000, "book1.jpg", "http://www.yes24.com/Product/Goods/15651484"));
        books.add(new Book(2, "HTML+CSS", "홍길동", "IT", 10000, "book2.jpg", "http://www.yes24.com/Product/Goods/96674934"));
        books.add(new Book(3, "클린코드 아미텍쳐", "임꺽정", "Art", 10000, "book3.jpg", "http://www.yes24.com/Product/Goods/77283734"));
        books.add(new Book(4, "스프링부트 + AWS", "민시완", "Art", 10000, "book4.jpg", "http://www.yes24.com/Product/Goods/83849117"));
    }

    @RequestMapping("/")
    public String thymeleafbasic(Model model) {

        model.addAttribute("name", "이순신");
        model.addAttribute("html", "<p style=\"color:red;\">this is </p>");
        model.addAttribute("image", "like.png");
        model.addAttribute("id", 10);

        model.addAttribute("book", books.get(0));
        model.addAttribute("age", 3);

        String[] datas = {"사과", "배", "귤", "바나나", "포도"};
        model.addAttribute("datas", datas);

        model.addAttribute("books", books);



        return "main";
    }

    @RequestMapping("/fragment")
    public String fragment(Model model) {



        return "fragment";

    }
}
