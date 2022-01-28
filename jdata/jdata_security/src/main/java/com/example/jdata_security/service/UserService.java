package com.example.jdata_security.service;

import com.example.jdata_security.model.users.User;
import com.example.jdata_security.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<Object> getMyData(String id) {
        final User user = userRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<Object> getAllData() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
}
