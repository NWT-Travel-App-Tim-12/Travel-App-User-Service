package com.app.travel.service.user.service;

import com.app.travel.service.user.model.entity.User;
import com.app.travel.service.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User addUser(User user) {
        return userRepository.save(user);
    }


    public User getUser(Integer id) {
        return userRepository.findById(id).get();
    }
}
