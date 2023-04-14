package com.app.travel.service.user.service;

import com.app.travel.service.user.exceptions.ObjectDoesNotExistInDb;
import com.app.travel.service.user.model.entity.User;
import com.app.travel.service.user.repository.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User addUser(User user) {
        return userRepository.save(user);
    }


    public User getUser(Integer id) {
        var model = userRepository.findById(id);
        if(model.isPresent()) return model.get();
        throw new ObjectDoesNotExistInDb("No data with id " + id + "!", model.getClass().getName());
    }
}
