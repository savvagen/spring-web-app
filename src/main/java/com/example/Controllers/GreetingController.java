package com.example.Controllers;


import com.example.Entity.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/")
public class GreetingController {


    private static final String greetingTemplate = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @GetMapping(value = "/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "Savva") String name, Model model){
        model.addAttribute("name", name);
        return "greeting";
    }


    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public @ResponseBody Greeting greeting(@RequestParam(name = "name", defaultValue = "Savva") String name){
        return new Greeting(counter.incrementAndGet(), String.format(greetingTemplate, name));
    }


    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model){
        return "welcome";
    }


    @GetMapping
    public String goHome(){
        return "home";
    }






}
