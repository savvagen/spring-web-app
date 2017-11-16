package com.example.Controllers;


import com.example.Entity.Role;
import com.example.Entity.User;
import com.example.Repository.RolesRepository;
import com.example.Repository.UsersRepository;
import com.example.Services.SecurityService;
import com.example.Services.UserService;
import com.example.Validator.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidation userValidator;

    @Autowired
    private RolesRepository rolesRepository;




    @GetMapping
    public @ResponseBody List<User> getUsers(){
        return userService.findAll();
    }


    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public @ResponseBody List<User> getUsersByRole(@RequestParam(value = "role") String role){
        return userService.findAllByRole(role);
    }



    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public @ResponseBody User getUserById(@PathVariable(value = "id") Long id){
        return userService.findOne(id);
    }


    @RequestMapping(value = "/byEmail" , method = RequestMethod.GET)
    public @ResponseBody User getUserByEmail(@RequestParam(value = "email") String email){
        return userService.findOneByEmail(email);
    }


    @RequestMapping(value = "/byUserName/{name}" , method = RequestMethod.GET)
    public @ResponseBody User getUserByUserName(@PathVariable(value = "name") String userName){
        return userService.findOneByUsername(userName);
    }



    @RequestMapping(value = "/{id}/roles" , method = RequestMethod.GET)
    public @ResponseBody List<Role> getUserRole(@PathVariable(value = "id") Long id){
        return userService.findOne(id).getRoles();
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }
    
    
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerNewUser(@ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()){
            return "registration";
        }
        List<Role> roles = new ArrayList<>();
        roles.add(rolesRepository.findOneByName("ROLE_USER"));
        user.setRoles(roles);
        userService.save(user);
        securityService.autoLogin(user.getUsername(), user.getConfirmPassword());
        return "redirect:/welcome";
    }




}
