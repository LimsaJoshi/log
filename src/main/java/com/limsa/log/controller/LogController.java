package com.limsa.log.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.limsa.log.domain.Login;
import com.limsa.log.service.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogController {

    @Autowired
    private LogService service;

    @GetMapping("/")
    public String api() {

        return "log";
    }

    @PostMapping("/log")
    public String login(@ModelAttribute("user") Login user) {

        Login oauthUser = service.log(user.getUsername(), user.getPassword());

        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/index";
        } else {
            return "redirect:/";
        }
    }

    // @GetMapping("/register")
    // public String add(Model model) {
    // model.addAttribute("login", new Login());
    // return "register";
    // }

    /*
     * @RequestMapping(value = "/register", method = RequestMethod.POST)
     * public String regLog(@ModelAttribute("login") Login login) {
     * service.reg(login);
     * return "redirect:/login";
     * }
     */

}
