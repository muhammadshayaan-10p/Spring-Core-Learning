package com.shayaan.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
<<<<<<< HEAD
@RequestMapping("/")
public class HomeController {

=======
public class HomeController {

    @RequestMapping("/")
>>>>>>> bff30b57fce77a5c0962c00affb44f68ae9f835f
    public String showPage(){
        System.out.println("Printing");
        return "main-menu";
    }

    @RequestMapping("/yes")
    public String show(){

        return "hello";
    }
}
