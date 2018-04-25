package com.soshiant.controller.login;


import com.soshiant.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;



@CrossOrigin(origins = "/**")
@Controller
@RequestMapping("/springmvc")
public class LoginController {


    @Autowired
    private UserService userService;

    //===================================== Url : http://localhost:8080/springmvc/showLogin=============================
    @RequestMapping(value = {"/showLogin","/logout"},method = RequestMethod.GET)
    public ModelAndView showLoginForm()  {

        ModelAndView model = new ModelAndView("/login/login");
        return model;
    }
    //=============================== Url : http://localhost:8080/springmvc/login ======================================
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value= "username",required = true) String username,
                              @RequestParam(value= "password",required = true) String password) throws Exception {


        boolean loginResult = false;
        try {
            loginResult = userService.login(username, password);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        ModelAndView tempModel = new ModelAndView();
        if (! loginResult){
            tempModel.addObject("errorMessage", "Error!, username or password is invalid! ");
            tempModel.setViewName("/login/login");
            tempModel.setStatus(HttpStatus.NOT_ACCEPTABLE);
        }
        else {
            tempModel.setViewName("/dashboard/dashboard");
            tempModel.setStatus(HttpStatus.OK);
        }
        return tempModel;
    }
    //================================== Url : http://localhost:8080/springmvc/logout===================================
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public RedirectView logout(RedirectAttributes attributes) {
        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        attributes.addAttribute("attribute", "redirectWithRedirectView");
        return new RedirectView("/");
    }
    //===================================== Url : http://localhost:8080/springmvc/dashboard=============================
    @RequestMapping(value = {"/dashboard"},method = RequestMethod.GET)
    public ModelAndView showDashboard()  {

        ModelAndView model = new ModelAndView("/dashboard/dashboard");
        return model;
    }

}
