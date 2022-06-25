package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.impls.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminRestController {

    private final UserServiceImpl userService;



    @GetMapping("/api/principal")
    public User getPrincipalInfo(Principal principal) {
        return userService.getUserByUsername(principal.getName());
    }

    @GetMapping("/api/{id}")
    public User findOneUser(@PathVariable long id) {
        User user = userService.getUserById(id);
        return user;
    }

    @PostMapping("/api")
    public ResponseEntity addNewUser(@RequestBody User user) {
        user.setRoles(userService.getRoles(userService.rolesToId(user.getRoles())));
        userService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).body(user);
    }

    @GetMapping("/api")
    public ResponseEntity<List<User>> findAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PutMapping("/api/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") long id) {
        //roleRepository.saveAll(user.getRoles());
        user.setRoles(userService.getRoles(userService.rolesToId(user.getRoles())));
//        updateUserService.setPassword(user, id);
        userService.updateUser(user);
        return user;
    }

    @DeleteMapping("/api/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUserById(id);
    }
}
