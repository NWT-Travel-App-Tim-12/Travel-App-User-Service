package com.app.travel.service.user.service;
import com.app.travel.service.user.exceptions.UserAlreadyExistsException;
import com.app.travel.service.user.model.Role;
import com.app.travel.service.user.model.entity.User;
import com.app.travel.service.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public User addUser(User credential) {
        if(userRepository.findByEmail(credential.getEmail()).isPresent()){
            throw new UserAlreadyExistsException("User with email " + credential.getEmail() + " already exists!", HttpStatus.BAD_REQUEST);
        }
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        return userRepository.save(credential);
    }

    public String generateToken(String email, Role role) {
        return jwtService.generateToken(email, role);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }


}