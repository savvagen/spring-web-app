package com.example.Validator;


import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LoginForm {

    @NotNull
    @Size(min=3, max=32)
    private String username;

    @NotNull
    @Min(5)
    private String password;




}
