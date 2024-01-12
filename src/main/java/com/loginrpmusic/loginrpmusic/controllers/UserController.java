package com.loginrpmusic.loginrpmusic.controllers;

import com.loginrpmusic.loginrpmusic.exception.InvalidRequestException;
import com.loginrpmusic.loginrpmusic.models.entity.User;
import com.loginrpmusic.loginrpmusic.models.entity.UserLogin;
import com.loginrpmusic.loginrpmusic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{

    @Autowired
    private UserService service;

    @GetMapping("/pin")
    public String pin(){
        return "Service is listening";
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody UserLogin userLogin) {
        try {
            validateUserLogin(userLogin);
            //service.login(user);
            return ResponseEntity.ok("Success register");
        } catch (InvalidRequestException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("register")
    public  ResponseEntity<String> register(@RequestBody User user) {
        try {
            validateUser(user);
            service.register(user);
            return ResponseEntity.ok("Success register");
        } catch (InvalidRequestException e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private void validateUserLogin(UserLogin userLogin) {
        if (userLogin == null || !userLogin.getClass().equals(UserLogin.class))
            throw new InvalidRequestException("User don't have Data");
        if (userLogin.getUser() == null || userLogin.getPassword() == null)
            throw new InvalidRequestException("Sending data haven't a valid format");
    }

    private void validateUser(User user) {
        if(user == null || !user.getClass().equals(User.class))
            throw new InvalidRequestException("User don't have Data");
        if(user.getEmail() == null || user.getFirstName() == null || user.getLastName() == null || user.getPhoneNumber() == null || user.getPassword() == null)
            throw new InvalidRequestException("Sending data haven't a valid format");
    }
}
