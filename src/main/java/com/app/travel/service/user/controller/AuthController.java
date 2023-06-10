package com.app.travel.service.user.controller;


import com.app.travel.service.user.model.dto.AuthRequest;
import com.app.travel.service.user.model.entity.User;
import com.app.travel.service.user.service.AuthService;
import com.app.travel.service.user.service.UserService;
import io.grpc.StatusRuntimeException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService service;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public @ResponseBody ResponseEntity<User> addUser(@RequestBody @Valid User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public String getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return service.generateToken(authRequest.getUsername());
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "unauthenticated", null);
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return "Token is valid";
    }
}