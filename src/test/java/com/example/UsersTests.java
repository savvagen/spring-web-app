package com.example;


import com.example.Controllers.UserController;
import com.example.Entity.Greeting;
import com.example.Entity.User;
import com.example.Services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersTests {




    @Test
    public void getUsers(){
        RestTemplate restTemplate = new RestTemplate();
        Greeting greeting = restTemplate.getForObject("http://localhost:8087/greeting", Greeting.class);
        assertThat(greeting.getMessage()).isEqualTo("Hello, Savva");
    }


}
