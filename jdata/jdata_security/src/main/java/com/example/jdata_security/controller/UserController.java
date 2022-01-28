package com.example.jdata_security.controller;

import com.example.jdata_security.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/username")
    @PreAuthorize("#username == authentication.principal.username")
    public ResponseEntity<Object> getMyData(@RequestParam("username")
                                            @NotBlank(message = "{username.is.blank}") String username) {
        return userService.getMyData(username);
    }

    @GetMapping("/my-data")
    @Secured("ROLE_READ")
    public ResponseEntity<Object> getMyData(Principal principal) {
        final String username = principal.getName();
        return userService.getMyData(username);
    }

    @GetMapping("/all-data")
    @PreAuthorize("hasAnyRole('ROLE_WRITE', 'ROLE_DELETE')")
    public ResponseEntity<Object> getAllData() {
        return userService.getAllData();
    }
}
