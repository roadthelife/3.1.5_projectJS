//package com.example.demo.service.impls;
//
//import com.example.demo.model.User;
//import com.example.demo.service.interfaces.UpdateUserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//@Service
//@RequiredArgsConstructor
//public class UpdateUserServiceImpl implements UpdateUserService {
//    private final UserServiceImpl userService;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Override
//    public void setPassword(User user, long id) {
//        if (user.getPassword() == null ||
//                user.getPassword().equals("") || user.getPassword().equals(userService.getUserById((long) id).getPassword())) {
//            user.setPassword(userService.getUserById(id).getPassword());
//        } else {
//            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        }
//    }
//}
