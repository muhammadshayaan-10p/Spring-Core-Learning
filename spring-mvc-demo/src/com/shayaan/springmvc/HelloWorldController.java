package com.shayaan.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    // controller method to show the initial form data
    @RequestMapping("/showform")
    public String showForm(){
        return "helloworld-form";
    }

    // controller method to process html form
    @RequestMapping("/processform")
    public String processForm(){

        return "helloworld";

    }

    // new controller to read form data and add data to the model
    @RequestMapping("/processFormv2")
    public String shout(HttpServletRequest request, Model model){

        //read the request param from the HTML form
        String name = request.getParameter("studentName");

        //convert data to all caps
        name = name.toUpperCase();

        //create the message
        String result = "Yooo "  + name;

        //add message to the model
        model.addAttribute("message",result);

        return "helloworld";
    }


    @RequestMapping("/processFormv3")
    public String shout2(
            @RequestParam("studentName") String name,
            Model model
    ){

        String result = "Yoo!! " + name.toUpperCase() + " Hello from @RequestParam";
        model.addAttribute("message ",result);

        return "helloworld";
    }
}
