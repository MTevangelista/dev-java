package br.edu.infnet.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LandingController {
    
    @RequestMapping("")
    public String landing() {
        return "landing";
    }
    
    @RequestMapping("/signup")
    public String signUp() {
        return "signup";
    }
    
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    
}
