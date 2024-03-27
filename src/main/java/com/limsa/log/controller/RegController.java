package com.limsa.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.limsa.log.domain.Login;
import com.limsa.log.service.RegService;

@Controller
public class RegController {

    @Autowired
    private RegService regService; // Assuming you have a RegService bean defined

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Login()); // Assuming Login is your entity class for users
        return "register"; // Assuming "register.html" is the view name
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") Login user) {
        regService.saveUser(user.getUsername(), user.getPassword()); // Assuming your RegService has a saveUser method
        return "redirect:/login"; // Redirect to login page after registration
    }

    @GetMapping("/login")
    public String getMethodName() {
        return "log";
    }

    @GetMapping("/logout")
    public String logout() {
        return "log";
    }
}
