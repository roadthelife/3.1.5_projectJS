package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @GetMapping("/info")
    public String goHome(Principal principal, Model model){
        User user = userService.getUserByUsername(principal.getName());
        model.addAttribute("activeUser", user);

        return "admin_info";
    }
}
