package com.bitc.javateam1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MyPageController {


    @RequestMapping("/mypage")
    public String MypageMain()throws Exception{


        return "mypage/mypage";
    }
}
