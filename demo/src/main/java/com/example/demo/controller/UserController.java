package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import static com.example.demo.controller.DemoPaths.BASE_URL;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/info")
    public String showAllUsers(Principal principal, Model model){

        User user = (User) userService.loadUserByUsername(principal.getName());
        model.addAttribute("user", user);

        return "admin_info";
    }
}
