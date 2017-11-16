package com.example.Services;

public interface SecurityService {

    String findLoggedInUserName();

    void autoLogin(String username, String password);

}
