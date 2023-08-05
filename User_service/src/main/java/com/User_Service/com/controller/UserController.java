package com.User_Service.com.controller;

import com.User_Service.com.model.User;
import com.User_Service.com.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/findUserByEmail")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getUserByEmail(@Valid @RequestBody Map<String, String> request) {
        return userService.getUser(request.get("Email"));
    }

    @PostMapping("/newUser")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> registerNewUser(@Valid @RequestBody User userDTO) {
        User user = userService.registerNewUser(userDTO);
        return Map.of("ID", user.getId(),
                "PhoneNumber", user.getPhoneNumber(),
                "Email", user.getEmail(),
                "Address", user.getAddress());
    }


}
