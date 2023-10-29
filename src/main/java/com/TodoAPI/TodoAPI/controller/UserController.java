package com.TodoAPI.TodoAPI.controller;

import com.TodoAPI.TodoAPI.entity.User;
import com.TodoAPI.TodoAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUser(@PathVariable Long userId) {
        System.out.println("fds");
        return userService.getUserById(userId);
    }

}
