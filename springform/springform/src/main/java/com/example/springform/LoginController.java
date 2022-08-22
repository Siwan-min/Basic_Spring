package com.example.springform;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {


    @GetMapping("/main")
    @ResponseBody
    public String main() {
        return "main service";
    }

    @GetMapping("/login")
    @ResponseBody
    public String loginGet(@RequestParam String userId, @RequestParam String userPw) {

        String html = "";

        //인증작업
        if(userId.equals(userPw)) {
            // 인증되었습니다.

            html = "<script> alert('success'); location.href = '/main' </script>";

        }
        else {
            // no~~~~로그인 페이지 링크
            html = "no~~~<a href=/loginform.html> </a>";
        }

        return html;
    }

    @PostMapping("/login")
    @ResponseBody
    public String loginPost(@RequestParam String userId, @RequestParam String userPw) {
        return "data" + userId + "/" + userPw;
    }
}
