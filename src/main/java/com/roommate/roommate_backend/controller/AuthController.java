package com.roommate.roommate_backend.controller;

import com.roommate.roommate_backend.model.User;
import com.roommate.roommate_backend.repository.UserRepository;
import com.roommate.roommate_backend.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }
    @Autowired
private JwtUtil jwtUtil;

@PostMapping("/login")
public String login(@RequestBody User loginRequest) {
    User existingUser = userRepository.findByEmail(loginRequest.getEmail());

    if (existingUser == null) {
        return "User not found";
    }

    boolean passwordMatches = passwordEncoder.matches(loginRequest.getPassword(), existingUser.getPassword());

    if (!passwordMatches) {
        return "Invalid password";
    }

    return jwtUtil.generateToken(existingUser.getEmail());
}
    }
