package com.example.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


@Controller
public class BasicController {
    int cnt = 0;

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "hello~~~~";
    }

    @GetMapping("/main")
    @ResponseBody
    public String main() {
        return "<h1>hello~~~</h1>";
    }

    @GetMapping("/day")
    @ResponseBody
    public String day() {

        LocalDate now = LocalDate.now();
        //Date nowDate = new Date();
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
        //String strNowDate = simpleDateFormat.format(nowDate);
        String result = String.format("오늘은 <h1 style ='display:inline'>%s</h1> 입니다.", now);

        return result;
    }

    @GetMapping("/count")
    @ResponseBody
    public String count() {
        cnt++;

        //String result = String.format("방문자 수는 %d 입니다.", cnt);
        String number = String.valueOf(cnt);
        char[] digits1 = number.toCharArray();

        String html = "";
        for(int i = 0 ; i < digits1.length; i++) {
            String result = String.format("<img src='img/%c.jpg' width='80'/>",digits1[i]);
            html += result;
        }
        //String result = String.format("<img src='img/%d.jpg' width='80'/>",cnt);

        return html;
    }

    @GetMapping("/banner")
    @ResponseBody
    public String banner() {

        String[] arrHref = {"http://google.com", "http://daum.net", "http://naver.com"};
        String[] arrSrc = {"google.jpg", "daum.jpg", "naver.jpg"};

        String html = "";

        for(int i = 0 ; i < 3; i++) {
            String result = String.format("<a href='%s'><img src='img/%s' width='100'/></a>", arrHref[i], arrSrc[i]);
            html += result;
        }

        return html;
    }
    // /로 들어오면 위 메소드를 수행함
    // ResponseBody 를 설정해야 Response 객체에 담아 수행함

}
