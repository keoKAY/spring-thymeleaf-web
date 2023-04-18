package com.istad.springthymleafpartone.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

// RestController vs Controller

@Controller
public class HomeController {


    // ModelAndView
    @GetMapping("/index")
    public ModelAndView getHomePage(){
        ModelAndView obj = new ModelAndView();
        obj.setViewName("index");
        return obj;
    }

   @GetMapping("/registration")
   public String registerForm() {
        return "register-form";
    }


}
