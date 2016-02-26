package com.lynas.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LynAs on 26-Feb-16
 */
public class RootController {
    @RequestMapping("/")
    public String ins() {

        return "greeting";
    }


    @RequestMapping("/login")
    public String login() {
        System.out.println();
        return "login";
    }

    @RequestMapping("/signup")
    public String signup() {
        System.out.println();
        return "signup";
    }
}
