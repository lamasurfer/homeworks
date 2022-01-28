package com.example.rest.controller;

import com.example.rest.model.Authorities;
import com.example.rest.model.User;
import com.example.rest.resolver.ResolveUser;
import com.example.rest.service.AuthorizationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid @ResolveUser User user) {
        return service.getAuthorities(user);
    }
}
