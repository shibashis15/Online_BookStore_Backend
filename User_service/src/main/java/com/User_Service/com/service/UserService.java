package com.User_Service.com.service;

import com.User_Service.com.Exceptions.UserAlreadyExistsException;
import com.User_Service.com.Exceptions.UserNotPresent;
import com.User_Service.com.dto.UserDto;
import com.User_Service.com.model.User;
import com.User_Service.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getByID(Long id) {
        return userRepository.getById(id);
    }

    public Map<String, Object> getUser(String email) throws UserNotPresent {
        User user = userRepository.findByEmail(email).get();
        if (user == null) throw new UserNotPresent("User Not Present");
        return Map.of("ID", user.getId(),
                "PhoneNumber", user.getPhoneNumber(),
                "Email", user.getEmail(),
                "Address", user.getAddress());
    }

    public ResponseEntity getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        // Map User entities to UserDto objects
        for (User user : users) {
            UserDto userDto = new UserDto(user.getUsername(), user.getEmail(), user.getPhoneNumber(), user.getAddress());
            userDtos.add(userDto);
        }

        return ResponseEntity.ok(userDtos);
    }

    public User registerNewUser(User userDto) {
        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistsException("account with that email already exists");
        }

        User user = new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));


        return userRepository.save(user);
    }

    private boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
