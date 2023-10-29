package com.TodoAPI.TodoAPI.service;

import com.TodoAPI.TodoAPI.entity.User;
import com.TodoAPI.TodoAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public ResponseEntity<Object> getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found with id: " + userId, HttpStatus.NOT_FOUND);
        }
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
