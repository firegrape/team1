package org.bitc.viewtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class View {

    @RequestMapping("view.do")
    public String view () throws Exception {
            return "view1";
        }
    }