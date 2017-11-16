package com.example.Validator;

import com.example.Entity.User;
import com.example.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Service
public class UserValidation implements Validator{

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object userObject, Errors errors) {
        User user = (User) userObject;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");

        if (user.getUsername().length() < 3 || user.getUsername().length() > 32){
            errors.rejectValue("username", "Size.userForm.username");
        }

        if (userService.findOneByUsername(user.getUsername()) != null){
            errors.reject("username", "Duplicate.userForm.username");
        }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required");

        if (user.getEmail().length() < 6 || user.getEmail().length() > 45){
            errors.rejectValue("email", "Size.userForm.email");
        }

        if (userService.findOneByEmail(user.getEmail()) != null){
            errors.reject("email", "Duplicate.userForm.email");
        }



        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");

        if (user.getPassword().length() < 6 || user.getPassword().length() > 32){
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())){
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }



    }
}
