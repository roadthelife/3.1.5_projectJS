//package com.example.demo.configs;
//
//import com.example.demo.model.Role;
//import com.example.demo.model.User;
//import com.example.demo.repository.RoleRepository;
//import com.example.demo.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.*;
//
//@Component
//public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
//    private final static long ROLE_ADMIN = 1;
//    private final static long ROLE_USER = 2;
//
//    boolean alreadySetup = false;
//
//    private final UserRepository userRepository;
//
//    private final RoleRepository roleRepository;
//
//    private final PasswordEncoder passwordEncoder;
//    @Autowired
//    public SetupDataLoader(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    @Transactional
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//
//        Iterable<User> users = userRepository.findAll();
//        alreadySetup = users.iterator().hasNext();
//        Role adminRole = new Role(ROLE_ADMIN, "ROLE_ADMIN");
//        Role userRole = new Role (ROLE_USER, "ROLE_USER");
//        Set<Role> adminRoles = new HashSet<>();
//        adminRoles.add(adminRole);
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(userRole);
//        roleRepository.save(adminRole);
//        roleRepository.save(userRole);
//
//        User admin = new User();
//        admin.setUsername("admin");
//        admin.setFirstName("Admin");
//        admin.setLastName("Admin");
//        admin.setPassword(passwordEncoder.encode("admin"));
//        admin.setRoles(adminRoles);
//        userRepository.save(admin);
//
//        User user = new User();
//        user.setUsername("user");
//        user.setFirstName("User");
//        user.setLastName("User");
//        user.setPassword(passwordEncoder.encode("user"));
//        user.setRoles(userRoles);
//        userRepository.save(user);
//        alreadySetup = true;
//    }
//
//}