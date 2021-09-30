package com.shayaan.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    public String showPage(){
        System.out.println("Printing");
        return "main-menu";
    }

    @RequestMapping("/yes")
    public String show(){

        return "hello";
    }
}