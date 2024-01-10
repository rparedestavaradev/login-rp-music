package com.loginrpmusic.loginrpmusic.controllers;

import com.loginrpmusic.loginrpmusic.exception.InvalidRequestException;
import com.loginrpmusic.loginrpmusic.models.entity.User;
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

    @PostMapping()
    public ResponseEntity<String> login(@RequestBody User user) {
        try {
            validateUser(user);
            service.login(user);
            return ResponseEntity.ok("Success register");
        } catch (InvalidRequestException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping()
    public  String register( User user) {
        service.register(user);
        return  "";
    }

    private void validateUser(User user) {
        if (user == null || !user.getClass().equals(User.class)) {
            throw new InvalidRequestException("El dato enviado no es de tipo User.");
        }
    }
}
