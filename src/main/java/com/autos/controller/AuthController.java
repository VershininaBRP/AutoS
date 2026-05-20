package com.autos.controller;

import com.autos.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    private final UserService userService;
    public AuthController(UserService userService) { this.userService = userService; }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password,
                           @RequestParam String phone, @RequestParam String confirmPassword) {
        if (!password.equals(confirmPassword)) return "redirect:/?error=passwords";
        try {
            userService.register(username, password, phone);
        } catch (Exception e) {
            return "redirect:/?error=exists";
        }
        return "redirect:/?success";
    }
}