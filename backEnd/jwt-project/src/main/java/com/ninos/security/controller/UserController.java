package com.ninos.security.controller;

import com.ninos.security.entity.User;
import com.ninos.security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@AllArgsConstructor
@RestController
public class UserController {

    private UserService userService;


    @PostConstruct
    public void initRolesAndUser(){
        userService.initRolesAndUser();
    }


    @PostMapping("/registerNewUser")
    public User registerNewUser(@RequestBody User user){
        return userService.registerNewUser(user);
    }

//    @PreAuthorize("hasAnyRole('Admin','User')")  // used for more one role
    @GetMapping("/forAdmin")
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
      return "this URL is only for admin";
    }

    @GetMapping("/forUser")
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "this URL is only for user";
    }



}
