package com.bank.controller;

import com.bank.dto.ProfileDto;
import com.bank.entity.UserInfo;
import com.bank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService usersService;

    @PostMapping("/register")
    public String register(@RequestBody UserInfo user){
        return usersService.register(user);
    }

    @GetMapping("/view-profile")
    public ProfileDto viewProfile() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return usersService.viewProfile(name);
    }

}
