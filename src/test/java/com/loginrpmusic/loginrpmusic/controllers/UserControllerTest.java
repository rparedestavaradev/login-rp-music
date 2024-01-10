package com.loginrpmusic.loginrpmusic.controllers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.PostMapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldExistMethodLogin() {
        Class<UserController> userControllerClass = UserController.class;
        String methodName = "login";
        Method[] methods = userControllerClass.getDeclaredMethods();
        assertTrue(Arrays.stream(methods).anyMatch(method -> method.getName().equals(methodName)),
                "Method 'login' should exist in UserController class.");
    }

    @Test
    public void methodLoginShouldBePost() {
        Class<UserController> userControllerClass = UserController.class;
        String methodName = "login";
        Method[] methods = userControllerClass.getDeclaredMethods();
        assertTrue(Arrays.stream(methods)
                        .filter(method -> method.getName().equals(methodName))
                        .anyMatch(method -> method.isAnnotationPresent(PostMapping.class)),
                "Method 'login' should be annotated with @PostMapping.");
    }

    /*ToDo: Check who implement test to exceptions
    @Test
    public void loginShouldBeReturnedAnExceptionIfTheRequestDontHaveTypeUserLogin() throws Exception {
        String requestBody = "{ \"usernameuu\": \"\", \"password\": \"\" }"; // User with invalid request
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Usuario no válido"));
    }*/
    @Test
    public void ifTheUserNotWasFoudThenTheMessageShouldBeUserNotFound() {

    }
}