package com.soshiant.controller;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class WelcomeController {

    //==================================================================================================================
    @RequestMapping(value = {"","/","/index"}, method = RequestMethod.GET)
    public ModelAndView index()  {

        ModelAndView model = new ModelAndView("index");
        return model;
    }
    //=============================== http://localhost:8080/springmvc/welcome?name=name ================================
    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public ModelAndView welcome(ModelMap modelMap)  {

        ModelAndView model = new ModelAndView("welcome");
        modelMap.addAttribute("message","Welcome, This is a Spring Boot Example Application");
        model.setStatus(HttpStatus.OK);
        return model;
    }
    //==================================================================================================================
}
