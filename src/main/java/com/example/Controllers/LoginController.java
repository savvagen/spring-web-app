package com.example.Controllers;

import com.example.Services.UserService;
import com.example.Validator.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class LoginController {


    @Autowired
    private UserService userService;



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(LoginForm loginForm){
        return "login";

    }


    @PostMapping("/login")
    public String checkPersonInfo(@Valid LoginForm loginForm, BindingResult bindingResult, Errors errors) {
        if (userService.findOneByUsername(loginForm.getUsername()) == null) {
            errors.reject("loginError", "Invalid username and password.");
            return "login";
        }
        else if (bindingResult.hasErrors()) {
            return "login";
        }
        return "redirect:/welcome";
    }


}