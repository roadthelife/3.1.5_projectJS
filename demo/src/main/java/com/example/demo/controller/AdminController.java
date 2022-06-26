package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.impls.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.example.demo.controller.DemoParams.ID;
import static com.example.demo.controller.DemoPaths.*;

@RestController
@RequiredArgsConstructor
public class AdminController {

    private final UserServiceImpl userService;


    @GetMapping(GET_USER_URL)
    public User getPrincipalInfo(Principal principal) {
        return userService.getUserByUsername(principal.getName());
    }

    @GetMapping(API_URL)
    public User findOneUser(@PathVariable long id) {
        User user = userService.getUserById(id);
        return user;
    }

    @PostMapping(BASE_API)
    public ResponseEntity addNewUser(@RequestBody User user) {
        user.setRoles(userService.getRoles(rolesToId(user.getRoles())));
        userService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).body(user);
    }

    @GetMapping(BASE_API)
    public ResponseEntity<List<User>> findAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PutMapping(API_URL)
    public User updateUser(@RequestBody User user, @PathVariable(ID) long id) {
        user.setRoles(userService.getRoles(rolesToId(user.getRoles())));
        userService.updateUser(user);
        return user;
    }

    @DeleteMapping(API_URL)
    public void deleteUser(@PathVariable long id) {
        userService.deleteUserById(id);
    }

    public ArrayList<Long> rolesToId(Set<Role> roles) {
        ArrayList<Long> rolesId = new ArrayList<>();
        for (Role role : roles) {
            rolesId.add(Long.valueOf(role.getName()));
        }
        return rolesId;
    }

}
