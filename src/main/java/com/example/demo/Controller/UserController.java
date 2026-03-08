package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private final UserRepository userRepository;

    // Constructor injection (no Lombok)
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
