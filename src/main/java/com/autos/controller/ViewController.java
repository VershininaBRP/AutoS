package com.autos.controller;

import org.springframework.security.core.Authentication;   // правильный импорт!
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Метод для перенаправления после входа
    @GetMapping("/home")
    public String redirectAfterLogin(Authentication authentication) {
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        return isAdmin ? "redirect:/admin/dashboard" : "redirect:/user/masters";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin_dashboard";
    }

    @GetMapping("/user/masters")
    public String userMasters() {
        return "user_masters";
    }
}